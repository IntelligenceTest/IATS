package com.autostreets.biz.auction.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.DealerEmployeeMapper;
import com.autostreets.biz.auction.model.DealerEmployee;
import com.autostreets.biz.auction.model.DealerEmployeeExample;
import com.autostreets.biz.auction.service.DealerEmployeeService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("dealerEmployeeService")
public class DealerEmployeeServiceImpl extends GenericServiceImpl<DealerEmployee, DealerEmployeeExample, Integer>
        implements DealerEmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DealerEmployeeServiceImpl.class);

    @Autowired
    private DealerEmployeeMapper dealerEmployeeMapper;

    @Override
    protected GenericMapper<DealerEmployee, DealerEmployeeExample, Integer> getGenericMapper() {
        return dealerEmployeeMapper;
    }

	@Override
	public Pagination selectEmployeeByPage(Pagination pagination,
			DealerEmployee employee) {
		Pagination pageResult=employee.getPagination();
		if(employee!=null){
		if(employee.getPagination()==null){
			employee.setPagination(new Pagination());
		}
		}
		int count = selectEmployeeCount(employee);
		pageResult.setCount(count);
		List<DealerEmployee> employeeList = selectEmployeeList(employee);
		
		pageResult.setDataList(employeeList);
		return pageResult;
	}

        
	private List<DealerEmployee> selectEmployeeList(DealerEmployee employee) {
		List<DealerEmployee> employeeList=dealerEmployeeMapper.selectEmployeeList(employee);	
		return employeeList;
	}

    private int selectEmployeeCount(DealerEmployee employee) {
        // TODO Auto-generated method stub
        return dealerEmployeeMapper.selectEmployeeCount(employee);
    }


    @Override
    public Boolean editEmployee(DealerEmployee dealerEmployee) {
        int num=dealerEmployeeMapper.updateByPrimaryKeySelective(dealerEmployee);
        return num>0;
    }


    @Override
    public Boolean updateEmployeeStatusById(Integer id) {
        DealerEmployee employee = new DealerEmployee();
        employee.setId(id);
        employee.setDelFlag(true);
        int num = dealerEmployeeMapper.updateByPrimaryKeySelective(employee);
        return num > 0;

    }

    @Override
    public Boolean stopEmployeeById(Integer id) {
        // TODO Auto-generated method stub
       int num= dealerEmployeeMapper.updateEmployeeToStop(id);
       return num>0;
    }

    @Override
    public Boolean openEmployeeById(Integer id) {
       int num= dealerEmployeeMapper.updateEmployeeToOpen(id);
       return num>0;
    }
    @Override
    public Boolean addEmployeeInfo(DealerEmployee dealerEmployee) {
    	int count = 0;
    	if(dealerEmployee!=null &&dealerEmployee.getOrgId()!=null&& dealerEmployee.getGroupId()!=null&&dealerEmployee.getCreatedBy()!=null ){
    		 dealerEmployee.setEmployeeNo(dealerEmployeeMapper.selectEmployeeNo(dealerEmployee.getOrgId()));
    		 count = dealerEmployeeMapper.insertSelective(dealerEmployee);
    	}
    	 return count > 0;
    }

    @Override
    public List<DealerEmployee> getEmployeeByOrgIdAndType(List<Integer> orgIds, Integer type) {
        Map<String, Object> param = new HashMap<>();
        param.put("orgIds", orgIds);
        param.put("type", type);
        return dealerEmployeeMapper.getEmployeeByOrgIdAndType(param);
    }

}
