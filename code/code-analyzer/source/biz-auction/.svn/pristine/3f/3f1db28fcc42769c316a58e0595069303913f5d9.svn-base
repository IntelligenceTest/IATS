package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderItemExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface OrderItemService extends GenericService<OrderItem, OrderItemExample, Integer> {

    public Pagination queryOrders(Pagination pagination, OrderItem orderItem);

    /**
     * @param vehicleId
     * @return
     */
    List<OrderItem> getOrderItemByVehicleId(Integer vehicleId);

    List<OrderItem> getOrderItemByAuctionId(Integer vehicleId, Integer auctionVehicleId);

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param orderId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public OrderItem selectOrderItemByOrderId(Integer orderId);

    /**
     * 功能描述: 财务用，查询订单<br>
     * 〈功能详细描述〉
     *
     * @author wwy
     * @param pagination
     * @param orderItem
     * <br>
     *            orderItem.vehicleSrcIds 组织机构权限参数 <br>
     *            orderItem.startFinalPrice 最小成交价——orderItem.endFinalPrice 最大成交价 <br>
     *            orderItem.status 订单状态<br>
     *            orderItem.saleType 订单类型<br>
     *            orderItem.order.startDealTimestamp——orderItem.order.
     *            endDealTimestamp 订单成交时间<br>
     *            orderItem.order.startPayTimestamp——orderItem.order.
     *            endPayTimestamp 订单支付时间<br>
     *            orderItem.order.orderNo 订单号<br>
     *            orderItem.order.bidderName 购买人<br>
     *            orderItem.vehicle.code 车辆编号<br>
     *            orderItem.vehicle.licenseCode 车牌号
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Pagination queryOrders4Fi(Pagination pagination, OrderItem orderItem);

    /**
     * 
     * 功能描述: <br>
     * 〈查询订单管理中的区域〉
     *
     * @param orderItem
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AuctionVehicle> getAuctionCityList();

    /**
     * 功能描述:导出Excel查询数量 <br>
     *
     * @param orderItem
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer queryOrderCount(OrderItem orderItem);

    /**
     * 功能描述: 导出Excel查询<br>
     *
     * @param orderItem
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<OrderItem> queryOrders(OrderItem orderItem);

}
