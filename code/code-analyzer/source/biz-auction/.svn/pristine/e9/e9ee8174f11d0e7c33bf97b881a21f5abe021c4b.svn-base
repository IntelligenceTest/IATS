package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.utils.BizUtils;
import com.autostreets.biz.auction.web.utils.UserIdentityUtils;
import com.autostreets.biz.usedvehicle.model.CheckitemCategoryScore;
import com.autostreets.biz.usedvehicle.model.CheckitemInfo;
import com.autostreets.biz.usedvehicle.model.PhotoStar;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.model.Member;
import com.autostreets.service.MemberService;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

@Controller
public class VehicleController extends BaseController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private BidService bidService;

    @Autowired
    private AuctionDictionaryService dictionaryService;

    @Autowired
    MemberVehicleFavoriteService memberVehicleFavoriteService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/auction/{auctionId}/vehicle/{vehicleId}", method = RequestMethod.GET)
    public String show(@PathVariable Integer auctionId, @PathVariable Integer vehicleId, HttpServletRequest request,
            HttpServletResponse response, Model model) {
        if (auctionId == null || vehicleId == null) {
            throw new IllegalArgumentException();
        }

        Auction auction = auctionService.selectByPrimaryKey(auctionId); // 获取拍卖会信息
        if (auction == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        VehicleInfo vehicle = vehicleService.loadVehicleInfo(vehicleId); // 获取车辆信息
        if (vehicle == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        // 获取车辆其它信息
        List<CheckitemInfo> carframeList = vehicle.getFrameList(); // 获取车架损伤信息
        List<CheckitemInfo> carappearanceList = vehicle.getFeatureList(); // 获取外观损伤信息
        List<CheckitemInfo> carcockpitList = vehicle.getInteriorList(); // 获取内饰(驾驶舱)损伤信息
        List<CheckitemInfo> carconditionList = vehicle.getDricabList(); // 获取车况检测信息
        carconditionList.addAll(vehicle.getEngineList());
        carconditionList.addAll(vehicle.getStartList());
        carconditionList.addAll(vehicle.getRoadList());
        carconditionList.addAll(vehicle.getChassisList());
        List<CheckitemInfo> carOtherList = vehicle.getOtherList(); // 获取车况其他检测信息
        List<PhotoStar> checkPhotoList = vehicle.getStarPhotoList(); // 获取车辆检测照片

        int photoNum = 0;
        PhotoStar firstVehiclePhoto = null;
        if (checkPhotoList != null && checkPhotoList.size() > 0) {
            for (PhotoStar vehiclePhoto : checkPhotoList) {
                if (!Strings.isNullOrEmpty(vehiclePhoto.getPhotoUrl())) {
                    ++photoNum;
                    if (firstVehiclePhoto == null) {
                        firstVehiclePhoto = vehiclePhoto;
                    }
                }
            }
        }

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria criteria = ave.createCriteria();
        criteria.andAuctionIdEqualTo(auctionId);
        criteria.andVehicleIdEqualTo(vehicleId);
        List<AuctionVehicle> auctionVehicleList = auctionVehicleService.selectByExample(ave); // 获取拍品表信息
        if (auctionVehicleList == null || auctionVehicleList.size() == 0) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        AuctionVehicle auctionVehicle = auctionVehicleList.get(0);

        String featureItems = vehicle.getFeatureItems(); // 获取车辆配置信息
        String[] featureItem = featureItems.split(","); // 以逗号分割
        List<CheckitemCategoryScore> vehicleCheckCategoryScore_ = vehicle.getCheckItemCategoryScoreList(); // 获取车辆检查报告信息
        List<CheckitemInfo> vehicleCheckCategoryScore = new ArrayList<CheckitemInfo>();
        for (CheckitemCategoryScore score : vehicleCheckCategoryScore_) {
            CheckitemInfo checkScore = new CheckitemInfo();
            checkScore.setItemName(String.valueOf(score.getCheckitemCategoryId()));
            checkScore.setBaseScore(score.getScore() == null ? new BigDecimal(0) : score.getScore());
            vehicleCheckCategoryScore.add(checkScore);
        }

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String isFavorite = "0";
        String priceDisp = "0";
        if (userIdentity != null) {
            MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
            MemberVehicleFavoriteExample.Criteria mvfeCriteria = mvfe.createCriteria();
            mvfeCriteria.andMemberSidEqualTo(userIdentity.getId());
            mvfeCriteria.andAvIdEqualTo(auctionVehicle.getId());

            List<MemberVehicleFavorite> memberVehicleFavoriteList = memberVehicleFavoriteService.selectByExample(mvfe);
            if (memberVehicleFavoriteList != null && memberVehicleFavoriteList.size() > 0) {
                isFavorite = "1";
            }

            Member member = memberService.selectByPrimaryKey(userIdentity.getId());
            // Check user category and level
            if ("商户".equals(member.getMemberCategory()) && "VIP1".equalsIgnoreCase(member.getMemberLevel())) {
                priceDisp = "1";
            } else {
                priceDisp = "0";
            }
        }

        model.addAttribute("auction", auction);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("auctionVehicle", auctionVehicle);
        model.addAttribute("featureItem", featureItem);
        model.addAttribute("vehicleCheckCategoryScore", vehicleCheckCategoryScore);
        model.addAttribute("carframeList", carframeList);
        model.addAttribute("carappearanceList", carappearanceList);
        model.addAttribute("carcockpitList", carcockpitList);
        model.addAttribute("carconditionList", carconditionList);
        model.addAttribute("carOtherList", carOtherList); // 添加其他检测项
        model.addAttribute("isFavorite", isFavorite);
        model.addAttribute("priceDisp", priceDisp);

        model.addAttribute("checkPhotoList", checkPhotoList);
        model.addAttribute("photoNum", photoNum);
        model.addAttribute("firstVehiclePhoto", firstVehiclePhoto);

        List<Bid> bidList = BizUtils.getBidList(bidService, auctionVehicle.getId(), null, false);

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

        BigDecimal bidPrice;
        if (auctionVehicle.getPlusRange() != null) {
            bidPrice = currentPrice.add(BigDecimal.valueOf(auctionVehicle.getPlusRange().longValue()));
        } else {
            bidPrice = currentPrice;
        }

        model.addAttribute("bidPrice", bidPrice);

        List<Integer> plusRangeList = Lists.newArrayList();
        for (int i = 0; i < 4; ++i) {
            if (auctionVehicle.getPlusRange() != null) {
                plusRangeList.add(auctionVehicle.getPlusRange().intValue() * (i + 1));
            } else {
                plusRangeList.add(0);
            }
        }

        model.addAttribute("plusRangeList", plusRangeList);

        int commission = BizUtils.calculateCommission(dictionaryService, currentPrice, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(currentPrice, commission, auctionVehicle);

        model.addAttribute("commission", commission);
        model.addAttribute("totalPrice", totalPrice);

        /*
         * if (userIdentity == null) { model.addAttribute("showSetProxyPrice",
         * false); model.addAttribute("showEditProxyPrice", false);
         * model.addAttribute("showProxyPrice", false); } else {
         * AgentPriceExample ape = new AgentPriceExample();
         * AgentPriceExample.Criteria apeCriteria = ape.createCriteria();
         * apeCriteria.andMemberSidEqualTo(userIdentity.getId());
         * apeCriteria.andAvSidEqualTo(auctionVehicle.getId());
         * 
         * List<AgentPrice> agentPriceList =
         * agentPriceService.selectByExample(ape); if (agentPriceList.isEmpty())
         * { model.addAttribute("showSetProxyPrice",
         * "1".equals(auction.getStatus()));
         * model.addAttribute("showEditProxyPrice", false);
         * model.addAttribute("showProxyPrice", false); } else {
         * model.addAttribute("showSetProxyPrice", false);
         * model.addAttribute("showEditProxyPrice",
         * "1".equals(auction.getStatus()));
         * model.addAttribute("showProxyPrice", true);
         * model.addAttribute("proxyPrice",
         * agentPriceList.get(0).getReservePrice()); } }
         */

        return "vehicle/show";
    }

    /*
     * @RequestMapping(value = "/send-car-address-sms", method =
     * RequestMethod.POST) public void sendCarAddressSms(String mobile, String
     * avId, HttpServletResponse response) { if (Strings.isNullOrEmpty(mobile)
     * || Strings.isNullOrEmpty(avId)) { throw new IllegalArgumentException(); }
     * 
     * AuctionVehicle auctionVehicle =
     * auctionVehicleService.selectByPrimaryKey(avId); if
     * (StringUtils.isNotBlank(auctionVehicle.getSeeCarAddr())) {
     * smsSender.sendSms(mobile, auctionVehicle.getSeeCarAddr() +
     * GlobalConstants.SMS_SIGNATURE); } Map<String, Object> result =
     * Maps.newHashMap(); result.put("success", true);
     * 
     * ResponseUtils.writeJsonObject(response, result); }
     * 
     * @RequestMapping(value = "/member/set-proxy-price", method =
     * RequestMethod.POST) public void setProxyPrice(String avId, BigDecimal
     * price, HttpServletRequest request, HttpServletResponse response) { if
     * (Strings.isNullOrEmpty(avId) || price == null) { throw new
     * IllegalArgumentException(); }
     * 
     * AuctionVehicle auctionVehicle =
     * auctionVehicleService.selectByPrimaryKey(avId); if (auctionVehicle ==
     * null) { throw new RuntimeException(); }
     * 
     * Auction auction =
     * auctionService.selectByPrimaryKey(auctionVehicle.getAuctionSid());
     * 
     * if (!auction.getStatus().equals("1")) { Map<String, Object> result =
     * Maps.newHashMap(); result.put("success", false); result.put("error",
     * "拍卖会已开始，不允许修改代理价"); ResponseUtils.writeJsonObject(response, result); }
     * 
     * UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
     * 
     * AgentPriceExample ape = new AgentPriceExample();
     * AgentPriceExample.Criteria apeCriteria = ape.createCriteria();
     * apeCriteria.andMemberSidEqualTo(userIdentity.getId());
     * apeCriteria.andAvSidEqualTo(avId);
     * 
     * AgentPrice agentPriceEntity = new AgentPrice();
     * agentPriceEntity.setReservePrice(price.intValue());
     * 
     * int affectedRows =
     * agentPriceService.updateByExampleSelective(agentPriceEntity, ape); if
     * (affectedRows < 1) { agentPriceEntity.setSid(UUIDUtil.getUUID());
     * agentPriceEntity.setMemberSid(userIdentity.getId());
     * agentPriceEntity.setAvSid(avId);
     * agentPriceEntity.setReservePrice(price.intValue());
     * agentPriceEntity.setPlusPrice(0); agentPriceEntity.setCreatedTime(new
     * Date());
     * 
     * agentPriceService.insertSelective(agentPriceEntity); }
     * 
     * Map<String, Object> result = Maps.newHashMap(); result.put("success",
     * true);
     * 
     * ResponseUtils.writeJsonObject(response, result); }
     * 
     * @RequestMapping(value = "/member/cancel-proxy-price", method =
     * RequestMethod.POST) public void cancelProxyPrice(String avId,
     * HttpServletRequest request, HttpServletResponse response) { if
     * (Strings.isNullOrEmpty(avId)) { throw new IllegalArgumentException(); }
     * 
     * AuctionVehicle auctionVehicle =
     * auctionVehicleService.selectByPrimaryKey(avId); if (auctionVehicle ==
     * null) { throw new RuntimeException(); }
     * 
     * Auction auction =
     * auctionService.selectByPrimaryKey(auctionVehicle.getAuctionSid());
     * 
     * if (!auction.getStatus().equals("1")) { Map<String, Object> result =
     * Maps.newHashMap(); result.put("success", false); result.put("error",
     * "拍卖会已开始，不允许取消代理价"); ResponseUtils.writeJsonObject(response, result); }
     * 
     * UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
     * 
     * AgentPriceExample ape = new AgentPriceExample();
     * AgentPriceExample.Criteria apeCriteria = ape.createCriteria();
     * apeCriteria.andMemberSidEqualTo(userIdentity.getId());
     * apeCriteria.andAvSidEqualTo(avId);
     * 
     * agentPriceService.deleteByExample(ape);
     * 
     * Map<String, Object> result = Maps.newHashMap(); result.put("success",
     * true);
     * 
     * ResponseUtils.writeJsonObject(response, result); }
     * 
     * public String format(BigDecimal x) { StringBuilder sb = new
     * StringBuilder(); String s = x.setScale(0,
     * BigDecimal.ROUND_CEILING).toString(); if (s.length() > 4) {
     * sb.append("<i>").append(s.substring(0, s.length() -
     * 4)).append("</i>").append(s.substring(s.length() - 4)); } else {
     * sb.append(s); } return sb.toString(); }
     */

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