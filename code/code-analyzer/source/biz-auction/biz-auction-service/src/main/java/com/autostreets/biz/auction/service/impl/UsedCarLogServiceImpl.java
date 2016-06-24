package com.autostreets.biz.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.UsedCarLogMapper;
import com.autostreets.biz.auction.model.UsedCarLog;
import com.autostreets.biz.auction.model.UsedCarLogExample;
import com.autostreets.biz.auction.service.UsedCarLogService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("usedCarLogService")
public class UsedCarLogServiceImpl extends GenericServiceImpl<UsedCarLog, UsedCarLogExample, Integer>
		implements UsedCarLogService {

	@Autowired
	private UsedCarLogMapper usedCarLogMapper;

	@Override
	protected GenericMapper<UsedCarLog, UsedCarLogExample, Integer> getGenericMapper() {
		return usedCarLogMapper;
	}

	@Override
	public List<UsedCarLog> getUsedCarLogs(Integer fixedPriceId) {
		UsedCarLogExample example = new UsedCarLogExample();
		UsedCarLogExample.Criteria criteria = example.createCriteria();
		if (null != fixedPriceId) {
			criteria.andFixedPriceIdEqualTo(fixedPriceId);
		}
		example.setOrderByClause("operation_time desc");
		List<UsedCarLog> list = usedCarLogMapper.selectByExample(example);
		/*
		 * for (UsedCarLog uclog : list) { String prepStatus =
		 * auctionDictionaryService.getNameByCategoryValue("fixed_price_status",
		 * String.valueOf(uclog.getPreUsedCarStatus()));
		 * uclog.setPrepStatusName(prepStatus); String postStatus =
		 * auctionDictionaryService.getNameByCategoryValue("fixed_price_status",
		 * String.valueOf(uclog.getCurrentUsedCarStatus()));
		 * uclog.setPostStatusName(postStatus); }
		 */
		return list;
	}

}
