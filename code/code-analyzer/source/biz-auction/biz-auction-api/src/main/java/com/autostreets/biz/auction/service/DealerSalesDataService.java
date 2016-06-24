package com.autostreets.biz.auction.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.autostreets.biz.auction.model.DealerSalesData;
import com.autostreets.biz.auction.model.DealerSalesDataExample;
import com.autostreets.framework.common.dal.GenericService;
import com.autostreets.framework.common.dal.Pagination;

public interface DealerSalesDataService extends GenericService<DealerSalesData, DealerSalesDataExample, Integer> {

    Pagination selectSalesDataList(Pagination pagination,DealerSalesData dealerSalesData);

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
    public int insertsalesDatas(Map<String, Object> map);

    boolean editSalesData(DealerSalesData dealerSalesData);

    void delSalesData(Integer primaryKey);

    /**
     * 
     * 功能描述: <br>
     * 〈日期唯一〉
     *
     * @param date
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean isNoSameDate(Date date,Integer orgId);

    List<Date> getExsitDateList(List<Date> dates,Integer orgId);
}
