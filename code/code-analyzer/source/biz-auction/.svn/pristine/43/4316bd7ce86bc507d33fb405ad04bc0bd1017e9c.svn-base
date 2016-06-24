package com.autostreets.biz.auction.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.enums.BusinessIdRuleEnum;
import com.autostreets.biz.auction.enums.VehicleAgeRangeEnum;
import com.autostreets.biz.auction.enums.VehicleMileRangeEnum;
import com.autostreets.biz.auction.enums.VehiclePriceRangeEnum;
import com.autostreets.biz.auction.mapper.AuctionVehicleMapper;
import com.autostreets.biz.auction.mapper.VehicleSyncFailLogMapper;
import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.BidExample;
import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.model.VehicleSyncFailLog;
import com.autostreets.biz.auction.model.VehicleTempLog;
import com.autostreets.biz.auction.model.base.BaseAuctionVehicleExample.Criteria;
import com.autostreets.biz.auction.pagination.Pagination1;
import com.autostreets.biz.auction.pagination.Pagination1Utils;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.service.VehicleTempLogService;
import com.autostreets.biz.auction.utils.BizUtils;
import com.autostreets.biz.auction.utils.MsgPhshUtils;
import com.autostreets.biz.cms.service.AppModelService;
import com.autostreets.biz.cms.service.AppMsgPushTriggerService;
import com.autostreets.biz.cms.service.DrawDictionaryService;
import com.autostreets.biz.common.utils.DateUtil;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.biz.usedvehicle.enums.SaleStatusEnum;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.usedvehicle.service.vehicle.UsedvehicleDealerService;
import com.autostreets.biz.workflow.exception.WorkflowException;
import com.autostreets.biz.workflow.model.StockRemoval;
import com.autostreets.biz.workflow.service.StockRemovalService;
import com.autostreets.biz.wtms.dto.RepairFee;
import com.autostreets.biz.wtms.dto.RepaireFeeQueryBean;
import com.autostreets.biz.wtms.dto.VehicleInventory;
import com.autostreets.biz.wtms.enums.StockStatus;
import com.autostreets.biz.wtms.service.WmsService;
import com.autostreets.cache.CacheService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.model.Member;
import com.autostreets.service.MemberService;
import com.autostreets.service.common.BizIdService;
import com.autostreets.util.StringUtil;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service("auctionVehicleService")
public class AuctionVehicleServiceImpl extends GenericServiceImpl<AuctionVehicle, AuctionVehicleExample, Integer>
        implements AuctionVehicleService {

    private final static Logger LOGGER = LoggerFactory.getLogger(AuctionVehicleServiceImpl.class);

    @Autowired
    private AuctionVehicleMapper auctionVehicleMapper;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private com.autostreets.biz.usedvehicle.service.vehicle.VehicleService usedVehicleService;

    @Autowired
    private UsedvehicleDealerService usedvehicleDealerService;

    @Autowired
    private BidService bidService;

    @Autowired
    private MemberVehicleFavoriteService memberVehicleFavoriteService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private VehicleTempLogService vehicleTempLogService;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @Autowired
    private BizIdService bizIdService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private WmsService wmsService;

    @Autowired
    private StockRemovalService stockRemovalService;

    @Autowired
    private VehicleSyncFailLogMapper vehicleSyncFailLogMapper;

    @Autowired
    private DrawDictionaryService drawDictionaryService;

    @Autowired
    private AppModelService appModelService;

    @Autowired
    private AppMsgPushTriggerService appMsgPushTriggerService;

    @Override
    protected GenericMapper<AuctionVehicle, AuctionVehicleExample, Integer> getGenericMapper() {
        return auctionVehicleMapper;
    }

    @Override
    public Pagination1<AuctionVehicle> selectOnlinePage(Integer price, Integer age, Integer mileage, String city,
            boolean recommend, Integer dateflag, Integer status, int pageNumber, int pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("auctionType", 1);
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
                params.put("displayMileageMin", new BigDecimal(ss[0] + "0000"));
            }
            if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
                params.put("displayMileageMax", new BigDecimal(ss[1] + "0000"));
            }
        }
        if (status != null) {
            params.put("status", status);
        }
        params.put("city", city);
        if ((dateflag != null) && (dateflag != 0)) {
            if (dateflag == 1) { // 竞拍中
                params.put("status", 5);
            } else if (dateflag == 2) { // 等待竞拍
                params.put("status", 1);
            }
        } else {
            Date currentDate = new Date();
            Date dateStart = DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH);
            params.put("dateStart", dateStart);
        }
        if (recommend) {
            params.put("recommend", recommend);
        } else {
            params.put("recommend", null);
        }

        int count = countAuctionVehicle1(params);

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

        List<AuctionVehicle> auctionVehicleList = findAuctionVehicle1(params);

        return Pagination1Utils.newPagination(pageSize, pageNumber, count, auctionVehicleList);
    }

    @Override
    public Map<String, Object> loadVehicleInfo(Integer avId, String loginUserId) {
        Map<String, Object> map = Maps.newHashMap();
        AuctionVehicle auctionVehicle = auctionVehicleMapper.selectByPrimaryKey(avId);
        if (auctionVehicle == null) {
            return null;
        }
        map.put("auctionVehicle", auctionVehicle);
        Integer vehicleId = auctionVehicle.getVehicleId();

        // 前提条件: 在线拍 type=1
        if (null == vehicleId || 1 != auctionVehicle.getAuctionType()) {
            LOGGER.error("参数错误或非在线拍拍品");
            return null;
        }

        VehicleInfo vehicle = vehicleService.loadVehicleInfo(vehicleId);

        String featureItems = vehicle.getFeatureItems(); // 获取车辆配置信息
        String[] featureItem = featureItems.split(","); // 以逗号分割
        map.put("vehicle", vehicle);

        List<Bid> bidList = BizUtils.getBidList(bidService, avId, null, false); // 获得拍品的出价记录

        String isFavorite = "0";
        List<Bid> myBidList = Lists.newArrayList();
        boolean isTopPrice = false;
        String priceDisp = "0";

        Member member = null;
        if (loginUserId != null) {
            MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
            MemberVehicleFavoriteExample.Criteria mvfeCriteria = mvfe.createCriteria();
            mvfeCriteria.andMemberSidEqualTo(loginUserId);
            mvfeCriteria.andAvIdEqualTo(avId);

            List<MemberVehicleFavorite> memberVehicleFavoriteList = memberVehicleFavoriteService.selectByExample(mvfe);
            if (memberVehicleFavoriteList != null && memberVehicleFavoriteList.size() > 0) {
                isFavorite = "1";
            }

            myBidList = BizUtils.getBidList(bidService, avId, loginUserId, false); // 当前用户的出价记录
            isTopPrice = BizUtils.isTopPrice(bidList, myBidList);

            member = memberService.selectByPrimaryKey(loginUserId);
            // Check user category and level
            if (member != null && "商户".equals(member.getMemberCategory())
                    && ("VIP1".equalsIgnoreCase(member.getMemberLevel())
                            || "SP".equalsIgnoreCase(member.getMemberLevel()))) {
                priceDisp = "1";
            } else {
                priceDisp = "0";
            }
        }

        Boolean isSp = false;
        if (member != null && "商户".equals(member.getMemberCategory())
                && "SP".equalsIgnoreCase(member.getMemberLevel())) {
            isSp = true;
        }
        map.put("isSp", isSp);

        // 显示当前用户的最新出价
        BigDecimal myBidPrice;
        if (myBidList.isEmpty()) {
            myBidPrice = BigDecimal.ZERO;
        } else {
            myBidPrice = myBidList.get(0).getPrice();
        }

        map.put("isTopPrice", isTopPrice);
        map.put("myBidPrice", myBidPrice);

        Date endTime;
        if (auctionVehicle.getOnlineEndTime() != null) {
            endTime = auctionVehicle.getOnlineEndTime();
        } else {
            endTime = auctionVehicle.getPlanEndTime();
        }

        // 若当前拍品状态为成交确认，且当前用户出价为最高，则进行购买引导
        boolean isAlert = false;
        long restSeconds = 0;
        Integer intPriceDiff = 0;
        Integer intTimeDiff = 0;
        if (auctionVehicle.getStatus().equals(3)) {
            if (isTopPrice) {
                // 是否是无底价拍品
                if (auctionVehicle.getAvType().equals(1)) {
                    isAlert = true;
                } else {
                    // Get price-diff, time-diff configuration
                    intPriceDiff = auctionDictionaryService.selectPriceDiff();
                    intTimeDiff = auctionDictionaryService.selectTimeDiff();
                    // 在限定的时间段内，且差价小于等于设置的差价
                    Date currDate = new Date();
                    Date newDate = DateUtils.addMinutes(endTime, intTimeDiff);
                    if (!newDate.before(currDate)) {
                        if (auctionVehicle.getReservePrice().subtract(myBidPrice)
                                .compareTo(BigDecimal.valueOf(intPriceDiff)) <= 0) {
                            isAlert = true;
                            restSeconds = (newDate.getTime() - currDate.getTime()) / 1000;
                            if (restSeconds < 0) {
                                restSeconds = 0;
                            }
                            long rh = restSeconds / 3600;
                            long rm = (restSeconds - rh * 3600) / 60;
                            long rs = restSeconds - rh * 3600 - rm * 60;
                            map.put("restHms", String.format("%02d:%02d:%02d", rh, rm, rs));
                        }
                    }
                }
            }
        }

        map.put("priceDisp", priceDisp);
        map.put("isAlert", isAlert);
        map.put("restSeconds", restSeconds);

        map.put("priceDiff", intPriceDiff);
        map.put("timeDiff", intTimeDiff);

        map.put("vehicle", vehicle);
        map.put("auctionVehicle", auctionVehicle);
        map.put("featureItem", featureItem);
        map.put("isFavorite", isFavorite);

        // 显示距离结束的时间
        Date currentDate = new Date();
        long seconds = (endTime.getTime() - currentDate.getTime()) / 1000;
        if (seconds < 0) {
            seconds = 0;
        }

        long h = seconds / 3600;
        long m = (seconds - h * 3600) / 60;
        long s = seconds - h * 3600 - m * 60;

        map.put("seconds", seconds);
        map.put("hms", String.format("%02d:%02d:%02d", h, m, s));

        // 显示当前出价
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
        map.put("currentPrice", currentPrice);

        BigDecimal bidPrice;
        if (auctionVehicle.getPlusRange() != null && !bidList.isEmpty()) {
            bidPrice = currentPrice.add(BigDecimal.valueOf(auctionVehicle.getPlusRange().longValue()));
        } else {
            bidPrice = currentPrice;
        }

        int commission = BizUtils.calculateCommission(auctionDictionaryService, currentPrice, auctionVehicle);
        BigDecimal totalPrice = BizUtils.calculateTotalPrice(currentPrice, commission, auctionVehicle);

        map.put("bidCount", (bidList == null) ? 0 : bidList.size());
        map.put("hasBid", (bidList == null || bidList.isEmpty()) ? 0 : 1);
        map.put("bidPrice", bidPrice);
        map.put("commission", commission);
        map.put("totalPrice", totalPrice);

        return map;
    }

    @Override
    public List<Map<String, String>> listAuctionVehicleByAcutionId(Map<String, Integer> param) {
        return auctionVehicleMapper.listAuctionVehicleByAcutionId(param);
    }

    @Override
    public Pagination selectAuctionVehicles(Pagination pagination, AuctionVehicle auctionVehicle) {
        List<AuctionVehicle> auctions = null;

        // 总数
        int count = auctionVehicleMapper.selectAuctionVehiclesTotal(auctionVehicle);
        pagination.setCount(count);
        auctionVehicle.setPagination(pagination);

        auctions = auctionVehicleMapper.selectAuctionVehicles(auctionVehicle);
        // 计算佣金
        for (AuctionVehicle auctionVehicle2 : auctions) {
            if (auctionVehicle2.getFinalPrice() != null) {
                int commission = bidService.calculateCommission(auctionVehicle2.getFinalPrice(), auctionVehicle2);
                auctionVehicle2.setCommission(commission);
            }
        }
        pagination.setDataList(auctions);
        return pagination;
    }

    @Override
    public AuctionVehicle selectVehicle(AuctionVehicle av) {
        return auctionVehicleMapper.selectVehicle(av);
    }

    @Override
    public AuctionVehicle selectAuctionVehicle(AuctionVehicle av) {
        return auctionVehicleMapper.selectAuctionVehicle(av);
    }

    @Override
    public void updateAuctionVehicleOrder(Integer[] id, Integer[] auctionVehicleOrder) {
        AuctionVehicle av = null;
        for (int i = 0; i < id.length; i++) {
            av = new AuctionVehicle();
            av.setId(id[i]);
            if (auctionVehicleOrder[i] != null) {
                av.setAuctionVehicleOrder(auctionVehicleOrder[i]);
                auctionVehicleMapper.updateByPrimaryKeySelective(av);
            }
        }
    }

    @Override
    public void volumeSetPrice(Map<String, Object> params) {
        auctionVehicleMapper.volumeSetPrice(params);
    }

    @Override
    public Integer selectAvId(Map<String, Object> params) {
        return auctionVehicleMapper.selectAvId(params);
    }

    @Override
    public boolean updateTempVehicleInfo(Integer auctionVehicleId, Integer tempVehicleId, String vehicleCode) {
        try {
            VehicleInfo vehicle = usedVehicleService.selectVehicleByCode(vehicleCode);// 拍品的车
            if (auctionVehicleId == null) {
                return false;
            }

            AuctionVehicle av = selectByPrimaryKey(auctionVehicleId);
            av.setVehicleId(vehicle.getId());
            int count = updateAuctionVehicle(av);

            if (count == 0) {
                return false;
            }

            VehicleInfo tempvehicle = vehicleService.selectVehicleInfoById(tempVehicleId); // 临时拍品的车
            VehicleInfo tempVehicleInfo = new VehicleInfo();
            tempVehicleInfo.setCode(tempvehicle.getCode());
            tempVehicleInfo.setDelFlag(true);
            usedvehicleDealerService.vehicleSave(tempVehicleInfo);

            List<OrderItem> orderList = orderItemService.getOrderItemByAuctionId(tempVehicleId, auctionVehicleId);
            for (OrderItem order : orderList) {
                order.setVehicleId(vehicle.getId());
                orderItemService.updateByPrimaryKey(order);
            }

            // 修改拍品的状态
            VehicleInfo vehicleInfo = new VehicleInfo();
            vehicleInfo.setSaleStatus(tempvehicle.getSaleStatus().shortValue());
            vehicleInfo.setCode(vehicle.getCode());
            usedvehicleDealerService.vehicleSave(vehicleInfo);

            VehicleTempLog vehicleTempLog = new VehicleTempLog();
            vehicleTempLog.setTempVehicleId(tempVehicleId);
            vehicleTempLog.setVehicleId(vehicle.getId());
            vehicleTempLog.setCreatedTime(new Date());
            vehicleTempLogService.insert(vehicleTempLog);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public int updateAuctionVehicle(AuctionVehicle av) {
        return auctionVehicleMapper.updateByPrimaryKey(av);
    }

    @Override
    public List<AuctionVehicle> selectTempVehicleAuctionVehicle(Integer tempVehicleId) {
        AuctionVehicleExample ave = new AuctionVehicleExample();
        Criteria criteria = ave.createCriteria();
        criteria.andVehicleIdEqualTo(tempVehicleId);
        List<Integer> statusList = new ArrayList<Integer>();
        statusList.add(1);
        statusList.add(2);
        statusList.add(5);
        statusList.add(6);
        criteria.andStatusIn(statusList);
        return auctionVehicleMapper.selectByExample(ave);
    }

    @Override
    public boolean isVehicleToFixedprice(Integer vehicleId) {
        boolean result = true;
        AuctionVehicleExample ave = new AuctionVehicleExample();
        Criteria criteria = ave.createCriteria();
        criteria.andVehicleIdEqualTo(vehicleId);
        List<Integer> statusList = new ArrayList<Integer>();
        statusList.add(0);
        statusList.add(1);
        statusList.add(2);
        statusList.add(3);
        statusList.add(5);
        statusList.add(6);
        criteria.andStatusIn(statusList);
        List<AuctionVehicle> avList = auctionVehicleMapper.selectByExample(ave);
        if (avList != null && avList.size() > 0) {
            result = false;
        }
        return result;
    }

    @Override
    public int getOnlineAunctionCount() {
        int result = 0;
        // 当天key
        String avHis = new StringBuilder("avHis_").append(DateUtil.formatBusinessRuleDate("yyyy-MM-dd")).toString();
        Object cacheHisCount = cacheService.get(avHis);// 缓存历史在线拍数量

        String avToday = new StringBuilder("avToday_").append(DateUtil.formatBusinessRuleDate("yyyy-MM-dd")).toString();
        Object cacheTodayCount = cacheService.get(avToday);// 缓存当天车辆数量

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        if (cacheHisCount == null) {
            result = auctionVehicleMapper.getOnlineAunctionCount(); // 历史在线拍数量
            cacheService.set(avHis, result, new Date(24 * 60 * 60 * 1000));// 24小时过期
        } else {
            result = Integer.parseInt(String.valueOf(cacheHisCount));
        }

        int todayCount = 0;
        if (cacheTodayCount == null) {
            todayCount = auctionVehicleMapper.isOnlineAunction(); // 当天在线拍车辆数量
            cacheService.set(avToday, todayCount, new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));// 24小时过期
        } else {
            todayCount = Integer.parseInt(String.valueOf(cacheTodayCount));
        }

        if (todayCount >= 1) {
            if (new Date().getTime() > cal.getTimeInMillis()) {
                result = result * 2 + 2;
            } else {
                result = result * 2 + 1;
            }
        } else {
            result = result * 2;
        }

        return result;
    }

    @Override
    public List<AuctionVehicle> findAuctionVehicle1(Map<String, Object> params) {
        return auctionVehicleMapper.findAuctionVehicle1(params);
    }

    @Override
    public int countAuctionVehicle1(Map<String, Object> params) {
        return auctionVehicleMapper.countAuctionVehicle1(params);
    }

    @Override
    public List<AuctionVehicle> findAuctionVehicleRecommend() {
        return auctionVehicleMapper.findAuctionVehicleRecommend();
    }

    @Override
    public List<Map<String, Boolean>> getCityListforAuction() {
        Map<String, Object> params = Maps.newHashMap();
        params.put("auctionType", 1);
        return getCityListforAuction(params);
    }

    @Override
    public int countAuctionVehicle(Map<String, Object> params) {
        return auctionVehicleMapper.countAuctionVehicle(params);
    }

    @Override
    public List<AuctionVehicle> findAuctionVehicle(Map<String, Object> params) {
        return auctionVehicleMapper.findAuctionVehicle(params);
    }

    @Override
    public List<Map<String, Boolean>> getCityListforAuction(Map<String, Object> params) {
        return auctionVehicleMapper.getCityListforAuction(params);
    }

    @Override
    public void updateAuctionVehicleComplete(Integer avId) throws Exception {
        AuctionVehicle av = auctionVehicleMapper.selectByPrimaryKey(avId);

        List<Bid> bidList = bidService.getBidList(avId, null, false);
        if (bidList.isEmpty()) {
            this.updateAuctionVehicleStatus(av.getId(), av.getVehicleId(), GlobalConstants.AUCTION_VEHICLE_STATUS_ON,
                    GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL);
            return;
        }

        if (this.updateAuctionVehicleStatus(av.getId(), av.getVehicleId(), GlobalConstants.AUCTION_VEHICLE_STATUS_ON,
                GlobalConstants.AUCTION_VEHICLE_STATUS_SUCCESS)) {
            Bid bid = bidList.get(0);

            int commission = bidService.calculateCommission(bid.getPrice(), av);
            int sellerCommission = bidService.calculateSellerCommission(bid.getPrice(), av);

            Order orderEntity = new Order();
            String orderNo = bizIdService.getOrderId("32"); // 同步拍
            orderEntity.setOrderNo(orderNo);
            orderEntity.setBidderSid(bid.getBidderSid());
            orderEntity.setBidderName(bid.getBidderName());
            orderEntity.setDealTimestamp(new Date());
            orderEntity.setCreatedTime(new Date());
            orderEntity.setUpdateTime(new Date());
            Member member = memberService.selectByPrimaryKey(bid.getBidderSid());
            if (member != null) {
                orderEntity.setBuyerCellphone(member.getCellphone());
            }
            orderService.insertSelective(orderEntity);
            orderEntity = orderService.selectOrderByOrderNo(orderNo);

            OrderItem orderItemEntity = new OrderItem();
            // orderItemEntity.setSid(UUIDUtil.getUUID());
            orderItemEntity.setOrderId(orderEntity.getId());
            orderItemEntity.setCommission(BigDecimal.ZERO);
            orderItemEntity.setLicenseFee(av.getLicenseFee());
            orderItemEntity.setExWarehouseFee(av.getExWarehouseFee());
            orderItemEntity.setParkingFee(av.getParkingFee());
            orderItemEntity.setTrafficFee(av.getTrafficFee());
            orderItemEntity.setTrafficViolationFee(av.getTrafficViolationFee());
            orderItemEntity.setBidId(bid.getId());
            orderItemEntity.setVehicleId(av.getVehicleId());
            orderItemEntity.setAuctionVehicleId(avId);
            orderItemEntity.setCreatedTimestamp(new Date());
            orderItemEntity.setFinalPrice(bid.getPrice());
            orderItemEntity.setSaleType(1);
            orderItemEntity.setClientCommissionFee(BigDecimal.valueOf(sellerCommission));
            orderItemEntity.setBuyerCommissionFee(BigDecimal.valueOf(commission));
            orderItemEntity.setStatus(0);
            if (member == null) {
                orderItemEntity.setDealType(1);// 线下成交
            }

            Bid msgBid = new Bid();
            msgBid.setAuctionVehicleId(av.getId());
            msgBid.setBidderSid("***");
            msgBid.setBidderUsername("***");
            msgBid.setBidderName("系统");
            msgBid.setBidTimestamp(new Date());
            msgBid.setIp("127.0.0.1");
            msgBid.setMsg(true);
            msgBid.setContent(Strings.padStart(String.valueOf(av.getAuctionVehicleOrder()), 3, '0') + "号拍品由"
                    + StringUtil.mask(bid.getBidderUsername()) + "竞得");

            orderItemService.insertSelective(orderItemEntity);
            bidService.insertSelective(msgBid);
            // FIXME 上工作流后，这段代码需要恢复，并测试
            // try {
            // stockRemovalApply(av, orderEntity, orderItemEntity);
            // } catch (Exception e) {
            // LOGGER.warn("订单号{}自动出库申请出错,{}", orderEntity.getId(),
            // e.getMessage());
            // }
        }
    }

    /**
     * 拍卖成交车辆订单中心出库申请接口
     * 
     * @throws WorkflowException
     * @throws IOException
     */
    @Override
    public boolean stockRemovalApply(AuctionVehicle av, Order order, OrderItem orderItem)
            throws WorkflowException, IOException {
        boolean falg = false;
        VehicleInfo vehicle = vehicleService.selectVehicleInfoById(orderItem.getVehicleId());
        if (null == vehicle) {
            return falg;
        }
        Auction auction = auctionService.selectByPrimaryKey(av.getAuctionId());
        if (null == auction) {
            return falg;
        }
        Organization auctionOrganization = organizationService.selectByPrimaryKey(auction.getOrgId());
        StockRemoval stockRemoval = new StockRemoval();
        // 这个账号要等到
        stockRemoval.setApplyId("0");
        stockRemoval.setApplyName(auction.getCreatedBy());
        String sellName = vehicle.getBrand() + vehicle.getBrandSeries() + vehicle.getVehicleModel()
                + vehicle.getSelledName();
        // 根据用户类型查询车辆所属信息
        if (null != vehicle.getVehicleSrcType() && null != vehicle.getVehicleSrcId()) {
            if (vehicle.getVehicleSrcType() == 3) {
                // Member member =
                // memberService.selectByPrimaryKey(String.valueOf(vehicle.getVehicleSrcId()));
                // stockRemoval.setVehicleCompany(member.getUsername());
            } else {
                try {
                    Organization organization = organizationService.selectByPrimaryKey(vehicle.getVehicleSrcId());
                    stockRemoval.setVehicleCompany(organization.getOrgName());
                } catch (Exception e) {
                    LOGGER.warn("设置车辆所在公司失败", e);
                }
            }
        }
        stockRemoval.setCode(vehicle.getCode());
        stockRemoval.setOrderNo(order.getOrderNo());
        stockRemoval.setSellName(sellName);
        stockRemoval.setVinCode(vehicle.getVinCode());
        stockRemoval.setCarColor(vehicle.getBodyColor());
        stockRemoval.setInteriorColor(vehicle.getInteriorColor());
        // 预计出库时间时当前时间加五天
        stockRemoval.setStockRemovalExpectDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 5));
        stockRemoval.setLicenseCode(vehicle.getLicenseCode());
        stockRemoval.setApparentMileage(vehicle.getDisplayMileage().toString());
        stockRemoval.setSellPrice(orderItem.getFinalPrice());
        stockRemoval.setUserName(order.getBidderName());
        stockRemoval.setUserCellphone(order.getBuyerCellphone());
        // StockRemoval.setPayDate(new Date());
        stockRemoval.setPayType("线下付款");
        // 仓库位置等做好可以直接调拍卖会中的字段
        stockRemoval.setLeaveCarAddress(auction.getAddress());
        stockRemoval.setTakeCarWay("自提");
        stockRemoval.setRemark("拍卖成功系统自动出库申请");
        // 整备时间晚于入库时间即表示此次拍卖的车辆整备过
        RepaireFeeQueryBean repaireFeeQueryBean = new RepaireFeeQueryBean();
        repaireFeeQueryBean.setVin(vehicle.getVinCode());
        // repaireFeeQueryBean.setVin("33");
        List<String> vinList = new ArrayList<String>();
        vinList.add(vehicle.getVinCode());
        List<VehicleInventory> inventoryList = wmsService.queryVehicleInventory(vinList);
        com.autostreets.biz.wtms.dto.Pagination<List<RepairFee>> pagination = wmsService
                .queryRepairFee(repaireFeeQueryBean);
        if (null == pagination.getDataList() || pagination.getDataList().size() == 0 || null == inventoryList
                || inventoryList.size() == 0) {
            stockRemoval.setIsSetup(false);
        } else {
            if (inventoryList.get(0).getStorageTime().getTime() < pagination.getDataList().get(0).getRepairTime()
                    .getTime()) {
                stockRemoval.setIsSetup(true);
            } else {
                stockRemoval.setIsSetup(false);
            }
        }
        List<StockRemoval> stockRemovalList = new ArrayList<StockRemoval>();
        stockRemovalList.add(stockRemoval);
        falg = stockRemovalService.applyStockRemovals(stockRemoval.getApplyId(), stockRemoval.getApplyName(),
                auctionOrganization.getOrgName(), stockRemovalList);
        if (falg) {
            VehicleInfo vehicleTemp = new VehicleInfo();
            vehicleTemp.setCode(vehicle.getCode());
            vehicleTemp.setStockStatus(StockStatus.APPLY_OUT.getKey());
            usedvehicleDealerService.vehicleSave(vehicleTemp);
        }
        LOGGER.info("admin后台出库申请" + JSON.toJSONString(stockRemoval));
        return falg;
    }

    /**
     * 
     * 功能描述: <br>
     * 订单手动出库申请
     * 
     * @param code
     *            车辆编号
     * @param orgAddr
     *            门店地址
     * @param applyId
     *            申请人ID
     * @param applyName
     *            申请人姓名
     * @param stockRemovalType
     *            出库类型
     * @param payType
     *            支付方式
     * @param takeCarWay
     *            提车方式
     * 
     * @return
     * @throws WorkflowException
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @Override
    public boolean stockRemovalApply(String orderNo, String code, String orgAddr, String applyId, String applyName,
            String stockRemovalType, String payType, String takeCarWay, String cellphone)
                    throws WorkflowException, IOException {
        VehicleInfo vehicle = usedVehicleService.selectVehicleByCode(code);
        boolean falg = false;
        if (null == vehicle) {
            return falg;
        }

        StockRemoval stockRemoval = new StockRemoval();
        stockRemoval.setApplyId(applyId);
        stockRemoval.setApplyName(applyName);
        String sellName = vehicle.getBrand() + vehicle.getVehicleModel() + vehicle.getSelledName();
        // 根据用户类型查询车辆所属信息
        Organization organization = null;
        if (null != vehicle.getVehicleSrcType() && null != vehicle.getVehicleSrcId()) {
            if (vehicle.getVehicleSrcType() == 3) {
                // Member member =
                // memberService.selectByPrimaryKey(vehicle.getVehicleSrcId());
                // stockRemoval.setVehicleCompany(member.getUsername());
            } else {
                try {
                    organization = organizationService.selectByPrimaryKey(vehicle.getVehicleSrcId());
                    stockRemoval.setVehicleCompany(organization.getOrgName());
                } catch (Exception e) {
                    LOGGER.warn("设置车辆所在公司失败", e);
                }
            }
        }
        // stockRemoval.setApplyCompany(da);
        stockRemoval.setOrderNo(orderNo);
        stockRemoval.setCode(code);
        stockRemoval.setSellName(sellName);
        stockRemoval.setVinCode(vehicle.getVinCode());
        stockRemoval.setCarColor(vehicle.getBodyColor());
        stockRemoval.setInteriorColor(vehicle.getInteriorColor());
        // 预计出库时间时当前时间加五天
        stockRemoval.setStockRemovalExpectDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 5));
        stockRemoval.setLicenseCode(vehicle.getLicenseCode());
        stockRemoval.setApparentMileage(vehicle.getDisplayMileage().toString());
        stockRemoval.setLeaveCarAddress(orgAddr);
        stockRemoval.setStockRemovalType(stockRemovalType);
        stockRemoval.setTakeCarWay(takeCarWay);
        stockRemoval.setPayType(payType);
        stockRemoval.setRemark("车辆手动出库申请");
        // stockRemoval.setleaveCarAddress();
        stockRemoval.setLeaveCarUser(applyName);
        stockRemoval.setLeaveCarCellphone(cellphone);
        List<StockRemoval> stockRemovalList = new ArrayList<StockRemoval>();
        stockRemovalList.add(stockRemoval);
        // 取车辆所属门店 dealer 去申请人所属门店
        if (null != organization) {
            orgAddr = organization.getOrgName();
        }
        falg = stockRemovalService.applyStockRemovals(stockRemoval.getApplyId(), stockRemoval.getApplyName(), orgAddr,
                stockRemovalList);
        if (falg) {
            VehicleInfo vehicleTemp = new VehicleInfo();
            vehicleTemp.setCode(vehicle.getCode());
            vehicleTemp.setStockStatus(StockStatus.APPLY_OUT.getKey());
            usedvehicleDealerService.vehicleSave(vehicleTemp);
        }
        LOGGER.info("admin后台出库申请" + JSON.toJSONString(stockRemoval));
        return falg;
    }

    // @Override
    // public int updateAvStatus(Integer avId, Integer oldStatus, Integer
    // newStatus) {
    // AuctionVehicle avEntity = new AuctionVehicle();
    // avEntity.setStatus(newStatus);
    //
    // AuctionVehicleExample ave = new AuctionVehicleExample();
    // AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
    // aveCriteria.andIdEqualTo(avId);
    // aveCriteria.andStatusEqualTo(oldStatus);
    //
    // Map<String, Object> params = Maps.newHashMap();
    // params.put("record", avEntity);
    // params.put("example", ave);
    //
    // return auctionVehicleMapper.updateByExampleSelective(params);
    // }
    //
    // @Override
    // public boolean updateVehicleStatusEQS(AuctionVehicle av, int status) {
    // Integer vehicleId = av.getVehicleId();
    // boolean flag = false;
    // if (status == GlobalConstants.SALE_STATUS_WAIT) {
    // LOGGER.info("将车辆" + vehicleId + "销售状态改为待售");
    // flag = usedvehicleOperatorService.updateSaleStatus(vehicleId,
    // SaleStatusEnum.SALE_STATUS_WAIT);
    // } else if (status == GlobalConstants.SALE_STATUS_ONGOING) {
    // LOGGER.info("将车辆" + vehicleId + "销售状态改为销售中");
    // flag = usedvehicleOperatorService.updateSaleStatus(vehicleId,
    // SaleStatusEnum.SALE_STATUS_ONGOING);
    // } else if (status == GlobalConstants.SALE_STATUS_DONE) {
    // LOGGER.info("将车辆" + vehicleId + "销售状态改为已售");
    // flag = usedvehicleOperatorService.updateSaleStatus(vehicleId,
    // SaleStatusEnum.SALE_STATUS_DONE);
    // }
    // if (flag) {
    // LOGGER.info("修改车辆" + vehicleId + "销售状态成功");
    // } else {
    // LOGGER.info("修改车辆" + vehicleId + "销售状态失败");
    // }
    // return flag;
    // }

    @Override
    public void updateAuctionVehicleFail(Integer avId) throws Exception {
        AuctionVehicle av = auctionVehicleMapper.selectByPrimaryKey(avId);
        if (this.updateAuctionVehicleStatus(av.getId(), av.getVehicleId(), GlobalConstants.AUCTION_VEHICLE_STATUS_ON,
                GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL)) {
            if (av.getOnlineEndTime() != null) {
                this.resetOnlineEndTime(avId);
            }
        }
    }

    @Override
    public void resetOnlineEndTime(Integer avId) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("avId", avId);
        auctionVehicleMapper.resetOnlineEndTime(params);
    }

    @Override
    public boolean updateOnlineComplete(Bid bid, Integer avId) throws Exception {
        AuctionVehicle av = auctionVehicleMapper.selectByPrimaryKey(avId);

        // 生成订单
        int commission = calculateCommission(bid.getPrice(), av);
        int sellerCommission = calculateSellerCommission(bid.getPrice(), av);

        // 更新av, vehicle状态
        if (this.updateAuctionVehicleStatus(av.getId(), av.getVehicleId(),
                GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL_CONFIRM, GlobalConstants.AUCTION_VEHICLE_STATUS_SUCCESS)) {
            bidService.insertSelective(bid);

            Order orderEntity = new Order();
            String orderNo = bizIdService.getOrderId("31"); // 在线拍
            orderEntity.setOrderNo(orderNo);
            orderEntity.setBidderSid(bid.getBidderSid());
            orderEntity.setBidderName(bid.getBidderName());
            orderEntity.setDealTimestamp(new Date());
            orderService.insertSelective(orderEntity);
            orderEntity = orderService.loadByOrderNo(orderNo);

            OrderItem orderItemEntity = new OrderItem();
            orderItemEntity.setOrderId(orderEntity.getId());

            orderItemEntity.setCommission(BigDecimal.ZERO);
            orderItemEntity.setLicenseFee(av.getLicenseFee());
            orderItemEntity.setExWarehouseFee(av.getExWarehouseFee());
            orderItemEntity.setParkingFee(av.getParkingFee());
            orderItemEntity.setTrafficFee(av.getTrafficFee());
            orderItemEntity.setTrafficViolationFee(av.getTrafficViolationFee());

            orderItemEntity.setClientCommissionFee(BigDecimal.valueOf(sellerCommission));
            orderItemEntity.setBuyerCommissionFee(BigDecimal.valueOf(commission));

            orderItemEntity.setBidId(bid.getId());
            orderItemEntity.setVehicleId(av.getVehicleId());
            orderItemEntity.setAuctionVehicleId(av.getId());
            orderItemEntity.setCreatedTimestamp(new Date());
            orderItemEntity.setFinalPrice(bid.getPrice());
            orderItemEntity.setSaleType(Integer.valueOf(2));
            orderItemEntity.setStatus(Integer.valueOf(0));
            orderItemEntity.setOrderType(Integer.valueOf(2)); // 前台引导订单
            orderItemService.insertSelective(orderItemEntity);
            return true;
        } else {
            return false;
        }
    }

    private int calculateCommission(BigDecimal price, AuctionVehicle auctionVehicle) {
        int commission = 0;
        if (auctionVehicle.getBuyerFixedCommission() != null
                && auctionVehicle.getBuyerFixedCommission().compareTo(BigDecimal.ZERO) > 0) {
            commission = auctionVehicle.getBuyerFixedCommission().intValue();
        } else if (auctionVehicle.getBuyerCommissionRate() != null
                && auctionVehicle.getBuyerCommissionRate().compareTo(BigDecimal.ZERO) > 0) {
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

            commission = price.multiply(auctionVehicle.getBuyerCommissionRate())
                    .divide(BigDecimal.valueOf(100L), 0, BigDecimal.ROUND_CEILING).intValue();
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

    private int calculateSellerCommission(BigDecimal price, AuctionVehicle auctionVehicle) {
        int commission = 0;
        if (auctionVehicle.getClientFixedCommission() != null
                && auctionVehicle.getClientFixedCommission().compareTo(BigDecimal.ZERO) > 0) {
            commission = auctionVehicle.getClientFixedCommission().intValue();
        } else if (auctionVehicle.getClientCommissionRate() != null
                && auctionVehicle.getClientCommissionRate().compareTo(BigDecimal.ZERO) > 0) {
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

            commission = price.multiply(auctionVehicle.getClientCommissionRate())
                    .divide(BigDecimal.valueOf(100L), 0, BigDecimal.ROUND_CEILING).intValue();
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

    @Override
    public void createOrder(Integer avId) {
        AuctionVehicle av = auctionVehicleMapper.selectByPrimaryKey(avId);

        if (!av.getAuctionType().equals(1) && !av.getStatus().equals(2)) {
            return;
        }

        List<Bid> bidList = getBidList(av.getId(), null, false);
        if (bidList.isEmpty()) {
            return;
        }

        Bid bid = bidList.get(0);
        if (av.getReservePrice() != null && bid.getPrice().compareTo(av.getReservePrice()) < 0) {
            return;
        }

        int commission = calculateCommission(bid.getPrice(), av);
        int sellerCommission = calculateSellerCommission(bid.getPrice(), av);
        // boolean updateVehicleStatusEQS = updateVehicleStatusEQS(av, 2);
        boolean updateStatusResult = false;
        try {
            // 更新拍品，车辆销售状态
            updateStatusResult = this.updateAuctionVehicleStatus(av.getId(), av.getVehicleId(),
                    GlobalConstants.AUCTION_VEHICLE_STATUS_ON, GlobalConstants.AUCTION_VEHICLE_STATUS_SUCCESS);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        if (updateStatusResult) {
            Order orderEntity = new Order();
            String orderNo = bizIdService.getOrderId("31"); // 在线拍
            orderEntity.setOrderNo(orderNo);
            orderEntity.setBidderSid(bid.getBidderSid());
            orderEntity.setBidderName(bid.getBidderName());
            orderEntity.setDealTimestamp(new Date());
            orderService.insertSelective(orderEntity);
            orderEntity = orderService.loadByOrderNo(orderNo);

            OrderItem orderItemEntity = new OrderItem();
            orderItemEntity.setOrderId(orderEntity.getId());
            orderItemEntity.setCommission(BigDecimal.ZERO);
            orderItemEntity.setLicenseFee(av.getLicenseFee());
            orderItemEntity.setExWarehouseFee(av.getExWarehouseFee());
            orderItemEntity.setParkingFee(av.getParkingFee());
            orderItemEntity.setTrafficFee(av.getTrafficFee());
            orderItemEntity.setTrafficViolationFee(av.getTrafficViolationFee());
            orderItemEntity.setBidId(bid.getId());
            orderItemEntity.setVehicleId(av.getVehicleId());
            orderItemEntity.setAuctionVehicleId(av.getId());
            orderItemEntity.setCreatedTimestamp(new Date());
            orderItemEntity.setFinalPrice(bid.getPrice());
            orderItemEntity.setSaleType(2);
            orderItemEntity.setClientCommissionFee(BigDecimal.valueOf(sellerCommission));
            orderItemEntity.setBuyerCommissionFee(BigDecimal.valueOf(commission));
            orderItemEntity.setStatus(0);
            orderItemService.insertSelective(orderItemEntity);
        }
    }

    private List<Bid> getBidList(Integer avId, String memberId, boolean includeMsg) {
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

    @Override
    public void endBid(AuctionVehicle av) throws Exception {
        // 注意：由于拍品的信息取的是加入定时器时刻的信息，所以必须重新查询，以取得拍品最新信息（如onlineEndTime可能已经有了变化）
        av = auctionVehicleMapper.selectByPrimaryKey(av.getId());

        if (!av.getStatus().equals(5)) {
            return;
        }

        // 延时2秒成交
        Date currentDate = DateUtils.addSeconds(new Date(), -2);
        if (av.getOnlineEndTime() != null) {
            if (!av.getOnlineEndTime().before(currentDate)) {
                return;
            }
        }

        List<Bid> bidList = bidService.getBidList(av.getId(), null, false);
        if (bidList.isEmpty()) {
            // if (updateAvStatus(av.getId(), 5, 4) == 1) {
            // updateVehicleStatusEQS(av, 0);
            // }
            this.updateAuctionVehicleStatus(av.getId(), av.getVehicleId(), GlobalConstants.AUCTION_VEHICLE_STATUS_ON,
                    GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL);
            return;
        }

        Bid bid = bidList.get(0);
        // 无底价、即时拍、(保留价不为空，并且出价小于保留价) 拍品状态修改为成交确认
        if (av.getAvType().equals(1) || av.getAuctionType().equals(2)
                || (av.getReservePrice() != null && bid.getPrice().compareTo(av.getReservePrice()) < 0)) {
            // updateAvStatus(av.getId(), 5, 3); // 直接设置为成交确认
            this.updateAuctionVehicleStatus(av.getId(), av.getVehicleId(), GlobalConstants.AUCTION_VEHICLE_STATUS_ON,
                    GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL_CONFIRM);
            return;
        }
        // else {
        // if (av.getReservePrice() != null &&
        // bid.getPrice().compareTo(av.getReservePrice()) < 0) {
        // if (updateAvStatus(av.getId(), 5, 3) == 1) {
        // // updateVehicleStatus(av, 1, 0);
        // // updateVehicleStatusEQS(av, 0);
        // }
        // return;
        // }
        // }

        int commission = calculateCommission(bid.getPrice(), av);
        int sellerCommission = calculateSellerCommission(bid.getPrice(), av);
        // 拍品状态由正在拍修改为拍卖成功
        boolean updateVehicleStatus = this.updateAuctionVehicleStatus(av.getId(), av.getVehicleId(),
                GlobalConstants.AUCTION_VEHICLE_STATUS_ON, GlobalConstants.AUCTION_VEHICLE_STATUS_SUCCESS);
        // boolean updateVehicleStatusEQS = updateVehicleStatusEQS(av, 2);

        if (updateVehicleStatus) {
            Order orderEntity = new Order();
            String orderNo = bizIdService.getOrderId("31"); // 在线拍
            orderEntity.setOrderNo(orderNo);
            orderEntity.setBidderSid(bid.getBidderSid());
            orderEntity.setBidderName(bid.getBidderName());
            orderEntity.setDealTimestamp(new Date());
            orderService.insertSelective(orderEntity);
            orderEntity = orderService.loadByOrderNo(orderNo);
            OrderItem orderItemEntity = new OrderItem();
            orderItemEntity.setOrderId(orderEntity.getId());
            orderItemEntity.setCommission(BigDecimal.ZERO);
            orderItemEntity.setLicenseFee(av.getLicenseFee());
            orderItemEntity.setExWarehouseFee(av.getExWarehouseFee());
            orderItemEntity.setParkingFee(av.getParkingFee());
            orderItemEntity.setTrafficFee(av.getTrafficFee());
            orderItemEntity.setTrafficViolationFee(av.getTrafficViolationFee());
            orderItemEntity.setBidId(bid.getId());
            orderItemEntity.setVehicleId(av.getVehicleId());
            orderItemEntity.setAuctionVehicleId(av.getId());
            orderItemEntity.setCreatedTimestamp(new Date());
            orderItemEntity.setFinalPrice(bid.getPrice());
            orderItemEntity.setSaleType(2);
            orderItemEntity.setClientCommissionFee(BigDecimal.valueOf(sellerCommission));
            orderItemEntity.setBuyerCommissionFee(BigDecimal.valueOf(commission));
            orderItemEntity.setStatus(0);
            // updateAvStatus(av.getId(), 5, 2);
            orderItemService.insertSelective(orderItemEntity);
            try {
                Vehicle vehicle = vehicleService.selectByPrimaryKey(av.getVehicleId());
                Map<String, String> params = new HashMap<String, String>();
                params.put("title", vehicle.getSelledName());
                params.put("price", bid.getPrice().toString());
                MsgPhshUtils.Jpush(drawDictionaryService, appModelService,
                        appMsgPushTriggerService.getMsgPushByTriggerName("在线拍成交"), bid.getBidderSid(), params);
            } catch (Exception e) {
                LOGGER.error("在线拍成交推送失败", e);
            }
        }
    }

    @Override
    public void updateOnlineAVFail(Integer avId) {
        AuctionVehicle av = auctionVehicleMapper.selectByPrimaryKey(avId);
        try {
            this.updateAuctionVehicleStatus(av.getId(), av.getVehicleId(),
                    GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL_CONFIRM, GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL);
            // if (updateAvStatus(avId, 3, 4) == 1) {
            // updateVehicleStatusEQS(av, 0);
            // }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public Map<Integer, List<Map<String, Object>>> getHighestPriceByList(List<Integer> list) {
        Map<Integer, List<Map<String, Object>>> mapList = null;
        if (null == list || list.size() == 0 || list.size() > 10) {
            return mapList;
        }
        mapList = new HashMap<Integer, List<Map<String, Object>>>();
        for (Integer vehicleId : list) {
            List<Map<String, Object>> vehiclePriceList = getHighestPriceByString(vehicleId);
            mapList.put(vehicleId, vehiclePriceList);
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> getHighestPriceByString(Integer vehicleId) {
        List<Map<String, Object>> highestPriceList = null;
        if (null == vehicleId) {
            return highestPriceList;
        }
        AuctionVehicleExample example = new AuctionVehicleExample();
        Criteria criteria = example.createCriteria();
        criteria.andVehicleIdEqualTo(vehicleId);
        example.setOrderByClause("end_time desc");
        List<AuctionVehicle> auctionVehicleList = auctionVehicleMapper.selectByExample(example);
        if (null == auctionVehicleList || auctionVehicleList.size() == 0) {
            return highestPriceList;
        }
        for (AuctionVehicle auctionVehicle : auctionVehicleList) {
            if (null != auctionVehicle.getMaxBidPrice()
                    && auctionVehicle.getMaxBidPrice().compareTo(BigDecimal.ZERO) != 0) {
                if (null == highestPriceList) {
                    highestPriceList = new ArrayList<Map<String, Object>>();
                }
                Map<String, Object> priceMap = new HashMap<String, Object>();
                priceMap.put("price", auctionVehicle.getMaxBidPrice());
                priceMap.put("auctionDate", DateUtil.formatSimpleDatetime(auctionVehicle.getPlanEndTime()));
                highestPriceList.add(priceMap);
            }
        }
        return highestPriceList;
    }

    @Override
    public Pagination getOnceBidAuction(AuctionVehicle auctionVehicle) {
        Pagination pagination = auctionVehicle.getPagination();
        int count = auctionVehicleMapper.getOnceBidAuctionCount(auctionVehicle);
        pagination.setCount(count);
        List<AuctionVehicle> auctionVehicles = auctionVehicleMapper.getOnceBidAuction(auctionVehicle);
        pagination.setDataList(auctionVehicles);
        return pagination;
    }

    @Override
    public Boolean createOnceBidOrder(AuctionVehicle auctionVehicle) throws Exception {
        Assert.notNull(auctionVehicle);
        Assert.notNull(auctionVehicle.getId());
        Assert.notNull(auctionVehicle.getVehicleId());

        // 最高价
        Bid maxPrice = bidService.getMaxPriceBidder(auctionVehicle.getId());
        // 次高价
        Bid secondPrice = bidService.getSecondPrice(auctionVehicle.getId());

        int commission = bidService.calculateCommission(secondPrice.getPrice(), auctionVehicle);
        int sellerCommission = bidService.calculateSellerCommission(secondPrice.getPrice(), auctionVehicle);
        boolean updateVehicleStatus = this.updateAuctionVehicleStatus(auctionVehicle.getId(),
                auctionVehicle.getVehicleId(), GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL_CONFIRM,
                GlobalConstants.AUCTION_VEHICLE_STATUS_SUCCESS);
        // boolean updateVehicleStatusEQS =
        // updateVehicleStatusEQS(auctionVehicle, 2);
        if (updateVehicleStatus) {
            Order orderEntity = new Order();
            String orderNo = bizIdService.getOrderId(BusinessIdRuleEnum.OV_ONCEBID.getCode()); // 即时拍
            orderEntity.setOrderNo(orderNo);
            orderEntity.setBidderSid(maxPrice.getBidderSid());
            orderEntity.setBidderName(maxPrice.getBidderName());
            orderEntity.setDealTimestamp(new Date());
            orderService.insertSelective(orderEntity);
            orderEntity = orderService.loadByOrderNo(orderNo);
            OrderItem orderItemEntity = new OrderItem();
            orderItemEntity.setBidId(maxPrice.getId());
            orderItemEntity.setOrderId(orderEntity.getId());
            orderItemEntity.setCommission(BigDecimal.ZERO);
            orderItemEntity.setLicenseFee(auctionVehicle.getLicenseFee());
            orderItemEntity.setExWarehouseFee(auctionVehicle.getExWarehouseFee());
            orderItemEntity.setParkingFee(auctionVehicle.getParkingFee());
            orderItemEntity.setTrafficFee(auctionVehicle.getTrafficFee());
            orderItemEntity.setTrafficViolationFee(auctionVehicle.getTrafficViolationFee());
            orderItemEntity.setVehicleId(auctionVehicle.getVehicleId());
            orderItemEntity.setAuctionVehicleId(auctionVehicle.getId());
            orderItemEntity.setCreatedTimestamp(new Date());
            orderItemEntity.setFinalPrice(secondPrice.getPrice());// 次高价
            orderItemEntity.setSaleType(3);
            orderItemEntity.setClientCommissionFee(BigDecimal.valueOf(sellerCommission));
            orderItemEntity.setBuyerCommissionFee(BigDecimal.valueOf(commission));
            orderItemEntity.setStatus(0);
            orderItemEntity.setOrderType(3);// 后台拍卖师协商
            // 即时拍，原状态成交确认
            // updateAvStatus(auctionVehicle.getId(), 3, 2);
            orderItemService.insertSelective(orderItemEntity);
        }
        return Boolean.TRUE;
    }

    @Override
    public List<AuctionVehicle> getAuctionVehicles(Integer auctionId) {
        return auctionVehicleMapper.getAuctionVehicles(auctionId);
    }

    @Override
    public AuctionVehicle getAuctionVehicleAndVehicle(Integer avId) {
        return auctionVehicleMapper.getAuctionVehicleAndVehicle(avId);
    }

    @Override
    public List<Vehicle> selectStockRemovalAuction(Integer auctionId) {
        return auctionVehicleMapper.selectStockRemovalAuction(auctionId);
    }

    @Override
    public List<String> getCityList() {
        return auctionVehicleMapper.getCityList();
    }

    @Override
    public List<AuctionVehicle> getNextAvList(Integer auctionId) {
        return auctionVehicleMapper.getNextAvList(auctionId);
    }

    @Override
    public int selectAuctionVehicleMaxSeq(Integer auctionId) {
        AuctionVehicleExample example = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria criteria = example.createCriteria();
        criteria.andAuctionIdEqualTo(auctionId);
        criteria.andLatestEqualTo(true);// 最新拍品
        return countByExample(example);
    }

    @Override
    public boolean updateAuctionVehicleStatus(Integer avId, Integer vehicleId, Integer oldStatus, Integer newStatus)
            throws Exception {
        // 0 待拍卖 1 已上架 2 拍卖成功 3 成交确认 4 流拍 5 正在拍 6 暂停 7 取消订单
        if (avId != null && vehicleId != null && oldStatus != null && newStatus != null) {
            // 更新指定avId、状态的拍品为新的状态
            AuctionVehicleExample example = new AuctionVehicleExample();
            AuctionVehicleExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(avId);
            criteria.andStatusEqualTo(oldStatus);
            criteria.andLatestEqualTo(true);
            criteria.andEnableEqualTo(true);
            // 更新状态
            AuctionVehicle record = new AuctionVehicle();
            record.setStatus(newStatus);
            int affect = updateByExampleSelective(record, example);
            int rightAffect = 1;// 正确的受影响行数
            if (affect != rightAffect) {
                LOGGER.error("更新拍品{}状态{}为{}异常，受影响行数为{}", avId, oldStatus, newStatus, affect);
                return false;
            }
            // 判断车辆销售状态是否需要修改，比如正在拍>>成交确认，车辆销售状态都是出售中，这样就没有必要修改一次车辆销售状态
            SaleStatusEnum oldSaleStatus = getSaleStatusByAvStatus(oldStatus);// 原车辆销售状态
            SaleStatusEnum newSaleStatus = getSaleStatusByAvStatus(newStatus);// 新车辆销售状态
            if (oldSaleStatus != null && newSaleStatus != null) {
                if (!oldSaleStatus.equals(newSaleStatus)) {
                    // 更新销售状态
                    try {
                        affect = vehicleService.updateSaleStatus(vehicleId, newSaleStatus);
                        if (affect != rightAffect) {
                            LOGGER.warn("更新车辆{}销售状态{}为{}异常，受影响行数为{}", vehicleId, oldSaleStatus.getKey(),
                                    newSaleStatus.getKey(), affect);
                        }
                    } catch (Exception e) {
                        VehicleSyncFailLog failLog = new VehicleSyncFailLog();
                        failLog.setCreatedTime(new Date());
                        failLog.setDelFlag(false);
                        failLog.setVehicleId(vehicleId);
                        failLog.setAuctionVehicleId(avId);
                        failLog.setOldStatus(oldStatus);
                        failLog.setNewStatus(newStatus);
                        vehicleSyncFailLogMapper.insert(failLog);
                    }
                    return true;
                } else {
                    LOGGER.info("拍品状态{}到{}，车辆销售状态不变无需修改。", oldStatus, newStatus);
                }
            } else {
                throw new Exception(
                        "更新拍品状态失败：未获取到正确的车辆销售状态[avOldStatus:" + oldStatus + ",avNewStatus:" + newStatus + "]。");
            }
        }
        return false;
    }

    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 根据拍品状态获取对应的车辆销售状态
     * </pre>
     *
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月24日 下午12:17:19
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private SaleStatusEnum getSaleStatusByAvStatus(Integer avStatus) {
        SaleStatusEnum saleStatus = null;
        switch (avStatus) {
            case 0:// 待拍卖
            case 1:// 已上架
            case 3:// 成交确认
            case 5:// 正在拍
            case 6:// 暂停
                saleStatus = SaleStatusEnum.SALE_STATUS_ONGOING;
                break;
            case 4:// 流拍
            case 7:// 取消订单
                saleStatus = SaleStatusEnum.SALE_STATUS_WAIT;
                break;
            case 2:// 拍卖成功
                saleStatus = SaleStatusEnum.SALE_STATUS_DONE;
                break;
            default:
                break;
        }
        return saleStatus;
    }

    @Override
    public int selectOnlineDealSum(Integer auctionIn) {
        return auctionVehicleMapper.selectOnlineDealSum(auctionIn);
    }

    @Override
    public List<AuctionVehicle> exportCatalog(Auction auction) {
        return auctionVehicleMapper.exportCatalog(auction);
    }

}