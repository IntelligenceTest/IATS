package com.autostreets.biz.auction.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.OrderItemMapper;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderItemExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.model.base.BaseOrderItemExample.Criteria;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.sys.model.user.User;
import com.autostreets.biz.sys.model.user.UserExample;
import com.autostreets.biz.sys.service.user.UserService;
import com.autostreets.biz.wtms.dto.VehicleInventory;
import com.autostreets.biz.wtms.service.WmsService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("orderItemService")
public class OrderItemServiceImpl extends GenericServiceImpl<OrderItem, OrderItemExample, Integer>
        implements OrderItemService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrderItemServiceImpl.class);

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private WmsService wtmsService;

    @Autowired
    private UserService userService;

    @Override
    protected GenericMapper<OrderItem, OrderItemExample, Integer> getGenericMapper() {
        return orderItemMapper;
    }

    @Override
    public Integer queryOrderCount(OrderItem orderItem) {
        List<Integer> userIds = null;
        if (StringUtils.isNotBlank(orderItem.getOpUserName())) {
            UserExample example = new UserExample();
            example.createCriteria().andNameEqualTo(StringUtils.trim(orderItem.getOpUserName())).andEnabledEqualTo(1)
                    .andExpiredEqualTo(0).andLockedEqualTo(0).andDelFlagEqualTo(0);
            List<User> users = userService.selectByExample(example);
            if (users != null && users.size() > 0) {
                userIds = new ArrayList<>();
                for (User user : users) {
                    userIds.add(user.getId());
                }
                orderItem.setUserIds(userIds);
            } else {
                return 0;
            }
        }
        Integer count = orderItemMapper.queryOrderCount(orderItem);
        return count;
    }

    @Override
    public List<OrderItem> queryOrders(OrderItem orderItem) {
        List<Integer> userIds = null;
        if (StringUtils.isNotBlank(orderItem.getOpUserName())) {
            UserExample example = new UserExample();
            example.createCriteria().andNameEqualTo(StringUtils.trim(orderItem.getOpUserName())).andEnabledEqualTo(1)
                    .andExpiredEqualTo(0).andLockedEqualTo(0).andDelFlagEqualTo(0);
            List<User> users = userService.selectByExample(example);
            if (users != null && users.size() > 0) {
                userIds = new ArrayList<>();
                for (User user : users) {
                    userIds.add(user.getId());
                }
                orderItem.setUserIds(userIds);
            } else {
                return null;
            }
        }
        List<OrderItem> data = orderItemMapper.queryOrders(orderItem);
        return data;
    }

    @Override
    public Pagination queryOrders(Pagination pagination, OrderItem orderItem) {
        List<Integer> userIds = null;
        if (StringUtils.isNotBlank(orderItem.getOpUserName())) {
            UserExample example = new UserExample();
            example.createCriteria().andNameEqualTo(StringUtils.trim(orderItem.getOpUserName())).andEnabledEqualTo(1)
                    .andExpiredEqualTo(0).andLockedEqualTo(0).andDelFlagEqualTo(0);
            List<User> users = userService.selectByExample(example);
            if (users != null && users.size() > 0) {
                userIds = new ArrayList<>();
                for (User user : users) {
                    userIds.add(user.getId());
                }
                orderItem.setUserIds(userIds);
            } else {
                return pagination;
            }
        }
        int count = orderItemMapper.queryOrderCount(orderItem);
        pagination.setCount(count);
        orderItem.setPagination(pagination);
        List<OrderItem> data = orderItemMapper.queryOrders(orderItem);
        try {
            // 过滤不在库的车辆
            List<String> vinList = new ArrayList<String>();
            for (OrderItem orderItemTemp : data) {
                vinList.add(orderItemTemp.getVehicle().getVinCode());
            }
            List<VehicleInventory> vehicleInventoryList = wtmsService.queryVehicleInventory(vinList);
            if (vehicleInventoryList != null) {
                for (int i = 0; i < vehicleInventoryList.size(); i++) {
                    for (int j = 0; j < data.size(); j++) {
                        Vehicle vehicleTemp = data.get(j).getVehicle();
                        VehicleInventory vehicleInventory = vehicleInventoryList.get(i);
                        if (vehicleInventory.getVin().equals(vehicleTemp.getVinCode())) {
                            data.get(j).setStockRemovalApprovalStatus(2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            // LOGGER.warn("调用工作流接口失败", e);
            LOGGER.warn("调用出库接口失败", e);
        }
        pagination.setDataList(data);
        return pagination;
    }

    @Override
    public Pagination queryOrders4Fi(Pagination pagination, OrderItem orderItem) {
        List<Integer> userIds = null;
        if (StringUtils.isNotBlank(orderItem.getOpUserName())) {
            UserExample example = new UserExample();
            example.createCriteria().andNameEqualTo(StringUtils.trim(orderItem.getOpUserName())).andEnabledEqualTo(1)
                    .andExpiredEqualTo(0).andLockedEqualTo(0).andDelFlagEqualTo(0);
            List<User> users = userService.selectByExample(example);
            if (users != null && users.size() > 0) {
                userIds = new ArrayList<>();
                for (User user : users) {
                    userIds.add(user.getId());
                }
                orderItem.setUserIds(userIds);
            } else {
                return pagination;
            }
        }
        int count = orderItemMapper.queryOrderCount(orderItem);
        pagination.setCount(count);
        orderItem.setPagination(pagination);
        List<OrderItem> data = orderItemMapper.queryOrders(orderItem);
        pagination.setDataList(data);
        return pagination;
    }

    /**
     * 根据车查找相关订单
     */
    @Override
    public List<OrderItem> getOrderItemByVehicleId(Integer vehicleId) {
        OrderItemExample example = new OrderItemExample();
        OrderItemExample.Criteria criteria = example.createCriteria();
        criteria.andVehicleIdEqualTo(vehicleId);
        return orderItemMapper.selectByExample(example);
    }

    @Override
    public List<OrderItem> getOrderItemByAuctionId(Integer vehicleId, Integer auctionVehicleId) {
        OrderItemExample example = new OrderItemExample();
        OrderItemExample.Criteria criteria = example.createCriteria();
        criteria.andVehicleIdEqualTo(vehicleId);
        criteria.andAuctionVehicleIdEqualTo(auctionVehicleId);
        return this.selectByExample(example);
    }

    @Override
    public OrderItem selectOrderItemByOrderId(Integer orderId) {
        OrderItemExample orderItemExample = new OrderItemExample();
        Criteria criteria = orderItemExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderItem> itemList = orderItemMapper.selectByExample(orderItemExample);
        if (CollectionUtils.isNotEmpty(itemList)) {
            return itemList.get(0);
        }
        return null;
    }

    @Override
    public List<AuctionVehicle> getAuctionCityList() {
        return orderItemMapper.getAuctionCityList();

    }

}
