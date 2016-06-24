package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.pagination.Pagination1Utils;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.web.utils.UserIdentityUtils;
import com.autostreets.biz.usedvehicle.model.CheckitemCategoryScore;
import com.autostreets.biz.usedvehicle.model.PhotoStar;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.framework.common.web.utils.RequestUtils;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.model.Member;
import com.autostreets.service.MemberService;
import com.autostreets.service.ad.AdPositionsService;
import com.autostreets.util.StringUtil;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 即时拍
 * 
 * @author youpeng.zhang Date: 2015年9月2日 下午1:02:37
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/onceBidAuction")
public class OnceBidAuctionController extends PaginationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnceBidAuctionController.class);
    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private MemberVehicleFavoriteService memberVehicleFavoriteService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private BidService bidService;

    @Autowired
    private AdPositionsService adPositionsService;

    @RequestMapping(value = "/index")
    public String index(@RequestParam(required = false) Integer age, @RequestParam(required = false) Integer mileage,
            @RequestParam(required = false) String city, @RequestParam(required = false) Integer dateflag,
            @RequestParam(required = false) Integer status, @RequestParam(defaultValue = "1") int pageNumber,
            HttpServletRequest request, Model model) {

        int pageSize = 10;
        Map<String, Object> params = Maps.newHashMap();

        params.put("auctionType", 2);
        if (age != null && age != 0) {
            String range = VehicleAgeRangeEnum.lookup(age);
            String[] ss = range.split(",");
            if (!Strings.isNullOrEmpty(ss[0])) {
                params.put("vehicleAgeMin", new BigDecimal(ss[0]));
            }
            if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
                params.put("vehicleAgeMax", new BigDecimal(ss[1]));
            }
        }
        if (mileage != null && mileage != 0) {
            String range = VehicleMileRangeEnum.lookup(mileage);
            String[] ss = range.split(",");
            if (!Strings.isNullOrEmpty(ss[0])) {
                params.put("displayMileageMin", new BigDecimal(ss[0]).multiply(new BigDecimal("10000")));
            }
            if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
                params.put("displayMileageMax", new BigDecimal(ss[1]).multiply(new BigDecimal("10000")));
            }
        }
        if (status != null) {
            params.put("status", status);
        }
        params.put("city", city);
        model.addAttribute("city", city);
        if ((dateflag != null) && (dateflag != 0)) {
            if (dateflag == 1) { // 竞拍中
                params.put("status", 5);
                model.addAttribute("dateflag", 1);
            } else if (dateflag == 2) { // 等待竞拍
                params.put("status", 1);
                model.addAttribute("dateflag", 2);

            }
        } else {
            Date currentDate = new Date();
            Date dateStart = DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH);
            params.put("dateStart", dateStart);
        }

        int count = auctionVehicleService.countAuctionVehicle1(params);

        if (count % pageSize == 0) {
            if (count == 0) {
                pageNumber = 1;
            } else {
                if (pageNumber > (count / pageSize)) {
                    pageNumber = count / pageSize;
                }
            }
        } else {
            if (pageNumber > (count / pageSize + 1)) {
                pageNumber = count / pageSize + 1;
            }
        }

        params.put("offset", (pageNumber - 1) * pageSize);
        params.put("limit", pageSize);

        List<AuctionVehicle> auctionVehicleList = auctionVehicleService.findAuctionVehicle1(params);

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberSid = null;
        if (userIdentity != null) {
            memberSid = userIdentity.getId();
        }

        String priceDisp = "0";
        Boolean isSp = false;
        Set<Integer> favoriteVehicleIds = Sets.newHashSet();
        Member member = null;
        if (StringUtils.isNotEmpty(memberSid)) {
            MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
            MemberVehicleFavoriteExample.Criteria mvfeCriteria = mvfe.createCriteria();
            mvfeCriteria.andMemberSidEqualTo(memberSid);

            List<MemberVehicleFavorite> memberVehicleFavoriteList = memberVehicleFavoriteService.selectByExample(mvfe);
            for (MemberVehicleFavorite mvf : memberVehicleFavoriteList) {
                favoriteVehicleIds.add(mvf.getAvId());
            }

            member = memberService.selectByPrimaryKey(memberSid);
            if (member != null) {
                // Check user category and level
                if ("商户".equals(member.getMemberCategory()) && "VIP1".equalsIgnoreCase(member.getMemberLevel())) {
                    priceDisp = "1";
                } else {
                    priceDisp = "0";
                }

                if ("商户".equals(member.getMemberCategory()) && "SP".equalsIgnoreCase(member.getMemberLevel())) {
                    isSp = true;
                }
            } else {
                LOGGER.warn("member为空");
            }
        }

        for (AuctionVehicle av : auctionVehicleList) {
            if (member != null) {
                BigDecimal curprice = bidService.queryMemberBidPrice(av.getId(), member.getSid());
                av.setCurBidPrice(curprice);
            }
        }

        // Get the pop page switch
        String popValue = auctionDictionaryService.selectPopSwitch();
        model.addAttribute("priceDisp", priceDisp);
        model.addAttribute("isSp", isSp);
        model.addAttribute("popValue", popValue);
        // model.addAttribute("price", price);
        model.addAttribute("age", age);
        model.addAttribute("mileage", mileage);
        model.addAttribute("p", Pagination1Utils.newPagination(pageSize, pageNumber, count, auctionVehicleList));
        model.addAttribute("favoriteVehicleIds", favoriteVehicleIds);

        model.addAttribute("auctionCount", auctionVehicleService.getOnlineAunctionCount());

        // 添加广告2016-6-3 14:00:28
        model.addAttribute("topAdv", adPositionsService.getPositionAd(35));
        //

        return "oncebid/index";
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
        Map<String, Object> params = Maps.newHashMap();
        params.put("auctionType", 2);
        return auctionVehicleService.getCityListforAuction(params);
    }

    /**
     * 即时拍出价
     * 
     * @return JsonResult
     * @author youpeng.zhang Date: 2015年9月8日 下午5:46:36
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/bid", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addBatch(Integer avId, BigDecimal bidAmt, HttpServletRequest request,
            HttpServletResponse response) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberSid = null;
        if (userIdentity != null) {
            memberSid = userIdentity.getId();
        }
        Member member = null;
        if (StringUtils.isNotEmpty(memberSid)) {
            member = memberService.selectByPrimaryKey(memberSid);
        }
        if (member != null && "商户".equalsIgnoreCase(member.getMemberCategory())
                && "VIP1".equalsIgnoreCase(member.getMemberLevel())) {
            List<Bid> myBidList = Lists.newArrayList();
            myBidList = bidService.getBidList(avId, memberSid, false);
            if (myBidList.isEmpty()) {
                AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
                // 未结束才可出价
                if (auctionVehicle != null && auctionVehicle.getOnlineEndTime().after(new Date())) {
                    Bid bid = new Bid();
                    bid.setAuctionVehicleId(avId);
                    bid.setBidderSid(member.getSid());
                    bid.setBidderUsername(member.getUsername());
                    bid.setBidderName(member.getName());
                    bid.setBidTimestamp(new Date());
                    bid.setOriginPrice(bidAmt);
                    bid.setPrice(bidAmt);
                    bid.setIp(RequestUtils.getClientIp(request));
                    bid.setMsg(false);
                    bid.setContent(
                            StringUtil.mask(bid.getBidderUsername()) + " 出价 " + bid.getPrice().toString() + " 元");

                    try {
                        bidService.insert(bid);
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage(), e);
                        return new JsonResult(false);
                    }
                }
            } else {
                return new JsonResult(false, "您已出价，请勿重复出价！");
            }
            return new JsonResult(true);
        } else {
            return new JsonResult(false, "您还未认证！");
        }
    }

    @RequestMapping(value = "/{avId}", method = RequestMethod.GET)
    public String show(@PathVariable @ModelAttribute("avId") Integer avId, HttpServletRequest request,
            HttpServletResponse response, Model model) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (auctionVehicle == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        Integer vehicleId = auctionVehicle.getVehicleId();

        // 前提条件: 在线拍 type=2
        if (vehicleId == null || auctionVehicle.getAuctionType() != 2) {
            throw new IllegalArgumentException();
        }

        // 以下获取车辆的相关详情
        VehicleInfo vehicleInfo = vehicleService.loadVehicleInfo(vehicleId);
        // 车辆图片
        List<PhotoStar> checkPhotoList = vehicleInfo.getStarPhotoList();
        // 车辆评分
        List<CheckitemCategoryScore> checkitemCategoryScores = vehicleInfo.getCheckItemCategoryScoreList();
        Map<String, Double> checkitemCategoryScoresMap = new HashMap<String, Double>();
        if (checkitemCategoryScores != null) {
            for (CheckitemCategoryScore checkitemCategoryScore : checkitemCategoryScores) {
                checkitemCategoryScoresMap.put(checkitemCategoryScore.getCategoryName(),
                        checkitemCategoryScore.getScore().doubleValue());
            }
        }
        // 车辆检测
        String featureItems = vehicleInfo.getFeatureItems(); // 获取车辆配置信息
        String[] featureItem = featureItems.split(","); // 以逗号分割

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberSid = null;
        if (userIdentity != null) {
            memberSid = userIdentity.getId();
        }

        String isFavorite = "0";
        List<Bid> myBidList = Lists.newArrayList();
        String priceDisp = "0";

        Member member = null;
        if (StringUtils.isNotEmpty(memberSid)) {
            MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
            MemberVehicleFavoriteExample.Criteria mvfeCriteria = mvfe.createCriteria();
            mvfeCriteria.andMemberSidEqualTo(memberSid);
            mvfeCriteria.andAvIdEqualTo(avId);

            List<MemberVehicleFavorite> memberVehicleFavoriteList = memberVehicleFavoriteService.selectByExample(mvfe);
            if (memberVehicleFavoriteList != null && memberVehicleFavoriteList.size() > 0) {
                isFavorite = "1";
            }
            myBidList = bidService.getBidList(avId, memberSid, false);

            member = memberService.selectByPrimaryKey(memberSid);
            // Check user category and level
            if (member != null && "商户".equals(member.getMemberCategory())
                    && ("VIP1".equalsIgnoreCase(member.getMemberLevel()))) {
                priceDisp = "1";
            } else {
                priceDisp = "0";
            }
        }

        // 显示当前用户的出价
        BigDecimal myBidPrice;
        if (myBidList.isEmpty()) {
            myBidPrice = BigDecimal.ZERO;
        } else {
            myBidPrice = myBidList.get(0).getPrice();
        }

        model.addAttribute("myBidPrice", myBidPrice);

        Date endTime;
        if (auctionVehicle.getOnlineEndTime() != null) {
            endTime = auctionVehicle.getOnlineEndTime();
        } else {
            endTime = auctionVehicle.getPlanEndTime();
        }

        model.addAttribute("checkPhotoList", checkPhotoList);// 图片
        model.addAttribute("firstVehiclePhoto", vehicleInfo.getStarPhotoList().get(0));// 首图
        model.addAttribute("featureItem", featureItem);// 车辆配置
        model.addAttribute("vehicleCheckCategoryScore", checkitemCategoryScoresMap);
        model.addAttribute("carframeList", vehicleInfo.getFrameList());// 车架损伤图
        model.addAttribute("carappearanceList", vehicleInfo.getFeatureList());// 外观损伤图
        model.addAttribute("carcockpitList", vehicleInfo.getInteriorList());// 内饰损伤图
        model.addAttribute("cardricabList", vehicleInfo.getDricabList());// 车况:驾驶舱
        model.addAttribute("carengineList", vehicleInfo.getEngineList());// 车况:发动机
        model.addAttribute("carstartList", vehicleInfo.getStartList());// 车况:启动
        model.addAttribute("carroadList", vehicleInfo.getRoadList());// 车况:路试
        model.addAttribute("carchassisList", vehicleInfo.getChassisList());// 车况:底盘
        model.addAttribute("carotherList", vehicleInfo.getOtherList());// 车况:其他
        model.addAttribute("caraccessoryList", vehicleInfo.getAccessoryList());// 车况:其他

        model.addAttribute("priceDisp", priceDisp);
        model.addAttribute("vehicle", vehicleInfo);
        model.addAttribute("auctionVehicle", auctionVehicle);
        model.addAttribute("isFavorite", isFavorite);
        model.addAttribute("vehicleId", vehicleId);

        // 显示距离结束的时间
        Date currentDate = new Date();
        long seconds = (endTime.getTime() - currentDate.getTime()) / 1000;
        if (seconds < 0) {
            seconds = 0;
        }

        long h = seconds / 3600;
        long m = (seconds - h * 3600) / 60;
        long s = seconds - h * 3600 - m * 60;
        model.addAttribute("seconds", seconds);
        model.addAttribute("hms", String.format("%02d:%02d:%02d", h, m, s));

        int commission = bidService.calculateCommission(myBidPrice, auctionVehicle);
        model.addAttribute("commission", commission);

        return "oncebid/show";
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

}
