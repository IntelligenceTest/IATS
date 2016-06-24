package com.autostreets.biz.auction.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.HomepageRecommendMapper;
import com.autostreets.biz.auction.mapper.VehicleMapper;
import com.autostreets.biz.auction.model.HomepageRecommend;
import com.autostreets.biz.auction.model.HomepageRecommendExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.service.HomepageRecommendService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("homepageRecommendService")
public class HomepageRecommendServiceImpl extends
		GenericServiceImpl<HomepageRecommend, HomepageRecommendExample, Integer>implements HomepageRecommendService {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(HomepageRecommendServiceImpl.class);

	@Autowired
	private HomepageRecommendMapper homepageRecommendMapper;

	@Autowired
	private VehicleMapper vehicleMapper;

	@Override
	protected GenericMapper<HomepageRecommend, HomepageRecommendExample, Integer> getGenericMapper() {
		return homepageRecommendMapper;
	}

	@Override
	public int countHomepageRecommend(HomepageRecommend homepageRecommend) {
		return homepageRecommendMapper.countHomepageRecommend(homepageRecommend);
	}

	@Override
	public List<HomepageRecommend> findHomepageRecommend(HomepageRecommend homepageRecommend) {
		List<HomepageRecommend> homepageRecommends = homepageRecommendMapper.findHomepageRecommend(homepageRecommend);
		for (HomepageRecommend tempHomepageRecommend : homepageRecommends) {
			Vehicle vehicle = vehicleMapper.selectByPrimaryKey(tempHomepageRecommend.getVehicleId());
			tempHomepageRecommend.setVehicle(vehicle);
		}
		return homepageRecommends;
	}

	@Override
	public Integer countMaxSeqNo() {
		return homepageRecommendMapper.countMaxSeqNo();
	}

	/**
	 * 获取首页推荐的二手车辆列表
	 */
	@Override
	public List<Vehicle> selectRecommendUsedcar(Map<String, Object> params) {
		return homepageRecommendMapper.selectRecommendUsedcar(params);
	}
}
