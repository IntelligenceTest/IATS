package com.autostreets.biz.auction.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.domain.BidDisplay;
import com.autostreets.biz.auction.mapper.BidMapper;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.BidExample;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.utils.DateUtils;
import com.google.common.base.Strings;

@Service("bidService")
public class BidServiceImpl extends GenericServiceImpl<Bid, BidExample, Integer>implements BidService {

    @Autowired
    private BidMapper bidMapper;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private AuctionDictionaryService dictionaryService;

    @Override
    protected GenericMapper<Bid, BidExample, Integer> getGenericMapper() {
        return bidMapper;
    }

    @Override
    public List<BidDisplay> selectBidDisplayByVehicleMode(Bid bid) {
        if (Strings.isNullOrEmpty(bid.getBrand())) {
            bid.setBrand(null);
        }
        if (Strings.isNullOrEmpty(bid.getType())) {
            bid.setType(null);
        }
        if (Strings.isNullOrEmpty(bid.getAvType())) {
            bid.setAvType(null);
        }
        if (Strings.isNullOrEmpty(bid.getLicense_code())) {
            bid.setLicense_code(null);
        }
        if (Strings.isNullOrEmpty(bid.getEvaluation_dept())) {
            bid.setEvaluation_dept(null);
        }
        if (Strings.isNullOrEmpty(bid.getStartTimestamp())) {

            bid.setStartTimestamp(null);
        }
        if (Strings.isNullOrEmpty(bid.getEndTimestamp())) {
            bid.setEndTimestamp(null);
        }
        if (Strings.isNullOrEmpty(bid.getCode())) {
            bid.setCode(null);
        }
        if (Strings.isNullOrEmpty(bid.getCity())) {
            bid.setCity(null);
        }
        List<BidDisplay> list = bidMapper.selectBidDisplayByVehicleMode(bid);
        return list;
    }

    @Override
    public List<BidDisplay> selectBidByAvId(Integer avId) {
        return bidMapper.selectBidByAvId(avId);
    }

    @Override
    public boolean createOnlineBid(Bid bid) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(bid.getAuctionVehicleId());
        if (bid.getPrice().compareTo(auctionVehicle.getMaxBidPrice()) <= 0) {
            return false;
        }

        Date currentDate = new Date();
        if (auctionVehicle.getOnlineEndTime() != null && !auctionVehicle.getOnlineEndTime().after(currentDate)) {
            return false;
        }

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andIdEqualTo(auctionVehicle.getId());
        aveCriteria.andMaxBidPriceEqualTo(auctionVehicle.getMaxBidPrice());

        AuctionVehicle auctionVehicleEntity = new AuctionVehicle();
        auctionVehicleEntity.setMaxBidPrice(bid.getPrice());

        int affectedRows = auctionVehicleService.updateByExampleSelective(auctionVehicleEntity, ave);
        if (affectedRows < 1) {
            return false;
        }

