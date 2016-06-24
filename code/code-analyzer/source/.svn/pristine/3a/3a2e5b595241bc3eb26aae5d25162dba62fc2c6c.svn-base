package com.autostreets.biz.auction.service;

import java.util.Date;

public interface SchedulerService {
	public boolean registerComputer(String module, String computerName, String[] ips);
	public boolean canRunOnTheCompunter(String module, String computerName);
	public void startInvoke(String module, String computerName, String taskName, Date invokeTime);
	public void completeInvoke(String module, String computerName, String taskName, Date completeTime, boolean success);
	public void disableInvoke(String module);
	public boolean hasRunningTask(String module);
	public boolean enableUniqueInvoke(String module, String computerName);
}
