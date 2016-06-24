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
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.OrderItemExample;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.auction.web.scheduler.AbstractSpringBeanJob;

@Service("auctionEndJob")
public class AuctionEndJob extends AbstractSpringBeanJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionEndJob.class);

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private AuctionDictionaryService dictionaryService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

    @Override
    protected String getModule() {
        return "AuctionEndJob";
    }

    private static ScheduledExecutorService ses = Executors.newScheduledThreadPool(20);

    @Override
    protected void doJob() {
        // 在线拍结束出价后的流程：成交or流拍or成交确认
        autoChangeAVStatus4EndBid();

        // 针对成交确认状态的车辆超过一段时间后，自动转为流拍状态
        autoChangeAVStatus3T4();
        // 针对线上未支付定金订单，超过一段时间后，自动取消订单状态
        autoChangeOrderStatus();
    }

    /**
     * 在线拍结束出价,修改状态
     */
    private void autoChangeAVStatus4EndBid() {
        Date currentDate = new Date();
        Date date = DateUtils.addMinutes(currentDate, 1);

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        List<Integer> auctionTypeList = new ArrayList<Integer>();
        auctionTypeList.add(1);
        auctionTypeList.add(2); // 增加即时拍
        aveCriteria.andAuctionTypeIn(auctionTypeList);

        // aveCriteria.andAuctionTypeEqualTo("1");
        aveCriteria.andStatusEqualTo(5);
        aveCriteria.andLatestEqualTo(true);
        aveCriteria.andEnableEqualTo(true);
        aveCriteria.andPlanEndTimeLessThan(date);

        ave.setOrderByClause("plan_end_time");

        List<AuctionVehicle> avList = auctionVehicleService.selectByExample(ave);
        for (AuctionVehicle av : avList) {
            long delay = av.getPlanEndTime().getTime() - new Date().getTime();
            if (delay < 10L) {
                delay = 10L;
            }

            final AuctionVehicle fav = av;
            ses.schedule(new Runnable() {

                @Override
                public void run() {
                    try {
                        auctionVehicleService.endBid(fav);
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            }, delay, TimeUnit.MILLISECONDS);
        }
    }

    private void autoChangeAVStatus3T4() {
        changeAVStatus_R();
        changeAVStatus_NR();
    }

    /**
     * 有底价在线拍状态变更
     * 
     * @author chunfeng.huang
     */
    private void changeAVStatus_R() {
        // 获取设置的成交确认时间阀值：分钟 (有底价在线拍)
        Integer intDeadTime = dictionaryService.selectStatusChangeTime_R();
        Date currDate = new Date();
        Date newDate = DateUtils.addMinutes(currDate, (-1) * intDeadTime);

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andAuctionTypeEqualTo(1);
        aveCriteria.andStatusEqualTo(3);
        aveCriteria.andAvTypeEqualTo(0);
        aveCriteria.andLatestEqualTo(true);
        aveCriteria.andEnableEqualTo(true);
        aveCriteria.andOnlineEndTimeLessThan(newDate);
        ave.setOrderByClause("online_end_time");

        List<AuctionVehicle> avList = auctionVehicleService.selectByExample(ave);
        for (AuctionVehicle avItem : avList) {
            long delay = newDate.getTime() - avItem.getOnlineEndTime().getTime();
            if (delay > 10L) {
                delay = 10L;
            }
            final AuctionVehicle favItem = avItem;
            ses.schedule(new Runnable() {

                public void run() {
                    try {
                        auctionVehicleService.updateOnlineAVFail(favItem.getId());
                    } catch (Exception ex) {
                        LOGGER.error(ex.getMessage(), ex);
                    }
                }
            }, delay, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * 无底价在线拍状态变更
     * 
     * @author chunfeng.huang
     */
    private void changeAVStatus_NR() {
        // 获取设置的成交确认时间阀值：分钟 (无底价在线拍)
        Integer intDeadTime = dictionaryService.selectStatusChangeTime_NR();
        Date currDate = new Date();
        Date newDate = DateUtils.addMinutes(currDate, (-1) * intDeadTime);

        AuctionVehicleExample ave = new AuctionVehicleExample();
        AuctionVehicleExample.Criteria aveCriteria = ave.createCriteria();
        aveCriteria.andAuctionTypeEqualTo(1);
        aveCriteria.andStatusEqualTo(3);
        aveCriteria.andAvTypeEqualTo(1);
        aveCriteria.andLatestEqualTo(true);
        aveCriteria.andEnableEqualTo(true);
        aveCriteria.andOnlineEndTimeLessThan(newDate);
        ave.setOrderByClause("online_end_time");

        List<AuctionVehicle> avList = auctionVehicleService.selectByExample(ave);
        for (AuctionVehicle avItem : avList) {
            long delay = newDate.getTime() - avItem.getOnlineEndTime().getTime();
            if (delay > 10L) {
                delay = 10L;
            }
            final AuctionVehicle favItem = avItem;
            ses.schedule(new Runnable() {

                public void run() {
                    try {
                        auctionVehicleService.updateOnlineAVFail(favItem.getId());
                    } catch (Exception ex) {
                        LOGGER.error(ex.getMessage(), ex);
                    }
                }
            }, delay, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * 精品二手车未支付订单的状态变更
     * 
     * @author chunfeng.huang
     */
    private void autoChangeOrderStatus() {
        // 获取设置的支付时限：单位分钟
        Integer intPayTime = dictionaryService.selectPayTime();
        Date currDate = new Date();
        Date newDate = DateUtils.addMinutes(currDate, (-1) * intPayTime);

        OrderItemExample oie = new OrderItemExample();
        OrderItemExample.Criteria oieCriteria = oie.createCriteria();
        oieCriteria.andCreatedTimestampLessThan(newDate);
        oieCriteria.andSaleTypeEqualTo(0); // 精品二手车订单
        oieCriteria.andStatusEqualTo(0); // 未支付
        oieCriteria.andEnabledEqualTo(true); // 有效订单

        List<OrderItem> oiList = orderItemService.selectByExample(oie);
        for (OrderItem oiItem : oiList) {
            long delay = newDate.getTime() - oiItem.getCreatedTimestamp().getTime();
            if (delay > 10L) {
                delay = 10L;
            }

            Order oItem = orderService.selectByPrimaryKey(oiItem.getOrderId());
            final Order foItem = oItem;
            ses.schedule(new Runnable() {

                public void run() {
                    try {
                        // 订单状态: 0->3 (未支付 更新为 超时未支付取消)
                        orderService.cancelOrder(foItem.getOrderNo(), null, null, 3);
                        // orderItemService.updateOrderItemStatus(foiItem.getSid(),
                        // (short)0, (short)3);
                    } catch (Exception ex) {
                        LOGGER.error(ex.getMessage(), ex);
                    }
                }
            }, delay, TimeUnit.MILLISECONDS);
        }
    }

}
