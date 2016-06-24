package com.autostreets.biz.auction.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.autostreets.biz.auction.domain.AuctionDataUploadVO;
import com.autostreets.biz.auction.model.AuctionUploadLog;
import com.autostreets.biz.auction.model.AuctionVehicleExample;
import com.autostreets.biz.auction.service.AuctionDataUploadService;
import com.autostreets.biz.auction.service.AuctionService;
import com.autostreets.biz.auction.service.AuctionUploadLogService;
import com.autostreets.biz.auction.service.AuctionVehicleService;
import com.autostreets.cache.CacheService;
import com.autostreets.framework.common.dal.Pagination;
import com.autostreets.framework.common.web.vo.JsonResult;

@Controller
@RequestMapping("/adumanage")
public class AuctionDataUploadManageController extends BaseController {

    @Autowired
    private AuctionDataUploadService auctionDataUploadService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private AuctionVehicleService auctionVehicleService;

    @Autowired
    private AuctionUploadLogService auctionUploadLogService;

    @RequiresPermissions("auct:adumanage:index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Pagination pagination, AuctionDataUploadVO auctionDataUploadVO, Model model) {
        LOGGER.debug("*******************同步拍数据管理首页**********************");
        Integer dataFlag = auctionDataUploadVO.getDataFlag();
        if (null == dataFlag) {
            dataFlag = Integer.valueOf(1);
            auctionDataUploadVO.setDataFlag(dataFlag);
        }

        Boolean isShowDeal = auctionDataUploadVO.getIsShowDeal();
        if (null == isShowDeal) {
            isShowDeal = Boolean.valueOf(true);
            auctionDataUploadVO.setIsShowDeal(isShowDeal);
        }

        Boolean isShowUndeal = auctionDataUploadVO.getIsShowUndeal();
        if (null == isShowUndeal) {
            isShowUndeal = Boolean.valueOf(true);
            auctionDataUploadVO.setIsShowUndeal(isShowUndeal);
        }
        Pagination p = auctionDataUploadService.selectPage(pagination, auctionDataUploadVO);
        model.addAttribute("auctionDataUploadVO", auctionDataUploadVO);
        model.addAttribute("pagination", p);
        model.addAttribute("auctionTitleList", auctionService.selectEndAuctionList());
        model.addAttribute("dataFalg", dataFlag);

        Map<String, Object> data = auctionDataUploadService.getUploadCalcInfo(dataFlag, auctionDataUploadVO);
        model.addAttribute("data", data);

        return "adumanage/index";
    }

