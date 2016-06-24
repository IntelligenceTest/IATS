package com.autostreets.biz.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.AuctionDrivewayMapper;
import com.autostreets.biz.auction.model.AuctionDriveway;
import com.autostreets.biz.auction.model.AuctionDrivewayExample;
import com.autostreets.biz.auction.service.AuctionDrivewayService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("auctionDrivewayService")
public class AuctionDrivewayServiceImpl extends GenericServiceImpl<AuctionDriveway, AuctionDrivewayExample, Integer>
		implements AuctionDrivewayService {

	@Autowired
	private AuctionDrivewayMapper auctionDrivewayMapper;

	@Override
	protected GenericMapper<AuctionDriveway, AuctionDrivewayExample, Integer> getGenericMapper() {
		return auctionDrivewayMapper;
	}

	@Override
	public List<AuctionDriveway> getDrivewayByPlaceId(Integer placeId) {
		AuctionDrivewayExample example = new AuctionDrivewayExample();
		AuctionDrivewayExample.Criteria criteria = example.createCriteria();
		criteria.andPlaceIdEqualTo(placeId);
		return selectByExample(example);
	}

}
