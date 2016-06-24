/*
 * Copyright (C), 2014-2014, 上海澍勋电子商务有限公司
 * FileName: CasProtectedController.java
 * Author:   long.yu
 * Date:     2014年12月15日 下午1:12:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.autostreets.biz.auction.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.core.JsonResult;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author long.yu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/cas")
public class CasProtectedController extends BaseController {

    @RequestMapping(value = "/protected", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult logout(HttpServletRequest request, HttpServletResponse response) {
        JsonResult jr = new JsonResult(true);
        return jr;
    }

}
