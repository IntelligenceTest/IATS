package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.domain.OrderVo;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderExample;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.model.order.OrderAppVo;

public interface OrderMapper extends GenericMapper<Order, OrderExample, Integer> {

	List<OrderItem> queryOrders(OrderItem orderItem);

	/**
	 * @param order
	 * @return
	 */
	int queryFixedPriceOrderCount(Order order);

	/**
	 * @param order
	 * @return
	 */
	List<OrderVo> queryFixedPriceOrders(Order order);

    int countOrderByUserID(Map<String, Object> params);

    List<Order> findOrderByUserID(Map<String, Object> params);

	/**
	 * @param memberSid
	 * @return
	 */
	List<OrderAppVo> listOrderForApp(String memberSid);
}