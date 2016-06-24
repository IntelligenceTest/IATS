/*
 * Copyright (C), 2014-2014, 上海澍勋电子商务有限公司 FileName: BaseController.java Author: long.yu Date: 2014年12月24日 下午1:06:55
 * Description: //模块目的、功能描述 History: //修改记录 <author> <time> <version> <desc> 修改人姓名 修改时间 版本号 描述
 */
package com.autostreets.biz.auction.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.autostreets.biz.auction.constants.SmsConstants;
import com.autostreets.biz.auction.web.utils.ExportExcelUtil;
import com.autostreets.biz.common.utils.DateUtil;
import com.autostreets.biz.sys.constants.SysConstants;
import com.autostreets.biz.sys.dto.DataPermissionDto;
import com.autostreets.biz.sys.model.auth.Resource;
import com.autostreets.biz.sys.model.auth.Role;
import com.autostreets.biz.sys.model.dict.DictArea;
import com.autostreets.biz.sys.model.user.User;
import com.autostreets.biz.sys.service.dict.DictAreaService;
import com.autostreets.biz.sys.web.utils.UserCache;
import com.autostreets.biz.sys.web.utils.UserUtils;

/**
 * controller基类
 * 
 * @author wei.liao
 */
public abstract class BaseController {

    protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected String datePattern = "yyyy-MM-dd"; // 默认日期格式

    @Autowired
    protected DictAreaService dictAreaService;

    @Autowired
    protected ExportExcelUtil exportExcelUtil;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        DateFormat df = new SimpleDateFormat(datePattern);
        CustomDateEditor editor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    protected List<DictArea> getCitys(String proId) {
        return dictAreaService.selectAllCityByProvince(proId);
    }

    /**
     * 功能描述: 获取用户基本信息<br>
     */
    public User getUser() {
        return UserUtils.getUser();
    }

    /**
     * 功能描述: 刷新用户信息<br>
     * 
     * @param isRefresh
     */
    public User getUser(boolean isRefresh) {
        if (isRefresh) {
            UserCache.removeCache(SysConstants.CACHE_USER);
        }
        return getUser();
    }

    /**
     * 功能描述: 获取用户角色（role对象）<br>
     */
    public List<Role> getRoleList() {
        return UserUtils.getRoleList();
    }

    /**
     * 功能描述: 获取用户角色（roleId）<br>
     */
    public List<Integer> getRoles() {
        return UserUtils.getRoles();
    }

    /**
     * 功能描述: 获取资源列表<br>
     */
    public List<Resource> getResourceList() {
        return UserUtils.getResourceList();
    }

    /**
     * 功能描述: 根据用户名查询用户信息<br>
     */
    public User getUserById(String id) {
        return UserUtils.getUserById(id);
    }

    /**
     * 功能描述: 数据权限计算<br>
     */
    public DataPermissionDto getDataPermissionDto() throws Exception {
        return UserUtils.getDataPermissionDto();
    }

    /**
     * 功能描述: 获取Request请求<br>
     */
    protected static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    public static String getRelativeUrl() {
        return getRequest().getServletPath();
    }

    /**
     * 是否是拍卖
     * 
     * @return boolean
     * @author youpeng.zhang Date: 2015年8月21日 下午1:20:34
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    protected boolean isAuction(String requirementType) {
        return StringUtils.indexOf(requirementType, "拍卖") == -1 ? false : true;
    }

    /**
     * 车辆销售状态转换
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月21日 下午1:34:58
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    protected String formatStatusSale(Short saleStatus) {
        if (null == saleStatus)
            return "【空】";

        switch (saleStatus) {
            case 0:
                return "0【待售】";
            case 1:
                return "1【出售中】";
            case 2:
                return "2【已出售】";
            default:
                return saleStatus + "【未匹配】";
        }
    }

    /**
     * getLogInfo
     * 
     * @return StringBuffer
     * @author youpeng.zhang Date: 2015年8月21日 下午1:36:55
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    protected StringBuffer getLogInfo() {
        return new StringBuffer("）#操作人（" + getUser().getUsername() + "）#操作时间（");
    }

    /**
     * 
     * 撤拍更新为取消订单
     * 
     * @return String
     * @author youpeng.zhang Date: 2015年8月21日 下午2:26:18
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    protected String formatStatusAuction(Integer status) {
        if (status == null)
            return "【空】";

        switch (status) {
            case 0:
                return "0【待拍卖】";
            case 1:
                return "1【已上架】";
            case 2:
                return "2【拍卖成功】";
            case 3:
                return "3【成交确认】";
            case 4:
                return "4【流拍】";
            case 5:
                return "5【正在拍】";
            case 6:
                return "6【暂停】";
            case 7:
                return "7【撤拍】";
            default:
                return status + "【未匹配】";
        }
    }

    /**
     * 竞拍区域校验
     * 
     * @return boolean
     * @author youpeng.zhang Date: 2015年8月24日 下午2:25:11
     * @see [相关类/方法]（可选）
     * @since [产品/模块版本] （可选）
     */
    protected boolean checkArea(String province, String city) {
        if (StringUtils.isBlank(province) || StringUtils.isBlank(city)) {
            return false;
        }
        // 判断省是否存在
        boolean result = false;
        List<DictArea> provList = dictAreaService.selectAllProvince();

        for (DictArea prov : provList) {
            if (province.equals(prov.getProvince())) {
                result = true;
            }
        }

        if (!result) {
            return false;
        }
        // 判断市是否存在
        result = false;
        List<DictArea> cityList = dictAreaService.selectAllCityByProvince(province);
        for (DictArea curcity : cityList) {
            if (city.equals(curcity.getCity())) {
                result = true;
            }
        }
        if (!result) {
            return false;
        }

        return true;
    }

