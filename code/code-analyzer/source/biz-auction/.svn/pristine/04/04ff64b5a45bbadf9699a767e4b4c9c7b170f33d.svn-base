package com.autostreets.biz.auction.web.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.model.AuctionVehicle;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.web.scheduler.AbstractSpringBeanJob;

@Service("auctionStartJob")
public class AuctionStartJob extends AbstractSpringBeanJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionStartJob.class);
    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Override
    protected String getModule() {
        return "AuctionStartJob";
    }

    private static ScheduledExecutorService ses = Executors.newScheduledThreadPool(20);

    @Override
    protected void doJob() {
        Date currentDate = new Date();
        Date date = DateUtils.addMinutes(currentDate, 1);

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        List<Integer> auctionTypeList = new ArrayList<Integer>();
        auctionTypeList.add(1);
        auctionTypeList.add(2); // 增加即时拍
        aveCriteria.andAuctionTypeIn(auctionTypeList);
        aveCriteria.andStatusEqualTo(1);
        aveCriteria.andPlanStartTimeLessThan(date);

        ave.setOrderByClause("plan_start_time");

        List<AuctionVehicle> avList = auctionVehicleService.selectByExample(ave);
        for (AuctionVehicle av : avList) {
            long delay = av.getPlanStartTime().getTime() - new Date().getTime();
            if (delay < 10L) {
                delay = 10L;
            }

            final AuctionVehicle fav = av;
            ses.schedule(new Runnable() {

                @Override
                public void run() {
                    try {
                        AuctionVehicle avEntity = new AuctionVehicle();
                        avEntity.setStatus(5);
                        avEntity.setOnlineEndTime(fav.getPlanEndTime());

                        AuctionVehicleExample ave = new AuctionVehicleExample();
                        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
                        aveCriteria.andIdEqualTo(fav.getId());
                        aveCriteria.andStatusEqualTo(fav.getStatus());

                        auctionVehicleService.updateByExampleSelective(avEntity, ave);
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            }, delay, TimeUnit.MILLISECONDS);
        }
    }
}
