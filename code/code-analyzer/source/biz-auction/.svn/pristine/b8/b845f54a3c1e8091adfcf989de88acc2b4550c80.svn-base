package com.autostreets.biz.auction.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionPlace;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionPlaceService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.biz.auction.web.utils.UserIdentityUtils;
import com.autostreets.framework.common.utils.DateUtils;
import com.autostreets.model.Member;
import com.autostreets.model.News;
import com.autostreets.model.ad.AdDetail;
import com.autostreets.service.MemberService;
import com.autostreets.service.NewsService;
import com.autostreets.service.ad.AdPositionsService;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

@Controller
public class IndexController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private AuctionService auctionService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private AdPositionsService adPositionsService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private AuctionPlaceService auctionPlaceService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private AuctionDictionaryService dictionaryService;

    @Autowired
    private MemberVehicleFavoriteService memberVehicleFavoriteService;

    /**
     * 拍卖首页
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月14日 上午10:25:29
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/")
    public String index(Model model, HttpServletRequest request) {
        // 拍卖场次
        List<News> auctionNumbers = newsService.selectNewsByType(1);
        model.addAttribute("auctionNumbers", auctionNumbers);
        // 常见问题
        List<News> auctionProblems = newsService.selectNewsByType(2);
        model.addAttribute("auctionProblems", auctionProblems);
        List<Auction> auctions = auctionService.selectAuctionListFP();
        if (auctions != null && auctions.size() > 2) {
            auctions = auctions.subList(0, 2);
        }
        model.addAttribute("auctions", auctions);
        model.addAttribute("now", new Date());
        List<AdDetail> advList = adPositionsService.getPositionAd(16, null, null, null);// 竞拍大厅轮播广告
        model.addAttribute("advList", advList);
        int pageSize = 3;
        Map<String, Object> params = Maps.newHashMap();
        Date currentDate = new Date();
        Date dateStart = DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH);
        params.put("dateStart", dateStart);
        // params.put("status", 5);
        params.put("offset", 0);
        params.put("auctionType", 1);
        params.put("limit", pageSize);
        List<AuctionVehicle> auctionVehicleList = auctionVehicleService.findAuctionVehicle1(params);// 竞拍中的车

        List<AuctionVehicle> auctionVehicleListnew = new ArrayList<AuctionVehicle>();
        try {
            if (auctionVehicleList != null) {
                int size = auctionVehicleList.size();
                for (int i = 0; i < size; i++) {
                    if (auctionVehicleList.get(i).getStatus().equals(1)
                            || auctionVehicleList.get(i).getStatus().equals(5)) {
                        auctionVehicleListnew.add(auctionVehicleList.get(i));
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            // logger.error(e.getMessage());
        }

        model.addAttribute("auctionVehicleList", auctionVehicleListnew);
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberSid = null;
        if (userIdentity != null) {
            memberSid = userIdentity.getId();
        }
        Set<Integer> favoriteVehicleIds = Sets.newHashSet();
        String priceDisp = "0";
        Boolean isSp = false;
        if (org.apache.commons.lang.StringUtils.isNotEmpty(memberSid)) {
            MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
            MemberVehicleFavoriteExample.Criteria mvfeCriteria = mvfe.createCriteria();
            mvfeCriteria.andMemberSidEqualTo(memberSid);
            List<MemberVehicleFavorite> memberVehicleFavoriteList = memberVehicleFavoriteService.selectByExample(mvfe);
            for (MemberVehicleFavorite mvf : memberVehicleFavoriteList) {
                favoriteVehicleIds.add(mvf.getAvId());
            }
            Member member = memberService.selectByPrimaryKey(memberSid);
            if ("商户".equals(member.getMemberCategory()) && "VIP1".equalsIgnoreCase(member.getMemberLevel())) {
                priceDisp = "1";
            } else {
                priceDisp = "0";
            }
            if ("商户".equals(member.getMemberCategory()) && "SP".equalsIgnoreCase(member.getMemberLevel())) {
                isSp = true;
            }
        }
        model.addAttribute("priceDisp", priceDisp);
        model.addAttribute("isSp", isSp);
        model.addAttribute("favoriteVehicleIds", favoriteVehicleIds);
        return "/index";
    }

    @RequestMapping(value = "/eqs")
    public String toEqs(Model model, HttpServletRequest request) {
        return "auctionhall/eqs";
    }

    @RequestMapping(value = "/center")
    public String toCenter(Model model, HttpServletRequest request) {
        AuctionPlace auctionPlace = new AuctionPlace();
        auctionPlace.setEnabled(true);
        List<AuctionPlace> avpList = auctionPlaceService.getAuctionPlaceList(auctionPlace);
        model.addAttribute("avpList", avpList);
        return "auctionhall/center";
    }

    public String getAuctionPicUrl(Integer auctionPlaceId) {
        if (auctionPlaceId != null) {
            AuctionPlace auctionPlace = auctionPlaceService.selectByPrimaryKey(auctionPlaceId);
            if (StringUtils.isNotBlank(auctionPlace.getPicUrl())) {
                return auctionPlace.getPicUrl();
            }
            return null;
        }
        return null;
    }

    public Integer compareDate(Date startTime, Date endTime) {
        Date now = new Date();
        if (startTime.after(now)) {
            return 1;// 即将开始
        }
        if (startTime.before(now) && endTime.after(now)) {
            return 0;// 正在竞拍中
        }
        if (endTime.before(now)) {
            return -1;// 已经结束
        }
        return 0;
    }

    public String choiceModelPic(String spec, String src) {
        return dictionaryService.choiceImgUrl(spec, src);
    }

    public String getAuctionAddress(Integer placeId) {
        if (placeId == null) {
            return null;
        }
        AuctionPlace auctionPlace = auctionPlaceService.selectByPrimaryKey(placeId);
        return auctionPlace.getAddr();
    }

    public String getThumbImgUrl(String spec, String imgUrl) {
        return dictionaryService.choiceImgUrl(spec, imgUrl);
    }
}
