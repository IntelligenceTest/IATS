package com.autostreets.biz.auction.service;

import java.math.BigDecimal;
import java.util.List;

import com.autostreets.biz.auction.domain.BidDisplay;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.BidExample;
import com.autostreets.framework.common.dal.GenericService;

public interface BidService extends GenericService<Bid, BidExample, Integer> {

	/**
	 * 
	 * 查询出与竞价相关的所有的元素
	 */
	List<BidDisplay> selectBidDisplayByVehicleMode(Bid big);

	List<BidDisplay> selectBidByAvId(Integer avId);

	List<BidDisplay> selectBidDisplayByBidMode(Bid big);

	public Integer countBidDisplayByVehicleMode(Bid bid);

	public Integer countBidDisplayByBidMode(Bid bid);

	public BidDisplay getMaxPrice(Integer avId);

	/**
	 * 同步拍网络出价
	 *
	 * @param bid
	 * @return
	 */
	boolean createOnlineBid(Bid bid);

	//
	// /**
	// * 同步拍现场出价
	// *
	// * @param bid
	// * @return
	// */
	// boolean createOfflineBid(Bid bid);
	//
	// /**
	// * 同步拍现场撤销上一价格
	// *
	// * @param bid
	// * @param price
	// */
	// void deleteOfflineBid(Bid bid, BigDecimal price);
	//
	/**
	 * 在线拍出价
	 *
	 * @param bid
	 * @return
	 */
	boolean createOnlineOnlyBid(Bid bid);

	/**
	 * @Title: queryBidMaxPrice
	 * @Description: 根据拍品查询其最高出价
	 */
	BigDecimal queryBidMaxPrice(Integer avSid);

	/**
	 * Get Max Price record by bid entity
	 */
	BigDecimal queryMaxPriceByEntity(Bid bid);

	/**
	 * 根据登录用户及拍品查询出价信息
	 * 
	 * @return BigDecimal
	 * @author youpeng.zhang Date: 2015年9月8日 下午2:54:46
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	BigDecimal queryMemberBidPrice(Integer avId, String memberSid);

	/**
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 * 
	 * @author jingzhou.zhao
	 * @param avId
	 * @param memberSid
	 * @param includeMsg
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	List<Bid> getBidList(Integer avId, String memberId, boolean includeMsg);

	/**
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 * 
	 * @author jingzhou.zhao
	 * @param myBidPrice
	 * @param auctionVehicle
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	int calculateCommission(BigDecimal myBidPrice, AuctionVehicle auctionVehicle);

	/**
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 * 
	 * @author jingzhou.zhao
	 * @param price
	 * @param av
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	int calculateSellerCommission(BigDecimal price, AuctionVehicle av);

	/**
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 * 
	 * @author jingzhou.zhao
	 * @param bid
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	boolean createOfflineBid(Bid bid);

	/**
	 * 功能描述: <br>
	 * 〈计算总价〉
	 * 
	 * @author jingzhou.zhao
	 * @param price
	 * @param commission
	 * @param auctionVehicle
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	BigDecimal calculateTotalPrice(BigDecimal price, int commission, AuctionVehicle auctionVehicle);

	/**
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 * 
	 * @author jingzhou.zhao
	 * @param bid
	 * @param price
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	void deleteOfflineBid(Bid bid, BigDecimal price);

	/**
	 * 功能描述: <br>
	 * 〈获取最高出价人〉
	 * 
	 * @author jingzhou.zhao
	 * @param auctionVehicleId
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	Bid getMaxPriceBidder(Integer auctionVehicleId);

	/**
	 * 功能描述: <br>
	 * 〈获取次高价〉
	 * 
	 * @author jingzhou.zhao
	 * @param id
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	Bid getSecondPrice(Integer auctionVehicleId);

	/**
	 * 功能描述: <br>
	 * 〈获取指定用户最高出价〉
	 * 
	 * 
	 * @author jingzhou.zhao
	 * @datetime 2015年9月29日 下午2:26:56
	 * @param avId
	 *            拍品id
	 * @param memberSid
	 *            指定用户id
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	Bid getCurrentHighestPrice(Integer avId, String memberSid);

	/**
	 * 商家车辆拍品追加价格
	 * 
	 * @param bid
	 * @return
	 */
	boolean createOnlineZjBid(Bid bid);
}
