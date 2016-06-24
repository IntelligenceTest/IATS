package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.constants.OrderConstans;
import com.autostreets.biz.auction.constants.SmsTemplateConstants;
import com.autostreets.biz.auction.constants.UsedCarConstants;
import com.autostreets.biz.auction.enums.BusinessIdRuleEnum;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.HomepageRecommend;
import com.autostreets.biz.auction.model.HomepageRecommendExample;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderStatusLog;
import com.autostreets.biz.auction.model.UsedCarLog;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.HomepageRecommendService;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.auction.service.OrderStatusLogService;
import com.autostreets.biz.auction.service.UsedCarLogService;
import com.autostreets.biz.sms.service.SyncSmsService;
import com.autostreets.biz.sms.utils.IPUtils;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.biz.usedvehicle.enums.RequirementTypeEnum;
import com.autostreets.biz.usedvehicle.enums.SaleStatusEnum;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.usedvehicle.service.vehicle.UsedvehicleOperatorService;
import com.autostreets.biz.usedvehicle.service.vehicle.VehicleService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.utils.RequestUtils;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.model.FpNewcarRelate;
import com.autostreets.model.FpNewcarRelateExample;
import com.autostreets.model.NewVehicleDetailParameters;
import com.autostreets.model.RepModel;
import com.autostreets.model.RepSeries;
import com.autostreets.service.BusinessRuleService;
import com.autostreets.service.FpNewcarRelateService;
import com.autostreets.service.NewVehicleDetailParametersService;
import com.autostreets.service.RepModelService;
import com.autostreets.service.RepSeriesService;
import com.autostreets.service.ReplacementService;

