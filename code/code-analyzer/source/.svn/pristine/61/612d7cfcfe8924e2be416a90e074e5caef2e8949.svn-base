package com.autostreets.biz.auction.web.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.autostreets.biz.auction.constants.Constants;
import com.autostreets.biz.auction.enums.NoHaggleAgeRangeEnum;
import com.autostreets.biz.auction.enums.NoHaggleMileRangeEnum;
import com.autostreets.biz.auction.enums.NoHagglePriceRangeEnum;
import com.autostreets.biz.auction.service.AuctionDictionaryService;
import com.autostreets.web.util.RequestUtils;

public abstract class BaseController {

    @Autowired
    protected AuctionDictionaryService auctionDictionaryService;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ModelAttribute("baseDomain")
    public String getBaseDomain() {
        return Constants.BASE_DOMAIN;
    }

    @ModelAttribute("staticDomain")
    public String getStaticDomain() {
        return Constants.STATIC_DOMAIN;
    }

    @ModelAttribute("homeDomain")
    public String getHomeDomain() {
        return Constants.HOME_DOMAIN;
    }

    @ModelAttribute("newDomain")
    public String getNewDomain() {
        return Constants.NEW_DOMAIN;
    }

    @ModelAttribute("imageDomain")
    public String getImageDomain() {
        return Constants.IMAGE_DOMAIN;
    }

    @ModelAttribute("parentDomain")
    public String getParentDomain() {
        return Constants.PARENT_HOME_DOMAIN;
    }

    @ModelAttribute("yDomain")
    public String getYDomain() {
        return Constants.YDOMAIN;
    }

    @ModelAttribute("base")
    public String getBase() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request.getContextPath();
    }

    @ModelAttribute("staticTime")
    public String getStaticTime() {
        return Constants.STATIC_TIME;
    }

    //
    // @InitBinder
    // public void initBinder(WebDataBinder binder) {
    // binder.registerCustomEditor(String.class, new StringEscapeEditor(true,
    // false, false));
    // }

    public String subString1(String str, int max) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if ((c & 0xff00) != 0)
                sum += 2;
            else
                sum += 1;
        }

        if (str != null && sum > max) {
            sum = 0;
            StringBuilder sb = new StringBuilder(max);
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i);
                if ((c & 0xff00) != 0)
                    sum += 2;
                else
                    sum += 1;
                if (sum <= max)
                    sb.append((char) c);
                else
                    break;
            }
            return sb.append("...").toString();
        } else
            return str != null ? str : "";
    }

    public String getPaginationUrl(int pageNumber) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String url = RequestUtils.getRequestURIWithQueryString(request);
        return RequestUtils.replaceParamValue(url, "pageNumber", pageNumber == 1 ? null : String.valueOf(pageNumber));
    }

    public String getPaginationUrl(int pageSize, int pageNumber) {
        String url = getPaginationUrl(pageNumber);
        return RequestUtils.replaceParamValue(url, "pageSize", String.valueOf(pageSize));
    }

    public String getThumbImgUrl(String spec, String imgUrl) {
        return auctionDictionaryService.choiceImgUrl(spec, imgUrl);
    }

    //
    // private Map<String, Object> loginUserSid() {
    // Map<String, Object> loginUserMap = null;
    // Assertion assertion = AssertionHolder.getAssertion();
    // if (null != assertion) {
    // AttributePrincipal principal = assertion.getPrincipal();
    // if (principal != null) {
    // loginUserMap = new HashMap<String, Object>();
    // loginUserMap.put("username", principal.getName());
    // Map<String, Object> userMap = principal.getAttributes();
    // if (userMap.containsKey("sid")) {
    // loginUserMap.put("sid", (String) userMap.get("sid"));
    // }
    // }
    // }
    // return loginUserMap;
    // }

    public String format(BigDecimal x) {
        StringBuilder sb = new StringBuilder();
        String s = x.setScale(0, BigDecimal.ROUND_CEILING).toString();
        if (s.length() > 4) {
            sb.append("<i>").append(s.substring(0, s.length() - 4)).append("</i>").append(s.substring(s.length() - 4));
        } else {
            sb.append(s);
        }
        return sb.toString();
    }

    // /**
    // * 功能描述: <br>
    // * 〈功能详细描述〉
    // *
    // * @author jingzhou.zhao
    // * @return
    // * @see [相关类/方法](可选)
    // * @since [产品/模块版本](可选)
    // */
    // protected String getMemberSid() {
    // Map<String, Object> map = loginUserSid();
    // if (map != null && map.containsKey("sid")) {
    // return map.get("sid").toString();
    // }
    // return null;
    // }

    // ---------------------------------------2015年12月版首页需用controller---------------------------------------

    /**
     * 
     * 功能描述:获取二手车价格区间 <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @ModelAttribute("usedCarPrice")
    public List<TreeMap<String, String>> paramListPrice() {
        return NoHagglePriceRangeEnum.getList();
    }

    /**
     * 
     * 功能描述: 获取二手车车龄区间<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @ModelAttribute("usedCarAge")
    public List<TreeMap<String, String>> paramListAge() {
        return NoHaggleAgeRangeEnum.getList();
    }

    /**
     * 
     * 功能描述: 获取二手车里程区间<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @ModelAttribute("usedCarMile")
    public List<TreeMap<String, String>> paramListMile() {
        return NoHaggleMileRangeEnum.getList();
    }
}