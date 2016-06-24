package com.autostreets.biz.auction.web.filter;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateUtils;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.util.StringUtils;

import com.autostreets.web.constant.Constants;
import com.autostreets.web.util.Config;
import com.autostreets.web.util.CookieUtils;
import com.autostreets.web.util.UserIdentityUtils;
import com.autostreets.web.vo.UserIdentity;

public class PassportFilter implements Filter {

	private static String wapWebsiteAddr = "http://wap.autostreets.com";
	
	private static String mobileGateWayHeaders[] = new String[] {
		"ZXWAP", "chinamobile.com", "monternet.com", "infoX", "XMS 724Solutions HTG", "wap.lizongbo.com", "Bytemobile"
	};

	// 电脑上的IE或Firefox浏览器等的User-Agent关键词
	private static String[] pcHeaders = new String[] {
		"Windows 98", "Windows ME", "Windows 2000", "Windows XP", "Windows NT", "Ubuntu"
	};

	// 手机浏览器的User-Agent里的关键词
	private static String[] mobileUserAgents = new String[] {
		"Nokia", "SAMSUNG", "MIDP-2", "CLDC1.1", "SymbianOS", "MAUI", "UNTRUSTED/1.0", "Windows CE", "iPhone", 
		"Android", "BlackBerry", "UCWEB", "ucweb", "BREW", "J2ME", "YULONG", "YuLong", "COOLPAD", "TIANYU",
		"TY-", "K-Touch", "Haier", "DOPOD", "Lenovo", "LENOVO", "HUAQIN", "AIGO-", "CTC/1.0", "CTC/2.0", "CMCC", 
		"DAXIAN", "MOT-", "SonyEricsson", "GIONEE", "HTC", "ZTE", "HUAWEI", "webOS", "GoBrowser", "IEMobile", "WAP2.0"
	};
	
    private boolean loginRequiredDefault = true;
    private List<Pattern> loginRequiredUrlPatterns = new LinkedList<Pattern>();
    private List<Pattern> loginIgnoredUrlPatterns = new LinkedList<Pattern>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        loadConfig();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        boolean login = isLogin(request);

        if (login) {
            if (isSessionExpired(request)) {
                removeCookie(request, response);
            } else {
              //如果是忽略登录cookie的不去更新cookie的时间
                if (isLoginRequired(request)) {
                    updateLastVisitTime(request, response);
                }
            }
        }
        
        if (isMobileDevice(request)) {
        	response.sendRedirect(wapWebsiteAddr);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    private void loadConfig() {
        loginRequiredDefault = !"false".equals(Config.getConfig().get("login.required.default"));

        String loginRequiredUrlRegex = Config.getConfig().get("login.required.url.regex");
        if (!StringUtils.isEmpty(loginRequiredUrlRegex)) {
            String[] regexes = loginRequiredUrlRegex.split(",");
            for (String regex : regexes) {
                loginRequiredUrlPatterns.add(Pattern.compile(regex.trim()));
            }
        }

        String loginIgnoredUrlRegex = Config.getConfig().get("login.ignored.url.regex");
        if (!StringUtils.isEmpty(loginIgnoredUrlRegex)) {
            String[] regexes = loginIgnoredUrlRegex.split(",");
            for (String regex : regexes) {
                loginIgnoredUrlPatterns.add(Pattern.compile(regex.trim()));
            }
        }
    }

    private boolean isLoginRequired(HttpServletRequest request) {
        String uri = request.getRequestURI();

        for (Pattern pattern : loginRequiredUrlPatterns) {
            if (pattern.matcher(uri).matches()) {
                return true;
            }
        }

        for (Pattern pattern : loginIgnoredUrlPatterns) {
            if (pattern.matcher(uri).matches()) {
                return false;
            }
        }

        return loginRequiredDefault;
    }

    private boolean isLogin(HttpServletRequest request) {
        Cookie cookie = CookieUtils.getCookie(request, Constants.COOKIE_NAME);
        if (cookie == null) {
            return false;
        }

        request.setAttribute(Constants.USER_IDENTITY_KEY, UserIdentityUtils.unserialize(cookie.getValue()));

        Assertion assertion = AssertionHolder.getAssertion();
        if (assertion != null) {
            request.getSession().setAttribute(Constants.SESSION_CAS_ISLOGIN, true);
        }

        return true;
    }

    private boolean isSessionExpired(HttpServletRequest request) {
        UserIdentity userIdentity = (UserIdentity) request.getAttribute(Constants.USER_IDENTITY_KEY);
        Date expiryTime = DateUtils.addMinutes(userIdentity.getLastVisitTime(), Constants.SESSION_TIMEOUT);
        return expiryTime.before(new Date());
    }

    private void updateLastVisitTime(HttpServletRequest request, HttpServletResponse response) {
        UserIdentity userIdentity = (UserIdentity) request.getAttribute(Constants.USER_IDENTITY_KEY);
        userIdentity.setLastVisitTime(new Date());
        CookieUtils.addCookie(response, Constants.COOKIE_DOMAIN, Constants.COOKIE_PATH, Constants.COOKIE_NAME,
                UserIdentityUtils.serialize(userIdentity));
    }

    private void removeCookie(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(Constants.USER_IDENTITY_KEY, null);
        CookieUtils.removeCookie(response, Constants.COOKIE_DOMAIN, Constants.COOKIE_PATH, Constants.COOKIE_NAME);
     // cookie失效后将session失效
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute(AbstractCasFilter.CONST_CAS_ASSERTION, null);
            session.setAttribute(Constants.SESSION_CAS_ISLOGIN, null);
        }
    }
    
    /***
     * 根据当前请求的特征，判断该请求是否来自手机终端，主要检测特殊的头信息，以及user-Agent这个header
     * @param request
     * @return
     */
    public static boolean isMobileDevice(HttpServletRequest request) {
        boolean b = false;
        boolean pcFlag = false;
        boolean mobileFlag = false;
        
        String via = request.getHeader("Via");
        String userAgent = request.getHeader("user-agent");
        
        if (!StringUtils.isEmpty(via)) {
        	for (int i = 0; i < mobileGateWayHeaders.length; i++) {
        		if (via.contains(mobileGateWayHeaders[i])) {
        			mobileFlag = true;
        			break;
        		}
        	}
        }
                
        if (!mobileFlag && !StringUtils.isEmpty(userAgent)) {
        	for (int i = 0; i < mobileUserAgents.length; i++) {
        		if (userAgent.contains(mobileUserAgents[i])) {
        			mobileFlag = true;
        			break;
        		}
        	}
        }

        if (!StringUtils.isEmpty(userAgent)) {
        	for (int i = 0; i < pcHeaders.length; i++) {
        		if (userAgent.contains(pcHeaders[i])) {
        			pcFlag = true;
        			break;
        		}
        	}
        }
        
        if (mobileFlag && !pcFlag){
            b = true;
        }
        return b; //false -pc; true -wap
    }
    
}