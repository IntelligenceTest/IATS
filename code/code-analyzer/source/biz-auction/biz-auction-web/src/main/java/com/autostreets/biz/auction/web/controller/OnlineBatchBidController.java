package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.BidExample;
import com.autostreets.biz.auction.model.MemberVehicleBatch;
import com.autostreets.biz.auction.model.MemberVehicleBatchExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.MemberVehicleBatchService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.utils.BizUtils;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.model.Member;
import com.autostreets.service.MemberService;
import com.autostreets.util.StringUtil;
import com.autostreets.web.util.RequestUtils;
import com.autostreets.web.util.ResponseUtils;
import com.autostreets.web.util.UserIdentityUtils;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Controller
public class OnlineBatchBidController extends BaseController {

    @Autowired
    private MemberVehicleBatchService memberVehicleBatchService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private BidService bidService;

	// max count for batch bid vehicle list
	public static final int MAX_COUNT = 8;

	@RequestMapping(value = "/online-batchbid/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
		if (userIdentity == null) {
            return "redirect:/";
            // throw new RuntimeException();
		}
		String userId = userIdentity.getId();

		MemberVehicleBatchExample mvbExample = new MemberVehicleBatchExample();
		MemberVehicleBatchExample.Criteria mvbCriteria = mvbExample
				.createCriteria();
		mvbCriteria.andMemberSidEqualTo(userId);
		List<MemberVehicleBatch> mvbList = memberVehicleBatchService
				.selectByExample(mvbExample);
		for (int i = 0; i < mvbList.size(); i++) {
			AuctionVehicle avTemp = null;
			MemberVehicleBatch mvb = null;
			mvb = mvbList.get(i);

			// 获得当前用户的最新bid价格
			if (mvb.getLatestPrice() == null) {
				BidExample bidExamp = new BidExample();
				BidExample.Criteria criteria = bidExamp.createCriteria();
				criteria.andBidderSidEqualTo(userId);
				criteria.andAuctionVehicleIdEqualTo(mvb.getAvId());
				bidExamp.setOrderByClause(" bid_timestamp desc ");
				List<Bid> list = bidService.selectByExample(bidExamp);
				if (list != null && list.size() > 0) {
					mvb.setLatestPrice(list.get(0).getPrice());
				}
			}

			avTemp = auctionVehicleService.selectByPrimaryKey(mvb.getAvId());
			mvb.setAuctionVehicle(avTemp);
			mvb.setVehicle(vehicleService.selectByPrimaryKey(mvb
					.getVehicleId()));

			Date currTime = new Date();
			Date endTime;
			if (avTemp.getOnlineEndTime() != null) {
				endTime = avTemp.getOnlineEndTime();
			} else {
				endTime = avTemp.getPlanEndTime();
			}

			mvb.setTimeIntervalEnd(endTime.getTime() - currTime.getTime());
			mvb.setTimeIntervalStart(avTemp.getPlanStartTime().getTime()
					- currTime.getTime());
		}

		model.addAttribute("memberVehicles", mvbList);
		return "online-auction-vehicle/batch_list";
	}

