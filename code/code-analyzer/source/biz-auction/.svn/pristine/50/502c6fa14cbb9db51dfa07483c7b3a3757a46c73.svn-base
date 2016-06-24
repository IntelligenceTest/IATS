package com.autostreets.biz.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.OrderStatusLogMapper;
import com.autostreets.biz.auction.model.OrderStatusLog;
import com.autostreets.biz.auction.model.OrderStatusLogExample;
import com.autostreets.biz.auction.model.base.BaseOrderStatusLogExample.Criteria;
import com.autostreets.biz.auction.service.OrderStatusLogService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("orderStatusLogService")
public class OrderStatusLogServiceImpl extends GenericServiceImpl<OrderStatusLog, OrderStatusLogExample, Integer>
        implements OrderStatusLogService {

    @Autowired
    private OrderStatusLogMapper orderStatusLogMapper;

    @Override
    protected GenericMapper<OrderStatusLog, OrderStatusLogExample, Integer> getGenericMapper() {
        return orderStatusLogMapper;
    }

    @Override
    public OrderStatusLog getOrderLog(Integer orderId) {
        OrderStatusLogExample example = new OrderStatusLogExample();
        Criteria criteria = example.createCriteria();
        if (orderId != null) {
            criteria.andOrderIdEqualTo(orderId);
        }
        Integer i = new Integer(5);
        criteria.andPostStatusEqualTo(i.shortValue());
        example.setOrderByClause(" id desc");

        List<OrderStatusLog> orderlog = orderStatusLogMapper.selectByExample(example);
        if (orderlog.size() > 0) {
            return orderlog.get(0);
        }
        return null;
    }

}
