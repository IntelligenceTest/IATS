package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.DealerEmployee;
import com.autostreets.biz.auction.model.DealerEmployeeExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface DealerEmployeeService extends GenericService<DealerEmployee, DealerEmployeeExample, Integer> {

	

    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 获取员工列表
     * </pre>
     *
     * @param employee
     * @return
     * @author dongjing.liu
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	
    public Pagination selectEmployeeByPage(Pagination pagination, DealerEmployee employee);

    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 编辑员工
     * </pre>
     * @param dealerEmployee
     * @return
     * @author dongjing.liu
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Boolean editEmployee(DealerEmployee dealerEmployee);

    
    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 逻辑删除员工
     * </pre>
     * @param id
     * @return
     * @author dongjing.liu
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Boolean updateEmployeeStatusById(Integer id);
    
    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 停用员工
     * </pre>
     * @param id
     * @return
     * @author dongjing.liu
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Boolean stopEmployeeById(Integer id);
   
    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 启用员工
     * </pre>
     * @param id
     * @return
     * @author dongjing.liu
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Boolean openEmployeeById(Integer id);
    
    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 新增员工
     * </pre>
     * @param dealerEmployee
     * @return
     * @author dongjing.liu
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Boolean addEmployeeInfo(DealerEmployee dealerEmployee);

    public List<DealerEmployee> getEmployeeByOrgIdAndType(List<Integer> orgIds, Integer type);
}
