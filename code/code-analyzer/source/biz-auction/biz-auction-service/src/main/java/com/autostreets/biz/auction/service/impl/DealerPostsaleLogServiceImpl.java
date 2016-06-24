package com.autostreets.biz.auction.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.DealerPostsaleLogMapper;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.biz.auction.model.DealerPostsaleLog;
import com.autostreets.biz.auction.model.DealerPostsaleLogExample;
import com.autostreets.biz.auction.service.DealerPostsaleLogService;

@Service("dealerPostsaleLogService")
public class DealerPostsaleLogServiceImpl extends GenericServiceImpl<DealerPostsaleLog, DealerPostsaleLogExample, Integer> implements DealerPostsaleLogService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerPostsaleLogServiceImpl.class);
	
	@Autowired
	private DealerPostsaleLogMapper dealerPostsaleLogMapper;
	
	@Override
	protected GenericMapper<DealerPostsaleLog, DealerPostsaleLogExample, Integer> getGenericMapper() {
		return dealerPostsaleLogMapper;
	}
}
