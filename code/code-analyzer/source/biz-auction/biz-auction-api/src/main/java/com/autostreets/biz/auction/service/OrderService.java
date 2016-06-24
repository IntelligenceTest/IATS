package com.autostreets.biz.auction.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.exception.GenericEntityException;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderExample;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderStatusLog;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.model.order.OrderAppVo;

public interface OrderService extends GenericService<Order, OrderExample, Integer> {

    /**
     * 查询二手车展厅的订单
     * 
     * @param order
     * @return
     */
    Pagination queryFixedPriceOrders(Order order, Pagination pagination);

    public void cancelOrder(String orderNo, Integer userId, String memberSid, int cancelMethod) throws Exception;

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param orderNo
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Order selectOrderByOrderNo(String orderNo);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param orderId
     * @param userId
     * @param userType
     * @param postStatus
     * @param memo
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void changeOrderStatus(Integer orderId, Integer userId, Short userType, Short postStatus, String memo)
            throws Exception;

    public void changeOrderStatus(Integer orderId, Integer userId, Short userType, Short postStatus, String memo,
            String cellPhone, String name, Integer collectionParty, Integer collectionModel) throws Exception;

    public void changeOrderStatus(Integer orderId, Integer userId, Short userType, Short postStatus, String memo,
            Order orderParam) throws Exception;

    /**
     * 功能描述: 批量修改订单状态<br>
     * 〈功能详细描述〉
     *
     * @param orderIds
     * @param userId
     * @param userType
     * @param postStatus
     * @param memo
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<OrderItem> changeOrderStatusBatch(List<Integer> orderIds, Integer userId, Short userType, Short postStatus,
            String memo, Date payTime) throws Exception;

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param orderId
     * @param userId
     * @param userType
     * @param postStatus
     * @param memo
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void changeOrderStatus(Integer orderId, String memberSid, Short userType, Short postStatus, String memo)
            throws Exception;

    /**
     * 创建订单
     * 
     * @param order
     * @return
     * @throws GenericEntityException
     */
    String createOrder(Order order) throws GenericEntityException;

    /**
     * 按照订单编号查询二手车展厅的订单
     * 
     * @param order
     * @return
     */
    Order loadByOrderNo(String orderNo);

    // /**
    // * BI渠道推广数据统计
    // *
    // * @param orderSid
    // * @param channelSource
    // * @param orderType
    // * @param tableSource
    // * @param username
    // */
    // public void createOrderSource(String orderSid, String channelSource, int
    // orderType, String tableSource,
    // String username);

    /**
     * 根据订单编号获取订单状态变更情况
     * 
     * @param orderNo
     * @return
     * @throws GenericEntityException
     */
    List<OrderStatusLog> trackOrderStatus(String orderNo) throws GenericEntityException;

    /**
     * 二手车成交
     * 
     * @param orderNo
     *            订单编号
     * @param userSid
     *            用户标识
     * @param userType
     *            用户类型【1.后台（user）；2前台（member）】
     * @throws GenericEntityException
     */
    void dealOrder(String orderNo, String userId) throws Exception;

    /**
     * 二手车审核
     * 
     * @param orderNo
     * @param userSid
     *            仅支持后台用户审核
     * @throws GenericEntityException
     */
    void orderReview(String orderNo, Integer userId) throws GenericEntityException;

    /**
     * 二手车退订金
     * 
     * @param orderNo
     *            订单编号
     * @param userSid
     *            用户标识
     * @param userType
     *            用户类型【1.后台（user）；2前台（member）】
     * @throws GenericEntityException
     */
    void refundDeposit(String orderNo, Integer userId, Integer userType) throws Exception;

    int countOrderByUserID(Map<String, Object> params);

    List<Order> findOrderByUserID(Map<String, Object> params);

    /**
     * 支付订单【定金或全款】
     * 
     * @param orderId
     * @param price
     * @return
     * @throws GenericEntityException
     */
    void changeOrderStatusByPrice(String orderId, BigDecimal price) throws GenericEntityException;

    /**
     * APP使用的订单列表
     * 
     * @return List<OrderAppVo>
     * @author youpeng.zhang Date: 2015年10月26日 上午10:57:08
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    List<OrderAppVo> listOrderForApp(String memberSid);
}