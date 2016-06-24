package com.autostreets.biz.auction.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.constants.OrderConstans;
import com.autostreets.biz.auction.domain.OrderVo;
import com.autostreets.biz.auction.enums.BusinessIdRuleEnum;
import com.autostreets.biz.auction.exception.GenericEntityException;
import com.autostreets.biz.auction.mapper.FixedPriceMapper;
import com.autostreets.biz.auction.mapper.OrderMapper;
import com.autostreets.biz.auction.mapper.OrderStatusLogMapper;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AvStatusLog;
import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderExample;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderItemExample;
import com.autostreets.biz.auction.model.OrderStatusLog;
import com.autostreets.biz.auction.model.OrderStatusLogExample;
import com.autostreets.biz.auction.model.base.BaseOrderExample.Criteria;
import com.autostreets.biz.auction.model.base.BaseOrderStatusLogExample;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.AvStatusLogService;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.sys.model.user.User;
import com.autostreets.biz.sys.service.user.UserService;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.wtms.service.WmsService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.model.Member;
import com.autostreets.model.order.OrderAppVo;
import com.autostreets.service.BusinessRuleService;
import com.autostreets.service.MemberService;

@Service("orderService")
public class OrderServiceImpl extends GenericServiceImpl<Order, OrderExample, Integer>implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private FixedPriceService fixedPriceService;

    @Autowired
    private BusinessRuleService businessRuleService;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    // @Autowired
    // private OrderSourceInfoService orderSourceInfoService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private FixedPriceMapper fixedPriceMapper;

    @Autowired
    private OrderStatusLogMapper orderStatusLogMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private AvStatusLogService avStatusLogService;

    @Autowired
    private WmsService wmsService; // 仓储物流服务

    @Autowired
    private VehicleService vehicleService;

    @Override
    protected GenericMapper<Order, OrderExample, Integer> getGenericMapper() {
        return orderMapper;
    }

    @Override
    public Pagination queryFixedPriceOrders(Order order, Pagination pagination) {
        int count = orderMapper.queryFixedPriceOrderCount(order);
        pagination.setCount(count);
        order.setPagination(pagination);
        List<OrderVo> data = orderMapper.queryFixedPriceOrders(order);
        pagination.setDataList(data);
        return pagination;
    }

    @Override
    public String createOrder(Order order) throws GenericEntityException {
        // TODO:订单来源尚未录入
        if (null == order) {
            return null;
        }
        String orderNo = null;
        OrderItem orderItemEntity = new OrderItem();

        // 根据产品类型生成订单信息
        switch (order.getProductType()) {
            case 0:
                orderNo = businessRuleService.getBusinessIdByType(BusinessIdRuleEnum.OV_FIXED.getCode());

                FixedPrice fixedPrice = fixedPriceService.selectByPrimaryKey(order.getProductId());
                if (null == fixedPrice) {
                    throw new GenericEntityException("车辆不存在！");
                }
                orderItemEntity.setVehicleId(fixedPrice.getVehicleId());
                // TODO:一口价标识已存入拍品字段里面了
                orderItemEntity.setAuctionVehicleId(fixedPrice.getId());
                orderItemEntity.setFinalPrice(fixedPrice.getPrice());
                orderItemEntity.setSaleType(0);
                orderItemEntity.setOrderType(1);

                // 定金价格目前从字典表中获取，将来会在fixedPrice对象中获取，一车一价
                if (order.getOrderType() == 1) {
                    // orderItemEntity.setPrePrice(new BigDecimal("0.01"));
                    orderItemEntity.setPrePrice(fixedPrice.getDeposit());
                }
                if (fixedPrice.getStatus() != 3) { // 展品状态必须为已上架
                    throw new GenericEntityException("该车辆不可预定！");
                }
                fixedPrice.setStatus(4); // 已预定
                fixedPrice.setUpdateTime(new Date());
                fixedPriceService.updateByPrimaryKey(fixedPrice);
                break;
            default:
                break;
        }
        order.setCreatedTime(new Date());
        order.setOrderNo(orderNo);
        order.setDealTimestamp(new Date());
        orderMapper.insert(order);
        order = loadByOrderNo(orderNo);

        orderItemEntity.setFinAudit(OrderConstans.FINANCE_AUDIT_STATUS_NO);
        orderItemEntity.setOrderId(order.getId());
        orderItemEntity.setCreatedTimestamp(new Date());
        orderItemEntity.setStatus(OrderConstans.ORDER_STATUS_CREATED);
        orderItemEntity.setEnabled(true);

        orderItemService.insert(orderItemEntity);
        return orderNo;
    }

    @Override
    public Order loadByOrderNo(String orderNo) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<Order> list = orderMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    // @Override
    // public void createOrderSource(String orderSid, String channelSource, int
    // orderType, String tableSource,
    // String username) {
    // OrderSourceInfo orderSourceInfo = new OrderSourceInfo();
    // orderSourceInfo.setOrderId(orderSid);
    // orderSourceInfo.setChannelSource(channelSource);
    // orderSourceInfo.setCreatedTime(new Date());
    // orderSourceInfo.setDelFlag((byte) 0);
    // // orderSourceInfo.setId(1);
    // orderSourceInfo.setModifyTime(new Date());
    // orderSourceInfo.setOrderType(orderType);
    // orderSourceInfo.setTableSource(tableSource);
    // orderSourceInfo.setUsername(username);
    // orderSourceInfoService.insert(orderSourceInfo);
    // }

    @Override
    public void cancelOrder(String orderNo, Integer userId, String memberSid, int cancelMethod) throws Exception {
        Integer status;
        switch (cancelMethod) {
            case 1:
                status = OrderConstans.ORDER_STATUS_MANAGE_USER_CANCEL;
                break;
            case 2:
                status = OrderConstans.ORDER_STATUS_WEB_USER_CANCEL;
                break;
            case 3:
                status = OrderConstans.ORDER_STATUS_PAY_OVERTIME;
                break;
            default:
                throw new Exception("请选择取消方式！");
        }

        Order order = selectOrderByOrderNo(orderNo);
        if (null == order) {
            throw new Exception("该订单不存在！");
        }
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(order.getId());
        if (OrderConstans.ORDER_STATUS_CREATED != orderItem.getStatus()
                && OrderConstans.ORDER_STATUS_REFUND_FULL != orderItem.getStatus()) {
            throw new Exception("订单已支付或已取消，不能再取消！");
        }
        if (userId != null) {
            changeOrderStatus(order.getId(), userId, (short) 1, status.shortValue(), null);
        } else {
            changeOrderStatus(order.getId(), memberSid, (short) 2, status.shortValue(), null);
        }

        // 根据销售方式做撤单动作
        switch (orderItem.getSaleType()) {
            case 0: // 若是一口价
                FixedPrice fixedPrice = fixedPriceService.selectByPrimaryKey(orderItem.getAuctionVehicleId());
                if (null == fixedPrice) {
                    throw new Exception("展品不存在！");
                }
                fixedPrice.setStatus(3); // 已上架
                fixedPrice.setUpdateTime(new Date());
                fixedPrice.setUpdateUser(userId);// 一口价需要修改UpdateUser类型为Integer
                fixedPriceService.updateByPrimaryKey(fixedPrice);
                break;
            case 1:
            case 2:
            case 3: // 在线拍或是同步拍或者即时拍
                AuctionVehicle auctionVehicle = auctionVehicleService
                        .selectByPrimaryKey(orderItem.getAuctionVehicleId());
                if (null != auctionVehicle) {
                    // auctionVehicle.setStatus(7); // 设置拍品状态为侧单
                    // auctionVehicleService.updateByPrimaryKey(auctionVehicle);
                    // 更新为取消订单
                    auctionVehicleService.updateAuctionVehicleStatus(auctionVehicle.getId(),
                            auctionVehicle.getVehicleId(), auctionVehicle.getStatus(),
                            GlobalConstants.AUCTION_VEHICLE_STATUS_CANCEL);
                    // 添加拍品表的log日志
                    AvStatusLog avStatusLog = new AvStatusLog();
                    avStatusLog.setAvId(auctionVehicle.getId());
                    avStatusLog.setCreateTime(new Date());
                    avStatusLog.setMemo("取消订单！");
                    avStatusLog.setPreStatus((short) 2);
                    avStatusLog.setPostStatus((short) 7);
                    avStatusLog.setCreateUser(userId);
                    avStatusLogService.insert(avStatusLog);
                }

                // 修改车辆的销售状态为待售中
                // Vehicle vehicle =
                // vehicleService.se.selectByPrimaryKey(orderItem.getVehicleId());
                // if (null != vehicle) {
                /*
                 * vehicle.setSaleStatus((short) 0);
                 * vehicleMapper.updateByPrimaryKey(vehicle);
                 */
                // usedvehicleOperatorService.updateSaleStatus(orderItem.getVehicleId(),
                // SaleStatusEnum.SALE_STATUS_WAIT);
                // }
                break;
            default:
                break;
        }

    }

    @Override
    public Order selectOrderByOrderNo(String orderNo) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(orderNo);
        List<Order> orders = selectByExample(example);
        if (CollectionUtils.isNotEmpty(orders)) {
            return orders.get(0);
        }
        return null;
    }

    @Override
    public void changeOrderStatus(Integer orderId, Integer userId, Short userType, Short postStatus, String memo)
            throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (null == order) {
            throw new Exception("该订单不存在！");
        }
        order.setUpdateTime(new Date());
        orderMapper.updateByPrimaryKey(order);
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);

        OrderStatusLog orderStatusLog = new OrderStatusLog();
        orderStatusLog.setOrderId(orderId);
        orderStatusLog.setUserId(userId);
        orderStatusLog.setUserType(userType);
        orderStatusLog.setCreateTime(new Date());
        orderStatusLog.setPrepStatus(orderItem.getStatus().shortValue());
        orderStatusLog.setPostStatus(postStatus);
        if (StringUtils.isNotEmpty(memo)) {
            orderStatusLog.setMemo(memo);
        }
        orderStatusLogMapper.insert(orderStatusLog);

        orderItem.setStatus(postStatus.intValue());
        orderItemService.updateByPrimaryKey(orderItem);
    }

    @Override
    @Transactional
    public void changeOrderStatus(Integer orderId, Integer userId, Short userType, Short postStatus, String memo,
            Order orderParam) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (null == order) {
            throw new Exception("该订单不存在！");
        }
        order.setUpdateTime(new Date());
        order.setBidderName(orderParam.getBidderName());
        if (StringUtils.isNotBlank(orderParam.getBuyerCellphone())) {
            order.setBuyerCellphone(orderParam.getBuyerCellphone());
            Member member = new Member();
            member.setCellphone(order.getBuyerCellphone());
            List<Member> members = memberService.selectByExample(member);
            if (members != null && members.size() > 0) {
                member = members.get(0);
            }
            order.setBidderSid(member.getSid());
        }
        order.setDraweeName(orderParam.getDraweeName());
        orderMapper.updateByPrimaryKey(order);
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);

        OrderStatusLog orderStatusLog = new OrderStatusLog();
        orderStatusLog.setOrderId(orderId);
        orderStatusLog.setUserId(userId);
        orderStatusLog.setUserType(userType);
        orderStatusLog.setCreateTime(new Date());
        orderStatusLog.setPrepStatus(orderItem.getStatus().shortValue());
        orderStatusLog.setPostStatus(postStatus);
        if (StringUtils.isNotEmpty(memo)) {
            orderStatusLog.setMemo(memo);
        }
        orderStatusLogMapper.insert(orderStatusLog);

        orderItem.setStatus(postStatus.intValue());
        orderItem.setCollectionParty(orderParam.getItem().getCollectionParty());
        orderItem.setCollectionModel(orderParam.getItem().getCollectionModel());
        orderItemService.updateByPrimaryKey(orderItem);
    }

    @Override
    public void changeOrderStatus(Integer orderId, Integer userId, Short userType, Short postStatus, String memo,
            String cellPhone, String name, Integer collectionParty, Integer collectionModel) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (null == order) {
            throw new Exception("该订单不存在！");
        }
        order.setUpdateTime(new Date());
        if (StringUtils.isNotBlank(name)) {
            order.setBidderName(name);
        }
        if (StringUtils.isNotBlank(cellPhone)) {
            order.setBuyerCellphone(cellPhone);
            Member member = new Member();
            member.setCellphone(order.getBuyerCellphone());
            List<Member> members = memberService.selectByExample(member);
            if (members != null && members.size() > 0) {
                member = members.get(0);
            }
            order.setBidderSid(member.getSid());
        }
        orderMapper.updateByPrimaryKey(order);
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);

        OrderStatusLog orderStatusLog = new OrderStatusLog();
        orderStatusLog.setOrderId(orderId);
        orderStatusLog.setUserId(userId);
        orderStatusLog.setUserType(userType);
        orderStatusLog.setCreateTime(new Date());
        orderStatusLog.setPrepStatus(orderItem.getStatus().shortValue());
        orderStatusLog.setPostStatus(postStatus);
        if (StringUtils.isNotEmpty(memo)) {
            orderStatusLog.setMemo(memo);
        }
        orderStatusLogMapper.insert(orderStatusLog);

        orderItem.setStatus(postStatus.intValue());
        orderItem.setCollectionParty(collectionParty);
        orderItem.setCollectionModel(collectionModel);
        orderItemService.updateByPrimaryKey(orderItem);
    }

    @Override
    @Transactional
    public List<OrderItem> changeOrderStatusBatch(List<Integer> orderIds, Integer userId, Short userType,
            Short postStatus, String memo, Date payTime) throws Exception {
        if (orderIds.isEmpty()) {
            LOGGER.error("参数错误!");
        }
        List<OrderItem> orders = new ArrayList<OrderItem>();
        OrderExample example = new OrderExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andIdIn(orderIds);
        List<Order> orderList = orderMapper.selectByExample(example);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        List<Integer> orderItemIds = new ArrayList<Integer>();
        for (Order order : orderList) {
            if (null == order) {
                continue;
            }
            OrderItem orderItem = orderItemService.selectOrderItemByOrderId(order.getId());
            orderItemIds.add(orderItem.getId());
            orderItems.add(orderItem);
            OrderStatusLog orderStatusLog = new OrderStatusLog();
            orderStatusLog.setOrderId(order.getId());
            orderStatusLog.setUserId(userId);
            orderStatusLog.setUserType(userType);
            orderStatusLog.setCreateTime(new Date());
            orderStatusLog.setPrepStatus(orderItem.getStatus().shortValue());
            orderStatusLog.setPostStatus(postStatus);
            if (StringUtils.isNotEmpty(memo)) {
                orderStatusLog.setMemo(memo);
            }
            orderStatusLogMapper.insert(orderStatusLog);

            orderItem.setStatus(postStatus.intValue());
            orderItem.setVehicle(vehicleService.selectByPrimaryKey(orderItem.getVehicleId()));
            // orderItemService.updateByPrimaryKey(orderItem);
            orderItem.setOrder(order);
            orders.add(orderItem);
        }
        Order order = new Order();
        order.setUpdateTime(new Date());
        if (payTime != null) {
            order.setPayTimestamp(payTime);
        }
        updateByExampleSelective(order, example);// 批量更新订单
        OrderItem item = new OrderItem();
        item.setStatus(postStatus.intValue());
        OrderItemExample example2 = new OrderItemExample();
        com.autostreets.biz.auction.model.base.BaseOrderItemExample.Criteria createCriteria2 = example2
                .createCriteria();
        createCriteria2.andIdIn(orderItemIds);
        orderItemService.updateByExampleSelective(item, example2);// 批量更新orderItem
        return orders;
    }

    @Override
    public void changeOrderStatus(Integer orderId, String memberSid, Short userType, Short postStatus, String memo)
            throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (null == order) {
            throw new Exception("该订单不存在！");
        }
        if (postStatus == 4) {
            order.setPayTimestamp(new Date());
        }
        order.setUpdateTime(new Date());
        orderMapper.updateByPrimaryKey(order);
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);

        OrderStatusLog orderStatusLog = new OrderStatusLog();
        orderStatusLog.setOrderId(orderId);
        orderStatusLog.setMemberSid(memberSid);
        orderStatusLog.setUserType(userType);
        orderStatusLog.setCreateTime(new Date());
        orderStatusLog.setPrepStatus(orderItem.getStatus().shortValue());
        orderStatusLog.setPostStatus(postStatus);
        if (StringUtils.isNotEmpty(memo)) {
            orderStatusLog.setMemo(memo);
        }
        orderStatusLogMapper.insert(orderStatusLog);

        orderItem.setStatus(postStatus.intValue());
        orderItemService.updateByPrimaryKey(orderItem);
    }

    @Override
    public List<OrderStatusLog> trackOrderStatus(String orderNo) throws GenericEntityException {
        Order order = selectOrderByOrderNo(orderNo);
        if (null == order) {
            throw new GenericEntityException("该订单不存在！");
        }
        OrderStatusLogExample orderStatusLogExample = new OrderStatusLogExample();
        BaseOrderStatusLogExample.Criteria criteria = orderStatusLogExample.createCriteria();
        criteria.andOrderIdEqualTo(order.getId());
        orderStatusLogExample.setOrderByClause("id desc");
        List<OrderStatusLog> list = orderStatusLogMapper.selectByExample(orderStatusLogExample);
        if (null != list && list.size() > 0) {
            int i = 0;
            for (OrderStatusLog orderStatusLog : new ArrayList<OrderStatusLog>(list)) {
                if (null != orderStatusLog.getUserType() && 1 == orderStatusLog.getUserType()) {
                    User user = userService.selectByPrimaryKey(orderStatusLog.getUserId());
                    if (null != user && StringUtils.isNotEmpty(user.getName())) {
                        orderStatusLog.setUserId(user.getId());
                        orderStatusLog.setUserName(user.getUsername());
                    }
                } else if (null != orderStatusLog.getUserType() && 2 == orderStatusLog.getUserType()) {
                    Member member = memberService.selectByPrimaryKey(orderStatusLog.getMemberSid());
                    if (null != member && StringUtils.isNotEmpty(member.getUsername())) {
                        orderStatusLog.setMemberSid(member.getSid());
                        orderStatusLog.setUserName(member.getUsername());
                    }
                }
                if (null != orderStatusLog.getPrepStatus()) {
                    String prepStatus = auctionDictionaryService.getNameByCategoryValue("order_status",
                            orderStatusLog.getPrepStatus().toString());
                    orderStatusLog.setPrepStatusName(prepStatus);
                }
                if (null != orderStatusLog.getPostStatus()) {
                    String postStatus = auctionDictionaryService.getNameByCategoryValue("order_status",
                            orderStatusLog.getPostStatus().toString());
                    orderStatusLog.setPostStatusName(postStatus);
                }
                // if (StringUtils.isNotEmpty(orderStatusLog.getMemo())) {
                // orderStatusLog.setPostStatusName(
                // orderStatusLog.getPostStatusName() + "（" +
                // orderStatusLog.getMemo() + "）");
                // }
                list.set(i++, orderStatusLog);
            }
        }
        return list;
    }

    @Override
    public void dealOrder(String orderNo, String userId) throws Exception {
        dealOrder(orderNo, userId, OrderConstans.USER_TYPE_USER);
    }

    private void dealOrder(String orderNo, String userId, short userType) throws Exception {
        Order order = selectOrderByOrderNo(orderNo);
        if (null == order) {
            throw new GenericEntityException("该订单不存在！");
        }
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(order.getId());
        if (OrderConstans.ORDER_STATUS_PAID_DEPOSIT != orderItem.getStatus()) {
            throw new GenericEntityException("订单必须已付定金！");
        }
        if (orderItem.getSaleType() != 0) {
            throw new GenericEntityException("只有精品二手车成能线上付款！");
        }
        changeOrderStatus(order.getId(), Integer.parseInt(userId), userType,
                OrderConstans.ORDER_STATUS_PAID_FULL.shortValue(), null);

        // 展品
        FixedPrice fixedPrice = fixedPriceService.selectByPrimaryKey(orderItem.getAuctionVehicleId());
        if (null == fixedPrice) {
            throw new GenericEntityException("展品不存在！");
        }
        fixedPrice.setStatus(6); // 已付全款
        fixedPrice.setUpdateTime(new Date());
        fixedPrice.setUpdateUser(Integer.parseInt(userId));
        fixedPriceService.updateByPrimaryKey(fixedPrice);
    }

    @Override
    public void orderReview(String orderNo, Integer userId) throws GenericEntityException {
        Order order = selectOrderByOrderNo(orderNo);
        OrderItem item = orderItemService.selectOrderItemByOrderId(order.getId());
        if (null == item) {
            throw new GenericEntityException("该订单不存在！");
        }
        if (OrderConstans.FINANCE_AUDIT_STATUS_YES == item.getFinAudit()) {
            throw new GenericEntityException("该订单已审核！");
        }
        if (OrderConstans.ORDER_STATUS_PAID_FULL != item.getStatus()) {
            throw new GenericEntityException("订单必须已付全款！");
        }
        order.setUpdateTime(new Date());
        item.setFinAudit(OrderConstans.FINANCE_AUDIT_STATUS_YES);
        orderMapper.updateByPrimaryKey(order);
        orderItemService.updateByPrimaryKey(item);

        // 订单修改日志
        OrderStatusLog orderStatusLog = new OrderStatusLog();
        orderStatusLog.setOrderId(order.getId());
        orderStatusLog.setUserId(userId);
        orderStatusLog.setUserType(OrderConstans.USER_TYPE_USER);
        orderStatusLog.setCreateTime(new Date());
        orderStatusLog.setPrepStatus(OrderConstans.ORDER_STATUS_PAID_FULL.shortValue());
        orderStatusLog.setPostStatus(OrderConstans.ORDER_STATUS_PAID_FULL.shortValue());
        orderStatusLog.setMemo("已审核");
        orderStatusLogMapper.insert(orderStatusLog);
    }

    @Override
    public void refundDeposit(String orderNo, Integer userId, Integer userType) throws Exception {
        Order order = selectOrderByOrderNo(orderNo);
        if (null == order) {
            throw new GenericEntityException("该订单不存在！");
        }
        OrderItem item = orderItemService.selectOrderItemByOrderId(order.getId());

        Integer intStatus = item.getStatus(); // modified by HCF
        if ((!OrderConstans.ORDER_STATUS_PAID_DEPOSIT.equals(item.getStatus()))
                && (!OrderConstans.ORDER_STATUS_CONSULT_REFUND_DEPOSIT.equals(item.getStatus()))) {
            throw new GenericEntityException("订单必须已付定金！");
        }
        if (item.getSaleType() != 0) {
            throw new GenericEntityException("只有精品二手车才能退定金！");
        }

        changeOrderStatus(order.getId(), userId, userType.shortValue(),
                OrderConstans.ORDER_STATUS_REFUND_DEPOSIT.shortValue(), null);

        // 展品
        // modified for 9-协商退款 by HCF
        if (intStatus == OrderConstans.ORDER_STATUS_CONSULT_REFUND_DEPOSIT) {
            return;
        }

        FixedPrice fixedPrice = fixedPriceService.selectByPrimaryKey(item.getAuctionVehicleId());
        if (null == fixedPrice) {
            throw new GenericEntityException("展品不存在！");
        }
        fixedPrice.setStatus(3); // 重新上架
        fixedPrice.setUpdateTime(new Date());
        fixedPrice.setUpdateUser(userId);
        fixedPriceService.updateByPrimaryKey(fixedPrice);
    }

    @Override
    public int countOrderByUserID(Map<String, Object> params) {
        return orderMapper.countOrderByUserID(params);
    };

    @Override
    public List<Order> findOrderByUserID(Map<String, Object> params) {
        return orderMapper.findOrderByUserID(params);
    }

    @Override
    public void changeOrderStatusByPrice(String orderNo, BigDecimal price) throws GenericEntityException {
        Order order = selectOrderByOrderNo(orderNo);
        if (null == order) {
            throw new GenericEntityException("该订单不存在！");
        }
        OrderItem item = orderItemService.selectOrderItemByOrderId(order.getId());
        if (null != item.getPrePrice() && item.getPrePrice().equals(price)) {
            try {
                changeOrderStatus(order.getId(), order.getBidderSid(), OrderConstans.USER_TYPE_MEMBER,
                        Short.valueOf("4"), null);
            } catch (Exception e1) {
                // e1.printStackTrace();
                LOGGER.error("订单状态转换失败 changeOrderStatusByPrice" + orderNo);
            }
            // 展品
            FixedPrice fixedPrice = fixedPriceMapper.selectByPrimaryKey(item.getAuctionVehicleId());
            if (null == fixedPrice) {
                throw new GenericEntityException("展品不存在！");
            }
            fixedPrice.setStatus(5); // 已付定金
            fixedPrice.setUpdateTime(new Date());
            fixedPrice.setUpdateUser(item.getBidId());
            fixedPriceMapper.updateByPrimaryKey(fixedPrice);
            // TODO 新增二手车支付订金移动到预订库区服务调用
            try {
                // Vehicle vehicle =
                // vehicleMapper.selectByPrimaryKey(fixedPrice.getVehicleId());
                VehicleInfo vehicle = vehicleService.selectVehicleInfoById(fixedPrice.getVehicleId());
                if (null == vehicle) {
                    throw new GenericEntityException("该车辆不存在");
                }
                if (vehicle.getStockStatus() == 0) {
                    wmsService.placeAnOrderForNewVehicle(vehicle.getVinCode(),
                            String.valueOf(vehicle.getVehicleSrcId()), orderNo);
                }
            } catch (Exception e) {
                LOGGER.warn("调用仓储物流移动到预订区接口失败orderNo=" + orderNo);
            }
        } else if (null != item.getFinalPrice() && item.getFinalPrice().equals(price)) {
            try {
                dealOrder(orderNo, order.getBidderSid(), OrderConstans.USER_TYPE_MEMBER);
            } catch (Exception e) {
                LOGGER.warn("订单处理失败" + orderNo);
            }
        }
    }

    @Override
    public List<OrderAppVo> listOrderForApp(String memberSid) {
        return orderMapper.listOrderForApp(memberSid);
    }
}