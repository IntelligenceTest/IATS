package com.autostreets.biz.auction.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.DealerSaleLogMapper;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.biz.auction.model.DealerSaleLog;
import com.autostreets.biz.auction.model.DealerSaleLogExample;
import com.autostreets.biz.auction.service.DealerSaleLogService;

@Service("dealerSaleLogService")
public class DealerSaleLogServiceImpl extends GenericServiceImpl<DealerSaleLog, DealerSaleLogExample, Integer> implements DealerSaleLogService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerSaleLogServiceImpl.class);
	
	@Autowired
	private DealerSaleLogMapper dealerSaleLogMapper;
	
	@Override
	protected GenericMapper<DealerSaleLog, DealerSaleLogExample, Integer> getGenericMapper() {
		return dealerSaleLogMapper;
	}
}
