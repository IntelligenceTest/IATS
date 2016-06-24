package com.autostreets.biz.auction.web.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.service.SchedulerService;

public abstract class AbstractSpringBeanJob implements InitializingBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractSpringBeanJob.class);

    @Autowired
    private SchedulerService schedulerService;

    public void run() {
        if (schedulerService.canRunOnTheCompunter(getModule(), SchedulerUtils.getLocalHostName())) {
            LOGGER.error("-------------" + JSON.toJSONString(SchedulerUtils.getLocalHostIps()) + "----"
                    + SchedulerUtils.getLocalHostName() + "run");
            schedulerService.startInvoke(getModule(), SchedulerUtils.getLocalHostName(), getTaskName(), new Date());
            try {
                doJob();
                schedulerService.completeInvoke(getModule(), SchedulerUtils.getLocalHostName(), getTaskName(),
                        new Date(), true);
            } catch (Exception e) {
                schedulerService.completeInvoke(getModule(), SchedulerUtils.getLocalHostName(), getTaskName(),
                        new Date(), false);
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    abstract protected String getModule();

    protected String getTaskName() {
        return this.getClass().getSimpleName() + ".doJob()";
    }

    abstract protected void doJob();

    @Override
    public void afterPropertiesSet() throws Exception {
        // 注册本机
        // catch住异常，可能bean初始化时数据库没启动，注册失败不应该导致bean的初始化失败
        try {
            schedulerService.registerComputer(getModule(), SchedulerUtils.getLocalHostName(),
                    SchedulerUtils.getLocalHostIps());
        } catch (Exception e) {
            LOGGER.warn("registerComputer fail", e);
        }
    }
}
