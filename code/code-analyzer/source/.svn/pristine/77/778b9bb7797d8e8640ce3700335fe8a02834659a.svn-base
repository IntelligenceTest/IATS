/**
 * @Title: ExportExcelUtil.java
 * @Package com.autostreets.web.common.util
 * @Description:
 * @author yanqing.luo （roceys#gmail.com）
 * @date 2014-10-20 13:09:44
 * @version V3.0
 * @Copyright: 2014 www.autostreets.com Inc. All rights reserved.
 * 本内容仅限于汽车街(AUTOSTREETS)内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.autostreets.biz.auction.web.utils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.autostreets.biz.auction.model.AuctionDictionary;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.biz.common.utils.DateUtil;

/**
 * <pre>
 * excel导出公用类
 * v1.0（jie.xu）<br>
 * v2.0（zhenxing.li）：<br>
 * 1.增加Office EXCEL 2003、2007版本处理
 * 2.更新数字类型为数值单元格而非文本格式
 * 3.增加单元格自动宽度适应<br>
 * v3.0（yanqing.luo）：<br>
 * 1.增加列样式
 * 2.增加处理特殊数字字段--patternMath
 * 3.增加字符中含浮点数的校验
 * 4.优化循环反射取值效率
 * 5.过滤身份证不作为数值处理
 * 6.修复单元格自动宽度调整无效bug<br>
 * </pre>
 * 
 * @author jie.xu 2014年8月28日 上午11:43:18
 * @author zhenxing.li 2014年10月15日
 * @author yanqing.luo 2014年10月16日 10:51:26
 * @version v3.0
 */
