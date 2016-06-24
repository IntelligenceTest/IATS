package com.autostreets.biz.auction.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.ProcessApplyLogMapper;
import com.autostreets.biz.auction.model.ProcessApplyLog;
import com.autostreets.biz.auction.model.ProcessApplyLogExample;
import com.autostreets.biz.auction.service.ProcessApplyLogService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

@Service("processApplyLogService")
public class ProcessApplyLogServiceImpl extends GenericServiceImpl<ProcessApplyLog, ProcessApplyLogExample, Integer> implements ProcessApplyLogService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessApplyLogServiceImpl.class);
	
	@Autowired
	private ProcessApplyLogMapper processApplyLogMapper;
	
	@Override
	protected GenericMapper<ProcessApplyLog, ProcessApplyLogExample, Integer> getGenericMapper() {
		return processApplyLogMapper;
	}

    @Override
    public ProcessApplyLog addLog(Integer processId, String processInstanceId, Integer processType, Integer keyValue) {
        ProcessApplyLog entity = new ProcessApplyLog();
        entity.setProcessId(processId);
        entity.setProcessInstanceId(processInstanceId);
        entity.setProcessType(processType);
        entity.setKeyValue(keyValue);
        entity.setCreateTime(new Date());
        return insertSelective(entity);
    }

    @Override
    public int addBatchLog(List<ProcessApplyLog> processApplyLogs) {
        return processApplyLogMapper.addBatchLog(processApplyLogs);
    }
}
