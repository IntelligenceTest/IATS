package com.autostreets.biz.auction.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.common.service.CacheService;
import com.autostreets.framework.common.web.vo.JsonResult;

/**
 * 拍卖报表
 * 
 * @author wwy
 * @date 2015年8月26日下午3:17:11
 */
@Controller
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private com.autostreets.cache.CacheService cacheService2;

    @RequestMapping("index")
    public String index(Model model) {
        return "cache/index";
    }

    @RequestMapping("getMemCacheCache")
    @ResponseBody
    public Object getMemCacheCache(String key) {
        Object obj = cacheService2.get(key);
        return obj;
    }

    @RequestMapping("deleteMemCacheCache")
    @ResponseBody
    public JsonResult deleteMemCacheCache(String key) {
        cacheService2.set(key, "1", new Date(1000));
        return new JsonResult(true, "删除成功!");
    }

    @RequestMapping("getRedisCache")
    @ResponseBody
    public Object getRedisCache(String key) {
        Object obj = cacheService.get(key);
        return obj;
    }

    @RequestMapping("deleteRedisCache")
    @ResponseBody
    public JsonResult deleteRedisCache(String key) {
        cacheService.delete(key);
        return new JsonResult(true, "删除成功!");
    }
}
