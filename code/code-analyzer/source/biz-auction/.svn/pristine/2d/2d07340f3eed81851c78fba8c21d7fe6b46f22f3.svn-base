package com.autostreets.biz.auction.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.mapper.DealerPurchaseVehicleMapper;
import com.autostreets.biz.auction.model.DealerPurchaseVehicle;
import com.autostreets.biz.auction.model.DealerPurchaseVehicleExample;
import com.autostreets.biz.auction.service.DealerPurchaseVehicleService;
import com.autostreets.biz.usedvehicle.enums.AuditedStatusEnum;
import com.autostreets.biz.usedvehicle.enums.SaleStatusEnum;
import com.autostreets.biz.usedvehicle.enums.VehicleSrcTypeEnum;
import com.autostreets.biz.usedvehicle.model.DictBrandseries;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.usedvehicle.model.VinVehicle;
import com.autostreets.biz.usedvehicle.service.UsedvehicleDictionaryService;
import com.autostreets.biz.usedvehicle.service.vehicle.BrandseriesService;
import com.autostreets.biz.usedvehicle.service.vehicle.UsedvehicleDealerService;
import com.autostreets.biz.usedvehicle.service.vehicle.VehicleService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Controller
@Service("dealerPurchaseVehicleService")
public class DealerPurchaseVehicleServiceImpl extends
        GenericServiceImpl<DealerPurchaseVehicle, DealerPurchaseVehicleExample, Integer> implements
        DealerPurchaseVehicleService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DealerPurchaseVehicleServiceImpl.class);

    @Autowired
    DealerPurchaseVehicleMapper dealerPurchaseVehicleMapper;

    @Autowired
    private UsedvehicleDealerService usedvehicleDealerService;

    @Autowired
    private UsedvehicleDictionaryService usedvehicleDictionaryService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private BrandseriesService brandseriesService;

    @Override
    protected GenericMapper<DealerPurchaseVehicle, DealerPurchaseVehicleExample, Integer> getGenericMapper() {
        return dealerPurchaseVehicleMapper;
    }

    @Override
    public Pagination selectByPage(Pagination pagination, DealerPurchaseVehicle dealerPurchaseVehicle) {
        pagination.setCount(dealerPurchaseVehicleMapper.countByPage(dealerPurchaseVehicle));
        dealerPurchaseVehicle.setPagination(pagination);
        pagination.setDataList(dealerPurchaseVehicleMapper.selectByPage(dealerPurchaseVehicle));
        return pagination;
    }

    @Override
    public Boolean noDupliVInCode(String vinCode, Integer orgId) {
        if (StringUtils.isBlank(vinCode) || orgId == null) {
            return null;
        }
        DealerPurchaseVehicleExample e = new DealerPurchaseVehicleExample();
        DealerPurchaseVehicleExample.Criteria criteria = e.createCriteria();
        criteria.andVinCodeEqualTo(vinCode);
        criteria.andOrgIdEqualTo(orgId);
        int count = countByExample(e);
        if (count >= 1) {
            return false;
        }
        return true;
    }

    @Override
    public String toAssess(Integer purchaseId, Integer orgId, String orgName) {
        if (purchaseId != null) {
            DealerPurchaseVehicle purchaseVehicle = this.selectByPrimaryKey(purchaseId);
            if (purchaseVehicle != null && purchaseVehicle.getCustIntention() != null
                    && purchaseVehicle.getCustIntention().equals(4)) {// 客户意向：已签约
                try {
                    VehicleInfo vehicleInfo = new VehicleInfo();
                    vehicleInfo.setId(purchaseVehicle.getVehicleId());// 车辆ID
                    vehicleInfo.setVinCode(purchaseVehicle.getVinCode());// vin
                                                                         // code
                    // 初次保存，根据vin code 获取厂商 品牌 等信息
                    if (vehicleInfo.getId() == null) {
                        String manufacturer = null;
                        String manufacturerId = null;
                        String brand = purchaseVehicle.getBrand();
                        String brandId = null;
                        String brandSeries = purchaseVehicle.getSeries();
                        String seriesId = null;
                        String vehicleModel = purchaseVehicle.getModel();
                        String modelId = null;
                        List<VinVehicle> vvList = usedvehicleDictionaryService
                                .selectVinVehicleListByVin(purchaseVehicle.getVinCode());
                        if (null != vvList && !vvList.isEmpty()) {
                            brand = vvList.get(0).getBrand();
                            brandId = brandseriesService.loadBrandByName(brand).getSid();
                            manufacturer = vvList.get(0).getManufacturer();
                            List<DictBrandseries> ml = brandseriesService.selectDictBrandseries(brand, null, null);
                            for (DictBrandseries m : ml) {
                                if (m.getName().equals(manufacturer)) {
                                    manufacturerId = m.getSid();
                                }
                            }
                            brandSeries = vvList.get(0).getBrandSeries();
                            List<DictBrandseries> sl = brandseriesService.selectDictBrandseries(brand, manufacturer,
                                    null);
                            for (DictBrandseries s : sl) {
                                if (s.getName().equals(brandSeries)) {
                                    seriesId = s.getSid();
                                }
                            }
                            vehicleModel = vvList.get(0).getVehicleModel();
                            List<DictBrandseries> vml = brandseriesService.selectDictBrandseries(brand, manufacturer,
                                    brandSeries);
                            for (DictBrandseries vm : vml) {
                                if (vm.getName().equals(vehicleModel)) {
                                    modelId = vm.getSid();
                                }
                            }
                        }
                        vehicleInfo.setManufacturer(manufacturer);
                        vehicleInfo.setManufacturerId(manufacturerId);
                        vehicleInfo.setBrand(brand);
                        vehicleInfo.setBrandId(brandId);
                        vehicleInfo.setBrandSeries(brandSeries);
                        vehicleInfo.setSeriesId(seriesId);
                        vehicleInfo.setVehicleModel(vehicleModel);
                        vehicleInfo.setSelledName(vehicleModel);
                        vehicleInfo.setModelId(modelId);
                        vehicleInfo.setSaleStatus(SaleStatusEnum.SALE_STATUS_WAIT.getKey());
                        // eqs 使用性质==车辆性质
                        vehicleInfo.setUsingModel(purchaseVehicle.getVehiclePpe() == 0 ? "营运" : "非营运");
                        vehicleInfo.setCustName(purchaseVehicle.getCustName());// 客户姓名
                        vehicleInfo.setCustPhone(purchaseVehicle.getCustPhone());// 客户联系电话
                        vehicleInfo.setLicenseCode(purchaseVehicle.getLicenseCode());// 车牌号
                        vehicleInfo.setRegisterLicenseYears(purchaseVehicle.getRegisterLicenseYears());// 上牌日期
                        vehicleInfo.setProducedYears(purchaseVehicle.getProducedYears());// 生产年月
                        vehicleInfo.setDisplayMileage(purchaseVehicle.getDisplayMileage());// 表显里程
                        // vehicleInfo.setVehiclePpe(purchaseVehicle.getVehiclePpe());//车辆性质的含义已经变更
                        if (purchaseVehicle.getDisplayMileage() != null) {
                            vehicleInfo.setClearDisplayMileage(true);
                        } else {
                            vehicleInfo.setClearDisplayMileage(false);
                        }
                        vehicleInfo.setClearVin(true);
                        vehicleInfo.setVehicleLicense(false);
                        vehicleInfo.setVehicleAppraiser(purchaseVehicle.getVehicleAppraiser()); // 评估师
                        vehicleInfo.setVehicleSrcType(VehicleSrcTypeEnum.VEHICLE_SRC_TYPE_GROUP.getKey());// 车辆来源类型
                        vehicleInfo.setVehicleSrcId(purchaseVehicle.getOrgId());// 门店
                        // 评估部门
                        vehicleInfo.setEvalOrgId(orgId);
                        vehicleInfo.setEvaluationDept(orgName);
                        vehicleInfo = usedvehicleDealerService.vehicleSave(vehicleInfo);
                    }
                    if (vehicleInfo != null && vehicleInfo.getId() != null) {// 保存、修改成功
                        // vehicleSave 通过code判断是新增还是修改
                        VehicleInfo vehicleEntity = vehicleService.selectVehicleById(vehicleInfo.getId());
                        vehicleInfo.setCode(vehicleEntity != null ? vehicleEntity.getCode() : null);
                        // 首次评估录入，更新登记信息中的车辆ID
                        if (purchaseVehicle.getVehicleId() == null) {
                            purchaseVehicle.setVehicleId(vehicleInfo.getId());
                            this.updateByPrimaryKeySelective(purchaseVehicle);
                        }
                        Short auditedStatus = vehicleEntity.getAuditedStatus();
                        if (null != auditedStatus
                                && (auditedStatus.equals(AuditedStatusEnum.AUDITED_STATUS_SUCCESS.getKey()) || auditedStatus
                                        .equals(AuditedStatusEnum.AUDITED_STATUS_BUSINESS_SUCCESS.getKey()))) {
                            return "";
                        }
                        return vehicleInfo.getCode();
                    } else {
                        LOGGER.error("保存车辆信息{}失败，车辆登记信息标识：{}", JSON.toJSONString(vehicleInfo), purchaseId);
                    }
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return null;
    }

    @Override
    public Pagination selectContractPurchaseV(Pagination pagination, DealerPurchaseVehicle dealerPurchaseVehicle) {

        int count = dealerPurchaseVehicleMapper.selectContractPurchaseVCount(dealerPurchaseVehicle);
        dealerPurchaseVehicle.setPagination(pagination);
        List<DealerPurchaseVehicle> list = dealerPurchaseVehicleMapper.selectContractPurchaseV(dealerPurchaseVehicle);
        pagination.setCount(count);
        pagination.setDataList(list);
        return pagination;
    }

    @Override
    public Pagination selectContractPurchaseByAppraiser(Pagination pagination,
            DealerPurchaseVehicle dealerPurchaseVehicle) {
        int count = dealerPurchaseVehicleMapper.selectContractPurchaseByAppraiserCount(dealerPurchaseVehicle);
        dealerPurchaseVehicle.setPagination(pagination);
        List<DealerPurchaseVehicle> list = dealerPurchaseVehicleMapper
                .selectContractPurchaseByAppraiser(dealerPurchaseVehicle);
        pagination.setCount(count);
        pagination.setDataList(list);
        return pagination;
    }

    @Override
    public DealerPurchaseVehicle selectByVehicleAppraiser(DealerPurchaseVehicle dealerPurchaseVehicle) {
        List<DealerPurchaseVehicle> data = dealerPurchaseVehicleMapper.selectByVehicleAppraiser(dealerPurchaseVehicle);
        if (data.size() > 0) {
            return data.get(0);
        }
        return null;
    }

    @Override
    public DealerPurchaseVehicle selectByRecommender(DealerPurchaseVehicle dealerPurchaseVehicle) {
        List<DealerPurchaseVehicle> data = dealerPurchaseVehicleMapper.selectByRecommender(dealerPurchaseVehicle);
        if (data.size() > 0) {
            return data.get(0);
        }
        return null;
    }

    @Override
    public Pagination selectByOnSaleVehicle(Pagination pagination, DealerPurchaseVehicle dealerPurchaseVehicle) {
        pagination.setCount(dealerPurchaseVehicleMapper.countByOnSaleVehicle(dealerPurchaseVehicle));
        dealerPurchaseVehicle.setPagination(pagination);
        pagination.setDataList(dealerPurchaseVehicleMapper.selectByOnSaleVehicle(dealerPurchaseVehicle));
        return pagination;
    }

    @Override
    public void updateVehicleSaleStatus(Integer processType, Integer processInstanceId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("processType", processType);
        map.put("processInstanceId", processInstanceId);
        dealerPurchaseVehicleMapper.updateVehicleSaleStatus(map);
    }

    @Override
    public Pagination selectAllVehicle(Pagination pagination, DealerPurchaseVehicle dealerPurchaseVehicle) {
        pagination.setCount(dealerPurchaseVehicleMapper.selectAllVehicleCount(dealerPurchaseVehicle));
        dealerPurchaseVehicle.setPagination(pagination);
        pagination.setDataList(dealerPurchaseVehicleMapper.selectAllVehicle(dealerPurchaseVehicle));
        return pagination;
    }
}
