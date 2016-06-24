package com.autostreets.biz.auction.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.autostreets.biz.usedvehicle.model.CheckitemInfo;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.biz.usedvehicle.service.UsedvehicleDictionaryService;
import com.autostreets.biz.usedvehicle.service.vehicle.VehicleService;
import com.autostreets.framework.common.utils.DFSUtils;

/**
 * 车辆详情
 * 
 * @author wei.liao
 * @date 2015年8月26日下午3:17:11
 */
@Controller
@RequestMapping("/vehicle")
public class VehicleController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);
    // 错误消息文本
    public static final String ERROR_INITIALIZATION_VEHICLE_INFO = "初始化车辆信息失败";

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UsedvehicleDictionaryService usedvehicleDictionaryService;

    // @RequiresPermissions(value= {"autc:vehicle:detail"})
    @RequestMapping(value = "/vehicleDetail", method = RequestMethod.GET)
    public String vehicleDetail(VehicleInfo vehicle, Model model) {
        try {
            vehicle = vehicleService.addVehicle(vehicle);
            if (vehicle == null) {
                return null;
            }
            if (3 != vehicle.getVehicleSrcType().intValue()) {
                vehicle = vehicleService.defaultVehicleSrcOrg(vehicle);
            }
            List<CheckitemInfo> checkitemList = vehicle.getCheckitemList();
            Integer appearanceCount = 0;
            Integer skeletonCount = 0;
            Integer interiorCount = 0;
            for (CheckitemInfo checkitemInfo : checkitemList) {
                if (checkitemInfo.getCategory().intValue() == 1 && checkitemInfo.getItemGroup().intValue() == 1) {
                    skeletonCount += 1;
                }
                if (checkitemInfo.getCategory().intValue() == 2 && checkitemInfo.getSubCategory().intValue() == 4
                        && checkitemInfo.getItemGroup().intValue() == 1) {
                    appearanceCount += 1;
                }
                if (checkitemInfo.getCategory().intValue() == 2 && checkitemInfo.getSubCategory().intValue() == 5
                        && checkitemInfo.getItemGroup().intValue() == 1) {
                    interiorCount += 1;
                }
            }

            model.addAttribute("vehicleLicenseUrlSmall",
                    DFSUtils.choiceImgUrl("240X180", vehicle.getVehicleLicenseUrl()));
            model.addAttribute("vehicleLicenseUrlBig",
                    DFSUtils.choiceImgUrl("520X390", vehicle.getVehicleLicenseUrl()));
            model.addAttribute("featureItemsList", usedvehicleDictionaryService.selectFeatureItems());
            model.addAttribute("appearanceCount", appearanceCount);
            model.addAttribute("skeletonCount", skeletonCount);
            model.addAttribute("interiorCount", interiorCount);
            model.addAttribute("vehicle", vehicle);
        } catch (Exception e) {
            LOGGER.error(ERROR_INITIALIZATION_VEHICLE_INFO, e);
        }
        return "vehicleDetail/index";
    }
}
