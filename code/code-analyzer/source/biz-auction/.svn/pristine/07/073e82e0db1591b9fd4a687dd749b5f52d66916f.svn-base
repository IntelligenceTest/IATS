package com.autostreets.biz.auction.web.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.model.AppointmentUsedcar;
import com.autostreets.biz.auction.service.AppointmentUsedcarService;
import com.autostreets.framework.common.dal.Pagination;

@Controller
@RequestMapping("/appointmentUsedCar")
public class AppointmentUsedCarController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentUsedCarController.class);

    @Autowired
    private AppointmentUsedcarService appointmentUsedcarService;

    @RequiresPermissions("auct:appointment:index")
    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public String selectAppVersion(Pagination pagination, AppointmentUsedcar appointmentUsedcar, Model model) {
        datePattern = GlobalConstants.AUCTION_DATE_FORMAT_YYYYMMDD_HHMMSS;
        LOGGER.debug("*******************进入预约看车单首页**********************");
        pagination = appointmentUsedcarService.selectAppointmentUsedcarWithPage(pagination, appointmentUsedcar);
        model.addAttribute("pagination", pagination);
        return "appointmentUsedCar/index";
    }

    @RequestMapping(value = "/queryVehicleSrc", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String queryVehicleSrc(@RequestParam(required = true) String vehicleSrcSid,
            @RequestParam(required = true) String vehicleSrcType) {
        if (StringUtils.isNotBlank(vehicleSrcSid) && StringUtils.isNotBlank(vehicleSrcType)) {
            String vehicleSrc = appointmentUsedcarService.selectVehicleSrc(vehicleSrcSid, vehicleSrcType);
            return vehicleSrc;
        } else {
            return "";
        }
    }
}
