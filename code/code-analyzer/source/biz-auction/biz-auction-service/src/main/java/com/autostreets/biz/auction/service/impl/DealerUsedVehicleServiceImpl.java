package com.autostreets.biz.auction.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.constants.ProcessTypeContants;
import com.autostreets.biz.auction.mapper.DealerUsedVehicleMapper;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.DealerUsedVehicle;
import com.autostreets.biz.auction.model.DealerUsedVehicleExample;
import com.autostreets.biz.auction.model.DealerVehicleLog;
import com.autostreets.biz.auction.model.DealerVehicleLogExample;
import com.autostreets.biz.auction.model.ProcessApplyLog;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.DealerUsedVehicleService;
import com.autostreets.biz.auction.service.DealerVehicleLogService;
import com.autostreets.biz.auction.service.ProcessApplyLogService;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.model.user.OrganizationExample;
import com.autostreets.biz.sys.model.user.User;
import com.autostreets.biz.sys.model.user.UserExample;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.biz.sys.service.user.UserService;
import com.autostreets.biz.usedvehicle.enums.AuditedStatusEnum;
import com.autostreets.biz.usedvehicle.enums.VehicleSrcTypeEnum;
import com.autostreets.biz.usedvehicle.model.DictBrandseries;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.usedvehicle.model.VinVehicle;
import com.autostreets.biz.usedvehicle.service.UsedvehicleDictionaryService;
import com.autostreets.biz.usedvehicle.service.vehicle.BrandseriesService;
import com.autostreets.biz.usedvehicle.service.vehicle.UsedvehicleDealerService;
import com.autostreets.biz.usedvehicle.service.vehicle.VehicleService;
import com.autostreets.biz.workflow.exception.WorkflowException;
import com.autostreets.biz.workflow.model.ApprovalApplyDTO;
import com.autostreets.biz.workflow.service.ApprovalService;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.utils.DateUtils;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

