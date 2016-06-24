package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.AuctionDriveway;
import com.autostreets.biz.auction.model.AuctionDrivewayExample;
import com.autostreets.framework.common.dal.GenericService;

public interface AuctionDrivewayService extends GenericService<AuctionDriveway, AuctionDrivewayExample, Integer> {

	/**
	 * 功能描述: <br>
	 * 〈根据拍卖场地ID获取车道信息〉
	 * 
	 * @author weiyi.wang
	 * @param placeId
	 *            拍卖场地ID
	 */
	public List<AuctionDriveway> getDrivewayByPlaceId(Integer placeId);

}
