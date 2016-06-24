package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.AppointmentUsedcar;
import com.autostreets.biz.auction.model.AppointmentUsedcarExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface AppointmentUsedcarMapper
		extends GenericMapper<AppointmentUsedcar, AppointmentUsedcarExample, Integer> {

	/**
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> selectByMap(Map<String, Object> params);

	/**
	 * @param appointmentUsedcarExample
	 * @return
	 */
	int selectAppointmentUsedcarCount(AppointmentUsedcarExample appointmentUsedcarExample);

	/**
	 * @param appointmentUsedcarExample
	 * @return
	 */
	List<AppointmentUsedcar> selectAppointmentUsedcar(AppointmentUsedcarExample appointmentUsedcarExample);

}