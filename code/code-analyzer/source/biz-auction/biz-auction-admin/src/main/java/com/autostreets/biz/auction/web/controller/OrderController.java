package com.autostreets.biz.auction.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.constants.SmsTemplateConstants;
import com.autostreets.biz.auction.exception.GenericEntityException;
import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderStatusLog;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.auction.service.OrderStatusLogService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.sms.service.SyncSmsService;
import com.autostreets.biz.sms.utils.IPUtils;
import com.autostreets.biz.sys.model.user.User;
import com.autostreets.biz.sys.service.user.UserService;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.workflow.exception.WorkflowException;
import com.autostreets.biz.wtms.dto.VehicleInventory;
import com.autostreets.biz.wtms.service.WmsService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.utils.RequestUtils;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.model.Member;
import com.autostreets.model.Voucher;
import com.autostreets.service.MemberService;
import com.autostreets.service.VoucherReleaseService;
import com.autostreets.service.VoucherService;
import com.autostreets.service.VoucherUsedLogService;

/**
 * 
 * @author wwy
 * @date 2015年8月25日下午4:34:31
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private WmsService wmsService;

    @Autowired
    private SyncSmsService syncSmsService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private VoucherReleaseService voucherReleaseService;

    @Autowired
    private VoucherUsedLogService voucherUsedLogService;

    @Autowired
    private OrderStatusLogService orderStatusLogService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @RequiresPermissions("auction:order:index")
    @RequestMapping(value = "/index")
    public String doToIndex(Pagination pagination, OrderItem orderItem, Model model) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
        List<AuctionDictionary> collections = auctionDictionaryService.selectResource("collection_party");
        List<AuctionDictionary> collectionModels = auctionDictionaryService.selectResource("collection_model");
        collections.addAll(collectionModels);
        pagination = orderItemService.queryOrders(pagination, orderItem);
        model.addAttribute("pagination", pagination);
        model.addAttribute("collections", collections);
        return "order/index";
    }

    /**
     * 取消订单
     * 
     * @param orderNo
     *            订单编号
     * @return
     */
    @RequiresPermissions("auction:order:cancel")
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult cancelOrder(String orderNo) {
        try {
            orderService.cancelOrder(orderNo, getUser().getId(), null, 1);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new JsonResult(false, "取消失败!");
        }
        return new JsonResult(true, "取消成功");
    }

    /**
     * 线下支付
     * 
     * @param orderNo
     *            订单编号
     * @return
     */
    @RequiresPermissions("auction:order:offlinePay")
    @RequestMapping(value = "/offlinePay", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult offlinePayOrder(Integer orderId, Order order, String remark, String[] voucherCodes,
            HttpServletRequest request) {
        try {
            OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
            if (!orderItem.getStatus().equals(0)) {
                return new JsonResult(false, "操作失败!此订单非待支付状态!");
            }
            orderService.changeOrderStatus(orderId, getUser().getId(), (short) 1, (short) 5, remark, order);
            BigDecimal sumVoucherPrice = new BigDecimal(0);
            if (voucherCodes != null) {
                sumVoucherPrice = voucherService.useVoucher(voucherCodes, orderItem.getAuctionVehicleId(), orderId,
                        order.getBuyerCellphone(), IPUtils.ipToInt(request.getRemoteAddr()));
            }
            if (sumVoucherPrice == null) {
                throw new Exception("优惠券使用失败!");
            }
            orderItem = orderItemService.selectOrderItemByOrderId(orderId);
            BigDecimal bigDecimal = new BigDecimal(0);
            bigDecimal = bigDecimal.add(orderItem.getFinalPrice());
            bigDecimal = bigDecimal
                    .add(orderItem.getExWarehouseFee() == null ? new BigDecimal(0) : orderItem.getExWarehouseFee());
            bigDecimal = bigDecimal
                    .add(orderItem.getLicenseFee() == null ? new BigDecimal(0) : orderItem.getLicenseFee());
            bigDecimal = bigDecimal.add(
                    orderItem.getBuyerCommissionFee() == null ? new BigDecimal(0) : orderItem.getBuyerCommissionFee());
            bigDecimal = bigDecimal.subtract(sumVoucherPrice);
            if (bigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                orderItem.setSettlePrice(BigDecimal.ZERO);
            } else {
                orderItem.setSettlePrice(bigDecimal);
            }
            orderItem.setDiscountPrice(sumVoucherPrice);
            orderItemService.updateByPrimaryKey(orderItem);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            try {
                orderService.changeOrderStatus(orderId, getUser().getId(), (short) 1, (short) 0, "操作失败回滚",
                        order.getBuyerCellphone(), order.getBidderName(), order.getItem().getCollectionParty(),
                        order.getItem().getCollectionModel());
            } catch (Exception e1) {
                LOGGER.error(e1.getMessage(), e1);
            }
            return new JsonResult(false, "操作失败!");
        }
        return new JsonResult(true, "操作成功");
    }

    /**
     * 线下支付
     * 
     * @param orderNo
     *            订单编号
     * @return
     */
    @RequiresPermissions("auction:order:batchOfflinePay")
    @RequestMapping(value = "/batchOfflinePay", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult batchOfflinePay(String orderIds, Order order, String remark) {
        try {
            String[] ids = orderIds.split(",");
            for (String id : ids) {
                Integer orderId = Integer.valueOf(id);
                orderService.changeOrderStatus(orderId, getUser().getId(), (short) 1, (short) 5, remark, null,
                        order.getBidderName(), order.getItem().getCollectionParty(),
                        order.getItem().getCollectionModel());
                OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
                BigDecimal bigDecimal = new BigDecimal(0);
                bigDecimal = bigDecimal.add(orderItem.getFinalPrice());
                bigDecimal = bigDecimal
                        .add(orderItem.getExWarehouseFee() == null ? new BigDecimal(0) : orderItem.getExWarehouseFee());
                bigDecimal = bigDecimal
                        .add(orderItem.getLicenseFee() == null ? new BigDecimal(0) : orderItem.getLicenseFee());
                bigDecimal = bigDecimal.add(orderItem.getBuyerCommissionFee() == null ? new BigDecimal(0)
                        : orderItem.getBuyerCommissionFee());
                orderItem.setSettlePrice(bigDecimal);// 结算价格
                orderItemService.updateByPrimaryKey(orderItem);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new JsonResult(false, "操作失败!");
        }
        return new JsonResult(true, "操作成功");
    }

    /**
     * 加载线下支付页面
     * 
     * @param orderNo
     *            订单编号
     * @return
     */
    @RequestMapping(value = "/loadOfflinePay", method = RequestMethod.POST)
    public String loadOfflinePay(Integer orderId, Model model) {
        Order order = orderService.selectByPrimaryKey(orderId);
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
        Vehicle vehicle = null;
        if (orderItem.getVehicleId() != null) {
            vehicle = vehicleService.selectByPrimaryKey(orderItem.getVehicleId());
        }
        Member member = null;
        if (order.getBidderSid() != null && !order.getBidderSid().equals("000")) {
            member = memberService.selectByPrimaryKey(order.getBidderSid());
            Voucher voucher = new Voucher();
            voucher.setMemberSid(order.getBidderSid());
            voucher.setStatus(0);
            List<Voucher> voucherList = voucherService.selectMemberVoucherList(voucher);
            model.addAttribute("voucherList", voucherList);
        }
        model.addAttribute("order", order);
        model.addAttribute("orderItem", orderItem);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("member", member);
        return "order/offlinePay";
    }

    /**
     * 加载线下支付页面
     * 
     * @param orderNo
     *            订单编号
     * @return
     */
    @RequiresPermissions("auction:order:batchOfflinePay")
    @RequestMapping(value = "/loadBatchOfflinePay", method = RequestMethod.POST)
    public String loadBatchOfflinePay(String orderIds, Model model) {
        String[] ids = orderIds.split(",");
        List<Order> orders = new ArrayList<Order>();
        for (String id : ids) {
            Integer orderId = Integer.valueOf(id);
            Order order = orderService.selectByPrimaryKey(orderId);
            OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
            Vehicle vehicle = null;
            if (orderItem != null && orderItem.getVehicleId() != null) {
                AuctionVehicle auctionVehicle = auctionVehicleService
                        .selectByPrimaryKey(orderItem.getAuctionVehicleId());
                orderItem.setAuctionVehicle(auctionVehicle);
                vehicle = vehicleService.selectByPrimaryKey(orderItem.getVehicleId());
            }
            order.setVehicle(vehicle);
            order.setItem(orderItem);
            orders.add(order);
        }
        model.addAttribute("orderIds", orderIds);
        model.addAttribute("orders", orders);
        return "order/batchOfflinePay";
    }

    /**
     * 加载线下支付页面
     * 
     * @param cellPhone
     *            会员手机号
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loadOfflinePayMember", method = RequestMethod.GET)
    public JsonResult loadOfflinePayMember(String cellPhone, Model model) {
        if (StringUtils.isNotBlank(cellPhone)) {
            boolean bool = memberService.checkMemberByCellphone(cellPhone);
            if (bool) {
                Member temp = new Member();
                temp.setCellphone(cellPhone);
                List<Member> members = memberService.selectByExample(temp);// .queryMember(cellPhone);
                if (members != null && members.size() > 0) {
                    Member member = members.get(0);
                    Voucher voucher = new Voucher();
                    voucher.setMemberSid(member.getSid());
                    voucher.setStatus(0);
                    List<Voucher> voucherList = voucherService.selectMemberVoucherList(voucher);
                    member.setVouchers(voucherList);
                    return new JsonResult(true, member);
                } else {
                    return new JsonResult(true, null);
                }
            } else {
                return new JsonResult(true, null);
            }
        } else {
            return new JsonResult(false, "缺少手机号参数");
        }
    }

    /**
     * 订单成交
     * 
     * @param orderNo
     *            订单编号
     * @return
     */
    @RequestMapping(value = "/deal", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult dealOrder(String orderNo) {
        try {
            orderService.dealOrder(orderNo, String.valueOf(getUser().getId()));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new JsonResult(false, e.getMessage());
        }
        return new JsonResult(true, "成交成功");
    }

    /**
     * 二手车展厅订单
     * 
     * @param pagination
     * @param order
     * @param model
     * @return
     */
    @RequiresPermissions("auct:fporder:index")
    @RequestMapping(value = "/showroomorder")
    public String fixPriceOrder(Pagination pagination, Order order, Model model) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
        pagination = orderService.queryFixedPriceOrders(order, pagination);
        model.addAttribute("pagination", pagination);
        return "order/showroomorder";
    }

    @RequiresPermissions("auct:order_review:index")
    @RequestMapping(value = "/order_review")
    public String finance_review(Pagination pagination, Order order, Model model) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
        if (order == null) {
            order = new Order();
        }
        order.setIsReviewOrder(1);
        pagination = orderService.queryFixedPriceOrders(order, pagination);
        model.addAttribute("pagination", pagination);
        return "order/order-finance_review";
    }

    /**
     * 退款
     * 
     * @param orderNo
     *            订单编号
     * @return
     */
    @RequestMapping(value = "/refundDeposit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult refundDeposit(String orderNo, HttpServletRequest request) {
        try {
            orderService.refundDeposit(orderNo, getUser().getId(), 1);
            Order order = orderService.selectOrderByOrderNo(orderNo);
            OrderItem item = orderItemService.selectOrderItemByOrderId(order.getId());
            Map<String, String> model = new HashMap<String, String>();
            model.put("customerName", order.getBidderName());
            model.put("price", item.getPrePrice().toString());
            syncSmsService.sendSms(order.getBuyerCellphone(), SmsTemplateConstants.SMS_REFUND_DEPOSIT,
                    IPUtils.ipToInt(RequestUtils.getClientIp(request)), model);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new JsonResult(false, "退订失败");
        }
        return new JsonResult(true, "退订成功");
    }

    /**
     * 订单审核
     * 
     * @param orderNo
     *            订单编号
     * @return
     */
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult orderReview(String orderNo) {
        try {
            orderService.orderReview(orderNo, getUser().getId());
        } catch (GenericEntityException e) {
            LOGGER.error(e.getMessage());
            return new JsonResult(false, e.getMessage());
        }
        return new JsonResult(true, "审核完成");
    }

    /**
     * 订单状态跟踪
     * 
     * @param orderNo
     *            订单编号
     * @return
     */
    @RequestMapping(value = "/trackOrderStatus", method = RequestMethod.POST)
    public String trackOrderStatus(String orderNo, Model model) {
        try {
            List<OrderStatusLog> logs = orderService.trackOrderStatus(orderNo);
            model.addAttribute("logs", logs);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return "order/trackOrderStatusLog";
    }

    /**
     * 
     * 功能描述: <br>
     * 〈出库获取车辆 代码来自原autostreets〉
     * 
     * @author jingzhou.zhao
     * @param orderId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/getVehicle", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getVehicle(Integer orderId) {
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
        if (null == orderItem || null == orderItem.getVehicleId()) {
            return new JsonResult(false, "该订单不存在");
        }
        VehicleInfo vehicleInfo = vehicleService.selectVehicleInfoById(orderItem.getVehicleId());
        if (null == vehicleInfo) {
            return new JsonResult(false, "该车辆不存在");
        }
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(vehicleInfo, vehicle);

        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(orderItem.getAuctionVehicleId());
        if (null != auctionVehicle) {
            vehicle.setAvStatus(auctionVehicle.getStatus());
        }
        try {
            List<String> vinList = new ArrayList<String>();
            vinList.add(vehicle.getVinCode());
            List<VehicleInventory> vehicleInventoryList = wmsService.queryVehicleInventory(vinList);
            if (null != vehicleInventoryList && !vehicleInventoryList.isEmpty()) {
                vehicle.setInGarageTimestamp(vehicleInventoryList.get(0).getStorageTime());
            }
            if (StringUtils.isNotBlank(vehicle.getBrand()) && StringUtils.isNotBlank(vehicle.getBrandSeries())
                    && StringUtils.isNotBlank(vehicle.getVehicleModel())) {
                vehicle.setSelledName(
                        vehicle.getBrand() + " " + vehicle.getVehicleModel() + " " + vehicle.getSelledName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("仓储物流接口调用失败:{}", e.getMessage());
        }
        return new JsonResult(true, vehicle);
    }

    /**
     * 订单中心车辆出库
     * 
     * @param orderNo
     *            订单编号
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/stockRemoval", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult stockRemoval(Integer orderId, Integer avStatus, String deposit, String stockRemovalType,
            String takeCarWay) throws IOException {

        Order order = orderService.selectByPrimaryKey(orderId);
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
        boolean falg = false;
        VehicleInfo vehicle = vehicleService.selectVehicleInfoById(orderItem.getVehicleId());

        if (null == orderItem || null == orderItem.getVehicleId()) {
            return new JsonResult(false, "该订单不存在");
        }
        if (null == vehicle) {
            return new JsonResult(false, "该车辆不存在");
        }
        AuctionVehicle av = auctionVehicleService.selectByPrimaryKey(orderItem.getAuctionVehicleId());
        Auction auction = null;
        String orgAddr = "";
        if (av != null && av.getAuctionId() != null) {
            auction = auctionService.selectByPrimaryKey(av.getAuctionId());
        }
        if (null != auction && StringUtils.isNotBlank(auction.getAddress())) {
            orgAddr = auction.getAddress();
        }
        try {
            falg = auctionVehicleService.stockRemovalApply(order.getOrderNo(), vehicle.getCode(), orgAddr,
                    getUser().getId().toString(), getUser().getName(), stockRemovalType, deposit, takeCarWay,
                    getUser().getCellPhone());
        } catch (WorkflowException e) {
            LOGGER.error("拍卖成交订单orderNo=" + order.getOrderNo() + "出库申请调用审批流接口失败", e);
            if (e instanceof WorkflowException) {
                return new JsonResult(false, e.getMessage());
            }
            return new JsonResult(false, "系统异常,请联系管理员");
        }
        String msg = "出库申请失败,该车在工作流中已经有申请了";
        if (falg) {
            msg = "出库申请成功";
        }
        return new JsonResult(falg, msg);
    }

    /**
     * 订单导出Excel
     */
    @RequiresPermissions(value = {"auct:order:exportOrder"})
    @RequestMapping(value = "/exportOrder", method = {RequestMethod.GET, RequestMethod.POST})
    public void exportOrder(String[] exportCol, HttpServletResponse response, OrderItem orderItem) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
        int count = orderItemService.queryOrderCount(orderItem);
        if (count == 0) {
            response.setContentType("text/plain; charset=utf-8");
            try {
                response.getWriter().write("<font color='red'>无数据!</font>");
            } catch (IOException e) {
            }
            return;
        }
        Map<Integer, String> orderStatusMap = new HashMap<>();
        orderStatusMap.put(0, "已创建");
        orderStatusMap.put(1, "订单取消");
        orderStatusMap.put(2, "用户取消");
        orderStatusMap.put(3, "超时未支付取消");
        orderStatusMap.put(4, "已支付订金");
        orderStatusMap.put(5, "待收款确认");
        orderStatusMap.put(6, "已退定金");
        orderStatusMap.put(7, "已退款");
        orderStatusMap.put(8, "已结算");
        orderStatusMap.put(9, "协商退款");
        orderStatusMap.put(10, "退款失败");
        orderStatusMap.put(11, "已收款");
        orderStatusMap.put(12, "支付确认");
        Map<Integer, String> saleTypeMap = new HashMap<>();
        saleTypeMap.put(1, "同步拍");
        saleTypeMap.put(2, "在线拍");
        saleTypeMap.put(3, "即时拍");
        List<OrderItem> data = orderItemService.queryOrders(orderItem);
        Map<Integer, String> userMap = new HashMap<Integer, String>();
        try {
            for (OrderItem item : data) {
                if (item.getVehicle() == null) {
                    item.setVehicle(new Vehicle());
                } else {
                    item.getVehicle()
                            .setVehicleModel(item.getVehicle().getBrand() + " " + item.getVehicle().getVehicleModel());// 品牌型号
                }
                BigDecimal bigDecimal = new BigDecimal(0);
                bigDecimal = bigDecimal.add(item.getFinalPrice());
                bigDecimal = bigDecimal
                        .add(item.getExWarehouseFee() == null ? new BigDecimal(0) : item.getExWarehouseFee());
                bigDecimal = bigDecimal.add(item.getLicenseFee() == null ? new BigDecimal(0) : item.getLicenseFee());
                bigDecimal = bigDecimal
                        .add(item.getBuyerCommissionFee() == null ? new BigDecimal(0) : item.getBuyerCommissionFee());
                item.setDealPrice(bigDecimal);// 成交总价
                item.setStatusDesc(orderStatusMap.get(item.getStatus()));// 状态描述
                item.setSaleTypeDesc(saleTypeMap.get(item.getSaleType()));// 拍卖类型
                OrderStatusLog orderLog = orderStatusLogService.getOrderLog(item.getOrderId());
                if (orderLog != null) {
                    if (userMap.get(orderLog.getUserId()) == null) {
                        User user = userService.selectByPrimaryKey(orderLog.getUserId());
                        item.setOpUserName(user.getName());
                        userMap.put(user.getId(), user.getName());
                    } else {
                        item.setOpUserName(userMap.get(orderLog.getUserId()));
                    }
                }
            }
            if (!CollectionUtils.isEmpty(data)) {
                exportExcelUtil.exportExcel(Arrays.asList(exportCol), data, response, "订单管理", "2007");
            } else {
                try {
                    response.getWriter().write("<font color='red'>no data!</font>");
                } catch (IOException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        } catch (Exception e1) {
            LOGGER.error(e1.getMessage(), e1);
        }
    }
}
