package com.autostreets.biz.auction.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.enums.BusinessIdRuleEnum;
import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.AuctionVehicleLog;
import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.FixedPriceExample;
import com.autostreets.biz.auction.model.OnlineAuctionLog;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.model.base.BaseFixedPriceExample.Criteria;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.OnlineAuctionLogService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.sys.model.dict.DictArea;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.model.user.User;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.biz.usedvehicle.enums.RequirementTypeEnum;
import com.autostreets.biz.usedvehicle.enums.SaleStatusEnum;
import com.autostreets.biz.usedvehicle.enums.VehicleInfoSourceEnum;
import com.autostreets.biz.usedvehicle.model.DictBrandseries;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.usedvehicle.service.vehicle.BrandseriesService;
import com.autostreets.biz.usedvehicle.service.vehicle.UsedvehicleDealerService;
import com.autostreets.biz.wtms.dto.VehicleInventory;
import com.autostreets.biz.wtms.service.WmsService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.service.BusinessRuleService;
import com.google.common.base.Splitter;

/**
 * 拍品管理请求处理
 * 
 * @author youpeng.zhang Date: 2015年8月21日 下午1:33:11
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/auctionvehicle")
public class AuctionVehicleController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionVehicleController.class);

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private BrandseriesService brandseriesService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private com.autostreets.biz.usedvehicle.service.vehicle.VehicleService usedVehicleService;

    @Autowired
    private com.autostreets.biz.auction.service.VehicleService auctVehicleService;

    @Autowired
    private FixedPriceService fixedPriceService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private BusinessRuleService businessRuleService;

    @Autowired
    private UsedvehicleDealerService usedvehicleDealerService;

    @Autowired
    private BidService bidService;

    @Autowired
    private WmsService wmsService;

    @Autowired
    private AuctionDictionaryService auctDictionaryService;

    @Autowired
    private OnlineAuctionLogService onlineAuctionLogService;

    @Autowired
    private OrganizationService organizationService;

    /** 在线拍默认加价幅度 */
    private static final int ONLINE_DEFAULT_PRICE_MARKUP_RANGE = 500;

    /**
     * 拍品管理首页
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月20日 上午8:53:36
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/index")
    @RequiresPermissions("auct:av:index")
    public String doToIndex(Pagination pagination, @ModelAttribute AuctionVehicle auctionVehicle, Model model) {
        LOGGER.info("*******************进入拍品管理首页********************");
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;

        Integer status = auctionVehicle.getStatus();
        if (status == null) {
            auctionVehicle.setStatus(99);
        }

        List<Organization> orgList = getUser().getOrgList();
        Integer userOrgId = null;
        if (orgList != null && orgList.size() > 0) {
            userOrgId = getUser().getOrgList().get(0).getId();// 用户组织机构
        }
        if (userOrgId == null || userOrgId == 8 || userOrgId == 0) {
            auctionVehicle.setOrgIds(null);
        } else {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("parentId", 8);
            param.put("delFlag", 0);
            param.put("enabled", 1);
            List<Integer> autostreetsOrgIds;
            try {
                autostreetsOrgIds = organizationService.selectAllSubOrganizationIdsById(param, true);
                if (!autostreetsOrgIds.contains(userOrgId)) {
                    try {
                        param.put("parentId", userOrgId);
                        List<Integer> orgIds = organizationService.selectAllSubOrganizationIdsById(param, true);
                        auctionVehicle.setOrgIds(orgIds);
                    } catch (Exception e) {
                        LOGGER.error("获取权限失败!", e);
                    }
                }
            } catch (Exception e1) {
                LOGGER.error("获取汽车街权限失败!", e1);
            }
        }

        pagination = auctionVehicleService.selectAuctionVehicles(pagination, auctionVehicle);

        model.addAttribute("brands", brandseriesService.selectDictBrandseries(null, null, null)); // 品牌下拉框

        List<String> yearList = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        for (int i = year; i >= 1985; i--) {
            yearList.add(String.valueOf(i));
        }

        model.addAttribute("yearList", yearList);

        List<String> monthsList = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                monthsList.add("0" + String.valueOf(i));
            } else {
                monthsList.add(String.valueOf(i));
            }
        }
        model.addAttribute("monthsList", monthsList);

        model.addAttribute("pagination", pagination);
        return "auction/auction-vehicle-index";
    }

    // 根据省获取市
    @Override
    @RequestMapping(value = "/getCitys")
    @ResponseBody
    public List<DictArea> getCitys(String proId) {
        return super.getCitys(proId);
    }

    /**
     * 修改拍品顺序
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月19日 下午5:02:41
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/itemorder", method = RequestMethod.GET)
    public String itemOrder(@Validated Integer auctionId, Model model) {
        // 查询拍卖会拍品
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("auctionId", auctionId);
        List<Map<String, String>> auctionVehicleList = auctionVehicleService.listAuctionVehicleByAcutionId(param);
        List<String> vinList = new ArrayList<String>();
        for (Map<String, String> map : auctionVehicleList) {
            String vinCode = map.get("vinCode");
            vinList.add(vinCode);
        }
        try {
            List<VehicleInventory> vehicleInventoryList = wmsService.queryVehicleInventory(vinList);
            for (int i = 0; i < vehicleInventoryList.size(); i++) {
                for (int j = 0; j < auctionVehicleList.size(); j++) {
                    if (vehicleInventoryList.get(i).getVin().equals(auctionVehicleList.get(j).get("vinCode"))) {
                        Map<String, String> map = auctionVehicleList.get(j);
                        map.put("wareHouse", vehicleInventoryList.get(i).getWareHouse());
                        map.put("wareHouseZone", vehicleInventoryList.get(i).getWareHouseZone());
                        map.put("wareHouseLocation", vehicleInventoryList.get(i).getWareHouseLocation());
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.warn("获取仓储列表信息失败：auctionSid={}", auctionId);
        }
        // TODO 新增仓储物流相关字段到页面
        model.addAttribute("auctionVehicleList", auctionVehicleList);
        model.addAttribute("auctionId", auctionId);
        return "/auction/auction-item-order";
    }

    /**
     * 跳转至拍品编辑画面
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月20日 下午2:29:40
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/view")
    public String doView(AuctionVehicle auctionVehicle, Model model) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
        if (null == auctionVehicle)
            auctionVehicle = new AuctionVehicle();

        if (auctionVehicle.getVehicleId() != null) {
            if (auctionVehicle.getId() == null) {// 非拍品
                auctionVehicle = auctionVehicleService.selectVehicle(auctionVehicle);
            } else {
                auctionVehicle = auctionVehicleService.selectAuctionVehicle(auctionVehicle);
            }
            model.addAttribute(auctionVehicle);
        }
        return "auction/auction-vehicle-edit";
    }

    /**
     * 拍品管理同步拍批量设置拍卖会
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月21日 上午11:25:45
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/syncUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String doSyncBatchSave(AuctionVehicle auctionVehicle, String currentMenuSid) {
        LOGGER.info("*******************进入拍品同步批量设置拍卖会处理********************");

        Integer createdBy = getUser().getId();
        if (createdBy == null) {
            throw new NullPointerException("用户非法！！！！！");
        }

        // 拍卖会标识
        Integer auctionId = auctionVehicle.getAuctionId();
        int size1 = 0;
        // 拍品批量处理
        String[] auctionVehicleIds = null;
        // 拍品标识
        Integer auctionVehicleId = null;
        // 更新车辆销售状态
        Integer vehicleId = null;
        // 组装拍品对象
        AuctionVehicle av = null;
        VehicleInfo vehicle = null;
        String msg = "保存失败！";
        boolean flag = true;
        StringBuilder sb = new StringBuilder("\n存在客户需求为非【拍卖】的车辆，未进行保存。\n请按条件查询后进行【撤拍】并修改客户需求！\n车辆编号为");
        boolean isFixedPrice = false;
        StringBuilder sb1 = new StringBuilder("\n部分车辆在“网上展厅”进行寄售且非【已下架】状态。\n如确定需要进行竞拍，请联系相关业务人员下架处理后再操作。\n车辆编号为");

        if (auctionId != null) {

            String allSids = auctionVehicle.getAllSids();// 同步拍批量设置
            if (StringUtils.isNotBlank(allSids)) {

                String[] sids = allSids.split("\\|\\|");// "sid,vehicleSid"
                int size = sids.length;
                int count = 0;
                boolean isAuction = true;

                // 网上展厅
                FixedPriceExample fpex = new FixedPriceExample();
                Criteria fpCriteria = fpex.createCriteria();
                List<FixedPrice> fps = null;

                if (null != sids && size > 0) {

                    int auctionVehicleOrder = auctionVehicleService.selectAuctionVehicleMaxSeq(auctionId) + 1;
                    Auction auction = auctionService.selectByPrimaryKey(auctionId);
                    for (int i = 0; i < size; i++) {

                        auctionVehicleIds = sids[i].split(",");
                        size1 = auctionVehicleIds.length;

                        if (null != auctionVehicleIds && size1 > 0) {

                            if (size1 == 1)
                                auctionVehicleId = Integer.valueOf(auctionVehicleIds[0]);

                            if (size1 == 2) {
                                // 拍品关联标识
                                if (StringUtils.isNotBlank(auctionVehicleIds[0])) {
                                    auctionVehicleId = Integer.valueOf(auctionVehicleIds[0]);
                                }
                                // 车辆
                                if (StringUtils.isNotBlank(auctionVehicleIds[1])) {
                                    vehicleId = Integer.valueOf(auctionVehicleIds[1]);
                                }
                            }

                            if (vehicleId != null) {

                                count++;
                                // 取得车辆信息
                                vehicle = vehicleService.selectVehicleInfoById(vehicleId);
                                if (null == vehicle) {
                                    LOGGER.error("车辆[" + vehicleId + "]不存在!");
                                }
                                if (null == vehicle) {
                                    LOGGER.error("车辆[" + vehicleId + "]不存在!");
                                }
                                if (vehicle.getSaleStatus() != null && vehicle.getSaleStatus() != 0) {// 不是代售的车辆
                                    flag = false;
                                    sb.append(vehicle.getCode() + "、");
                                    continue;
                                }

                                isAuction = isAuction(vehicle.getRequirementType());

                                if (!isAuction) {
                                    sb.append(vehicle.getCode() + "、");

                                    if (flag)
                                        flag = false;

                                    continue;
                                }

                                fpex.clear();
                                fpCriteria = fpex.createCriteria();
                                fpCriteria.andVehicleIdEqualTo(vehicleId);
                                fpCriteria.andStatusNotEqualTo(1);// 已下架
                                fpCriteria.andLatestEqualTo(Boolean.TRUE);
                                fpCriteria.andEnabledEqualTo(Boolean.TRUE);
                                fps = fixedPriceService.selectByExample(fpex);

                                if (!CollectionUtils.isEmpty(fps)) {
                                    sb1.append(vehicle.getCode() + "、");

                                    if (!isFixedPrice)
                                        isFixedPrice = true;

                                    continue;
                                }

                                av = new AuctionVehicle();
                                try {
                                    BeanUtils.copyProperties(auctionVehicle, av);
                                } catch (Exception e) {
                                    LOGGER.error(e.getMessage(), e);
                                }
                                av.setAuctionId(auctionId);

                                updateAuctionVehicleFromAuction(av, auction);
                                // String oldAuctionSid = null;

                                // 未建立拍卖与拍品关系车辆处理
                                if (auctionVehicleId == null) {

                                    av.setVehicleId(vehicleId);
                                    // 设置起拍价、保留价
                                    av.setStartPrice(
                                            (vehicle.getStartBidPrice()) == null ? null : vehicle.getStartBidPrice());
                                    av.setReservePrice(
                                            (vehicle.getReservePrice()) == null ? null : vehicle.getReservePrice());
                                    av.setPlusRange(200);// 默认200
                                    // 拍品默认顺序
                                    av.setAuctionType(0);
                                    av.setAuctionVehicleOrder(auctionVehicleOrder);
                                    av.setCreatedBy(createdBy);
                                    av.setStatus(GlobalConstants.WAITING_FOR_THE_AUCTION);
                                    initAuctionVehicle(av);

                                    // 更新车辆销售状态为销售中 2014年9月2日 12:10:50 与宫伟来讨论更新
                                    // updateVehicleSaleStatus(vehicleSid, "1");
                                    LOGGER.info("******[拍品业务操作日志-同步拍]成功添加待售车辆（#车辆编号" + vehicle.getCode() + "，#销售状态为"
                                            + formatStatusSale(vehicle.getSaleStatus()) + "）至拍卖会【" + auction.getTitle()
                                            + "】中，#拍卖会编号（" + auction.getCode() + "）、#拍卖会状态（" + auction.getStatus()
                                            + getLogInfo().toString() + new Date() + "）");

                                } else {
                                    // vehicle = null;
                                    AuctionVehicle tmpAv = auctionVehicleService.selectByPrimaryKey(auctionVehicleId);
                                    Integer status = tmpAv.getStatus();
                                    // oldAuctionSid = tmpAv.getAuctionSid();
                                    Integer auctionType = tmpAv.getAuctionType();

                                    if (status == null) {
                                        throw new NullPointerException("拍品状态非法！！！！！");
                                    }

                                    if (auctionType == null) {
                                        throw new NullPointerException("拍品类型非法！！！！！");
                                    }

                                    // 流拍、取消订单操作
                                    if (isCreateAuction(status)) {
                                        tmpAv.setLatest(Boolean.FALSE);
                                        auctionVehicleService.updateByPrimaryKeySelective(tmpAv);

                                        updateAuctionVehicleFromAuction(tmpAv, auction);
                                        tmpAv.setAuctionType(GlobalConstants.AUCTION_TYPE_SYNC);
                                        tmpAv.setAuctionId(auctionId);
                                        tmpAv.setMaxBidPrice(BigDecimal.ZERO);
                                        tmpAv.setCreatedBy(createdBy);
                                        tmpAv.setAuctionVehicleOrder(auctionVehicleOrder);
                                        tmpAv.setStatus(GlobalConstants.WAITING_FOR_THE_AUCTION);

                                        initAuctionVehicle(tmpAv);

                                        LOGGER.info("******[拍品业务操作日志-同步拍]" + formatStatusAuction(status) + "拍品（#拍品编号"
                                                + tmpAv.getAvNo() + "，#车辆编号" + vehicle.getCode() + "，#车辆销售状态"
                                                + formatStatusSale(vehicle.getSaleStatus())
                                                + "）重新上架成功，（#拍卖类型设置为0【同步拍】，#拍品最新状态设置为0【待拍卖】" + getLogInfo().toString()
                                                + new Date() + "）");

                                    } else {
                                        StringBuffer logSync = new StringBuffer("******[拍品业务日志-同步拍]拍品更新操作：");

                                        logSync.append("#当前拍品编号" + tmpAv.getAvNo() + "，#车辆编号" + vehicle.getCode()
                                                + "，#当前拍品原拍卖会SID（" + tmpAv.getAuctionId() + "），#原拍卖会状态"
                                                + auction.getStatus() + "），#更新至新拍卖会【" + auction.getTitle()
                                                + "】，#新拍卖会SID（" + auction.getId() + "），");

                                        if (auction.getStatus().equals(GlobalConstants.AUCTION_STATUS_CREATE)) {
                                            av.setStatus(GlobalConstants.WAITING_FOR_THE_AUCTION);
                                            logSync.append("（#新拍卖会状态为【未发布】，设置拍品状态为【待拍卖】），");
                                        }

                                        // 待拍卖拍品添加到新拍卖会
                                        av.setId(auctionVehicleId);
                                        av.setAuctionVehicleOrder(auctionVehicleOrder);
                                        av.setCreatedBy(createdBy);

                                        if (auctionType.equals(GlobalConstants.AUCTION_TYPE_ONLINE)) {
                                            av.setAvNo(businessRuleService
                                                    .getBusinessIdByType(BusinessIdRuleEnum.AV_SYN.getCode()));
                                            logSync.append("（该拍品为【在线拍】转【同步拍】），");
                                        }

                                        auctionVehicleService.updateByPrimaryKeySelective(av);
                                        logSync.append("（拍品原状态为" + formatStatusAuction(tmpAv.getStatus()) + "，更新后状态不变");
                                        LOGGER.info(logSync.toString() + getLogInfo().toString() + new Date() + "）");
                                    }
                                }
                                updateVehicleSaleStatus(vehicleId, 1);
                                LOGGER.info("******[拍品业务操作日志-同步拍]车辆（#车辆编号" + vehicle.getCode() + "），（原【销售状态】为"
                                        + formatStatusSale(vehicle.getSaleStatus()) + "，更新后【销售状态】为1"
                                        + getLogInfo().toString() + new Date() + "）");
                            }
                        }
                        // 更新拍卖会拍品数量
                        auctionService.updateAuctionVehicleQuantity();
                        auctionVehicleOrder++;
                    }
                }

                if (count == size)
                    msg = "保存成功！";
            }
        }

        if (!flag)
            msg += sb.toString();

        if (!flag && isFixedPrice)
            msg += "\n-------------------------------------------\n";

        if (isFixedPrice)
            msg += sb1.toString();

        LOGGER.info("****[拍品业务操作日志-同步拍]同步拍批量设置结果：" + msg + getLogInfo().toString() + new Date() + "）");

        return msg;
    }

    /**
     * 拍品状态为【流拍】-4、【取消订单】-7，则创建新拍品更新旧拍品latest
     * 
     * @return boolean
     * @author youpeng.zhang Date: 2015年8月21日 下午2:16:01
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    private boolean isCreateAuction(Integer status) {
        if (status == 4 || status == 7) {
            return true;
        }
        return false;
    }

    /**
     * 待售车辆转在线拍时由原来的取车辆中起拍价、保留价
     * 
     * @return JsonResult
     * @author youpeng.zhang Date: 2015年8月24日 下午2:14:26
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/online", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doOnlineSave(AuctionVehicle auctionVehicle, String currentMenuSid) {
        LOGGER.info("*******************进入在线拍流程处理********************");
        String onlineSids = auctionVehicle.getOnlineSids();
        Integer createdBy = getUser().getId();
        if (createdBy == null)
            throw new NullPointerException("用户非法！！！！！");

        int size1 = 0;
        // 拍品批量处理
        String[] auctionVehicleIds = null;
        // 拍品标识
        Integer auctionVehicleId = null;
        // 更新车辆销售状态
        Integer vehicleId = null;
        // 组装拍品对象
        AuctionVehicle av = null;
        String msg = "保存失败！";
        boolean flag = true;// 客户需求判定
        StringBuilder sb = new StringBuilder("\n存在客户需求为非【拍卖】的车辆或车辆状态不在【待售中】，未进行保存。\n请按条件查询后进行【撤拍】并修改客户需求！\n车辆编号为");
        boolean isFixedPrice = false;// 是否网上展品判定
        StringBuilder sb1 = new StringBuilder("\n部分车辆在“网上展厅”进行寄售且非【已下架】状态。\n如确定需要进行竞拍，请联系相关业务人员下架处理后再操作。\n车辆编号为");
        boolean checkArea = false;// 车辆所在区域判定
        StringBuilder areaMsg = new StringBuilder("\n部分车辆【所在区域】非法。\n如确定需要进行竞拍，请联系相关业务人员编辑车辆后再操作。\n车辆编号为");
        // add by zxf 上拍操作记录日志
        int successCount = 0;// 成功上拍的车辆数
        StringBuilder vehicleList = new StringBuilder("");// 成功上排的车辆ID

        List<AuctionDictionary> commissionRates = auctDictionaryService.selectResource("online_buyer_commission_rate");
        BigDecimal commissionRate = null;
        if (commissionRates != null && commissionRates.size() > 0) {
            commissionRate = new BigDecimal(commissionRates.get(0).getValue());
        }
        List<AuctionDictionary> fixedCommissions = auctDictionaryService
                .selectResource("online_buyer_fixed_commission");
        BigDecimal fixedCommission = null;
        if (fixedCommissions != null && fixedCommissions.size() > 0) {
            fixedCommission = new BigDecimal(fixedCommissions.get(0).getValue());
        }

        if (StringUtils.isNotBlank(onlineSids)) {
            String[] ids = onlineSids.split("\\|\\|");// "sid,vehicleSid"
            int size = ids.length;
            int count = 0;
            boolean isAuction = true;
            boolean isArea = true;

            // 网上展厅
            FixedPriceExample fpex = new FixedPriceExample();
            Criteria fpCriteria = fpex.createCriteria();
            List<FixedPrice> fps = null;

            if (ArrayUtils.isNotEmpty(ids)) {
                for (int i = 0; i < size; i++) {

                    auctionVehicleIds = ids[i].split(",");
                    size1 = auctionVehicleIds.length;

                    if (ArrayUtils.isNotEmpty(auctionVehicleIds)) {
                        if (size1 == 1)
                            auctionVehicleId = Integer.valueOf(auctionVehicleIds[0]);
                        if (size1 == 2) {
                            // 拍品关联标识
                            if (StringUtils.isNotBlank(auctionVehicleIds[0])) {
                                auctionVehicleId = Integer.valueOf(auctionVehicleIds[0]);
                            }
                            // 车辆标识
                            if (StringUtils.isNotBlank(auctionVehicleIds[1])) {
                                vehicleId = Integer.valueOf(auctionVehicleIds[1]);
                            }
                        }
                        if (vehicleId != null) {
                            count++;
                            VehicleInfo vehicle = vehicleService.selectVehicleInfoById(vehicleId);
                            if (null == vehicle)
                                throw new NullPointerException(vehicleId + "车辆不存在，数据异常！！！！！");
                            if (vehicle.getSaleStatus() != null && vehicle.getSaleStatus() != 0) {
                                flag = false;
                                sb.append(vehicle.getCode() + "、");
                                continue;
                            }
                            isAuction = isAuction(vehicle.getRequirementType());
                            if (!isAuction) {
                                sb.append(vehicle.getCode() + "、");

                                if (flag)
                                    flag = false;

                                continue;
                            }

                            isArea = checkArea(vehicle.getCurrentProvince(), vehicle.getCurrentCity());
                            if (!isArea) {
                                areaMsg.append(vehicle.getCode() + "、");

                                if (!checkArea)
                                    checkArea = true;

                                continue;
                            }

                            fpex.clear();
                            fpCriteria = fpex.createCriteria();
                            fpCriteria.andVehicleIdEqualTo(vehicleId);
                            fpCriteria.andStatusNotEqualTo(1);// 已下架
                            fpCriteria.andLatestEqualTo(Boolean.TRUE);
                            fpCriteria.andEnabledEqualTo(Boolean.TRUE);
                            fps = fixedPriceService.selectByExample(fpex);

                            if (!CollectionUtils.isEmpty(fps)) {
                                sb1.append(vehicle.getCode() + "、");

                                if (!isFixedPrice)
                                    isFixedPrice = true;

                                continue;
                            }

                            av = new AuctionVehicle();

                            // 应free.gong要求http://jira.autostreets.com/jira4/browse/PM-3827，修改添加拍品到在线拍时，起拍价、保留价默认单位改为万元
                            BigDecimal startAVprice = auctionVehicle.getStartPrice();
                            BigDecimal reserveAVprice = auctionVehicle.getReservePrice();
                            BeanUtils.copyProperties(auctionVehicle, av);
                            if (startAVprice != null) {
                                av.setStartPrice(startAVprice.multiply(new BigDecimal(10000)));
                            }
                            if (reserveAVprice != null) {
                                av.setReservePrice(reserveAVprice.multiply(new BigDecimal(10000)));
                            }
                            av.setAuctionId(null);
                            av.setAuctionType(GlobalConstants.AUCTION_TYPE_ONLINE);// 在线拍

                            Integer avType = av.getAvType();// 拍品类型

                            BigDecimal startPrice1 = av.getStartPrice();// 起拍价
                            BigDecimal reservePrice1 = av.getReservePrice();// 保留价

                            // 未建立拍卖与拍品关系车辆处理
                            if (auctionVehicleId == null) {

                                av.setVehicleId(vehicleId);
                                av.setStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);// 已上架

                                Integer plus = auctionVehicle.getPlusRange();// 加价幅度处理
                                if (null == plus || plus.compareTo(0) == 0) {
                                    av.setPlusRange(ONLINE_DEFAULT_PRICE_MARKUP_RANGE);
                                }

                                // 从车辆中拉取竞拍区域
                                String province = vehicle.getCurrentProvince();
                                String city = vehicle.getCurrentCity();

                                if (StringUtils.isBlank(auctionVehicle.getProvince()))
                                    av.setProvince(province);

                                if (StringUtils.isBlank(auctionVehicle.getCity()))
                                    av.setCity(city);

                                // 起拍价、保留价
                                BigDecimal startPrice = vehicle.getStartBidPrice();
                                BigDecimal reservePrice = vehicle.getReservePrice();
                                if (startPrice1 == null) {
                                    if (null == startPrice) {
                                        av.setStartPrice(BigDecimal.ZERO);
                                    } else {
                                        av.setStartPrice(startPrice);
                                    }
                                    // }
                                } else {
                                    av.setStartPrice(startPrice1);
                                }

                                if (reservePrice1 == null) {
                                    if (null == reservePrice) {
                                        av.setReservePrice(BigDecimal.ZERO);
                                    } else {
                                        av.setReservePrice(reservePrice);
                                    }
                                    // }
                                } else {
                                    av.setReservePrice(reservePrice1);
                                }

                                // edit by zjz 添加热门推荐
                                if (BooleanUtils.isTrue(auctionVehicle.getRecommend())) {
                                    av.setRecommend(true);
                                } else {
                                    av.setRecommend(false);
                                }
                                // edit by zxf 添加是否活动拍品，添加活动拍品title
                                if (BooleanUtils.isTrue(auctionVehicle.getActivity())) {
                                    av.setActivity(true);
                                } else {
                                    av.setActivity(false);
                                }
                                if (StringUtils.isNotBlank(auctionVehicle.getActivityTitle())) {
                                    av.setActivityTitle(auctionVehicle.getActivityTitle());
                                }
                                // edit end;
                                av.setCreatedBy(createdBy);
                                // 应free.gong要求http://jira.autostreets.com/jira4/browse/PM-4426，增加佣金百分比和固定佣金
                                // 若佣金比例参数值>0，则需保存该值到buyer_commission_rate中，若固定佣金参数值>0，则需保存该值到buyer_fixed_commission中，若两个均>0,则只保存佣金比例。
                                if (commissionRate != null && commissionRate.compareTo(BigDecimal.ZERO) > 0) {
                                    av.setBuyerCommissionRate(commissionRate);
                                } else if (fixedCommission != null && fixedCommission.compareTo(BigDecimal.ZERO) > 0) {
                                    av.setBuyerFixedCommission(fixedCommission);
                                }
                                initAuctionVehicle(av);

                                // 更新车辆销售状态为销售中
                                updateVehicleSaleStatus(vehicleId, 1);
                                LOGGER.info("******[拍品业务操作日志-在线拍]车辆（#车辆编号" + vehicle.getCode() + "，原【销售状态】为"
                                        + formatStatusSale(vehicle.getSaleStatus())
                                        + "，更新后【销售状态】为1【销售中】），初始化拍品状态为1【已上架】" + getLogInfo().toString() + new Date()
                                        + "）");
                                // add by zxf 添加上拍日志
                                successCount++;
                                vehicleList.append(vehicleId + ",");
                            } else {

                                // vehicle = null;
                                AuctionVehicle tmpAv = auctionVehicleService.selectByPrimaryKey(auctionVehicleId);
                                Integer status = tmpAv.getStatus();
                                Integer auctionType = tmpAv.getAuctionType();

                                if (status == null) {
                                    throw new NullPointerException("拍品状态非法！！！！！");
                                }

                                if (auctionType == null) {
                                    throw new NullPointerException("拍品类型非法！！！！！");
                                }

                                Integer plusRange1 = av.getPlusRange();// 加价幅度
                                Integer agentPrice1 = av.getAgentPrice();// 代理价

                                // 流拍、取消订单处理
                                if (isCreateAuction(status)) {
                                    tmpAv.setLatest(Boolean.FALSE);
                                    auctionVehicleService.updateByPrimaryKeySelective(tmpAv);

                                    tmpAv.setPlanStartTime(auctionVehicle.getPlanStartTime());
                                    tmpAv.setPlanEndTime(auctionVehicle.getPlanEndTime());

                                    if (startPrice1 != null && startPrice1.compareTo(BigDecimal.ZERO) == 1)
                                        tmpAv.setStartPrice(startPrice1);

                                    if (reservePrice1 != null && reservePrice1.compareTo(BigDecimal.ZERO) == 1)
                                        tmpAv.setReservePrice(reservePrice1);

                                    if (plusRange1 != null)
                                        tmpAv.setPlusRange(plusRange1);

                                    if (agentPrice1 != null && agentPrice1.compareTo(0) == 1)
                                        tmpAv.setAgentPrice(agentPrice1);

                                    if (StringUtils.isNotBlank(auctionVehicle.getProvince()))
                                        tmpAv.setProvince(auctionVehicle.getProvince());

                                    if (StringUtils.isNotBlank(auctionVehicle.getCity()))
                                        tmpAv.setCity(auctionVehicle.getCity());

                                    if (avType != null) {
                                        tmpAv.setAvType(avType);
                                    }

                                    // edit by zjz 添加热门推荐
                                    if (BooleanUtils.isTrue(auctionVehicle.getRecommend())) {
                                        tmpAv.setRecommend(true);
                                    } else {
                                        tmpAv.setRecommend(false);
                                    }
                                    // edit by zxf 添加是否活动拍品，添加活动拍品title
                                    if (BooleanUtils.isTrue(auctionVehicle.getActivity())) {
                                        tmpAv.setActivity(true);
                                    } else {
                                        tmpAv.setActivity(false);
                                    }
                                    if (StringUtils.isNotBlank(auctionVehicle.getActivityTitle())) {
                                        tmpAv.setActivityTitle(auctionVehicle.getActivityTitle());
                                    }
                                    // edit end;

                                    // 在更新旧拍品后，创建新的拍品
                                    tmpAv.setVehicleId(vehicleId);
                                    tmpAv.setLatest(Boolean.TRUE);
                                    tmpAv.setAuctionType(GlobalConstants.AUCTION_TYPE_ONLINE);// 在线拍
                                    tmpAv.setStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);// 已上架
                                    tmpAv.setAuctionId(null);
                                    tmpAv.setMaxBidPrice(BigDecimal.ZERO);
                                    tmpAv.setCreatedBy(createdBy);
                                    // 应free.gong要求http://jira.autostreets.com/jira4/browse/PM-4426，增加佣金百分比和固定佣金
                                    // 若佣金比例参数值>0，则需保存该值到buyer_commission_rate中，若固定佣金参数值>0，则需保存该值到buyer_fixed_commission中，若两个均>0,则只保存佣金比例。
                                    if (commissionRate != null && commissionRate.compareTo(BigDecimal.ZERO) > 0) {
                                        tmpAv.setBuyerCommissionRate(commissionRate);
                                    } else
                                        if (fixedCommission != null && fixedCommission.compareTo(BigDecimal.ZERO) > 0) {
                                        tmpAv.setBuyerFixedCommission(fixedCommission);
                                    }
                                    initAuctionVehicle(tmpAv);
                                    updateVehicleSaleStatus(vehicleId, 1);

                                    String statusMsg = status == 4 ? "流拍" : "撤拍";
                                    LOGGER.info("******[拍品业务操作日志-在线拍]【" + statusMsg + "】拍品（#拍品编号" + tmpAv.getAvNo()
                                            + "，#车辆编号" + vehicle.getCode() + "，#销售状态"
                                            + formatStatusSale(vehicle.getSaleStatus())
                                            + "）重新上架成功，（#拍卖类型设置为1【在线拍】，#拍品最新状态设置为1【已上架】，#销售状态为1【销售中】"
                                            + getLogInfo().toString() + new Date() + "）");
                                    successCount++;
                                    vehicleList.append(vehicleId + ",");
                                } else {
                                    // 拍品同步拍/在线拍转换
                                    av.setId(auctionVehicleId);
                                    av.setAuctionType(GlobalConstants.AUCTION_TYPE_ONLINE);// 在线拍

                                    StringBuffer logInfo = new StringBuffer("******[拍品业务日志-在线拍]拍品更新操作：");
                                    logInfo.append("#当前拍品编号" + tmpAv.getAvNo() + "，#车辆编号" + vehicle.getCode() + "，#销售状态"
                                            + formatStatusSale(vehicle.getSaleStatus()) + "。（拍品原状态为"
                                            + formatStatusAuction(tmpAv.getStatus()) + "，更新后状态不变。）");

                                    if (auctionType.equals(GlobalConstants.AUCTION_TYPE_SYNC)) {
                                        av.setStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);// 已上架
                                        av.setAvNo(businessRuleService
                                                .getBusinessIdByType(BusinessIdRuleEnum.AV_ONLINE.getCode()));
                                        logInfo.append("该拍品为【同步拍】转【在线拍】#拍品原拍卖会SID（" + tmpAv.getAuctionId() + "）");
                                    }

                                    if (plusRange1 == null || plusRange1.compareTo(0) == 0)
                                        av.setPlusRange(null);

                                    if (reservePrice1 == null || reservePrice1.compareTo(BigDecimal.ZERO) == 0)
                                        av.setReservePrice(null);

                                    if (startPrice1 == null || startPrice1.compareTo(BigDecimal.ZERO) == 0)
                                        av.setStartPrice(null);

                                    if (agentPrice1 == null || agentPrice1.compareTo(0) == 0)
                                        av.setAgentPrice(null);

                                    if (StringUtils.isBlank(av.getProvince()))
                                        av.setProvince(null);

                                    if (StringUtils.isBlank(av.getCity()))
                                        av.setCity(null);

                                    // edit by zjz 添加热门推荐
                                    if (BooleanUtils.isTrue(auctionVehicle.getRecommend())) {
                                        av.setRecommend(true);
                                    } else {
                                        av.setRecommend(false);
                                    }
                                    // edit by zxf 添加是否活动拍品，添加活动拍品title
                                    if (BooleanUtils.isTrue(auctionVehicle.getActivity())) {
                                        av.setActivity(true);
                                    } else {
                                        av.setActivity(false);
                                    }
                                    if (StringUtils.isNotBlank(auctionVehicle.getActivityTitle())) {
                                        av.setActivityTitle(auctionVehicle.getActivityTitle());
                                    }
                                    // edit end;
                                    av.setCreatedBy(createdBy);
                                    // 应free.gong要求http://jira.autostreets.com/jira4/browse/PM-4426，增加佣金百分比和固定佣金
                                    // 若佣金比例参数值>0，则需保存该值到buyer_commission_rate中，若固定佣金参数值>0，则需保存该值到buyer_fixed_commission中，若两个均>0,则只保存佣金比例。
                                    if (commissionRate != null && commissionRate.compareTo(BigDecimal.ZERO) > 0) {
                                        av.setBuyerCommissionRate(commissionRate);
                                    } else
                                        if (fixedCommission != null && fixedCommission.compareTo(BigDecimal.ZERO) > 0) {
                                        av.setBuyerFixedCommission(fixedCommission);
                                    }
                                    auctionVehicleService.updateByPrimaryKeySelective(av);
                                    LOGGER.info(logInfo.toString() + getLogInfo().toString() + new Date() + "）");
                                    successCount++;
                                    vehicleList.append(vehicleId + ",");
                                }
                            }
                        }
                    }
                    auctionVehicleId = null;
                }
                // 更新拍卖会拍品数量
                auctionService.updateAuctionVehicleQuantity();

                if (count == size)
                    msg = "保存成功！";
                if (successCount > 0) {
                    OnlineAuctionLog onlineAuctionLog = new OnlineAuctionLog();
                    BeanUtils.copyProperties(auctionVehicle, onlineAuctionLog);
                    onlineAuctionLog.setId(null);
                    onlineAuctionLog.setUserId(createdBy);
                    int lastIndex = vehicleList.length() - 1;
                    String vehicleList1 = vehicleList.toString();
                    vehicleList1 = vehicleList1.substring(0, lastIndex);// 去掉最后一个","
                    if (vehicleList1.length() > 300) {// 数据库中最长长度为300
                        vehicleList1 = vehicleList1.substring(0, 299);
                        vehicleList1 = vehicleList1.substring(0, vehicleList1.lastIndexOf(",")) + "等";
                    }
                    onlineAuctionLog.setVehilceList(vehicleList1);
                    if (!onlineAuctionLogService.insertOnlineLog(onlineAuctionLog)) {
                        LOGGER.warn("记录在线拍上拍日志操作失败！");
                    }
                }
            }
        }

        if (!flag)
            msg += sb.toString();

        if (!flag && checkArea)
            msg += "\n-------------------------------------------\n";

        if (checkArea)
            msg += areaMsg.toString();

        if (checkArea && isFixedPrice)
            msg += "\n-------------------------------------------\n";

        if (isFixedPrice)
            msg += sb1.toString();

        LOGGER.info("*****[拍品业务操作日志-在线拍]批量设置【在线拍】处理完成：" + msg + getLogInfo().toString() + new Date() + "）");

        return new JsonResult(true, msg);
    }

    /**
     * 
     * 更新车辆销售状态 销售状态：0、待售；1、 出售中；2、已出售
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月21日 下午2:28:45
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    private void updateVehicleSaleStatus(Integer vehicleId, Integer status) {
        try {
            if (status.intValue() == GlobalConstants.SALE_STATUS_WAIT.intValue()) {
                vehicleService.updateSaleStatus(vehicleId, SaleStatusEnum.SALE_STATUS_WAIT);
            } else if (status.intValue() == GlobalConstants.SALE_STATUS_ONGOING.intValue()) {
                vehicleService.updateSaleStatus(vehicleId, SaleStatusEnum.SALE_STATUS_ONGOING);
            } else if (status.intValue() == GlobalConstants.SALE_STATUS_DONE.intValue()) {
                vehicleService.updateSaleStatus(vehicleId, SaleStatusEnum.SALE_STATUS_DONE);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 拍品批量设置
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月24日 下午3:30:33
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/allUpdate", method = RequestMethod.POST)
    public String doBatchSave(AuctionVehicle auctionVehicle, Model model) {
        int size1 = 0;

        String[] auctionVehicleIds = null;
        Integer auctionVehicleId = null;
        AuctionVehicle av = null;
        String allSids = null;

        String cash = auctionVehicle.getCashAllSids();
        String seeCar = auctionVehicle.getSeeCarAllSids();
        if (StringUtils.isNotBlank(cash)) {
            allSids = cash;
            LOGGER.info("*******************进入拍品费用批量设置处理********************");
        } else if (StringUtils.isNotBlank(seeCar)) {
            allSids = seeCar;
            LOGGER.info("*******************进入看车批量设置处理********************");
        }
        if (StringUtils.isNotBlank(allSids)) {
            String[] sids = allSids.split("\\|\\|");// "sid,vehicleSid"
            int size = sids.length;
            if (null != sids && size > 0) {
                for (int i = 0; i < size; i++) {
                    auctionVehicleIds = sids[i].split(",");
                    size1 = auctionVehicleIds.length;
                    if (null != auctionVehicleIds && size1 > 0) {
                        // 拍品关联标识
                        if (size1 == 2) {
                            auctionVehicleId = Integer.valueOf(auctionVehicleIds[0]);
                        }
                        if (auctionVehicleId != null) {
                            try {
                                av = new AuctionVehicle();
                                BeanUtils.copyProperties(auctionVehicle, av);
                                av.setId(auctionVehicleId);
                                auctionVehicleService.updateByPrimaryKeySelective(av);
                            } catch (Exception e) {
                                LOGGER.error("allUpdate BeanUtils error auctionVehicleId={}", auctionVehicleId);
                            }

                        }
                    }
                }
            }
        }
        model.addAttribute(auctionVehicle);
        return "redirect:/auctionvehicle/index";
    }

    /**
     * 取消拍品流程处理
     * 
     * @return boolean
     * @author youpeng.zhang Date: 2015年8月24日 下午4:46:43
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ResponseBody
    public boolean doCancelAuction(@RequestParam(value = "allSids", required = true) String allSids) {
        LOGGER.info("*******************进入拍品【取消拍卖】流程********************");
        if (StringUtils.isNotBlank(allSids)) {
            String[] sids = allSids.split("\\|\\|");// "sid,vehicleSid"
            int size = sids.length;
            if (null != sids && size > 0) {
                String[] auctionVehicleIds = null;
                int size1 = 0;
                Integer auctionVehicleId = null;
                AuctionVehicle av = null;
                AuctionVehicleLog avLog = null;
                for (int i = 0; i < size; i++) {
                    auctionVehicleIds = sids[i].split(",");
                    size1 = auctionVehicleIds.length;
                    if (null != auctionVehicleIds && size1 > 0) {
                        // 拍品关联标识
                        if (size1 == 2) {
                            auctionVehicleId = Integer.valueOf(auctionVehicleIds[0]);
                        }
                        if (auctionVehicleId != null) {
                            av = auctionVehicleService.selectByPrimaryKey(auctionVehicleId);
                            // String oldAuctionSid = av.getAuctionSid();
                            Integer vehicleId = av.getVehicleId();

                            avLog = new AuctionVehicleLog();
                            try {
                                BeanUtils.copyProperties(av, avLog);
                            } catch (Exception e) {
                                LOGGER.error("BeanUtils avLog error vehicleId = {}", vehicleId);
                            }
                            // 初始化日志记录
                            initAuctionVehicleLog(avLog, auctionVehicleId, this.getUser().getUsername(), "0");
                            // auctionVehicleLogService.insertSelective(avLog);//
                            // 记录日志
                            LOGGER.info("*****[拍品业务操作日志-取消拍卖]【数据彻底删除，可到AuctionVehicleLog表查看】拍品Id：" + avLog.getAvId()
                                    + "，拍品状态：" + formatStatusAuction(avLog.getStatus()));
                            auctionVehicleService.deleteByPrimaryKey(auctionVehicleId);// 删除数据

                            // 处理是否最新拍品
                            Map<String, Object> params = new HashMap<String, Object>();
                            params.put("vehicleId", vehicleId);
                            params.put("status", GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL);// 流拍
                            params.put("latest", "0");

                            Integer failAvId = auctionVehicleService.selectAvId(params);

                            if (failAvId != null) {
                                AuctionVehicle record = new AuctionVehicle();
                                record.setId(failAvId);
                                record.setLatest(Boolean.TRUE);
                                auctionVehicleService.updateByPrimaryKeySelective(record);
                                LOGGER.info("*****[拍品业务操作日志-取消拍卖]设置已取消拍品的历史【流拍】拍品为最新拍品。");
                            }

                            updateVehicleSaleStatus(vehicleId, 0);// 待售
                            LOGGER.info("*****[拍品业务操作日志-取消拍卖]设置车辆（#SID：" + vehicleId + "）销售状态为0【待售】。");
                            // auctionVehicleService.updateAuctionVehicleOrders(null,oldAuctionSid);
                        }
                    }
                }
                // 更新拍卖会拍品数量
                auctionService.updateAuctionVehicleQuantity();
                return true;
            }
        }
        return false;
    }

    /**
     * 撤拍
     * 
     * @return boolean
     * @author youpeng.zhang Date: 2015年8月25日 下午5:34:34
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/cancel1", method = RequestMethod.POST)
    @ResponseBody
    public boolean doCancelAuction1(@RequestParam(value = "allIds", required = true) String allIds) {
        LOGGER.info("*******************进入拍品【撤拍】流程********************");
        String userName = this.getUser().getUsername();

        if (StringUtils.isNotBlank(allIds)) {

            String[] ids = allIds.split("\\|\\|");// "sid,vehicleSid"
            int size = ids.length;
            if (null != ids && size > 0) {

                String[] auctionVehicleIds = null;
                Integer auctionVehicleId = null;
                AuctionVehicle av = null;
                AuctionVehicleLog avLog = null;
                boolean isAuction = false;
                int size1 = 0;

                for (int i = 0; i < size; i++) {
                    auctionVehicleIds = ids[i].split(",");
                    size1 = auctionVehicleIds.length;
                    if (ArrayUtils.isNotEmpty(auctionVehicleIds)) {
                        // 拍品关联标识
                        if (size1 == 2) {
                            auctionVehicleId = Integer.valueOf(auctionVehicleIds[0]);
                        }

                        if (auctionVehicleId != null) {
                            av = auctionVehicleService.selectByPrimaryKey(auctionVehicleId);
                            // String oldAuctionSid = av.getAuctionSid();
                            Integer vehicleId = av.getVehicleId();
                            Integer avId = av.getId();
                            Integer type = av.getAuctionType();

                            if (!isAuction && type == GlobalConstants.AUCTION_TYPE_SYNC) {
                                isAuction = true;
                            }

                            avLog = new AuctionVehicleLog();
                            try {
                                BeanUtils.copyProperties(av, avLog);
                            } catch (Exception e1) {
                                LOGGER.error(" BeanUtils av avId = {} ", avId);
                            }
                            // 初始化日志记录
                            initAuctionVehicleLog(avLog, auctionVehicleId, userName, "1");

                            try {
                                // auctionVehicleLogService.insertSelective(avLog);//
                                // 记录日志
                            } catch (Exception e) {
                                LOGGER.error("拍品撤拍日志插入异常[avID-->" + avId + "],[vehicleId--->" + vehicleId + "]."
                                        + e.getMessage());
                            }

                            // av1 = new AuctionVehicle();
                            // av1.setId(avId);
                            // av1.setStatus(7);// 撤拍
                            //
                            // try {
                            // auctionVehicleService.updateByPrimaryKeySelective(av1);
                            // } catch (Exception e) {
                            // LOGGER.error("拍品撤拍异常[avSID-->" + avId +
                            // "],[vehicleId--->" + vehicleId + "]."
                            // + e.getMessage());
                            // }
                            //
                            // try {
                            // updateVehicleSaleStatus(vehicleId, 0);// 待售
                            // } catch (Exception e) {
                            // LOGGER.error("拍品撤拍车辆状态更新异常[avID-->" + avId +
                            // "],[vehicleId--->" + vehicleId + "]."
                            // + e.getMessage());
                            // }

                            try {
                                auctionVehicleService.updateAuctionVehicleStatus(avId, vehicleId, av.getStatus(),
                                        GlobalConstants.AUCTION_VEHICLE_STATUS_CANCEL);
                            } catch (Exception e) {
                                LOGGER.error(e.getMessage(), e);
                            }

                        }
                    }
                }

                // 更新拍卖会拍品数量
                if (isAuction)
                    auctionService.updateAuctionVehicleQuantity();

                return true;
            }
        }
        return false;
    }

    /**
     * @Title: doShowMaxPrice
     * @Description: 显示拍品最高出价
     * @param id
     * @return String
     * @throws @author
     *             yanqing.luo
     * @version V3.0
     * @date 2014年7月30日 上午11:54:32
     */
    @RequestMapping(value = "/to-edit-price", method = RequestMethod.GET)
    @ResponseBody
    public String doShowMaxPrice(@RequestParam(value = "sid", required = true) Integer id) {
        LOGGER.info("*******************进入拍品在线拍【保留价更新】页面********************");

        BigDecimal price = bidService.queryBidMaxPrice(id);

        if (null != price && price.compareTo(BigDecimal.ZERO) == 1) {
            price = price.divide(BigDecimal.valueOf(10000f), 2, BigDecimal.ROUND_HALF_UP);// 万元
            return price.toString();
        }
        return "0.00";
    }

    /**
     * @Title: doUpdatePrice
     * @Description: 编辑在线拍保留价
     * @param id
     * @param newPrice
     * @return boolean
     * @throws @author
     *             yanqing.luo
     * @version V2.0
     * @date 2014年7月30日 上午11:54:56
     */
    @RequestMapping(value = "/edit-price", method = RequestMethod.POST)
    @ResponseBody
    public boolean doUpdatePrice(@RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "newPrice", required = true) BigDecimal newPrice) {
        LOGGER.info("*******************进入拍品在线拍【保留价更新】流程********************");
        AuctionVehicle record = new AuctionVehicle();
        record.setId(id);
        BigDecimal maxPrice = new BigDecimal("0.00");
        if (newPrice != null && newPrice.compareTo(BigDecimal.ZERO) == 1) {
            maxPrice = newPrice.multiply(BigDecimal.valueOf(10000l));
        }
        record.setReservePrice(maxPrice);
        int count = auctionVehicleService.updateByPrimaryKeySelective(record);
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(id);
        if (count > 0) {
            // 记录在线拍编辑日志
            OnlineAuctionLog onlinelog = new OnlineAuctionLog();
            BeanUtils.copyProperties(auctionVehicle, onlinelog);
            onlinelog.setId(null);
            onlinelog.setStartPrice(null);// 没有修改起拍价
            onlinelog.setUserId(getUser().getId());
            onlinelog.setVehilceList("编辑保留价：" + auctionVehicle.getVehicleId());
            if (!onlineAuctionLogService.insertOnlineLog(onlinelog)) {
                LOGGER.warn("记录在线拍上拍日志操作失败！");
            }
            return true;
        }
        return false;
    }

    /**
     * @Title: doUpdatePrice
     * @Description: 编辑在线拍起拍价
     * @param id
     * @param newPrice
     * @return boolean
     * @throws @author
     *             yanqing.luo
     * @version V2.0
     * @date 2014年7月30日 上午11:54:56
     */
    @RequestMapping(value = "/edit-start-price", method = RequestMethod.POST)
    @ResponseBody
    public boolean doUpdateStartPrice(@RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "newPrice", required = true) BigDecimal newPrice) {
        LOGGER.info("*******************进入拍品在线拍【起拍价更新】流程********************");
        AuctionVehicle record = new AuctionVehicle();
        record.setId(id);
        BigDecimal maxPrice = new BigDecimal("0.00");
        if (newPrice != null && newPrice.compareTo(BigDecimal.ZERO) == 1) {
            maxPrice = newPrice.multiply(BigDecimal.valueOf(10000l));
        }
        record.setStartPrice(maxPrice);
        int count = auctionVehicleService.updateByPrimaryKeySelective(record);
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(id);
        if (count > 0) {
            // 记录在线拍编辑日志
            OnlineAuctionLog onlinelog = new OnlineAuctionLog();
            BeanUtils.copyProperties(auctionVehicle, onlinelog);
            onlinelog.setId(null);
            onlinelog.setReservePrice(null);// 没有修改保留价
            onlinelog.setUserId(getUser().getId());
            onlinelog.setVehilceList("编辑起拍价：" + auctionVehicle.getVehicleId());
            if (!onlineAuctionLogService.insertOnlineLog(onlinelog)) {
                LOGGER.warn("记录在线拍上拍日志操作失败！");
            }
            return true;
        }
        return false;
    }

    /**
     * @Title: initAuctionVehicleLog
     * @Description: 初始化拍品日志操作
     * @param avLog
     * @param userName
     * @param type
     * @return void
     * @throws @author
     *             yanqing.luo
     * @version V2.0
     * @date 2014年7月21日 下午3:28:08
     */
    private void initAuctionVehicleLog(AuctionVehicleLog avLog, Integer auctionVehicleId, String userName,
            String type) {
        avLog.setOperationTime(new Date());
        avLog.setOperationType(type);
        avLog.setOperator(userName);
        avLog.setAvId(auctionVehicleId);
    }

    /**
     * 更新同步拍拍品数据与拍卖会同步
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月21日 下午1:26:18
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    private void updateAuctionVehicleFromAuction(AuctionVehicle auctionVehicle, Auction auction) {
        if (null == auction)
            throw new NullPointerException("拍卖会不存在！！！！");

        Date startTimestamp = auction.getStartTimestamp();
        Date endTimestamp = auction.getEndTimestamp();
        // 更新拍品时间
        auctionVehicle.setPlanStartTime(startTimestamp);
        auctionVehicle.setPlanEndTime(endTimestamp);
        // 拍卖方式
        auctionVehicle.setAuctionModel(auction.getAuctionModel());
        // 竞拍区域
        auctionVehicle.setProvince(auction.getProvince());
        auctionVehicle.setCity(auction.getCity());
        // 同步拍
        auctionVehicle.setAuctionType(0);
    }

    /**
     * @Title: initAuctionVehicle
     * @Description: 拍品信息初始化并保存
     * @param av
     *            拍品
     * @return void
     * @throws @author
     *             yanqing.luo
     * @version V6.0
     * @date 2014年7月13日 下午2:53:16
     */
    private void initAuctionVehicle(AuctionVehicle av) {
        // 拍卖类型0-同步拍、1-在线拍
        av.setId(null);
        Integer type = av.getAuctionType();
        if (type == null)
            throw new IllegalArgumentException("拍卖类型不存在，数据异常！！！！");

        String avNo = null;
        switch (type) {
            case 0:
                avNo = BusinessIdRuleEnum.AV_SYN.getCode();
                av.setAvType(0);
                break;
            case 1:
                avNo = BusinessIdRuleEnum.AV_ONLINE.getCode();
                break;
            case 2:// 即时拍
                avNo = BusinessIdRuleEnum.AV_ONCEBID.getCode();
                break;
            default:
                throw new IllegalArgumentException("拍卖类型非法！！！！！");
        }

        av.setAvNo(businessRuleService.getBusinessIdByType(avNo));// 拍品编号
        av.setLatest(Boolean.TRUE);// 最新拍卖
        av.setDone(GlobalConstants.AUCTION_DONE_FALSE);// 未成交
        av.setEnable(true);// 未删除
        av.setCreatedTimestamp(new Date());

        auctionVehicleService.insertSelective(av);
    }

    /**
     * @Title: doSave
     * @Description: 编辑保存拍品信息
     * @param auctionVehicle
     * @param model
     * @return String
     * @throws @author
     *             yanqing.luo
     * @version V4.0
     * @date 2014年7月10日 下午5:28:09
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Transactional(rollbackFor = Throwable.class)
    public String doSave(AuctionVehicle auctionVehicle, Model model) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
        LOGGER.info("*******************进入拍品编辑保存流程********************");

        // 拍卖类型：0-同步拍、1-在线拍、2-即时拍
        Integer auctionType = auctionVehicle.getAuctionType();
        if (!GlobalConstants.AUCTION_TYPE_SYNC.equals(auctionType)
                && !GlobalConstants.AUCTION_TYPE_ONLINE.equals(auctionType)
                && !GlobalConstants.AUCTION_TYPE_ONCEBID.equals(auctionType)) {
            auctionVehicle.setMsgError("编辑失败！拍品类型非法！！！");
            LOGGER.info(auctionVehicle.getMsgError() + getLogInfo().toString() + new Date() + "）");
            model.addAttribute(auctionVehicle);
            return "auction/auction-vehicle-edit";
        }

        Integer vehicleId = auctionVehicle.getVehicleId();
        if (vehicleId == null) {
            auctionVehicle.setMsgError("编辑失败！车辆标识无效！！！");
            LOGGER.info(auctionVehicle.getMsgError() + getLogInfo().toString() + new Date() + "）");
            model.addAttribute(auctionVehicle);
            return "auction/auction-vehicle-edit";
        }

        VehicleInfo vehicle = vehicleService.selectVehicleInfoById(vehicleId);
        if (null == vehicle) {
            auctionVehicle.setMsgError("编辑失败！车辆不存在！");
            LOGGER.info(auctionVehicle.getMsgError() + getLogInfo().toString() + new Date() + "）");
            model.addAttribute(auctionVehicle);
            return "auction/auction-vehicle-edit";
        }

        boolean isAuction = isAuction(vehicle.getRequirementType());
        if (!isAuction) {
            auctionVehicle.setMsgError("编辑失败！该拍品客户需求为【非拍卖】，如需编辑请修改车辆信息中的客户需求！");
            LOGGER.info(auctionVehicle.getMsgError() + getLogInfo().toString() + new Date() + "）");
            model.addAttribute(auctionVehicle);
            return "auction/auction-vehicle-edit";
        }

        boolean checkArea = checkArea(vehicle.getCurrentProvince(), vehicle.getCurrentCity());
        if (!checkArea) {
            auctionVehicle.setMsgError("编辑失败！该拍品【车辆所在区域】非法，如需编辑请修改车辆信息！");
            LOGGER.info(auctionVehicle.getMsgError() + getLogInfo().toString() + new Date() + "）");
            model.addAttribute(auctionVehicle);
            return "auction/auction-vehicle-edit";
        }

        // 网上展厅
        FixedPriceExample fpex = new FixedPriceExample();
        Criteria fpCriteria = fpex.createCriteria();
        List<FixedPrice> fps = null;

        fpCriteria.andVehicleIdEqualTo(vehicleId);
        fpCriteria.andStatusNotEqualTo(1);// 已下架
        fpCriteria.andLatestEqualTo(Boolean.TRUE);
        fpCriteria.andEnabledEqualTo(Boolean.TRUE);
        fps = fixedPriceService.selectByExample(fpex);

        if (!CollectionUtils.isEmpty(fps)) {
            auctionVehicle.setMsgError("编辑失败！该拍品已在“网上展厅”进行寄售。如需编辑请联系相关业务人员进行下架操作！");
            LOGGER.info(auctionVehicle.getMsgError() + getLogInfo().toString() + new Date() + "）");
            model.addAttribute(auctionVehicle);
            return "auction/auction-vehicle-edit";
        }

        String msgSync = "";
        String msgOnline = "";
        Integer auctionId = auctionVehicle.getAuctionId();
        Integer auctionVehicleId = auctionVehicle.getId();
        Integer plus = auctionVehicle.getPlusRange();// 加价幅度处理
        if (plus == null || plus.compareTo(0) == 0) {
            if (auctionType == 1) {// 2016-1-13 14:35:38 在线拍默认加价幅度修改为500
                auctionVehicle.setPlusRange(ONLINE_DEFAULT_PRICE_MARKUP_RANGE);
            } else {
                auctionVehicle.setPlusRange(200);
            }

        }

        if (auctionVehicleId == null) {

            if (auctionType.equals(GlobalConstants.AUCTION_TYPE_SYNC)) {// 同步拍

                msgSync += "设置为【同步拍】";
                Auction auction = auctionService.selectByPrimaryKey(auctionId);
                updateAuctionVehicleFromAuction(auctionVehicle, auction);
                auctionVehicle.setStatus(GlobalConstants.WAITING_FOR_THE_AUCTION);// 待拍卖
                msgSync += "、【拍品状态】为待拍卖";

            } else if (auctionType.equals(GlobalConstants.AUCTION_TYPE_ONLINE)) {
                // 在线拍
                auctionVehicle.setAuctionId(null);
                auctionVehicle.setStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);
                // 已上架
                msgSync += "设置为【在线拍】、【拍品状态】为已上架";
            }
            initAuctionVehicle(auctionVehicle);
            updateVehicleSaleStatus(vehicleId, 1);// 销售中
            // eidt by zxf 取消在线拍上拍添加定价日志
            // // 记录定价日志
            // VehiclePriceLog vplog = new VehiclePriceLog();
            // vplog.setCreatedTimestamp(new Date());
            // vplog.setStartPrice(auctionVehicle.getStartPrice());
            // vplog.setReservePrice(auctionVehicle.getReservePrice());
            // vplog.setVehicleId(auctionVehicle.getVehicleId());
            // // 一期默认为拍卖
            // vplog.setRequirementType(0);
            // vplog.setCreateUser(getUser().getId());
            // vehiclePriceLogService.insert(vplog);

            String msg = StringUtils.isNotBlank(msgSync) ? msgSync : msgOnline;
            LOGGER.info("[********拍品编辑业务操作日志]将待售车辆（#车辆编号" + vehicle.getCode() + "，#销售状态"
                    + formatStatusSale(vehicle.getSaleStatus()) + "）" + msg + "，并设置车辆【销售状态】为1【销售中】"
                    + getLogInfo().toString() + new Date() + "）");
            // 编辑在线拍时记录日志 add by zxf at 2015年12月29日10:42:46
            if (auctionType.equals(GlobalConstants.AUCTION_TYPE_ONLINE)) {
                OnlineAuctionLog onlineLog = new OnlineAuctionLog();
                BeanUtils.copyProperties(auctionVehicle, onlineLog);
                onlineLog.setId(null);
                onlineLog.setUserId(getUser().getId());
                onlineLog.setVehilceList("编辑：" + vehicleId);
                if (!onlineAuctionLogService.insertOnlineLog(onlineLog)) {
                    LOGGER.warn("记录在线拍上拍日志操作失败！");
                }
            }
        } else {

            if (auctionVehicle.getClientCommissionRate() == null)
                auctionVehicle.setClientCommissionRate(BigDecimal.ZERO);

            if (auctionVehicle.getClientFixedCommission() == null)
                auctionVehicle.setClientFixedCommission(BigDecimal.ZERO);

            if (auctionVehicle.getBuyerCommissionRate() == null)
                auctionVehicle.setBuyerCommissionRate(BigDecimal.ZERO);

            if (auctionVehicle.getBuyerFixedCommission() == null)
                auctionVehicle.setBuyerFixedCommission(BigDecimal.ZERO);

            if (auctionVehicle.getAgentPrice() == null)
                auctionVehicle.setAgentPrice(0);

            Auction auction = auctionService.selectByPrimaryKey(auctionId);

            String msgAuctionType = null;
            String msgSyncActionStatus = "不变";
            String msgVSaleStatus = null;
            if (null != auction) {

                msgAuctionType = "同步拍";
                if (auction.getStatus().equals(GlobalConstants.AUCTION_STATUS_CREATE)) {
                    msgAuctionType += "拍卖会状态为【未发布】";
                    auctionVehicle.setStatus(GlobalConstants.WAITING_FOR_THE_AUCTION);
                    msgSyncActionStatus = "为0【待拍卖】";
                }
            } else {
                msgAuctionType = "在线拍";
            }

            AuctionVehicle tmpAv = auctionVehicleService.selectByPrimaryKey(auctionVehicleId);
            if (null == tmpAv) {
                tmpAv = new AuctionVehicle();
                LOGGER.info("[********拍品编辑业务操作日志]当前拍品数据为空，实例化完成！");
            }

            Integer auctionType1 = tmpAv.getAuctionType();
            String msgAuction = null;

            if (!auctionType1.equals(auctionType)) {
                if (auctionType.equals(GlobalConstants.AUCTION_TYPE_SYNC)
                        && auctionType1.equals(GlobalConstants.AUCTION_TYPE_ONLINE)) {
                    auctionVehicle
                            .setAvNo(businessRuleService.getBusinessIdByType(BusinessIdRuleEnum.AV_SYN.getCode()));
                    msgAuction = "【在线拍】更新为【同步拍】";
                } else if (auctionType1.equals(GlobalConstants.AUCTION_TYPE_SYNC)
                        && auctionType.equals(GlobalConstants.AUCTION_TYPE_ONLINE)) {
                    msgAuction = "【同步拍】更新为【在线拍】";
                    auctionVehicle
                            .setAvNo(businessRuleService.getBusinessIdByType(BusinessIdRuleEnum.AV_ONLINE.getCode()));
                }
            }

            try {
                auctionVehicleService.updateByPrimaryKeySelective(auctionVehicle);
                updateVehicleSaleStatus(vehicleId, 1);// 销售中
                // eidt by zxf 取消在线拍上拍添加定价日志
                // 记录定价日志
                // VehiclePriceLog vplog = new VehiclePriceLog();
                // vplog.setCreatedTimestamp(new Date());
                // vplog.setStartPrice(auctionVehicle.getStartPrice());
                // vplog.setReservePrice(auctionVehicle.getReservePrice());
                // vplog.setVehicleId(auctionVehicle.getVehicleId());
                // // 一期默认为拍卖
                // vplog.setRequirementType(0);
                // vplog.setCreateUser(getUser().getId());
                // vehiclePriceLogService.insert(vplog);
                msgVSaleStatus = "为1【销售中】";
            } catch (Exception e) {
                String error = "**********拍品编辑失败！数据更新异常：" + e.getMessage();
                LOGGER.error(error);
                throw new RuntimeException(error);
            }

            LOGGER.info("[********拍品编辑业务操作日志]更新【" + msgAuctionType + "】拍品（#车辆编号" + vehicle.getCode() + "，#销售状态"
                    + formatStatusSale(vehicle.getSaleStatus()) + "）、（#拍品编号" + tmpAv.getAvNo() + "，#拍品状态"
                    + formatStatusAuction(tmpAv.getStatus()) + "），设置车辆【销售状态】" + msgVSaleStatus + "、拍品状态"
                    + msgSyncActionStatus + "，" + (msgAuction == null ? "" : msgAuction) + getLogInfo().toString()
                    + new Date() + "）");
            // 编辑在线拍时记录日志 add by zxf at 2015年12月29日10:42:46
            if (auctionType.equals(GlobalConstants.AUCTION_TYPE_ONLINE)) {
                OnlineAuctionLog onlineLog = new OnlineAuctionLog();
                BeanUtils.copyProperties(auctionVehicle, onlineLog);
                onlineLog.setId(null);
                onlineLog.setUserId(getUser().getId());
                onlineLog.setVehilceList("编辑：" + vehicleId);
                if (!onlineAuctionLogService.insertOnlineLog(onlineLog)) {
                    LOGGER.warn("记录在线拍上拍日志操作失败！");
                }
            }

        }
        model.addAttribute(auctionVehicle);
        return "redirect:/auctionvehicle/index";
    }

    /**
     * 拍品顺序设置列表
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月21日 下午5:01:23
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/itemordersave", method = RequestMethod.POST)
    public String itemOrderSave(@Validated Integer[] id, Integer[] auctionVehicleOrder, Model model) {
        // 更新拍卖会车辆序号
        auctionVehicleService.updateAuctionVehicleOrder(id, auctionVehicleOrder);
        return "redirect:/auction/index";
    }

    //
    // /**
    // * 拍品生成订单列表【只包含在线拍且是已拍完的数据】
    // *
    // * @param pagination
    // * @param auctionVehicle
    // * @param currentMenuSid
    // * @param model
    // * @return
    // */
    // @RequestMapping(value = "/formatOrder")
    // public String findAuctionList(Pagination pagination, AuctionVehicle
    // auctionVehicle, String currentMenuSid,
    // Model model) {
    // // 加载菜单
    // loadMenus(currentMenuSid, model);
    //
    // auctionVehicle.setPagination(pagination);
    // auctionVehicle.setAuctionType("1");
    // auctionVehicle.setStatus("2");
    // List<AuctionVehicle> avList =
    // auctionVehicleService.findAuctionVehicle2(auctionVehicle);
    //
    // pagination.setCount(avList.size());// 设置记录的所有数目
    // pagination.setEnd(pagination.getLength() * pagination.getCurrent());//
    // 设计记录的最后显示
    // // 设置需要本页显示的数据
    // pagination.setDataList(avList.subList(pagination.getBegin(),
    // pagination.getEnd() > pagination.getCount() ? pagination.getCount() :
    // pagination.getEnd()));
    // model.addAttribute("pagination", pagination);
    //
    // return "/auction/auctionVehicleformatOrder-index";
    // }
    //
    // /**
    // * 根据拍品单号生成订单
    // *
    // * @param avId
    // * @param model
    // * @return
    // */
    // @RequestMapping(value = "/formatOrder/createysyhl9t0123456789/{avId}",
    // method = RequestMethod.POST)
    // @ResponseBody
    // public Object formatOrder(@PathVariable String avId, Model model) {
    // auctionVehicleService.createOrder(avId);
    // return new JsonResult(true, "生成成功！");
    // }
    //
    /**
     * 批量设置价格
     * 
     * @param auctionVehicle
     * @param startPrice
     * @param plusRange
     * @param currentMenuSid
     * @param model
     * @return
     * 
     * @author haoju.li
     */
    @RequestMapping(value = "/volumeSetPrice")
    public String volumeSetPrice(AuctionVehicle auctionVehicle, String startPrice, String plusRange,
            String currentMenuSid, Model model) {

        Map<String, Object> avMap = new HashMap<String, Object>();
        avMap.put("auctionId", auctionVehicle.getAuctionId());
        avMap.put("plusRange", auctionVehicle.getPlusRange());
        avMap.put("startPrice", auctionVehicle.getStartPrice());
        auctionVehicleService.volumeSetPrice(avMap);
        return "redirect:/auction/index";
    }

    /**
     * 下拉根据品牌找车系
     * 
     * @param brand
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * 
     * @author youpeng.zhang
     */
    @RequestMapping(value = "/selectSeries")
    @ResponseBody
    public List<DictBrandseries> selectSeries(String brand) {
        List<DictBrandseries> seriesList = new ArrayList<>();
        List<DictBrandseries> manufacturerList = brandseriesService.selectDictBrandseries(brand, null, null);
        // 获取车系
        if (null != manufacturerList && manufacturerList.size() > 0) {
            for (DictBrandseries manufacturer : manufacturerList) {
                seriesList.addAll(brandseriesService.selectDictBrandseries(brand, manufacturer.getName(), null));
            }
        }
        return seriesList;
    }

    /**
     * 新增临时车
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * 
     * @author youpeng.zhang
     */
    @RequestMapping(value = "/saveTempVehicle")
    @ResponseBody
    public JsonResult saveTempVehicle(VehicleInfo vehicleInfo, String operation) {
        JsonResult jsonResult = null;
        if ("add".equals(operation)) {
            if (vehicleInfo.getDisplayMileage() != null) {
                vehicleInfo.setDisplayMileage(vehicleInfo.getDisplayMileage());
            }

            if (!StringUtils.isEmpty(vehicleInfo.getRegisterYear())
                    && !StringUtils.isEmpty(vehicleInfo.getRegisterMonth())) {
                if (vehicleInfo.getRegisterMonth().trim().length() == 1) {
                    vehicleInfo.setRegisterMonth("0" + vehicleInfo.getRegisterMonth());
                }
                vehicleInfo.setRegisterLicenseYears(vehicleInfo.getRegisterYear() + vehicleInfo.getRegisterMonth());
            }
            vehicleInfo.setVinCode("tempvin");
            vehicleInfo.setSource(VehicleInfoSourceEnum.VEHICLE_SOURCE_AV.getKey()); // 临时拍品
            vehicleInfo.setAuditedStatus((short) 1);
            vehicleInfo.setAuditedStatus((short) 1);
            try {
                vehicleInfo = usedvehicleDealerService.vehicleSave(vehicleInfo);
                jsonResult = new JsonResult(true, "保存成功!", vehicleInfo.getCode());
            } catch (IOException e) {
                jsonResult = new JsonResult(true, "保存失败!", vehicleInfo.getCode());
                e.printStackTrace();
            }
        } else {
            VehicleInfo vehicle = new VehicleInfo();
            vehicle.setBrand(vehicleInfo.getBrand());
            vehicle.setBrandSeries(vehicleInfo.getBrandSeries());
            vehicle.setSelledName(vehicleInfo.getSelledName());
            vehicle.setLicenseCode(vehicleInfo.getLicenseCode());
            vehicle.setCode(vehicleInfo.getCode());
            vehicleInfo.setAuditedStatus((short) 1);
            if (!StringUtils.isEmpty(vehicleInfo.getRegisterYear())
                    && !StringUtils.isEmpty(vehicleInfo.getRegisterMonth())) {
                if (vehicleInfo.getRegisterMonth().trim().length() == 1) {
                    vehicleInfo.setRegisterMonth("0" + vehicleInfo.getRegisterMonth());
                }
                vehicle.setRegisterLicenseYears(vehicleInfo.getRegisterYear() + vehicleInfo.getRegisterMonth());
            }
            vehicle.setDisplayMileage(vehicleInfo.getDisplayMileage());
            vehicle.setStartBidPrice(vehicleInfo.getStartBidPrice());
            vehicle.setReservePrice(vehicleInfo.getReservePrice());
            vehicle.setVinCode("tempvin");
            vehicle.setSource("av"); // 临时拍品
            try {
                usedvehicleDealerService.vehicleSave(vehicle);
                jsonResult = new JsonResult(true, "修改成功!", vehicleInfo.getCode());
            } catch (IOException e) {
                jsonResult = new JsonResult(true, "修改失败!", vehicleInfo.getCode());
                LOGGER.error(e.getMessage(), e);
            }
        }

        return jsonResult;
    }

    /**
     * 替换临时拍品
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * 
     * @author youpeng.zhang
     */
    @RequestMapping(value = "/subtitVehicleInfo")
    @ResponseBody
    public JsonResult subtitVehicleInfo(String vehicleCode) throws Exception {
        JsonResult jsonResult = null;

        VehicleInfo tempvehicle = usedVehicleService.selectVehicleByCode(vehicleCode);
        if (null == tempvehicle) {
            return new JsonResult(false, "没有查到编号为" + vehicleCode + "的车辆！");
        }
        // 拍品的车
        jsonResult = new JsonResult(true, "获取正式车信息", tempvehicle);
        return jsonResult;
    }

    /**
     * 替换临时拍品
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * 
     * @author youpeng.zhang
     */
    @RequestMapping(value = "/substituteTempVehicle")
    @ResponseBody
    public JsonResult substituteTempVehicle(Integer auctionVehicleId, Integer tempVehicleId, String vehicleCode)
            throws Exception {
        JsonResult jsonResult = null;
        Boolean result = auctionVehicleService.updateTempVehicleInfo(auctionVehicleId, tempVehicleId, vehicleCode);

        jsonResult = new JsonResult(true, "保存成功!", result);
        return jsonResult;
    }

    /**
     * 查询二手车
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     *
     * @author dongling.qu
     */
    @RequestMapping(value = "/selectVehicleByPrimaryKey")
    @ResponseBody
    public Vehicle selectVehicleByPrimaryKey(Integer id) {
        Vehicle v = auctVehicleService.selectByPrimaryKey(id);
        try {
            String registerLicenseYears = v.getRegisterLicenseYears();
            if (registerLicenseYears != null) {
                v.setRegisterYear(registerLicenseYears.substring(0, 4));
                v.setRegisterMonth(registerLicenseYears.substring(4));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return v;
    }

    /**
     * 临时拍品是否已经加入拍卖会
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     *
     * @author youpeng.zhang
     */
    @RequestMapping(value = "/isTempAuctionVehicle")
    @ResponseBody
    public JsonResult isTempAuctionVehicle(Integer tempVehicleId) {
        List<AuctionVehicle> av = auctionVehicleService.selectTempVehicleAuctionVehicle(tempVehicleId);
        if (av == null || av.size() == 0) {// 说明没有加入拍卖会
            return new JsonResult(true, "保存成功!", true);
        }
        return new JsonResult(true, "保存成功!", false);
    }

    /**
     * 更改销售需求，拍卖转展厅
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     *
     * @author youpeng.zhang
     */
    @RequestMapping(value = "/changeSaleRequest")
    @ResponseBody
    public JsonResult changeSaleRequest(String allSids) {
        String[] sids = allSids.split("\\|\\|");
        if (sids != null && sids.length > 0) {
            for (int i = 0; i < sids.length; i++) {
                String vehicleSid = sids[i].split(",")[1];
                if (!auctionVehicleService.isVehicleToFixedprice(Integer.valueOf(vehicleSid))) {
                    return new JsonResult(true, "保存失败!", false);
                }
            }

            for (int i = 0; i < sids.length; i++) {
                String vehicleSid = sids[i].split(",")[1];
                // usedvehicleOperatorService.updateRequirementType(Integer.valueOf(vehicleSid),
                // RequirementTypeEnum.ONLINE_CONSIGNMENT);
                vehicleService.updateRequirementType(Integer.valueOf(vehicleSid),
                        RequirementTypeEnum.ONLINE_CONSIGNMENT);
            }
        }
        return new JsonResult(true, "保存成功!", true);

    }

    /**
     * 直接发布展厅
     *
     * @param allSids
     * @return
     * @since [起始版本]
     */
    @RequestMapping(value = "/postedOnAPrice")
    @ResponseBody
    public JsonResult postedOnAPrice(String allSids) {
        User loginUser = getUser();
        JsonResult rs = null;
        Date currentDate = new Date();
        Map<String, Object> rsMap = new HashMap<String, Object>();
        List<String> msgList = new ArrayList<String>();
        try {
            AuctionVehicleExample example = new AuctionVehicleExample();
            AuctionVehicleExample.Criteria criteria = example.createCriteria();
            List<String> sids = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(allSids);
            List<Integer> ids = new ArrayList<Integer>();
            for (String sid : sids) {
                ids.add(Integer.valueOf(sid));
            }
            criteria.andIdIn(ids);
            List<AuctionVehicle> list = auctionVehicleService.selectByExample(example);
            Vehicle vehicle;
            // VehicleInfo vehicleInfo;
            FixedPrice fp;
            FixedPrice fp_;
            BigDecimal newVehicleSuggestionPrice;
            BigDecimal reservePrice;
            String province;
            String city;
            int successCount = 0;
            int failedCount = 0;

            for (AuctionVehicle av : list) {
                reservePrice = av.getReservePrice();
                province = av.getProvince();
                city = av.getCity();

                // 取得车辆信息
                vehicle = auctVehicleService.selectByPrimaryKey(av.getVehicleId());
                if (!(vehicle.getSaleStatus() != null && new Integer(vehicle.getSaleStatus()).equals(0)
                        && av.getStatus().equals(4))) {
                    msgList.add(vehicle.getCode() + " " + vehicle.getBrand() + " " + vehicle.getVehicleModel() + " "
                            + vehicle.getSelledName() + "，<span style='color: red;'>车辆非流拍，不能发布到展厅！</span>");
                    failedCount++;
                    continue;
                }
                Integer vehicleId = av.getVehicleId();

                // 取得展售上架信息
                FixedPriceExample fpExample = new FixedPriceExample();
                fpExample.setOrderByClause("create_time desc");
                FixedPriceExample.Criteria fpCriteria = fpExample.createCriteria();
                fpCriteria.andVehicleIdEqualTo(vehicleId);
                fpCriteria.andLatestEqualTo(true);
                List<FixedPrice> fpList = fixedPriceService.selectByExample(fpExample);

                if (fpList.isEmpty()) {
                    newVehicleSuggestionPrice = vehicle.getNewVehicleSuggestionPrice();
                    reservePrice = (null == reservePrice || BigDecimal.ZERO.compareTo(reservePrice) == 0)
                            ? vehicle.getReservePrice() : reservePrice;
                    if (null == newVehicleSuggestionPrice
                            || BigDecimal.ZERO.compareTo(newVehicleSuggestionPrice) == 0) {
                        msgList.add(vehicle.getCode() + " " + vehicle.getBrand() + " " + vehicle.getVehicleModel() + " "
                                + vehicle.getSelledName() + "，<span style='color: red;'>新车指导价缺失，无法发布！</span>");
                        failedCount++;
                    } else if (null == reservePrice || BigDecimal.ZERO.compareTo(reservePrice) == 0) {
                        msgList.add(vehicle.getCode() + " " + vehicle.getBrand() + " " + vehicle.getVehicleModel() + " "
                                + vehicle.getSelledName() + "，<span style='color: red;'>保留价缺失，无法发布！</span>");
                        failedCount++;
                    } else {

                        // 购置税计算
                        BigDecimal taxBuy = null;
                        BigDecimal priceNewcar = newVehicleSuggestionPrice.multiply(BigDecimal.valueOf(10000));
                        List<AuctionDictionary> dics = auctDictionaryService.selectResource("setting_taxbuy");
                        if (CollectionUtils.isEmpty(dics) || null == dics.get(0).getValue()) {
                            taxBuy = BigDecimal.ZERO;
                        } else {
                            taxBuy = priceNewcar.divide(BigDecimal.valueOf(Double.parseDouble(dics.get(0).getValue())),
                                    2, BigDecimal.ROUND_HALF_UP);
                            taxBuy = taxBuy.divide(BigDecimal.valueOf(10000d), 2, BigDecimal.ROUND_HALF_UP)
                                    .multiply(BigDecimal.valueOf(10000l));
                        }

                        // 新增网上寄售上架信息
                        fp = new FixedPrice();
                        fp.setCode(businessRuleService.getBusinessIdByType(BusinessIdRuleEnum.AV_FIXED.getCode()));
                        fp.setVehicleId(vehicleId);
                        fp.setDeposit(BigDecimal.valueOf(3000));
                        fp.setPrice(reservePrice);
                        fp.setHasTaxBuy(true);
                        fp.setNewVehicleSuggestionPrice(newVehicleSuggestionPrice);
                        fp.setTaxBuy(taxBuy);
                        fp.setProvince(province);
                        fp.setCity(city);
                        fp.setWhereStore("汽车街");
                        fp.setAddressDetailStore("上海市闵行区虹莘路3998号");
                        fp.setServiceTime("8：30-17：00");
                        fp.setStatus(3);
                        fp.setHidden(false);
                        fp.setLatest(true);
                        fp.setSellTime(currentDate);
                        fp.setCreateTime(currentDate);
                        fp.setUpdateTime(currentDate);
                        fp.setEnabled(true);
                        fp.setUpdateUser(loginUser.getId());
                        fp.setCreateUser(loginUser.getId());
                        fp.setMemo(vehicle.getVehicleDesc());
                        fp.setPhone("400-821-8889");
                        fixedPriceService.insertSelective(fp);

                        // fixbug:更新销售需求、状态 by zjz
                        // usedvehicleOperatorService.updateRequirementType(vehicleId,
                        // RequirementTypeEnum.getByValue("网上寄售"));
                        vehicleService.updateRequirementType(vehicleId, RequirementTypeEnum.ONLINE_CONSIGNMENT);
                        vehicleService.updateSaleStatus(vehicleId, SaleStatusEnum.SALE_STATUS_ONGOING);

                        msgList.add(vehicle.getCode() + " " + vehicle.getBrand() + " " + vehicle.getVehicleModel() + " "
                                + vehicle.getSelledName() + "，发布成功！");
                        successCount++;
                    }
                } else {
                    fp = fpList.get(0);
                    if (1 == fp.getStatus().intValue()) {

                        // 修改原有效数据
                        fp.setLatest(false);
                        fp.setOffShelvesTime(currentDate);
                        fp.setOffShelvesRemark("自动发布");
                        fp.setUpdateTime(currentDate);
                        fp.setUpdateUser(loginUser.getId());
                        fixedPriceService.updateByPrimaryKeySelective(fp);

                        // 新增新上架信息
                        fp_ = new FixedPrice();
                        BeanUtils.copyProperties(fp, fp_);
                        fp_.setWhereStore("汽车街");
                        fp_.setAddressDetailStore("上海市闵行区虹莘路3998号");
                        fp_.setServiceTime("8：30-17：00");
                        fp_.setStatus(3);
                        fp_.setLatest(true);
                        fp_.setApplyShelvesTime(null);
                        fp_.setSellTime(currentDate);
                        fp_.setOffShelvesTime(null);
                        fp_.setOffShelvesRemark(null);
                        fp_.setCreateTime(currentDate);
                        fp_.setUpdateTime(currentDate);
                        fp_.setEnabled(true);
                        fp_.setUpdateUser(loginUser.getId());
                        fp_.setCreateUser(loginUser.getId());
                        fp_.setFavCount(null);
                        fp_.setClickCount(null);
                        fp_.setPhone("400-821-8889");
                        fp_.setId(null);
                        fixedPriceService.insertSelective(fp_);

                        // 更新销售需求
                        // vehicleInfo = new VehicleInfo();
                        // vehicleInfo.setRequirementType("网上寄售");
                        // vehicleInfo.setCode(vehicle.getCode());
                        // vehicleInfo.setSaleStatus(SaleStatusEnum.SALE_STATUS_ONGOING.getKey());
                        // usedvehicleDealerService.vehicleSave(vehicleInfo);
                        // fixbug:更新销售需求、状态 by zjz
                        // usedvehicleOperatorService.updateRequirementType(vehicleId,
                        // RequirementTypeEnum.getByValue("网上寄售"));
                        vehicleService.updateRequirementType(vehicleId, RequirementTypeEnum.ONLINE_CONSIGNMENT);
                        vehicleService.updateSaleStatus(vehicleId, SaleStatusEnum.SALE_STATUS_ONGOING);

                        msgList.add(vehicle.getCode() + " " + vehicle.getBrand() + " " + vehicle.getVehicleModel() + " "
                                + vehicle.getSelledName() + "，发布成功！");
                        successCount++;
                    } else {
                        msgList.add(vehicle.getCode() + " " + vehicle.getBrand() + " " + vehicle.getVehicleModel() + " "
                                + vehicle.getSelledName() + "，<span style='color: red;'>该车已发布，无需发布！</span>");
                        failedCount++;
                    }
                }
            }

            rsMap.put("successCount", successCount);
            rsMap.put("failedCount", failedCount);
            rsMap.put("msgList", msgList);
            rs = new JsonResult(true, rsMap);
            // } catch (IOException e) {
            // LOGGER.error("更新销售需求出现服务器错误");
            // rs = new JsonResult(false, "更新销售需求出现服务器错误，操作失败！");
        } catch (Exception e) {
            LOGGER.error("未知服务器错误，操作失败！");
            rs = new JsonResult(false, "未知服务器错误，操作失败！");
        }

        return rs;
    }

    /**
     * 功能描述: <br>
     * 〈即时拍：逻辑与在线拍基本一致〉
     * 
     * @author jingzhou.zhao
     * @datetime 2015年9月1日 下午3:21:18
     * @param auctionVehicle
     * @param currentMenuSid
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/onceBid", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doOnceBidSave(AuctionVehicle auctionVehicle) {
        LOGGER.info("*******************进入即时拍流程处理********************");
        String onceBidSids = auctionVehicle.getOnceBidSids();
        Integer createdBy = getUser().getId();
        if (createdBy == null)
            throw new NullPointerException("用户非法！！！！！");

        int size1 = 0;
        // 拍品批量处理
        String[] auctionVehicleIds = null;
        // 拍品标识
        Integer auctionVehicleId = null;
        // 更新车辆销售状态
        Integer vehicleId = null;
        // 组装拍品对象
        AuctionVehicle av = null;
        String msg = "保存失败！";
        boolean flag = true;// 客户需求判定
        StringBuilder sb = new StringBuilder("\n存在客户需求为非【拍卖】的车辆，未进行保存。\n请按条件查询后进行【撤拍】并修改客户需求！\n车辆编号为");
        boolean isFixedPrice = false;// 是否网上展品判定
        StringBuilder sb1 = new StringBuilder("\n部分车辆在“网上展厅”进行寄售且非【已下架】状态。\n如确定需要进行竞拍，请联系相关业务人员下架处理后再操作。\n车辆编号为");
        boolean checkArea = false;// 车辆所在区域判定
        StringBuilder areaMsg = new StringBuilder("\n部分车辆【所在区域】非法。\n如确定需要进行竞拍，请联系相关业务人员编辑车辆后再操作。\n车辆编号为");
        boolean checkStatus = false;// 车辆状态判定
        StringBuilder checkstatusMsg = new StringBuilder("\n部分车辆非【待售】状态。\n如确定需要进行竞拍，请联系相关业务人员撤拍处理后再操作。\n车辆编号为");

        if (StringUtils.isNotBlank(onceBidSids)) {
            String[] sids = onceBidSids.split("\\|\\|");// "sid,vehicleSid"
            int size = sids.length;
            int count = 0;
            boolean isAuction = true;
            boolean isArea = true;

            // 网上展厅
            FixedPriceExample fpex = new FixedPriceExample();
            Criteria fpCriteria = fpex.createCriteria();
            List<FixedPrice> fps = null;

            if (ArrayUtils.isNotEmpty(sids)) {
                // List<String> locations = getDictAreas();

                for (int i = 0; i < size; i++) {

                    auctionVehicleIds = sids[i].split(",");
                    size1 = auctionVehicleIds.length;

                    if (ArrayUtils.isNotEmpty(auctionVehicleIds)) {
                        if (size1 == 1)
                            auctionVehicleId = Integer.valueOf(auctionVehicleIds[0]);
                        if (size1 == 2) {
                            // 拍品关联标识
                            if (StringUtils.isNotBlank(auctionVehicleIds[0])) {
                                auctionVehicleId = Integer.valueOf(auctionVehicleIds[0]);
                            }
                            // 车辆标识
                            if (StringUtils.isNotBlank(auctionVehicleIds[1])) {
                                vehicleId = Integer.valueOf(auctionVehicleIds[1]);
                            }
                        }
                        if (vehicleId != null) {
                            count++;
                            VehicleInfo vehicle = vehicleService.selectVehicleInfoById(vehicleId);
                            if (null == vehicle)
                                throw new NullPointerException(vehicleId + "车辆不存在，数据异常！！！！！");
                            if (vehicle.getSaleStatus() != null && vehicle.getSaleStatus() != 0) {
                                // flag = false;
                                checkStatus = true;
                                checkstatusMsg.append(vehicle.getCode() + "、");
                                continue;
                            }
                            // zjz注释：是否拍卖车辆
                            isAuction = isAuction(vehicle.getRequirementType());
                            if (!isAuction) {
                                sb.append(vehicle.getCode() + "、");

                                if (flag)
                                    flag = false;

                                continue;
                            }
                            // zjz注释：校验车辆所在地
                            isArea = checkArea(vehicle.getCurrentProvince(), vehicle.getCurrentCity());
                            if (!isArea) {
                                areaMsg.append(vehicle.getCode() + "、");

                                if (!checkArea)
                                    checkArea = true;

                                continue;
                            }

                            // zjz注释：查询是否展厅车辆
                            fpex.clear();
                            fpCriteria = fpex.createCriteria();
                            fpCriteria.andVehicleIdEqualTo(vehicleId);
                            fpCriteria.andStatusNotEqualTo(1);// 已下架
                            fpCriteria.andLatestEqualTo(Boolean.TRUE);
                            fpCriteria.andEnabledEqualTo(Boolean.TRUE);
                            fps = fixedPriceService.selectByExample(fpex);

                            if (!CollectionUtils.isEmpty(fps)) {
                                sb1.append(vehicle.getCode() + "、");

                                if (!isFixedPrice)
                                    isFixedPrice = true;

                                continue;
                            }

                            av = new AuctionVehicle();
                            BeanUtils.copyProperties(auctionVehicle, av);
                            av.setAuctionId(null);
                            av.setAuctionType(GlobalConstants.AUCTION_TYPE_ONCEBID);// 即时拍

                            // String avType = av.getAvType();// 拍品类型（有底价，无底价）

                            // BigDecimal startPrice1 = av.getStartPrice();//
                            // 起拍价
                            // BigDecimal reservePrice1 =
                            // av.getReservePrice();// 保留价

                            // 未建立拍卖与拍品关系车辆处理
                            if (auctionVehicleId == null) {

                                av.setVehicleId(vehicleId);
                                // av.setAuctionVehicleOrder(i + 1);// 拍品默认顺序
                                av.setStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);// 已上架

                                // Short plus = auctionVehicle.getPlusRange();//
                                // 加价幅度处理
                                // if (null == plus ||
                                // plus.compareTo(Short.parseShort("0")) == 0) {
                                auctionVehicle.setPlusRange(0);
                                // }

                                // 从车辆中拉取竞拍区域
                                String province = vehicle.getCurrentProvince();
                                String city = vehicle.getCurrentCity();

                                if (StringUtils.isBlank(auctionVehicle.getProvince()))
                                    av.setProvince(province);

                                if (StringUtils.isBlank(auctionVehicle.getCity()))
                                    av.setCity(city);

                                // 起拍价、保留价
                                BigDecimal startPrice = vehicle.getStartBidPrice();
                                BigDecimal reservePrice = vehicle.getReservePrice();

                                if (null != startPrice)
                                    av.setStartPrice(startPrice);

                                if (null != reservePrice)
                                    av.setReservePrice(reservePrice);

                                // av.setPlusRange(0);// 加价幅度

                                // edit by zjz 2015年9月1日 15:44:25 即时拍无起拍价、保留价设置
                                // 增加取用户设置的在线拍起拍价、保留价（2014年10月28日PM 宫伟来要求添加）
                                // if (null == startPrice1)
                                // av.setStartPrice(startPrice);
                                //
                                // if (null == reservePrice1)
                                // av.setReservePrice(reservePrice);

                                // edit by zjz 2015年9月1日 15:44:25 即时拍无热门推荐设置
                                // edit by zjz 添加热门推荐
                                // if
                                // (BooleanUtils.isTrue(auctionVehicle.getRecommend()))
                                // {
                                // av.setRecommend(true);
                                // } else {
                                // av.setRecommend(false);
                                // }
                                // edit by zxf 添加是否活动拍品，添加活动拍品title
                                if (BooleanUtils.isTrue(auctionVehicle.getActivity())) {
                                    av.setActivity(true);
                                } else {
                                    av.setActivity(false);
                                }
                                if (StringUtils.isNotBlank(auctionVehicle.getActivityTitle())) {
                                    av.setActivityTitle(auctionVehicle.getActivityTitle());
                                }
                                // edit end;
                                av.setCreatedBy(createdBy);
                                initAuctionVehicle(av);

                                // 更新车辆销售状态为销售中
                                updateVehicleSaleStatus(vehicleId, 1);
                                LOGGER.info("******[拍品业务操作日志-在线拍]车辆（#车辆编号" + vehicle.getCode() + "，原【销售状态】为"
                                        + formatStatusSale(vehicle.getSaleStatus())
                                        + "，更新后【销售状态】为1【销售中】），初始化拍品状态为1【已上架】" + getLogInfo().toString() + new Date()
                                        + "）");

                            } else {// zjz注释：已建立拍品关系车辆处理

                                // vehicle = null;
                                AuctionVehicle tmpAv = auctionVehicleService.selectByPrimaryKey(auctionVehicleId);
                                Integer status = tmpAv.getStatus();
                                // String oldAuctionSid = tmpAv.getAuctionSid();
                                Integer auctionType = tmpAv.getAuctionType();

                                if (status == null)
                                    throw new NullPointerException("拍品状态非法！！！！！");

                                if (auctionType == null)
                                    throw new NullPointerException("拍品类型非法！！！！！");

                                // Short plusRange1 = av.getPlusRange();// 加价幅度
                                // Integer agentPrice1 = av.getAgentPrice();//
                                // 代理价

                                // 流拍、取消订单处理
                                if (isCreateAuction(status)) {
                                    // zjz注释：更新原拍品为 ”已参加过拍卖“
                                    tmpAv.setLatest(Boolean.FALSE);
                                    auctionVehicleService.updateByPrimaryKeySelective(tmpAv);

                                    tmpAv.setPlanStartTime(auctionVehicle.getPlanStartTime());
                                    tmpAv.setPlanEndTime(auctionVehicle.getPlanEndTime());

                                    // if (startPrice1 != null &&
                                    // startPrice1.compareTo(BigDecimal.ZERO) ==
                                    // 1)
                                    // tmpAv.setStartPrice(BigDecimal.ZERO);//
                                    // 起拍价
                                    //
                                    // if (reservePrice1 != null &&
                                    // reservePrice1.compareTo(BigDecimal.ZERO)
                                    // == 1)
                                    // tmpAv.setReservePrice(BigDecimal.ZERO);//
                                    // 保留价

                                    // 加价幅度，即时拍清空
                                    // if (plusRange1 != null &&
                                    // plusRange1.compareTo(Short.parseShort("200"))
                                    // != 0)
                                    // tmpAv.setPlusRange(0);// 加价幅度

                                    // if (agentPrice1 != null &&
                                    // agentPrice1.compareTo(0) == 1)
                                    // 此属性为“在线拍代理价”,转即时拍清空
                                    tmpAv.setAgentPrice(null);

                                    if (StringUtils.isNotBlank(auctionVehicle.getProvince()))
                                        tmpAv.setProvince(auctionVehicle.getProvince());

                                    if (StringUtils.isNotBlank(auctionVehicle.getCity()))
                                        tmpAv.setCity(auctionVehicle.getCity());

                                    // zjz注释：即时拍不区分 有底价、无底价？
                                    // if (StringUtils.isNotEmpty(avType)) {
                                    // tmpAv.setAvType(avType);
                                    // }

                                    // edit by zjz 添加热门推荐
                                    // if
                                    // (BooleanUtils.isTrue(auctionVehicle.getRecommend()))
                                    // {
                                    // tmpAv.setRecommend(true);
                                    // } else {
                                    // tmpAv.setRecommend(false);
                                    // }
                                    // edit by zxf 添加是否活动拍品，添加活动拍品title
                                    if (BooleanUtils.isTrue(auctionVehicle.getActivity())) {
                                        tmpAv.setActivity(true);
                                    } else {
                                        tmpAv.setActivity(false);
                                    }
                                    if (StringUtils.isNotBlank(auctionVehicle.getActivityTitle())) {
                                        tmpAv.setActivityTitle(auctionVehicle.getActivityTitle());
                                    }
                                    // edit end;

                                    // 流拍操作
                                    tmpAv.setVehicleId(vehicleId);
                                    tmpAv.setLatest(Boolean.TRUE);// 最新拍品
                                    tmpAv.setAuctionType(GlobalConstants.AUCTION_TYPE_ONCEBID);// 在线拍
                                    tmpAv.setStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);// 已上架
                                    tmpAv.setAuctionId(null);
                                    tmpAv.setMaxBidPrice(BigDecimal.ZERO);
                                    tmpAv.setCreatedBy(createdBy);
                                    // tmpAv.setAuctionVehicleOrder(i + 1);
                                    initAuctionVehicle(tmpAv);
                                    updateVehicleSaleStatus(vehicleId, 1);

                                    String statusMsg = status == 4 ? "流拍" : "撤拍";
                                    LOGGER.info("******[拍品业务操作日志-在线拍]【" + statusMsg + "】拍品（#拍品编号" + tmpAv.getAvNo()
                                            + "，#车辆编号" + vehicle.getCode() + "，#销售状态"
                                            + formatStatusSale(vehicle.getSaleStatus())
                                            + "）重新上架成功，（#拍卖类型设置为1【在线拍】，#拍品最新状态设置为1【已上架】，#销售状态为1【销售中】"
                                            + getLogInfo().toString() + new Date() + "）");

                                } else {// 已上架、待拍卖等等
                                    // 拍品同步拍/在线拍转换
                                    av.setId(auctionVehicleId);
                                    av.setAuctionType(GlobalConstants.AUCTION_TYPE_ONCEBID);// 即时拍

                                    StringBuffer logInfo = new StringBuffer("******[拍品业务日志-即时拍]拍品更新操作：");
                                    logInfo.append("#当前拍品编号" + tmpAv.getAvNo() + "，#车辆编号" + vehicle.getCode() + "，#销售状态"
                                            + formatStatusSale(vehicle.getSaleStatus()) + "。（拍品原状态为"
                                            + formatStatusAuction(tmpAv.getStatus()) + "，更新后状态不变。）");

                                    // if
                                    // (auctionType.equals(GlobalConstants.AUCTION_TYPE_SYNC))
                                    // {
                                    // av.setStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);//
                                    // 已上架
                                    // av.setAvNo(businessRuleService
                                    // .getBusinessIdByType(BusinessIdRuleEnum.AV_ONCEBID.getCode()));
                                    // logInfo.append("该拍品为【同步拍】转【即时拍】#拍品原拍卖会SID（"
                                    // + tmpAv.getAuctionId() + "）");
                                    // } else if
                                    // (auctionType.equals(GlobalConstants.AUCTION_TYPE_ONLINE))
                                    // {
                                    // av.setStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);//
                                    // 已上架
                                    // av.setAvNo(businessRuleService
                                    // .getBusinessIdByType(BusinessIdRuleEnum.AV_ONCEBID.getCode()));
                                    // logInfo.append("该拍品为【在线拍】转【即时拍】#拍品原拍卖会SID（"
                                    // + tmpAv.getAuctionId() + "）");
                                    // }

                                    // if (plusRange1 == null ||
                                    // plusRange1.compareTo(Short.parseShort("200"))
                                    // == 0)
                                    av.setPlusRange(0);// 加价幅度

                                    // if (reservePrice1 == null ||
                                    // reservePrice1.compareTo(BigDecimal.ZERO)
                                    // == 0)
                                    av.setReservePrice(BigDecimal.ZERO);// 保留价
                                    //
                                    // if (startPrice1 == null ||
                                    // startPrice1.compareTo(BigDecimal.ZERO) ==
                                    // 0)
                                    av.setStartPrice(BigDecimal.ZERO);// 起拍价

                                    // if (agentPrice1 == null ||
                                    // agentPrice1.compareTo(0) == 0)
                                    av.setAgentPrice(null);

                                    if (StringUtils.isBlank(av.getProvince()))
                                        av.setProvince(null);

                                    if (StringUtils.isBlank(av.getCity()))
                                        av.setCity(null);

                                    // edit by zjz 添加热门推荐
                                    if (BooleanUtils.isTrue(auctionVehicle.getRecommend())) {
                                        av.setRecommend(true);
                                    } else {
                                        av.setRecommend(false);
                                    }
                                    // edit by zxf 添加是否活动拍品，添加活动拍品title
                                    if (BooleanUtils.isTrue(auctionVehicle.getActivity())) {
                                        av.setActivity(true);
                                    } else {
                                        av.setActivity(false);
                                    }
                                    if (StringUtils.isNotBlank(auctionVehicle.getActivityTitle())) {
                                        av.setActivityTitle(auctionVehicle.getActivityTitle());
                                    }
                                    // edit end;
                                    av.setCreatedBy(createdBy);
                                    auctionVehicleService.updateByPrimaryKeySelective(av);
                                    LOGGER.info(logInfo.toString() + getLogInfo().toString() + new Date() + "）");
                                    // auctionVehicleService.updateAuctionVehicleOrders(null,oldAuctionSid);
                                }
                            }
                        }
                    }
                }
                // 更新拍卖会拍品数量
                auctionService.updateAuctionVehicleQuantity();

                if (count == size)
                    msg = "保存成功！";
            }
        }

        if (!flag)
            msg += sb.toString();

        if (!flag && checkArea)
            msg += "\n-------------------------------------------\n";

        if (checkArea)
            msg += areaMsg.toString();

        if (checkArea && isFixedPrice)
            msg += "\n-------------------------------------------\n";

        if (isFixedPrice)
            msg += sb1.toString();
        if (checkStatus)
            msg += checkstatusMsg.toString();
        LOGGER.info("*****[拍品业务操作日志-在线拍]批量设置【在线拍】处理完成：" + msg + getLogInfo().toString() + new Date() + "）");

        return new JsonResult(true, msg);
    }

    @ResponseBody
    @RequestMapping("/getAuctionList")
    public List<Auction> getAuctionList() {
        Auction auction = new Auction();
        List<Organization> orgList = getUser().getOrgList();
        Integer userOrgId = null;
        if (orgList != null && orgList.size() > 0) {
            userOrgId = getUser().getOrgList().get(0).getId();// 用户组织机构
        }
        if (userOrgId == null || userOrgId == 8 || userOrgId == 0) {
            auction.setOrgIds(null);
        } else {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("parentId", 8);
            param.put("delFlag", 0);
            param.put("enabled", 1);
            List<Integer> autostreetsOrgIds;
            try {
                autostreetsOrgIds = organizationService.selectAllSubOrganizationIdsById(param, true);
                if (!autostreetsOrgIds.contains(userOrgId)) {
                    try {
                        param.put("parentId", userOrgId);
                        List<Integer> orgIds = organizationService.selectAllSubOrganizationIdsById(param, true);
                        auction.setOrgIds(orgIds);
                    } catch (Exception e) {
                        LOGGER.error("获取权限失败!", e);
                    }
                }
            } catch (Exception e1) {
                LOGGER.error("获取汽车街权限失败!", e1);
            }
        }
        List<Auction> auctions = auctionService.selectAuctionByOrgIds(auction);
        return auctions;
    }
}