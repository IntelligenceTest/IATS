/*
 * Copyright (C), 2014-2015, 上海澍勋电子商务有限公司
 * FileName: MonitorController.java
 * Author:   wwy
 * Date:     2015年12月7日 下午3:55:11
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.autostreets.biz.auction.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.service.AuctionDictionaryService;

/**
 * 监控链接<br>
 * 〈功能详细描述〉
 *
 * @author wwy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class MonitorController {

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/servlet/monitor")
    @ResponseBody
    public String getMonitorHrefInfo() {
        List<AuctionDictionary> auctionType = auctionDictionaryService.selectAuctionType();
        String result = "";
        for (AuctionDictionary auctionDictionary : auctionType) {
            result += auctionDictionary.getName();
        }
        return result;
    }
}
