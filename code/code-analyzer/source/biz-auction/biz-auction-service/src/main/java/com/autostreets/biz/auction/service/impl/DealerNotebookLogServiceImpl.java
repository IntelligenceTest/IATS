package com.autostreets.biz.auction.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.DealerNotebookLogMapper;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.biz.auction.model.DealerNotebookLog;
import com.autostreets.biz.auction.model.DealerNotebookLogExample;
import com.autostreets.biz.auction.service.DealerNotebookLogService;

@Service("dealerNotebookLogService")
public class DealerNotebookLogServiceImpl extends GenericServiceImpl<DealerNotebookLog, DealerNotebookLogExample, Integer> implements DealerNotebookLogService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerNotebookLogServiceImpl.class);
	
	@Autowired
	private DealerNotebookLogMapper dealerNotebookLogMapper;
	
	@Override
	protected GenericMapper<DealerNotebookLog, DealerNotebookLogExample, Integer> getGenericMapper() {
		return dealerNotebookLogMapper;
	}
}
