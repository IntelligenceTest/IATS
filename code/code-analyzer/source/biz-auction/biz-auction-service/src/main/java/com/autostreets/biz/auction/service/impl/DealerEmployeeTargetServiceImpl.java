package com.autostreets.biz.auction.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.autostreets.biz.auction.mapper.DealerEmployeeTargetMapper;
import com.autostreets.biz.auction.model.DealerEmployee;
import com.autostreets.biz.auction.model.DealerEmployeeTarget;
import com.autostreets.biz.auction.model.DealerEmployeeTargetExample;
import com.autostreets.biz.auction.service.DealerEmployeeService;
import com.autostreets.biz.auction.service.DealerEmployeeTargetService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("dealerEmployeeTargetService")
public class DealerEmployeeTargetServiceImpl extends GenericServiceImpl<DealerEmployeeTarget, DealerEmployeeTargetExample, Integer> implements DealerEmployeeTargetService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerEmployeeTargetServiceImpl.class);
	
	@Autowired
	private DealerEmployeeTargetMapper dealerEmployeeTargetMapper;
	
    @Autowired
    private DealerEmployeeService dealerEmployeeService;

	@Override
	protected GenericMapper<DealerEmployeeTarget, DealerEmployeeTargetExample, Integer> getGenericMapper() {
		return dealerEmployeeTargetMapper;
	}

    @Override
    public Pagination getByPage(DealerEmployeeTarget dealerEmployeeTarget) {
        if (dealerEmployeeTarget != null) {
            Pagination pagination = dealerEmployeeTarget.getPagination();
            if (pagination == null) {
                pagination = new Pagination();
                dealerEmployeeTarget.setPagination(pagination);
            }
            pagination.setCount(dealerEmployeeTargetMapper.countByPage(dealerEmployeeTarget));
            pagination.setDataList(dealerEmployeeTargetMapper.selectByList(dealerEmployeeTarget));
            return pagination;
        }
        return null;
    }

    @Override
    public List<DealerEmployeeTarget> selectByCondition(DealerEmployeeTarget dealerEmployeeTarget) {
        if (dealerEmployeeTarget != null) {
            DealerEmployeeTargetExample example = new DealerEmployeeTargetExample();
            DealerEmployeeTargetExample.Criteria criteria = example.createCriteria();
            if (dealerEmployeeTarget.getYear() != null) {
                criteria.andYearEqualTo(dealerEmployeeTarget.getYear());
            }
            if (dealerEmployeeTarget.getMonth() != null) {
                criteria.andMonthEqualTo(dealerEmployeeTarget.getMonth());
            }
            if (dealerEmployeeTarget.getEmployeeId() != null) {
                criteria.andEmployeeIdEqualTo(dealerEmployeeTarget.getEmployeeId());
            }
            if (dealerEmployeeTarget.getDelFlag() != null) {
                criteria.andDelFlagEqualTo(dealerEmployeeTarget.getDelFlag());
            }
            return selectByExample(example);
        }
        return null;
    }

    @Override
    public List<Integer> selectExistsYears(Integer orgId) {
        return dealerEmployeeTargetMapper.selectExistsYears(orgId);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Boolean save(List<DealerEmployeeTarget> dealerEmployeeTargets, Integer createdBy) {
        if (!CollectionUtils.isEmpty(dealerEmployeeTargets)) {
            Date current = new Date();
            for (DealerEmployeeTarget dealerEmployeeTarget : dealerEmployeeTargets) {
                // 查询指标是否存在，存在则更新不存在插入新纪录
                dealerEmployeeTarget.setDelFlag(false);
                List<DealerEmployeeTarget> existsTargets = selectByCondition(dealerEmployeeTarget);
                if (!CollectionUtils.isEmpty(existsTargets)) {
                    DealerEmployeeTarget entity = existsTargets.get(0);
                    entity.setTargetNumber(dealerEmployeeTarget.getTargetNumber());
                    entity.setTargetProfit(dealerEmployeeTarget.getTargetProfit());
                    entity.setModifyTime(current);
                    updateByPrimaryKeySelective(entity);
                } else {
                    // 查询出员工
                    DealerEmployee dealerEmployee = dealerEmployeeService
                            .selectByPrimaryKey(dealerEmployeeTarget.getEmployeeId());
                    if (dealerEmployee != null) {
                        dealerEmployeeTarget.setOrgId(dealerEmployee.getOrgId());
                        dealerEmployeeTarget.setGroupId(dealerEmployee.getGroupId());
                        dealerEmployeeTarget.setCreatedBy(createdBy);
                        dealerEmployeeTarget.setCreateTime(current);
                        dealerEmployeeTarget.setModifyTime(current);
                        insertSelective(dealerEmployeeTarget);
                    }
                }
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
