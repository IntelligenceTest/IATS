package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionExample;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.BidExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.utils.BizUtils;
import com.autostreets.biz.auction.web.utils.MsgPhshUtils;
import com.autostreets.biz.cms.service.AppModelService;
import com.autostreets.biz.cms.service.AppMsgPushTriggerService;
import com.autostreets.biz.cms.service.DrawDictionaryService;
import com.autostreets.framework.common.web.utils.RequestUtils;
import com.autostreets.util.StringUtil;
import com.autostreets.web.util.ResponseUtils;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Controller
public class PanelController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PanelController.class);

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private BidService bidService;

    @Autowired
    private AuctionDictionaryService dictionaryService;

    @Autowired
    private DrawDictionaryService drawDictionaryService;

    @Autowired
    private AppModelService appModelService;

    @Autowired
    private AppMsgPushTriggerService appMsgPushTriggerService;

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/panel/{auctionId}", method = RequestMethod.GET)
    @RequiresPermissions("auct:auct_idx:panel")
    public String show(@PathVariable Integer auctionId, Model model, HttpServletRequest request) {
        Auction auction = auctionService.selectAutionById(auctionId);
        AuctionVehicle currentAuctionVehicle = null;
        AuctionVehicle auctionVehicle = null;
        List<AuctionVehicle> auctionVehicles = auctionVehicleService.getAuctionVehicles(auction.getId());// 获取所有拍品信息，包含车辆信息
        // 如果默认拍品sid不为空，则直接循环拍品列表，否则读取数据库
        if (auction.getCurrentAvId() != null) {
            for (AuctionVehicle tempAuctionVehicle : auctionVehicles) {
                if (tempAuctionVehicle.getId().equals(auction.getCurrentAvId())) {
                    currentAuctionVehicle = tempAuctionVehicle;
                }
            }
        }

        // status: 5,6,1,4
        if (currentAuctionVehicle != null && !currentAuctionVehicle.getStatus().equals(0)
                && !currentAuctionVehicle.getStatus().equals(2) && !currentAuctionVehicle.getStatus().equals(3)) {
            auctionVehicle = currentAuctionVehicle;
        }
        if (auctionVehicle == null) {
            auctionVehicle = getFirstAuctionVehicle(auctionVehicle, auctionVehicles, 5);
        }
        if (auctionVehicle == null) {
            auctionVehicle = getFirstAuctionVehicle(auctionVehicle, auctionVehicles, 6);
        }
        if (auctionVehicle == null) {
            auctionVehicle = getFirstAuctionVehicle(auctionVehicle, auctionVehicles, 1);
        }
        if (auctionVehicle == null) {
            auctionVehicle = getFirstAuctionVehicle(auctionVehicle, auctionVehicles, 4);
        }
        if (auctionVehicle == null) {
            // 修改车辆全部拍卖成功，点击结束拍卖会按钮报错bug
            if (currentAuctionVehicle.getStatus().equals(2)) {
                model.addAttribute("auction", auction);
                model.addAttribute("auctionVehicleList", auctionVehicles);
                model.addAttribute("onlineEndActive", true);
                return "/panel/show";
            }
            throw new RuntimeException("拍品异常!");
        } else {
            if (auctionVehicle.getStatus().equals(4)) {
                // delete old bids
                BidExample bidExamp = new BidExample();
                BidExample.Criteria bidCriteria = bidExamp.createCriteria();
                bidCriteria.andAuctionVehicleIdEqualTo(auctionVehicle.getId());
                bidService.deleteByExample(bidExamp);

                // update maxBidPrice
                AuctionVehicle avEntity = new AuctionVehicle();
                avEntity.setMaxBidPrice(BigDecimal.ZERO);

                AuctionVehicleExample avExamp = new AuctionVehicleExample();
                AuctionVehicleExample.Criteria avCriteria = avExamp.createCriteria();
                avCriteria.andIdEqualTo(auctionVehicle.getId());
                auctionVehicleService.updateByExampleSelective(avEntity, avExamp);
            }
        }

        if (auction.getCurrentAvId() == null || !auction.getCurrentAvId().equals(auctionVehicle.getId())) {
            Auction auctionEntity = new Auction();
            auctionEntity.setId(auctionId);
            auctionEntity.setCurrentAvId(auctionVehicle.getId());
            auctionService.updateByPrimaryKeySelective(auctionEntity);
        }
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

        // 助手中 线下出价提示价格 方便线下出价 有出价记录 在当前价格上递增加价幅度，没有出价记录 第一个提示价格与当前价格一致，其他的递增。
        List<BigDecimal> bidPriceList = Lists.newArrayList();
        int n = bidList.isEmpty() ? 0 : 1;
        for (int i = 0 + n; i < 4 + n; ++i) {
            if (auctionVehicle.getPlusRange() != null) {
                bidPriceList.add(currentPrice.add(BigDecimal.valueOf(auctionVehicle.getPlusRange().longValue() * i)));
            } else {
                bidPriceList.add(currentPrice);
            }
        }
        int commission = BizUtils.calculateCommission(dictionaryService, currentPrice, auctionVehicle);
        List<Bid> bidListWithMsg = BizUtils.getBidList(bidService, auctionVehicle.getId(), null, true);
        model.addAttribute("auction", auction);
        model.addAttribute("auctionVehicleList", auctionVehicles);
        model.addAttribute("auctionVehicle", auctionVehicle);
        model.addAttribute("bidList", bidList);
        model.addAttribute("currentPrice", currentPrice);
        model.addAttribute("currentPriceFormat", this.format(currentPrice));
        model.addAttribute("currentPriceFormatCN", this.formatCN(currentPrice));
        model.addAttribute("bidPriceList", bidPriceList);
        model.addAttribute("commission", commission);
        model.addAttribute("bidListWithMsg", bidListWithMsg);
        model.addAttribute("onlineEndActive", auctionVehicle.getOnlineEndTime() == null);

        Date currentDate = new Date();
        if (auctionVehicle.getOnlineEndTime() != null && auctionVehicle.getOnlineEndTime().after(currentDate)) {
            model.addAttribute("seconds", (auctionVehicle.getOnlineEndTime().getTime() - currentDate.getTime()) / 1000);
        }
        return "/panel/show";
    }

    /**
     * @param auctionVehicle
     * @param auctionVehicles
     * @return
     */
    private AuctionVehicle getFirstAuctionVehicle(AuctionVehicle auctionVehicle, List<AuctionVehicle> auctionVehicles,
            Integer status) {
        for (AuctionVehicle av : auctionVehicles) {
            if (av.getStatus().equals(status)) {
                auctionVehicle = av;
                break;
            }
        }
        return auctionVehicle;
    }

    @RequestMapping(value = "/panel/set-reserve-price", method = RequestMethod.POST)
    public void setReservePrice(Integer avId, Integer reservePrice, HttpServletResponse response) {
        if (avId == null || reservePrice == null || reservePrice < 0) {
            throw new IllegalArgumentException();
        }

        AuctionVehicle av = new AuctionVehicle();
        av.setId(avId);
        av.setReservePrice(BigDecimal.valueOf(reservePrice.longValue()));

        auctionVehicleService.updateByPrimaryKeySelective(av);
        // AuctionVehicle auctionVehicle =
        // auctionVehicleService.selectByPrimaryKey(avId);
        // if (auctionVehicle != null) {
        // VehiclePriceLog vplog = new VehiclePriceLog();
        // vplog.setCreatedTimestamp(new Date());
        // vplog.setStartPrice(auctionVehicle.getStartPrice());
        // vplog.setReservePrice(av.getReservePrice());
        // vplog.setVehicleId(auctionVehicle.getVehicleId());
        // // TODO 待二期修改
        // // 二手车管理系统一期默认为拍卖
        // vplog.setRequirementType(0);
        // vplog.setCreateUser(getUser().getId());
        // vehiclePriceLogService.insert(vplog);
        // }

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/set-start-price", method = RequestMethod.POST)
    public void setStartPrice(Integer avId, Integer startPrice, HttpServletResponse response) {
        if (avId == null || startPrice == null || startPrice < 0) {
            throw new IllegalArgumentException();
        }

        AuctionVehicle av = new AuctionVehicle();
        av.setId(avId);
        av.setStartPrice(BigDecimal.valueOf(startPrice.longValue()));

        auctionVehicleService.updateByPrimaryKeySelective(av);

        // AuctionVehicle auctionVehicle =
        // auctionVehicleService.selectByPrimaryKey(avId);
        // if (auctionVehicle != null) {
        // VehiclePriceLog vplog = new VehiclePriceLog();
        // vplog.setCreatedTimestamp(new Date());
        // vplog.setStartPrice(av.getStartPrice());
        // vplog.setReservePrice(auctionVehicle.getReservePrice());
        // vplog.setVehicleId(auctionVehicle.getVehicleId());
        // // TODO 待二期修改
        // // 二手车管理系统一期默认为拍卖
        // vplog.setRequirementType(0);
        // vplog.setCreateUser(getUser().getId());
        // vehiclePriceLogService.insert(vplog);
        // }

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/set-plus-range", method = RequestMethod.POST)
    public void setPlusRange(Integer avId, Integer plusRange, HttpServletResponse response) {
        if (avId == null || plusRange == null || plusRange <= 0) {
            throw new IllegalArgumentException();
        }

        AuctionVehicle av = new AuctionVehicle();
        av.setId(avId);
        av.setPlusRange(plusRange);

        auctionVehicleService.updateByPrimaryKeySelective(av);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);
        result.put("plusRange", plusRange);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/start-auction", method = RequestMethod.POST)
    public void startAuction(Integer auctionId, HttpServletResponse response) {
        if (auctionId == null) {
            throw new IllegalArgumentException();
        }
        List<AuctionVehicle> auctionVehicles = auctionVehicleService.getAuctionVehicles(auctionId);
        AuctionVehicle auctionVehicle1 = null;
        auctionVehicle1 = getFirstAuctionVehicle(auctionVehicle1, auctionVehicles, 5);
        if (auctionVehicle1 == null) {
            auctionVehicle1 = getFirstAuctionVehicle(auctionVehicle1, auctionVehicles, 6);
        }
        if (auctionVehicle1 == null) {
            auctionVehicle1 = getFirstAuctionVehicle(auctionVehicle1, auctionVehicles, 1);
        }
        if (auctionVehicle1 == null) {
            throw new RuntimeException();
        }

        Auction auctionEntity = new Auction();
        auctionEntity.setStatus(2);
        auctionEntity.setCurrentAvId(auctionVehicle1.getId());

        AuctionExample ae = new AuctionExample();
        AuctionExample.Criteria aeCriteria = ae.createCriteria();
        aeCriteria.andIdEqualTo(auctionId);
        aeCriteria.andStatusEqualTo(1);

        int affectedRows = auctionService.updateByExampleSelective(auctionEntity, ae);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", affectedRows == 1);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/end-auction", method = RequestMethod.POST)
    public void endAuction(Integer auctionId, HttpServletResponse response) {
        if (auctionId == null) {
            throw new IllegalArgumentException();
        }
        List<AuctionVehicle> auctionVehicles = auctionVehicleService.getAuctionVehicles(auctionId);// 获取所有拍品信息，包含车辆信息
        for (AuctionVehicle auctionVehicle : auctionVehicles) {
            if (!auctionVehicle.getStatus().equals(2) && !auctionVehicle.getStatus().equals(4)) {
                Map<String, Object> result = Maps.newHashMap();
                result.put("success", false);
                result.put("msg", "该拍卖会仍有车辆在竞拍中，请处理！");
                ResponseUtils.writeJsonObject(response, result);
                return;
            }
        }

        Auction auctionEntity = new Auction();
        auctionEntity.setStatus(3);

        AuctionExample ae = new AuctionExample();
        AuctionExample.Criteria aeCriteria = ae.createCriteria();
        aeCriteria.andIdEqualTo(auctionId);
        aeCriteria.andStatusEqualTo(2);

        int affectedRows = auctionService.updateByExampleSelective(auctionEntity, ae);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", affectedRows == 1);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/start-av", method = RequestMethod.POST)
    public void startAv(Integer avId, HttpServletRequest request, HttpServletResponse response) {
        if (avId == null) {
            throw new IllegalArgumentException();
        }

        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);// 获取拍品信息
        auctionVehicle.setStatus(5);// 拍卖中
        auctionVehicle.setOnlineEndTime(null);// 网络倒计时
        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andIdEqualTo(avId);
        aveCriteria.andStatusEqualTo(1);
        int affectedRows = auctionVehicleService.updateByExample(auctionVehicle, ave);// 更新拍品状态信息

        int sortOrder = (auctionVehicle.getAuctionVehicleOrder() == null) ? 0 : auctionVehicle.getAuctionVehicleOrder();
        Bid msgBid = new Bid();
        msgBid.setAuctionVehicleId(auctionVehicle.getId());
        msgBid.setBidderSid("***");
        msgBid.setBidderUsername("***");
        msgBid.setBidderName("系统");
        msgBid.setBidTimestamp(new Date());
        msgBid.setIp(RequestUtils.getClientIp(request));
        msgBid.setMsg(true);
        if (affectedRows < 1) {
            List<Integer> statusList = Lists.newArrayList();
            statusList.add(4);
            statusList.add(6);
            ave = new AuctionVehicleExample();
            aveCriteria = ave.createCriteria();
            aveCriteria.andIdEqualTo(avId);
            // aveCriteria.andStatusEqualTo("6");
            aveCriteria.andStatusIn(statusList);
            affectedRows = auctionVehicleService.updateByExample(auctionVehicle, ave);
            msgBid.setContent(Strings.padStart(String.valueOf(sortOrder), 3, '0') + "号拍品恢复拍卖...");
        } else {
            msgBid.setContent(Strings.padStart(String.valueOf(sortOrder), 3, '0') + "号拍品开始拍卖...");
        }
        bidService.insertSelective(msgBid);
        Map<String, Object> result = Maps.newHashMap();
        result.put("success", affectedRows == 1);
        result.put("msgBid", msgBid);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/pause-av", method = RequestMethod.POST)
    public void pauseAv(Integer avId, HttpServletRequest request, HttpServletResponse response) {
        if (avId == null) {
            throw new IllegalArgumentException();
        }

        AuctionVehicle auctionVehicleEntity = new AuctionVehicle();
        auctionVehicleEntity.setStatus(6);

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andIdEqualTo(avId);
        aveCriteria.andStatusEqualTo(5);

        int affectedRows = auctionVehicleService.updateByExampleSelective(auctionVehicleEntity, ave);

        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);

        Bid msgBid = new Bid();
        msgBid.setAuctionVehicleId(auctionVehicle.getId());
        msgBid.setBidderSid("***");
        msgBid.setBidderUsername("***");
        msgBid.setBidderName("系统");
        msgBid.setBidTimestamp(new Date());
        msgBid.setIp(RequestUtils.getClientIp(request));
        msgBid.setMsg(true);
        int sortOrder = auctionVehicle.getAuctionVehicleOrder() == null ? 0 : auctionVehicle.getAuctionVehicleOrder();
        msgBid.setContent(Strings.padStart(String.valueOf(sortOrder), 3, '0') + "号拍品暂停拍卖...");

        bidService.insertSelective(msgBid);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", affectedRows == 1);
        result.put("msgBid", msgBid);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/complete-av", method = RequestMethod.POST)
    public void completeAv(Integer avId, HttpServletResponse response) {
        if (avId == null) {
            throw new IllegalArgumentException();
        }
        Map<String, Object> result = Maps.newHashMap();
        try {
            auctionVehicleService.updateAuctionVehicleComplete(avId);
            result.put("success", true);

            // 消息推送
            // 获取最大出价的人
            try {
                AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);

                Bid bid = bidService.getMaxPriceBidder(avId);
                Vehicle vehicle = vehicleService.selectByPrimaryKey(auctionVehicle.getVehicleId());
                Map<String, String> params = new HashMap<String, String>();
                // TODO: 用户的id
                params.put("title", vehicle.getSelledName());
                params.put("price", bid.getPrice().toString());
                MsgPhshUtils.Jpush(drawDictionaryService, appModelService,
                        appMsgPushTriggerService.getMsgPushByTriggerName("同步拍成交"), bid.getBidderSid(), params);
            } catch (Exception e) {
                LOGGER.error("同步拍成交推送失败", e);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            result.put("success", false);
        }
        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/fail-av", method = RequestMethod.POST)
    public void failAv(Integer avId, HttpServletResponse response) {
        if (avId == null) {
            throw new IllegalArgumentException();
        }

        Map<String, Object> result = Maps.newHashMap();
        try {
            auctionVehicleService.updateAuctionVehicleFail(avId);
            result.put("success", true);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            result.put("success", false);
        }
        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/retry-av", method = RequestMethod.POST)
    public void retryAv(Integer avId, HttpServletResponse response) {
        if (avId == null) {
            throw new IllegalArgumentException();
        }
        BidExample be = new BidExample();
        BidExample.Criteria beCriteria = be.createCriteria();
        beCriteria.andAuctionVehicleIdEqualTo(avId);

        bidService.deleteByExample(be);

        AuctionVehicle auctionVehicleEntity = new AuctionVehicle();
        auctionVehicleEntity.setMaxBidPrice(BigDecimal.ZERO);
        auctionVehicleEntity.setStatus(1);

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andIdEqualTo(avId);
        aveCriteria.andStatusEqualTo(5);

        int affectedRows = auctionVehicleService.updateByExampleSelective(auctionVehicleEntity, ave);

        auctionVehicleService.resetOnlineEndTime(avId);
        Map<String, Object> result = Maps.newHashMap();
        result.put("success", affectedRows == 1);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/next-av", method = RequestMethod.POST)
    public void nextAv(Integer avId, Integer auctionId, HttpServletResponse response) {
        if (avId == null || auctionId == null) {
            throw new IllegalArgumentException();
        }

        List<AuctionVehicle> auctionVehicleList = auctionVehicleService.getNextAvList(auctionId);

        AuctionVehicle nextAuctionVehicle = null;

        nextAuctionVehicle = getFirstAuctionVehicle(nextAuctionVehicle, auctionVehicleList, 5);
        if (nextAuctionVehicle == null) {
            nextAuctionVehicle = getFirstAuctionVehicle(nextAuctionVehicle, auctionVehicleList, 6);
        }
        if (nextAuctionVehicle == null) {
            nextAuctionVehicle = getFirstAuctionVehicle(nextAuctionVehicle, auctionVehicleList, 1);
        }
        if (nextAuctionVehicle == null) {
            return;
        }

        Auction auctionEntity = new Auction();
        auctionEntity.setId(nextAuctionVehicle.getAuctionId());
        auctionEntity.setCurrentAvId(nextAuctionVehicle.getId());

        int affectedRows = auctionService.updateByPrimaryKeySelective(auctionEntity);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", affectedRows == 1);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/set-start-av", method = RequestMethod.POST)
    public void intimeAv(Integer avId, Integer auctionId, HttpServletResponse response) {
        if (avId == null || auctionId == null) {
            throw new IllegalArgumentException();
        }

        // update auction
        Auction auctionEntity = new Auction();
        auctionEntity.setId(auctionId);
        auctionEntity.setCurrentAvId(avId);

        int affectedRows = auctionService.updateByPrimaryKeySelective(auctionEntity);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", affectedRows == 1);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/bid/add", method = RequestMethod.POST)
    public void addBid(Integer avId, BigDecimal price, HttpServletRequest request, HttpServletResponse response) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        // if (auctionVehicle != null && !auctionVehicle.getStatus().equals(5))
        // {
        // Map<String, Object> result = Maps.newHashMap();
        // result.put("success", false);
        // result.put("error", "该拍品非拍卖中，不可出价!");
        // ResponseUtils.writeJsonObject(response, result);
        // return;
        // }
        Bid bid = new Bid();
        bid.setAuctionVehicleId(avId);
        bid.setBidderSid("000");
        bid.setBidderUsername("线下用户");
        bid.setBidderName("线下用户");
        bid.setBidTimestamp(new Date());
        bid.setOriginPrice(price);
        bid.setPrice(price);
        bid.setIp(RequestUtils.getClientIp(request));
        bid.setMsg(false);
        bid.setContent(StringUtil.mask(bid.getBidderUsername()) + " 出价 " + bid.getPrice().toString() + " 元");

        boolean success = bidService.createOfflineBid(bid);
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
        result.put("plusRange", auctionVehicle.getPlusRange());

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/send-msg", method = RequestMethod.POST)
    public void sendMsg(Integer avId, String content, HttpServletRequest request, HttpServletResponse response) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);

        Bid msgBid = new Bid();
        msgBid.setAuctionVehicleId(auctionVehicle.getId());
        msgBid.setBidderSid("***");
        msgBid.setBidderUsername("***");
        msgBid.setBidderName("系统");
        msgBid.setBidTimestamp(new Date());
        msgBid.setIp(RequestUtils.getClientIp(request));
        msgBid.setMsg(true);
        msgBid.setContent(content);

        bidService.insertSelective(msgBid);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);
        result.put("msgBid", msgBid);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/cancel-price", method = RequestMethod.POST)
    public void cancelPrice(Integer avId, HttpServletResponse response) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (auctionVehicle == null) {
            return;
        }
        List<Bid> bidList = bidService.getBidList(auctionVehicle.getId(), null, false);

        if (!bidList.isEmpty()) {
            Bid bid = bidList.get(0);
            if (bid.getBidderSid().equals("000")) {
                BigDecimal price;
                if (bidList.size() > 1) {
                    price = bidList.get(1).getPrice();
                } else {
                    price = BigDecimal.ZERO;
                }
                bidService.deleteOfflineBid(bid, price);
            }
        }

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/online-end", method = RequestMethod.POST)
    public void onlineEnd(Integer avId, HttpServletResponse response) {
        AuctionVehicle auctionVehicleEntity = new AuctionVehicle();
        auctionVehicleEntity.setId(avId);
        int countdown = 8;
        List<AuctionDictionary> auctionCountdown = dictionaryService.selectResource("auction_countdown");
        try {
            if (auctionCountdown != null && auctionCountdown.size() >= 0) {
                countdown = Integer.valueOf(auctionCountdown.get(0).getValue());
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        auctionVehicleEntity.setOnlineEndTime(DateUtils.addSeconds(new Date(), countdown));

        auctionVehicleService.updateByPrimaryKeySelective(auctionVehicleEntity);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);

        ResponseUtils.writeJsonObject(response, result);
    }

    @RequestMapping(value = "/panel/sync", method = RequestMethod.GET)
    public void sync(Integer avId, HttpServletRequest request, HttpServletResponse response) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (auctionVehicle == null) {
            return;
        }

        List<Bid> bidListWithMsg = BizUtils.getBidList(bidService, auctionVehicle.getId(), null, true);// 带消息的bidList
        List<Bid> bidList = Lists.newArrayList();// 不带消息的bidList
        Bid tempBid = null;
        for (Bid bid : bidListWithMsg) {
            if (!bid.getMsg()) {
                tempBid = new Bid();
                tempBid.setBidTimestamp(bid.getBidTimestamp());
                tempBid.setContent(bid.getContent());
                tempBid.setPrice(bid.getPrice());
                tempBid.setBidderUsername(bid.getBidderUsername());
                bidList.add(tempBid);
            }
        }

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

        int commission = BizUtils.calculateCommission(dictionaryService, currentPrice, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(currentPrice, commission, auctionVehicle);

        Map<String, Object> result = Maps.newHashMap();
        result.put("success", true);
        result.put("currentPrice", currentPrice);
        result.put("commission", commission);
        result.put("totalPrice", totalPrice);
        result.put("bidList", bidList);
        result.put("plusRange", auctionVehicle.getPlusRange());
        result.put("bidListWithMsg", bidListWithMsg);
        result.put("onlineEndActive", auctionVehicle.getOnlineEndTime() == null);
        result.put("hasBid", bidList.isEmpty() ? 0 : 1);

        // current auctionVehicle status value
        result.put("currentAVStatus", auctionVehicle.getStatus());

        Date currentDate = new Date();
        if (auctionVehicle.getOnlineEndTime() != null && auctionVehicle.getOnlineEndTime().after(currentDate)) {
            result.put("seconds", (auctionVehicle.getOnlineEndTime().getTime() - currentDate.getTime()) / 1000);
        } else {
            result.put("seconds", -1);
        }

        ResponseUtils.writeJsonObject(response, result);
    }

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

    public String formatCN(BigDecimal x) {
        int n = x.setScale(0, BigDecimal.ROUND_CEILING).intValue();
        int wan = n / 10000;
        int qian = (n - wan * 10000) / 1000;
        int bai = (n - wan * 10000 - qian * 1000) / 100;

        StringBuilder sb = new StringBuilder();
        sb.append("<i>").append(wan).append("</i>").append("万");
        sb.append("<i>").append(qian).append("</i>").append("千");
        sb.append("<i>").append(bai).append("</i>").append("百");

        return sb.toString();
    }

    public String getThumbImgUrl(String spec, String imgUrl) {
        return dictionaryService.choiceImgUrl(spec, imgUrl);
    }

}
