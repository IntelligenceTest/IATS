package com.autostreets.biz.auction.service;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.HomepageRecommend;
import com.autostreets.biz.auction.model.HomepageRecommendExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.framework.common.dal.GenericService;

public interface HomepageRecommendService extends GenericService<HomepageRecommend, HomepageRecommendExample, Integer> {

	/**
	 * 计算推荐二手车数量
	 * 
	 * @param homepageRecommend
	 * @return
	 */
	int countHomepageRecommend(HomepageRecommend homepageRecommend);

	/**
	 * 获取推荐二手车
	 * 
	 * @param homepageRecommend
	 * @return
	 */
	List<HomepageRecommend> findHomepageRecommend(HomepageRecommend homepageRecommend);

	/**
	 * 获取最大序列号
	 * 
	 * @return
	 */
	Integer countMaxSeqNo();

	/**
	 * 获取首页推荐的二手车辆列表
	 */
	public List<Vehicle> selectRecommendUsedcar(Map<String, Object> params);
}
