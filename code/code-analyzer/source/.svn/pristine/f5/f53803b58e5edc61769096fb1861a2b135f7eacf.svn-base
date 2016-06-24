package com.autostreets.biz.auction.mapper;

import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.DealerSalesData;
import com.autostreets.biz.auction.model.DealerSalesDataExample;
import com.autostreets.framework.common.dal.GenericMapper;

public interface DealerSalesDataMapper extends GenericMapper<DealerSalesData, DealerSalesDataExample, Integer> {

    /**
     * 
     * 功能描述: <br>
     * 〈销售数据首页〉
     *
     * @param dealerSalesData
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<DealerSalesData> selectSalesDataList(DealerSalesData dealerSalesData);

    public int selectSalesDataCount(DealerSalesData dealerSalesData);

    /**
     * 
     * 功能描述: <br>
     * 〈批量录入功能〉
     *
     * @param map
     *            dataList 数据，使用DealerSalesData包装
     *            orgId 门店ID
     *            userId 用户ID
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int addNewSalesDatas(Map<String, Object> map);

}