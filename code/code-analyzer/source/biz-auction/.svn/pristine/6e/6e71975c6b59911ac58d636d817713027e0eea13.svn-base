package com.autostreets.biz.auction.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.DealerSalesDataMapper;
import com.autostreets.biz.auction.model.DealerSalesData;
import com.autostreets.biz.auction.model.DealerSalesDataExample;
import com.autostreets.biz.auction.service.DealerSalesDataService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;
import com.autostreets.framework.common.dal.Pagination;

@Service("dealerSalesDataService")
public class DealerSalesDataServiceImpl extends GenericServiceImpl<DealerSalesData, DealerSalesDataExample, Integer>
        implements DealerSalesDataService {
    private final static Logger LOGGER = LoggerFactory.getLogger(DealerSalesDataServiceImpl.class);

    @Autowired
    private DealerSalesDataMapper dealerSalesDataMapper;

    @Override
    protected GenericMapper<DealerSalesData, DealerSalesDataExample, Integer> getGenericMapper() {
        return dealerSalesDataMapper;
    }

    @Override
    public Pagination selectSalesDataList(Pagination pagination, DealerSalesData dealerSalesData) {
    	int count = dealerSalesDataMapper.selectSalesDataCount(dealerSalesData);
    	if(pagination.getBegin() >= count) {
    		dealerSalesData.setPagination(pagination);
    		return pagination;
    	}
        pagination.setCount(count);
        dealerSalesData.setPagination(pagination);
        pagination.setDataList(dealerSalesDataMapper.selectSalesDataList(dealerSalesData));
        return pagination;
    }

    @Override
    public int insertsalesDatas(Map<String, Object> map) {
        int count = 0;//插入数量
        try{
           count = dealerSalesDataMapper.addNewSalesDatas(map);
        }catch(Exception e){
            throw e;
        }
        return count;
    }
    
    @Override
    public boolean editSalesData(DealerSalesData dealerSalesData) {
        if(null == dealerSalesData || dealerSalesData.getId() == null){
            return false;
        }
        dealerSalesData.setModifyTime(new Date());
        dealerSalesDataMapper.updateByPrimaryKeySelective(dealerSalesData);
        return true;
    }
    
    /**
     * 执行物理删除的原因是
     * UNIQUE KEY `sale_date` (`sale_date`)
     */
    @Override
    public void delSalesData(Integer primaryKey) {
        dealerSalesDataMapper.deleteByPrimaryKey(primaryKey);
    }
    
    @Override
    public boolean isNoSameDate(Date date,Integer orgId) {
        if(date == null||orgId == null){
            LOGGER.warn("入参异常");
            return false;
        }
        DealerSalesDataExample ex = new DealerSalesDataExample();
        DealerSalesDataExample.Criteria criteria = ex.createCriteria();
        criteria.andSaleDateEqualTo(date);
        criteria.andOrgIdEqualTo(orgId);
        int count = countByExample(ex);
        if(count>0){
            return false;
        }
    return true;
}

    @Override
    public List<Date> getExsitDateList(List<Date> dates,Integer orgId) {
        if(dates == null || dates.size() == 0){
            return null;
        }
        DealerSalesDataExample ex = new DealerSalesDataExample();
        DealerSalesDataExample.Criteria criteria = ex.createCriteria();
        criteria.andSaleDateIn(dates);
        criteria.andOrgIdEqualTo(orgId);
        List<DealerSalesData> list = selectByExample(ex); 
        if(list.size() == 0){
            return null;
        }else{
            List<Date> dateList = new ArrayList<Date>();
            for (DealerSalesData dealerSalesData : list) {
                dateList.add(dealerSalesData.getSaleDate());
                }
            return dateList;
        }
    }

}
