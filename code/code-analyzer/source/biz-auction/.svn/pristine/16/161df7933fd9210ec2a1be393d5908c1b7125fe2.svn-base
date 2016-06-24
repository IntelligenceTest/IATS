package com.autostreets.biz.auction.service;

import java.util.List;

import com.autostreets.biz.auction.model.DealerGroup;
import com.autostreets.biz.auction.model.DealerGroupExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface DealerGroupService extends GenericService<DealerGroup, DealerGroupExample, Integer> {

    /**
     * 
     * 功能描述: <br>
     * 
     * <pre>
     * 获取门店团队列表
     * </pre>
     *
     * @param dealerGroup
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月5日 上午10:47:11
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<DealerGroup> getGroupList(DealerGroup dealerGroup);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 分页门店团队列表
     * </pre>
     *
     * @param dealerGroup
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月5日 下午3:05:02
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Pagination getGroupsByPage(DealerGroup dealerGroup);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 保存
     * </pre>
     *
     * @param dealerGroup
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月5日 下午3:44:42
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean saveDealerGroup(DealerGroup dealerGroup);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 逻辑删除
     * </pre>
     *
     * @param id
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月6日 上午10:27:54
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean deleteByLogical(Integer id);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 团队员工数量更新
     * </pre>
     *
     * @param groupId
     *            团队ID
     * @param plusOrminus
     *            TRUE:数量+1，FALSE:数量-1
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月6日 下午2:04:20
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Boolean updateEmployeeAmount(Integer groupId, Boolean plusOrminus);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @param dealerGroup
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月9日 下午5:33:23
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<DealerGroup> getByCondition(DealerGroup dealerGroup);

}