    protected String excelExtNameEqualTime(String modelName, String attr, Date startTime, Date endTime) {
        return excelExtName(modelName, attr, startTime, endTime, true);
    }

    /**
     * <pre>
     * 1.如果起始时间都为空（全选）则只生成业务名；<br>
     * 2.如果只选择了开始时间，则生成业务类型时间>=查询时间；<br>
     * 3.如果只选择了结束时间，则生成业务类型时间<=查询时间；<br>
     * 4.时间查询方式：只选择一个时间时按等于或大于小于查询，true按等于查询、false按大于小于查询<br>
     * 如：精品二手车报表（入库日期20141022-20141026）
     * </pre>
     * 
     * @Title: excelExtName
     * @Description: 按查询时间生成追加excel文件名
     * @param modelName
     *            大业务名，如：精品二手车报表
     * @param attr
     *            查询时间业务名，如：入库日期
     * @param startTime
     *            开始时间
     * @param endTime
     *            结束时间
     * @param isEqualTime
     *            时间查询方式
     * @return String
     * @throws @author yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年10月22日 上午11:05:30
     */
    private String excelExtName(String modelName, String attr, Date startTime, Date endTime, boolean isEqualTime) {

        if (null == startTime && null == endTime)
            return modelName;

        String pattern1 = "＝";
        String pattern2 = pattern1;
        if (!isEqualTime) {
            pattern1 = "＞＝";
            pattern2 = "＜＝";
        }

        String dateStr = null;
        StringBuffer fullName = new StringBuffer("（" + attr);
        if (null != startTime && null != endTime) {
            dateStr = DateFormatUtils.format(startTime, DateUtil.PURE_DATE_FORMAT_STR) + "-"
                    + DateFormatUtils.format(endTime, DateUtil.PURE_DATE_FORMAT_STR);
        } else if (null != startTime && null == endTime) {
            dateStr = pattern1 + DateFormatUtils.format(startTime, DateUtil.PURE_DATE_FORMAT_STR);
        } else if (null == startTime && null != endTime) {
            dateStr = pattern2 + DateFormatUtils.format(endTime, DateUtil.PURE_DATE_FORMAT_STR);
        }
        fullName.append(dateStr + "）");

        return modelName + fullName.toString();
    }

    protected boolean isSale(Integer requirementType) {
        return requirementType == 1 ? true : false;
    }

    /**
     * @Title: formatSmsReturnCode
     * @Description: 短信返回码中文转换
     * @param smsStatus
     *            返回码
     * @return String 中文说明
     * @throws
     * @author yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年12月4日 下午2:29:57
     */
    protected String formatSmsReturnCode(final String smsStatus) {
        if (StringUtils.isBlank(smsStatus)) {
            return "短信商返回异常";
        }

        switch (smsStatus) {
            case SmsConstants.FAIL_BALANCE_ERROR:
                return SmsConstants.FAIL_BALANCE_ERROR_TEXT;
            case SmsConstants.FAIL_BLACKLIST:
                return SmsConstants.FAIL_BLACKLIST_TEXT;
            case SmsConstants.FAIL_CHANNEL_ERROR:
                return SmsConstants.FAIL_CHANNEL_ERROR_TEXT;
            case SmsConstants.FAIL_INTERFACE_ERROR:
                return SmsConstants.FAIL_INTERFACE_ERROR_TEXT;
            case SmsConstants.FAIL_INVALID_PHONE:
                return SmsConstants.FAIL_INVALID_PHONE_TEXT;
            case SmsConstants.FAIL_LENGTH_SIGNATURE_ERROR:
                return SmsConstants.FAIL_LENGTH_SIGNATURE_ERROR_TEXT;
            case SmsConstants.FAIL_SIGNATURE_ERROR:
                return SmsConstants.FAIL_SIGNATURE_ERROR_TEXT;
            case SmsConstants.FAIL_SMSUSER_INVALIDDATE:
                return SmsConstants.FAIL_SMSUSER_INVALIDDATE_TEXT;
            case SmsConstants.FAIL_TEMPLATE_DIFF_FILING:
                return SmsConstants.FAIL_TEMPLATE_DIFF_FILING_TEXT;
            case SmsConstants.FAIL_USERNAMEORPWD_ERROR:
                return SmsConstants.FAIL_USERNAMEORPWD_ERROR_TEXT;
            default:
                return smsStatus;
        }
    }

    /**
     * <pre>
     * 短信发送状态
     * true ---> 发送成功
     * false -->发送失败
     * </pre>
     * 
     * @Title: smsSendSuccess
     * @Description: 判断短信是否发送成功
     * @param returnCode
     *            短信发送返回码
     * @return boolean 发送成功true
     * @throws
     * @author yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年12月4日 下午2:47:32
     */
    protected boolean smsSendSuccess(final String returnCode) {
        return !Arrays.asList(SmsConstants.FAIL_ERRORS).contains(returnCode);
    }
}