    @RequestMapping(value = "/online-batchbid/addbid", method = RequestMethod.POST)
    public void addBid(Integer sid, Integer avId, BigDecimal price, HttpServletRequest request,
            HttpServletResponse response) {
        if (avId == null || price == null || sid == null) {
            throw new IllegalArgumentException();
        }

        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (auctionVehicle == null) {
            throw new RuntimeException();
        }

        Map<String, Object> result = Maps.newHashMap();

        if (!auctionVehicle.getStatus().equals(5)) {
            result.put("success", false);
            result.put("error", "对不起，非竞拍中商品");
            ResponseUtils.writeJsonObject(response, result);
            return;
        }

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        if (userIdentity == null) {
            result.put("success", false);
            result.put("error", "请先登录");
            ResponseUtils.writeJsonObject(response, result);
            return;
        }

        Member member = memberService.selectByPrimaryKey(userIdentity.getId());

        if (!("商户".equals(member.getMemberCategory()) && "VIP1".equalsIgnoreCase(member.getMemberLevel()))) {
            result.put("success", false);
            result.put("error", "对不起，只 有认证商户才有资格参加竞拍");
            ResponseUtils.writeJsonObject(response, result);
            return;
        }
        if (!"0".equals(member.getEnable())) {
        	result.put("success", false);
            result.put("error", "对不起，您暂时没有权限出价，如有问题，请联系客服");
            ResponseUtils.writeJsonObject(response, result);
            return;
		}

        Bid bid = new Bid();
        bid.setAuctionVehicleId(avId);
        bid.setBidderSid(userIdentity.getId());
        bid.setBidderUsername(userIdentity.getUsername());
        bid.setBidderName(member.getName());
        bid.setBidTimestamp(new Date());
        bid.setOriginPrice(price);
        bid.setPrice(price);
        bid.setIp(RequestUtils.getClientIp(request));
        bid.setMsg(false);
        bid.setContent(StringUtil.mask(bid.getBidderUsername()) + " 出价 " + bid.getPrice().toString() + " 元");

        boolean success = bidService.createOnlineOnlyBid(bid);
        if (!success) {
            result.put("success", false);
            result.put("error", "出价慢了，请重新出价");
            ResponseUtils.writeJsonObject(response, result);
            return;
        } else {
            // update the latest_price value
            MemberVehicleBatch mvb = memberVehicleBatchService.selectByPrimaryKey(sid);
            mvb.setLatestPrice(price);
            memberVehicleBatchService.updateByPrimaryKey(mvb);
        }

        Date endTime;
        AuctionVehicle av = auctionVehicleService.selectByPrimaryKey(avId);
        if (av.getOnlineEndTime() != null) {
            endTime = av.getOnlineEndTime();
        } else {
            endTime = av.getPlanEndTime();
        }

        long times = endTime.getTime() - new Date().getTime();
        if (times < 0) {
            times = 0;
        }
        result.put("times", times);

        result.put("success", true);
        result.put("price", price);

        ResponseUtils.writeJsonObject(response, result);
    }

