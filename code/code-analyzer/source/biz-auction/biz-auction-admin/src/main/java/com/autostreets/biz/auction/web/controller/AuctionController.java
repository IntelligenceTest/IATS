package com.autostreets.biz.auction.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.enums.BusinessIdRuleEnum;
import com.autostreets.biz.auction.model.Auction;
import com.autostreets.biz.auction.model.AuctionPlace;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.model.base.BaseAuctionVehicleExample.Criteria;
import com.autostreets.biz.auction.service.AuctionPlaceService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.web.utils.MsgPhshUtils;
import com.autostreets.biz.cms.service.AppModelService;
import com.autostreets.biz.cms.service.AppMsgPushTriggerService;
import com.autostreets.biz.cms.service.DrawDictionaryService;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.biz.usedvehicle.enums.SaleStatusEnum;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.wtms.dto.AuctionCatalogue;
import com.autostreets.biz.wtms.dto.WareHouse;
import com.autostreets.biz.wtms.service.WmsService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.service.BusinessRuleService;

/**
 * 拍卖会管理请求处理控制器
 * 
 * @author youpeng.zhang Date: 2015年8月17日 下午2:34:54
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/auction")
public class AuctionController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionController.class);

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private AuctionPlaceService auctionPlaceService;

    @Autowired
    private OrganizationService sysOrganizationService;

    @Autowired
    private BusinessRuleService businessRuleService;

    @Autowired
    private WmsService wmsService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private DrawDictionaryService drawDictionaryService;

    @Autowired
    private AppModelService appModelService;

    @Autowired
    private AppMsgPushTriggerService appMsgPushTriggerService;

    @Autowired
    private com.autostreets.biz.usedvehicle.service.vehicle.VehicleService usedVehicleService;

    @Autowired
    private OrganizationService organizationService;

    /**
     * 车辆拍卖管理首页
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月17日 下午2:36:54
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/index")
    @RequiresPermissions(value = {"auct:auct_idx:index"})
    public String doToIndex(Pagination pagination, Auction auction, Model model) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
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
        pagination = auctionService.selectAuctionsByPage(pagination, auction);
        model.addAttribute("pagination", pagination);
        return "auction/auction-index";
    }

    /**
     * 处理新增、更新、查看操作
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月19日 下午3:22:06
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/op")
    @RequiresPermissions(value = {"auct:auct_idx:add", "auct:auct_idx:edit",
            "auct:auct_idx:view"}, logical = Logical.OR)
    public String doOperation(Integer auctionId, String flag, Model model) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
        Auction auction = new Auction();

        if (auctionId != null && StringUtils.isNotBlank(flag)) {
            auction = auctionService.selectByPrimaryKey(auctionId);
            // 进行更新、查看、删除处理
            if (flag.equalsIgnoreCase(GlobalConstants.USER_OPERATION_EDIT)) {
                LOGGER.info("************************进入拍卖信息更新页面************************");
                model.addAttribute(GlobalConstants.USER_OPERATION_FLAG, GlobalConstants.USER_OPERATION_EDIT);

            } else if (flag.equalsIgnoreCase(GlobalConstants.USER_OPERATION_VIEW)) {
                LOGGER.info("************************进入拍卖信息查看页面************************");
                model.addAttribute(GlobalConstants.USER_OPERATION_FLAG, GlobalConstants.USER_OPERATION_VIEW);

            } else if (flag.equalsIgnoreCase(GlobalConstants.USER_OPERATION_DELETE)) {
                LOGGER.info("************************进入拍卖信息删除处理************************");
                auction.setEnable(false);
                auctionService.updateByPrimaryKeySelective(auction);

                return "redirect:/auction/index";
            }
        } else {
            // 新增
            model.addAttribute(GlobalConstants.USER_OPERATION_FLAG, GlobalConstants.USER_OPERATION_ADD);
        }
        // 构建仓储门店查询参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("businessType", "4");
        params.put("type", 2);
        List<Organization> orgs = sysOrganizationService.getOrgByOrgDetailQueryParam(params);
        model.addAttribute("orgs", orgs);

        model.addAttribute(auction);
        // edit by zjz 2015-07-08 11:28:51
        bindViewAuctionPlace(model);
        // edit end;
        return "auction/auction-operation";
    }

    /**
     * 绑定页面拍卖场地信息
     * 
     * @return void
     * @author youpeng.zhang Date: 2015年8月19日 下午3:26:36
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    private void bindViewAuctionPlace(Model model) {
        AuctionPlace auctionPlace = new AuctionPlace();
        auctionPlace.setEnabled(true);// 激活的场地
        model.addAttribute("auctionPlaces", auctionPlaceService.getAuctionPlaceList(auctionPlace));
    }

    /**
     * 新增/编辑拍卖信息
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月21日 上午9:49:55
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    public String doSave(@Validated Auction auction, Model model) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
        // 是否需要保证金
        Boolean flag = auction.getDepositMargin();
        if (!flag) {
            auction.setVehicleMargin(BigDecimal.ZERO);
            auction.setAuctionMargin(BigDecimal.ZERO);
        }

        // edit by zjz at 2015-07-08 11:13:29 拍卖场地的处理（将拍卖场地相关地址字段冗余到拍卖会中）
        if (auction.getPlaceId() != null) {
            AuctionPlace auctionPlace = auctionPlaceService.selectByPrimaryKey(auction.getPlaceId());
            if (auctionPlace != null) {
                auction.setProvince(auctionPlace.getProvince());// 省
                auction.setCity(auctionPlace.getCity());// 市
                auction.setAddress(auctionPlace.getAddr());// 地址
            } else {
                LOGGER.error("auctionPlace not found!!!,placeId:{}", auction.getPlaceId());
            }
        } else {
            LOGGER.error("auction-placeId not found!!!");
        }

        if (auction.getId() != null) {

            if (null == auction.getAuctionMargin()) {
                auction.setAuctionMargin(BigDecimal.ZERO);
            }

            if (null == auction.getVehicleMargin()) {
                auction.setVehicleMargin(BigDecimal.ZERO);
            }

            Auction orgAuction = auctionService.selectByPrimaryKey(auction.getId());
            if (!orgAuction.getStartTimestamp().equals(auction.getStartTimestamp())
                    || !orgAuction.getEndTimestamp().equals(auction.getEndTimestamp())) {
                AuctionVehicleExample auctionVehicleExample = new AuctionVehicleExample();
                Criteria criteria = auctionVehicleExample.createCriteria();
                criteria.andAuctionIdEqualTo(auction.getId());
                List<AuctionVehicle> avList = auctionVehicleService.selectByExample(auctionVehicleExample);
                if (null != avList && avList.size() > 0) {
                    for (AuctionVehicle auctionVehicle : avList) {
                        auctionVehicle.setPlanStartTime(auction.getStartTimestamp());
                        auctionVehicle.setPlanEndTime(auction.getEndTimestamp());
                        auctionVehicleService.updateByPrimaryKey(auctionVehicle);
                    }
                }
            }
            // fixed bug by zjz 拍卖数量修改为不可修改。2015-11-4 11:32:10.
            auction.setVehicleQuantity(null);
            auction.setOrgId(getUser().getOrgList().get(0).getId());
            // fixed end;
            auctionService.updateByPrimaryKeySelective(auction);

            LOGGER.info("*******************更新拍卖会信息成功*******************");

        } else {
            // 初始化

            auction.setCode(businessRuleService.getBusinessIdByType(BusinessIdRuleEnum.AUCTION.getCode()));// 拍卖会编号
            auction.setCreatedTimestamp(new Date());// 创建时间
            auction.setEnable(true);// 未删除
            auction.setStatus(0); // 状态：创建(未发布)
            auction.setCreatedBy(getUser().getUsername());// 创建人
            auction.setOrgId(getUser().getOrgList().get(0).getId());
            auctionService.insert(auction);
            LOGGER.info("*******************保存拍卖会信息成功********************");
        }
        return "redirect:/auction/index";
    }

    /**
     * 拍卖会发布
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月21日 下午5:45:12
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/release", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"auct:auct_idx:release"})
    public String doRelease(@RequestParam(value = "auctionSids", required = true) String auctionSids) {
        LOGGER.info("*******************进入拍卖会发布流程********************");

        String msg = "发布失败！";
        boolean checkOrderError = false;
        StringBuilder errorMsg = new StringBuilder("\n您选中的部分拍卖会【拍品顺序】设置无效。\n请重新修改后再发布。\n拍卖会编号为");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        if (StringUtils.isNotBlank(auctionSids)) {
            String[] allSid = auctionSids.split(",");

            if (ArrayUtils.isNotEmpty(allSid)) {
                int size = allSid.length;
                Integer auctionId = null;
                List<Integer> vehicleIds = null;
                Integer vehicleId = null;
                int count = 0;
                boolean checkOrder = true;
                Auction auction = null;

                for (int i = 0; i < size; i++) {
                    auctionId = Integer.valueOf(allSid[i]);
                    checkOrder = isRelease(auctionId);
                    auction = auctionService.selectByPrimaryKey(auctionId);
                    LOGGER.warn("拍卖会：" + auction.getTitle() + "；拍卖时间：" + format.format(auction.getStartTimestamp())
                            + "；地址：" + auction.getAddress() + ";准备发布");
                    // 如果发布过，不再执行更新操作及推送消息
                    if (auction.getStatus().equals(1) || auction.getStatus().equals(2)) {
                        msg = "已发布";
                        continue;
                    }
                    if (!checkOrder) {
                        errorMsg.append(auction.getCode());
                        errorMsg.append("、");
                        if (!checkOrderError) {
                            checkOrderError = true;
                        }
                        continue;
                    }

                    vehicleIds = auctionService.queryVehicleFromAuction(auctionId,
                            GlobalConstants.WAITING_FOR_THE_AUCTION);
                    if (!vehicleIds.isEmpty()) {
                        try {
                            for (Integer tmpvehicleId : vehicleIds) {

                                // 2015-03-04 17:03 EQS整合修改车辆销售状态

                                // vehicleId =
                                // Integer.valueOf(vehicle.get("vehicle_id"));
                                vehicleId = tmpvehicleId;
                                // usedvehicleOperatorService.updateSaleStatus(vehicleId,
                                // SaleStatusEnum.SALE_STATUS_ONGOING);
                                vehicleService.updateSaleStatus(vehicleId, SaleStatusEnum.SALE_STATUS_ONGOING);
                            }
                        } catch (Exception e) {
                            LOGGER.error(e.getMessage(), e);
                        }
                        Integer placeNum = auctionPlaceService.getPlaceLastAuctionNum(auction.getPlaceId());
                        // 更新最大场次
                        if (auction.getAuctionNum() == null) {
                            auction.setAuctionNum(placeNum + 1);
                            auctionService.updateByPrimaryKey(auction);
                        }

                        // 发布拍卖会
                        count += auctionService.updateStatus(GlobalConstants.AUCTION_STATUS_RELEASE, auctionId);

                        // 更新该拍卖会下所有待拍卖拍品为已上架
                        auctionService.updateAuctionVehicleStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES,
                                auctionId, GlobalConstants.WAITING_FOR_THE_AUCTION);
                    }
                    LOGGER.warn("拍卖会：" + auction.getTitle() + "；拍卖时间：" + format.format(auction.getStartTimestamp())
                            + "；地址：" + auction.getAddress() + ";原发布状态：" + auction.getStatus() + ";已发布");
                    // 推送给所有用户
                    try {
                        auction = auctionService.selectByPrimaryKey(auctionId);

                        Map<String, String> params = new HashMap<String, String>();

                        params.put("auctionTime", format.format(auction.getStartTimestamp()));
                        params.put("address", auction.getAddress());
                        MsgPhshUtils.Jpush(drawDictionaryService, appModelService,
                                appMsgPushTriggerService.getMsgPushByTriggerName("同步拍拍卖会发布"), null, params);
                        LOGGER.warn("拍卖会：" + auction.getTitle() + "；拍卖时间：" + format.format(auction.getStartTimestamp())
                                + "；地址：" + auction.getAddress() + ";原发布状态：" + auction.getStatus() + ";已推送通知");
                    } catch (Exception e) {
                        LOGGER.error("同步拍拍卖会发布推送失败", e);
                    }

                }

                if (size == count) {

                    msg = "发布成功！";
                }

            }
        }

        if (checkOrderError)
            msg += errorMsg.toString();

        return msg;
    }

    /**
     * 拍卖会取消发布
     * 
     * @return boolean
     * @author youpeng.zhang Date: 2015年8月22日 下午4:54:13
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequestMapping(value = "/cancelRelease", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = {"auct:auct_idx:cancelRelease"})
    public boolean doCancelRelease(@RequestParam(value = "auctionIds", required = true) String auctionIds) {
        LOGGER.info("*******************进入拍卖会【取消发布】流程********************");
        if (StringUtils.isNotBlank(auctionIds)) {

            String[] allSid = auctionIds.split(",");
            if (null != allSid) {

                int size = allSid.length;
                Integer auctionId = null;
                List<Integer> vehicleIds = null;
                Integer vehicleId = null;

                for (int i = 0; i < size; i++) {
                    auctionId = Integer.valueOf(allSid[i]);
                    vehicleIds = auctionService.queryVehicleFromAuction(auctionId,
                            GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);
                    if (!vehicleIds.isEmpty()) {// 有拍品才更新
                        try {
                            for (Integer tempvehicleId : vehicleIds) {
                                vehicleId = tempvehicleId;
                                vehicleService.updateSaleStatus(vehicleId, SaleStatusEnum.SALE_STATUS_WAIT);
                            }
                        } catch (Exception e) {
                            LOGGER.error(e.getMessage(), e);
                        }
                    }
                    // 取消发布拍卖会
                    auctionService.updateStatus(GlobalConstants.AUCTION_STATUS_CREATE, auctionId);
                    // 更新该拍卖会下所有待拍卖拍品为待拍卖
                    auctionService.updateAuctionVehicleStatus(GlobalConstants.WAITING_FOR_THE_AUCTION, auctionId,
                            GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * 判断拍卖会拍品顺序是否有效
     * 
     * @return boolean
     * @author youpeng.zhang Date: 2015年8月21日 下午5:46:57
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    private boolean isRelease(Integer auctionId) {

        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("auctionId", auctionId);
        List<Map<String, String>> auctionVehicleList = auctionVehicleService.listAuctionVehicleByAcutionId(param);

        if (null == auctionVehicleList || auctionVehicleList.isEmpty()) {
            return false;
        }

        HashSet<String> orderLast = new HashSet<String>();// 判断重复
        Object auctionVehicleOrder = null;
        String order = null;

        for (Map<String, String> item : auctionVehicleList) {
            auctionVehicleOrder = item.get("auctionVehicleOrder");
            if (null == auctionVehicleOrder)
                return false;

            order = auctionVehicleOrder.toString();
            if (StringUtils.isNotBlank(order))
                orderLast.add(order);
        }

        int size1 = auctionVehicleList.size();
        int size2 = orderLast.size();

        if (size1 != size2)
            return false;

        HashSet<String> result = new HashSet<String>();// 正确顺序
        for (int i = 1; i <= size2; i++) {
            result.add(i + "");
        }

        result.retainAll(orderLast);
        int resultSize = result.size();

        if (resultSize == size2)
            return true;

        return false;
    }

    @RequestMapping("/synchronizationCatalog")
    @ResponseBody
    public JsonResult synchronizationCatalog(Integer auctionId) {
        boolean falg = false;
        Auction auction = auctionService.selectAutionById(auctionId);

        List<Vehicle> vehicleList = auctionVehicleService.selectStockRemovalAuction(auctionId);
        AuctionCatalogue auctionCatalogue = new AuctionCatalogue();
        List<com.autostreets.biz.wtms.dto.AuctionVehicle> auctionVehicleList = new ArrayList<com.autostreets.biz.wtms.dto.AuctionVehicle>();
        if (null == vehicleList || vehicleList.size() == 0) {
            return new JsonResult(falg, "推送失败，该拍卖会中没有车辆");
        }
        for (int i = 0; i < vehicleList.size(); i++) {
            com.autostreets.biz.wtms.dto.AuctionVehicle auctionVehicle = new com.autostreets.biz.wtms.dto.AuctionVehicle();
            auctionVehicle.setOrder(vehicleList.get(i).getAuctionVehicleOrder().toString());
            auctionVehicle.setVin(vehicleList.get(i).getVinCode());
            auctionVehicleList.add(auctionVehicle);
        }
        auctionCatalogue.setAuctonVehicles(auctionVehicleList);
        auctionCatalogue.setName(auction.getTitle());
        auctionCatalogue.setId(String.valueOf(auction.getId()));
        if (null == auction.getOrgId()) {
            return new JsonResult(falg, "没有选择仓储门店无法推送到仓储");
        }
        try {
            List<WareHouse> wareHouseList = wmsService.queryWareHouseList(auction.getOrgId().toString(), "2");
            if (null == wareHouseList || wareHouseList.isEmpty()) {
                return new JsonResult(falg, "选择的仓储门店没有查询到仓库，无法推送到仓储");
            }
        } catch (Exception e) {
            LOGGER.warn("查询仓库失败");
            return new JsonResult(falg, "选择的仓储门店没有查询到仓库，无法推送到仓储");
        }
        auctionCatalogue.setOrgId(auction.getOrgId().toString());
        try {
            falg = wmsService.pushAuctionCatalogue(auctionCatalogue);
            if (falg) {
                auction.setPushTms(falg);
                auctionService.updateByPrimaryKey(auction);
            } else {
                LOGGER.warn("pushAuctionCatalogue接口调用返回false");
                return new JsonResult(falg, "推送失败");
            }
        } catch (Exception e) {
            LOGGER.error("推送拍卖会sid=" + auction.getId() + "失败", e);
            return new JsonResult(falg, "推送失败，系统异常");
        }
        /* auction.set */

        return new JsonResult(falg, "推送成功");
    }

    /**
     * 远通集团拍卖导出
     */
    @RequiresPermissions(value = {"auct:auct_idx:exportCatalog"})
    @RequestMapping(value = "/exportCatalog", method = RequestMethod.GET)
    public void exportCatalog(HttpServletResponse response, Auction auction) {
        if (auction == null || auction.getId() == null) {
            try {
                response.getWriter()
                        .write("<font color='red'>Inconsistent or incomplete information was provided!</font>");
                return;
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        auction = auctionService.selectByPrimaryKey(auction.getId());
        if (auction.getStatus() == 0) {
            try {
                response.setContentType("text/plain; charset=utf-8");
                response.getWriter().write("拍卖会还未发布!");
                return;
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        List<String> exportCol = new ArrayList<String>();
        exportCol.add("auctionVehicleOrder#序号");
        exportCol.add("orgName#单位");
        exportCol.add("code#车辆编号");
        exportCol.add("vehicleModel#车型");
        exportCol.add("vinCode#车架号");
        exportCol.add("sweptVolume#排量");
        exportCol.add("createdTimestamp#登记时间");
        exportCol.add("nextCompulsoryInsurance#交强险有效期");
        exportCol.add("nextAnnualExamination#年审有效期");
        exportCol.add("displayMileage#表显里程（万公里）");
        exportCol.add("vehicleDesc#车辆描述");
        List<AuctionVehicle> auctionVehicleList = auctionVehicleService.exportCatalog(auction);
        for (AuctionVehicle auctionVehicle : auctionVehicleList) {
            if (auctionVehicle.getVehicleSrcId() != null) {
                auctionVehicle.setOrgName(organizationService.getOrgNameById(auctionVehicle.getVehicleSrcId()));
            }
            VehicleInfo vehicleInfo = usedVehicleService.loadVehicleInfo(auctionVehicle.getVehicleId());
            auctionVehicle.setDisplayMileage(vehicleInfo.getDisplayMileage() != null
                    ? vehicleInfo.getDisplayMileage().divide(new BigDecimal(10000)).toString() : null);
            auctionVehicle.setVehicleModel(vehicleInfo.getBrand() + " " + vehicleInfo.getVehicleModel());// 车型
            auctionVehicle.setNextAnnualExamination(vehicleInfo.getNextAnnualExamination());// 年审有效期
            auctionVehicle.setNextCompulsoryInsurance(vehicleInfo.getNextCompulsoryInsurance());// 交强险有效期
            auctionVehicle.setSweptVolume(vehicleInfo.getSweptVolume() + vehicleInfo.getSweptVolumeType());
            auctionVehicle.setCreatedTimestamp(vehicleInfo.getCreatedTime());
        }
        if (!CollectionUtils.isEmpty(auctionVehicleList)) {
            exportExcelUtil.setDateFormat("yyyy-MM-dd");
            exportExcelUtil.exportExcel(exportCol, auctionVehicleList, response, auction.getTitle() + "车辆信息公示表",
                    "2007");
        } else {
            try {
                response.getWriter().write("<font color='red'>no data!</font>");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @RequestMapping("/getMaxAuctionPlace")
    @ResponseBody
    public Integer checkAuctionPlace(Integer placeId) {
        if (placeId == null) {
            return null;
        }
        return auctionPlaceService.getPlaceLastAuctionNum(placeId);

    }
}
