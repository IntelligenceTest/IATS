/*
 * Copyright (C), 2014-2016, 上海澍勋电子商务有限公司
 * FileName: SetCache.java
 * Author:   wwy
 * Date:     2016年3月1日 上午11:06:37
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.autostreets.biz.auction.service.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.mapper.AuctionDictionaryMapper;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionDictionaryExample;
import com.autostreets.biz.auction.test.BaseDubboTest;
import com.autostreets.cache.CacheService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author wwy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SetCache extends BaseDubboTest {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private AuctionDictionaryMapper auctionDictionaryMapper;

    @Test
    public void setCache() {
        AuctionDictionaryExample ex = new AuctionDictionaryExample();
        ex.createCriteria().andCategoryEqualTo("auction_layer_on");
        String orderBy = "item_order";
        if (org.apache.commons.lang.StringUtils.isNotBlank(orderBy)) {
            orderBy += " desc";
        }
        List<AuctionDictionary> auctionDictionaries = this.auctionDictionaryMapper.selectByExample(ex);
        cacheService.set("auct_auction_layer_on", JSON.toJSONString(auctionDictionaries),
                new Date(365 * 24 * 60 * 60 * 1000));
    }
}
