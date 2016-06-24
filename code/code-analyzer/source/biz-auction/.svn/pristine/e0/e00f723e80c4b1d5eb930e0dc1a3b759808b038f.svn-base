/*
 * Copyright (C), 2014-2014, 上海澍勋电子商务有限公司
 * FileName: AutostreetsAuthenticationRedirectStrategy.java
 * Author:   long.yu
 * Date:     2014年12月15日 下午3:53:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.autostreets.biz.auction.web.cas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.authentication.AuthenticationRedirectStrategy;

import com.autostreets.web.util.ResponseUtils;
import com.autostreets.web.util.AutostreetsWebUtils;


/**
 * 〈一句话功能简述〉<br> 
 *  复写cas拦截的跳转策略
 *
 * @author long.yu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AutostreetsAuthenticationRedirectStrategy implements AuthenticationRedirectStrategy{

    @Override
    public void redirect(HttpServletRequest request, HttpServletResponse response, String potentialRedirectUrl)
            throws IOException {
        //如果是ajax请求则返回要跳转的路径，否则直接跳转到该路径
        if (AutostreetsWebUtils.isAjaxRequest(request)) {
            Map<String,Object> result = new HashMap<>();
            result.put("redirectUrl", potentialRedirectUrl);
            ResponseUtils.writeJsonObject(response, result);
        } else {
            response.sendRedirect(potentialRedirectUrl);
        }
    }
    
}
