package com.autostreets.biz.auction.utils;

import java.math.BigDecimal;
import java.util.List;

import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.BidExample;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.BidService;
import com.google.common.base.Strings;

public final class BizUtils {
    public static boolean isTopPrice(List<Bid> bidList, List<Bid> myBidList) {
    	if (bidList.isEmpty() || myBidList.isEmpty()) {
    		return false;
    	}

    	Bid bid = bidList.get(0);
    	Bid myBid = myBidList.get(0);
    	if (bid.getPrice().compareTo(myBid.getPrice()) != 0 || !bid.getBidderSid().equals(myBid.getBidderSid())) {
    		return false;
    	}

    	for (Bid b : bidList) {
    		if (b.getPrice().compareTo(myBid.getPrice()) == 0 && b.getBidderSid().equals("000")) {
    			return false;
    		}
    	}

    	return true;
    }

    public static int calculateCommission(AuctionDictionaryService auctionDictionaryService, BigDecimal price, AuctionVehicle auctionVehicle) {
    	int commission = 0;
    	if (auctionVehicle.getBuyerFixedCommission() != null && auctionVehicle.getBuyerFixedCommission().compareTo(BigDecimal.ZERO) > 0) {
    		commission = auctionVehicle.getBuyerFixedCommission().intValue();
    	} else if (auctionVehicle.getBuyerCommissionRate() != null && auctionVehicle.getBuyerCommissionRate().compareTo(BigDecimal.ZERO) > 0) {
	    	int commissionMin = 0;
	    	int commissionMax = 0;
	    	List<AuctionDictionary> dictList = auctionDictionaryService.selectCommissionFeeRange();
	    	for (AuctionDictionary dict : dictList) {
	    		if ("min".equals(dict.getName())) {
	    			commissionMin = Integer.parseInt(dict.getValue());
	    		}
	    		if ("max".equals(dict.getName())) {
	    			commissionMax = Integer.parseInt(dict.getValue());
	    		}
	    	}

	    	commission = price.multiply(auctionVehicle.getBuyerCommissionRate()).divide(BigDecimal.valueOf(100L), 0, BigDecimal.ROUND_CEILING).intValue();
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

    public static BigDecimal calculateTotalPrice(BigDecimal price, int commission, AuctionVehicle auctionVehicle) {
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

    public static List<Bid> getBidList(BidService bidService, Integer avId, String memberId, boolean includeMsg) {
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

    	return bidService.selectByExample(be);
    }

	private BizUtils() {
	}
}
