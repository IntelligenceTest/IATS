/*
 * Copyright (C), 2014-2016, 上海澍勋电子商务有限公司
 * FileName: AuctionVehicleStatusLogServiceImpl.java
 * Author:   wwy
 * Date:     2016年3月11日 下午5:25:33
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.autostreets.biz.auction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autostreets.biz.auction.mapper.AuctionVehicleStatusLogMapper;
import com.autostreets.biz.auction.model.AuctionVehicleStatusLog;
import com.autostreets.biz.auction.model.AuctionVehicleStatusLogExample;
import com.autostreets.biz.auction.service.AuctionVehicleStatusLogService;
import com.autostreets.framework.common.dal.GenericMapper;
import com.autostreets.framework.common.dal.GenericServiceImpl;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author wwy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("auctionVehicleStatusLogService")
public class AuctionVehicleStatusLogServiceImpl
        extends GenericServiceImpl<AuctionVehicleStatusLog, AuctionVehicleStatusLogExample, Integer>
        implements AuctionVehicleStatusLogService {

    @Autowired
    private AuctionVehicleStatusLogMapper auctionVehicleStatusLogMapper;

    @Override
    protected GenericMapper<AuctionVehicleStatusLog, AuctionVehicleStatusLogExample, Integer> getGenericMapper() {
        return auctionVehicleStatusLogMapper;
    }

}
