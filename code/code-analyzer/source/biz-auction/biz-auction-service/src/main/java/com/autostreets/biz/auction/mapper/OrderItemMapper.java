package com.autostreets.biz.auction.mapper;

import java.util.List;

import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderItemExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface OrderItemMapper extends GenericMapper<OrderItem, OrderItemExample, Integer> {

    /**
     * @param orderItem
     * @return
     */
    int queryOrderCount(OrderItem orderItem);

    /**
     * @param orderItem
     * @return
     */
    List<OrderItem> queryOrders(OrderItem orderItem);

    List<AuctionVehicle> getAuctionCityList();

}