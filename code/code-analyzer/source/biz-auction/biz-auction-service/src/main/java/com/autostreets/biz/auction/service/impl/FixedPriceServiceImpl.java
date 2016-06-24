package com.autostreets.biz.auction.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.autostreets.biz.auction.enums.NoHaggleAgeRangeEnum;
import com.autostreets.biz.auction.enums.NoHaggleMileRangeEnum;
import com.autostreets.biz.auction.enums.NoHagglePriceRangeEnum;
import com.autostreets.biz.auction.mapper.FixedPriceMapper;
import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.FixedPriceExample;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.UsedcarShopExt;
import com.autostreets.biz.auction.model.UsedcarShopExtExample;
import com.autostreets.biz.auction.pagination.Pagination1;
import com.autostreets.biz.auction.pagination.Pagination1Utils;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.UsedcarShopExtService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.sys.model.dict.DictArea;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.service.dict.DictAreaService;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.biz.usedvehicle.enums.SaleStatusEnum;
import com.autostreets.biz.usedvehicle.model.DictBrandseries;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.usedvehicle.service.UsedvehicleDictionaryService;
import com.autostreets.biz.usedvehicle.service.vehicle.BrandseriesService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.model.MemberFavorite;
import com.autostreets.model.MemberFavoriteExample;
import com.autostreets.service.MemberFavoriteService;
import com.autostreets.service.RepAutomakersService;
import com.autostreets.service.ad.AdPositionsService;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

