package com.autostreets.biz.auction.mapper;

import java.util.List;

import com.autostreets.biz.auction.model.DealerGroup;
import com.autostreets.biz.auction.model.DealerGroupExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface DealerGroupMapper extends GenericMapper<DealerGroup, DealerGroupExample, Integer> {

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
     * @datetime 2016年5月5日 下午1:25:00
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<DealerGroup> selectGroupList(DealerGroup dealerGroup);

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
     * @datetime 2016年5月5日 下午3:11:51
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer countGroups(DealerGroup dealerGroup);

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年5月5日 下午3:50:17
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer selectNextGroupNo(Integer orgId);

}
