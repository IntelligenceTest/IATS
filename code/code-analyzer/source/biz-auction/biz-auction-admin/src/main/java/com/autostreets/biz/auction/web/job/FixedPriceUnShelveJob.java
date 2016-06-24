package com.autostreets.biz.auction.web.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Controller;

import com.autostreets.biz.auction.constants.GlobalConstants;
import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;

/**
 * 
 * 一口价定时查询处理上架一个月以上的展品，将其下架
 *
 * @author wwy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class FixedPriceUnShelveJob extends QuartzJobBean {

    @Autowired
    private FixedPriceService fixedPriceService;

    @Autowired
    private VehicleService vehicleService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedPriceUnShelveJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // 获取JobExecutionContext中的service对象
        SchedulerContext skedCtx = null;
        try {
            skedCtx = context.getScheduler().getContext();
        } catch (SchedulerException e) {
            LOGGER.error(e.getMessage(), e);
        }
        // 获取SchedulerContext中的service
        // 这里的service就是通过配置文件 配置的
        fixedPriceService = (FixedPriceService) skedCtx.get("fixedPriceService");
        vehicleService = (VehicleService) skedCtx.get("auctVehicleService");

        List<FixedPrice> fixedPriceList = fixedPriceService.queryExpirationFixedPrice();
        int count = 0;

        try {
            for (FixedPrice fixedPriceTemp : fixedPriceList) {
                if (fixedPriceTemp.getStatus().equals(3)) {
                    VehicleInfo vehicle = vehicleService.selectVehicleInfoById(fixedPriceTemp.getVehicleId());
                    // 验证车辆销售状态
                    if (null != vehicle && vehicle.getSaleStatus() != null
                            && Integer.valueOf(vehicle.getSaleStatus()).equals(1)) {
                        // 将拍品状态改为已下架
//                    fixedPriceTemp.setStatus(1);
//                    fixedPriceTemp.setOffShelvesRemark("上架已过有效期，自动下架");
//                    int falg = fixedPriceService.updateByPrimaryKeySelective(fixedPriceTemp);
                        if (fixedPriceService.updateFixedPriceStatus(fixedPriceTemp.getId(), vehicle.getId(),
                                fixedPriceTemp.getStatus(), GlobalConstants.FIXED_PRICE_STATUS_OFF, "上架已过有效期，自动下架")) {
                            count++;
                        }
                        // 更新车辆销售状态为待售
                        // if
                        // (!fixedPriceService.updateVehicleSaleStatusEQS(vehicle.getId(),
                        // "0", null)) {
                        // LOGGER.info("上架展品超过时限下架:展品id" + fixedPriceTemp.getId() +
                        // "更新车辆销售状态失败");
                        // } else {
                        // LOGGER.info("上架展品超过时限下架:展品id" + fixedPriceTemp.getId() +
                        // "成功");
                        // }
                    } else {
                        LOGGER.info("上架展品超过时限下架:展品sid" + fixedPriceTemp.getId() + "失败（车辆销售状态不正确）");
                    }
                } else {
                    LOGGER.info("上架展品超过时限下架:展品sid" + fixedPriceTemp.getId() + "失败（展品状态不正确）");
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        LOGGER.info("上架展品超过时限下架结束共下架" + count + "辆展品");
    }

}
