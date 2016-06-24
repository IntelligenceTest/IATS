package com.autostreets.biz.auction.web.controller;

import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.model.AuctionDictionaryExample;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.cache.CacheService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.vo.JsonResult;

/**
 * @author wei.liao
 */
@Controller
@RequestMapping("/auctionDictionary")
public class DictionaryController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryController.class);

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @Autowired
    private CacheService cacheService;

    /**
     * 查询字典表信息，分页显示
     * 
     * @param pagination
     * @param role
     * @param model
     * @return
     */
    @RequestMapping("index")
    @RequiresPermissions("auct:auctionDictionary:index")
    public String index(Pagination pagination, AuctionDictionary auctionDictionary, Model model) {
        pagination = auctionDictionaryService.selectDictionaryByPage(pagination, auctionDictionary);
        model.addAttribute("pagination", pagination);
        return "/dictionary/index";
    }

    /**
     * 新增记录
     * 
     * @param dictionary
     * @param model
     * @return
     */
    @RequestMapping("add")
    public String add(AuctionDictionary auctionDictionary, Model model) {
        return "/dictionary/add";
    }

    /**
     * 保存字典表数据
     * 
     * @param model
     * @param user
     * @param systemIds
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Model model, AuctionDictionary auctionDictionary) {
        try {
            auctionDictionary.setModifyTime(new Date());
            auctionDictionary.setUpdateUser(getUser().getId());
            if (auctionDictionary.getId() == null) {
                auctionDictionaryService.insert(auctionDictionary);
            } else {
                auctionDictionaryService.updateByPrimaryKeySelective(auctionDictionary);
            }
            AuctionDictionaryExample ex = new AuctionDictionaryExample();
            ex.createCriteria().andCategoryEqualTo(auctionDictionary.getCategory()).andDelFlagEqualTo(false);
            String orderBy = "item_order";
            ex.setOrderByClause(orderBy);
            List<AuctionDictionary> auctionDictionaries = auctionDictionaryService.selectByExample(ex);
            cacheService.set("auct_" + auctionDictionary.getCategory(), JSON.toJSONString(auctionDictionaries),
                    new Date(365 * 24 * 60 * 60 * 1000));
            return new JsonResult(true, "保存成功!");
        } catch (Exception e) {
            LOGGER.error("保存失败", e);
            return new JsonResult(false, "保存失败!");
        }
    }

    /**
     * 修改时加载记录
     * 
     * @return
     */
    @RequestMapping("get")
    public String get(Model model, AuctionDictionary dictionary) {
        dictionary = auctionDictionaryService.selectByPrimaryKey(dictionary.getId());
        model.addAttribute("auctionDictionary", dictionary);
        return "/dictionary/add";
    }

    /**
     * 删除记录
     * 
     * @param dictionary
     * @param sid
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public JsonResult delete(AuctionDictionary auctionDictionary) {
        try {
            auctionDictionary.setDelFlag(true);
            auctionDictionary.setUpdateUser(getUser().getId());
            auctionDictionaryService.updateByPrimaryKeySelective(auctionDictionary);
            auctionDictionary = auctionDictionaryService.selectByPrimaryKey(auctionDictionary.getId());
            // cacheService.set("auct_" + auctionDictionary.getCategory(), "1",
            // new Date(1000));
            AuctionDictionaryExample ex = new AuctionDictionaryExample();
            ex.createCriteria().andCategoryEqualTo(auctionDictionary.getCategory()).andDelFlagEqualTo(false);
            String orderBy = "item_order";
            ex.setOrderByClause(orderBy);
            List<AuctionDictionary> auctionDictionaries = auctionDictionaryService.selectByExample(ex);
            cacheService.set("auct_" + auctionDictionary.getCategory(), JSON.toJSONString(auctionDictionaries),
                    new Date(1000));
            return new JsonResult(true, "删除成功!");
        } catch (Exception e) {
            LOGGER.error("删除失败", e);
            return new JsonResult(false, "删除失败");
        }
    }

    /**
     * 获取缓存值
     * 
     * @param dictionary
     * @param sid
     * @return
     */
    @RequestMapping("getCache")
    @ResponseBody
    public Object getCache(String key) {
        if (key != null) {
            return cacheService.get("auct_" + key);
        } else {
            return null;
        }
    }
}