@Service("fixedPriceService")
public class FixedPriceServiceImpl extends GenericServiceImpl<FixedPrice, FixedPriceExample, Integer>
        implements FixedPriceService {

    private final static Logger LOGGER = LoggerFactory.getLogger(FixedPriceServiceImpl.class);

    @Autowired
    private FixedPriceMapper fixedPriceMapper;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private BrandseriesService brandseriesService;

    @Autowired
    private UsedcarShopExtService usedcarShopExtService;

    @Autowired
    private DictAreaService dictAreaService;

    @Autowired
    private AdPositionsService adPositionsService;

    @Autowired
    private UsedvehicleDictionaryService usedvehicleDictionaryService;

    // @Autowired
    // private UsedvehicleOperatorService usedvehicleOperatorService;

    @Autowired
    private MemberFavoriteService memberFavoriteService;

    @Autowired
    private RepAutomakersService repAutomakersService;

    @Override
    protected GenericMapper<FixedPrice, FixedPriceExample, Integer> getGenericMapper() {
        return fixedPriceMapper;
    }

    @Override
    public Pagination queryFixedPrices(Pagination pagination, FixedPrice fixedPrice) {
        // 总数
        int count = fixedPriceMapper.queryFixedPriceTotal(fixedPrice);
        pagination.setCount(count);
        fixedPrice.setPagination(pagination);

        List<FixedPrice> data = fixedPriceMapper.queryFixedPrices(fixedPrice);
        pagination.setDataList(data);
        return pagination;
    }

    @Override
    public int queryUsedCarOrderNum(HashMap<String, Object> param) {
        return fixedPriceMapper.queryUsedCarOrderNum(param);
    }

    /**
     * <pre>
     * 更新车辆销售状态
     * 销售状态：0、待售；1、 出售中；2、已出售
     * </pre>
     * 
     * V2.0:增加新车售价（2014年10月15日 17:58:36）
     * 
     * @Title: updateVehicleSaleStatus
     * @Description:
     * @param vehicleSid
     *            车辆主键
     * @param status
     *            要设置的状态
     * @param priceNewcar
     *            新车售价
     * @return void
     * @throws @author
     *             tao.huang
     * @version V1.0
     * @date 2014年7月29日 下午1:45:04
     * @see tao.huang 2015-03-05 EQS分离 修改车辆销售状态接口
     * 
     */
    // @Override
    // public boolean updateVehicleSaleStatusEQS(Integer vehicleId, String
    // status, BigDecimal priceNewcar) {
    // boolean falg = false;
    // if (vehicleId == null) {
    // return falg;
    // }
    // int affect = 0;
    // try {
    // if (Short.valueOf(status) == GlobalConstants.SALE_STATUS_WAIT) {
    // if (priceNewcar != null) {
    // affect = vehicleService.updateSaleStatus(vehicleId,
    // SaleStatusEnum.SALE_STATUS_WAIT,
    // priceNewcar);
    // } else {
    // affect = vehicleService.updateSaleStatus(vehicleId,
    // SaleStatusEnum.SALE_STATUS_WAIT);
    // }
    // } else if (Short.valueOf(status) == GlobalConstants.SALE_STATUS_ONGOING)
    // {
    // if (priceNewcar != null) {
    // affect = vehicleService.updateSaleStatus(vehicleId,
    // SaleStatusEnum.SALE_STATUS_ONGOING,
    // priceNewcar);
    // } else {
    // affect = vehicleService.updateSaleStatus(vehicleId,
    // SaleStatusEnum.SALE_STATUS_ONGOING);
    // }
    //
    // } else if (Short.valueOf(status) == GlobalConstants.SALE_STATUS_DONE) {
    // if (priceNewcar != null) {
    // affect = vehicleService.updateSaleStatus(vehicleId,
    // SaleStatusEnum.SALE_STATUS_DONE,
    // priceNewcar);
    // } else {
    // affect = vehicleService.updateSaleStatus(vehicleId,
    // SaleStatusEnum.SALE_STATUS_DONE);
    // }
    // }
    // } catch (NumberFormatException e) {
    // LOGGER.error(e.getMessage(), e);
    // } catch (Exception e) {
    // LOGGER.error(e.getMessage(), e);
    // }
    // falg = affect == 1 ? true : false;
    // return falg;
    // }

    @Override
    public Pagination1<FixedPrice> selectFixedPricePage(String brand, Integer age, String pro, String city,
            Integer price, Integer mile, Integer min, Integer max, Integer cert, Integer ps, String sb, String s,
            int pageNumber, String d, int pageSize) {
        Map<String, Object> params = Maps.newHashMap();

        if (!Strings.isNullOrEmpty(brand)) {
            params.put("brand", brand);
        }

        if (age != null && age != 0) {
            String range = NoHaggleAgeRangeEnum.lookup(age);
            String[] ss = range.split(",");
            if (!Strings.isNullOrEmpty(ss[0])) {
                params.put("vehicleAgeMin", new BigDecimal(ss[0]));
            }
            if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
                params.put("vehicleAgeMax", new BigDecimal(ss[1]));
            }
        }

        if (price != null && price != 0) {
            String range = NoHagglePriceRangeEnum.lookup(price);
            String[] ss = range.split(",");
            if (!Strings.isNullOrEmpty(ss[0])) {
                params.put("startPriceMin", new BigDecimal(ss[0]).multiply(BigDecimal.valueOf(10000)));
            }
            if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
                params.put("startPriceMax", new BigDecimal(ss[1]).multiply(BigDecimal.valueOf(10000)));
            }
        } else {
            if (min != null && min > 0) {
                params.put("startPriceMin", new BigDecimal(min).multiply(BigDecimal.valueOf(10000)));
            }
            if (max != null && max > 0) {
                params.put("startPriceMax", new BigDecimal(max).multiply(BigDecimal.valueOf(10000)));
            }
        }

        if (mile != null && mile != 0) {
            String range = NoHaggleMileRangeEnum.lookup(mile);
            String[] ss = range.split(",");
            if (!Strings.isNullOrEmpty(ss[0])) {
                // fixed bug 里程数据库中存储为公里，页面查询条件为万公里，此处万公里转公里
                params.put("displayMileageMin", new BigDecimal(ss[0]).multiply(new BigDecimal("10000")));
            }
            if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
                params.put("displayMileageMax", new BigDecimal(ss[1]).multiply(new BigDecimal("10000")));
            }
        }

        if (cert != null && cert == 1) {
            params.put("cert", cert);
        }

        params.put("city", city);

        params.put("province", pro);
        params.put("sortBy", sb);
        params.put("sort", s);

        int count = fixedPriceMapper.countByMap(params);

        if (ps > 90) {
            ps = pageSize;
        }
        if (count % ps == 0) {
            if (count == 0) {
                pageNumber = 1;
            } else {
                if (pageNumber > (count / pageSize)) {
                    pageNumber = count / pageSize;
                }
            }
        } else {
            if (pageNumber > (count / ps + 1)) {
                pageNumber = count / ps + 1;
            }
        }

        params.put("offset", (pageNumber - 1) * ps);
        params.put("limit", ps);

        List<FixedPrice> fpList = fixedPriceMapper.selectByMap(params);
        return Pagination1Utils.newPagination(ps, pageNumber, count, fpList);
    }

    @Override
    public FixedPrice loadFixedPrice(Integer vehicleId) {
        FixedPriceExample example = new FixedPriceExample();
        FixedPriceExample.Criteria criteria = example.createCriteria();
        criteria.andVehicleIdEqualTo(vehicleId);
        criteria.andEnabledEqualTo(true);
        criteria.andLatestEqualTo(true);
        List<FixedPrice> list = fixedPriceMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public Map<String, Object> loadVehicleInfo(Integer vehicleId, String loginUserId) {
        if (vehicleId == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();

        VehicleInfo vehicle = vehicleService.loadVehicleInfo(vehicleId); // 获取车辆信息
        if (vehicle == null) {
            LOGGER.error("车辆不存在，id为" + vehicleId);
            return null;
        }

        FixedPrice fp = loadFixedPrice(vehicleId);
        // vehicle.setCode(fp.getCode());
        vehicle.setCurrentCity(fp.getCity());
        vehicle.setHidden(fp.getHidden());
        vehicle.setFinalTransactionPrice(fp.getPrice());

        map.put("vehicle", vehicle);
        map.put("fp", fp);

        // 获取当前车辆所属：若是汽车街的则有支付功能，若是其他店铺或大客户或个人的都没有支付功能 --- 二手车店铺
        Organization org = null;
        UsedcarShopExt usedcarShop = null;
        try {
            Integer vehicleSrcId = vehicle.getVehicleSrcId();
            if (vehicle.getVehicleSrcType() != null && (vehicle.getVehicleSrcType() == 1) && null != vehicleSrcId) { // 集团客户-开设店铺
                org = organizationService.selectByPrimaryKey(vehicleSrcId);
                // 获取二手车店铺扩展表
                UsedcarShopExtExample shopExamp = new UsedcarShopExtExample();
                UsedcarShopExtExample.Criteria cri = shopExamp.createCriteria();
                cri.andOrgSidEqualTo(vehicleSrcId);
                List<UsedcarShopExt> shopList = usedcarShopExtService.selectByExample(shopExamp);
                if (shopList != null && shopList.size() > 0) {
                    usedcarShop = shopList.get(0);
                }

                List<String> logoLists = repAutomakersService.selectAutomakerLogoByOrgSid(String.valueOf(vehicleSrcId));
                map.put("logoList", logoLists);

            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            org = null;
            usedcarShop = null;
        }
        map.put("shop", org); // 所属店铺
        map.put("usedcarShop", usedcarShop); // 获取对应二手车店铺扩展对象

        String featureItems = vehicle.getFeatureItems(); // 获取车辆配置信息
        String[] featureItem = featureItems.split(","); // 以逗号分割
        map.put("featureItem", featureItem);

        List<DictArea> provinceList = dictAreaService.selectAllProvince();
        map.put("provinceList", provinceList);

        // saved money
        BigDecimal newPrice = vehicle.getNewVehicleSuggestionPrice() == null ? BigDecimal.valueOf(0)
                : vehicle.getNewVehicleSuggestionPrice();
        BigDecimal taxPrice = fp.getTaxBuy() == null ? BigDecimal.valueOf(0) : fp.getTaxBuy();
        BigDecimal fpPrice = fp.getPrice() == null ? BigDecimal.valueOf(0) : fp.getPrice();
        BigDecimal savedMoney = newPrice.add(taxPrice).subtract(fpPrice);
        map.put("savedMoney", savedMoney);

        // 获取订金:Integer 类型
        BigDecimal prePrice = fp.getDeposit();

        // 获取用户可能感兴趣的车辆列表 added by HCF
        Map<String, Object> params = Maps.newHashMap();
        String range = NoHagglePriceRangeEnum.lookupByValue(fpPrice.divide(BigDecimal.valueOf(10000)));
        if (StringUtils.isNotEmpty(range)) {
            String[] ss = range.split(",");
            if (!Strings.isNullOrEmpty(ss[0])) {
                params.put("startPriceMin", new BigDecimal(ss[0]).multiply(BigDecimal.valueOf(10000)));
            }

            if (ss.length > 1 && !Strings.isNullOrEmpty(ss[1])) {
                params.put("startPriceMax", new BigDecimal(ss[1]).multiply(BigDecimal.valueOf(10000)));
            }

            params.put("id", fp.getId());
            params.put("city", fp.getCity()); // 增加已城市筛选
            params.put("offset", 0);
            params.put("limit", 3); // 获取前3条记录
            int dispCount = 3;

            List<FixedPrice> favVehicleList = fixedPriceMapper.selectFavoriteByMap(params);

            if (favVehicleList.isEmpty() || (favVehicleList.size() < dispCount)) {
                // 当第一次筛选条件查询到的记录数不足时，去掉城市条件，并排除之前已经查询到的记录，再次查询以补足记录数
                if (!favVehicleList.isEmpty()) {
                    List<Integer> excludeSidList = new ArrayList<Integer>();
                    for (FixedPrice fv : favVehicleList) {
                        excludeSidList.add(fv.getId());
                    }
                    params.put("excludeSidList", excludeSidList);
                }
                params.remove("city");
                params.put("limit", dispCount - favVehicleList.size());
                favVehicleList.addAll(fixedPriceMapper.selectFavoriteByMap(params));

                if (favVehicleList.isEmpty() || (favVehicleList.size() < dispCount)) {
                    // 当两次查询都记录数不足时，去掉价格区间条件，并排除之前已经查询到的记录，再次查询
                    if (params.containsKey("startPriceMin")) {
                        params.remove("startPriceMin");
                    }

                    if (params.containsKey("startPriceMax")) {
                        params.remove("startPriceMax");
                    }
                    if (!favVehicleList.isEmpty()) {
                        List<Integer> excludeSidList = new ArrayList<Integer>();
                        for (FixedPrice fv : favVehicleList) {
                            excludeSidList.add(fv.getId());
                        }
                        params.put("excludeSidList", excludeSidList);
                    }
                    params.put("limit", dispCount - favVehicleList.size());
                    favVehicleList.addAll(fixedPriceMapper.selectFavoriteByMap(params));
                }
            }

            map.put("favVehicleList", favVehicleList);
        }

        // 新版广告 2015-05-14 09:28:08
        map.put("advInfo", adPositionsService.getPositionAdRandom(2, null, null, null));

        String levelId = vehicle.getLevelId();
        if (!Strings.isNullOrEmpty(levelId)) {
            map.put("vinVehicle", usedvehicleDictionaryService.selectVinVehicleByLevelId(levelId));
        }

        int favID = 0;
        if (loginUserId != null) {
            MemberFavoriteExample mfe = new MemberFavoriteExample();
            MemberFavoriteExample.Criteria mfeCriteria = mfe.createCriteria();
            mfeCriteria.andMemberSidEqualTo(loginUserId); // 当前用户sid
            mfeCriteria.andTypeEqualTo("1"); // 一口价
            mfeCriteria.andEnabledEqualTo(true); // 有效收藏
            mfeCriteria.andRefSidEqualTo(String.valueOf(fp.getId()));

            List<MemberFavorite> favList = memberFavoriteService.selectByExample(mfe);
            if ((favList != null) && (favList.size() > 0)) {
                favID = favList.get(0).getId();
            }
        }
        map.put("favID", favID);

        // 获取 是否能够在线预订标志: 0-不可预订 1-可以预订 2-已预订 3-已出售 4-已下架
        String prepayFlag = "0";
        if (fp.getStatus() == 3) {
            prepayFlag = "1";
        } else if (fp.getStatus() == 4 || fp.getStatus() == 5 || fp.getStatus() == 6) {
            prepayFlag = "2";
        } else if (fp.getStatus() == 2) {
            prepayFlag = "3";
        } else if (fp.getStatus() == 1) {
            prepayFlag = "4";
        }
        map.put("prePrice", prePrice);
        map.put("prepayFlag", prepayFlag);

        return map;
    }

    @Override
    public List<FixedPrice> selectFavoriteByMap(Map<String, Object> params) {
        return fixedPriceMapper.selectFavoriteByMap(params);
    }

    @Override
    public List<String> selectAllProvince() {
        return fixedPriceMapper.selectAllProvince();
    }

    @Override
    public HashMap<String, Object> queryNonOffLineOrder(HashMap<String, Object> param) {
        return fixedPriceMapper.queryNonOffLineOrder(param);
    }

    @Override
    public List<FixedPrice> queryUsedCarLatest(Integer vId) {
        return fixedPriceMapper.queryUsedCarLatest(vId);
    }

    @Override
    public List<OrderItem> queryUsedCarOrderOnline(HashMap<String, Object> param) {
        return fixedPriceMapper.queryUsedCarOrderOnline(param);
    }

    @Override
    public List<FixedPrice> queryAllFixedPrices(FixedPrice fixedPrice) {
        List<FixedPrice> data = fixedPriceMapper.queryFixedPrices(fixedPrice);
        return data;
    }

    @Override
    public List<Map<String, String>> selectBrandByVehicleNum(Integer orgId) {
        List<String> brandList = fixedPriceMapper.selectBrandByFixedPrice(orgId);
        List<DictBrandseries> list = brandseriesService.selectBrandListByNameList(brandList);
        List<Map<String, String>> list_ = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        for (DictBrandseries brandSeries : list) {
            map = new HashMap<String, String>();
            map.put("name", brandSeries.getName());
            map.put("logoUrl", brandSeries.getLogoUrl());
            map.put("firstPinyin", brandSeries.getPinyinAbbreviations().substring(0, 1));
            list_.add(map);
        }

        return list_;
    }

    @Override
    public List<Map<String, String>> selectCityByVehicleNum() {
        List<String> cityList = fixedPriceMapper.selectCityByFixedPrice();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map;

        for (String city : cityList) {
            map = new HashMap<String, String>();
            map.put("name", city);
            list.add(map);
        }

        return list;
    }

    @Override
    public List<FixedPrice> selectByMap(Map<String, Object> params) {
        return fixedPriceMapper.selectByMap(params);
    }

    @Override
    public boolean isVehicleToAuction(Integer vehicleId) {
        boolean result = true;
        FixedPriceExample ave = new FixedPriceExample();
        FixedPriceExample.Criteria criteria = ave.createCriteria();
        criteria.andVehicleIdEqualTo(vehicleId);
        criteria.andLatestEqualTo(true);
        List<Integer> statusList = new ArrayList<Integer>();
        statusList.add(0);
        statusList.add(2);
        statusList.add(3);
        statusList.add(4);
        statusList.add(5);
        statusList.add(6);
        statusList.add(7);
        criteria.andStatusIn(statusList);
        List<FixedPrice> avList = fixedPriceMapper.selectByExample(ave);
        if (avList != null && avList.size() > 0) {
            result = false;
        }
        return result;
    }

    @Override
    public List<String> selectCityByVehicleProvince(String province) {
        List<FixedPrice> fixPrice = fixedPriceMapper.selectCityByVehicleProvince(province);
        List<String> citys = new ArrayList<String>();
        if (fixPrice != null && fixPrice.size() > 0) {
            for (FixedPrice fp : fixPrice) {
                citys.add(fp.getCity());
            }
        }
        return citys;
    }

    @Override
    public Integer updateFavCount(Integer fpId, boolean isAdd) {
        if (fpId == null) {
            return 0;
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("fpId", fpId);
        params.put("isAdd", isAdd);
        return fixedPriceMapper.updateFavCount(params);
    }

    @Override
    public List<FixedPrice> queryExpirationFixedPrice() {
        return fixedPriceMapper.queryExpirationFixedPrice();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public boolean updateFixedPriceStatus(Integer fpId, Integer vehicleId, Integer oldStatus, Integer newStatus)
            throws Exception {
        return updateFixedPriceStatus(fpId, vehicleId, oldStatus, newStatus, null);
    }

    @Override
    public boolean updateFixedPriceStatus(Integer fpId, Integer vehicleId, Integer oldStatus, Integer newStatus,
            String offShelvesRemark) throws Exception {
        return updateFixedPriceStatus(fpId, vehicleId, oldStatus, newStatus, offShelvesRemark, null);
    }

    @Override
    public boolean updateFixedPriceStatus(Integer fpId, Integer vehicleId, Integer oldStatus, Integer newStatus,
            String offShelvesRemark, Integer updateUserId) throws Exception {
        if (fpId != null && oldStatus != null && newStatus != null) {
            FixedPriceExample example = new FixedPriceExample();
            FixedPriceExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(fpId);
            criteria.andStatusEqualTo(oldStatus);
            criteria.andLatestEqualTo(true);
            criteria.andEnabledEqualTo(true);
            FixedPrice record = new FixedPrice();
            record.setStatus(newStatus);
            if (StringUtils.isNotEmpty(offShelvesRemark)) {
                record.setOffShelvesRemark(offShelvesRemark);
                Date date = new Date();
                record.setOffShelvesTime(date);
                record.setUpdateTime(date);
            }
            if (updateUserId != null) {
                record.setUpdateUser(updateUserId);
            }
            int affect = updateByExampleSelective(record, example);
            int rightAffect = 1;// 正确受影响行数
            if (affect != rightAffect) {
                LOGGER.warn("更新展品{}状态{}为{}异常，受影响行数为{}", fpId, oldStatus, newStatus, affect);
            }
            // 判断车辆销售状态是否需要修改
            SaleStatusEnum oldSaleStatus = getSaleStatusByFpStatus(oldStatus);// 原车辆销售状态
            SaleStatusEnum newSaleStatus = getSaleStatusByFpStatus(newStatus);// 新车辆销售状态
            if (oldSaleStatus != null && newSaleStatus != null) {
                if (!oldSaleStatus.equals(newSaleStatus)) {
                    // 更新销售状态
                    affect = vehicleService.updateSaleStatus(vehicleId, newSaleStatus);
                    if (affect != rightAffect) {
                        LOGGER.warn("更新车辆{}销售状态{}为{}异常，受影响行数为{}", vehicleId, oldSaleStatus.getKey(),
                                newSaleStatus.getKey(), affect);
                    }
                    return true;
                } else {
                    LOGGER.info("展品状态{}到{}，车辆销售状态不变无需修改。", oldStatus, newStatus);
                }
            } else {
                throw new Exception(
                        "更新展品状态失败：未获取到正确的车辆销售状态[fpOldStatus:" + oldStatus + ",fpNewStatus:" + newStatus + "]。");
            }
        }
        return false;
    }

    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 根据展品状态获取对应的车辆销售状态
     * </pre>
     *
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月24日 下午12:17:19
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private SaleStatusEnum getSaleStatusByFpStatus(Integer fpStatus) {
        // 0-上架申请、1-已下架、2-已出售、3-已上架、4-已预订、5-已付定金、6-已付全款、7-上架失败
        SaleStatusEnum saleStatus = null;
        switch (fpStatus) {
            case 0:// 上架申请
            case 3:// 已上架
            case 4:// 已预订
            case 5:// 已付定金
                saleStatus = SaleStatusEnum.SALE_STATUS_ONGOING;
                break;
            case 1:// 已下架
            case 7:// 上架失败
                saleStatus = SaleStatusEnum.SALE_STATUS_WAIT;
                break;
            case 2:// 已出售
            case 6:// 已付全款
                saleStatus = SaleStatusEnum.SALE_STATUS_DONE;
                break;
            default:
                break;
        }
        return saleStatus;
    }

}