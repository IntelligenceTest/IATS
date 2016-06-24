/*
 * Copyright (C), 2013-2014, 宝信汽车集团股份有限公司
 * FileName: MenberController.java
 * Author:   mengzhao
 * Date:     2014年7月11日 
 * Description: 会员中心controller
 */
package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.constants.OrderConstans;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.FixedPriceExample;
import com.autostreets.biz.auction.model.MemberVehicle;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.pagination.Pagination1Utils;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.biz.auction.service.MemberVehicleService;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.web.utils.StringUtil;
import com.autostreets.biz.auction.web.utils.UserIdentityUtils;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.utils.RequestUtils;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.model.Member;
import com.autostreets.model.MemberFavorite;
import com.autostreets.model.MemberFavoriteExample;
import com.autostreets.model.base.BaseMemberFavoriteExample.Criteria;
import com.autostreets.service.MemberFavoriteService;
import com.autostreets.service.MemberService;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.collect.Maps;

/**
 * 会员中心
 * 
 * @author zxf
 */
@Controller
@RequestMapping("/member")
public class MemberController extends PaginationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    /**
     * 会员信息服务类注入
     */
    @Autowired
    private MemberService memberService;

    /**
     * 车辆服务类注入
     */
    @Autowired
    private MemberVehicleService memberVehicleService;

    /**
     * 我的关注服务类
     */
    @Autowired
    MemberVehicleFavoriteService memberVehicleFavoriteService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    AuctionVehicleService auctionVehicleService;

    @Autowired
    FixedPriceService fixedPriceService;

    /**
     * 字典表服务类
     */
    @Autowired
    private AuctionDictionaryService dictionaryService;

    @Autowired
    private MemberFavoriteService memberFavoriteService;

    @Autowired
    private BidService bidService;

    /**
     * 查询会员竞得的车辆信息
     */
    @RequestMapping(value = "/auctionedvehicle")
    public String acutionedVehicle(@RequestParam(defaultValue = "1") int pageNumber, HttpServletRequest request,
            Model model) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        }
        // 查询会员竞得车辆总数
        int count = memberVehicleService.getMemberAuctionedVehicleCount(memberId);
        // 查询会员竞得车辆信息
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("offset", (pageNumber - 1) * 10);
        params.put("limit", 10);
        params.put("sid", memberId);
        List<Order> memberVehicleList = memberVehicleService.listMemberAuctionedVehicle(params);
        for (Order order : memberVehicleList) {
            if (order.getItem().getBuyerCommissionFee() == null) {
                order.getItem().setBuyerCommissionFee(new BigDecimal(0));
            }
            if (order.getItem().getLicenseFee() == null) {
                order.getItem().setLicenseFee(new BigDecimal(0));
            }
            if (order.getItem().getExWarehouseFee() == null) {
                order.getItem().setExWarehouseFee(new BigDecimal(0));
            }
        }
        model.addAttribute("p", Pagination1Utils.newPagination(10, pageNumber, count, memberVehicleList));
        return "member/auctionedvehicle";
    }

    /**
     * 用户的二手车订单列表
     * 
     * @param pageNumber
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/usedCarOrder")
    public String oldCarOrder(@RequestParam(defaultValue = "1") int pageNumber, HttpServletRequest request,
            Model model) {
        int pageSize = 5;
        // String memberId = getMemberSid();
        // 获得二手车订单总数
        HashMap<String, Object> params = new HashMap<String, Object>();
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        }
        params.put("userID", memberId);
        params.put("saleType", 0); // 0-一口价 1-同步拍 2-在线拍
        int count = orderService.countOrderByUserID(params);

        params.put("offset", (pageNumber - 1) * pageSize);
        params.put("limit", pageSize);
        List<Order> orderList = orderService.findOrderByUserID(params);
        for (Order oItem : orderList) {
            OrderItem orderItem = orderItemService.selectOrderItemByOrderId(oItem.getId());
            oItem.setItem(orderItem);
            Vehicle vehicle = vehicleService.selectByPrimaryKey(orderItem.getVehicleId());
            oItem.setVehicle(vehicle);
        }

        model.addAttribute("p", Pagination1Utils.newPagination(pageSize, pageNumber, count, orderList));
        return "member/usedCarOrder";
    }

    /**
     * 查询会员出价的车辆信息
     */
    @RequestMapping(value = "/biddedvehicle")
    public String biddedVehicle(@RequestParam(defaultValue = "1") int pageNumber, HttpServletRequest request,
            Model model) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        }
        // 查询会员出价车辆总数
        int count = memberVehicleService.getMemberBiddedVehicleCount(memberId);
        // 查询出价车辆信息
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("offset", (pageNumber - 1) * 10);
        params.put("limit", 10);
        params.put("sid", memberId);
        List<MemberVehicle> memberVehicleList = memberVehicleService.listMemberBiddedVehicle(params);
        model.addAttribute("p", Pagination1Utils.newPagination(10, pageNumber, count, memberVehicleList));
        return "member/biddedvehicle";
    }

    // /**
    // * 查询会员关注过的车辆信息
    // */
    // @RequestMapping(value = "/favoritevehicle")
    // public String favoriteVehicle(@RequestParam(defaultValue = "1") int
    // pageNumber, HttpServletRequest request,
    // Model model) {
    // UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
    // String memberId = null;
    // if (userIdentity != null) {
    // memberId = userIdentity.getId();
    // }
    // // 查询会员出价车辆总数
    // int count = memberVehicleService.getMemberFavoriteVehicleCount(memberId);
    // // 查询会员关注过的车辆信息
    // HashMap<String, Object> params = new HashMap<String, Object>();
    // params.put("offset", (pageNumber - 1) * 10);
    // params.put("limit", 10);
    // params.put("sid", memberId);
    // List<MemberVehicle> memberVehicleList =
    // memberVehicleService.listMemberFavoriteVehicle(params);
    // model.addAttribute("p", Pagination1Utils.newPagination(10, pageNumber,
    // count, memberVehicleList));
    // return "member/favoritevehicle";
    // }

    /**
     * 我的收藏页面
     * 
     * @param pageNumber
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/favorites")
    public String favorites(@RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "0") String type, HttpServletRequest request, Model model) {
        int pageSize = 10;
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        } else {
            // 调到登陆页面

        }

        // 新车收藏数量
        HashMap<String, Object> params = new HashMap<String, Object>();
        params = new HashMap<String, Object>();
        params.put("type", "0");
        params.put("memberSid", memberId);
        int newcarFavCount = memberFavoriteService.getMemberFavoriteCountByType(params);

        // 展厅(二手车)收藏
        MemberFavoriteExample favorite = new MemberFavoriteExample();
        Criteria criteria = favorite.createCriteria();
        criteria.andMemberSidEqualTo(memberId);
        criteria.andTypeEqualTo("1");
        criteria.andEnabledEqualTo(true);
        int noHaggleCount = 0;

        MemberVehicleFavorite mf = new MemberVehicleFavorite();
        mf.setMemberSid(memberId);
        // 拍卖数量
        Pagination pagination = new Pagination();
        pagination.setCurrent(pageNumber);
        mf.setPagination(pagination);
        int avFavCount = memberVehicleFavoriteService.getMemberFavoriteVehicleCount(mf);

        favorite.setPagination(null);
        List<MemberFavorite> noHaggleFavList = memberFavoriteService.selectByExample(favorite);
        List<FixedPrice> fixedPriceList = null;
        if (!CollectionUtils.isEmpty(noHaggleFavList)) {
            List<Integer> fpIds = new ArrayList<Integer>();
            for (MemberFavorite memberFav : noHaggleFavList) {
                fpIds.add(Integer.valueOf(memberFav.getRefSid()));
            }
            FixedPriceExample fpExample = new FixedPriceExample();
            com.autostreets.biz.auction.model.base.BaseFixedPriceExample.Criteria crt = fpExample.createCriteria();
            crt.andLatestEqualTo(true);
            crt.andIdIn(fpIds);
            fixedPriceList = fixedPriceService.selectByExample(fpExample);
            noHaggleCount = fixedPriceList.size();
        }
        if (type.equals("1")) {
            model.addAttribute("p",
                    Pagination1Utils.newPagination(pageSize, pageNumber, noHaggleCount, fixedPriceList));
        } else if (type.equals("2")) {

            List<MemberVehicleFavorite> avFavList = memberVehicleFavoriteService.getMemberFavoriteVehicle(mf);
            if (avFavList.size() > 0) {
                for (MemberVehicleFavorite mvf : avFavList) {
                    AuctionVehicle av = auctionVehicleService.selectByPrimaryKey(mvf.getAvId());
                    mvf.setAuctionVehicle(av);
                    Vehicle vehicle = vehicleService.selectByPrimaryKey(av.getVehicleId());
                    mvf.setVehicle(vehicle);
                }
            }
            model.addAttribute("p", Pagination1Utils.newPagination(pageSize, pageNumber, avFavCount, avFavList));
        }
        String priceDisp = "0";
        if (StringUtils.isNotBlank(memberId)) {
            Member member = memberService.selectByPrimaryKey(memberId);
            // Check user category and level
            if ("商户".equals(member.getMemberCategory()) && "VIP1".equalsIgnoreCase(member.getMemberLevel())) {
                priceDisp = "1";
            } else {
                priceDisp = "0";
            }
        }

        model.addAttribute("noHaggleCount", noHaggleCount);
        model.addAttribute("newcarFavCount", newcarFavCount);
        model.addAttribute("avFavCount", avFavCount);
        model.addAttribute("type", type);
        model.addAttribute("priceDisp", priceDisp);

        return "member/favoriteList";
    }

    // 获得fixprice
    public FixedPrice getFixPriceBuyRefId(String refId) {
        if (StringUtils.isNotBlank(refId)) {
            return fixedPriceService.selectByPrimaryKey(Integer.valueOf(refId));
        }
        return null;
    }

    // 获得收藏的车辆
    public Vehicle getVehicleInfoRefId(String vehicleId) {
        return vehicleService.selectByPrimaryKey(Integer.valueOf(vehicleId));
    }

    /**
     * 删除我的关注
     * 
     * @param response
     * @param fId
     */
    @RequestMapping(value = "/deleteById")
    public @ResponseBody String deleteById(HttpServletResponse response, Integer fId) {
        String rtnMsg = "";
        try {
            if (fId != null) {
                memberVehicleFavoriteService.deleteByPrimaryKey(fId);
                rtnMsg = "0";
            }
        } catch (Exception e) {
            rtnMsg = "1";
            e.printStackTrace();
        }
        return rtnMsg;
    }

    /**
     * 用户收藏 - 新增
     * 
     * @author chunfeng.huang
     * @param avId
     * @param request
     * @param response
     */
    @RequestMapping(value = "/favorite/new", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addFavorite(String refID, String orgID, Integer type,
            HttpServletRequest request, HttpServletResponse response) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        }
        Map<String, Object> result = Maps.newHashMap();

        if (StringUtils.isBlank(memberId)) {
            result.put("success", false);
            return result;
        }

        MemberFavorite mf = new MemberFavorite();
        mf.setType(type.toString());
        mf.setRefSid(refID);
        mf.setOrgSid(orgID);
        mf.setMemberSid(memberId);
        mf.setCreateTime(new Date());
        mf.setEnabled(true);

        mf = memberFavoriteService.insert(mf);

        result.put("success", true);

        if (mf != null) {
            // fixbug，展厅收藏数量+1
            fixedPriceService.updateFavCount(Integer.parseInt(refID), true);
            // end;
            result.put("id", mf.getId());
        } else {
            result.put("id", 0);
        }
        return result;
    }

    /**
     * 用户收藏-取消 (方式一：根据id直接取消)
     * 
     * @author chunfeng.huang
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping(value = "/favorite/cancel", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> cancelFavorite(int id, HttpServletRequest request,
            HttpServletResponse response) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        }
        Map<String, Object> result = Maps.newHashMap();

        if (StringUtils.isBlank(memberId)) {
            result.put("success", false);
            return result;
        }

        MemberFavoriteExample example = new MemberFavoriteExample();
        MemberFavoriteExample.Criteria criteria = example.createCriteria();
        criteria.andRefSidEqualTo(String.valueOf(id));
        criteria.andEnabledEqualTo(true);
        criteria.andMemberSidEqualTo(memberId);
        MemberFavorite mf = new MemberFavorite();
        mf.setEnabled(false);
        mf.setModifyTime(new Date());

        int ret = memberFavoriteService.updateByExampleSelective(mf, example);
        if (ret > 0) {
            // fixbug，展厅收藏数量-1
            fixedPriceService.updateFavCount(id, false);
            // end;
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        return result;
    }

    /**
     * 用户收藏-取消 (方式二：根据refId, type, memberSid取消)
     * 
     * @author chunfeng.huang
     * @param type
     * @param refId
     * @param request
     * @param response
     */
    @RequestMapping(value = "/favorite/toCancel", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> cancelFavoriteByRefId(String refID, Integer type, String orgSid,
            HttpServletRequest request, HttpServletResponse response) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        }
        Map<String, Object> result = Maps.newHashMap();

        if (StringUtils.isBlank(memberId)) {
            result.put("success", false);
            return result;
        }

        MemberVehicleFavoriteExample mfe = new MemberVehicleFavoriteExample();
        MemberVehicleFavoriteExample.Criteria cri = mfe.createCriteria();
        cri.andTypeEqualTo(type);
        // cri.andRefSidEqualTo(refID);
        if (orgSid != null) { // just for newcar
            // cri.andOrgSidEqualTo(orgSid);
        }
        cri.andMemberSidEqualTo(memberId);

        MemberVehicleFavorite mf = new MemberVehicleFavorite();
        /*
         * mf.setEnabled(false); mf.setModifyTime(new Date());
         */
        int ret = memberVehicleFavoriteService.updateByExampleSelective(mf, mfe);
        if (ret > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }

        return result;
    }

    /**
     * 缩略图
     */
    @Override
    public String getThumbImgUrl(String spec, String imgUrl) {
        return dictionaryService.choiceImgUrl(spec, imgUrl);
    }

    /**
     * 查询拍品最高出价以及商议价格
     */
    @RequestMapping(value = "/getmaxbidprice")
    @ResponseBody
    public JsonResult getmaxbidprice(Integer avId, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        JsonResult jsonResult = new JsonResult();
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (auctionVehicle == null) {
            LOGGER.warn("无此拍品");
        }
        BigDecimal maxBidPrice = auctionVehicle.getMaxBidPrice();
        BigDecimal finalBidPrice = auctionVehicle.getFinalBidPrice();
        map.put("maxBidPrice", maxBidPrice);
        map.put("finalBidPrice", finalBidPrice);
        jsonResult.setData(map);
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    /**
     * 追加价格
     */
    @RequestMapping(value = "/addbid")
    @ResponseBody
    public JsonResult addbid(Integer avId, Model model, HttpServletRequest request) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        } else {
            return null;
        }
        Member member = memberService.selectByPrimaryKey(memberId);
        JsonResult jsonResult = new JsonResult();
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (auctionVehicle == null || !auctionVehicle.getStatus().equals(3)) {
            return new JsonResult(false, "拍品状态不正确!");
        }

        Bid bid = new Bid();
        bid.setAuctionVehicleId(avId);
        bid.setBidderSid(memberId);
        bid.setBidderUsername(member.getUsername());
        bid.setBidderName(member.getName());
        bid.setBidTimestamp(new Date());
        bid.setOriginPrice(auctionVehicle.getFinalBidPrice());
        bid.setPrice(auctionVehicle.getFinalBidPrice());
        bid.setIp(RequestUtils.getClientIp(request));
        bid.setMsg(false);
        bid.setContent(StringUtil.mask(bid.getBidderUsername()) + " 出价 " + bid.getPrice().toString() + " 元");
        bidService.insert(bid);
        auctionVehicle.setMaxBidPrice(auctionVehicle.getFinalBidPrice());
        auctionVehicle.setFinalBidStatus(2);
        auctionVehicleService.updateByPrimaryKey(auctionVehicle);
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    /**
     * 提车
     */
    @RequestMapping(value = "/tiche")
    @ResponseBody
    public JsonResult tiche(Integer orderId, Model model, HttpServletRequest request) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        if (userIdentity == null) {
            return null;
        }
        if (orderId == null) {
            LOGGER.error("参数错误!");
            return null;
        }
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
        JsonResult jsonResult = new JsonResult();
        if (orderItem != null) {
            orderItem.setStatus(OrderConstans.ORDER_STATUS_DEAL_SUCCESS);// 交易成功
            Order order = orderService.selectByPrimaryKey(orderId);
            order.setUpdateTime(new Date());
            orderService.updateByPrimaryKey(order);// 修改更新时间
            orderItemService.updateByPrimaryKey(orderItem);// 修改订单状态
            jsonResult.setSuccess(true);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/paydetail/{orderId}", method = RequestMethod.GET)
    public String orderDetail(@PathVariable @ModelAttribute("orderId") Integer orderId, HttpServletRequest request,
            Model model) {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }

        // 订单信息
        Order order = orderService.selectByPrimaryKey(orderId);
        if (order == null) {
            return null;
        }
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        if (userIdentity == null || !userIdentity.getId().equals(order.getBidderSid())) {
            return null;
        }
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
        if (orderItem.getBuyerCommissionFee() == null) {
            orderItem.setBuyerCommissionFee(new BigDecimal(0));
        }
        if (orderItem.getLicenseFee() == null) {
            orderItem.setLicenseFee(new BigDecimal(0));
        }
        if (orderItem.getExWarehouseFee() == null) {
            orderItem.setExWarehouseFee(new BigDecimal(0));
        }
        order.setItem(orderItem);
        Vehicle v = vehicleService.selectByPrimaryKey(orderItem.getVehicleId());
        order.setVehicle(v);

        model.addAttribute("prepayOrder", order);

        return "member/orderDetail";
    }
}
