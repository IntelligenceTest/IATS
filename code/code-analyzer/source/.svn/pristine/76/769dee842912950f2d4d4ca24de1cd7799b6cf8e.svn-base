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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.auction.test.BaseDubboTest;
import com.autostreets.framework.common.dal.Pagination;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author wwy
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderItemServiceImplTest extends BaseDubboTest {

    @Autowired
    private OrderItemService itemService;

    @Autowired
    private OrderService orderService;

    @Test
    public void queryOrders4FiTest() {
        Pagination pagination = new Pagination();
        OrderItem item = new OrderItem();
        item.setSaleType(1);
        item.setStatus(1);
        item.setVehicleSrcIds(new ArrayList<Integer>() {

            /**
             */
            private static final long serialVersionUID = -8162382170502466460L;

            {
                add(263);
            }
        });
        pagination = itemService.queryOrders4Fi(pagination, item);
        System.out.println(JSON.toJSON(pagination));
    }

    @Test
    public void test() {
        List<Integer> ids = new ArrayList<Integer>() {

            private static final long serialVersionUID = 3535670773263407778L;

            {
                // add(1045);
                add(1037);
            }
        };
        try {
            orderService.changeOrderStatusBatch(ids, 137, (short) 1, (short) 11, "dfafd", new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
