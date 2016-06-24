/*
 * Copyright (C), 2014-2016, 上海澍勋电子商务有限公司
 * FileName: CommonUtils.java
 * Author:   wwy
 * Date:     2016年6月14日 下午4:47:19
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.autostreets.biz.auction.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author wwy
 */
public class CommonUtils {

    /**
     * 功能描述: 字符串分割<br>
     * 〈性能比{@linkplain java.lang.String#split(String) java原生split}
     * 的性能稍高，返回list，不支持正则表达式〉
     *
     * @param str
     *            要分割的字符串
     * @param splitStr
     *            分割字符,不支持正则表达式
     * @return list
     * @throws java.lang.NullPointerException
     *             如果str或者splitStr为null
     */
    public static List<String> split(String str, String splitStr) {
        int newIndex;
        int oldIndex;
        String subStr = null;
        List<String> list = new ArrayList<>();
        newIndex = 0;
        oldIndex = 0;
        newIndex = str.indexOf(splitStr, oldIndex);
        subStr = str.substring(0, newIndex);
        oldIndex = newIndex + 1;
        list.add(subStr);
        while ((newIndex = str.indexOf(splitStr, oldIndex)) != -1) {
            subStr = str.substring(oldIndex, newIndex);
            oldIndex = newIndex + 1;
            list.add(subStr);
        }
        return list;
    }
}
