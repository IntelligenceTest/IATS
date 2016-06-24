package com.autostreets.biz.auction.service;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.AppointmentUsedcar;
import com.autostreets.biz.auction.model.AppointmentUsedcarExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface AppointmentUsedcarService
		extends GenericService<AppointmentUsedcar, AppointmentUsedcarExample, Integer> {

	Pagination selectAppointmentUsedcarWithPage(Pagination pagination, AppointmentUsedcar appointmentUsedcar);

	String selectVehicleSrc(String vehicleSrcSid, String vehicleSrcType);

	public List<Map<String, Object>> selectByMap(Map<String, Object> params);

	public Pagination selectAppointmentUsedcarByOrgIdWithPage(Pagination pagination,
			AppointmentUsedcar appointmentUsedcar, String orgId);
}
