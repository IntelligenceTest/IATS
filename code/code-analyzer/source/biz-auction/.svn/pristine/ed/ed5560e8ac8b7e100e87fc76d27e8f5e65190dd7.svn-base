package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.DealerEmployee;
import com.autostreets.biz.auction.model.DealerEmployeeExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface DealerEmployeeMapper extends GenericMapper<DealerEmployee, DealerEmployeeExample, Integer> {

    public int selectEmployeeTotal(DealerEmployee employee);

    public List<DealerEmployee> selectEmployee(DealerEmployee employee);

    public int selectEmployeeCount(DealerEmployee employee);

    public List<DealerEmployee> selectEmployeeList(DealerEmployee employee);

    // public void deleteById(Integer employeId);

    public void updateEmployee(DealerEmployee dealerEmployee);

    public int updateEmployeeInfoById(DealerEmployee employee);

    public int updateEmployeeToStop(Integer employeId);

    public Integer selectEmployeeNo(Integer orgId);

    public List<DealerEmployee> getEmployeeByOrgIdAndType(Map<String, Object> param);

	public int updateEmployeeToOpen(Integer id);

}
