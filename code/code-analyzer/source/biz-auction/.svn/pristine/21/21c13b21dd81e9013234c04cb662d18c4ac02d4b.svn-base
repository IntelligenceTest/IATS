package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.autostreets.biz.auction.enums.VehicleAgeRangeEnum;
import com.autostreets.biz.auction.enums.VehicleMileRangeEnum;
import com.autostreets.biz.auction.enums.VehiclePriceRangeEnum;
import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.utils.BizUtils;
import com.autostreets.biz.auction.web.utils.StringUtil;
import com.autostreets.biz.auction.web.utils.UserIdentityUtils;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.core.JsonResult;
import com.autostreets.framework.common.web.utils.RequestUtils;
import com.autostreets.model.Member;
import com.autostreets.service.MemberService;
import com.autostreets.web.util.ResponseUtils;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

@Controller
public class AuctionController extends PaginationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionController.class);

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private VehicleService auctVehicleService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private MemberVehicleFavoriteService memberVehicleFavoriteService;

    @Autowired
    private BidService bidService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private AuctionDictionaryService dictionaryService;

    @RequestMapping(value = "/screen/{auctionSid}", method = RequestMethod.GET)
    public String screen(@PathVariable @ModelAttribute("auctionSid") Integer auctionSid, Model model) {
        Auction auction = auctionService.selectByPrimaryKey(auctionSid);
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(auction.getCurrentAvId());
        if (auctionVehicle == null) {
            return null;
        }
        Vehicle vehicle = auctVehicleService.selectByPrimaryKey(auctionVehicle.getVehicleId());

        List<Bid> bidList = BizUtils.getBidList(bidService, auctionVehicle.getId(), null, false);

        String bidType = "起拍价"; // 出价类型：现场出价和网络出价
        BigDecimal currentPrice;
        if (bidList.isEmpty()) {
            if (auctionVehicle.getStartPrice() != null) {
                currentPrice = auctionVehicle.getStartPrice();
            } else {
                currentPrice = BigDecimal.ZERO;
            }
        } else {
            if ("000".equals(bidList.get(0).getBidderSid())) {
                bidType = "现场出价";
            } else {
                bidType = "网络出价";
            }
            currentPrice = bidList.get(0).getPrice();
        }
        StringBuffer sb = new StringBuffer();
        if (!Strings.isNullOrEmpty(vehicle.getBrand())) {
            sb.append(vehicle.getBrand());
            sb.append(" ");
        }
        if (!Strings.isNullOrEmpty(vehicle.getVehicleModel())) {
            sb.append(vehicle.getVehicleModel());
        }
        if (!Strings.isNullOrEmpty(vehicle.getSweptVolumeStandard())
                && vehicle.getSweptVolumeStandard().startsWith("欧")) {
            sb.append("(进口)");
            sb.append(" ");
        }

        /**
         * 修改二手车车型和销售名称重复问题
         */
        String selledName = vehicle.getSelledName();
        String vehicleModel = vehicle.getVehicleModel();
        if (StringUtils.isNotBlank(selledName) && selledName.startsWith(vehicleModel)) {
            selledName = selledName.replace(vehicleModel, "");
        }
        if (!Strings.isNullOrEmpty(selledName)) {
            sb.append(selledName);
        }

        // 计算佣金、办证费、出库费、总价 added by HCF
        int commission = BizUtils.calculateCommission(dictionaryService, currentPrice, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(currentPrice, commission, auctionVehicle);

        model.addAttribute("commission", commission);
        model.addAttribute("totalPrice",
                totalPrice.divide(BigDecimal.valueOf(10000L), 2, BigDecimal.ROUND_CEILING).toString());
        model.addAttribute("licenseFee", (auctionVehicle.getLicenseFee() == null) ? 0 : auctionVehicle.getLicenseFee());
        model.addAttribute("exWarehouseFee",
                (auctionVehicle.getExWarehouseFee() == null) ? 0 : auctionVehicle.getExWarehouseFee());

        model.addAttribute("title", sb.toString());
        model.addAttribute("photoUrl", vehicle.getFirstPhotoUrl());
        model.addAttribute("orderNumber", String.format("%03d", auctionVehicle.getAuctionVehicleOrder()));
        model.addAttribute("licenseCode", vehicle.getLicenseCode() == null ? "---" : vehicle.getLicenseCode());
        model.addAttribute("currentPrice",
                currentPrice.divide(BigDecimal.valueOf(10000L), 2, BigDecimal.ROUND_CEILING).toString());
        model.addAttribute("bidType", bidType);
        model.addAttribute("source", vehicle.getSource());
        return "auction/screen";
    }

    @RequestMapping(value = "/screen-refresh", method = RequestMethod.GET)
    public void screenRefresh(Integer auctionSid, HttpServletResponse response) {
        Auction auction = auctionService.selectByPrimaryKey(auctionSid);
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(auction.getCurrentAvId());
        Vehicle vehicle = auctVehicleService.selectByPrimaryKey(auctionVehicle.getVehicleId());

        List<Bid> bidList = BizUtils.getBidList(bidService, auctionVehicle.getId(), null, false);

        String bidType = "起拍价"; // 出价类型：现场出价和网络出价
        BigDecimal currentPrice;
        if (bidList.isEmpty()) {
            if (auctionVehicle.getStartPrice() != null) {
                currentPrice = auctionVehicle.getStartPrice();
            } else {
                currentPrice = BigDecimal.ZERO;
            }
        } else {
            if ("000".equals(bidList.get(0).getBidderSid())) {
                bidType = "现场出价";
            } else {
                bidType = "网络出价";
            }
            currentPrice = bidList.get(0).getPrice();
        }

        StringBuffer sb = new StringBuffer();
        if (!Strings.isNullOrEmpty(vehicle.getBrand())) {
            sb.append(vehicle.getBrand());
            sb.append(" ");
        }
        if (!Strings.isNullOrEmpty(vehicle.getVehicleModel())) {
            sb.append(vehicle.getVehicleModel());
        }
        if (!Strings.isNullOrEmpty(vehicle.getSweptVolumeStandard())
                && vehicle.getSweptVolumeStandard().startsWith("欧")) {
            sb.append("(进口)");
            sb.append(" ");
        }

        /**
         * 修改二手车车型和销售名称重复问题
         */
        String selledName = vehicle.getSelledName();
        String vehicleModel = vehicle.getVehicleModel();
        if (StringUtils.isNotBlank(selledName) && selledName.startsWith(vehicleModel)) {
            selledName = selledName.replace(vehicleModel, "");
        }
        if (!Strings.isNullOrEmpty(selledName)) {
            sb.append(selledName);
        }

        String hasPhoto = "0";
        String photoUrl = "";
        if (StringUtils.isNotBlank(vehicle.getFirstPhotoUrl())) {
            photoUrl = getThumbImgUrl("520X390", vehicle.getFirstPhotoUrl());
            if (StringUtils.isBlank(photoUrl)) {
                hasPhoto = "0";
            } else {
                hasPhoto = "1";
            }
        }

        Date currentDate = new Date();
        String hasEnd = "0";
        if (auctionVehicle.getOnlineEndTime() != null && !auctionVehicle.getOnlineEndTime().after(currentDate)) {
            hasEnd = "1";
        }

        // 计算佣金、办证费、出库费、总价 added by HCF
        int commission = BizUtils.calculateCommission(dictionaryService, currentPrice, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(currentPrice, commission, auctionVehicle);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);
        result.put("title", sb.toString());

        result.put("hasPhoto", hasPhoto);
        result.put("photoUrl", photoUrl);

        result.put("orderNumber", String.format("%03d", auctionVehicle.getAuctionVehicleOrder()));
        result.put("licenseCode", vehicle.getLicenseCode() == null ? "---" : vehicle.getLicenseCode());
        result.put("currentPrice",
                currentPrice.divide(BigDecimal.valueOf(10000L), 2, BigDecimal.ROUND_CEILING).toString());
        result.put("bidType", bidType);
        result.put("hasEnd", hasEnd);
        result.put("source", vehicle.getSource());
        result.put("commission", commission);
        result.put("totalPrice", totalPrice.divide(BigDecimal.valueOf(10000L), 2, BigDecimal.ROUND_CEILING).toString());
        result.put("licenseFee", (auctionVehicle.getLicenseFee() == null) ? 0 : auctionVehicle.getLicenseFee());
        result.put("exWarehouseFee",
                (auctionVehicle.getExWarehouseFee() == null) ? 0 : auctionVehicle.getExWarehouseFee());

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/screen/{auctionSid}/list", method = RequestMethod.GET)
    public String screenList(@PathVariable @ModelAttribute("auctionSid") Integer auctionSid, Model model) {
        Auction auction = auctionService.selectByPrimaryKey(auctionSid);
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(auction.getCurrentAvId());

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria criteria = ave.createCriteria();
        criteria.andAuctionIdEqualTo(auctionSid);
        ave.setOrderByClause("auction_vehicle_order");

        List<AuctionVehicle> auctionVehicleList = auctionVehicleService.selectByExample(ave);
        Vehicle vehicle;
        if (auctionVehicleList != null && auctionVehicleList.size() > 0) {
            for (AuctionVehicle av : auctionVehicleList) {
                vehicle = auctVehicleService.selectByPrimaryKey(av.getVehicleId());
                av.setVehicle(vehicle);
            }
        }

        model.addAttribute("avList", auctionVehicleList);
        model.addAttribute("currentAV", auctionVehicle);

        return "auction/screen-list";
    }

    @RequestMapping(value = "/screen-listrefresh", method = RequestMethod.GET)
    public void screenListRefresh(Integer auctionSid, HttpServletResponse response) {
        Auction auction = auctionService.selectByPrimaryKey(auctionSid);
        Integer currentAvSid = auction.getCurrentAvId();
        // if (currentAvSid == null) {
        // currentAvSid = "";
        // }

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);
        result.put("currentAvSid", currentAvSid == null ? "" : currentAvSid.toString());

        ResponseUtils.writeJsonObject(response, result);
    }

    // @RequestMapping(value = "/auction", method = RequestMethod.GET)
    // public String index(@RequestParam(defaultValue = "1") int pageNumber,
    // HttpServletRequest request, Model model) {
    // int pageSize = 10;
    // AuctionExample ae = new AuctionExample();
    // AuctionExample.Criteria aeCriteria = ae.createCriteria();
    // aeCriteria.andStatusNotEqualTo("0");
    //
    // int count = auctionService.countByExample(ae);
    //
    // ae.setOrderByClause("start_timestamp desc");
    //
    // if (count % pageSize == 0) {
    // if (count == 0) {
    // pageNumber = 1;
    // } else {
    // if (pageNumber > (count / pageSize)) {
    // pageNumber = count / pageSize;
    // }
    // }
    // } else {
    // if (pageNumber > (count / pageSize + 1)) {
    // pageNumber = count / pageSize + 1;
    // }
    // }
    //
    // Pagination pagination = new Pagination();
    // pagination.setCurrent(pageNumber);
    // pagination.setCount(count);
    //
    // ae.setPagination(pagination);
    //
    // List<Auction> auctionList = auctionService.selectByExample(ae);
    //
    // // Get the pop page switch
    // String popValue = dictionaryService.selectPopSwitch();
    //
    // model.addAttribute("popValue", popValue);
    // model.addAttribute("p", Pagination1Utils.newPagination(pageSize,
    // pageNumber, count, auctionList));
    //
    // return "auction/index";
    // }

    // @RequestMapping(value = "/auction/{sid}", method = RequestMethod.GET)
    // public String show(@PathVariable @ModelAttribute("sid") String sid,
    // @RequestParam(required = false) Integer price,
    // @RequestParam(required = false) Integer age, @RequestParam(required =
    // false) Integer mileage,
    // @RequestParam(defaultValue = "1") int pageNumber, HttpServletRequest
    // request, Model model) {
    // int pageSize = 10;
    // Auction auction = auctionService.selectByPrimaryKey(sid);
    //
    // Map<String, Object> params = Maps.newHashMap();
    // params.put("auctionSid", sid);
    // if (price != null && price != 0) {
    // String range = VehiclePriceRangeEnum.lookup(price);
    // String[] ss = range.split(",");
    // if (!Strings.isNullOrEmpty(ss[0])) {
    // params.put("startPriceMin", new
    // BigDecimal(ss[0]).multiply(BigDecimal.valueOf(10000)));
    // }
    // if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
    // params.put("startPriceMax", new
    // BigDecimal(ss[1]).multiply(BigDecimal.valueOf(10000)));
    // }
    // }
    // if (age != null && age != 0) {
    // String range = VehicleAgeRangeEnum.lookup(age);
    // String[] ss = range.split(",");
    // if (!Strings.isNullOrEmpty(ss[0])) {
    // params.put("vehicleAgeMin", new BigDecimal(ss[0]));
    // }
    // if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
    // params.put("vehicleAgeMax", new BigDecimal(ss[1]));
    // }
    // }
    // if (mileage != null && mileage != 0) {
    // String range = VehicleMileRangeEnum.lookup(mileage);
    // String[] ss = range.split(",");
    // if (!Strings.isNullOrEmpty(ss[0])) {
    // params.put("displayMileageMin", new BigDecimal(ss[0]));
    // }
    // if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
    // params.put("displayMileageMax", new BigDecimal(ss[1]));
    // }
    // }
    //
    // int count = auctionVehicleService.countAuctionVehicle(params);
    //
    // if (count % pageSize == 0) {
    // if (count == 0) {
    // pageNumber = 1;
    // } else {
    // if (pageNumber > (count / pageSize)) {
    // pageNumber = count / pageSize;
    // }
    // }
    // } else {
    // if (pageNumber > (count / pageSize + 1)) {
    // pageNumber = count / pageSize + 1;
    // }
    // }
    //
    // params.put("offset", (pageNumber - 1) * pageSize);
    // params.put("limit", pageSize);
    //
    // List<AuctionVehicle> auctionVehicleList =
    // auctionVehicleService.findAuctionVehicle(params);
    //
    // for (AuctionVehicle av : auctionVehicleList) {
    // Vehicle vehicle = vehicleService.selectByPrimaryKey(av.getVehicleSid());
    // av.setVehicle(vehicle);
    // }
    //
    // UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
    //
    // String userVip = "0";
    // Set<String> favoriteVehicleIds = Sets.newHashSet();
    // if (userIdentity != null) {
    // Member member = memberService.selectByPrimaryKey(userIdentity.getId());
    //
    // // if (!("商户".equals(member.getMemberCategory()) &&
    // // "VIP1".equalsIgnoreCase(member.getMemberLevel()))) {
    // if (!("商户".equals(member.getMemberCategory()) &&
    // ("VIP1".equalsIgnoreCase(member.getMemberLevel())
    // || "SP".equalsIgnoreCase(member.getMemberLevel())))) {
    // userVip = "0";
    // } else {
    // userVip = "1";
    // }
    //
    // MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
    // MemberVehicleFavoriteExample.Criteria mvfeCriteria =
    // mvfe.createCriteria();
    // mvfeCriteria.andMemberSidEqualTo(userIdentity.getId());
    //
    // List<MemberVehicleFavorite> memberVehicleFavoriteList =
    // memberVehicleFavoriteService.selectByExample(mvfe);
    // for (MemberVehicleFavorite mvf : memberVehicleFavoriteList) {
    // favoriteVehicleIds.add(mvf.getAvSid());
    // }
    // }
    //
    // model.addAttribute("price", price);
    // model.addAttribute("age", age);
    // model.addAttribute("mileage", mileage);
    // model.addAttribute("auction", auction);
    // model.addAttribute("p", Pagination1Utils.newPagination(pageSize,
    // pageNumber, count, auctionVehicleList));
    // model.addAttribute("favoriteVehicleIds", favoriteVehicleIds);
    // model.addAttribute("userVip", userVip);
    //
    // return "auction/show";
    // }

    @RequestMapping(value = "/auction/{sid}/live", method = RequestMethod.GET)
    public String liveShow(@PathVariable @ModelAttribute("sid") Integer sid, HttpServletRequest request, Model model) {
        Auction auction = auctionService.selectByPrimaryKey(sid);
        if (!auction.getStatus().equals(2)) {
            return "redirect:/";
        }
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(auction.getCurrentAvId());
        Integer vehicleId = auctionVehicle.getVehicleId();
        Vehicle v = auctVehicleService.selectByPrimaryKey(vehicleId);
        VehicleInfo vi = auctVehicleService.selectVehicleInfoById(vehicleId);
        v.setRegisterLicenseYears(vi.getProducedYears());
        v.setTransmissionType(vi.getTransmissionType());
        v.setUsingModel(vi.getUsingModel());
        auctionVehicle.setVehicle(v);

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andAuctionIdEqualTo(sid);

        ave.setOrderByClause("auction_vehicle_order");

        List<AuctionVehicle> auctionVehicleList = auctionVehicleService.selectByExample(ave);
        Vehicle vehicle;
        for (AuctionVehicle av : auctionVehicleList) {
            vehicle = auctVehicleService.selectByPrimaryKey(av.getVehicleId());
            av.setVehicle(vehicle);
        }

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);

        Member member = null;
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        }
        String userVip = "0";
        Set<String> favoriteVehicleIds = Sets.newHashSet();
        List<Bid> myBidList = Lists.newArrayList();
        if (StringUtils.isNotBlank(memberId)) {
            MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
            MemberVehicleFavoriteExample.Criteria mvfeCriteria = mvfe.createCriteria();
            mvfeCriteria.andMemberSidEqualTo(memberId);

            List<MemberVehicleFavorite> memberVehicleFavoriteList = memberVehicleFavoriteService.selectByExample(mvfe);
            for (MemberVehicleFavorite mvf : memberVehicleFavoriteList) {
                favoriteVehicleIds.add(String.valueOf(mvf.getAvId()));
            }
            myBidList = BizUtils.getBidList(bidService, auctionVehicle.getId(), memberId, false);
            member = memberService.selectByPrimaryKey(memberId);
            if (!("商户".equals(member.getMemberCategory()) && ("VIP1".equalsIgnoreCase(member.getMemberLevel())
                    || "SP".equalsIgnoreCase(member.getMemberLevel())))) {
                userVip = "0";
            } else {
                userVip = "1";
            }
        } else {
            model.addAttribute("showProxyPrice", false);
        }

        List<Bid> bidList = BizUtils.getBidList(bidService, auctionVehicle.getId(), null, false);

        model.addAttribute("userVip", userVip);
        model.addAttribute("auction", auction);
        model.addAttribute("auctionVehicleList", auctionVehicleList);
        model.addAttribute("auctionVehicle", auctionVehicle);
        model.addAttribute("favoriteVehicleIds", favoriteVehicleIds);
        model.addAttribute("bidList", bidList);
        model.addAttribute("myBidList", myBidList);
        model.addAttribute("isTopPrice", BizUtils.isTopPrice(bidList, myBidList));

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

        model.addAttribute("currentPrice", currentPrice);

        BigDecimal myBidPrice;
        if (myBidList.isEmpty()) {
            myBidPrice = BigDecimal.ZERO;
        } else {
            myBidPrice = myBidList.get(0).getPrice();
        }

        model.addAttribute("myBidPrice", myBidPrice);

        BigDecimal bidPrice;
        if (auctionVehicle.getPlusRange() != null && !bidList.isEmpty()) {
            bidPrice = currentPrice.add(BigDecimal.valueOf(auctionVehicle.getPlusRange().longValue()));
        } else {
            bidPrice = currentPrice;
        }

        model.addAttribute("hasBid", bidList.isEmpty() ? 0 : 1);
        model.addAttribute("bidPrice", bidPrice);

        int commission = BizUtils.calculateCommission(dictionaryService, currentPrice, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(currentPrice, commission, auctionVehicle);

        model.addAttribute("commission", commission);
        model.addAttribute("totalPrice", totalPrice);

        Date currentDate = new Date();
        boolean bidActive;
        if (auctionVehicle.getStatus().equals(5) && (auctionVehicle.getOnlineEndTime() == null
                || auctionVehicle.getOnlineEndTime().after(currentDate))) {
            bidActive = true;

            if (auctionVehicle.getOnlineEndTime() != null && auctionVehicle.getOnlineEndTime().after(currentDate)) {
                model.addAttribute("seconds",
                        (auctionVehicle.getOnlineEndTime().getTime() - currentDate.getTime()) / 1000);
            }
        } else {
            bidActive = false;
        }

        if (member != null && "商户".equals(member.getMemberCategory())
                && "SP".equalsIgnoreCase(member.getMemberLevel())) {
            bidActive = false;
        }

        model.addAttribute("bidActive", bidActive);

        model.addAttribute("bidListWithMsg", BizUtils.getBidList(bidService, auctionVehicle.getId(), null, true));

        return "auction/live-show";
    }

    @RequestMapping(value = "/member/bid/add", method = RequestMethod.POST)
    public void addBid(Integer avId, BigDecimal price, HttpServletRequest request, HttpServletResponse response) {
        if (avId == null || price == null) {
            throw new IllegalArgumentException();
        }

        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (auctionVehicle == null) {
            throw new RuntimeException();
        }

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        }
        if (StringUtils.isBlank(memberId)) {
            Map<String, Object> result = Maps.newHashMap();
            result.put("success", false);
            result.put("error", "1");
            ResponseUtils.writeJsonObject(response, result);
            return;
        }

        if (!auctionVehicle.getStatus().equals(5)) {
            Map<String, Object> result = Maps.newHashMap();
            result.put("success", false);
            result.put("error", "拍卖会暂停中，暂停出价");
            ResponseUtils.writeJsonObject(response, result);
            return;
        }

        Member member = memberService.selectByPrimaryKey(memberId);

        if (!("商户".equals(member.getMemberCategory()) && "VIP1".equalsIgnoreCase(member.getMemberLevel()))) {
            Map<String, Object> result = Maps.newHashMap();
            result.put("success", false);
            result.put("error", "对不起，只有认证商户才有资格参加竞拍");
            ResponseUtils.writeJsonObject(response, result);
            return;
        }
        if (!"0".equals(member.getEnable())) {
        	Map<String, Object> result = Maps.newHashMap();
            result.put("success", false);
            result.put("error", "对不起，您暂时没有权限出价，如有问题，请联系客服");
            ResponseUtils.writeJsonObject(response, result);
            return;
		}

        Bid bid = new Bid();
        bid.setAuctionVehicleId(avId);
        bid.setBidderSid(memberId);
        bid.setBidderUsername(member.getUsername());
        bid.setBidderName(member.getName());
        bid.setBidTimestamp(new Date());
        bid.setOriginPrice(price);
        bid.setPrice(price);
        bid.setIp(RequestUtils.getClientIp(request));
        bid.setMsg(false);
        bid.setContent(StringUtil.mask(bid.getBidderUsername()) + " 出价 " + bid.getPrice().toString() + " 元");

        boolean success = bidService.createOnlineBid(bid);

        if (!success) {
            Map<String, Object> result = Maps.newHashMap();
            result.put("success", false);
            result.put("error", "出价慢了，请重新出价");
            ResponseUtils.writeJsonObject(response, result);
            return;
        }

        int commission = BizUtils.calculateCommission(dictionaryService, price, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(price, commission, auctionVehicle);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);
        result.put("price", price);
        result.put("commission", commission);
        result.put("totalPrice", totalPrice);
        result.put("bid", bid);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/auction/sync", method = RequestMethod.GET)
    public void sync(Integer avId, HttpServletRequest request, HttpServletResponse response) {
        if (avId == null) {
            throw new IllegalArgumentException("参数异常!");
        }
        AuctionVehicle currentAuctionVehicle = auctionVehicleService.getAuctionVehicleAndVehicle(avId);// 当前拍品信息
        if (currentAuctionVehicle == null) {
            return;
        }
        Auction auction = auctionService.selectByPrimaryKey(currentAuctionVehicle.getAuctionId());// 拍卖会信息
        if (auction == null) {
            return;
        }

        AuctionVehicle auctionVehicle = null;
        if (!currentAuctionVehicle.getId().equals(auction.getCurrentAvId())) {
            auctionVehicle = auctionVehicleService.getAuctionVehicleAndVehicle(auction.getCurrentAvId());
        } else {
            auctionVehicle = currentAuctionVehicle;
        }

        boolean currentAvExists = false;
        if (auctionVehicle.getStatus().equals(5)) {
            currentAvExists = true;
        }

        int currentAvIndex = auctionVehicle.getAuctionVehicleOrder() - 1;

        // 当前拍卖车辆已更换, 添加需要局部刷新当前页面的详情信息部分 modified by HCF
        int chgFlag = 0;
        String imgUrl = "";

        if (StringUtils.isNotBlank(auctionVehicle.getVehicle().getFirstPhotoUrl())) {
            imgUrl = getThumbImgUrl("320X240", auctionVehicle.getVehicle().getFirstPhotoUrl());
        }

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);

        Bid bid = bidService.getCurrentHighestPrice(avId, (userIdentity == null ? "" : userIdentity.getId()));// 查询当前用户最高出价、当前拍品最高出价人

        BigDecimal myBidPrice;
        if (bid == null || bid.getPrice() == null) {
            myBidPrice = BigDecimal.ZERO;
        } else {
            myBidPrice = bid.getPrice();
        }

        BigDecimal currentPrice;
        String currentBidderSid = "";
        if (bid == null) {
            if (auctionVehicle.getStartPrice() != null) {
                currentPrice = auctionVehicle.getStartPrice();
            } else {
                currentPrice = BigDecimal.ZERO;
            }
        } else {
            currentPrice = auctionVehicle.getMaxBidPrice();
            currentBidderSid = bid.getBidderSid();
        }

        int commission = BizUtils.calculateCommission(dictionaryService, currentPrice, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(currentPrice, commission, auctionVehicle);

        List<Bid> bidListWithMsg = BizUtils.getBidList(bidService, auctionVehicle.getId(), null, true);

        BigDecimal bidPrice;
        if (auctionVehicle.getPlusRange() != null && bid != null) {
            bidPrice = currentPrice.add(BigDecimal.valueOf(auctionVehicle.getPlusRange().longValue()));
        } else {
            bidPrice = currentPrice;
        }

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);
        result.put("auctionVehicle", auctionVehicle);
        result.put("currentAvExists", currentAvExists);
        result.put("currentAvIndex", currentAvIndex);
        result.put("currentPrice", currentPrice);
        result.put("currentBidderSid", currentBidderSid);
        result.put("commission", commission);
        result.put("totalPrice", totalPrice);
        // result.put("bidList", bidList);
        result.put("myBidPrice", myBidPrice);
        result.put("bidListWithMsg", bidListWithMsg);
        result.put("isTopPrice",
                (currentPrice.compareTo(BigDecimal.ZERO) != 0 && currentPrice.equals(myBidPrice) ? true : false));
        result.put("bidPrice", bidPrice);
        result.put("auction", auction);
        result.put("imgUrl", imgUrl);
        if (!auctionVehicle.getId().equals(currentAuctionVehicle.getId())) {
            chgFlag = 1;

            /*
             * Map<String, Object> result = Maps.newHashMap();
             * result.put("success", false); result.put("redirectUrl",
             * "/auction/" + currentAuctionVehicle.getAuctionSid() + "/live");
             * ResponseUtils.writeJsonObject(response, result); return;
             */
            // add zyp 2015年9月29日11:15:49 修改title移到 每次更新拍品的时候更新
            // 获得车辆显示标题
            StringBuffer sb = new StringBuffer();
            String temp = auctionVehicle.getVehicle().getBrand() == null ? "" : auctionVehicle.getVehicle().getBrand();
            sb.append(temp);
            temp = auctionVehicle.getVehicle().getVehicleModel() == null ? ""
                    : auctionVehicle.getVehicle().getVehicleModel();
            sb.append(" ").append(temp);
            if (auctionVehicle.getVehicle().getSweptVolumeStandard() != null) {
                if (auctionVehicle.getVehicle().getSweptVolumeStandard().startsWith("欧")) {
                    sb.append("(进口)");
                }
            }
            temp = auctionVehicle.getVehicle().getSelledName() == null ? ""
                    : auctionVehicle.getVehicle().getSelledName();
            sb.append(" ").append(temp);
            result.put("title", sb.toString());
            VehicleInfo vehicleInfo = auctVehicleService.selectVehicleInfoById(auctionVehicle.getVehicle().getId());
            auctionVehicle.getVehicle().setTransmissionType(vehicleInfo.getTransmissionType());
            auctionVehicle.getVehicle().setUsingModel(vehicleInfo.getUsingModel());
            // fixbug by zjz 与live-show 代码保持一致，此处也是将ProducedYears set
            // RegisterLicenseYears 2015-11-24 13:43:58
            auctionVehicle.getVehicle().setRegisterLicenseYears(vehicleInfo.getProducedYears());
        }
        result.put("chgFlag", chgFlag); // 新增by HCF

        Date currentDate = new Date();
        if (auctionVehicle.getStatus().equals(5) && (auctionVehicle.getOnlineEndTime() == null
                || auctionVehicle.getOnlineEndTime().after(currentDate))) {
            result.put("bidActive", true);

            if (auctionVehicle.getOnlineEndTime() != null && auctionVehicle.getOnlineEndTime().after(currentDate)) {
                result.put("seconds", (auctionVehicle.getOnlineEndTime().getTime() - currentDate.getTime()) / 1000);
            }
        } else {
            result.put("bidActive", false);
        }
        Member member = null;
        if (userIdentity != null) {
            member = memberService.selectByPrimaryKey(userIdentity.getId());
        }
        if (member != null && "商户".equals(member.getMemberCategory())
                && "SP".equalsIgnoreCase(member.getMemberLevel())) {
            result.put("bidActive", false);
        }

        ResponseUtils.writeJsonObject(response, result);
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

    @Override
    public String format(BigDecimal x) {
        StringBuilder sb = new StringBuilder();
        String s = x.setScale(0, BigDecimal.ROUND_CEILING).toString();
        if (s.length() > 4) {
            sb.append("<i>").append(s.substring(0, s.length() - 4)).append("</i>").append(s.substring(s.length() - 4));
        } else {
            sb.append(s);
        }
        return sb.toString();
    }

    public String format1(BigDecimal x) {
        StringBuilder sb = new StringBuilder();
        String s = x.setScale(0, BigDecimal.ROUND_CEILING).toString();
        if (s.length() > 4) {
            sb.append("<ins>").append(s.substring(0, s.length() - 4)).append("</ins>")
                    .append(s.substring(s.length() - 4));
        } else {
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public String getThumbImgUrl(String spec, String imgUrl) {
        return dictionaryService.choiceImgUrl(spec, imgUrl);
    }
}
