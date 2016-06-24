package com.autostreets.biz.auction.service;

import com.autostreets.biz.auction.model.OrderStatusLog;
import com.autostreets.biz.auction.model.OrderStatusLogExample;
import com.autostreets.framework.common.dal.GenericService;

public interface OrderStatusLogService extends GenericService<OrderStatusLog, OrderStatusLogExample, Integer> {

    OrderStatusLog getOrderLog(Integer orderId);

}
