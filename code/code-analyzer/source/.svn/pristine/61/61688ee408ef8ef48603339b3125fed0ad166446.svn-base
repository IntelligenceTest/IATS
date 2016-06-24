package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.autostreets.biz.auction.enums.VehicleAgeRangeEnum;
import com.autostreets.biz.auction.enums.VehicleMileRangeEnum;
import com.autostreets.biz.auction.enums.VehiclePriceRangeEnum;
import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionExample;
import com.autostreets.biz.auction.model.AuctionPlace;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.pagination.Pagination1Utils;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionPlaceService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.cache.CacheService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.model.Member;
import com.autostreets.model.ad.AdDetail;
import com.autostreets.service.MemberService;
import com.autostreets.service.ad.AdPositionsService;
import com.autostreets.web.util.RequestUtils;
import com.autostreets.web.util.UserIdentityUtils;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 同步拍列表页
 * 
 * @author youpeng.zhang Date: 2015年8月28日 下午6:49:25
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/syncauction")
public class SyncAuctionController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SyncAuctionController.class);

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private AuctionPlaceService auctionPlaceService;

    @Autowired
    private MemberVehicleFavoriteService memberVehicleFavoriteService;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @Autowired
    private AdPositionsService adPositionsService;

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request) {
        List<Auction> auctionList = auctionService.selectAuctionListFP();
        List<AdDetail> advList = adPositionsService.getPositionAd(17, null, null, null);// 同步拍轮播广告
        model.addAttribute("advList", advList);
        model.addAttribute("auctionList", auctionList);
        return "syncauction/index";
    }

    @RequestMapping(value = "/detail/{id}")
    public String syncAuctionDetail(@PathVariable @ModelAttribute("id") Integer id,
            @RequestParam(required = false) Integer price, @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Integer mileage, @RequestParam(defaultValue = "1") int pageNumber,
            HttpServletRequest request, Model model) {
        int pageSize = 10;
        Auction auction = auctionService.selectByPrimaryKey(id);
        List<AuctionDictionary> auctionDictionarys = auctionDictionaryService.selectResource("auction_layer_on");
        if (auctionDictionarys != null && auctionDictionarys.size() > 0) {
            String value = auctionDictionarys.get(0).getValue();
            List<String> citys = new ArrayList<String>();
            citys.add("上海市");
            if ("1".equals(value) && citys.contains(auction.getCity())) {
                model.addAttribute("syncAuctionLayerBtnOn", 1);
            }
        }

        if (auction.getPlaceId() != null) {
            AuctionPlace auctionPlace = auctionPlaceService.selectByPrimaryKey(auction.getPlaceId());
            model.addAttribute("auctionPlace", auctionPlace);
        }

        Map<String, Object> params = Maps.newHashMap();
        params.put("auctionId", id);
        if (price != null && price != 0) {
            String range = VehiclePriceRangeEnum.lookup(price);
            String[] ss = range.split(",");
            if (!Strings.isNullOrEmpty(ss[0])) {
                params.put("startPriceMin", new BigDecimal(ss[0]).multiply(BigDecimal.valueOf(10000)));
            }
            if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
                params.put("startPriceMax", new BigDecimal(ss[1]).multiply(BigDecimal.valueOf(10000)));
            }
        }
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

        int count = auctionVehicleService.countAuctionVehicle(params);

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

        List<AuctionVehicle> auctionVehicleList = auctionVehicleService.findAuctionVehicle(params);

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberSid = null;
        if (userIdentity != null) {
            memberSid = userIdentity.getId();
        }

        String userVip = "0";
        Set<Integer> favoriteVehicleIds = Sets.newHashSet();
        if (StringUtils.isNotEmpty(memberSid)) {
            Member member = memberService.selectByPrimaryKey(memberSid);

            if (!("商户".equals(member.getMemberCategory()) && ("VIP1".equalsIgnoreCase(member.getMemberLevel())
                    || "SP".equalsIgnoreCase(member.getMemberLevel())))) {
                userVip = "0";
            } else {
                userVip = "1";
            }

            MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
            MemberVehicleFavoriteExample.Criteria mvfeCriteria = mvfe.createCriteria();
            mvfeCriteria.andMemberSidEqualTo(memberSid);

            List<MemberVehicleFavorite> memberVehicleFavoriteList = memberVehicleFavoriteService.selectByExample(mvfe);
            for (MemberVehicleFavorite mvf : memberVehicleFavoriteList) {
                favoriteVehicleIds.add(mvf.getAvId());
            }
            model.addAttribute("memberSid", member.getSid());
        }

        model.addAttribute("price", price);
        model.addAttribute("age", age);
        model.addAttribute("mileage", mileage);
        model.addAttribute("auction", auction);
        model.addAttribute("p", Pagination1Utils.newPagination(pageSize, pageNumber, count, auctionVehicleList));
        model.addAttribute("favoriteVehicleIds", favoriteVehicleIds);
        model.addAttribute("userVip", userVip);
        return "syncauction/detail";
    }

    @RequestMapping("/isVipMember")
    @ResponseBody
    public Boolean isVipMember(HttpServletRequest request) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberSid = null;
        if (userIdentity != null) {
            memberSid = userIdentity.getId();
        }
        if (StringUtils.isNotEmpty(memberSid)) {
            Member member = memberService.selectByPrimaryKey(memberSid);
            if ("VIP1".equalsIgnoreCase(member.getMemberLevel())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @RequestMapping(value = "/list")
    public String list(@RequestParam(defaultValue = "1") int pageNumber, HttpServletRequest request, Model model,
            Integer auctionPlaceId) {
        int pageSize = 10;
        AuctionExample ae = new AuctionExample();
        AuctionExample.Criteria aeCriteria = ae.createCriteria();
        aeCriteria.andStatusNotEqualTo(0);

        if (auctionPlaceId != null) {
            model.addAttribute("auctionPlaceId", auctionPlaceId);
            aeCriteria.andPlaceIdEqualTo(auctionPlaceId);
        }
        int count = auctionService.countByExample(ae);

        // ae.setOrderByClause("start_timestamp desc");
        // 1.拍卖中和等待竞拍按照是否专场排序，
        // 2.按状态排序 拍卖中 待拍卖 已结束
        // 3.按照拍卖会开始时间倒序排列
        ae.setOrderByClause(
                " if (status in (1, 2), is_special, 0) desc, if(status = 2, 0, status),start_timestamp desc");
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

        Pagination pagination = new Pagination();
        pagination.setCurrent(pageNumber);
        pagination.setCount(count);

        ae.setPagination(pagination);

        List<Auction> auctionList = auctionService.selectByExample(ae);

        // Get the pop page switch
        String popValue = auctionDictionaryService.selectPopSwitch();

        model.addAttribute("popValue", popValue);
        model.addAttribute("p", Pagination1Utils.newPagination(pageSize, pageNumber, count, auctionList));
        AuctionPlace auctionPlace = new AuctionPlace();
        auctionPlace.setEnabled(true);
        List<AuctionPlace> auctionPlaces = auctionPlaceService.getAuctionPlaceList(auctionPlace);
        model.addAttribute("auctionPlaces", auctionPlaces);
        return "syncauction/list";
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

    public String choiceModelPic(String spec, String src) {
        return auctionDictionaryService.choiceImgUrl(spec, src);
    }

    public String getAuctionAddress(Integer placeId) {
        if (placeId == null) {
            return null;
        }
        String cacheKey = "auctionPlace_" + placeId;
        AuctionPlace auctionPlace = (AuctionPlace) cacheService.get(cacheKey);
        if (auctionPlace == null) {
            auctionPlace = auctionPlaceService.selectByPrimaryKey(placeId);
            cacheService.set(cacheKey, auctionPlace);// 在拍卖后台中有改变时，会清掉缓存
        }
        return auctionPlace.getAddr();
    }
}