@Component("exportExcelUtil")
public class ExportExcelUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ExportExcelUtil.class);
    @Autowired
    private AuctionDictionaryService auctionDictionaryService;
    private CellStyle titleStyle;
    private Font titleFont;// 标题行字体样式
    private Workbook wb = null; // 根据不同的版本生成不同的Workbook对象
    private static final String patternMath[] = new String[] {"frameScore"};// 数字类型需要特殊处理的字段集
    private static final char floating[] = {'e', 'E', 'f', 'F', 'd', 'D', 'l', 'L'};// 浮点数判断
    Map<String, Map<String, String>> dictionaryMap = new HashMap<String, Map<String, String>>();
    private String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private Map<String, Method> methodMap = new HashMap<>();

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public ExportExcelUtil() {
    }

    public ExportExcelUtil(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * 
     */
    public void initDictionary() {
        Map<String, String> tempMap = null;
        List<AuctionDictionary> auctionDictionaries = auctionDictionaryService.selectByExample(null);
        for (AuctionDictionary auctionDictionary : auctionDictionaries) {
            if (dictionaryMap.containsKey(auctionDictionary.getCategory())) {
                dictionaryMap.get(auctionDictionary.getCategory()).put(auctionDictionary.getValue(),
                        auctionDictionary.getName());
            } else {
                tempMap = new HashMap<String, String>();
                tempMap.put(auctionDictionary.getValue(), auctionDictionary.getName());
                dictionaryMap.put(auctionDictionary.getCategory(), tempMap);
            }
        }
    }

    /**
     * 导出excel
     * 
     * @param selectColumnList
     *            col1,col2#coltext#dictionary#auction_status1,auction_status2
     * @param values
     * @param response
     * @param fileName
     */
    public void exportExcel(List<String> selectColumnList, List<?> values, HttpServletResponse response,
            String fileName) {
        exportExcel(selectColumnList, values, response, fileName, null);
    }

    public void exportExcel(List<String> selectColumnList, List<?> values, HttpServletResponse response,
            String fileName, String versionNo) {
        initDictionary();
        LOG.info("************Excel导出处理开始***************");

        if (CollectionUtils.isEmpty(values) || CollectionUtils.isEmpty(selectColumnList) || null == response) {
            LOG.info("系统异常或没有导出excel的数据...");
            return;
        }

        try (BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());) { // 使用Java7（try-with-source）新特性，能够自动关闭文件流

            String nameFormat = "%s_%s.xls"; // 版本格式：2003为xls，2007为xlsx
            if ("2007".equals(versionNo)) {
                LOG.info("**************Office 2007 版本**************");
                nameFormat = nameFormat + "x";
                wb = new XSSFWorkbook();
            } else {
                LOG.info("**************Office 2003 版本**************");
                wb = new HSSFWorkbook();
            }

            String fname = String.format(nameFormat, fileName, DateUtil.formatPureMiddleDatetime(new Date()));
            LOG.info("************Excel导出文件名为（" + fname + "）***************");

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition",
                    "attachment; filename=" + new String(fname.getBytes("GBK"), "ISO8859-1"));

            Object obj1 = values.get(0);
            Class<? extends Object> clazz = obj1.getClass();

            init();
            Sheet sheet = wb.createSheet();
            for (int i = 0; i < selectColumnList.size() + 1; i++) {
                sheet.autoSizeColumn(i);
                if (sheet.getColumnWidth(i) + 600 > 255 * 256) {
                    sheet.setColumnWidth(i, 255 * 256);
                } else {
                    sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 600);
                }
            }
            Row headerRow = sheet.createRow(0), valRow;
            Cell cell;

            int n = 0;
            for (String str : selectColumnList) {
                cell = headerRow.createCell(n);
                cell.setCellStyle(titleStyle);
                cell.setCellValue(str.split("#")[1]);
                ++n;
            }

            for (int j = 0; j < values.size(); j++) {
                valRow = sheet.createRow(j + 1);

                for (int k = 0; k < selectColumnList.size(); k++) {
                    String strKey = selectColumnList.get(k);
                    cell = valRow.createCell(k);

                    String[] keyPropArray = strKey.split("#");
                    String key = keyPropArray[0];
                    String dbQueryCol = null;

                    if (keyPropArray.length == 4)
                        dbQueryCol = keyPropArray[3];

                    String callValue = getCellValue(key, clazz, values.get(j), dbQueryCol);
                    if (isXNumber(callValue)) {
                        cell.setCellValue(Double.parseDouble(callValue));
                    } else {
                        cell.setCellValue(callValue);
                    }
                }
            }
            LOG.info("************Excel生成完成，准备导出***************");
            wb.write(bos);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException | IOException e) {
            LOG.error(e.getMessage(), e);
        }
        LOG.info("************Excel导出处理结束***************");
    }

    /**
     * @param key
     * @return
     */
    private static String getMethodByColName(String key) {
        String methodName = "get" + key.substring(0, 1).toUpperCase() + key.substring(1);
        return methodName;
    }

    /**
     * 时间数据转换由日期修改为时间（yyyy-MM-dd HH:mm:ss）
     * 
     * @Title: getCellValue
     * @Description:
     * @param key
     * @param clazz
     * @param obj
     * @param dbQueryCol
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @return String
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年10月16日 下午4:31:19
     */
    private String getCellValue(String key, Class<? extends Object> clazz, Object obj, String dbQueryCol)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException {

        String[] dbQueryColArray = null;
        if (dbQueryCol != null) {
            dbQueryColArray = dbQueryCol.split(",");
        }
        String[] subKeys = key.split(",");
        StringBuffer sb = new StringBuffer();
        outer: for (int i = 0; i < subKeys.length; i++) {
            String sub = subKeys[i];
            Object value = null;
            if (sub.indexOf(".") != -1) {
                // 处理对象里嵌套对象的情况
                String[] compositeArray = sub.split("\\.");
                String m = null;
                for (int c = 0; c < compositeArray.length; c++) {
                    m = getMethodByColName(compositeArray[c]);
                    Method method = null;
                    if (methodMap.get(clazz.getName() + "-" + m) == null) {
                        method = clazz.getMethod(m);
                        methodMap.put(clazz.getName() + "-" + m, method);
                    } else {
                        method = methodMap.get(clazz.getName() + "-" + m);
                    }
                    value = method.invoke(obj);
                    if (value == null) {
                        break outer;
                    }
                    if (c < compositeArray.length - 1) {
                        clazz = value.getClass();
                        obj = value;
                    }
                }
            } else {
                String methodName = getMethodByColName(sub);
                Method method = null;
                if (methodMap.get(clazz.getName() + "-" + methodName) == null) {
                    method = clazz.getMethod(methodName);
                    methodMap.put(clazz.getName() + "-" + methodName, method);
                } else {
                    method = methodMap.get(clazz.getName() + "-" + methodName);
                }
                value = method.invoke(obj);
            }

            if (value == null) {
                continue;
            }

            if (value instanceof Date) {
                sb.append(DateFormatUtils.format((Date) value, dateFormat));
            } else if (StringUtils.indexOfAny(sub, patternMath) > -1 && value instanceof Number) {
                BigDecimal temp = (BigDecimal) value;
                sb.append(temp.setScale(0, RoundingMode.HALF_UP).toString());
            } else {
                if (dbQueryCol != null) {
                    if (i <= dbQueryColArray.length - 1) {
                        value = dictionaryMap.get(dbQueryColArray[i]).get(String.valueOf(value));
                    }
                }
                sb.append(value != null ? value.toString() : StringUtils.EMPTY);
            }
        }
        return sb.toString();
    }

    /**
     * <pre>
     * 数字判断，以下情况返回true：<br>
     * 1.长度小于13位 2.非浮点数(double\float...)
     * </pre>
     * 
     * @Title: isXNumber
     * @Description: 数字判断
     * @param value
     * @return boolean
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年10月20日 下午2:15:27
     */
    private boolean isXNumber(String value) {
        return StringUtils.length(value) < 13 && NumberUtils.isNumber(value)
                && StringUtils.indexOfAny(value, floating) == -1;
    }

    /**
     * @Title: init
     * @Description: 样式初始化
     * @return void
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年10月20日 上午11:25:58
     */
    private void init() {
        titleStyle = wb.createCellStyle();
        titleFont = wb.createFont();
        initTitleFont();

        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        titleStyle.setFont(titleFont);
        titleStyle.setFillBackgroundColor(IndexedColors.SKY_BLUE.index);

    }

    /**
     * @Title: initTitleFont
     * @Description: 初始化标题字体
     * @return void
     * @throws @author
     *             yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年10月20日 上午11:25:38
     */
    private void initTitleFont() {
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short) 10);
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        titleFont.setCharSet(Font.DEFAULT_CHARSET);
        titleFont.setColor(IndexedColors.BLUE_GREY.index);
    }
}