    @RequestMapping(value = "/selectVehiclesByAuctionMember", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult selectVehiclesByAuctionMember(AuctionDataUploadVO auctionDataUploadVO) {
        LOGGER.debug("*******************按参拍人查询列表查看拍中车辆列表**********************");
        JsonResult jr;

        List<AuctionDataUploadVO> list = auctionDataUploadService.selectVehiclesByAuctionMember(auctionDataUploadVO);
        if (list == null) {
            jr = new JsonResult(false);
        } else {
            jr = new JsonResult(true, list);
        }

        return jr;
    }

    @RequestMapping(value = "/loadAuctionInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult loadAuctionInfo(AuctionDataUploadVO auctionDataUploadVO) {
        LOGGER.debug("*******************取得拍卖后台拍卖会统计信息**********************");
        JsonResult jr;
        Map<String, Object> data = auctionDataUploadService.getUploadFileInfoCount(auctionDataUploadVO.getAuctionId());
        Map<String, Object> map = auctionDataUploadService.loadAuctionInfo(auctionDataUploadVO);
        data.put("uploadAuctionVehicleNum", data.get("auctionVehicleNum"));
        data.putAll(map);
        if (map == null) {
            jr = new JsonResult(false);
        } else {
            jr = new JsonResult(true, data);
        }
        return jr;
    }

    @RequestMapping(value = "/uploadCheck", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonResult uploadCheck(AuctionDataUploadVO auctionDataUploadVO, HttpServletRequest request,
            HttpServletResponse response, String fileId) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        boolean rs = auctionDataUploadService.uploadCheck(auctionDataUploadVO);
        if (!rs) {
            return new JsonResult(false, "该场次已经导入过数据，如需要重新导入数据，请先删除场次已有数据");
        }
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                    List<List<List<String>>> list;
                    try {
                        list = readExcel(file.getInputStream(), file.getOriginalFilename());
                        JsonResult jsonResult = checkList(list);
                        if (!jsonResult.isSuccess()) {
                            return jsonResult;
                        }
                        Map<String, String> countData = new HashMap<String, String>();
                        countData.put("personNum", "" + (list.get(0).size() - 1));
                        List<List<String>> tempList = list.get(1);
                        int vehicleCount = 0;
                        int successCount = 0;
                        for (int i = 1; i < tempList.size(); i++) {
                            if (tempList.get(i).get(1) == null || StringUtils.isBlank(tempList.get(i).get(1))) {
                                vehicleCount++;
                            } else {
                                vehicleCount++;
                                successCount++;
                            }
                        }
                        AuctionVehicleExample avExample = new AuctionVehicleExample();
                        avExample.createCriteria().andAuctionIdEqualTo(auctionDataUploadVO.getAuctionId())
                                .andStatusEqualTo(2);
                        int cnt = auctionVehicleService.countByExample(avExample);
                        // 某拍卖会线上成交的数据
                        int onlineSum = auctionVehicleService.selectOnlineDealSum(auctionDataUploadVO.getAuctionId());
                        if (cnt != (successCount + onlineSum)) {
                            return new JsonResult(false, "导入数据成交数与系统成交数不一致,请检查!");
                        }
                        // 如果fileId不为空则删除之前的缓存list
                        if (StringUtils.isNotBlank(fileId)) {
                            cacheService.set(fileId, 1, 1000);
                        }
                        String cachekey = "auctUpFile" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss")
                                + nextInt(1000, 9999);
                        cacheService.set(cachekey, list, 1000 * 60 * 60);// 1个小时
                        countData.put("vehicleCount", "" + vehicleCount);
                        countData.put("successCount", "" + successCount);
                        countData.put("fileId", cachekey);
                        return new JsonResult(true, countData);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return new JsonResult(false, "上传文件异常");
                    }
                }
            }
        }
        return new JsonResult(false);
    }

    private int nextInt(int startInclusive, int endExclusive) {
        Random random = new Random();
        return startInclusive + random.nextInt(endExclusive - startInclusive);
    }

    @RequiresPermissions("auct:adumanage:importFile")
    @RequestMapping(value = "/uploadFile", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonResult uploadFile(HttpServletRequest request, HttpServletResponse response,
            AuctionDataUploadVO auctionDataUploadVO, String fileId) {
        Integer crtUserId = getUser().getId();
        boolean rs = auctionDataUploadService.uploadCheck(auctionDataUploadVO);
        if (!rs) {
            return new JsonResult(false, "已经上传过!");
        }
        List<List<String>> tempMemberList = null;// 参拍人list
        List<List<String>> tempAVList = null;// 展品list
        List<AuctionDataUploadVO> memberList = null;
        List<AuctionDataUploadVO> avList = null;
        try {
            Object object = cacheService.get(fileId);
            if (object != null) {
                @SuppressWarnings("unchecked")
                List<List<List<String>>> dataList = (List<List<List<String>>>) object;
                tempMemberList = dataList.get(0);// 参拍人list
                tempAVList = dataList.get(1);// 展品list
                memberList = new ArrayList<>();
                avList = new ArrayList<>();
                AuctionDataUploadVO vo = null;
                for (int i = 1; i < tempMemberList.size(); i++) {
                    vo = new AuctionDataUploadVO();
                    String auctionMemberName = tempMemberList.get(i).get(0);
                    String auctionMemberIDCar = tempMemberList.get(i).get(1);
                    String auctionMemberCellphone = tempMemberList.get(i).get(2);
                    String auctionNumber = tempMemberList.get(i).get(3);
                    String auctionMemberWechat = tempMemberList.get(i).get(4);
                    String auctionMemberProvince = tempMemberList.get(i).get(5);
                    String auctionMemberCity = tempMemberList.get(i).get(6);
                    String registerTime = tempMemberList.get(i).get(7);
                    vo.setAuctionMemberName(auctionMemberName);
                    vo.setAuctionMemberIDCar(auctionMemberIDCar);
                    vo.setAuctionMemberCellphone(auctionMemberCellphone);
                    vo.setAuctionNumber(auctionNumber == null ? null : Integer.valueOf(auctionNumber));
                    vo.setAuctionMemberWechat(auctionMemberWechat);
                    vo.setAuctionMemberProvince(auctionMemberProvince);
                    vo.setAuctionMemberCity(auctionMemberCity);
                    try {
                        vo.setRegisterTime(DateUtils.parseDate(registerTime, "yyyy/MM/dd HH:mm:ss", "yyyyMMdd",
                                "yyyyMMdd", "yyyy-MM-dd", "yyyy年MM月dd日"));
                    } catch (ParseException e) {
                        LOGGER.warn("时间转化错误", e);
                    }
                    memberList.add(vo);
                }
                for (int i = 1; i < tempAVList.size(); i++) {
                    vo = new AuctionDataUploadVO();
                    String auctionVehicleOrder = tempAVList.get(i).get(0);
                    String auctionNumber = tempAVList.get(i).get(1);
                    String dealTime = tempAVList.get(i).get(2);
                    String dealPrice = tempAVList.get(i).get(3);
                    vo.setAuctionVehicleOrder(
                            auctionVehicleOrder == null ? null : Integer.valueOf(auctionVehicleOrder));
                    vo.setAuctionNumber((auctionNumber == null || "".equals(auctionNumber)) ? null
                            : Integer.valueOf(auctionNumber));
                    try {
                        if (StringUtils.isNotBlank(dealTime)) {
                            vo.setDealTime(DateUtils.parseDate(dealTime, "yyyy/MM/dd HH:mm:ss", "yyyyMMdd",
                                    "yyyy/MM/dd", "yyyy-MM-dd", "yyyy年MM月dd日"));
                        }
                        if (StringUtils.isNotBlank(dealPrice)) {
                            vo.setDealPrice(new BigDecimal(dealPrice));
                        } else {
                            vo.setDealPrice(BigDecimal.ZERO);
                        }
                    } catch (ParseException e) {
                        LOGGER.warn("时间转化错误", e);
                    }
                    avList.add(vo);
                }
                auctionDataUploadService.insertUploadData(crtUserId, auctionDataUploadVO.getAuctionId(), memberList,
                        avList);
                cacheService.set(fileId, 1, 1000);
            }
            return new JsonResult(true, "上传成功!");

        } catch (Exception e) {
            LOGGER.error("上传失败", e);
            return new JsonResult(false, "上传失败!");
        }
    }

    public List<List<List<String>>> readExcel(InputStream inputStream, String originalFilename) {
        List<List<List<String>>> dataList = new ArrayList<List<List<String>>>();
        List<List<String>> rowList = null;
        List<String> cellList = null;
        Workbook workbook = null;
        try {
            if (originalFilename.endsWith("xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (originalFilename.endsWith("xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int sheetLength = workbook.getNumberOfSheets();
        for (int i = 0; i < sheetLength; i++) {
            rowList = new ArrayList<List<String>>();
            Sheet sheetAt = workbook.getSheetAt(i);
            int rowLength = sheetAt.getLastRowNum() + 1;
            int cellLength = 0;
            for (int j = 0; j < rowLength; j++) {
                cellList = new ArrayList<String>();
                Row row = sheetAt.getRow(j);
                int tempCellLength = row.getLastCellNum();
                if (tempCellLength > cellLength) {
                    cellLength = tempCellLength;
                }
                for (int k = 0; k < cellLength; k++) {
                    Cell cell = row.getCell(k);
                    if (cell != null) {
                        String v = getValue(cell);
                        if (v == null) {
                            cellList.add("");
                        } else {
                            cellList.add(getValue(cell));
                        }
                    } else {
                        cellList.add("");
                    }
                }
                rowList.add(cellList);
            }
            dataList.add(rowList);
        }
        return dataList;
    }

    private String getValue(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            DecimalFormat df = new DecimalFormat("#.##");
            return df.format(cell.getNumericCellValue());
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }

    @RequiresPermissions("auct:adumanage:deleteFile")
    @RequestMapping(value = "/deleteFile", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JsonResult deleteFile(Integer auctionId) {

        if (auctionId != null) {
            auctionDataUploadService.deleteUploadData(auctionId, null);
            AuctionUploadLog log = new AuctionUploadLog();
            log.setAuctionId(auctionId);
            log.setOperType(3);
            log.setCreateTime(new Date());
            log.setCreatedBy(getUser().getId());
            auctionUploadLogService.insertLog(log);
            return new JsonResult(true, "删除成功");
        }

        return new JsonResult(false, "删除失败");
    }

    @RequiresPermissions("auct:adumanage:view")
    @RequestMapping("/getVehicleInfoByAuctionPersonList")
    public String getVehicleInfoByAuctionPersonList(Integer auctionId, String memberSid, String idCardNum,
            Model model) {
        List<AuctionDataUploadVO> auctionDataUploads = auctionDataUploadService.getVehicleInfoByAuctionPerson(auctionId,
                memberSid, idCardNum, null);
        model.addAttribute("auctionDataUploads", auctionDataUploads);
        return "adumanage/viewBymem/vehicle-list";
    }

    /**
     * 功能描述: 检查list是否合法<br>
     *
     * @param list
     * @return
     */
    public JsonResult checkList(List<List<List<String>>> list) {
        Map<String, Integer> idCardNums = new HashMap<>();// 身份证号
        Map<String, Integer> auctionCardNums = new HashMap<>();// 拍卖号牌
        Map<String, Integer> auctionCardNums2 = new HashMap<>();// 第二个sheet中的拍卖号牌
        Map<String, Integer> auctionVehicleOrderNums = new HashMap<>();// 拍品编号
        if (list != null && list.size() > 0) {
            List<List<String>> sheet1 = list.get(0);
            if (sheet1.size() > 0) {
                for (int i = 1; i < sheet1.size(); i++) {
                    List<String> row = sheet1.get(i);
                    if (StringUtils.isBlank(row.get(0)) || StringUtils.isBlank(row.get(1))
                            || StringUtils.isBlank(row.get(3))) {
                        return new JsonResult(false, "数据不完整!参拍商户登记数据表中参拍人、身份证和拍卖号牌为必填项!错误行数:" + (i + 1));
                    }
                    if (!NumberUtils.isDigits(row.get(3))) {
                        return new JsonResult(false, "数据校验错误!参拍商户登记数据表中拍卖号牌应该是数字!错误行数:" + (i + 1));
                    }
                    if (idCardNums.containsKey(row.get(1))) {
                        return new JsonResult(false,
                                "数据校验错误!参拍商户登记数据表中身份证号" + idCardNums.get(row.get(1)) + "行和" + (i + 1) + "行" + "有重复!");
                    }
                    if (auctionCardNums.containsKey(row.get(3))) {
                        return new JsonResult(false, "数据校验错误!参拍商户登记数据表中拍卖号牌" + auctionCardNums.get(row.get(3)) + "行和"
                                + (i + 1) + "行" + "有重复!");
                    }
                    idCardNums.put(row.get(1), i + 1);
                    auctionCardNums.put(row.get(3), i + 1);
                }
            } else {
                return new JsonResult(false, "数据不完整!");
            }
            List<List<String>> sheet2 = list.get(1);
            if (sheet2.size() > 0) {
                for (int i = 1; i < sheet2.size(); i++) {
                    List<String> row = sheet2.get(i);
                    if (StringUtils.isBlank(row.get(0))) {
                        return new JsonResult(false, "数据不完整!车辆拍卖结果登记数据表中拍品编号为必填项!错误行数:" + (i + 1));
                    }
                    if (!NumberUtils.isDigits(row.get(0))) {
                        return new JsonResult(false, "数据校验错误!车辆拍卖结果登记数据表中拍品编号应该是数字!错误行数:" + (i + 1));
                    }
                    if (StringUtils.isNotBlank(row.get(1)) && !NumberUtils.isDigits(row.get(1))) {
                        return new JsonResult(false, "数据校验错误!车辆拍卖结果登记数据表中拍卖号牌应该是数字!错误行数:" + (i + 1));
                    }
                    if (!((StringUtils.isNotBlank(row.get(1)) && StringUtils.isNotBlank(row.get(2))
                            && StringUtils.isNotBlank(row.get(3)))
                            || (StringUtils.isBlank(row.get(1)) && StringUtils.isBlank(row.get(2))
                                    && StringUtils.isBlank(row.get(3))))) {
                        return new JsonResult(false, "数据校验错误!车辆拍卖结果登记数据表中拍卖号牌、成交时间和成交价格必须一致!错误行数:" + (i + 1));
                    }
                    if (auctionVehicleOrderNums.containsKey(row.get(0))) {
                        return new JsonResult(false, "数据校验错误!参拍商户登记数据表中拍品编号" + auctionVehicleOrderNums.get(row.get(0))
                                + "行和" + (i + 1) + "行" + "有重复!");
                    }
                    if (StringUtils.isNotBlank(row.get(1))) {
                        auctionCardNums2.put(row.get(1), i + 1);
                    }
                    auctionVehicleOrderNums.put(row.get(0), i + 1);
                }
            } else {
                return new JsonResult(false, "数据不完整!");
            }
            // 校验填写的拍卖号牌是否一致
            List<String> canpaiNum = new ArrayList<String>();
            canpaiNum.addAll(auctionCardNums.keySet());
            List<String> canpaiNum2 = new ArrayList<String>();
            canpaiNum2.addAll(auctionCardNums2.keySet());
            for (String str : canpaiNum2) {
                if (!canpaiNum.contains(str)) {
                    return new JsonResult(false, str + "号拍卖号牌在参拍人中不存在!请重新上传");
                }
            }
            return new JsonResult(true);
        } else {
            return new JsonResult(false, "表格无数据!");
        }
    }

    @RequiresPermissions("auct:adumanage:exportFile")
    @RequestMapping("/exportExcel")
    public void ExportExcel(String[] exportCol, AuctionDataUploadVO auctionDataUploadVO, HttpServletRequest request,
            HttpServletResponse response) {
        Integer dataFlag = auctionDataUploadVO.getDataFlag();
        if (null == dataFlag) {
            dataFlag = Integer.valueOf(1);
            auctionDataUploadVO.setDataFlag(dataFlag);
        }

        Boolean isShowDeal = auctionDataUploadVO.getIsShowDeal();
        if (null == isShowDeal) {
            isShowDeal = Boolean.valueOf(true);
            auctionDataUploadVO.setIsShowDeal(isShowDeal);
        }
        Boolean isShowUndeal = auctionDataUploadVO.getIsShowUndeal();
        if (null == isShowUndeal) {
            isShowUndeal = Boolean.valueOf(true);
            auctionDataUploadVO.setIsShowUndeal(isShowUndeal);
        }
        Pagination pagination = new Pagination(0, 10000000);
        pagination = auctionDataUploadService.selectPage(pagination, auctionDataUploadVO);
        if (pagination.getDataList() == null || pagination.getDataList().size() == 0) {
            try {
                response.getWriter().write("<font color='red'>no data!</font>");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        if (pagination.getCount() > 10000) {
            try {
                response.setContentType("text/plain; charset=utf-8");
                response.getWriter().write("数据超过10000条，请分批导出!");
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        } else {
            exportExcelUtil.setDateFormat("yyyy-MM-dd");
            exportExcelUtil.exportExcel(Arrays.asList(exportCol), pagination.getDataList(), response, "拍卖数据导出");

            AuctionUploadLog log = new AuctionUploadLog();
            log.setAuctionId(auctionDataUploadVO.getAuctionId());
            log.setOperType(2);
            log.setDealNum(auctionDataUploadVO.getDealVehicleSum());
            log.setCreateTime(new Date());
            log.setCreatedBy(getUser().getId());
            auctionUploadLogService.insertLog(log);
        }
    }

    @RequestMapping("/download")
    public String download(String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        java.io.BufferedInputStream bis = null;
        java.io.BufferedOutputStream bos = null;
        String ctxPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/download/";
        String downLoadPath = ctxPath + fileName;
        try {
            long fileLength = new File(downLoadPath).length();
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-disposition",
                    "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            response.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
}