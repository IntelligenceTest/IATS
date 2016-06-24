package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.HomepageRecommend;
import com.autostreets.biz.auction.model.HomepageRecommendExample;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.framework.common.dal.GenericMapper;

public interface HomepageRecommendMapper extends GenericMapper<HomepageRecommend, HomepageRecommendExample, Integer> {

	/**
	 * @param homepageRecommend
	 * @return
	 */
	List<HomepageRecommend> findHomepageRecommend(HomepageRecommend homepageRecommend);

	/**
	 * @param homepageRecommend
	 * @return
	 */
	int countHomepageRecommend(HomepageRecommend homepageRecommend);

	/**
	 * @return
	 */
	Integer countMaxSeqNo();

	/**
	 * @param params
	 * @return
	 */
	List<Vehicle> selectRecommendUsedcar(Map<String, Object> params);
}