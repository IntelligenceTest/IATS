package com.autostreets.biz.auction.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.AppointmentUsedcarMapper;
import com.autostreets.biz.auction.model.AppointmentUsedcar;
import com.autostreets.biz.auction.model.AppointmentUsedcarExample;
import com.autostreets.biz.auction.service.AppointmentUsedcarService;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.model.Member;
import com.autostreets.service.MemberService;

@Service("appointmentUsedcarService")
public class AppointmentUsedcarServiceImpl extends
		GenericServiceImpl<AppointmentUsedcar, AppointmentUsedcarExample, Integer>implements AppointmentUsedcarService {

	@Autowired
	private AppointmentUsedcarMapper appointmentUsedcarMapper;

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private MemberService memberService;

	@Override
	protected GenericMapper<AppointmentUsedcar, AppointmentUsedcarExample, Integer> getGenericMapper() {
		return appointmentUsedcarMapper;
	}

	@Override
	public Pagination selectAppointmentUsedcarWithPage(Pagination pagination, AppointmentUsedcar appointmentUsedcar) {
		AppointmentUsedcarExample appointmentUsedcarExample = new AppointmentUsedcarExample();
		AppointmentUsedcarExample.Criteria criteria = appointmentUsedcarExample.createCriteria();

		if (null != appointmentUsedcar.getStartTime()) {
			criteria.andCreateTimeGreaterThanOrEqualTo(appointmentUsedcar.getStartTime());
		}
		if (null != appointmentUsedcar.getEndTime()) {
			criteria.andCreateTimeLessThanOrEqualTo(appointmentUsedcar.getEndTime());
		}

		int count = appointmentUsedcarMapper.countByExample(appointmentUsedcarExample);
		pagination.setCount(count);
		appointmentUsedcarExample.setOrderByClause("create_time desc");// 按时间倒序排列
		appointmentUsedcarExample.setPagination(pagination);
		List<AppointmentUsedcar> appointmentUsedcarList = appointmentUsedcarMapper
				.selectByExample(appointmentUsedcarExample);
		pagination.setDataList(appointmentUsedcarList);
		return pagination;
	}

	@Override
	public String selectVehicleSrc(String vehicleSrcSid, String vehicleSrcType) {

		if (vehicleSrcType.equals("1")) {
			Organization o = organizationService.selectByPrimaryKey(Integer.parseInt(vehicleSrcSid));
            return o != null ? o.getOrgName() : null;
		} else if (vehicleSrcType.equals("2") || vehicleSrcType.equals("3")) {
            if (StringUtils.isNotEmpty(vehicleSrcSid)) {
                Member m = memberService.selectByPrimaryKey(vehicleSrcSid);
                if (m != null) {
                    return m.getName() == null ? "" : m.getName();
                }
            }
        }
        return null;
	}

	@Override
	public List<Map<String, Object>> selectByMap(Map<String, Object> params) {
		return appointmentUsedcarMapper.selectByMap(params);
	}

	@Override
	public Pagination selectAppointmentUsedcarByOrgIdWithPage(Pagination pagination,
			AppointmentUsedcar appointmentUsedcar, String orgId) {
		AppointmentUsedcarExample appointmentUsedcarExample = new AppointmentUsedcarExample();
		appointmentUsedcarExample.setOrganId(orgId);
		if (null != appointmentUsedcar.getStartTime()) {
			appointmentUsedcarExample.setStartTime(appointmentUsedcar.getStartTime());
		}
		if (null != appointmentUsedcar.getEndTime()) {
			appointmentUsedcarExample.setEndTime(appointmentUsedcar.getEndTime());
		}
		int count = appointmentUsedcarMapper.selectAppointmentUsedcarCount(appointmentUsedcarExample);
		pagination.setCount(count);
		appointmentUsedcarExample.setPagination(pagination);
		List<AppointmentUsedcar> appointmentUsedcars = appointmentUsedcarMapper
				.selectAppointmentUsedcar(appointmentUsedcarExample);
		pagination.setDataList(appointmentUsedcars);
		return pagination;
	}

}
