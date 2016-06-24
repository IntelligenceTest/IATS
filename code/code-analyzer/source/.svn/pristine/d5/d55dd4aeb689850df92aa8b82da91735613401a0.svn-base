package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.DealerEmployeeTarget;
import com.autostreets.biz.auction.model.DealerEmployeeTargetExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface DealerEmployeeTargetService extends GenericService<DealerEmployeeTarget, DealerEmployeeTargetExample, Integer> {

    public Pagination getByPage(DealerEmployeeTarget dealerEmployeeTarget);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @param dealerEmployeeTarget
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月9日 下午2:47:41
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<DealerEmployeeTarget> selectByCondition(DealerEmployeeTarget dealerEmployeeTarget);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @param orgId
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月9日 下午5:22:04
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Integer> selectExistsYears(Integer orgId);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @param dealerEmployeeTargets
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月10日 下午2:06:44
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Boolean save(List<DealerEmployeeTarget> dealerEmployeeTargets, Integer createdBy);

}
