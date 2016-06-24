package com.autostreets.biz.auction.web.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.model.AuctionServiceTrack;
import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AvStatusLog;
import com.autostreets.biz.auction.service.AuctionServiceTrackService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.AvStatusLogService;
import com.autostreets.biz.common.utils.DateUtil;
import com.autostreets.biz.sys.model.user.User;
import com.autostreets.biz.sys.service.user.UserService;
import com.autostreets.biz.usedvehicle.service.vehicle.UsedvehicleOperatorService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.vo.JsonResult;

/**
 * 
 * @author wwy
 * @date 2015年9月1日上午10:02:16
 */
@Controller
@RequestMapping("/oncebidauction")
public class OnceBidAuctionController extends BaseController {

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuctionServiceTrackService auctionServiceTrackService;

    @Autowired
    private AvStatusLogService avStatusLogService;

    @Autowired
    private UsedvehicleOperatorService usedvehicleOperatorService;

    @RequiresPermissions("auct:auction:oncebid")
    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(Model model, AuctionVehicle auctionVehicle, Pagination pagination) {
        datePattern = DateUtil.STANDARD_DATE_TIME_FORMAT_STR;
        auctionVehicle.setPagination(pagination);
        pagination = auctionVehicleService.getOnceBidAuction(auctionVehicle);
        model.addAttribute("pagination", pagination);
        return "oncebidauction/index";
    }

    @RequestMapping(value = "/changeStatus", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JsonResult changeStatus(AuctionVehicle auctionVehicle, String op) {
        try {
            if (auctionVehicle.getId() != null) {
                AvStatusLog avStatusLog = new AvStatusLog();
                avStatusLog.setAvId(auctionVehicle.getId());
                avStatusLog.setCreateTime(new Date());
                avStatusLog.setCreateUser(getUser().getId());
                avStatusLog.setMemo("暗拍预约更改状态");
                avStatusLog.setPreStatus((short) 3);
                auctionVehicle = auctionVehicleService.selectByPrimaryKey(auctionVehicle.getId());
                if ("success".equals(op)) {
                    avStatusLog.setPostStatus((short) 2);// 拍卖成功
                    auctionVehicleService.createOnceBidOrder(auctionVehicle);
                    avStatusLogService.insertSelective(avStatusLog);
                    return new JsonResult(true, "拍卖成功!");
                } else if ("fail".equals(op)) {
                    avStatusLog.setPostStatus((short) 4);// 流拍
                    avStatusLogService.insertSelective(avStatusLog);
                    // auctionVehicle.setStatus(4);
                    // auctionVehicleService.updateByPrimaryKeySelective(auctionVehicle);
                    // usedvehicleOperatorService.updateSaleStatus(auctionVehicle.getVehicleId(),
                    // SaleStatusEnum.SALE_STATUS_WAIT);
                    auctionVehicleService.updateAuctionVehicleStatus(auctionVehicle.getId(),
                            auctionVehicle.getVehicleId(), auctionVehicle.getStatus(),
                            GlobalConstants.AUCTION_VEHICLE_STATUS_FAIL);
                    return new JsonResult(false, "流拍成功!");
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new JsonResult(false, e.getMessage());
        }
        return null;
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param sid
     * @param trackInfo
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/saveTrackInfo", method = {RequestMethod.POST})
    @ResponseBody
    public JsonResult saveTrackInfo(Integer id, String trackInfo) {
        Integer userId = null;
        try {
            userId = getUser().getId();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new JsonResult(false, "请先登录");
        }
        if (userId == null) {
            return new JsonResult(false, "用户不存在");
        }
        if (id != null && StringUtils.isNotBlank(trackInfo)) {
            AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(id);
            if (auctionVehicle == null) {
                return new JsonResult(false, "拍品不存在");
            } else {
                try {
                    AuctionServiceTrack auctionServiceTrack = new AuctionServiceTrack();
                    auctionServiceTrack.setAuctionType(Integer.valueOf(auctionVehicle.getAuctionType()));
                    auctionServiceTrack.setAuctionVehicleId(auctionVehicle.getId());
                    auctionServiceTrack.setCreatedTime(new Date());
                    auctionServiceTrack.setOperatorId(userId);
                    auctionServiceTrack.setRemark(trackInfo);
                    auctionServiceTrackService.insertSelective(auctionServiceTrack);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                    return new JsonResult(false, e.getMessage());
                }
                return new JsonResult(true);
            }
        } else {
            return new JsonResult(false, "参数错误");
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param sid
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/getTrackInfo", method = {RequestMethod.GET})
    @ResponseBody
    public JsonResult getTrackInfo(Integer id) {
        AuctionVehicle auctionVehicle = auctionVehicleService.selectByPrimaryKey(id);
        if (auctionVehicle == null) {
            return new JsonResult(false, "拍品不存在");
        } else {
            try {
                List<AuctionServiceTrack> serviceTracks = auctionServiceTrackService.selectByAuctionVehicleId(id);
                if (serviceTracks != null) {
                    for (AuctionServiceTrack auctionServiceTrack : serviceTracks) {
                        User user = userService.selectByPrimaryKey(auctionServiceTrack.getOperatorId());
                        auctionServiceTrack.setUserName(user != null ? user.getName() : null);
                    }
                }
                return new JsonResult(true, null, serviceTracks);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                return new JsonResult(false, e.getMessage());
            }
        }
    }
}
