package com.autostreets.biz.auction.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.autostreets.web.util.RequestUtils;

public abstract class PaginationController extends BaseController {

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

}
