package com.autostreets.biz.auction.web.utils;

import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Strings;

public class StringUtil {

	private static final String MOBILE_REGEX = "^[1][3,4,5,8][0-9]{9}$"; // 手机号码
	private static final String AREA_CODE_AND_CELLPHONE_REGEX = "^[0][1-9]{2,3}-[0-9]{5,10}$"; // 带区号的电话号码
	private static final String CELLPHONE_REGEX = "^[0][1-9]{2,3}-[0-9]{5,10}$"; // 没有区号的电话号码
	private static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; // email

	private StringUtil() {
	}

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static Boolean isMobile(String str) {
		Boolean b = false;
		b = str.matches(MOBILE_REGEX);
		return b;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static Boolean isPhone(String str) {
		Boolean b = false;
		if (str.length() > 9) {
			b = str.matches(AREA_CODE_AND_CELLPHONE_REGEX);
		} else {
			b = str.matches(CELLPHONE_REGEX);
		}
		return b;
	}

	/**
	 * 电子邮箱地址验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static Boolean isEmail(String str) {
		Boolean b = str.matches(EMAIL_REGEX);
		return b;
	}

	public static String mask(String s) {
		if ("线下用户".equals(s)) {
			return s;
		} else if (Strings.isNullOrEmpty(s) || s.length() <= 4) {
			return "****";
		} else {
			return String.format("%s**%s", s.substring(0, 1),
					s.substring(s.length() - 1));
		}
	}

	/**
	 * 获取客户真实IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 对输出数据进行净化
	 * 
	 * @param request
	 * @return
	 */
	public static String filter(String value) {
        if (value == null) {
            return null;
        }        
        StringBuffer result = new StringBuffer(value.length());
        for (int i=0; i<value.length(); ++i) {
            switch (value.charAt(i)) {
            case '<':
                result.append("&lt;");
                break;
            case '>': 
                result.append("&gt;");
                break;
            default:
                result.append(value.charAt(i));
                break;
            }        
        }
        return result.toString();
	}
}
