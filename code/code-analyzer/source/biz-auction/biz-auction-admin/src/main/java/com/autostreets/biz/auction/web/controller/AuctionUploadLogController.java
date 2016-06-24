package com.autostreets.biz.auction.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autostreets.biz.auction.model.AuctionUploadLog;
import com.autostreets.biz.auction.service.AuctionUploadLogService;
import com.autostreets.framework.common.dal.Pagination;

/**
 * 同步拍数据操作记录
 * 
 * @author youpeng.zhang Date: 2015年8月17日 下午2:34:54
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/auctionUploadLog")
public class AuctionUploadLogController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionUploadLogController.class);

    @Autowired
    private AuctionUploadLogService auctionUploadLogService;

    /**
     * 同步拍数据操作记录首页
     * 
     * @return String
     * @author dingqiang.sheng Date: 2016年4月8日 下午14:49:54
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    @RequiresPermissions("auct:auctionUploadLog:index")
    @RequestMapping(value = "/index")
    public String index(Pagination pagination, AuctionUploadLog auctionUploadLog, Model model) {
        pagination = auctionUploadLogService.selectAuctionUploadLogByPage(pagination, auctionUploadLog);
        model.addAttribute("pagination", pagination);
        return "adu/log_index";
    }

}
