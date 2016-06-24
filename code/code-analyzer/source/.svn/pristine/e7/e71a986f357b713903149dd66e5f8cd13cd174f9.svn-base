package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.autostreets.biz.auction.enums.VehicleAgeRangeEnum;
import com.autostreets.biz.auction.enums.VehicleMileRangeEnum;
import com.autostreets.biz.auction.enums.VehiclePriceRangeEnum;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.MemberVehicleBatch;
import com.autostreets.biz.auction.model.MemberVehicleBatchExample;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.pagination.Pagination1;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.MemberVehicleBatchService;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.utils.BizUtils;
import com.autostreets.biz.auction.web.utils.StringUtil;
import com.autostreets.biz.auction.web.utils.UserIdentityUtils;
import com.autostreets.framework.common.web.utils.RequestUtils;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.model.Member;
import com.autostreets.service.MemberService;
import com.autostreets.service.ad.AdPositionsService;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 在线拍列表页
 * 
 * @author youpeng.zhang Date: 2015年7月14日 下午2:41:38
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/onlineauction")
public class OnlineAuctionController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnlineAuctionController.class);

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MemberVehicleFavoriteService memberVehicleFavoriteService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @Autowired
    private MemberVehicleBatchService memberVehicleBatchService;

    @Autowired
    private BidService bidService;

    @Autowired
    private AdPositionsService adPositionsService;

    @RequestMapping(value = "/index")
    public String index(@PathVariable @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Integer age, @RequestParam(required = false) Integer mileage,
            @RequestParam(required = false) String city, @RequestParam(required = false) boolean recommend,
            @RequestParam(required = false) Integer dateflag, @RequestParam(required = false) Integer status,
            @RequestParam(defaultValue = "1") int pageNumber, HttpServletRequest request, Model model) {

        int pageSize = 10;
        Pagination1<AuctionVehicle> page = auctionVehicleService.selectOnlinePage(price, age, mileage, city, recommend,
                dateflag, status, pageNumber, pageSize);
        model.addAttribute("city", city);
        if ((dateflag != null) && (dateflag != 0)) {
            if (dateflag == 1) { // 竞拍中
                model.addAttribute("dateflag", 1);
            } else if (dateflag == 2) { // 等待竞拍
                model.addAttribute("dateflag", 2);
            }
        }

        String priceDisp = "0";
        Boolean isSp = false;
        Set<Integer> favoriteVehicleIds = Sets.newHashSet();
        // Get memberVehicleBatch of current user
        List<MemberVehicleBatch> mvbList = new ArrayList<MemberVehicleBatch>();
        Set<Integer> avIds = Sets.newHashSet();

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String loginUserSid = null;
        if (userIdentity != null) {
            loginUserSid = userIdentity.getId();
        }
        if (StringUtils.isNotBlank(loginUserSid)) {

            MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
            MemberVehicleFavoriteExample.Criteria mvfeCriteria = mvfe.createCriteria();
            mvfeCriteria.andMemberSidEqualTo(loginUserSid);

            List<MemberVehicleFavorite> memberVehicleFavoriteList = memberVehicleFavoriteService.selectByExample(mvfe);
            for (MemberVehicleFavorite mvf : memberVehicleFavoriteList) {
                favoriteVehicleIds.add(mvf.getAvId());
            }

            Member member = memberService.selectByPrimaryKey(loginUserSid);
            // Check user category and level
            if ("商户".equals(member.getMemberCategory()) && "VIP1".equalsIgnoreCase(member.getMemberLevel())) {
                priceDisp = "1";
            } else {
                priceDisp = "0";
            }

            if ("商户".equals(member.getMemberCategory()) && "SP".equalsIgnoreCase(member.getMemberLevel())) {
                isSp = true;
            }

            MemberVehicleBatchExample mvbExample = new MemberVehicleBatchExample();
            MemberVehicleBatchExample.Criteria mvbCriteria = mvbExample.createCriteria();
            mvbCriteria.andMemberSidEqualTo(loginUserSid);
            mvbList = memberVehicleBatchService.selectByExample(mvbExample);

            if (mvbList != null && mvbList.size() > 0) {
                MemberVehicleBatch mvb = null;
                for (int i = 0; i < mvbList.size(); i++) {
                    mvb = mvbList.get(i);

                    avIds.add(mvb.getAvId());
                    Vehicle v = vehicleService.selectByPrimaryKey(mvb.getVehicleId());
                    mvb.setVehicle(v);
                }
            }
        }

        // Get the pop page switch
        String popValue = auctionDictionaryService.selectPopSwitch();
        model.addAttribute("priceDisp", priceDisp);
        model.addAttribute("isSp", isSp);
        model.addAttribute("popValue", popValue);
        model.addAttribute("price", price);
        model.addAttribute("age", age);
        model.addAttribute("mileage", mileage);
        // model.addAttribute("recommend", recommend ? 1 : 0);

        model.addAttribute("recommend", recommend);
        model.addAttribute("p", page);
        model.addAttribute("favoriteVehicleIds", favoriteVehicleIds);

        model.addAttribute("mvbList", mvbList);
        model.addAttribute("mvbCount", mvbList.size());
        model.addAttribute("avSids", avIds);
        model.addAttribute("auctionCount", auctionVehicleService.getOnlineAunctionCount());

        // 热门推荐
        List<AuctionVehicle> recommends = auctionVehicleService.findAuctionVehicleRecommend();
        
        //添加广告2016-6-3 14:00:28
        model.addAttribute("topAdv", adPositionsService.getPositionAd(45));
        //

        model.addAttribute("recommends", recommends);
        return "online-auction/index";
    }

    @RequestMapping(value = "/{avId}", method = RequestMethod.GET)
    public String show(@PathVariable @ModelAttribute("avId") Integer avId, HttpServletRequest request,
            HttpServletResponse response, Model model) {

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String loginUserSid = null;
        if (userIdentity != null) {
            loginUserSid = userIdentity.getId();
        }
        Map<String, Object> map = auctionVehicleService.loadVehicleInfo(avId, loginUserSid);
        if (map == null || map.get("auctionVehicle") == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        model.addAttribute("av", map);

        return "online-auction/show";
    }

    @RequestMapping(value = "/bid/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addBid(Integer avId, BigDecimal price, HttpServletRequest request, HttpServletResponse response) {
        if (null == avId || price == null) {
            throw new IllegalArgumentException();
        }
        JsonResult jr = null;
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String loginUserSid = null;
        if (userIdentity != null) {
            loginUserSid = userIdentity.getId();
        }
        // String username = (String) loginUserMap.get("username");

        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (auctionVehicle == null) {
            throw new RuntimeException();
        }

        if (auctionVehicle.getStatus().intValue() != 5) {
            jr = new JsonResult(false);
            return jr;
        }

        Member member = memberService.selectByPrimaryKey(loginUserSid);

        if (!("商户".equals(member.getMemberCategory()) && "VIP1".equalsIgnoreCase(member.getMemberLevel()))) {
            jr = new JsonResult(false, "对不起，只有认证商户才有资格参加竞拍");
            return jr;
        }
        if (!"0".equals(member.getEnable())) {
        	jr = new JsonResult(false, "对不起，您暂时没有权限出价，如有问题，请联系客服");
            return jr;
		}

        Bid bid = new Bid();
        bid.setAuctionVehicleId(avId);
        bid.setBidderSid(loginUserSid);
        bid.setBidderUsername(member.getUsername());
        bid.setBidderName(member.getName());
        bid.setBidTimestamp(new Date());
        bid.setOriginPrice(price);
        bid.setPrice(price);
        bid.setIp(RequestUtils.getClientIp(request));
        bid.setMsg(false);
        bid.setContent(StringUtil.mask(bid.getBidderUsername()) + " 出价 " + bid.getPrice().toString() + " 元");

        boolean success = bidService.createOnlineOnlyBid(bid);
        if (!success) {
            jr = new JsonResult(false, "出价慢了，请重新出价");
            return jr;
        }

        List<Bid> bidList = BizUtils.getBidList(bidService, avId, null, false);
        int commission = BizUtils.calculateCommission(auctionDictionaryService, price, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(price, commission, auctionVehicle);

        Map<String, Object> result = Maps.newHashMap();
        result.put("price", price);
        result.put("commission", commission);
        result.put("totalPrice", totalPrice);
        result.put("bid", bid);
        result.put("bidCount", bidList.size());

        AuctionVehicle av = auctionVehicleService.selectByPrimaryKey(avId);
        long seconds = (av.getOnlineEndTime().getTime() - new Date().getTime()) / 1000;
        if (seconds < 0) {
            seconds = 0;
        }
        result.put("seconds", seconds);

        jr = new JsonResult(true, result);
        return jr;
    }

    @RequestMapping(value = "/deal", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deal(Integer avId, HttpServletRequest request, HttpServletResponse response) {
        JsonResult jr = null;

        if (null == avId) {
            jr = new JsonResult(false, "1");
            return jr;
        }

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String loginUserSid = null;
        if (userIdentity != null) {
            loginUserSid = userIdentity.getId();
        }

        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (auctionVehicle == null) {
            jr = new JsonResult(false, "3");
            return jr;
        }

        // status = 3
        if (auctionVehicle.getStatus().intValue() != 3) {
            jr = new JsonResult(false, "4");
            return jr;
        }

        // 当前用户是否是最高出价者，且在出价成交时间范围内
        boolean isTopPrice = false;
        List<Bid> bidList = BizUtils.getBidList(bidService, avId, null, false); // 获得拍品的出价记录
        List<Bid> myBidList = BizUtils.getBidList(bidService, avId, loginUserSid, false); // 当前用户的出价记录

        isTopPrice = BizUtils.isTopPrice(bidList, myBidList); // 是否是最高出价者
        if (!isTopPrice) {
            jr = new JsonResult(false, "5");
            return jr;
        }

        Integer intPriceDiff = auctionDictionaryService.selectPriceDiff();
        Integer intTimeDiff = auctionDictionaryService.selectTimeDiff();

        // 是否在限定的时间段内
        Date endTime;
        if (auctionVehicle.getOnlineEndTime() != null) {
            endTime = auctionVehicle.getOnlineEndTime();
        } else {
            endTime = auctionVehicle.getPlanEndTime();
        }

        Date newDate = DateUtils.addMinutes(endTime, intTimeDiff);
        Date currDate = new Date();
        if (newDate.before(currDate)) {
            jr = new JsonResult(false, "6");
            return jr;
        }

        // 差价是否在设置的差价范围内
        BigDecimal myBidPrice; // 当前用户的最新出价
        if (myBidList == null || myBidList.isEmpty()) {
            myBidPrice = BigDecimal.ZERO;
        } else {
            myBidPrice = myBidList.get(0).getPrice();
        }

        if (auctionVehicle.getReservePrice().subtract(myBidPrice).compareTo(BigDecimal.valueOf(intPriceDiff)) > 0) {
            jr = new JsonResult(false, "7");
            return jr;
        }

        Member member = memberService.selectByPrimaryKey(loginUserSid);

        Bid bid = new Bid();
        bid.setAuctionVehicleId(avId);
        bid.setBidderSid(loginUserSid);
        bid.setBidderUsername(member.getUsername());
        bid.setBidderName(member.getName());
        bid.setBidTimestamp(new Date());
        bid.setOriginPrice(auctionVehicle.getReservePrice());
        bid.setPrice(auctionVehicle.getReservePrice());
        bid.setIp(RequestUtils.getClientIp(request));
        bid.setMsg(false);
        bid.setContent(StringUtil.mask(bid.getBidderUsername()) + " 出价 " + bid.getPrice().toString() + " 元");
        boolean result = false;
        try {
            result = auctionVehicleService.updateOnlineComplete(bid, avId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        if (result) {
            jr = new JsonResult(true);
            return jr;
        } else {
            jr = new JsonResult(false, "4");
            return jr;
        }
    }

    @RequestMapping(value = "/sync", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult sync(Integer avId, HttpServletRequest request, HttpServletResponse response) {
        JsonResult jr = null;
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);

        List<Bid> myBidList = Lists.newArrayList();
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String loginUserSid = null;
        if (userIdentity != null) {
            loginUserSid = userIdentity.getId();
        }
        if (avId == null) {
            return null;
        }
        myBidList = BizUtils.getBidList(bidService, avId, loginUserSid, false);
        // 获得我的出价
        BigDecimal myBidPrice = BigDecimal.ZERO;
        if (myBidList.isEmpty()) {
            myBidPrice = BigDecimal.ZERO;
        } else {
            myBidPrice = myBidList.get(0).getPrice();
        }

        List<Bid> bidList = BizUtils.getBidList(bidService, avId, null, false);

        BigDecimal currentPrice;
        if (bidList.isEmpty()) {
            if (auctionVehicle.getStartPrice() != null) {
                currentPrice = auctionVehicle.getStartPrice();
            } else {
                currentPrice = BigDecimal.ZERO;
            }
        } else {
            currentPrice = bidList.get(0).getPrice();
        }

        int commission = BizUtils.calculateCommission(auctionDictionaryService, currentPrice, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(currentPrice, commission, auctionVehicle);

        BigDecimal bidPrice;
        if (auctionVehicle.getPlusRange() != null && !bidList.isEmpty()) {
            bidPrice = currentPrice.add(BigDecimal.valueOf(auctionVehicle.getPlusRange().longValue()));
        } else {
            bidPrice = currentPrice;
        }

        Map<String, Object> result = Maps.newHashMap();
        result.put("currentPrice", currentPrice);
        result.put("commission", commission);
        result.put("totalPrice", totalPrice);
        result.put("hasBid", bidList.isEmpty() ? 0 : 1);
        result.put("bidCount", bidList.size());
        result.put("bidPrice", bidPrice);
        result.put("isTopPrice", BizUtils.isTopPrice(bidList, myBidList));
        result.put("myBidPrice", myBidPrice);
        result.put("status", auctionVehicle.getStatus()); // status can be
                                                          // changed

        Date endTime;
        if (auctionVehicle.getOnlineEndTime() != null) {
            endTime = auctionVehicle.getOnlineEndTime();
        } else {
            endTime = auctionVehicle.getPlanEndTime();
        }
        long seconds = (endTime.getTime() - new Date().getTime()) / 1000;
        if (seconds < 0) {
            seconds = 0;
        }
        result.put("seconds", seconds);

        jr = new JsonResult(true, result);
        return jr;
    }

    @RequestMapping(value = "/thumbImg", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getThumbImg(String spec, String imgUrl, HttpServletRequest request, HttpServletResponse response) {
        JsonResult jr = null;
        String strImgUrl = getThumbImgUrl(spec, imgUrl);
        if (strImgUrl == null) {
            strImgUrl = "";
        }

        jr = new JsonResult(true);
        jr.setData(strImgUrl);
        return jr;
    }

    public String getUrl(String name, String value) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String url = RequestUtils.getRequestURIWithQueryString(request);

        String[] names = null;
        String[] values = null;
        if (StringUtils.isNotBlank(name)) {
            names = name.split(",");
        }
        if (StringUtils.isNotBlank(value)) {
            values = value.split(",");
        }

        Map<String, String> mapParam = Maps.newHashMap();
        if (names != null && (names.length > 0)) {
            for (int i = 0; i < names.length; i++) {
                if (StringUtils.isNotBlank(names[i])) {
                    String nameTemp = names[i].trim();
                    String valueTemp = "";
                    try {
                        valueTemp = values[i].trim();
                    } catch (Exception ex) {
                        LOGGER.error(ex.getMessage(), ex);
                        valueTemp = "";
                    }
                    mapParam.put(nameTemp, valueTemp);
                }
            }
        }

        return RequestUtils.replaceParamValue(url, mapParam);
    }

    public List<TreeMap<String, String>> paramList(int type) {
        if (type == 1) {
            return VehiclePriceRangeEnum.getList();
        } else if (type == 2) {
            return VehicleAgeRangeEnum.getList();
        } else if (type == 3) {
            return VehicleMileRangeEnum.getList();
        } else {
            return Lists.newArrayList();
        }
    }

    public List<Map<String, Boolean>> getCityList() {
        return auctionVehicleService.getCityListforAuction();
    }
}