	@RequestMapping(value = "/online-batchbid/delRecord", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delRecord(Integer sid, HttpServletRequest request,
			HttpServletResponse response) {
		if (null == sid) {
			throw new IllegalArgumentException();
		}

		JsonResult result = new JsonResult();

		MemberVehicleBatch mvb = memberVehicleBatchService
				.selectByPrimaryKey(sid);
		if (mvb != null) {
			result.addExtra("vSid", mvb.getVehicleId());
		}

		int iRet = memberVehicleBatchService.deleteByPrimaryKey(sid);
		if (iRet > 0) {
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}

		return result;
	}

	@RequestMapping(value = "/online-batchbid/delRecordByAV", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delRecordByAV(Integer avId, Integer vId,
			HttpServletRequest request, HttpServletResponse response) {
		
	    JsonResult result = new JsonResult();
		if (null == vId || null == avId) {
			result.setSuccess(false);
			return result;
		}

		MemberVehicleBatchExample mvbExamp = new MemberVehicleBatchExample();
		MemberVehicleBatchExample.Criteria mvbCriteria = mvbExamp
				.createCriteria();
		mvbCriteria.andAvIdEqualTo(avId);
		mvbCriteria.andVehicleIdEqualTo(vId);
		
		//fixed bug by zjz 2015-11-6 09:56:10 删除批量出价 会影响其他用户
		com.autostreets.web.vo.UserIdentity userIdentity = com.autostreets.biz.auction.web.utils.UserIdentityUtils.getUserIdentity(request);
		mvbCriteria.andMemberSidEqualTo(userIdentity.getId());
		//

		List<MemberVehicleBatch> mvbList = memberVehicleBatchService
				.selectByExample(mvbExamp);
		Integer sid = null;
		if (mvbList == null || mvbList.size() == 0) {
		    result.setSuccess(false);
		} else {
			MemberVehicleBatch mvb = mvbList.get(0);
			sid = mvb.getId();

			int iRet = memberVehicleBatchService.deleteByPrimaryKey(sid);
			if (iRet > 0) {
			    result.setSuccess(true);
			} else {
			    result.setSuccess(false);
			}
		}

		result.addExtra("sid", sid);
		return result;
	}

    @RequestMapping(value = "/online-batchbid/batchDelRecord", method = RequestMethod.POST)
    public void batchDelRecord(String sids, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = Maps.newHashMap();
        if (Strings.isNullOrEmpty(sids)) {
            result.put("success", false);
            ResponseUtils.writeJsonObject(response, result);
            return;
        }

        String[] sidArray = sids.split(",");
        List<Integer> sidList = Lists.newArrayList();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sidArray.length; i++) {
            sidList.add(Integer.valueOf(sidArray[i]));
        }

        MemberVehicleBatchExample mvbExamp = new MemberVehicleBatchExample();
        MemberVehicleBatchExample.Criteria mvbCriteria = mvbExamp.createCriteria();
        mvbCriteria.andIdIn(sidList);
        //fixed bug by zjz 2015-11-6 09:56:10 删除批量出价 会影响其他用户
        com.autostreets.web.vo.UserIdentity userIdentity = com.autostreets.biz.auction.web.utils.UserIdentityUtils.getUserIdentity(request);
        mvbCriteria.andMemberSidEqualTo(userIdentity.getId());
        //
        List<MemberVehicleBatch> mvbEntityList = memberVehicleBatchService.selectByExample(mvbExamp);
        if (mvbEntityList != null && mvbEntityList.size() > 0) {
            for (MemberVehicleBatch mvb : mvbEntityList) {
                String strTemp = mvb.getId() + "," + mvb.getVehicleId() + "," + mvb.getAvId();
                sb.append(";" + strTemp);
            }
            int iRet = memberVehicleBatchService.deleteByExample(mvbExamp);
            if (iRet > 0) {
                result.put("success", true);
            } else {
                result.put("success", false);
            }
        }

        result.put("delList", (sb.toString().length() > 0) ? sb.toString().substring(1) : "");

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/online-batchbid/maxprice", method = RequestMethod.POST)
    public void getMaxBid(Integer avId, HttpServletRequest request, HttpServletResponse response) {
        if (avId == null) {
            throw new IllegalArgumentException();
        }
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);

        Map<String, Object> result = Maps.newHashMap();
        BigDecimal currentPrice = BigDecimal.ZERO;
        BigDecimal bidPrice = BigDecimal.ZERO;

        Bid bid = new Bid();
        bid.setAuctionVehicleId(avId);
        currentPrice = bidService.queryMaxPriceByEntity(bid);

        if (auctionVehicle.getPlusRange() != null && !currentPrice.equals(BigDecimal.ZERO)) {
            bidPrice = currentPrice.add(BigDecimal.valueOf(auctionVehicle.getPlusRange().longValue()));
        } else {
            if (currentPrice.equals(BigDecimal.ZERO)) {
                currentPrice = auctionVehicle.getStartPrice();
            }
            bidPrice = currentPrice;
        }

        BigDecimal myMaxPrice = BigDecimal.ZERO;
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        if (userIdentity != null) {
            bid = new Bid();
            bid.setAuctionVehicleId(avId);
            bid.setBidderSid(userIdentity.getId());
            myMaxPrice = bidService.queryMaxPriceByEntity(bid);
        }

        result.put("success", true);
        result.put("maxPrice", currentPrice);
        result.put("myMaxPrice", myMaxPrice);
        result.put("bidPrice", bidPrice);
        result.put("avId", avId);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/online-batchbid/endtime", method = RequestMethod.POST)
    public void getEndTime(Integer avSid, HttpServletRequest request, HttpServletResponse response) {
        if (avSid == null) {
            throw new IllegalArgumentException();
        }
        Map<String, Object> result = Maps.newHashMap();

        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avSid);

        Date endTime;
        if (auctionVehicle.getOnlineEndTime() != null) {
            endTime = auctionVehicle.getOnlineEndTime();
        } else {
            endTime = auctionVehicle.getPlanEndTime();
        }
        long times = endTime.getTime() - new Date().getTime();
        if (times < 0) {
            times = 0;
        }
        result.put("times", times);

        result.put("success", true);
        ResponseUtils.writeJsonObject(response, result);
    }

	@RequestMapping(value = "/online-batchbid/addbatch", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult addBatch(Integer avId, Integer vId, Integer count,
			HttpServletRequest request, HttpServletResponse response) {
		if (null == avId || null == vId) {
			throw new IllegalArgumentException();
		}

		JsonResult result = new JsonResult();
		if (count != null && count >= MAX_COUNT) {	
				result.setSuccess(false);
				result.addExtra("error", "2");
				
				return result;
			
		}

		UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
		if (userIdentity == null) {
            result.setSuccess(false);
            result.addExtra("error", "1");
			return result;
		}

		// check if existed
		MemberVehicleBatchExample mvbExamp = new MemberVehicleBatchExample();
		MemberVehicleBatchExample.Criteria criteria = mvbExamp.createCriteria();
		criteria.andAvIdEqualTo(avId);
		criteria.andVehicleIdEqualTo(vId);
		criteria.andMemberSidEqualTo(userIdentity.getId());
		List<MemberVehicleBatch> mvbList = memberVehicleBatchService
				.selectByExample(mvbExamp);
		if (mvbList != null && mvbList.size() > 0) {
            result.setSuccess(false);
            result.addExtra("error", "3");
			return result;
		}

		Vehicle vehicle = vehicleService.selectByPrimaryKey(vId);

		MemberVehicleBatch mvb = new MemberVehicleBatch();
		//mvb.setId(UUIDUtil.getUUID());
		mvb.setMemberSid(userIdentity.getId());
		mvb.setAvId(avId);
		mvb.setVehicleId(vId);
		mvb.setCreatedTimestamp(new Date());
		mvb = memberVehicleBatchService.insert(mvb);

		if (mvb == null) {
		    result.setSuccess(false);
		} else {
		    result.setSuccess(true);
			result.addExtra("avSid", avId);
			result.addExtra("vehicle", vehicle);
			result.addExtra("mvbSid", mvb.getId());
		}
		return result;
	}

    public BigDecimal getMaxBidPriceByAV(Integer avId) {
        BigDecimal currentPrice;
        List<Bid> bidList = BizUtils.getBidList(bidService, avId, null, false);
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);

        if (bidList.isEmpty()) {
            if (auctionVehicle.getStartPrice() != null) {
                currentPrice = auctionVehicle.getStartPrice();
            } else {
                currentPrice = BigDecimal.ZERO;
            }
        } else {
            currentPrice = bidList.get(0).getPrice();
        }
        return currentPrice;
    }

    public BigDecimal getMaxBidPriceByAVandUser(Integer avId, String userId) {
        BigDecimal myBidPrice;
        List<Bid> myBidList = BizUtils.getBidList(bidService, avId, userId, false);
        if (myBidList.isEmpty()) {
            myBidPrice = BigDecimal.ZERO;
        } else {
            myBidPrice = myBidList.get(0).getPrice();
        }
        return myBidPrice;
    }

    public BigDecimal getBidPrice(Integer avId) {
        BigDecimal currentPrice;
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        List<Bid> bidList = BizUtils.getBidList(bidService, avId, null, false);

        if (bidList.isEmpty()) {
            if (auctionVehicle.getStartPrice() != null) {
                currentPrice = auctionVehicle.getStartPrice();
            } else {
                currentPrice = BigDecimal.ZERO;
            }
        } else {
            currentPrice = bidList.get(0).getPrice();
        }

        BigDecimal bidPrice;
        if (auctionVehicle.getPlusRange() != null && !bidList.isEmpty()) {
            bidPrice = currentPrice.add(BigDecimal.valueOf(auctionVehicle.getPlusRange().longValue()));
        } else {
            bidPrice = currentPrice;
        }
        return bidPrice;
    }

    public int checkBidedByVehicleAndUser(String userId, String vehicleSid) {
        return memberVehicleBatchService.checkBidedByVehicleAndUser(userId, Integer.parseInt(vehicleSid));
    }

}
