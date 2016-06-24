package com.autostreets.biz.auction.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.config.AppConfig;
import com.autostreets.biz.auction.service.SchedulerService;
import com.google.common.base.Joiner;

@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService {

	private final static Logger LOGGER = LoggerFactory.getLogger(SchedulerServiceImpl.class);

	@Autowired
	private AppConfig appConfig;

	private JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(appConfig.getDriverClassName());
		dataSource.setUrl(appConfig.getUrl());
		dataSource.setUsername(appConfig.getUsername());
		dataSource.setPassword(appConfig.getPassword());

		return new JdbcTemplate(dataSource);
	}

	@Override
	public boolean canRunOnTheCompunter(String module, String computerName) {
		try {
			LOGGER.info("canRunOnTheCompunter start");

			JdbcTemplate jdbcTemplate = getJdbcTemplate();

			String sql = "select id from task_scheduler where module_name = ? and hostname = ? and enabled = ?";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[] { module, computerName, 1 });

			return !list.isEmpty();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return false;
		}
	}

	@Override
	public void completeInvoke(String module, String computerName, String taskName, Date completeTime,
			boolean success) {
	}

	@Override
	public void disableInvoke(String module) {
	}

	@Override
	public boolean enableUniqueInvoke(String module, String computerName) {
		return false;
	}

	@Override
	public boolean hasRunningTask(String module) {
		return false;
	}

	@Override
	public boolean registerComputer(String module, String computerName, String[] ips) {
		try {
			JdbcTemplate jdbcTemplate = getJdbcTemplate();
			LOGGER.error("-------------插入ip：" + JSON.toJSON(ips));
			String sql = "select id from task_scheduler where module_name = ? and hostname = ?";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[] { module, computerName });
			if (list.isEmpty()) {
				sql = "insert into task_scheduler (module_name, hostname, ip_address, enabled, created_at, updated_at) values (?, ?, ?, ?, ?, ?)";
				LOGGER.error("-------------插入sql：" + sql);
				LOGGER.error("-------------插入sql paramters：{" + module + "," + computerName + "," + JSON.toJSON(ips)
						+ "," + 0 + "new Date(),new Date()" + "}");
				jdbcTemplate.update(sql,
						new Object[] { module, computerName, Joiner.on(",").join(ips), 0, new Date(), new Date() });
			}
			LOGGER.error("-------------插入ip：" + JSON.toJSON(ips) + "成功");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.error("-------------插入ip：" + JSON.toJSON(ips) + "失败");
			return false;
		}

		return true;
	}

	@Override
	public void startInvoke(String module, String computerName, String taskName, Date invokeTime) {
	}
}