/**
 * （网上展厅）
 * 
 * @author youpeng.zhang Date: 2015年8月26日 下午1:34:30
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/fixedPrice")
public class FixedPriceController extends BaseController {

    @Autowired
    private FixedPriceService fixedPriceService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private com.autostreets.biz.auction.service.VehicleService auctVehicleService;

    @Autowired
    private UsedCarLogService usedCarLogService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderStatusLogService orderStatusLogService;

    @Autowired
    private BusinessRuleService businessRuleService;

    @Autowired
    private UsedvehicleOperatorService usedvehicleOperatorService;

    @Autowired
    private SyncSmsService syncSmsService;

    @Autowired
    private RepModelService repModelService;

    @Autowired
    private RepSeriesService repSeriesService;

    @Autowired
    private ReplacementService replacementService;

    @Autowired
    private NewVehicleDetailParametersService newVehicleDetailParametersService;

    @Autowired
    private FpNewcarRelateService fpNewcarRelateService;

    @Autowired
    private AuctionDictionaryService dictionaryService;

    @Autowired
    private HomepageRecommendService homepageRecommendService;

    @RequiresPermissions("auct:fp:index")
    @RequestMapping(value = "/index")
    public String doToIndex(Pagination pagination, FixedPrice fixedPrice, Model model) {
        LOGGER.info("*******************进入网上展厅首页********************");
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;

        Integer status = fixedPrice.getStatus();
        if (null == status) {
            fixedPrice.setStatus(99);
        }

        pagination = fixedPriceService.queryFixedPrices(pagination, fixedPrice);
        model.addAttribute("pagination", pagination);
        return "fixedPrice/index";
    }

    /**
     * 批量上架展品
     * 
     * @return JsonResult
     * @author youpeng.zhang Date: 2015年8月26日 下午5:28:33
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/onsell-confirm", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult doConfirmOnSell(@RequestParam(value = "allId", required = true) String allIds) {
        LOGGER.info("*******************进入展品【上架】流程********************");
        boolean success = false;
        String msg = "非法请求！";
        if (StringUtils.isBlank(allIds)) {
            return new JsonResult(success, msg);
        }

        String[] allId = allIds.split("\\|\\|");
        if (ArrayUtils.isEmpty(allId)) {
            return new JsonResult(success, msg);
        }

        msg = "上架失败！";
        // 验证展品信息
        FixedPrice fixedPrice = null;// 展品
        // VehicleInfo vehicle = null;// 车辆
        Integer vId = null;// 车辆ID
        StringBuffer errorVehicleInfo = new StringBuffer("\n\r上架失败，展品状态非【上架申请】或车辆销售状态不在【出售中】！\n\r（展品SID|车辆SID）：");
        boolean errorVehicleFlag = false;

        StringBuffer errorDB = new StringBuffer("\n\r数据库操作异常！\n\r（展品SID|车辆SID）：");
        boolean errorDBFlag = false;

        // 订单校验
        StringBuffer errorOrderInfo = new StringBuffer("\n上架失败，部分展品已经生成过订单。\n（展品SID|车辆SID）：");
        boolean errorOrder = false;
        HashMap<String, Object> param = new HashMap<>();
        int orders = 0;

        // 车辆客户需求校验
        boolean isSale;
        boolean errorVehicleCustomer = false;
        StringBuffer errorVehicleCustomerInfo = new StringBuffer("\n上架失败，部分展品客户需求非【出售】，如需上架请到车辆管理中修改。\n（展品SID|车辆SID）：");

        Integer fpId = null;// 展品ID
        FixedPrice fp = null;// 上架展品
        int size = allId.length;
        int count = 0;

        // 操作日志
        UsedCarLog log = null;
        String proc = UsedCarConstants.ACTION_SHELVES_MULTI;

        for (int i = 0; i < size; i++) {
            fpId = Integer.valueOf(allId[i]);
            if (fpId == null) {
                msg += i + "展品ID非法！";
                continue;
            }

            fixedPrice = fixedPriceService.selectByPrimaryKey(fpId);
            if (null == fixedPrice) {
                msg += fpId + "展品已不存在！";
                continue;
            }

            vId = fixedPrice.getVehicleId();
            if (vId == null) {
                msg += i + "展品VSID非法！";
                continue;
            }

            com.autostreets.biz.auction.model.Vehicle auctvehicle = auctVehicleService.selectByPrimaryKey(vId);
            if (null == auctvehicle) {
                msg += vId + "车辆已不存在！";
                continue;
            }

            isSale = isSale(auctvehicle.getRequirementType());
            if (!isSale) {
                errorVehicleCustomerInfo.append(fpId).append("|").append(vId).append("、");
                if (!errorVehicleCustomer)
                    errorVehicleCustomer = true;
                continue;
            }

            if (!isOnSellStatus(fixedPrice, auctvehicle)) {
                errorVehicleInfo.append(fpId).append("|").append(vId).append("、");
                if (!errorVehicleFlag)
                    errorVehicleFlag = true;
                continue;
            }

            param.put("fpSid", fpId);
            param.put("vSid", vId);
            orders = fixedPriceService.queryUsedCarOrderNum(param);
            if (orders > 0) {
                errorOrderInfo.append(fpId).append("|").append(vId).append("、");
                if (!errorOrder)
                    errorOrder = true;
                continue;
            }

            fp = new FixedPrice();
            fp.setId(fpId);
            fp.setStatus(UsedCarConstants.STATUS_SHELVES);// 已上架
            fp.setUpdateUser(getUser().getId());
            fp.setUpdateTime(new Date());
            fp.setSellTime(new Date());
			fp.setOffShelvesTime(setOffShelvesTime(fp.getSellTime()));// 下架时间
            try {
                count += fixedPriceService.updateByPrimaryKeySelective(fp);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                errorDB.append(fpId).append("|").append(vId).append("、");
                if (!errorDBFlag)
                    errorDBFlag = true;
            }

            log = new UsedCarLog();
            log.setVehicleId(vId);
            log.setFixedPriceId(fpId);
            log.setAction(proc);
            log.setPreVehicleSaleStatus(Integer.valueOf(auctvehicle.getSaleStatus()));
            log.setCurrentVehicleSaleStatus(Integer.valueOf(auctvehicle.getSaleStatus()));
            log.setPreLatest(fixedPrice.getLatest());
            log.setCurrentLatest(fixedPrice.getLatest());
            log.setPreUsedCarStatus(fixedPrice.getStatus());
            log.setCurrentUsedCarStatus(UsedCarConstants.STATUS_SHELVES);
            log.setOperater(this.getUser().getUsername());
            log.setOperationTime(new Date());
            log.setRemark(proc);

            try {
                usedCarLogService.insertSelective(log);
            } catch (Exception e) {
                LOGGER.error(proc + "操作日志保存失败！FPSID：" + fpId + "，VSID：" + vId);
            }

        }

        success = true;
        msg = "此次共选择" + size + "个展品，其中" + count + "个展品上架成功！";
        if (errorVehicleFlag)
            msg += errorVehicleInfo.toString();

        if (errorDBFlag)
            msg += errorDB.toString();

        if (errorOrder)
            msg += errorOrderInfo.toString();

        return new JsonResult(success, msg);
    }

    /**
     * 
     * 1.车辆销售状态为出售中 2.展品状态为上架申请 符合以上1-2条件则进行展品上架处理（返回true）
     * 
     * @return boolean
     * @author youpeng.zhang Date: 2015年8月26日 下午5:54:23
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    private boolean isOnSellStatus(FixedPrice fixedPrice, Vehicle vehicle) {
        // 车辆销售状态为出售中
        if (vehicle.getSaleStatus() == null
                || vehicle.getSaleStatus().intValue() != GlobalConstants.SALE_STATUS_ONGOING) {
            return false;
        }
        // 展品状态为上架申请
        if (fixedPrice.getStatus() == null
                || fixedPrice.getStatus().intValue() != UsedCarConstants.STATUS_SHELVES_APPLY)
            return false;
        return true;
    }

    /**
     * @Title: doLoadStore
     * @Description: 获取车辆所属门店及详细地址
     * @param vehicleSid
     * @return JsonResult
     * @throws @author yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月21日 下午5:48:40
     */
    @RequestMapping(value = "load-store", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult doLoadStore(@RequestParam(required = true, value = "vsid") Integer vehicleId) {
        LOGGER.info("*******************【精品二手车】获取车辆所属门店及详细地址********************");
        boolean success = false;
        VehicleInfo v = auctVehicleService.selectVehicleInfoById(vehicleId);
        if (null == v) {
            return new JsonResult(success, "车辆不存在！");
        }

        Integer orgSid = v.getEvalOrgId();
        if (null == orgSid) {
            return new JsonResult(success, "车辆所属评估部门SID为空！");
        }

        Organization org = organizationService.selectByPrimaryKey(orgSid);
        if (null == org)
            return new JsonResult(success, "车辆所属评估部门不存在！");

        String[] data = new String[3];
        data[0] = (StringUtils.isBlank(org.getOrgNameAbbr())) ? org.getOrgName() : org.getOrgNameAbbr();
        data[1] = org.getAddr();
        data[2] = v.getVehicleDesc();
        success = true;

        return new JsonResult(success, data);
    }

    /**
     * @Title: doLoadNonOfflineOrder
     * @Description: 查询展品线上订单
     * @param fpSid
     *            展品sid
     * @param vSid
     *            车辆sid
     * @return HashMap<String,Object>
     * @throws @author yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月27日 上午11:47:11
     */
    @RequestMapping(value = "/load-nonoffline-order", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> doLoadNonOfflineOrder(@RequestParam(value = "sid", required = true) Integer fpSid,
            @RequestParam(value = "vehicleSid", required = true) Integer vSid) {
        HashMap<String, Object> param = new HashMap<>(2);
        param.put("vId", vSid);
        param.put("fpId", fpSid);
        return fixedPriceService.queryNonOffLineOrder(param);
    }

    /**
     * <pre>
     *  V2.0：取消竞拍检验<br>
     *  V3.0：（2014年11月26日 15:03:40）
     *  1.此处成交只处理线下成交，线上成交到订单管理处理
     *  2.增加展品状态校验
     *  3.增加订单状态校验<br>
     *  V4.0：（2014年12月4日 10:54:25）
     *  1.黄春风修改订单后处理线上线下成交逻辑<br>
     * </pre>
     * 
     * @Title: doDeal
     * @Description: 展品（线下）成交
     * @param fixedPrice
     * @return String
     * @throws @author yanqing.luo （roceys#gmail.com）
     * @version V4.0
     * @date 2014年10月15日 下午3:49:44
     */
    @RequestMapping(value = "/deal", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult doDeal(FixedPrice fixedPrice, HttpServletRequest request) {
        LOGGER.info("*******************进入展品【线下成交】操作********************");
        String msg = "非法请求！";
        boolean success = false;

        if (null == fixedPrice)
            return new JsonResult(success, msg);

        Order order = fixedPrice.getOrder();
        if (null == order || StringUtils.isBlank(order.getBidderName()))
            return new JsonResult(success, msg);

        OrderItem orderItem = fixedPrice.getOrderItem();
        if (null == orderItem || null == orderItem.getFinalPrice())
            return new JsonResult(success, msg);

        Integer id = fixedPrice.getId();
        Integer vehicleId = fixedPrice.getVehicleId();
        if (id == null || vehicleId == null)
            return new JsonResult(success, msg);

        Vehicle vehicle = auctVehicleService.selectByPrimaryKey(vehicleId);
        if (null == vehicle)
            return new JsonResult(success, "当前车辆已不存在！");

        boolean isSale = isSale(vehicle.getRequirementType());
        if (!isSale)
            return new JsonResult(success, "当前展品客户需求为非【出售】，如需成交请联系相关业务人员或技术中心！");

        FixedPrice fp = fixedPriceService.selectByPrimaryKey(id);
        if (null == fp)
            return new JsonResult(success, "当前展品已不存在！");

        // 展品状态为非上架申请-0、已下架-1、已出售-2、已支付全款-6可以进行线下成交
        final Integer[] fpStatus = {UsedCarConstants.STATUS_SHELVES_APPLY, UsedCarConstants.STATUS_OFF_SHELVES,
                UsedCarConstants.STATUS_SELL, UsedCarConstants.STATUS_PAY_ALLCASH};
        if (!isDealUsedCarStatus(fp, vehicle.getSaleStatus(), fpStatus))
            return new JsonResult(success, "线下成交失败，当前展品状态异常且车辆非【出售中】！");

        List<FixedPrice> fpLatests = fixedPriceService.queryUsedCarLatest(vehicleId);
        int size = fpLatests.size();
        if (size > 1)
            return new JsonResult(success, "线下成交失败，存在多个最新展品！VSID：" + vehicleId);

        fixedPrice.setUpdateTime(new Date());
        fixedPrice.setUpdateUser(getUser().getId());
        fixedPrice.setStatus(UsedCarConstants.STATUS_PAY_ALLCASH);// 已支付全款

        int count = 0;
        try {
            count += fixedPriceService.updateByPrimaryKeySelective(fixedPrice);
        } catch (Exception e) {
            LOGGER.error("线下成交失败，更新展品数据库操作异常！VSID|FPSID：" + vehicleId + "|" + id);
            throw new RuntimeException(e.getMessage());
        }

        StringBuffer logInfo = new StringBuffer("订单操作日志：");

        // 处理线上预订（未支付、已支付）订单
        HashMap<String, Object> param = new HashMap<>(2);
        param.put("fpId", id);
        param.put("vId", vehicleId);
        final List<OrderItem> orderItems = fixedPriceService.queryUsedCarOrderOnline(param);

        int i = 1;
        OrderItem oi = null;
        Order updateOrder = null;
        Integer orderItemId = null;
        String phoneNum = null;
        Integer orderItemStatus = null;
        Map<String, String> smsParam = null;
        OrderStatusLog orderLog = null;

        String returnCode = null;
        String smsSendStatus = null;
        List<Boolean> isSmsSends = new ArrayList<>();

        for (OrderItem item : orderItems) {
            orderItemId = item.getId();
            orderItemStatus = item.getStatus();
            if (orderItemId == null && null == orderItemStatus && null == item.getOrder()) {
                LOGGER.info("无有效订单！！！");
                continue;
            }

            phoneNum = item.getOrder().getBuyerCellphone();
            // item.getOrder().getBidderSid();

            oi = new OrderItem();
            oi.setId(orderItemId);
            // 如果线上预订订单状态为未支付则更新为后台业务取消，状态为已支付则更新为协商退款
            if (orderItemStatus.compareTo(OrderConstans.ORDER_STATUS_CREATED) == 0) {
                oi.setStatus(OrderConstans.ORDER_STATUS_MANAGE_USER_CANCEL);
            } else if (orderItemStatus.compareTo(OrderConstans.ORDER_STATUS_PAID_DEPOSIT) == 0) {
                oi.setStatus(OrderConstans.ORDER_STATUS_CONSULT_REFUND_DEPOSIT);
            }

            try {
                orderItemService.updateByPrimaryKeySelective(oi);
            } catch (Exception e) {
                LOGGER.error("线下成交失败，处理当前展品线上客户预订订单明细-数据库操作异常！VSID|FPSID|OISID：" + vehicleId + "|" + id + "|"
                        + orderItemId);
                throw new RuntimeException("线下成交时处理线上预订订单明细数据库操作异常！");
            }

            updateOrder = new Order();
            updateOrder.setId(item.getOrderId());
            updateOrder.setUpdateTime(new Date());
            try {
                orderService.updateByPrimaryKeySelective(updateOrder);
            } catch (Exception e) {
                LOGGER.error("线下成交失败，处理当前展品线上客户预订订单-数据库操作异常！VSID|FPSID|OSID：" + vehicleId + "|" + id + "|"
                        + item.getOrderId());
                throw new RuntimeException("线下成交时处理线上预订订单数据库操作异常！");
            }

            // 订单日志保存
            orderLog = new OrderStatusLog();
            orderLog.setMemo(null);
            orderLog.setOrderId(orderItemId);
            orderLog.setPrepStatus(item.getStatus().shortValue());
            orderLog.setPostStatus(oi.getStatus().shortValue());
            orderLog.setUserId(getUser().getId());
            orderLog.setUserType(OrderConstans.USER_TYPE_USER); // 后台用户
            orderLog.setCreateTime(new Date());
            try {
                orderStatusLogService.insert(orderLog);
            } catch (Exception e) {
                LOGGER.error("线下成交失败，生成订单操作日志-数据库操作异常！VSID|FPSID|OSID：" + vehicleId + "|" + id + "|"
                        + item.getOrderId());
                throw new RuntimeException("线下成交失败，生成订单操作日志数据库操作异常！");
            }

            // 短信通知客户
            smsParam = new HashMap<>();
            // smsParam.put("smsTemplate", smsTemplate);
            smsParam.put("customer", item.getOrder().getBidderName());
            smsParam.put("vehicleModel", vehicle.getBrand() + vehicle.getVehicleModel() + vehicle.getSelledName());
            // smsParam.put("vehiclePrice",fp.getPrice()); //
            // //与刘潇讨论过短信长度问题后，取消此属性
            // smsParam.put("signature", GlobalConstants.SMS_SIGNATURE);
            returnCode = syncSmsService.sendSms(phoneNum, SmsTemplateConstants.SMS_OFFLINE_DEAL,
                    IPUtils.ipToInt(RequestUtils.getClientIp(request)), smsParam);
            smsSendStatus = super.formatSmsReturnCode(returnCode);

            logInfo.append("(" + i + ")线上客户预订订单明细（SID：" + orderItemId + "、预订人电话：" + phoneNum + "、预订人SID："
                    + item.getOrder().getBidderSid() + "），");
            logInfo.append("处理前订单明细【状态-" + orderItemStatus + "】，处理后订单明细【状态-" + oi.getStatus() + "】，其它属性不变。");
            logInfo.append("$线上客户预订取消订单短信发送状态：" + smsSendStatus);

            isSmsSends.add((StringUtils.isNotBlank(returnCode) && smsSendSuccess(returnCode)));
            i++;
        }

        String smsTipsMsg = null;
        if (!CollectionUtils.isEmpty(isSmsSends)) {
            smsTipsMsg = "\n取消线上预订订单，提醒短信发送";
            if (isSmsSends.contains(false)) {
                smsTipsMsg += "失败！";
            } else {
                smsTipsMsg += "成功！";
            }
        }

        // 订单号
        String orderCode = businessRuleService.getBusinessIdByType(BusinessIdRuleEnum.OV_FIXED.getCode());
        order.setOrderNo(orderCode);
        order.setDealTimestamp(new Date());
        order.setPayTimestamp(new Date());
        order.setSource(OrderConstans.ORDER_SOURCE_OFFLINE);// 订单来源：1-Web线上 2-线下
                                                            // 3-Android 4-IOS
                                                            // 5-iPad 6-其他渠道
        order.setBidderSid("000");// 线下成交
        order.setCreatedTime(new Date());

        try {
            Order result = orderService.insertSelective(order);
            if (null != result)
                count++;
        } catch (Exception e) {
            LOGGER.error("线下成交失败，生成订单数据库操作异常！VSID|FPSID：" + vehicleId + "|" + id);
            throw new RuntimeException(e.getMessage());
        }

        logInfo.append("生成线下客户订单成功（CODE：" + orderCode + "）。");
        BigDecimal finalPrice = orderItem.getFinalPrice();
        orderItem.setFinalPrice(finalPrice.multiply(BigDecimal.valueOf(10000)));// 成交价
        // orderItem.setSource(Short.valueOf("2"));// 订单来源：1-Web线上 2-线下
        // 3-Android 4-IOS 5-iPad 6-其他渠道
        orderItem.setEnabled(Boolean.TRUE);// 有效标志：1-有效 0-无效
        orderItem.setStatus(5);// 订单子项状态：0-已创建(未支付),1-后台业务取消,2-用户取消,3-超时未支付取消,4-已支付订金,5-已支付全款,6-已退订金,7-已退全款,8-交易成功
        orderItem.setFinAudit(0);// 财务审核状态：0-未审核, 1-已审核
        order = orderService.selectOrderByOrderNo(orderCode);
        orderItem.setOrderId(order.getId());
        orderItem.setAuctionVehicleId(id);
        orderItem.setVehicleId(vehicleId);
        orderItem.setSaleType(0);// 一口价
        orderItem.setPrePrice(fixedPrice.getDeposit());
        orderItem.setCreatedTimestamp(new Date());

        try {
            OrderItem result = orderItemService.insertSelective(orderItem);
            if (null != result)
                count++;
        } catch (Exception e) {
            LOGGER.error("线下成交失败，生成订单明细数据库操作异常！VSID|FPSID：" + vehicleId + "|" + id);
            throw new RuntimeException(e.getMessage());
        }

        // logInfo.append("生成线下客户订单明细成功（ORDER-CODE：" + orderCode + "）、（明细SID：" +
        // uuid + "）。");
        logInfo.append("生成线下客户订单明细成功（ORDER-CODE：" + orderCode + "）");

        try {
            // 更新车辆销售状态为已出售
            // fixedPriceService.updateVehicleSaleStatusEQS(vehicleId, "2",
            // null);
            auctVehicleService.updateSaleStatus(vehicleId, SaleStatusEnum.SALE_STATUS_DONE);
        } catch (Exception e) {
            LOGGER.error("线下成交失败，更新车辆销售状态数据库操作异常！VSID|FPSID：" + vehicleId + "|" + id);
            throw new RuntimeException(e.getMessage());
        }

        // 操作日志
        UsedCarLog log = new UsedCarLog();
        String proc = UsedCarConstants.ACTION_DEAL_OFFLINE;
        log.setVehicleId(vehicleId);
        log.setFixedPriceId(id);
        log.setAction(proc);
        log.setPreVehicleSaleStatus(Integer.valueOf(vehicle.getSaleStatus()));
        log.setCurrentVehicleSaleStatus(2);
        log.setPreLatest(fp.getLatest());
        log.setCurrentLatest(fp.getLatest());
        log.setPreUsedCarStatus(fp.getStatus());
        log.setCurrentUsedCarStatus(fixedPrice.getStatus());
        log.setOperater(getUser().getUsername());
        log.setOperationTime(new Date());
        log.setRemark(logInfo.toString());

        try {
            usedCarLogService.insertSelective(log);
        } catch (Exception e) {
            String error = proc + "操作日志保存失败！";
            LOGGER.error(error);
            msg += "\n" + error;
        }

        if (count == 3) {
            msg = "线下成交完成！";
            success = true;
        }

        if (null != smsTipsMsg)
            msg += smsTipsMsg;

        return new JsonResult(success, msg);
    }

    /**
     * @Title: isDealUsedCarStatus
     * @Description: 成交展品状态、车辆销售状态校验
     * @param fixedPrice
     * @param vehicle
     * @param fpStatus
     * @return boolean
     * @throws @author yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年11月26日 下午4:28:27
     */
    private boolean isDealUsedCarStatus(FixedPrice fixedPrice, Short saleStatus, Integer[] fpStatus) {
        // 车辆销售状态为出售中
        if (fixedPrice.getStatus() == null || saleStatus == null || saleStatus != GlobalConstants.SALE_STATUS_ONGOING)
            return false;
        return !Arrays.asList(fpStatus).contains(fixedPrice.getStatus());
    }

    @RequestMapping("onAuditFailure")
    @ResponseBody
    public JsonResult onAuditFailure(FixedPrice fixedPrice, String memo) {
        // 更新一口价表
        fixedPrice.setStatus(7);
        int count = fixedPriceService.updateByPrimaryKeySelective(fixedPrice);
        fixedPrice = fixedPriceService.selectByPrimaryKey(fixedPrice.getId());
        // 调用EQS接口修改车辆状态
        try {
            auctVehicleService.updateSaleStatus(fixedPrice.getVehicleId(), SaleStatusEnum.SALE_STATUS_WAIT);
        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
        }
        // 插入车辆上架失败日志表
        UsedCarLog usedCarLog = new UsedCarLog();
        usedCarLog.setOperater(getUser().getUsername());
        usedCarLog.setVehicleId(fixedPrice.getVehicleId());
        usedCarLog.setPreUsedCarStatus(0);
        usedCarLog.setFixedPriceId(fixedPrice.getId());
        usedCarLog.setCurrentUsedCarStatus(7);
        usedCarLog.setRemark(memo);
        usedCarLog.setAction("上架失败");
        usedCarLog.setOperationTime(new Date());
        usedCarLogService.insert(usedCarLog);

        JsonResult result = new JsonResult(true);
        if (count > 0) {
            result.setMsg("上架申请驳回成功");
        } else {
            result.setMsg("系统异常请稍后再试");
        }
        return result;
    }

    // add by zxf
    @RequestMapping(value = "/selectForAuctionAllSeries", method = RequestMethod.GET)
    @ResponseBody
    public List<RepSeries> selectForAuctionAllSeries(String automaker) {
        if (StringUtils.isBlank(automaker)) {
            return null;
        }
        return repSeriesService.selectSeriesForAuctionByAutomaker(automaker);
    }

    @RequestMapping(value = "/selectMdYears", method = RequestMethod.GET)
    @ResponseBody
    public List<String> selectMdYears(String automaker, String series) {
        if (StringUtils.isEmpty(automaker) || StringUtils.isBlank(series)) {
            return null;
        }
        RepSeries repser = new RepSeries();
        repser.setAutomaker(automaker);
        repser.setSeries(series);
        return replacementService.selectMdYears(repser);
    }

    @RequestMapping(value = "/selectRepModelByMdYear", method = RequestMethod.GET)
    @ResponseBody
    public List<RepModel> selectRepModelByMdYear(String automaker, String series, String carYear) {
        if (StringUtils.isEmpty(automaker) || StringUtils.isBlank(series) || StringUtils.isBlank(carYear)) {
            return null;
        }
        RepModel repModel = new RepModel();
        repModel.setAutomaker(automaker);
        repModel.setSeries(series);
        repModel.setMdYear(carYear);
        return replacementService.selectRepModelByMdYear(repModel);
    }

    @RequestMapping(value = "/selectDetailParametersByRepModel", method = RequestMethod.GET)
    @ResponseBody
    public NewVehicleDetailParameters selectDetailParametersByRepModel(Integer repModelSid) {
        if (null == repModelSid) {
            return null;
        }
        RepModel repModel = repModelService.selectByPrimaryKey(repModelSid);
        if (null == repModel) {
            return null;
        }
        return newVehicleDetailParametersService.selectDetailParametersByRepModel(repModel);
    }

    /**
     * 
     * @Title: doSave
     * @Description: 一口价展品上架申请、编辑
     * @param fixedPrice
     * @param flag
     *            判断是否直接上架
     * @return JsonResult
     * @throws @author yanqing.luo （roceys#gmail.com）
     * @version V4.0
     * @date 2014年8月26日 下午2:27:25
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doSave(FixedPrice fixedPrice, FpNewcarRelate fpNewcarRelate, Boolean flag) {
        if (null == fixedPrice)
            throw new RuntimeException("系统异常！！！");

        String msg = null;
        boolean success = false;
        // 批量设置
        boolean isSale = true;
        // 购置税计算
        BigDecimal taxBuy = null;
        BigDecimal priceNewcar = null == fixedPrice.getVehicle() ? null : fixedPrice.getVehicle()
                .getNewVehicleSuggestionPrice();
        // 新车指导价直接存在fixedPrice中
        fixedPrice.setNewVehicleSuggestionPrice(priceNewcar);
        if (null != priceNewcar) {
            priceNewcar = priceNewcar.multiply(BigDecimal.valueOf(10000));

            if (null != fixedPrice.getHasTaxBuy() && fixedPrice.getHasTaxBuy()) {
                List<AuctionDictionary> dics = dictionaryService.selectResource("setting_taxbuy");
                if (CollectionUtils.isEmpty(dics) || null == dics.get(0).getValue()) {
                    taxBuy = BigDecimal.ZERO;
                } else {
                    taxBuy = priceNewcar.divide(BigDecimal.valueOf(Double.parseDouble(dics.get(0).getValue())), 2,
                            BigDecimal.ROUND_HALF_UP);
                    taxBuy = taxBuy.divide(BigDecimal.valueOf(10000d), 2, BigDecimal.ROUND_HALF_UP).multiply(
                            BigDecimal.valueOf(10000l));
                }
            }
        } else {
            priceNewcar = BigDecimal.ZERO;
        }

        if (null == fixedPrice.getHasTaxBuy() || !fixedPrice.getHasTaxBuy())
            taxBuy = BigDecimal.ZERO;

        BigDecimal lpg = fixedPrice.getLowPriceGroup();

        if (null == lpg) {
            fixedPrice.setLowPriceGroup(BigDecimal.ZERO);
        } else {
            fixedPrice.setLowPriceGroup(lpg.multiply(BigDecimal.valueOf(10000)));
        }

        UsedCarLog log = new UsedCarLog();
        if (null == fixedPrice.getId()) {
            String proc = UsedCarConstants.ACTION_APPLY_SHELVES;
            if (flag)
                proc = UsedCarConstants.ACTION_SHELVES_SINGLE;

            LOGGER.info("*******************进入精品二手车展品【" + proc + "】流程处理********************");
            // 批量上架
            FixedPrice fp = null;
            String allSids = fixedPrice.getAllIds();
            msg = proc + "失败！";

            if (StringUtils.isBlank(allSids))
                return new JsonResult(false, "非法请求！");

            String[] allSid = allSids.split(",");// "sid,vehicleSid"
            if (ArrayUtils.isEmpty(allSid))
                return new JsonResult(false, "非法请求！");
            Integer pfSid = StringUtils.isBlank(allSid[0]) ? null : Integer.valueOf(allSid[0]);
            Integer vehicleSid = Integer.valueOf(allSid[1]);

            Vehicle vehicle = auctVehicleService.selectByPrimaryKey(vehicleSid);
            if (null == vehicle) {
                return new JsonResult(false, "车辆不存在！");
            }

            Short vehicleSaleStatus = vehicle.getSaleStatus();
            if (vehicleSaleStatus == null || vehicleSaleStatus.compareTo(GlobalConstants.SALE_STATUS_WAIT) != 0)
                return new JsonResult(false, proc + "失败，车辆销售非【待售】！");

            isSale = isSale(vehicle.getRequirementType());
            if (!isSale) {
                return new JsonResult(false, "当前展品客户需求为【非出售】，请到车辆管理中修改或下架处理！");
            }

            fp = new FixedPrice();
            BeanUtils.copyProperties(fixedPrice, fp);
            fp.setTaxBuy(taxBuy);

            // 首次上架申请或直接上架
            if (null == pfSid && null != vehicleSid) {
                String text = "精品二手车首次" + proc;
                initFixedPrice(fp, fixedPrice, vehicle);

                initInsertFixedPrice(fp, flag);

                // 创建展品与新车关联
                // 未关联到新车数据提交时则不提交
                if (fpNewcarRelate.getNewcarParamId() != null) {
                    fpNewcarRelate.setVehicleSid(String.valueOf(vehicleSid));
                    fpNewcarRelate.setFpSid(fp.getId().toString());
                    fpNewcarRelate.setCreateTime(new Date());
                    fpNewcarRelate.setUpdateTime(new Date());
                    fpNewcarRelate.setCreateUser(getUser().getId().toString());
                    fpNewcarRelateService.insert(fpNewcarRelate);
                }

                log.setFixedPriceId(fp.getId());
                log.setCurrentLatest(fp.getLatest());
                log.setCurrentUsedCarStatus(fp.getStatus());
                log.setRemark(text);

            } else if (null != (pfSid)) {
                // 已下架展品再次上架申请或直接上架
                FixedPrice latestFP = fixedPriceService.selectByPrimaryKey(Integer.valueOf(pfSid));
                if (null == latestFP)
                    return new JsonResult(false, "当前展品不存在！");

                Integer status = latestFP.getStatus();
                if (null == status)
                    return new JsonResult(false, "当前展品状态非法！");

                Boolean isLatest = latestFP.getLatest();
                if (null == isLatest)
                    return new JsonResult(false, "当前展品isLatest状态非法！");

                // 如果是已下架展品则更新当前展品为旧展品，并生成新展品上架
                if (status.compareTo(UsedCarConstants.STATUS_OFF_SHELVES) != 0 && !isLatest)
                    return new JsonResult(false, "展品状态或isLatest状态已变更，" + proc + "失败！");

                latestFP.setLatest(Boolean.FALSE);
                try {
                    fixedPriceService.updateByPrimaryKeySelective(latestFP);
                } catch (Exception e1) {
                    LOGGER.error("精品二手车再次[" + proc + "]设置最新拍品属性失败，车辆SID：" + vehicleSid + "，展品SID：" + pfSid);
                    return new JsonResult(false, "已下架展品重新" + proc + "失败！");
                }

                initFixedPrice(fp, fixedPrice, vehicle);
                try {
                    initInsertFixedPrice(fp, flag);

                    // 创建展品与新车关联
                    // 未关联到新车数据提交时则不提交
                    if (fpNewcarRelate.getNewcarParamId() != null) {
                        fpNewcarRelate.setVehicleSid(vehicleSid.toString());
                        fpNewcarRelate.setFpSid(fp.getId().toString());
                        fpNewcarRelate.setCreateTime(new Date());
                        fpNewcarRelate.setUpdateTime(new Date());
                        fpNewcarRelate.setCreateUser(getUser().getId().toString());
                        fpNewcarRelateService.insert(fpNewcarRelate);
                    }
                } catch (Exception e) {
                    LOGGER.error("精品二手车再次[" + proc + "]失败，车辆SID：" + vehicleSid + "，展品SID：" + pfSid);
                    return new JsonResult(false, "已下架展品重新" + proc + "失败！");
                }

                log.setFixedPriceId(fp.getId());
                log.setPreLatest(isLatest);
                log.setCurrentLatest(fp.getLatest());
                log.setPreUsedCarStatus(status);
                log.setCurrentUsedCarStatus(fp.getStatus());
                log.setRemark("旧展品SID：" + latestFP.getId() + "车辆描述：" + fp.getMemo());

            }

            try {
                // 更新车辆销售状态为销售中
                auctVehicleService.updateSaleStatus(vehicleSid, SaleStatusEnum.SALE_STATUS_ONGOING);
            } catch (Exception e) {
                LOGGER.error("精品二手车[" + proc + "]成功，更新车辆销售状态失败。车辆SID：" + vehicleSid);
            }

            log.setAction(proc);
            log.setVehicleId(vehicleSid);
            log.setPreVehicleSaleStatus(Integer.valueOf(vehicleSaleStatus));
            log.setCurrentVehicleSaleStatus(1);
            log.setOperater(getUser().getName());
            log.setOperationTime(new Date());

            try {
                usedCarLogService.insertSelective(log);
            } catch (Exception e) {
                String error = proc + "操作日志保存失败！";
                LOGGER.error(error);
                msg += "\n" + error;
            }

            msg = proc + "成功！";
            success = true;
        } else {
            // 编辑
            LOGGER.info("*******************进入精品二手车展品【编辑】流程处理********************");
            msg = "编辑失败！";

            Integer sid = fixedPrice.getId();
            if (null == sid)
                return new JsonResult(false, "非法请求！");

            FixedPrice fp = fixedPriceService.selectByPrimaryKey(sid);
            if (null == fp)
                return new JsonResult(false, "展品不存在！");

            Integer status = fp.getStatus();
            if (status == null || status.compareTo(UsedCarConstants.STATUS_SHELVES_APPLY) != 0)
                return new JsonResult(false, "编辑失败，展品状态非【上架申请】！");

            Integer vehicleSid = fp.getVehicleId();
            if (null == vehicleSid)
                return new JsonResult(false, "展品数据异常，车辆SID为空！");

            Vehicle vehicle = auctVehicleService.selectByPrimaryKey(vehicleSid);
            if (null == vehicle)
                return new JsonResult(false, vehicleSid + "车辆不存在！");

            isSale = isSale(vehicle.getRequirementType());
            if (!isSale)
                return new JsonResult(false, "当前展品客户需求为【非出售】，如需编辑请到车辆管理中修改！");

            BigDecimal price = fixedPrice.getPrice();
            if (null == price)
                return new JsonResult(false, "展品价格无效！");

            BigDecimal result = price.multiply(BigDecimal.valueOf(10000));
            fixedPrice.setPrice(result);
            fixedPrice.setTaxBuy(taxBuy);
            fixedPrice.setUpdateUser(getUser().getId());
            fixedPrice.setUpdateTime(new Date());

            int size = 0;
            try {
                if (null == fixedPrice.getHidden()) {
                    fixedPrice.setHidden(false);
                }
                if (null == fixedPrice.getHasTaxBuy()) {
                    fixedPrice.setHasTaxBuy(false);
                }
                size = fixedPriceService.updateByPrimaryKeySelective(fixedPrice);
                /*
                 * vehicle.setPriceNewcar(priceNewcar);// 新车售价 size +=
                 * vehicleService.updateByPrimaryKeySelective(vehicle);
                 */
                int updateAffect = auctVehicleService.updateSaleStatus(vehicleSid, SaleStatusEnum.SALE_STATUS_ONGOING) ;
                if (updateAffect == 1) {
                    size++;
                } else {
                    LOGGER.warn("更新车辆{}销售状态受影响行数异常:{}", vehicleSid, updateAffect);
                }

                FpNewcarRelateExample fpNewcarRelateExample = new FpNewcarRelateExample();
                FpNewcarRelateExample.Criteria criteria = fpNewcarRelateExample.createCriteria();
                criteria.andVehicleSidEqualTo(vehicle.getId().toString());
                criteria.andFpSidEqualTo(fixedPrice.getId().toString());
                List<FpNewcarRelate> fpNewcarRelateList = fpNewcarRelateService.selectByExample(fpNewcarRelateExample);
                if (null == fpNewcarRelateList || fpNewcarRelateList.size() == 0) {
                    if (fpNewcarRelate.getNewcarParamId() != null) {
                        fpNewcarRelate.setVehicleSid(vehicleSid.toString());
                        fpNewcarRelate.setFpSid(fp.getId().toString());
                        fpNewcarRelate.setCreateTime(new Date());
                        fpNewcarRelate.setUpdateTime(new Date());
                        fpNewcarRelate.setCreateUser(getUser().getId().toString());
                        fpNewcarRelateService.insert(fpNewcarRelate);
                    }
                } else if (fpNewcarRelateList.size() == 1) {
                    if (fpNewcarRelate.getNewcarParamId() != null) {
                        fpNewcarRelateList.get(0).setNewcarParamId(fpNewcarRelate.getNewcarParamId());
                        fpNewcarRelateList.get(0).setUpdateTime(new Date());
                        fpNewcarRelateService.updateByPrimaryKey(fpNewcarRelateList.get(0));
                    }
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                return new JsonResult(false, "编辑失败！");
            }

            String proc = UsedCarConstants.ACTION_EDIT;
            log.setVehicleId(vehicleSid);
            log.setFixedPriceId(sid);
            log.setAction(proc);
            log.setPreVehicleSaleStatus(Integer.valueOf(vehicle.getSaleStatus()));
            log.setCurrentVehicleSaleStatus(Integer.valueOf(vehicle.getSaleStatus()));
            log.setPreLatest(fp.getLatest());
            log.setCurrentLatest(fp.getLatest());
            log.setPreUsedCarStatus(status);
            log.setCurrentUsedCarStatus(fp.getStatus());
            log.setOperater(getUser().getName());
            log.setOperationTime(new Date());
            log.setRemark(proc);

            try {
                usedCarLogService.insertSelective(log);
            } catch (Exception e) {
                String error = proc + "操作日志保存失败！";
                LOGGER.error(error);
                msg += "\n" + error;
            }

            if (size == 2) {
                msg = "编辑成功！";
                success = true;
            }

        }
        return new JsonResult(success, msg);
    }

    private void initInsertFixedPrice(FixedPrice fp, Boolean flag) {
        fp.setCreateUser(getUser().getId());
        fp.setUpdateUser(getUser().getId());
        // fp.setSid(UUIDUtil.getTimestampUUID());
        // 展品编号
        fp.setCode(businessRuleService.getBusinessIdByType(BusinessIdRuleEnum.AV_FIXED.getCode()));

		if (!flag) {
			fp.setStatus(UsedCarConstants.STATUS_SHELVES_APPLY);// 上架申请
			fp.setApplyShelvesTime(new Date());// 上架申请时间
		} else {
			fp.setStatus(UsedCarConstants.STATUS_SHELVES);// 已上架
			fp.setSellTime(new Date());// 上架时间
            fp.setOffShelvesTime(setOffShelvesTime(fp.getSellTime()));// 下架时间
		}

        fp.setCreateTime(new Date());
        fp.setLatest(Boolean.TRUE);
        fp.setUpdateTime(new Date());
        fp.setEnabled(Boolean.TRUE);
        FixedPrice ff = fixedPriceService.insertSelective(fp);
        fp.setId(ff.getId());
    }

    private void initFixedPrice(FixedPrice fp, FixedPrice param, Vehicle vehicle) {
        fp.setVehicleId(vehicle.getId());
        // 从车辆中拉取展售区域
        String province = vehicle.getCurrentProvince();
        String city = vehicle.getCurrentCity();

        if (StringUtils.isBlank(param.getProvince()))
            fp.setProvince(province);

        if (StringUtils.isBlank(param.getCity()))
            fp.setCity(city);

        if (null == param.getPrice()) {
            // 取保留价
            BigDecimal reservePrice = vehicle.getReservePrice();
            fp.setPrice(reservePrice);
        } else {
            fp.setPrice(param.getPrice().multiply(BigDecimal.valueOf(10000)));
        }

    }

    /**
     * <pre>
     * 展品下架处理
     * ****************************
     * V2.0：增加下架原因功能（2014年11月13日 14:33:54）<br>
     * V3.0：
     * 1.新版精品二手车下架<br>
     * </pre>
     * 
     * @Title: doCancelSell
     * @author xiaofeng.zhang
     */
    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult doCancelSell(@RequestParam(value = "allSids", required = true) String allSids,
            @RequestParam(value = "offShelvesRemark", required = true) String offShelvesRemark) {
        LOGGER.info("*******************进入展品【下架】流程********************");
        boolean success = false;
        String msg = "非法请求！";

        if (StringUtils.isBlank(allSids) && StringUtils.isBlank(offShelvesRemark))
            return new JsonResult(success, msg);

        String[] allSid = allSids.split("\\|\\|");// "sid,vehicleSid"
        if (ArrayUtils.isEmpty(allSid))
            return new JsonResult(success, msg);

        msg = "下架失败！";
        String[] fpSids = null;
        Integer fpId = null;// 展品SID
        Integer vehicleId = null;
        int size = allSid.length;
        int size1 = 0;
        int count = 0;
        FixedPrice checkFP = null;
        Vehicle checkVehicle = null;
        StringBuffer errorUsedCarInfo = new StringBuffer("\n下架失败，部分展品状态非【上架申请】或【已上架】或车辆销售状态非【出售中】。\n（展品SID|车辆SID）：");
        boolean errorUsedCar = false;

        // 车辆客户需求校验
        boolean isSale;
        boolean errorVehicleCustomer = false;
        StringBuffer errorVehicleCustomerInfo = new StringBuffer("\n上架失败，部分展品客户需求非【出售】，如需上架请到车辆管理中修改。\n（展品SID|车辆SID）：");

        // 操作日志
        UsedCarLog log = null;
        String proc = UsedCarConstants.ACTION_OFF_SHELVES_MULTI;

        // 展品状态为上架申请或已上架
        Integer[] fpStatus = {UsedCarConstants.STATUS_SHELVES_APPLY, UsedCarConstants.STATUS_SHELVES};

        for (int i = 0; i < size; i++) {
            fpSids = allSid[i].split(",");
            if (ArrayUtils.isEmpty(fpSids))
                continue;

            size1 = fpSids.length;
            if (size1 == 2) {
                fpId = Integer.valueOf(fpSids[0]);
                vehicleId = Integer.valueOf(fpSids[1]);
            }

            if (null == fpId && null == vehicleId) {
                LOGGER.info("展品下架处理异常，展品ID或车辆ID为空。");
                continue;
            }

            checkFP = fixedPriceService.selectByPrimaryKey(fpId);
            if (null == checkFP) {
                LOGGER.info("展品下架异常，展品不存在。ID：" + fpId);
                continue;
            }

            checkVehicle = auctVehicleService.selectByPrimaryKey(vehicleId);
            if (null == checkVehicle) {
                LOGGER.info("展品下架异常，车辆不存在。ID：" + vehicleId);
                continue;
            }

            isSale = isSale(checkVehicle.getRequirementType());
            if (!isSale) {
                errorVehicleCustomerInfo.append(fpId).append("|").append(vehicleId).append("、");
                if (!errorVehicleCustomer)
                    errorVehicleCustomer = true;
                continue;
            }

            if (!isCancelSellStatus(checkFP, checkVehicle.getSaleStatus(), fpStatus)) {
                errorUsedCarInfo.append(fpId).append("|").append(vehicleId).append("、");
                if (!errorUsedCar)
                    errorUsedCar = true;
                continue;
            }

            try {
                if (fixedPriceService.updateFixedPriceStatus(fpId, vehicleId, checkFP.getStatus(),
                        GlobalConstants.FIXED_PRICE_STATUS_OFF, offShelvesRemark, getUser().getId())) {
                    count++;
                }
                // 如果车辆下架，同时修改二手车推荐车辆为不可用状态
                HomepageRecommendExample example = new HomepageRecommendExample();
                com.autostreets.biz.auction.model.base.BaseHomepageRecommendExample.Criteria criteria = example
                        .createCriteria();
                criteria.andVehicleIdEqualTo(vehicleId);
                criteria.andFpIdEqualTo(fpId);
                criteria.andEnabledEqualTo(true);
                List<HomepageRecommend> homepageRecommends = homepageRecommendService.selectByExample(example);
                if (homepageRecommends != null && homepageRecommends.size() > 0) {
                    HomepageRecommend home = homepageRecommends.get(0);
                    home.setEnabled(false);
                    homepageRecommendService.updateByPrimaryKey(home);
                }
            } catch (Exception e) {
                LOGGER.error("展品下架处理，数据库操作异常。FPSID：" + fpId + "，VSID：" + vehicleId);
            }

            try {
                auctVehicleService.updateSaleStatus(vehicleId, SaleStatusEnum.SALE_STATUS_WAIT);// 待售
            } catch (Exception ex) {
                LOGGER.error(ex.getMessage(), ex);
            }

            log = new UsedCarLog();
            log.setVehicleId(vehicleId);
            log.setFixedPriceId(fpId);
            log.setAction(proc);
            log.setPreVehicleSaleStatus(Integer.valueOf(checkVehicle.getSaleStatus()));
            log.setCurrentVehicleSaleStatus(0);
            log.setPreLatest(checkFP.getLatest());
            log.setCurrentLatest(checkFP.getLatest());
            log.setPreUsedCarStatus(checkFP.getStatus());
            log.setCurrentUsedCarStatus(UsedCarConstants.STATUS_OFF_SHELVES);
            log.setOperater(getUser().getName());
            log.setOperationTime(new Date());
            log.setRemark(proc);

            try {
                usedCarLogService.insertSelective(log);
            } catch (Exception e) {
                LOGGER.error(proc + "操作日志保存失败！FPSID：" + fpId + "，VSID：" + vehicleId);
            }

        }

        success = true;
        msg = "下架完成！本次共选择" + size + "个展品，成功下架" + count + "个！";

        if (errorUsedCar) {
            msg += errorUsedCarInfo.toString();
        }
        return new JsonResult(success, msg);
    }

    /**
     * <pre>
     * 1.车辆销售状态为出售中
     * 2.展品状态为上架申请或已上架
     * 满足1-2条件即返回true，表示可下架
     * </pre>
     * 
     * @Title: isCancelSellStatus
     * @Description: 校验展品下架状态
     * @param fixedPrice
     * @param checkVehicle
     * @param fpStatus
     * @return boolean
     * @throws @author yanqing.luo （roceys#gmail.com）
     * @version V1.2
     * @date 2014年11月25日 下午7:24:31
     */
    private boolean isCancelSellStatus(FixedPrice fixedPrice, Short saleStatus, Integer[] fpStatus) {
        // 车辆销售状态为出售中
        if (fixedPrice.getStatus() == null || saleStatus == null
                || saleStatus.compareTo(GlobalConstants.SALE_STATUS_ONGOING) != 0)
            return false;
        return Arrays.asList(fpStatus).contains(fixedPrice.getStatus());
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param sid
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> doView(@RequestParam(value = "sid", required = true) Integer id) {
        LOGGER.info("*******************进入精品二手车展品编辑********************");
        FixedPrice fp = fixedPriceService.selectByPrimaryKey(id);
        Integer vehicleId = fp.getVehicleId();

        Map<String, Object> map = new HashMap<String, Object>();
        // 查询车辆是为了新车指导价，新车指导价存在fixed_price 中后无需再查询
        // Vehicle v = new Vehicle();
        // BeanUtils.copyProperties(auctVehicleService.selectVehicleInfoById((vehicleId)),
        // v);
        // fp.setVehicle(v);
        map.put("fixedPrice", fp);
        /*
         * 查询新车联系
         */
        FpNewcarRelateExample fpNewcarRelateExample = new FpNewcarRelateExample();
        FpNewcarRelateExample.Criteria criteria = fpNewcarRelateExample.createCriteria();
        criteria.andVehicleSidEqualTo(String.valueOf(vehicleId));
        criteria.andFpSidEqualTo(String.valueOf(id));
        List<FpNewcarRelate> fpNewcarRelateList = fpNewcarRelateService.selectByExample(fpNewcarRelateExample);
        if (null != vehicleId && fpNewcarRelateList.size() == 0) {
            return map;
        }
        NewVehicleDetailParameters newVehicleDetailParameters = null;
        if (fpNewcarRelateList.size() == 1) {
            newVehicleDetailParameters = newVehicleDetailParametersService.selectByPrimaryKey(fpNewcarRelateList.get(0)
                    .getNewcarParamId());
            map.put("newVehicleDetailParameters", newVehicleDetailParameters);
        }
        return map;
    }

    @RequestMapping("trackFpFailLog")
    @ResponseBody
    public JsonResult trackFpFailLog(Integer fixedPriceId) {
        return new JsonResult(true, usedCarLogService.getUsedCarLogs(fixedPriceId));
    }

    /**
     * 更改销售需求，展厅转拍卖
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * 
     * @author youpeng.zhang
     */
    @RequestMapping(value = "/changeToAuction")
    @ResponseBody
    public JsonResult changeToAuction(String allSids, String requirementType) {
        String[] sids = allSids.split("\\|\\|");
        if (sids != null && sids.length > 0) {
            for (int i = 0; i < sids.length; i++) {
                Integer vehicleId = Integer.valueOf(sids[i]);
                if (!fixedPriceService.isVehicleToAuction(vehicleId)) {
                    return new JsonResult(true, "保存失败!", false);
                }
            }

            for (int i = 0; i < sids.length; i++) {
                Integer vehicleId = Integer.valueOf(sids[i]);
                // usedvehicleOperatorService.updateRequirementType(vehicleId,
                // RequirementTypeEnum.getByValue(requirementType));
                auctVehicleService.updateRequirementType(vehicleId, RequirementTypeEnum.getByValue(requirementType));
            }
        }
        return new JsonResult(true, "保存成功!", true);

    }

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 计算展厅下架时间
     * </pre>
     *
     * @param sellTime
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月8日 下午5:10:52
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Date setOffShelvesTime(Date sellTime) {
        if (sellTime != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sellTime);
            //
            int expireDay = 600;// 到期时间默认600
            // 如果字典中存在配置，则应用字典配置
            List<AuctionDictionary> auctionDictionaries = dictionaryService.selectResource("usedcar_expiration_time");
            if (!CollectionUtils.isEmpty(auctionDictionaries)) {
                expireDay = Integer.parseInt(auctionDictionaries.get(0).getValue());
            }
            calendar.add(Calendar.DAY_OF_YEAR, expireDay);
            return calendar.getTime();
        }
        return null;
    }
}
