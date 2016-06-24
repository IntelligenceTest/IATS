/*
 * Copyright (C), 2014-2015, 上海澍勋电子商务有限公司
 * FileName: OrderItemServiceImplTest.java
 * Author:   wwy
 * Date:     2015年12月18日 上午9:55:30
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.autostreets.biz.auction.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.biz.auction.test.BaseDubboTest;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author wwy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AuctionVehicleServiceImplTest extends BaseDubboTest {

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Test
    public void test() {
        try {
            auctionVehicleService.updateAuctionVehicleStatus(999, 55555, 3, 4);
        } catch (Exception e) {
            System.err.println("出错了");
            e.printStackTrace();
        }
    }

}
