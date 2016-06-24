package com.autostreets.biz.auction.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.BidMapper;
import com.autostreets.biz.auction.mapper.MemberVehicleBatchMapper;
import com.autostreets.biz.auction.mapper.OrderItemMapper;
import com.autostreets.biz.auction.mapper.OrderMapper;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.MemberVehicleBatch;
import com.autostreets.biz.auction.model.MemberVehicleBatchExample;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderItemExample;
import com.autostreets.biz.auction.service.MemberVehicleBatchService;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("memberVehicleBatchService")
public class MemberVehicleBatchServiceImpl extends
		GenericServiceImpl<MemberVehicleBatch, MemberVehicleBatchExample, Integer>implements MemberVehicleBatchService {

	@Autowired
	private MemberVehicleBatchMapper memberVehicleBatchMapper;

	@Override
	protected MemberVehicleBatchMapper getGenericMapper() {
		return memberVehicleBatchMapper;
	}

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private BidMapper bidMapper;

	@Override
	public int checkBidedByVehicleAndUser(String userId, Integer vehicleSid) {
		OrderItemExample orderItemExample = new OrderItemExample();
		OrderItemExample.Criteria criteria = orderItemExample.createCriteria();
		criteria.andVehicleIdEqualTo(vehicleSid);
		criteria.andStatusEqualTo(0);

		List<OrderItem> list = orderItemMapper.selectByExample(orderItemExample);
		OrderItem orderItem = null;
		if (list != null && list.size() > 0) {
			orderItem = list.get(0);
		}
		if (orderItem == null) {
			return 0;
		}

		Integer orderSid = orderItem.getOrderId();
		Order order = orderMapper.selectByPrimaryKey(orderSid);
		String bidderSid = "";
		if (order != null) {
			bidderSid = order.getBidderSid();
			if (userId.equalsIgnoreCase(bidderSid)) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public BigDecimal getMaxBidPriceByAV(Integer avId) {
		Bid bid = new Bid();
		bid.setAuctionVehicleId(avId);

		BigDecimal maxBidPrice = bidMapper.queryMaxPriceByEntity(bid);
		if (maxBidPrice == null) {
			maxBidPrice = BigDecimal.ZERO;
		}
		return maxBidPrice;
	}

	@Override
	public BigDecimal getMaxBidPriceByAVandUser(Integer avId, String userId) {
		Bid bid = new Bid();
		bid.setAuctionVehicleId(avId);
		bid.setBidderSid(userId);

		BigDecimal maxBidPrice = bidMapper.queryMaxPriceByEntity(bid);
		if (maxBidPrice == null) {
			maxBidPrice = BigDecimal.ZERO;
		}
		return maxBidPrice;
	}

}
