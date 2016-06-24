package com.autostreets.biz.auction.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.autostreets.biz.auction.mapper.VehicleMapper;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.FixedPriceExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.model.VehicleExample;
import com.autostreets.biz.auction.model.VehicleSales;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.VehicleSalesService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.biz.sys.service.user.UserService;
import com.autostreets.biz.usedvehicle.enums.RequirementTypeEnum;
import com.autostreets.biz.usedvehicle.enums.SaleStatusEnum;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.usedvehicle.service.vehicle.UsedvehicleOperatorService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("auctVehicleService")
public class VehicleServiceImpl extends GenericServiceImpl<Vehicle, VehicleExample, Integer> implements VehicleService {

    private final static Logger LOGGER = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @Autowired
    private com.autostreets.biz.usedvehicle.service.vehicle.VehicleService vehicleInfoService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private FixedPriceService fixedPriceService;

    @Autowired
    private UsedvehicleOperatorService usedvehicleOperatorService;

    @Autowired
    private VehicleSalesService vehicleSalesService;

    @Override
    protected GenericMapper<Vehicle, VehicleExample, Integer> getGenericMapper() {
        return vehicleMapper;
    }

    @Override
    public boolean insertOrUpdate(Vehicle vehicle) {
        LOGGER.debug("更新车辆同步信息");
        Vehicle tempVehicle = vehicleMapper.selectByPrimaryKey(vehicle.getId());
        int rs;
        if (tempVehicle == null) {
            rs = vehicleMapper.insertSelective(vehicle);
        } else {
            rs = vehicleMapper.updateByPrimaryKeySelective(vehicle);
        }
        if (rs == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        LOGGER.debug("删除无效的车辆同步信息");
        int rs = vehicleMapper.deleteByPrimaryKey(id);
        if (rs == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int countByOrgMap(Map<String, Object> params) {
        return vehicleMapper.countByOrgMap(params);
    }

    @Override
    public List<Vehicle> selectByOrgMap(Map<String, Object> params) {
        return vehicleMapper.selectByOrgMap(params);
    }

    @Override
    public Pagination selectUsedVehicle(Pagination pagination, Map<String, Object> params) throws Exception {

        int count = vehicleMapper.selectUsedVehicleCountByMap(params);
        pagination.setCount(count);
        params.put("offset", pagination.getBegin());
        params.put("limit", pagination.getEnd());
        List<Map<String, Object>> list = vehicleMapper.selectUsedVehicleByMap(params);
        String status;
        for (Map<String, Object> m : list) {
            if (m.get("status") != null) {
                status = m.get("status").toString();
                if ("3".equals(status)) {
                    String expirationTime = auctionDictionaryService.getValueByCategoryName("usedcar_expiration_time",
                            "下架时间");

                    Date sellTime = (Date) m.get("sellTime");
                    Calendar c = Calendar.getInstance();
                    c.setTime(sellTime);
                    c.add(Calendar.DATE, Integer.parseInt(expirationTime)); // 自动下架时间

                    Calendar nowTime = Calendar.getInstance();

                    long l = c.getTimeInMillis() - nowTime.getTimeInMillis();

                    int days = new Long(l / (1000 * 60 * 60 * 24)).intValue();

                    m.put("expirationDay", days);

                }
            }
        }
        pagination.setDataList(list);
        return pagination;
    }

    @Override
    public List<Map<String, Object>> selectUsedVehicleForExcel(Map<String, Object> params) {
        List<Map<String, Object>> list = vehicleMapper.selectUsedVehicleByMap(params);
        return list;
    }

    @Override
    public List<Vehicle> selectByMap(Map<String, Object> params) {
        return vehicleMapper.selectByMap(params);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Pagination selectForPricingCenter(Pagination pagination, VehicleInfo vehicleInfo) {
        List<VehicleInfo> list = null;
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        // 不需要分页,导出
        if (pagination == null) {
            // list = vehicleMapper.selectForPricingCenter(vehicle);
            list = vehicleInfoService.selectVehicleList(vehicleInfo);
            pagination = new Pagination();
        } else {// 需要分页
            pagination = vehicleInfoService.selectVehicleBasePage(pagination, vehicleInfo);
            list = (List<VehicleInfo>) pagination.getDataList();
        }
        if (!CollectionUtils.isEmpty(list)) {
            Vehicle v;
            for (VehicleInfo vi : list) {
                v = new Vehicle();
                BeanUtils.copyProperties(vi, v);
                // 最新的销售需求始终是在vehicle_sales
                VehicleSales vehicleSales = vehicleSalesService.selectByPrimaryKey(v.getId());
                if (vehicleSales != null) {
                    v.setRequirementType(vehicleSales.getRequirementType());
                    v.setStartBidPrice(vehicleSales.getStartPrice());
                    v.setReservePrice(vehicleSales.getReservePrice());
                    v.setNewVehicleSuggestionPrice(vehicleSales.getNewVehicleSuggestionPrice());
                    v.setFpPrice(vehicleSales.getFpPrice());
                }
                v = getVehicleOnAuctOrFixed(v, null);
                if (v.getAvCreatedBy() != null) {
                    v.setAvCreatedByName(userService.getNameById(v.getAvCreatedBy()));
                    v.setOpUser(v.getAvCreatedByName());
                }
                if (v.getFpUpdateUser() != null) {
                    v.setFpUpdateUserName(userService.getNameById(v.getFpUpdateUser()));
                    v.setOpUser(v.getFpUpdateUserName());
                }
                if (v.getAvCreatedBy() == null && v.getFpUpdateUser() == null) {
                    // 审核人
                    // VehicleInfo vehicleInfo =
                    // vehicleInfoService.selectVehicleByIdForAuction(v.getId());
                    v.setAuditorName(vi.getAuditor());
                    v.setOpUser(vi.getAuditor());
                }
                if (v.getVehicleSrcId() != null) {
                    Organization organization = organizationService.selectByPrimaryKey(v.getVehicleSrcId());
                    // v.setVehiclesrcOrg(organizationService.getOrgNameById(v.getVehicleSrcId()));
                    v.setVehiclesrcOrg(organization.getOrgNameAbbr());
                }
                if (!StringUtils.equalsIgnoreCase(v.getCurrentCity(), v.getCurrentProvince())) {
                    v.setCurrentCity(v.getCurrentProvince() + " " + v.getCurrentCity());
                }
                if (v.getSweptVolumeStandard() != null && v.getSweptVolumeStandard().startsWith("欧")) {
                    v.setBrandSeries(v.getBrand() + v.getVehicleModel() + "(进口) " + v.getSelledName());
                } else {
                    v.setBrandSeries(v.getBrand() + v.getVehicleModel() + " " + v.getSelledName());
                }
                if (v.getAuditedStatus() != null) {
                    switch (v.getAuditedStatus()) {
                        case 1:
                            v.setVehicleAuditedStatus("审核通过");
                            break;
                        case 4:
                            // 定价中心，商家审核通过==平台待审核
                            v.setVehicleAuditedStatus("待审核");
                            break;
                        default:
                            v.setVehicleAuditedStatus("错误状态");
                            break;
                    }
                }
                if (null != v.getRequirementType() && v.getRequirementType().equals(0)) {
                    v.setSaleType("拍卖");
                    if (v.getAvStatus() != null) {
                        switch (v.getAvStatus()) {
                            case 0:
                                v.setVehicleStatus("待拍卖");
                                break;
                            case 1:
                                v.setVehicleStatus("已上架");
                                break;
                            case 2:
                                v.setVehicleStatus("拍卖成功");
                                break;
                            case 3:
                                v.setVehicleStatus("成交确认");
                                break;
                            case 4:
                                v.setVehicleStatus("流拍");
                                break;
                            case 5:
                                v.setVehicleStatus("拍卖中");
                                break;
                            case 6:
                                v.setVehicleStatus("拍卖暂停");
                                break;
                            case 7:
                                v.setVehicleStatus("取消订单");
                                break;
                            default:
                                break;
                        }
                    } else {
                        if (v.getSaleStatus() != null) {
                            switch (v.getSaleStatus()) {
                                case 0:
                                    v.setVehicleStatus("待售");
                                    break;
                                case 1:
                                    v.setVehicleStatus("出售中");
                                    break;
                                case 2:
                                    v.setVehicleStatus("已出售");
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else if (null != v.getRequirementType() && v.getRequirementType().equals(1)) {
                    v.setSaleType("展厅");
                    if (v.getFpStatus() != null) {
                        switch (v.getFpStatus()) {
                            case 0:
                                v.setVehicleStatus("上架申请");
                                break;
                            case 1:
                                v.setVehicleStatus("已下架");
                                break;
                            case 2:
                                v.setVehicleStatus("已出售");
                                break;
                            case 3:
                                v.setVehicleStatus("已上架");
                                break;
                            case 4:
                                v.setVehicleStatus("已预订");
                                break;
                            case 5:
                                v.setVehicleStatus("已付定金");
                                break;
                            case 6:
                                v.setVehicleStatus("已付全款");
                                break;
                            case 7:
                                v.setVehicleStatus("上架失败");
                                break;
                            default:
                                break;
                        }
                    } else {
                        if (v.getSaleStatus() != null) {
                            switch (v.getSaleStatus()) {
                                case 0:
                                    v.setVehicleStatus("待售");
                                    break;
                                case 1:
                                    v.setVehicleStatus("出售中");
                                    break;
                                case 2:
                                    v.setVehicleStatus("已出售");
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                vehicleList.add(v);
            }
        }
        pagination.setDataList(vehicleList);
        return pagination;
    }

    @Override
    public List<Vehicle> getReferencePriceList(String brand, String vehicleModel, int limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("brand", brand);
        map.put("vehicleModel", vehicleModel);
        map.put("limit", limit);
        List<Vehicle> list = vehicleMapper.getReferencePriceList(map);
        if (CollectionUtils.isEmpty(list)) {
            map.remove("vehicleModel");
            list = vehicleMapper.getReferencePriceList(map);
        }
        return list;
    }

    @Override
    public List<Vehicle> selectVehicleListByIds(List<Integer> idList) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        if (!CollectionUtils.isEmpty(idList)) {
            List<VehicleInfo> vehicleInfos = vehicleInfoService.selectVehicleListByIds(idList);
            Vehicle vehicle;
            if (!CollectionUtils.isEmpty(vehicleInfos)) {
                for (VehicleInfo vehicleInfo : vehicleInfos) {
                    vehicle = new Vehicle();
                    BeanUtils.copyProperties(vehicleInfo, vehicle);
                    vehicles.add(vehicle);
                }
            }
        }
        return vehicles;
    }

    @Override
    public VehicleInfo selectVehicleInfoById(Integer vehicleId) {
        return overrideVehicleInfoAttributes(vehicleInfoService.selectVehicleById(vehicleId));
    }

    @Override
    public VehicleInfo loadVehicleInfo(Integer vehicleId) {
        return overrideVehicleInfoAttributes(vehicleInfoService.loadVehicleInfo(vehicleId));
    }

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 部分属性重写
     * </pre>
     * 
     * @param vehicleInfo
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年12月17日 下午2:16:26
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private VehicleInfo overrideVehicleInfoAttributes(VehicleInfo vehicleInfo) {
        // 商家的销售需求在vehicleSales中，平台后台销售需求又是在vehicleInfo中。
        if (vehicleInfo != null && (vehicleInfo.getRequirementType().endsWith("寄售")
                || vehicleSalesService.getRequirementType(vehicleInfo.getId()) == 1)) {
            // 2015-12-30 20:46:33 展厅的最新指导价保存在fixed_price 中
            FixedPriceExample example = new FixedPriceExample();
            FixedPriceExample.Criteria criteria = example.createCriteria();
            criteria.andVehicleIdEqualTo(vehicleInfo.getId());
            criteria.andLatestEqualTo(true);
            criteria.andEnabledEqualTo(true);
            List<FixedPrice> fixedPrices = fixedPriceService.selectByExample(example);
            if (!CollectionUtils.isEmpty(fixedPrices)) {
                vehicleInfo.setNewVehicleSuggestionPrice(fixedPrices.get(0).getNewVehicleSuggestionPrice());
            }
        }
        return vehicleInfo;
    }

    @Override
    public Vehicle getVehicleOnAuctOrFixed(Vehicle vehicle, Integer requirementType) {
        Integer vehicleId = vehicle.getId();
        if (vehicleId == null) {
            return null;
        }
        if (requirementType == null) {
            AuctionVehicleExample avE = new AuctionVehicleExample();
            AuctionVehicleExample.Criteria criteria = avE.createCriteria();
            criteria.andVehicleIdEqualTo(vehicleId);
            criteria.andLatestEqualTo(true);
            AuctionVehicle av = CollectionUtils.isEmpty(auctionVehicleService.selectByExample(avE)) ? null
                    : auctionVehicleService.selectByExample(avE).get(0);
            if (av != null) {
                vehicle.setAvCreatedBy(av.getCreatedBy());
                vehicle.setAvStatus(av.getStatus());
            } else {// 拍品不存在，则查询是否展厅车辆
                FixedPriceExample fpE = new FixedPriceExample();
                FixedPriceExample.Criteria criteria1 = fpE.createCriteria();
                criteria1.andVehicleIdEqualTo(vehicleId);
                criteria1.andLatestEqualTo(true);
                FixedPrice fp = CollectionUtils.isEmpty(fixedPriceService.selectByExample(fpE)) ? null
                        : fixedPriceService.selectByExample(fpE).get(0);
                if (fp != null) {
                    vehicle.setFpUpdateUser(fp.getUpdateUser());
                    vehicle.setFpStatus(fp.getStatus());
                }
            }
        } else {
            if (requirementType == 0) {// 拍卖
                AuctionVehicleExample avE = new AuctionVehicleExample();
                AuctionVehicleExample.Criteria criteria = avE.createCriteria();
                criteria.andVehicleIdEqualTo(vehicleId);
                criteria.andLatestEqualTo(true);
                AuctionVehicle av = CollectionUtils.isEmpty(auctionVehicleService.selectByExample(avE)) ? null
                        : auctionVehicleService.selectByExample(avE).get(0);
                if (av != null) {
                    vehicle.setAvCreatedBy(av.getCreatedBy());
                    vehicle.setAvStatus(av.getStatus());
                }
            }
            if (requirementType == 1) {// 展厅
                FixedPriceExample fpE = new FixedPriceExample();
                FixedPriceExample.Criteria criteria = fpE.createCriteria();
                criteria.andVehicleIdEqualTo(vehicleId);
                criteria.andLatestEqualTo(true);
                FixedPrice fp = CollectionUtils.isEmpty(fixedPriceService.selectByExample(fpE)) ? null
                        : fixedPriceService.selectByExample(fpE).get(0);
                if (fp != null) {
                    vehicle.setFpUpdateUser(fp.getUpdateUser());
                    vehicle.setFpStatus(fp.getStatus());
                }
            }
        }

        return vehicle;
    }

    @Override
    public int updateSaleStatus(Integer vehicleId, SaleStatusEnum newSaleStatus)
            throws Exception {
        return updateSaleStatus(vehicleId, newSaleStatus, null);
    }

    @Override
    public int updateSaleStatus(Integer vehicleId, SaleStatusEnum newSaleStatus,
            BigDecimal newVehicleSuggestionPrice) throws Exception {
        boolean updateSaleStatusResult = false;
        // 更新vehicle_info 销售状态
        if(newVehicleSuggestionPrice==null){
            updateSaleStatusResult = usedvehicleOperatorService.updateSaleStatus(vehicleId, newSaleStatus);
        }else{
            updateSaleStatusResult = usedvehicleOperatorService.updateSaleStatus(vehicleId, newSaleStatus,newVehicleSuggestionPrice);
        }
        // 更新 vehicle 销售状态
        if (updateSaleStatusResult) {
            Vehicle record = new Vehicle();
            record.setId(vehicleId);
            record.setSaleStatus(newSaleStatus.getKey());
            if (newVehicleSuggestionPrice != null) {
                record.setNewVehicleSuggestionPrice(newVehicleSuggestionPrice);
            }
            // 更新vehicle 销售状态
            return updateByPrimaryKeySelective(record);
        } else {
            throw new Exception("更新车辆(vehicle_info)销售状态失败。 vehicleId =" + vehicleId);
            
        }
    }

    @Override
    public boolean updateRequirementType(Integer vehicleId, RequirementTypeEnum requirementTypeEnum) {
        if (vehicleId != null && requirementTypeEnum != null) {
            boolean updateResult = usedvehicleOperatorService.updateRequirementType(vehicleId, requirementTypeEnum);
            if (updateResult) {
                VehicleExample example = new VehicleExample();
                VehicleExample.Criteria criteria = example.createCriteria();
                criteria.andIdEqualTo(vehicleId);
                Vehicle record = new Vehicle();
                String requirementType = requirementTypeEnum.getValue();
                if (requirementType.endsWith("拍卖")) {
                    record.setRequirementType(0);
                } else if (requirementType.endsWith("寄售")) {
                    record.setRequirementType(1);
                }
                int affect = updateByExampleSelective(record, example);
                int rightAffect = 1;
                if (affect != rightAffect) {
                    LOGGER.warn("更新车辆{}销售方式异常，受影响记录数{}，正确影响行数{}", vehicleId, affect, rightAffect);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePricing(Integer vehicleId, boolean isPricing) {
        if (vehicleId != null) {
            boolean updateResult = usedvehicleOperatorService.updatePricing(vehicleId, isPricing);
            if (updateResult) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(vehicleId);
                vehicle.setPricing(isPricing);
                int affect = updateByPrimaryKeySelective(vehicle);
                int rightAffect = 1;
                if (affect != rightAffect) {
                    LOGGER.warn("更新车辆{}是否定价异常，受影响记录数{}，正确影响行数{}", vehicleId, affect, rightAffect);
                }
                return true;
            }
        }
        return false;
    }
}