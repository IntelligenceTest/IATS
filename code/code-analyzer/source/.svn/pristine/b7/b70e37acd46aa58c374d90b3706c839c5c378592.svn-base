package com.autostreets.biz.auction.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.DealerGroupMapper;
import com.autostreets.biz.auction.model.DealerGroup;
import com.autostreets.biz.auction.model.DealerGroupExample;
import com.autostreets.biz.auction.service.DealerGroupService;
import com.autostreets.biz.cms.utils.IntegerUtils;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("dealerGroupService")
public class DealerGroupServiceImpl extends GenericServiceImpl<DealerGroup, DealerGroupExample, Integer> implements DealerGroupService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DealerGroupServiceImpl.class);
	
	@Autowired
	private DealerGroupMapper dealerGroupMapper;
	
	@Override
	protected GenericMapper<DealerGroup, DealerGroupExample, Integer> getGenericMapper() {
		return dealerGroupMapper;
	}

    @Override
    public List<DealerGroup> getGroupList(DealerGroup dealerGroup) {
        return dealerGroupMapper.selectGroupList(dealerGroup);
    }

    @Override
    public Pagination getGroupsByPage(DealerGroup dealerGroup) {
        if (dealerGroup != null) {
            if (dealerGroup.getPagination() == null) {
                dealerGroup.setPagination(new Pagination());
            }
            dealerGroup.getPagination().setCount(dealerGroupMapper.countGroups(dealerGroup));
            dealerGroup.getPagination().setDataList(getGroupList(dealerGroup));
        }
        return dealerGroup.getPagination();
    }

    @Override
    public Boolean saveDealerGroup(DealerGroup dealerGroup) {
        if (dealerGroup != null && dealerGroup.getOrgId() != null && dealerGroup.getCreatedBy() != null) {
            // 修改
            if (dealerGroup.getId() == null) {
                dealerGroup.setEmployeeAmount(0);
                dealerGroup.setGroupNo(dealerGroupMapper.selectNextGroupNo(dealerGroup.getOrgId()));
                dealerGroup.setCreateTime(new Date());
                insertSelective(dealerGroup);
            } else {
                // 防止员工数量被修改
                dealerGroup.setEmployeeAmount(null);
                updateByPrimaryKeySelective(dealerGroup);
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteByLogical(Integer id) {
        DealerGroup entity = new DealerGroup();
        entity.setId(id);
        entity.setDelFlag(Boolean.TRUE);
        int affected = updateByPrimaryKeySelective(entity);
        return affected == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean updateEmployeeAmount(Integer groupId, Boolean plusOrminus) {
        DealerGroup dealerGroup = selectByPrimaryKey(groupId);
        if (dealerGroup != null && !dealerGroup.getDelFlag()) {
            DealerGroup entity = new DealerGroup();
            entity.setEmployeeAmount(
                    IntegerUtils.defaultValue(dealerGroup.getEmployeeAmount()) + (plusOrminus ? 1 : -1));
            DealerGroupExample example = new DealerGroupExample();
            DealerGroupExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(dealerGroup.getId());
            criteria.andEmployeeAmountEqualTo(dealerGroup.getEmployeeAmount());
            int affected = updateByExampleSelective(entity, example);
            return affected == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<DealerGroup> getByCondition(DealerGroup dealerGroup) {
        DealerGroupExample example = new DealerGroupExample();
        DealerGroupExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(false);
        if(dealerGroup!=null){
            if(dealerGroup.getType()!=null){
                criteria.andTypeEqualTo(dealerGroup.getType());
            }
            if (dealerGroup.getOrgId() != null) {
                criteria.andOrgIdEqualTo(dealerGroup.getOrgId());
            }
        }
        return selectByExample(example);
    }

}
