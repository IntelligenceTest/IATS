package com.autostreets.biz.auction.web.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.autostreets.biz.auction.domain.AuctionVehicleVO;
import com.autostreets.biz.auction.domain.BidReportVO;
import com.autostreets.biz.auction.domain.UsedCarVO;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.bi.service.ReportService;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.framework.common.dal.Pagination;

/**
 * 拍卖报表
 * 
 * @author wwy
 * @date 2015年8月26日下午3:17:11
 */
@Controller
@RequestMapping("/report")
public class ReportController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    @Autowired
    private AuctionDictionaryService auctionDictionaryService;

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/auctionreport")
    @RequiresPermissions(value = {"auct:report:auctionreport"})
    public String auctionReport(Pagination pagination, AuctionVehicleVO auctionVehicleVO, Model model) {
        if (null == auctionVehicleVO) {
            LOGGER.error("系统异常,auctionVehicleVO is null");
            throw new RuntimeException("系统异常,auctionVehicleVO is null.");
        }
        if (StringUtils.isBlank(auctionVehicleVO.getStatus()) && StringUtils.isBlank(auctionVehicleVO.getType())) {
            auctionVehicleVO.setStatus("2");// 拍品状态默认【拍卖成功】
            auctionVehicleVO.setType("1");// 拍卖类型默认【在线拍】
            auctionVehicleVO.setStartTimestamp(new Date());// 查询时间默认当天
            auctionVehicleVO.setEndTimestamp(new Date());
        }
        initVO(auctionVehicleVO);
        List<Organization> orgList = getUser().getOrgList();
        Integer userOrgId = null;
        if (orgList != null && orgList.size() > 0) {
            userOrgId = getUser().getOrgList().get(0).getId();// 用户组织机构
        }
        if (userOrgId == null || userOrgId == 8 || userOrgId == 0) {
            auctionVehicleVO.setOrgIds(null);
        } else {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("parentId", 8);
            param.put("delFlag", 0);
            param.put("enabled", 1);
            param.put("delFlag", 0);
            param.put("parentId", 8);
            param.put("parentId", 8);
            List<Integer> autostreetsOrgIds;
            try {
                autostreetsOrgIds = organizationService.selectAllSubOrganizationIdsById(param, true);
                if (!autostreetsOrgIds.contains(userOrgId)) {
                    try {
                        param.put("parentId", userOrgId);
                        List<Integer> orgIds = organizationService.selectAllSubOrganizationIdsById(param, true);
                        auctionVehicleVO.setOrgIds(orgIds);
                    } catch (Exception e) {
                        LOGGER.error("获取权限失败!", e);
                    }
                }
            } catch (Exception e1) {
                LOGGER.error("获取汽车街权限失败!", e1);
            }
        }
        pagination = reportService.queryAuctionVehicle(pagination, auctionVehicleVO);
        model.addAttribute("pagination", pagination);
        return "report/auctionreport";
    }

    /**
     * @Title: exportExcel
     * @Description: 拍卖统计报表EXCEL导出
     */
    @RequiresPermissions(value = {"auct:auctionreport:exportexcel"})
    @RequestMapping(value = "/exportauctionexcel", method = RequestMethod.POST)
    public void exportauctionexcel(String[] exportCol, HttpServletResponse response,
            AuctionVehicleVO auctionVehicleVO) {
        if (null == auctionVehicleVO) {
            LOGGER.error("系统异常,auctionVehicleVO is null");
            throw new RuntimeException("系统异常,auctionVehicleVO is null.");
        }
        initVO(auctionVehicleVO);
        List<Organization> orgList = getUser().getOrgList();
        Integer userOrgId = null;
        if (orgList != null && orgList.size() > 0) {
            userOrgId = getUser().getOrgList().get(0).getId();// 用户组织机构
        }
        if (userOrgId == null || userOrgId == 8 || userOrgId == 0) {
            auctionVehicleVO.setOrgIds(null);
        } else {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("parentId", 8);
            param.put("delFlag", 0);
            param.put("enabled", 1);
            param.put("delFlag", 0);
            param.put("parentId", 8);
            param.put("parentId", 8);
            List<Integer> autostreetsOrgIds;
            try {
                autostreetsOrgIds = organizationService.selectAllSubOrganizationIdsById(param, true);
                if (!autostreetsOrgIds.contains(userOrgId)) {
                    try {
                        param.put("parentId", userOrgId);
                        List<Integer> orgIds = organizationService.selectAllSubOrganizationIdsById(param, true);
                        auctionVehicleVO.setOrgIds(orgIds);
                    } catch (Exception e) {
                        LOGGER.error("获取权限失败!", e);
                    }
                }
            } catch (Exception e1) {
                LOGGER.error("获取汽车街权限失败!", e1);
            }
        }
        List<AuctionVehicleVO> dataSet = reportService.queryAuctionVehicle(auctionVehicleVO);
        if (!CollectionUtils.isEmpty(dataSet)) {
            if (dataSet.size() > 10000) {
                try {
                    response.setContentType("text/plain; charset=utf-8");
                    response.getWriter().write("数据超过10000条，请分批导出!");
                } catch (IOException e) {
                    LOGGER.error(e.getMessage());
                }
            } else {
                exportExcelUtil.exportExcel(Arrays.asList(exportCol), dataSet, response, "拍品统计报表");
            }
        } else {
            try {
                response.getWriter().write("<font color='red'>no data!</font>");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    /**
     * @Title: initVO
     * @Description: 初始化参数
     */
    private void initVO(AuctionVehicleVO auctionVehicleVO) {
        // 竞价人类型筛选
        String bidderType = auctionVehicleVO.getBidderType();
        if (StringUtils.isNotBlank(bidderType) && !StringUtils.equals(bidderType, "99")) {
            // 内部人员账号
            auctionVehicleVO.setInsiders(auctionDictionaryService.getInsidersAccount());
        }
    }

    @RequestMapping(value = "/bidreport")
    @RequiresPermissions(value = {"auct:report:bidreport"})
    public String bidReport(Pagination pagination, BidReportVO bidReportVO, Model model) {
        if (null != bidReportVO && null == bidReportVO.getStartTimestamp() && null == bidReportVO.getEndTimestamp()) {
            bidReportVO.setStartTimestamp(new Date());
            bidReportVO.setEndTimestamp(new Date());
        }
        pagination = reportService.queryBidReport(pagination, bidReportVO);
        model.addAttribute("pagination", pagination);
        return "report/bidreport";
    }

    /**
     * @Title: exportExcel
     * @Description: 出价记录报表导出excel
     * @param exportCol
     * @param response
     * @param bidReportVO
     * @return void
     * @author chao.duan
     * @date 2014年12月24日 10:13:14
     */
    @RequestMapping(value = "/exportbidexcel")
    @RequiresPermissions(value = {"auct:bidreport:exportexcel"})
    public void exportBidExcel(String[] exportCol, HttpServletResponse response, BidReportVO bidReportVO) {
        LOGGER.info("***************************进入统计报表【出价记录报表】导出Excel***************************");
        List<BidReportVO> dataSet = reportService.queryBidReport(bidReportVO);
        if (!CollectionUtils.isEmpty(dataSet)) {
            String modelName = "出价记录报表";
            String attr = "出价日期";
            Date startTime = bidReportVO.getStartTimestamp();
            Date endTime = bidReportVO.getEndTimestamp();
            if (dataSet.size() > 50000) {
                try {
                    response.setContentType("text/plain; charset=utf-8");
                    response.getWriter().write("数据超过50000条，请分批导出!");
                } catch (IOException e) {
                    LOGGER.error(e.getMessage());
                }
            } else {
                exportExcelUtil.exportExcel(Arrays.asList(exportCol), dataSet, response,
                        excelExtNameEqualTime(modelName, attr, startTime, endTime));
            }
        } else {
            try {
                response.getWriter().write("<font color='red'>no data!</font>");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    /**
     * @Title: doUsedCarsReport
     * @Description: 精品二手车报表查询
     */
    @RequestMapping(value = "/usedcarreport")
    @RequiresPermissions(value = {"auct:report:usedcarreport"})
    public String doUsedCarsReport(Pagination pagination, UsedCarVO usedCarVO, Model model) {
        if (null != usedCarVO && null == usedCarVO.getStartTimestamp() && null == usedCarVO.getEndTimestamp()) {
            usedCarVO.setStartTimestamp(new Date());
            usedCarVO.setEndTimestamp(new Date());
        }
        pagination = reportService.queryUsedCars(pagination, usedCarVO);
        model.addAttribute("pagination", pagination);
        return "report/usedcarreport";
    }

    /**
     * @Title: exportExcel
     * @Description: 精品二手车导出excel
     */
    @RequestMapping(value = "/exportusedcarexcel")
    @RequiresPermissions(value = {"auct:usedcarreport:exportexcel"})
    public void exportExcel(String[] exportCol, HttpServletResponse response, UsedCarVO usedCarVO) {
        List<UsedCarVO> dataSet = reportService.queryUsedCars(usedCarVO);
        if (!CollectionUtils.isEmpty(dataSet)) {
            String modelName = "展厅报表";
            String attr = "入库日期";
            Date startTime = usedCarVO.getStartTimestamp();
            Date endTime = usedCarVO.getEndTimestamp();
            exportExcelUtil.exportExcel(Arrays.asList(exportCol), dataSet, response,
                    excelExtNameEqualTime(modelName, attr, startTime, endTime));
        } else {
            try {
                response.getWriter().write("<font color='red'>no data!</font>");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    /**
     * @Title: doLoadBidLogs
     * @Description: 出价记录查询
     */
    @RequestMapping(value = "bid-log", method = RequestMethod.GET)
    public String doLoadBidLogs(Pagination pagination, AuctionVehicleVO auctionVehicleVO, Model model) {
        if (null == auctionVehicleVO)
            throw new RuntimeException("系统异常,auctionVehicleVO is null.");

        // 参数初始化处理
        initVO(auctionVehicleVO);
        BidReportVO b = new BidReportVO();
        b.setAuctionVehicleId(Integer.valueOf(auctionVehicleVO.getId()));
        b.setStartTimestamp(auctionVehicleVO.getStartTimestamp());
        b.setEndTimestamp(auctionVehicleVO.getEndTimestamp());
        b.setBidderType(auctionVehicleVO.getBidderType());
        b.setInsiders(auctionVehicleVO.getInsiders());
        pagination = reportService.queryBidLogs(pagination, b);
        model.addAttribute(auctionVehicleVO);
        model.addAttribute("pagination", pagination);
        return "report/bid-log";
    }

    /**
     * 功能描述: <br>
     * 查询竞拍人最高出价详情
     * 
     * @param pagination
     * @param auctionVehicleVO
     * @param model
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * @date 2014年12月17日下午5:01:59
     * @author yanqing.luo
     */
    @RequestMapping(value = "bidder-log", method = RequestMethod.GET)
    public String doLoadBidderLogs(Pagination pagination, AuctionVehicleVO auctionVehicleVO, Model model) {
        if (null == auctionVehicleVO)
            throw new RuntimeException("系统异常,auctionVehicleVO is null.");

        // 参数初始化处理
        initVO(auctionVehicleVO);
        BidReportVO b = new BidReportVO();
        b.setAuctionVehicleId(Integer.valueOf(auctionVehicleVO.getId()));
        b.setStartTimestamp(auctionVehicleVO.getStartTimestamp());
        b.setEndTimestamp(auctionVehicleVO.getEndTimestamp());
        b.setBidderType(auctionVehicleVO.getBidderType());
        b.setInsiders(auctionVehicleVO.getInsiders());

        pagination = reportService.queryBidderMaxPriceDetails(pagination, b);
        model.addAttribute(auctionVehicleVO);
        model.addAttribute("pagination", pagination);
        return "report/bidder-log";
    }
}
