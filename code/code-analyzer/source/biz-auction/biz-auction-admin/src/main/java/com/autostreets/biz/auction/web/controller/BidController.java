package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.domain.BidDisplay;
import com.autostreets.biz.auction.enums.BusinessIdRuleEnum;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleStatusLog;
import com.autostreets.biz.auction.model.Bid;
import com.autostreets.biz.auction.model.BidExample;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderStatusLog;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.model.base.BaseBidExample.Criteria;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.AuctionVehicleStatusLogService;
import com.autostreets.biz.auction.service.BidService;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.auction.service.OrderStatusLogService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.web.utils.MsgPhshUtils;
import com.autostreets.biz.cms.service.AppModelService;
import com.autostreets.biz.cms.service.AppMsgPushTriggerService;
import com.autostreets.biz.cms.service.DrawDictionaryService;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.model.user.User;
import com.autostreets.biz.sys.model.user.UserExample;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.biz.sys.service.user.UserService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.model.Member;
import com.autostreets.service.MemberService;
import com.autostreets.service.common.BizIdService;
import com.google.common.base.Strings;
import com.ibm.icu.util.Calendar;

/*
 * 车辆竞拍中出价管理
 * @author weiyi.wang
 */
@Controller
@RequestMapping("/bid")
public class BidController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidController.class);

    @Autowired
    private BidService bidService;

    @Autowired
    private BizIdService bizIdService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private com.autostreets.biz.auction.service.VehicleService auctVehicleService;

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private DrawDictionaryService drawDictionaryService;

    @Autowired
    private AppModelService appModelService;

    @Autowired
    private AppMsgPushTriggerService appMsgPushTriggerService;

    @Autowired
    private AuctionVehicleStatusLogService auctionVehicleStatusLogService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrderStatusLogService orderStatusLogService;

    /**
     * @Description: 处理页面日期转换问题
     */
    @Override
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        DateFormat df = new SimpleDateFormat(GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS);
        CustomDateEditor editor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(value = {"index"})
    @RequiresPermissions("auct:bid:index")
    public String index(Bid bid, Model model) {
        return "bid/vehicle-index";
    }

    /**
     * 车辆模式
     * 
     * @param pagination
     * @param bid
     * @param model
     * @return
     */
    @RequestMapping(value = {"singleQuery"})
    @RequiresPermissions("auct:bid:singleQuery")
    public String singleQuery(Bid bid, Model model) {
        Pagination pagination = new Pagination(1, 1);
        bid.setIsSingle(true);
        bid.setPagination(pagination);
        List<Organization> orgList = getUser().getOrgList();
        Integer userOrgId = null;
        if (orgList != null && orgList.size() > 0) {
            userOrgId = getUser().getOrgList().get(0).getId();// 用户组织机构
        }
        if (userOrgId == null || userOrgId == 8 || userOrgId == 0) {
            bid.setOrgIds(null);
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
                        bid.setOrgIds(orgIds);
                    } catch (Exception e) {
                        LOGGER.error("获取权限失败!", e);
                    }
                }
            } catch (Exception e1) {
                LOGGER.error("获取汽车街权限失败!", e1);
            }
        }
        List<BidDisplay> list = bidService.selectBidDisplayByVehicleMode(bid);
        paseVehicleField(list);
        int count = (list != null ? list.size() : 0);
        pagination.setCount(count);// 设置记录的所有数目
        // 设置需要本页显示的数据
        pagination.setDataList(list);
        model.addAttribute("pagination", pagination);
        return "bid/vehicle-index";
    }

    /**
     * 车辆模式
     * 
     * @param pagination
     * @param bid
     * @param model
     * @return
     */
    @RequestMapping(value = {"query"})
    @RequiresPermissions("auct:bid:index")
    public String query(Pagination pagination, Bid bid, Model model) {
        bid.setPagination(pagination);
        List<Organization> orgList = getUser().getOrgList();
        Integer userOrgId = null;
        if (orgList != null && orgList.size() > 0) {
            userOrgId = getUser().getOrgList().get(0).getId();// 用户组织机构
        }
        if (userOrgId == null || userOrgId == 8 || userOrgId == 0) {
            bid.setOrgIds(null);
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
                        bid.setOrgIds(orgIds);
                    } catch (Exception e) {
                        LOGGER.error("获取权限失败!", e);
                    }
                }
            } catch (Exception e1) {
                LOGGER.error("获取汽车街权限失败!", e1);
            }
        }
        List<BidDisplay> list = bidService.selectBidDisplayByVehicleMode(bid);
        paseVehicleField(list);
        int count = bidService.countBidDisplayByVehicleMode(bid);
        pagination.setCount(count);// 设置记录的所有数目
        // 设置需要本页显示的数据
        pagination.setDataList(list);
        model.addAttribute("pagination", pagination);
        return "bid/vehicle-index";
    }

    /**
     * 出价模式
     */
    @RequestMapping(value = "querybid")
    public String queryBid(Pagination pagination, Bid bid, Model model) {
        bid.setPagination(pagination);
        List<Organization> orgList = getUser().getOrgList();
        Integer userOrgId = null;
        if (orgList != null && orgList.size() > 0) {
            userOrgId = getUser().getOrgList().get(0).getId();// 用户组织机构
        }
        if (userOrgId == null || userOrgId == 8 || userOrgId == 0) {
            bid.setOrgIds(null);
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
                        bid.setOrgIds(orgIds);
                    } catch (Exception e) {
                        LOGGER.error("获取权限失败!", e);
                    }
                }
            } catch (Exception e1) {
                LOGGER.error("获取汽车街权限失败!", e1);
            }
        }
        pagination.setCount(bidService.countBidDisplayByBidMode(bid));// 设置记录的所有数目
        // 设置需要本页显示的数据
        pagination.setDataList(bidService.selectBidDisplayByBidMode(bid));
        model.addAttribute("pagination", pagination);
        return "bid/bid-index";
    }

    @RequestMapping(value = "isExistName")
    @ResponseBody
    public JsonResult isExistName(String creatorName) {
        UserExample uE = new UserExample();
        UserExample.Criteria criteria = uE.createCriteria();
        if (StringUtils.isNotBlank(creatorName)) {
            criteria.andNameEqualTo(creatorName.trim());
        }
        // 根据业务现状,先做如下处理，后续继续改进
        List<User> users = userService.selectByExample(uE);
        if (CollectionUtils.isEmpty(users)) {
            return new JsonResult(false);
        }
        User user = users.get(0);
        return new JsonResult(true, user.getId());
    }

    /**
     * 流拍操作 1 拍品表中状态发生改变 2车辆表中的销售状态发生改变
     * 
     * @param auctionSids
     * @return
     */
    @RequestMapping(value = "failAuction")
    @ResponseBody
    public boolean failAuction(@RequestParam(value = "auctionSids", required = true) String auctionSids) {
        if (StringUtils.isNotBlank(auctionSids)) {
            String[] allSid = auctionSids.split("#");
            if (allSid != null) {
                try {
                    for (String str : allSid) {
                        String[] sids = str.split(",");
                        Integer avId = Integer.valueOf(sids[0]);
                        Integer vehicleId = Integer.valueOf(sids[1]);
                        // String auction_sid = sids[2];
                        // 拍品的拍卖状态变为流拍
                        // fixbug by zjz
                        // 此处修改为新的更新状态接口，由于出价管理车辆流拍只能操作“成交确认”状态的拍品，所以此处状态是“成交确认”>>流拍
                        // at 2015-12-25 13:05:45
                        boolean updateStatusResult = auctionVehicleService.updateAuctionVehicleStatus(avId, vehicleId,
                                GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL_CONFIRM,
                                GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL);
                        if (!updateStatusResult) {
                            LOGGER.warn("拍卖后台，出价管理车辆流拍失败！");
                        }
                        AuctionVehicleStatusLog auctionVehicleStatusLog = new AuctionVehicleStatusLog();
                        auctionVehicleStatusLog.setAvId(avId);
                        auctionVehicleStatusLog.setCreateTime(new Date());
                        auctionVehicleStatusLog.setCreateUser(getUser().getId());
                        auctionVehicleStatusLog.setPreStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL_CONFIRM);
                        auctionVehicleStatusLog.setPostStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL);
                        auctionVehicleStatusLog.setMemo("流拍确认转流拍");
                        auctionVehicleStatusLogService.insertSelective(auctionVehicleStatusLog);
                        // AuctionVehicle av = new AuctionVehicle();
                        // av.setId(avId);
                        // av.setStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL);
                        // 更新车辆表 跟新车辆销售状态由直接调用 改为调用EQS接口
                        // try {
                        // vehicleService.updateSaleStatus(vehicleId,
                        // SaleStatusEnum.SALE_STATUS_WAIT);
                        // } catch (Exception e) {
                        // LOGGER.error(e.getMessage(), e);
                        // throw new IllegalArgumentException("车辆销售状态更新失败");
                        // }
                        // 更新拍品表
                        // try {
                        // auctionVehicleService.updateByPrimaryKeySelective(av);
                        // } catch (Exception e) {
                        // LOGGER.error(e.getMessage(), e);
                        // throw new IllegalArgumentException("拍品更新失败");
                        // }
                    }
                } catch (NumberFormatException e) {
                    LOGGER.error(e.getMessage(), e);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
                return true;
            }
        }
        return false;// 拍卖会首页
    }

    /**
     * 将排放标砖欧转化为 进口，否则排气标准置为空
     * 
     * @param bidDisplays
     */
    private void paseVehicleField(List<BidDisplay> bidDisplays) {
        for (BidDisplay bd : bidDisplays) {
            // 国标还是欧标
            String swept_volume_standard = bd.getSwept_volume_standard();
            if (!Strings.isNullOrEmpty(swept_volume_standard)) {
                if (swept_volume_standard.contains("欧")) {

                    swept_volume_standard = "(进口)";
                } else {
                    swept_volume_standard = null;
                }

                bd.setSwept_volume_standard(swept_volume_standard);
            }

            // 排气量单位处理
            String swept_volume = bd.getSwept_volume();
            String swept_volume_type = bd.getSwept_volume_type();

            if (!Strings.isNullOrEmpty(swept_volume)) {
                swept_volume = swept_volume + " " + swept_volume_type;
                bd.setSwept_volume(swept_volume);
            }

            Integer avId = bd.getId();
            List<BidDisplay> list = bidService.selectBidByAvId(avId);
            if (null != list && list.size() > 0) {
                bd.setBidder_sid(list.get(0).getBidder_sid());
                bd.setMaxPriceName(list.get(0).getBidder_name());
                bd.setMaxPrice(list.get(0).getPrice());
                bd.setBid_quantity(String.valueOf(list.size()));
                if (list.size() > 2) {
                    list = list.subList(0, 2);
                }
            } else if (list == null || list.size() == 0) {
                bd.setBid_quantity(String.valueOf(0));
            }
            bd.setBidList(list);
        }
    }

    @RequestMapping(value = "findBidByAvId")
    @ResponseBody
    public List<BidDisplay> selectBidByAvId(Integer avSid) {
        if (avSid == null) {
            return null;
        }
        return bidService.selectBidByAvId(avSid);
    }

    @RequestMapping(value = "findBidByAvIdTopTwo")
    @ResponseBody
    public List<BidDisplay> findBidByAvIdTopTwo(Integer avSid) {
        List<BidDisplay> list = selectBidByAvId(avSid);
        if (list != null && list.size() > 2) {
            list = list.subList(0, 2);
        }
        return list;
    }

    @RequestMapping(value = "queryMaxPrice")
    @ResponseBody
    public BidDisplay queryMaxPrice(Integer avId) {
        BidDisplay bidDisplay = bidService.getMaxPrice(avId);
        if (bidDisplay != null && "系统".equals(bidDisplay.getBidder_name())) {
            return null;
        }
        if (bidDisplay != null && StringUtils.isNotBlank(bidDisplay.getBidder_sid())) {
            Member member = memberService.selectByPrimaryKey(bidDisplay.getBidder_sid());
            if (member != null) {
                bidDisplay.setCellphone(member.getCellphone());
            }
        }
        return bidDisplay;
    }

    /**
     * 将元转化成万元进行显示
     * 
     * @param bd
     */
    private void setMillonRatio(BidDisplay bd) {
        BigDecimal start_price = bd.getStart_price();
        BigDecimal reserve_price = bd.getReserve_price();
        BigDecimal price = bd.getPrice();

        if (start_price != null) {
            start_price = start_price.divide(new BigDecimal(10000));
            bd.setStart_price(start_price);
        }

        if (reserve_price != null) {
            reserve_price = reserve_price.divide(new BigDecimal(10000));
            bd.setReserve_price(reserve_price);
        }

        if (price != null) {
            price = price.divide(new BigDecimal(10000));
            bd.setPrice(price);
        }
    }

    // 将已上架和待拍卖的不要显示
    public ArrayList<BidDisplay> removeSomeStatus(List<BidDisplay> list) {
        ArrayList<BidDisplay> displays = new ArrayList<BidDisplay>();
        // 去掉已上架的状态的车辆拍卖纪录
        for (BidDisplay bid : list) {

            String status = bid.getStatus();
            if (status != null) {
                // 将已上架和待拍卖的不要显示
                if (status.equals(GlobalConstants.AUCTION_VEHICLE_STATUS_SHELVES)
                        || status.equals(GlobalConstants.WAITING_FOR_THE_AUCTION)) {

                    continue;
                }
            }
            setMillonRatio(bid);
            displays.add(bid);

        }

        return displays;

    }

    /**
     * 车辆成交验证拍卖用户参与竞拍
     * 
     * @param bidName
     *            拍卖者
     * @param avSid
     *            拍品标识
     * @return
     */
    @RequestMapping(value = "dealVehicleValiBidName")
    @ResponseBody
    public JsonResult dealVehicleValiBidName(String bidName, Integer avId) {
        BidExample bidExample = new BidExample();
        Criteria criteria = bidExample.createCriteria();
        criteria.andAuctionVehicleIdEqualTo(avId);
        criteria.andBidderNameEqualTo(bidName);
        List<Bid> bidList = bidService.selectByExample(bidExample);
        if (null != bidList && bidList.size() == 0) {
            return new JsonResult(false, "该用户尚未出价，不能直接成交");
        }
        return new JsonResult(true, "获取成功", bidList.get(0).getBidderSid());
    }

    @RequestMapping("getAuctionVehicle")
    @ResponseBody
    public JsonResult getAuctionVehicle(Integer auctionVehicleId) {
        if (auctionVehicleId == null) {
            return new JsonResult(false, "参数错误");
        }
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(auctionVehicleId);
        return new JsonResult(true, auctionVehicle);
    }

    /**
     * 更新车辆表，跟新订单表，更新拍品表
     * 
     * @param pagination
     * @param bid
     * @param model
     * @param bidderName
     * @param price
     * @return
     */
    @RequestMapping(value = "syncOfflineDeal", method = {RequestMethod.POST})
    @ResponseBody
    public JsonResult syncOfflineDeal(String name, BigDecimal price, Integer avId, String cellphone, OrderItem oItem) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        if (!(auctionVehicle.getStatus().equals(4) || auctionVehicle.getStatus().equals(7))) {
            return new JsonResult(false, "只有流拍车辆和取消订单的车辆才可以成交!");
        }
        if (auctionVehicle.getPlanEndTime() != null) {
            List<AuctionDictionary> resource = auctionDictionaryService.selectResource("sync_end_limit_time");
            if (resource == null || resource.size() == 0) {
                return new JsonResult(false, "拍卖结束限制成交时间未配置!");
            }
            String time = resource.get(0).getValue();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(auctionVehicle.getPlanEndTime());
            calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + Integer.valueOf(time));
            if (calendar.getTime().before(new Date())) {
                return new JsonResult(false, "只有在拍卖结束后" + time + "小时内，才能操作成交!");
            }
        }
        Member member = new Member();
        member.setCellphone(cellphone);
        List<Member> members = memberService.selectByExample(member);
        if (members != null && members.size() > 0) {
            member = members.get(0);
        } else {
            member = null;
        }
        boolean updateStatusResult = false;
        try {
            updateStatusResult = auctionVehicleService.updateAuctionVehicleStatus(auctionVehicle.getId(),
                    auctionVehicle.getVehicleId(), auctionVehicle.getStatus(),
                    GlobalConstants.AUCTION_VEHICLE_STATUS_SUCCESS);
            if (updateStatusResult) {
                // 向订单表插入数据
                Order order = new Order();
                String orderSid = bizIdService.getOrderId(BusinessIdRuleEnum.OV_SYN.getCode());
                order.setOrderNo(orderSid);
                order.setBidderSid(member == null ? null : member.getSid());
                order.setBidderName(name);
                order.setDealTimestamp(new Date());
                order.setCreatedTime(new Date());
                order.setUpdateTime(new Date());
                order.setBuyerCellphone(cellphone);
                orderService.insertSelective(order);

                // 获得买家的佣金比例
                BigDecimal clientCommissionRate = auctionVehicle.getClientCommissionRate();

                // 获取卖方佣金
                BigDecimal clientFixedCommission = null;
                if (clientCommissionRate != null) {
                    clientFixedCommission = getCommission(auctionVehicle, price, clientCommissionRate);
                } else {
                    clientFixedCommission = auctionVehicle.getClientFixedCommission();
                }

                // 向订单详情表插入数据
                order = orderService.selectOrderByOrderNo(orderSid);
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderId(order.getId());
                orderItem.setVehicleId(auctionVehicle.getVehicleId());
                orderItem.setAuctionVehicleId(avId);
                orderItem.setFinalPrice(price);// new
                                               // BigDecimal(Integer.parseInt(price))

                orderItem.setSaleType(1);
                if (oItem.getLicenseFeeType().equals(1)) {
                    orderItem.setLicenseFee(oItem.getLicenseFee());// 办证费用
                    orderItem.setLicenseFeeType(1);// 汽车街代办
                } else {
                    orderItem.setLicenseFee(BigDecimal.ZERO);
                    orderItem.setLicenseFeeType(2);// 买家自理
                }
                // orderItem.setLicenseFee(auctionVehicle.getLicenseFee());//
                // 办证费用
                orderItem.setExWarehouseFee(oItem.getExWarehouseFee());// 出库费
                orderItem.setClientCommissionFee(clientFixedCommission);// 卖家佣金
                orderItem.setBuyerCommissionFee(oItem.getBuyerCommissionFee());// 买家佣金
                orderItem.setParkingFee(auctionVehicle.getParkingFee());// 停车费用
                orderItem.setTrafficFee(auctionVehicle.getTrafficFee());// 运输费
                orderItem.setTrafficViolationFee(auctionVehicle.getTrafficViolationFee());// 交通违章费
                orderItem.setCreatedTimestamp(new Date());// 输入时间
                orderItem.setOrderType(GlobalConstants.AUCTIONEER_MANAGE_CONFER);
                BigDecimal bigDecimal = new BigDecimal(0);
                bigDecimal = bigDecimal.add(orderItem.getFinalPrice());
                bigDecimal = bigDecimal
                        .add(orderItem.getExWarehouseFee() == null ? new BigDecimal(0) : orderItem.getExWarehouseFee());
                bigDecimal = bigDecimal
                        .add(orderItem.getLicenseFee() == null ? new BigDecimal(0) : orderItem.getLicenseFee());
                bigDecimal = bigDecimal.add(orderItem.getBuyerCommissionFee() == null ? new BigDecimal(0)
                        : orderItem.getBuyerCommissionFee());
                orderItem.setSettlePrice(bigDecimal);// 结算价格
                orderItemService.insertSelective(orderItem);

                AuctionVehicleStatusLog auctionVehicleStatusLog = new AuctionVehicleStatusLog();
                auctionVehicleStatusLog.setAvId(avId);
                auctionVehicleStatusLog.setCreateTime(new Date());
                auctionVehicleStatusLog.setCreateUser(getUser().getId());
                auctionVehicleStatusLog.setPreStatus(auctionVehicle.getStatus());
                auctionVehicleStatusLog.setPostStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SUCCESS);
                auctionVehicleStatusLog.setMemo("同步拍" + (auctionVehicle.getStatus().equals(4) ? "流拍" : "取消订单") + "转成交");
                auctionVehicleStatusLogService.insertSelective(auctionVehicleStatusLog);

                OrderStatusLog orderStatusLog = new OrderStatusLog();
                orderStatusLog.setOrderId(order.getId());
                orderStatusLog.setUserId(getUser().getId());
                orderStatusLog.setUserType(Short.valueOf("1"));
                orderStatusLog.setCreateTime(new Date());
                orderStatusLog.setPrepStatus(null);
                orderStatusLog.setPostStatus(Short.valueOf("0"));
                orderStatusLog.setMemo("同步拍" + (auctionVehicle.getStatus().equals(4) ? "流拍" : "取消订单") + "转成交");
                orderStatusLogService.insert(orderStatusLog);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new JsonResult(false, "成交失败!");
        }
        return new JsonResult(true);
    }

    /**
     * 更新车辆表，跟新订单表，更新拍品表
     * 
     * @param pagination
     * @param bid
     * @param model
     * @param bidderName
     * @param price
     * @return
     */
    @RequestMapping(value = "update")
    public String update(Pagination pagination, Bid bid, Model model, String name, BigDecimal price, Integer avId,
            String bidderSid, String flag, OrderItem oItem) {

        /**
         * auction_vehcle 拍卖状态 流拍---->拍卖成功 status 3--->1 order订单表 成交人和价格 order
         * bidder_sid bidder->name order_item 订单详情表 final_price 车辆表 vehicle
         * sale_type 线上拍 同步拍 一口价 sale_status 销售状态：0、待售；1、 出售中；2、已出售
         */

        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
        boolean updateStatusResult = false;
        try {
            updateStatusResult = auctionVehicleService.updateAuctionVehicleStatus(auctionVehicle.getId(),
                    auctionVehicle.getVehicleId(), auctionVehicle.getStatus(),
                    GlobalConstants.AUCTION_VEHICLE_STATUS_SUCCESS);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        if (updateStatusResult) {
            // 向订单表插入数据
            Order order = new Order();

            String orderSid = "";

            Member member = memberService.selectByPrimaryKey(bidderSid);
            if (member != null) {
                order.setBuyerCellphone(member.getCellphone());
            }
            if (auctionVehicle.getAuctionType().equals(0)) {// 同步拍
                orderSid = bizIdService.getOrderId(BusinessIdRuleEnum.OV_SYN.getCode());
            } else if (auctionVehicle.getAuctionType().equals(1)) {
                orderSid = bizIdService.getOrderId(BusinessIdRuleEnum.OV_ONLINE.getCode());
            }
            order.setOrderNo(orderSid);
            order.setBidderSid(bidderSid);
            order.setBidderName(name);
            order.setDealTimestamp(new Date());
            order = orderService.insertSelective(order);

            // 获得买家的佣金比例
            BigDecimal clientCommissionRate = auctionVehicle.getClientCommissionRate();

            // 获取卖方佣金
            BigDecimal clientFixedCommission = null;
            if (clientCommissionRate != null) {
                clientFixedCommission = getCommission(auctionVehicle, price, clientCommissionRate);
            } else {
                clientFixedCommission = auctionVehicle.getClientFixedCommission();
            }

            // 向订单详情表插入数据
            order = orderService.selectOrderByOrderNo(orderSid);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setVehicleId(auctionVehicle.getVehicleId());
            orderItem.setAuctionVehicleId(avId);
            orderItem.setFinalPrice(price);// new
                                           // BigDecimal(Integer.parseInt(price))

            orderItem.setSaleType(GlobalConstants.SALE_STATUS_DONE.intValue());
            if (oItem.getLicenseFeeType().equals(1)) {
                orderItem.setLicenseFee(oItem.getLicenseFee());// 办证费用
                orderItem.setLicenseFeeType(1);// 汽车街代办
            } else {
                orderItem.setLicenseFee(BigDecimal.ZERO);
                orderItem.setLicenseFeeType(2);// 买家自理
            }
            orderItem.setExWarehouseFee(oItem.getExWarehouseFee());// 出库费
            orderItem.setClientCommissionFee(clientFixedCommission);// 卖家佣金
            orderItem.setBuyerCommissionFee(oItem.getBuyerCommissionFee());// 买家佣金
            orderItem.setParkingFee(auctionVehicle.getParkingFee());// 停车费用
            orderItem.setTrafficFee(auctionVehicle.getTrafficFee());// 运输费
            orderItem.setTrafficViolationFee(auctionVehicle.getTrafficViolationFee());// 交通违章费
            orderItem.setCreatedTimestamp(new Date());// 输入时间
            orderItem.setOrderType(GlobalConstants.AUCTIONEER_MANAGE_CONFER);
            BigDecimal bigDecimal = new BigDecimal(0);
            bigDecimal = bigDecimal.add(orderItem.getFinalPrice());
            bigDecimal = bigDecimal
                    .add(orderItem.getExWarehouseFee() == null ? new BigDecimal(0) : orderItem.getExWarehouseFee());
            bigDecimal = bigDecimal
                    .add(orderItem.getLicenseFee() == null ? new BigDecimal(0) : orderItem.getLicenseFee());
            bigDecimal = bigDecimal.add(
                    orderItem.getBuyerCommissionFee() == null ? new BigDecimal(0) : orderItem.getBuyerCommissionFee());
            orderItem.setSettlePrice(bigDecimal);// 结算价格
            orderItemService.insertSelective(orderItem);

            AuctionVehicleStatusLog auctionVehicleStatusLog = new AuctionVehicleStatusLog();
            auctionVehicleStatusLog.setAvId(avId);
            auctionVehicleStatusLog.setCreateTime(new Date());
            auctionVehicleStatusLog.setCreateUser(getUser().getId());
            auctionVehicleStatusLog.setPreStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL_CONFIRM);
            auctionVehicleStatusLog.setPostStatus(GlobalConstants.AUCTION_VEHICLE_STATUS_SUCCESS);
            auctionVehicleStatusLog.setMemo("流拍确认转成交");
            auctionVehicleStatusLogService.insertSelective(auctionVehicleStatusLog);

            OrderStatusLog orderStatusLog = new OrderStatusLog();
            orderStatusLog.setOrderId(order.getId());
            orderStatusLog.setUserId(getUser().getId());
            orderStatusLog.setUserType(Short.valueOf("1"));
            orderStatusLog.setCreateTime(new Date());
            orderStatusLog.setPrepStatus(null);
            orderStatusLog.setPostStatus(Short.valueOf("0"));
            orderStatusLog.setMemo("流拍确认转成交");
            orderStatusLogService.insert(orderStatusLog);

            // 消息推送
            // 获取最大出价的人
            try {
                Vehicle vehicle = vehicleService.selectByPrimaryKey(auctionVehicle.getVehicleId());
                Map<String, String> params = new HashMap<String, String>();
                params.put("title", vehicle.getSelledName());
                params.put("price", bid.getPrice().toString());
                MsgPhshUtils.Jpush(drawDictionaryService, appModelService,
                        appMsgPushTriggerService.getMsgPushByTriggerName("在线拍成交"), bid.getBidderSid(), params);
            } catch (Exception e) {
                LOGGER.error("在线拍成交推送失败", e);
            }
        }
        model.addAttribute("flag", flag);
        if (Strings.isNullOrEmpty(flag) || flag.equals("v")) {
            return "redirect:/bid/query";
        } else {
            return "redirect:/bid/querybid";
        }
    }

    /**
     * 计算佣金
     * 
     * @param auctionVehicle
     * @param price
     * @return
     */
    private BigDecimal getCommission(AuctionVehicle auctionVehicle, BigDecimal price, BigDecimal commissionPercent) {
        if (commissionPercent != null) {
            commissionPercent = commissionPercent.divide(new BigDecimal(100));
        }
        List<AuctionDictionary> list = auctionDictionaryService.selectCommissionFeeRange();
        BigDecimal min = null;
        BigDecimal max = null;
        for (AuctionDictionary dictionary : list) {
            if (dictionary.getName().equals("min")) {
                min = new BigDecimal(dictionary.getValue());
            } else if (dictionary.getName().equals("max")) {
                max = new BigDecimal(dictionary.getValue());
            }
        }
        LOGGER.info("max=" + max + "  min=" + min);
        BigDecimal commission = null;
        if (commissionPercent != null) {
            commission = price.multiply(commissionPercent);
            // 计算出的佣金如果小于或者等于最小佣金，那么取最小佣金
            if (commission.compareTo(min) == -1 || commission.compareTo(min) == 0) {
                commission = min;
                // 计算出的佣金如果大于最小佣金 且小于最大佣金，那么就取计算出来的佣金
            } else if (commission.compareTo(min) == 1 && commission.compareTo(max) == -1) {
                commission = price.multiply(commissionPercent);
                // 如果计算出的佣金大于最大佣金，那么就取最大佣金
            } else {
                commission = max;
            }
        }
        return commission;
    }

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 获取拍品最高出价人信息（以及卖家信息）
     * </pre>
     *
     * @param avId
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年11月27日 下午1:29:51
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "getAvMaxPriceBidder", method = RequestMethod.GET)
    public @ResponseBody JsonResult getAvMaxPriceBidder(Integer avId, Integer vehicleId) {
        if (vehicleId != null) {
            Vehicle vehicle = auctVehicleService.selectByPrimaryKey(vehicleId);
            // 非商家车辆不能查看
            if (vehicle.getAuditFlag() == null || !vehicle.getAuditFlag().equals(1)) {
                return new JsonResult(false, "非商家车辆不能查看!");
            }
        }
        if (avId != null) {
            AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
            // 非成交确认的车不能查看
            if (!auctionVehicle.getStatus().equals(3)) {
                return new JsonResult(false, "非成交确认车辆不能查看!");
            }
            Bid maxBidder = bidService.getMaxPriceBidder(avId);
            if (maxBidder != null) {
                String memberSid = maxBidder.getBidderSid();
                if (StringUtils.isNotEmpty(memberSid)) {
                    Member member = memberService.selectByPrimaryKey(memberSid);
                    if (member != null) {
                        Integer userId = auctionVehicle.getCreatedBy();
                        if (auctionVehicle != null && userId != null) {
                            User user = userService.selectByPrimaryKey(userId);
                            if (user != null) {
                                JSONObject data = new JSONObject();
                                // 买家姓名，为空取用户名
                                data.put("buyerName", member.getName());
                                // 买家手机号
                                data.put("buyerPhone", member.getCellphone());
                                // 卖家姓名
                                data.put("sellerName", user.getName());
                                // 卖家手机号
                                data.put("sellerPhone", user.getCellPhone());
                                return new JsonResult(true, data);
                            }
                            return new JsonResult(false, "发拍人不存在");
                        }
                        return new JsonResult(false, "拍品不存在");
                    }
                }
                return new JsonResult(false, "用户信息不存在");
            } else {
                return new JsonResult(false, "无出价记录");
            }
        }
        return new JsonResult(false);
    }

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 更新是否可追加状态
     * </pre>
     *
     * @param avId
     * @return
     * @author jingzhou.zhao
     * @datetime 2015年11月27日 下午1:50:53
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "updateFinalPriceStatus", method = RequestMethod.POST)
    public @ResponseBody JsonResult updateFinalPriceStatus(Integer avId) {
        if (avId != null) {
            AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(avId);
            if (auctionVehicle != null) {
                // 已经标记为可以出价，结束方法
                if (auctionVehicle.getFinalBidStatus() != null && auctionVehicle.getFinalBidStatus().equals(1)) {
                    return new JsonResult(false, "此拍品已可追价！");
                }
                // VehicleInfo vehicleInfo =
                // vehicleService.selectVehicleById(auctionVehicle.getVehicleId());
                Vehicle vehicle = auctVehicleService.selectByPrimaryKey(auctionVehicle.getVehicleId());
                // 商家车辆
                if (vehicle != null && vehicle.getAuditFlag() != null && vehicle.getAuditFlag().equals(1)) {
                    // 成交确认才可修改状态
                    if (auctionVehicle.getStatus() != null && auctionVehicle.getStatus().equals(3)) {
                        AuctionVehicle record = new AuctionVehicle();
                        record.setId(avId);
                        record.setFinalBidStatus(1);// 可出价
                        int affect = auctionVehicleService.updateByPrimaryKeySelective(record);
                        if (affect == 1) {
                            return new JsonResult(true);
                        }
                        return new JsonResult(false, "更新失败");
                    }
                    return new JsonResult(false, "非成交确认状态");
                }
                return new JsonResult(false, "车辆不存在或者非商家审核车辆");
            }
            return new JsonResult(false, "拍品不存在");
        }
        return new JsonResult(false);
    }

}