        if (auctionVehicle.getOnlineEndTime() != null && auctionVehicle.getOnlineEndTime().after(currentDate)) {
            auctionVehicleService.resetOnlineEndTime(bid.getAuctionVehicleId());
        }
        bidMapper.insertSelective(bid);
        return true;
    }

    @Override
    public boolean createOfflineBid(Bid bid) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(bid.getAuctionVehicleId());
        if (bid.getPrice().compareTo(auctionVehicle.getMaxBidPrice()) < 0) {
            return false;
        }

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andIdEqualTo(auctionVehicle.getId());
        aveCriteria.andMaxBidPriceEqualTo(auctionVehicle.getMaxBidPrice());

        AuctionVehicle auctionVehicleEntity = new AuctionVehicle();
        auctionVehicleEntity.setMaxBidPrice(bid.getPrice());

        int affectedRows = auctionVehicleService.updateByExampleSelective(auctionVehicleEntity, ave);
        if (affectedRows < 1) {
            return false;
        }

        if (auctionVehicle.getOnlineEndTime() != null) {
            auctionVehicleService.resetOnlineEndTime(bid.getAuctionVehicleId());
        }

        bidMapper.insertSelective(bid);
        return true;
    }

    @Override
    public boolean createOnlineOnlyBid(Bid bid) {
        int retryCount = 10;
        AuctionVehicle auctionVehicle = null;
        for (int i = 0; i < retryCount; ++i) {
            auctionVehicle = auctionVehicleService.selectByPrimaryKey(bid.getAuctionVehicleId());
            if (bid.getPrice().compareTo(auctionVehicle.getMaxBidPrice()) <= 0
                    || bid.getPrice().compareTo(auctionVehicle.getStartPrice()) < 0) {
                return false;
            }

            AuctionVehicleExample ave = new AuctionVehicleExample();
            AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
            aveCriteria.andIdEqualTo(auctionVehicle.getId());
            aveCriteria.andMaxBidPriceEqualTo(auctionVehicle.getMaxBidPrice());

            Date currentDate = new Date();
            AuctionVehicle auctionVehicleEntity = new AuctionVehicle();
            auctionVehicleEntity.setMaxBidPrice(bid.getPrice());
            // 最后1分钟内如果有出价，结束时间顺延1分钟
            if (auctionVehicle.getOnlineEndTime().getTime() - currentDate.getTime() <= 60000) {
                auctionVehicleEntity.setOnlineEndTime(DateUtils.addSeconds(currentDate, 60));
            }

            int affectedRows = auctionVehicleService.updateByExampleSelective(auctionVehicleEntity, ave);
            if (affectedRows == 1) {
                break;
            }
        }

        bidMapper.insertSelective(bid);

        // int price = bid.getPrice().intValue();
        // int delta = auctionVehicle.getPlusRange().intValue();
        // if (!isProxyBid(bid) && auctionVehicle.getAgentPrice() != null &&
        // auctionVehicle.getAgentPrice() > 0
        // && auctionVehicle.getAgentPrice() > price) {
        // Bid proxyBid = new Bid();
        // proxyBid.setAuctionVehicleId(auctionVehicle.getId());
        // proxyBid.setBidderSid("***");
        // proxyBid.setBidderUsername("***");
        // proxyBid.setBidderName("系统");
        // proxyBid.setBidTimestamp(new Date());
        // proxyBid.setIp("0.0.0.0");
        // proxyBid.setMsg(false);
        // proxyBid.setContent(StringUtil.mask(proxyBid.getBidderUsername()) + "
        // 出价" + proxyBid.getPrice().toString()
        // + " 元（代理价）");
        // if (auctionVehicle.getAgentPrice() > price + delta) {
        // proxyBid.setPrice(BigDecimal.valueOf(price + delta));
        // } else {
        // proxyBid.setPrice(BigDecimal.valueOf(auctionVehicle.getAgentPrice().longValue()));
        // }
        // proxyBid.setOriginPrice(proxyBid.getPrice());
        //
        // createOnlineOnlyBid(proxyBid);
        // }

        return true;
    }

    // private boolean isProxyBid(Bid bid) {
    // return "0.0.0.0".equals(bid.getIp());
    // }

    @Override
    public BigDecimal queryBidMaxPrice(Integer avId) {
        return bidMapper.queryBidMaxPrice(avId);
    }

    @Override
    public BigDecimal queryMaxPriceByEntity(Bid bid) {
        if (bid.getAuctionVehicleId() == null) {
            bid.setAuctionVehicleId(null);
        }
        if (StringUtils.isBlank(bid.getBidderSid())) {
            bid.setBidderSid(null);
        }

        BigDecimal price = bidMapper.queryMaxPriceByEntity(bid);
        if (price == null) {
            price = BigDecimal.ZERO;
        }
        return price;
    }

    @Override
    public List<BidDisplay> selectBidDisplayByBidMode(Bid bid) {
        if (Strings.isNullOrEmpty(bid.getBrand())) {
            bid.setBrand(null);
        }
        if (Strings.isNullOrEmpty(bid.getType())) {
            bid.setType(null);
        }
        if (Strings.isNullOrEmpty(bid.getAvType())) {
            bid.setAvType(null);
        }
        if (Strings.isNullOrEmpty(bid.getLicense_code())) {
            bid.setLicense_code(null);
        }
        if (Strings.isNullOrEmpty(bid.getEvaluation_dept())) {
            bid.setEvaluation_dept(null);
        }
        if (Strings.isNullOrEmpty(bid.getStartTimestamp())) {
            bid.setStartTimestamp(null);
        }
        if (Strings.isNullOrEmpty(bid.getEndTimestamp())) {
            bid.setEndTimestamp(null);
        }
        if (Strings.isNullOrEmpty(bid.getCode())) {
            bid.setCode(null);
        }
        if (Strings.isNullOrEmpty(bid.getCity())) {
            bid.setCity(null);
        }
        List<BidDisplay> list = bidMapper.selectBidDisplayByBidMode(bid);
        return list;
    }

    @Override
    public BidDisplay getMaxPrice(Integer avId) {
        BidDisplay bidDisplay = bidMapper.getMaxPrice(avId);
        return bidDisplay;
    }

    @Override
    public Integer countBidDisplayByVehicleMode(Bid bid) {
        return bidMapper.countBidDisplayByVehicleMode(bid);
    }

    @Override
    public Integer countBidDisplayByBidMode(Bid bid) {
        return bidMapper.countBidDisplayByBidMode(bid);
    }

    @Override
    public BigDecimal queryMemberBidPrice(Integer avId, String memberSid) {
        BidExample example = new BidExample();
        BidExample.Criteria BidCriteria = example.createCriteria();
        BidCriteria.andAuctionVehicleIdEqualTo(avId);
        BidCriteria.andBidderSidEqualTo(memberSid);
        List<Bid> bidList = bidMapper.selectByExample(example);
        if (bidList == null || bidList.size() == 0) {
            return null;
        }
        return bidList.get(0).getPrice();
    }

    @Override
    public List<Bid> getBidList(Integer avId, String memberId, boolean includeMsg) {
        BidExample be = new BidExample();
        BidExample.Criteria beCriteria = be.createCriteria();
        beCriteria.andAuctionVehicleIdEqualTo(avId);
        if (!Strings.isNullOrEmpty(memberId)) {
            beCriteria.andBidderSidEqualTo(memberId);
        }
        if (!includeMsg) {
            beCriteria.andMsgEqualTo(false);
        }
        be.setOrderByClause("id desc");

        return this.selectByExample(be);
    }

    @Override
    public int calculateCommission(BigDecimal myBidPrice, AuctionVehicle auctionVehicle) {
        int commission = 0;
        if (auctionVehicle.getBuyerFixedCommission() != null
                && auctionVehicle.getBuyerFixedCommission().compareTo(BigDecimal.ZERO) > 0) {
            commission = auctionVehicle.getBuyerFixedCommission().intValue();
        } else if (auctionVehicle.getBuyerCommissionRate() != null
                && auctionVehicle.getBuyerCommissionRate().compareTo(BigDecimal.ZERO) > 0) {
            int commissionMin = 0;
            int commissionMax = 0;
            List<AuctionDictionary> dictList = dictionaryService.selectCommissionFeeRange();
            for (AuctionDictionary dict : dictList) {
                if ("min".equals(dict.getName())) {
                    commissionMin = Integer.parseInt(dict.getValue());
                }
                if ("max".equals(dict.getName())) {
                    commissionMax = Integer.parseInt(dict.getValue());
                }
            }

            commission = myBidPrice.multiply(auctionVehicle.getBuyerCommissionRate())
                    .divide(BigDecimal.valueOf(100L), 0, BigDecimal.ROUND_CEILING).intValue();
            if (commission < commissionMin) {
                commission = commissionMin;
            }
            if (commission > commissionMax) {
                commission = commissionMax;
            }
        } else {
            commission = 0;
        }

        return commission;
    }

    @Override
    public int calculateSellerCommission(BigDecimal price, AuctionVehicle auctionVehicle) {
        int commission = 0;
        if (auctionVehicle.getClientFixedCommission() != null
                && auctionVehicle.getClientFixedCommission().compareTo(BigDecimal.ZERO) > 0) {
            commission = auctionVehicle.getClientFixedCommission().intValue();
        } else if (auctionVehicle.getClientCommissionRate() != null
                && auctionVehicle.getClientCommissionRate().compareTo(BigDecimal.ZERO) > 0) {
            int commissionMin = 0;
            int commissionMax = 0;
            List<AuctionDictionary> dictList = dictionaryService.selectCommissionFeeRange();
            for (AuctionDictionary dict : dictList) {
                if ("min".equals(dict.getName())) {
                    commissionMin = Integer.parseInt(dict.getValue());
                }
                if ("max".equals(dict.getName())) {
                    commissionMax = Integer.parseInt(dict.getValue());
                }
            }

            commission = price.multiply(auctionVehicle.getClientCommissionRate())
                    .divide(BigDecimal.valueOf(100L), 0, BigDecimal.ROUND_CEILING).intValue();
            if (commission < commissionMin) {
                commission = commissionMin;
            }
            if (commission > commissionMax) {
                commission = commissionMax;
            }
        } else {
            commission = 0;
        }

        return commission;
    }

    @Override
    public BigDecimal calculateTotalPrice(BigDecimal price, int commission, AuctionVehicle auctionVehicle) {
        BigDecimal totalPrice = price;
        if (auctionVehicle.getLicenseFee() != null) {
            totalPrice = totalPrice.add(auctionVehicle.getLicenseFee());
        }
        if (auctionVehicle.getExWarehouseFee() != null) {
            totalPrice = totalPrice.add(auctionVehicle.getExWarehouseFee());
        }
        if (auctionVehicle.getParkingFee() != null) {
            totalPrice = totalPrice.add(auctionVehicle.getParkingFee());
        }
        totalPrice = totalPrice.add(BigDecimal.valueOf(commission));

        return totalPrice;
    }

    @Override
    public void deleteOfflineBid(Bid bid, BigDecimal price) {
        if (!bid.getBidderSid().equals("000")) {
            return;
        }

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andIdEqualTo(bid.getAuctionVehicleId());
        aveCriteria.andMaxBidPriceEqualTo(bid.getPrice());

        AuctionVehicle auctionVehicleEntity = new AuctionVehicle();
        auctionVehicleEntity.setMaxBidPrice(price);

        int affectedRows = auctionVehicleService.updateByExampleSelective(auctionVehicleEntity, ave);
        if (affectedRows < 1) {
            return;
        }

        BidExample be = new BidExample();
        BidExample.Criteria beCriteria = be.createCriteria();
        beCriteria.andIdEqualTo(bid.getId());
        beCriteria.andBidderSidEqualTo("000");

        bidMapper.deleteByExample(be);
    }

    @Override
    public Bid getMaxPriceBidder(Integer auctionVehicleId) {
        Bid bid = new Bid();
        bid.setAuctionVehicleId(auctionVehicleId);
        return bidMapper.getMaxPriceBidder(bid);
    }

    @Override
    public Bid getSecondPrice(Integer auctionVehicleId) {
        Bid bid = new Bid();
        bid.setAuctionVehicleId(auctionVehicleId);
        List<Bid> bids = bidMapper.getSecondPrice(bid);
        if (bids == null || bids.size() == 0) {
            return null;
        } else {
            if (bids.size() == 1) {
                return bids.get(0);
            } else {
                return bids.get(1);
            }
        }
    }

    @Override
    public Bid getCurrentHighestPrice(Integer avId, String memberSid) {
        Bid bid = new Bid();
        bid.setAuctionVehicleId(avId);
        bid.setBidderSid(memberSid);
        return bidMapper.getCurrentHighestPrice(bid);
    }

    @Override
    public boolean createOnlineZjBid(Bid bid) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(bid.getAuctionVehicleId());
        if (bid.getPrice().compareTo(auctionVehicle.getMaxBidPrice()) <= 0) {
            return false;
        }
        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andIdEqualTo(auctionVehicle.getId());
        aveCriteria.andMaxBidPriceEqualTo(auctionVehicle.getMaxBidPrice());

        AuctionVehicle auctionVehicleEntity = new AuctionVehicle();
        auctionVehicleEntity.setMaxBidPrice(bid.getPrice());
        auctionVehicleEntity.setFinalBidStatus(2);

        int affectedRows = auctionVehicleService.updateByExampleSelective(auctionVehicleEntity, ave);
        if (affectedRows < 1) {
            return false;
        }
        bidMapper.insertSelective(bid);
        return true;
    }
}
