package com.autostreets.biz.auction.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.autostreets.biz.auction.domain.BidDisplay;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.BidExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface BidMapper extends GenericMapper<Bid, BidExample, Integer> {

    public List<BidDisplay> selectBidDisplayByVehicleMode(Bid bid);

    public List<BidDisplay> selectBidByAvId(Integer avId);

    public Integer countBidDisplayByVehicleMode(Bid bid);

    public List<BidDisplay> selectBidDisplayByBidMode(Bid bid);

    public Integer countBidDisplayByBidMode(Bid bid);

    public BidDisplay getMaxPrice(Integer avId);

    /**
     * 根据拍品标识查询其最高出价
     * 
     * @Title: queryBidMaxPrice
     * @Description: 根据拍品标识查询其最高出价
     * @param avId
     *            拍品
     * @return BigDecimal 最高价
     * @throws @author yanqing.luo
     * @version V1.0
     * @date 2014年7月29日 下午6:58:01
     */
    BigDecimal queryBidMaxPrice(@Param("avId") Integer avId);

    public Bid getMaxPriceBidder(Bid bid);

    public List<Bid> getSecondPrice(Bid bid);

    /**
     * @param bid
     * @return
     */
    public Bid getCurrentHighestPrice(Bid bid);

    public BigDecimal queryMaxPriceByEntity(Bid bid);
}