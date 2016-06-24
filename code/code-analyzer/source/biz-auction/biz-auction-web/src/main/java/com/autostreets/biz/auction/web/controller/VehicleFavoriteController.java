package com.autostreets.biz.auction.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autostreets.biz.auction.model.MemberVehicleFavorite;
import com.autostreets.biz.auction.model.MemberVehicleFavoriteExample;
import com.autostreets.biz.auction.service.MemberVehicleFavoriteService;
import com.autostreets.biz.auction.web.utils.UserIdentityUtils;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.web.vo.UserIdentity;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author jingzhou.zhao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("member/favorite")
public class VehicleFavoriteController extends BaseController {

    @Autowired
    private MemberVehicleFavoriteService memberVehicleFavoriteService;

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param avId
     * @param request
     * @param response
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody JsonResult addFavorite(Integer avId, HttpServletRequest request, HttpServletResponse response) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberSid = null;
        if (userIdentity != null) {
            memberSid = userIdentity.getId();
        }
        if (StringUtils.isEmpty(memberSid)) {
            return new JsonResult(false);
        }
        MemberVehicleFavorite mvf = new MemberVehicleFavorite();
        mvf.setMemberSid(memberSid);
        mvf.setAvId(avId);
        // mvf.setType(0);
        mvf.setCreatedTimestamp(new Date());
        memberVehicleFavoriteService.insert(mvf);
        return new JsonResult(true);
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @author jingzhou.zhao
     * @param avId
     * @param request
     * @param response
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public @ResponseBody JsonResult removeFavorite(Integer avId, HttpServletRequest request,
            HttpServletResponse response) {
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberSid = null;
        if (userIdentity != null) {
            memberSid = userIdentity.getId();
        }
        if (StringUtils.isEmpty(memberSid)) {
            return new JsonResult(false);
        }
        MemberVehicleFavoriteExample mvfe = new MemberVehicleFavoriteExample();
        MemberVehicleFavoriteExample.Criteria mvfeCriteria = mvfe.createCriteria();
        mvfeCriteria.andMemberSidEqualTo(memberSid);
        mvfeCriteria.andAvIdEqualTo(avId);

        memberVehicleFavoriteService.deleteByExample(mvfe);
        return new JsonResult(true);
    }

}