@Service("dealerUsedVehicleService")
public class DealerUsedVehicleServiceImpl extends
        GenericServiceImpl<DealerUsedVehicle, DealerUsedVehicleExample, Integer>implements DealerUsedVehicleService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DealerUsedVehicleServiceImpl.class);

    @Autowired
    private DealerUsedVehicleMapper dealerUsedVehicleMapper;

    @Autowired
    private DealerVehicleLogService dealerVehicleLogService;

    @Autowired
    private BrandseriesService brandseriesService;

    @Autowired
    private UsedvehicleDictionaryService usedvehicleDictionaryService;

    @Autowired
    private UsedvehicleDealerService usedvehicleDealerService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private ProcessApplyLogService processApplyLogService;

    @Override
    protected DealerUsedVehicleMapper getGenericMapper() {
        return dealerUsedVehicleMapper;
    }

    @Override
    public List<DictBrandseries> selectBrandList() {
        LOGGER.debug("取得品牌列表");
        return brandseriesService.selectDictBrandseries(null, null, null);
    }

    @Override
    public List<AuctionDictionary> selectVehiclePpeList() {
        LOGGER.debug("取得车辆性质列表");
        return auctionDictionaryService.selectResource("vehicle_ppe");
    }

    @Override
    public List<Map<String, String>> selectSalesChannelList() {
        LOGGER.debug("取得销售渠道列表");
        List<Map<String, String>> scList = new ArrayList<Map<String, String>>();
        Map<String, String> scMap = new HashMap<String, String>();
        scMap.put("value", "private");
        scMap.put("name", "自有平台");
        scList.add(scMap);
        scMap = new HashMap<String, String>();
        scMap.put("value", "autostreets");
        scMap.put("name", "汽车街");
        scList.add(scMap);
        scMap = new HashMap<String, String>();
        scMap.put("value", "third");
        scMap.put("name", "第三方");
        scList.add(scMap);
        scMap = new HashMap<String, String>();
        scMap.put("value", "other");
        scMap.put("name", "其他");
        scList.add(scMap);

        return scList;
    }

    @Override
    public List<Map<String, String>> selectOrgListByScopeList(List<Integer> orgScopeList) {
        LOGGER.debug("根据数据权限取得门店列表");
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
        if (orgScopeList == null || orgScopeList.isEmpty()) {
            return mapList;
        }

        OrganizationExample example = new OrganizationExample();
        OrganizationExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(0);
        criteria.andIdIn(orgScopeList);
        criteria.andTypeEqualTo(2);// 公司（门店）

        List<Organization> list = organizationService.selectByExample(example);

        Map<String, String> map;
        for (Organization org : list) {
            map = new HashMap<String, String>();
            map.put("orgId", String.valueOf(org.getId()));
            map.put("orgName", org.getOrgNameAbbr());
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public Pagination selectPage(Pagination pagination, DealerUsedVehicle dealerUsedVehicle) {
        LOGGER.debug("取得分页列表");

        DealerUsedVehicleExample example = new DealerUsedVehicleExample();
        DealerUsedVehicleExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(false);

        Integer searchOrgId = dealerUsedVehicle.getSearchOrgId();
        List<Integer> orgScopeList = dealerUsedVehicle.getOrgScopeList();
        if (null != searchOrgId) {
            criteria.andOrgIdEqualTo(searchOrgId);
        } else if (null != orgScopeList && !orgScopeList.isEmpty()) {
            criteria.andOrgIdIn(orgScopeList);
        }

        String searchBrandId = dealerUsedVehicle.getSearchBrandId();
        if (!Strings.isNullOrEmpty(searchBrandId)) {
            criteria.andBrandIdEqualTo(searchBrandId);
        }

        String searchLicenseCode = dealerUsedVehicle.getSearchLicenseCode();
        if (!Strings.isNullOrEmpty(searchLicenseCode)) {
            criteria.andLicenseCodeLikeInsensitive("%" + searchLicenseCode + "%");
        }

        String searchVehiclePpe = dealerUsedVehicle.getSearchVehiclePpe();
        if (!Strings.isNullOrEmpty(searchVehiclePpe)) {
            criteria.andVehiclePpeEqualTo(searchVehiclePpe);
        }

        Boolean searchRetire = dealerUsedVehicle.getSearchRetire();
        if (null != searchRetire) {
            criteria.andRetireEqualTo(searchRetire);
        }

        Integer searchSaleStatus = dealerUsedVehicle.getSearchSaleStatus();
        if (null != searchSaleStatus) {
            criteria.andSaleStatusEqualTo(searchSaleStatus);
        }

        int cnt = dealerUsedVehicleMapper.countByExample(example);
        pagination.setCount(cnt);
        example.setPagination(pagination);
        example.setOrderByClause("create_time desc");
        List<DealerUsedVehicle> list = dealerUsedVehicleMapper.selectByExample(example);
        List<Integer> orgIdList = new ArrayList<Integer>();
        for (DealerUsedVehicle duv : list) {
            orgIdList.add(duv.getOrgId());
        }
        if (!orgIdList.isEmpty()) {
            OrganizationExample orgEx = new OrganizationExample();
            orgEx.createCriteria().andIdIn(orgIdList);
            List<Organization> orgList = organizationService.selectByExample(orgEx);
            for (DealerUsedVehicle duv : list) {
                for (Organization org : orgList) {
                    if (org.getId().equals(duv.getOrgId())) {
                        duv.setOrgName(org.getOrgNameAbbr());
                        break;
                    }
                }
            }
        }
        pagination.setDataList(list);

        return pagination;
    }

    @Override
    public void enregisterSave(DealerUsedVehicle dealerUsedVehicle, Integer crtUserId, Integer orgId) {
        LOGGER.debug("车辆登记");
        Date currentDate = new Date();

        int id;
        if (null == dealerUsedVehicle || null == dealerUsedVehicle.getId()) {
            dealerUsedVehicle.setOrgId(orgId);
            dealerUsedVehicle.setCreateTime(currentDate);
            id = dealerUsedVehicleMapper.insertSelective(dealerUsedVehicle);
        } else {
            dealerUsedVehicle.setModifyTime(currentDate);
            dealerUsedVehicleMapper.updateByPrimaryKeySelective(dealerUsedVehicle);
            id = dealerUsedVehicle.getId();
        }

        addLog(crtUserId, id, "自用车登记");
    }

    @Override
    public boolean isExistByVinAndOrgId(String vinCode, Integer orgId) {
        LOGGER.debug("判断相同组织机构下，vin码是否存在");

        DealerUsedVehicleExample example = new DealerUsedVehicleExample();
        DealerUsedVehicleExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(false);
        criteria.andVinCodeEqualTo(vinCode);
        criteria.andOrgIdEqualTo(orgId);
        List<DealerUsedVehicle> list = dealerUsedVehicleMapper.selectByExample(example);

        if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void appliedRetireSave(DealerUsedVehicle dealerUsedVehicle, Integer crtUserId) {
        LOGGER.debug("申请退役");

        MathContext mc = MathContext.UNLIMITED;
        BigDecimal newLimitedPrice = dealerUsedVehicle.getNewLimitedPrice();
        if (null != newLimitedPrice) {
            newLimitedPrice = newLimitedPrice.multiply(BigDecimal.valueOf(10000), mc);
        }
        dealerUsedVehicle.setNewLimitedPrice(newLimitedPrice);
        BigDecimal purchasePrice = dealerUsedVehicle.getPurchasePrice();
        if (null != purchasePrice) {
            purchasePrice = purchasePrice.multiply(BigDecimal.valueOf(10000), mc);
        }
        dealerUsedVehicle.setPurchasePrice(purchasePrice);
        BigDecimal suggestedSalePrice = dealerUsedVehicle.getSuggestedSalePrice();
        if (null != suggestedSalePrice) {
            suggestedSalePrice = suggestedSalePrice.multiply(BigDecimal.valueOf(10000), mc);
        }
        dealerUsedVehicle.setSuggestedSalePrice(suggestedSalePrice);
        dealerUsedVehicle.setRetire(true);
        dealerUsedVehicle.setModifyTime(new Date());
        dealerUsedVehicleMapper.updateByPrimaryKeySelective(dealerUsedVehicle);

        addLog(crtUserId, dealerUsedVehicle.getId(), "申请退役");
    }

    @Override
    public void retiredSave(DealerUsedVehicle dealerUsedVehicle, Integer crtUserId) {
        LOGGER.debug("退役审核");

        MathContext mc = MathContext.UNLIMITED;
        BigDecimal newLimitedPrice = dealerUsedVehicle.getNewLimitedPrice();
        if (null != newLimitedPrice) {
            newLimitedPrice = newLimitedPrice.multiply(BigDecimal.valueOf(10000), mc);
        }
        dealerUsedVehicle.setNewLimitedPrice(newLimitedPrice);
        BigDecimal purchasePrice = dealerUsedVehicle.getPurchasePrice();
        if (null != purchasePrice) {
            purchasePrice = purchasePrice.multiply(BigDecimal.valueOf(10000), mc);
        }
        dealerUsedVehicle.setPurchasePrice(purchasePrice);
        BigDecimal suggestedSalePrice = dealerUsedVehicle.getSuggestedSalePrice();
        if (null != suggestedSalePrice) {
            suggestedSalePrice = suggestedSalePrice.multiply(BigDecimal.valueOf(10000), mc);
        }
        dealerUsedVehicle.setSuggestedSalePrice(suggestedSalePrice);
        dealerUsedVehicle.setAudit(true);
        dealerUsedVehicle.setModifyTime(new Date());
        dealerUsedVehicleMapper.updateByPrimaryKeySelective(dealerUsedVehicle);

        addLog(crtUserId, dealerUsedVehicle.getId(), "退役审核");
    }

    @Override
    public String eqsSave(Integer id, Integer crtUserId, String crtUserRealName, Integer crtOrgId, String crtOrgName)
            throws IOException {
        LOGGER.debug("将自用车信息保存到eqs系统");
        String code;

        DealerUsedVehicle duv = dealerUsedVehicleMapper.selectByPrimaryKey(id);
        Integer vehicleId = duv.getVehicleId();
        if (null == vehicleId) {
            String brand = duv.getBrand();
            String brandId = duv.getBrandId();
            String manufacturer = null;
            String manufacturerId = null;
            String brandSeries = null;
            String seriesId = null;
            String vehicleModel = null;
            String modelId = null;
            String selledName = duv.getVehicleModel();
            String vinCode = duv.getVinCode();
            String licenseCode = duv.getLicenseCode();
            String vehiclePpe = duv.getVehiclePpe();
            BigDecimal purchasePrice = duv.getPurchasePrice();
            BigDecimal startPrice = duv.getStartPrice();
            BigDecimal reservePrice = duv.getReservePrice();
            BigDecimal salePrice = duv.getSalePrice();
            Integer vehicleSrcId = duv.getOrgId();
            Integer requirementType = duv.getRequirementType();
            List<VinVehicle> vvList = usedvehicleDictionaryService.selectVinVehicleListByVin(vinCode);
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
                List<DictBrandseries> sl = brandseriesService.selectDictBrandseries(brand, manufacturer, null);
                for (DictBrandseries s : sl) {
                    if (s.getName().equals(brandSeries)) {
                        seriesId = s.getSid();
                    }
                }
                vehicleModel = vvList.get(0).getVehicleModel();
                List<DictBrandseries> vml = brandseriesService.selectDictBrandseries(brand, manufacturer, brandSeries);
                for (DictBrandseries vm : vml) {
                    if (vm.getName().equals(vehicleModel)) {
                        modelId = vm.getSid();
                    }
                }
            }

            VehicleInfo vehicle = new VehicleInfo();
            vehicle.setVinCode(vinCode);
            vehicle.setBrandId(brandId);
            vehicle.setBrand(brand);
            vehicle.setManufacturerId(manufacturerId);
            vehicle.setManufacturer(manufacturer);
            vehicle.setSeriesId(seriesId);
            vehicle.setBrandSeries(brandSeries);
            vehicle.setModelId(modelId);
            vehicle.setVehicleModel(vehicleModel);
            vehicle.setSelledName(selledName);
            vehicle.setLicenseCode(licenseCode);
            vehicle.setVehiclePpe(vehiclePpe);
            vehicle.setPurchasePrice(purchasePrice);
            vehicle.setStartBidPrice(startPrice);
            vehicle.setReservePrice(reservePrice);
            vehicle.setSalePrice(salePrice);
            vehicle.setVehicleSrcType(VehicleSrcTypeEnum.VEHICLE_SRC_TYPE_GROUP.getKey());
            vehicle.setVehicleSrcId(vehicleSrcId);
            vehicle.setAppraiserId(crtUserId);
            vehicle.setVehicleAppraiser(crtUserRealName);
            vehicle.setEvalOrgId(crtOrgId);
            vehicle.setEvaluationDept(crtOrgName);
            vehicle.setAssessmentDatetime(new Date());
            vehicle.setVehicleLicense(false);
            vehicle.setClearVin(true);
            vehicle.setClearDisplayMileage(false);
            if (null != requirementType) {
                if (0 == requirementType.intValue()) {
                    vehicle.setRequirementType("网上无底价拍卖");
                } else if (1 == requirementType.intValue()) {
                    vehicle.setRequirementType("展厅寄售");
                }
            }

            vehicle = usedvehicleDealerService.vehicleSave(vehicle);
            code = vehicle.getCode();

            duv.setVehicleId(vehicle.getId());
            duv.setEvaluate(true);
            dealerUsedVehicleMapper.updateByPrimaryKeySelective(duv);
        } else {
            VehicleInfo v = vehicleService.selectVehicleById(vehicleId);
            Short auditedStatus = v.getAuditedStatus();
            code = v.getCode();
            if (null != auditedStatus && (auditedStatus.equals(AuditedStatusEnum.AUDITED_STATUS_SUCCESS.getKey()) || auditedStatus.equals(AuditedStatusEnum.AUDITED_STATUS_BUSINESS_SUCCESS.getKey()))) {
                code = "";
            }
        }

        addLog(crtUserId, id, "自用车评估");

        return code;
    }

    @Override
    public List<DealerVehicleLog> track(Integer id) {
        LOGGER.debug("车辆跟踪");

        DealerVehicleLogExample example = new DealerVehicleLogExample();
        example.setOrderByClause("create_time asc");
        DealerVehicleLogExample.Criteria criteria = example.createCriteria();
        criteria.andKeyValueEqualTo(id);
        criteria.andLogTypeEqualTo(1);

        List<DealerVehicleLog> list = dealerVehicleLogService.selectByExample(example);
        List<Integer> userIds = new ArrayList<Integer>();
        Integer userId;
        if (null != list && !list.isEmpty()) {
            for (DealerVehicleLog dvl : list) {
                userId = dvl.getUserId();
                userIds.add(userId);
            }
        }

        UserExample userEx = new UserExample();
        userEx.createCriteria().andIdIn(userIds);
        List<User> userList = userService.selectByExample(userEx);
        for (DealerVehicleLog dvl : list) {
            userId = dvl.getUserId();
            for (User user : userList) {
                if (userId.equals(user.getId())) {
                    dvl.setUserRealName(user.getName());
                    break;
                }
            }
        }

        return list;
    }

    @Override
    public String eqsDetail(Integer vehicleId) {
        LOGGER.debug("取得eqs系统车辆编号");

        VehicleInfo v = vehicleService.selectVehicleById(vehicleId);
        if (null != v) {
            return v.getCode();
        } else {
            return null;
        }
    }

    private void addLog(Integer crtUserId, Integer id, String oc) {
        DealerVehicleLog dvl = new DealerVehicleLog();
        dvl.setUserId(crtUserId);
        dvl.setLogType(1);
        dvl.setKeyValue(id);
        dvl.setOperatorContext(oc);
        dealerVehicleLogService.insertSelective(dvl);
    }

    @Override
    public String retireApply(String retireInfos, String vinCodes, String dataIds, Integer applyUserId,
            String applyUserName, String applyCompany, Integer orgId) {
        try {
            Map<String, Object> runVar = new HashMap<String, Object>();
            ApprovalApplyDTO applyInfo = new ApprovalApplyDTO();
            applyInfo.setApplyUserId(String.valueOf(applyUserId));
            applyInfo.setApplyCompany(applyCompany);
            applyInfo.setApplyDate(new Date());
            applyInfo.setContent("车辆收购申请  " + DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
            applyInfo.setApplyUserName(applyUserName);
            applyInfo.setRunVar(runVar);
            applyInfo.setVinCodes(vinCodes);
            applyInfo.setDetail(retireInfos);
            applyInfo.setOrgId(orgId);
            applyInfo.setProcessTypeId(4);// 退役申请
            String processInstanceId = approvalService.applyApproval(applyInfo);
            if (StringUtils.isNotEmpty(processInstanceId)) {
                List<String> retireIds = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(dataIds);
                if (CollectionUtils.isNotEmpty(retireIds)) {
                    List<ProcessApplyLog> logs = Lists.newArrayList();
                    ProcessApplyLog processApplyLog;
                    DealerUsedVehicle record = new DealerUsedVehicle();
                    record.setProcessInstanceId(processInstanceId);
                    for (String retireId : retireIds) {
                        record.setId(Integer.valueOf(retireId));
                        this.updateByPrimaryKeySelective(record);
                        appliedRetireSave(record, applyUserId);
                        processApplyLog = new ProcessApplyLog();
                        processApplyLog.setProcessId(4);// 退役申请
                        processApplyLog.setProcessInstanceId(processInstanceId);
                        processApplyLog.setProcessType(ProcessTypeContants.RETIRE_VEHICLE_APPLY);// 车辆退役
                        processApplyLog.setKeyValue(Integer.valueOf(retireId));
                        logs.add(processApplyLog);
                    }
                    processApplyLogService.addBatchLog(logs);
                }
            } else {
                return "申请失败，返回流程实例号为空";
            }
        } catch (WorkflowException e) {
            LOGGER.error("申请失败", e);
            if (e.getErrCode() == 10) {
                return "申请失败,存在正在处理中的车辆(vinCode):" + e.getMessage();
            } else {
                return "申请失败：系统异常，请联系管理员！";
            }
        }
        return null;
    }
}