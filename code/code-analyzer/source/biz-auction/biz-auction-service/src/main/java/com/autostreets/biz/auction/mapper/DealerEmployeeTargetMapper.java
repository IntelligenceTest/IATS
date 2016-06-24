package com.autostreets.biz.auction.mapper;

import java.util.List;

import com.autostreets.biz.auction.model.DealerEmployeeTarget;
import com.autostreets.biz.auction.model.DealerEmployeeTargetExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface DealerEmployeeTargetMapper extends GenericMapper<DealerEmployeeTarget, DealerEmployeeTargetExample, Integer> {

    public List<DealerEmployeeTarget> selectByList(DealerEmployeeTarget dealerEmployeeTarget);

    public Integer countByPage(DealerEmployeeTarget dealerEmployeeTarget);

    public List<Integer> selectExistsYears(Integer orgId);

}
