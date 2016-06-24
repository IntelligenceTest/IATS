package com.autostreets.biz.auction.web.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.HomepageRecommend;
import com.autostreets.biz.auction.model.HomepageRecommendExample;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.HomepageRecommendService;
import com.autostreets.biz.common.service.CacheService;
import com.autostreets.constants.CacheConstants;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.vo.JsonResult;

@Controller
@RequestMapping("homepageRecommend")
public class HomepageRecommendController extends BaseController {

    @Autowired
    private FixedPriceService fixedPriceService;

    @Autowired
    private HomepageRecommendService homepageRecommendService;

    @Autowired
    private CacheService cacheService;

    @RequiresPermissions("auct:recommend:index")
    @RequestMapping("index")
    public String index(Pagination pagination, Model model, HomepageRecommend homepageRecommend) {
        homepageRecommend.setEnabled(true);
        int count = homepageRecommendService.countHomepageRecommend(homepageRecommend);
        pagination.setCount(count);
        homepageRecommend.setPagination(pagination);
        List<HomepageRecommend> fpRecommendList = homepageRecommendService.findHomepageRecommend(homepageRecommend);
        pagination.setDataList(fpRecommendList);
        model.addAttribute("pagination", pagination);
        return "homepageRecommend/index";
    }

    @RequestMapping("/vehicle-select")
    public String selectVehicle(Model model) {
        model.addAttribute("fixedPrice", new FixedPrice());
        return "homepageRecommend/list/vehicle-select";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/vehicle-list")
    public String selectVehicleList(FixedPrice fixedPrice, Pagination pagination, Model model) {
        // 只查询已上架的二手车展厅车辆
        fixedPrice.setStatus(3);
        pagination = fixedPriceService.queryFixedPrices(pagination, fixedPrice);
        List<FixedPrice> list = (List<FixedPrice>) pagination.getDataList();
        HomepageRecommendExample example = null;
        com.autostreets.biz.auction.model.base.BaseHomepageRecommendExample.Criteria criteria = null;
        for (FixedPrice tempFixedPrice : list) {
            example = new HomepageRecommendExample();
            criteria = example.createCriteria();
            criteria.andFpIdEqualTo(tempFixedPrice.getId());
            criteria.andEnabledEqualTo(true);
            int count = homepageRecommendService.countByExample(example);
            if (count > 0) {
                tempFixedPrice.setIsRecommend(true);
            } else {
                tempFixedPrice.setIsRecommend(false);
            }
        }
        model.addAttribute("pagination", pagination);
        return "homepageRecommend/list/vehicle-list";
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(String sids) {
        JsonResult result = new JsonResult(true);
        if (StringUtils.isBlank(sids) || !sids.contains(",")) {
            return result;
        }
        String[] fixedPriceIds = sids.split(",");
        HomepageRecommend homepageRecommend = null;
        Integer seqNo = homepageRecommendService.countMaxSeqNo();
        if (null == seqNo) {
            seqNo = 1;
        }
        String msg = "一共选择了" + fixedPriceIds.length + "辆车";
        int count = 0;
        for (String id : fixedPriceIds) {
            FixedPrice fixedPrice = fixedPriceService.selectByPrimaryKey(Integer.valueOf(id));
            if (null != fixedPrice) {
                homepageRecommend = new HomepageRecommend();
                homepageRecommend.setVehicleId(fixedPrice.getVehicleId());
                homepageRecommend.setFpId(Integer.valueOf(id));
                homepageRecommend.setSeqNo(++seqNo);
                homepageRecommend.setCreateTime(new Date());
                homepageRecommend.setUpdateTime(new Date());
                homepageRecommend.setCreateUser(getUser().getId());
                homepageRecommend.setUpdateUser(getUser().getId());
                homepageRecommend.setEnabled(true);
                homepageRecommendService.insert(homepageRecommend);
                count++;
            } else {
                msg += "车辆id为" + id + "不存在该展品";
            }
        }
        // 清除首页缓存
        cacheService.delete(CacheConstants.AUTOSTREETS_INDEX_GET_HOME_PAGE_USEDCAR);
        msg += "成功推荐" + count + "辆车";
        result.setMsg(msg);
        return result;
    }

    @RequestMapping("/remove")
    @ResponseBody
    public JsonResult del(String ids) {
        JsonResult result = new JsonResult(true);
        if (StringUtils.isBlank(ids) || !ids.contains(",")) {
            result.setMsg("您没有选择任何记录");
            return result;
        }
        String[] fixedPriceIds = ids.split(",");
        Integer seqNo = homepageRecommendService.countMaxSeqNo();
        if (null == seqNo) {
            seqNo = 1;
        }
        String msg = "一共选择了" + fixedPriceIds.length + "条记录";
        int count = 0;
        HomepageRecommend homepageRecommend = null;
        for (String id : fixedPriceIds) {
            homepageRecommend = new HomepageRecommend();
            homepageRecommend.setId(Integer.valueOf(id));
            homepageRecommend.setEnabled(false);
            count += homepageRecommendService.updateByPrimaryKeySelective(homepageRecommend);
        }
        // 清除首页缓存
        cacheService.delete(CacheConstants.AUTOSTREETS_INDEX_GET_HOME_PAGE_USEDCAR);
        msg += "成功删除" + count + "条记录";
        result.setMsg(msg);
        return result;
    }

    @RequestMapping("/replace")
    @ResponseBody
    public JsonResult replace(Integer homepageRecommendId, Integer fixedPriceId) {
        JsonResult result = new JsonResult(true);
        if (fixedPriceId == null || homepageRecommendId == null) {
            result.setMsg("您没有选择任何记 录");
            return result;
        }
        FixedPrice fixedPrice = fixedPriceService.selectByPrimaryKey(fixedPriceId);
        if (null == fixedPrice) {
            result.setMsg("该条展品数据不存在");
            return result;
        }
        HomepageRecommend homepageRecommend = homepageRecommendService.selectByPrimaryKey(homepageRecommendId);
        homepageRecommend.setUpdateTime(new Date());
        homepageRecommend.setUpdateUser(getUser().getId());
        homepageRecommend.setFpId(fixedPrice.getId());
        homepageRecommend.setVehicleId(fixedPrice.getVehicleId());
        int count = homepageRecommendService.updateByPrimaryKeySelective(homepageRecommend);
        String msg;
        if (count > 0) {
            // 清除首页缓存
            cacheService.delete(CacheConstants.AUTOSTREETS_INDEX_GET_HOME_PAGE_USEDCAR);
            msg = "替换成功";
        } else {
            msg = "替换失败请稍后再试";
        }
        result.setMsg(msg);
        return result;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public JsonResult modify(Integer homepageRecommendId, Integer seqNo) {
        JsonResult result = new JsonResult(true);
        if (null == homepageRecommendId || null == seqNo) {
            result.setMsg("输入非法");
            return result;
        }
        HomepageRecommend homepageRecommend = homepageRecommendService.selectByPrimaryKey(homepageRecommendId);
        homepageRecommend.setUpdateTime(new Date());
        homepageRecommend.setUpdateUser(getUser().getId());
        homepageRecommend.setSeqNo(seqNo);
        int count = homepageRecommendService.updateByPrimaryKeySelective(homepageRecommend);
        String msg;
        if (count > 0) {
            // 清除首页缓存
            cacheService.delete(CacheConstants.AUTOSTREETS_INDEX_GET_HOME_PAGE_USEDCAR);
            msg = "修改序号成功";
        } else {
            msg = "修改序号失败请稍后再试";
        }
        result.setMsg(msg);
        return result;
    }
}
