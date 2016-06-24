package com.autostreets.biz.auction.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.autostreets.biz.auction.constants.Constants;
import com.autostreets.biz.auction.constants.OrderConstans;
import com.autostreets.biz.auction.constants.OrderConstants;
import com.autostreets.biz.auction.enums.NoHaggleAgeRangeEnum;
import com.autostreets.biz.auction.enums.NoHaggleMileRangeEnum;
import com.autostreets.biz.auction.enums.NoHagglePriceRangeEnum;
import com.autostreets.biz.auction.exception.GenericEntityException;
import com.autostreets.biz.auction.model.AppointmentUsedcar;
import com.autostreets.biz.auction.model.FixedPrice;
import com.autostreets.biz.auction.model.FixedPriceExample;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.model.Vehicle;
import com.autostreets.biz.auction.pagination.Pagination1;
import com.autostreets.biz.auction.service.AppointmentUsedcarService;
import com.autostreets.biz.auction.service.FixedPriceService;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.auction.service.VehicleService;
import com.autostreets.biz.auction.web.utils.CookieUtils;
import com.autostreets.biz.auction.web.utils.UserIdentityUtils;
import com.autostreets.biz.bi.model.OrderSourceInfo;
import com.autostreets.biz.bi.service.OrderSourceInfoService;
import com.autostreets.biz.payment.model.PayMerchant;
import com.autostreets.biz.payment.service.PayMerchantService;
import com.autostreets.biz.payment.utils.PayUtils;
import com.autostreets.biz.sys.model.user.Organization;
import com.autostreets.biz.sys.service.user.OrganizationService;
import com.autostreets.biz.usedvehicle.model.VehicleInfo;
import com.autostreets.framework.common.utils.DateUtils;
import com.autostreets.framework.common.utils.Utf8Decoder;
import com.autostreets.framework.common.web.utils.RequestUtils;
import com.autostreets.framework.common.web.vo.JsonResult;
import com.autostreets.model.FinInterestRate;
import com.autostreets.model.Member;
import com.autostreets.service.FinInterestRateService;
import com.autostreets.service.MemberService;
import com.autostreets.service.ad.AdPositionsService;
import com.autostreets.util.OrderResourceUtil;
import com.autostreets.web.vo.UserIdentity;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Controller
public class NoHaggleController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoHaggleController.class);

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private FixedPriceService fixedPriceService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private FinInterestRateService finInterestRateService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private AppointmentUsedcarService appointmentUsedcarService;

    @Autowired
    private PayMerchantService payMerchantService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrderSourceInfoService orderSourceInfoService;

    @Autowired
    private AdPositionsService adPositionsService;

    @RequestMapping(value = "/no-haggle", method = RequestMethod.GET)
    public String index(@PathVariable @RequestParam(required = false) String brand,
            @RequestParam(required = false) Integer age, @RequestParam(required = false) String pro,
            @RequestParam(required = false) String city, @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Integer mile, @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max, @RequestParam(required = false) Integer cert,
            @RequestParam(defaultValue = "30") Integer ps, @RequestParam(defaultValue = "selltime") String sb,
            @RequestParam(defaultValue = "desc") String s, @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "list") String d, HttpServletRequest request, Model model) {
        int pageSize = 30;
        Pagination1<FixedPrice> page = fixedPriceService.selectFixedPricePage(brand, age, pro, city, price, mile, min,
                max, cert, ps, sb, s, pageNumber, d, pageSize);

        // Get all province list
        List<String> provinceList = fixedPriceService.selectAllProvince();

        List<Map<String, String>> brandList = fixedPriceService.selectBrandByVehicleNum(null);

        model.addAttribute("brandList", brandList);
        model.addAttribute("brand", brand);
        model.addAttribute("city", city);
        model.addAttribute("age", age);
        model.addAttribute("price", price);
        model.addAttribute("mile", mile);
        model.addAttribute("count", page.getTotalNumberOfElements());

        model.addAttribute("minPrice", min);
        model.addAttribute("maxPrice", max);
        model.addAttribute("pageSize", ps);
        model.addAttribute("province", pro);
        model.addAttribute("sortBy", sb);
        model.addAttribute("sort", s);
        model.addAttribute("cert", cert);
        model.addAttribute("d", d);

        model.addAttribute("provinceList", provinceList);

        model.addAttribute("p", page);
        // 添加广告add by zjz at 2016-6-2 16:12:32
        model.addAttribute("topAdDetails", adPositionsService.getPositionAd(36));
        model.addAttribute("middleAdDetails", adPositionsService.getPositionAd(37));
        model.addAttribute("bottomAdDetails", adPositionsService.getPositionAd(38));
        // end;
        if ("view".equalsIgnoreCase(d)) {
            return "no-haggle/view";
        } else {
            return "no-haggle/index";
        }
    }

    @RequestMapping(value = "/no-haggle/{vehicleId}", method = RequestMethod.GET)
    public String show(@PathVariable @ModelAttribute("vehicleId") Integer vehicleId, HttpServletRequest request,
            HttpServletResponse response, Model model) {
        if (vehicleId == null) {
            throw new IllegalArgumentException();
        }

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String loginUserSid = null;
        if (userIdentity != null) {
            loginUserSid = userIdentity.getId();
        }
        Map<String, Object> map = fixedPriceService.loadVehicleInfo(vehicleId, loginUserSid);
        if (map == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        model.addAttribute("vehicle", map.get("vehicle"));
        VehicleInfo vehicleInfo = (VehicleInfo) map.get("vehicle");
        model.addAttribute("photoNum",
                vehicleInfo.getStarPhotoList() == null ? 0 : vehicleInfo.getStarPhotoList().size());
        model.addAttribute("fp", map.get("fp"));

        if (map.containsKey("logoList")) {
            model.addAttribute("logoLists", map.get("logoList"));
        }
        model.addAttribute("shop", map.get("shop")); // 所属店铺
        model.addAttribute("usedcarShop", map.get("usedcarShop")); // 获取对应二手车店铺扩展对象
        model.addAttribute("featureItem", map.get("featureItem"));
        model.addAttribute("provinceList", map.get("provinceList"));
        if (map.containsKey("favVehicleList")) {
            model.addAttribute("favVehicleList", map.get("favVehicleList"));
        }
        model.addAttribute("advInfo", map.get("advInfo"));
        if (map.containsKey("vinVehicle")) {
            model.addAttribute("vinVehicle", map.get("vinVehicle"));
        }
        model.addAttribute("vinVehicle", map.get("vinVehicle"));
        model.addAttribute("favID", map.get("favID"));
        model.addAttribute("prePrice", map.get("prePrice"));
        model.addAttribute("prepayFlag", map.get("prepayFlag"));

        // 获取贷款利率 added by HCF
        List<FinInterestRate> finInterestRates = finInterestRateService.queryAllFinInterestRate();
        if (finInterestRates.size() > 0) {
            model.addAttribute("DefaultInterestRate", finInterestRates.get(0));
        }
        model.addAttribute("finInterestRates", finInterestRates);

        model.addAttribute("savedMoney", map.get("savedMoney"));

        return "no-haggle/show";
    }

    @RequestMapping(value = "/no-haggle/nohaggle-order/{id}", method = RequestMethod.GET)
    public String toGenOrder(@PathVariable @ModelAttribute("id") Integer id, HttpServletRequest request, Model model) {
        FixedPrice fixedPrice = fixedPriceService.selectByPrimaryKey(id);
        if (fixedPrice == null) {
            LOGGER.warn("访问的车辆不存在" + id);
            return null;
        }
        model.addAttribute("fixedPrice", fixedPrice);

        Vehicle vehicle = vehicleService.selectByPrimaryKey(fixedPrice.getVehicleId());
        model.addAttribute("vehicle", vehicle);

        // 获取订金金额 use property: deposit in model：fixedPrice
        // String prePrice = auctionDictionaryService.selectNoHagglePreprice();
        String prePrice = String.valueOf(fixedPrice.getDeposit());
        model.addAttribute("prePrice", prePrice);

        Member member = null;
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String loginUserSid = null;
        if (userIdentity != null) {
            loginUserSid = userIdentity.getId();
        }
        if (StringUtils.isNotBlank(loginUserSid)) {
            member = memberService.selectByPrimaryKey(loginUserSid);
        }

        model.addAttribute("member", member);

        return "no-haggle/pay_order";
    }

    @RequestMapping(value = "/no-haggle/saveNoHaggleOrder", method = RequestMethod.GET)
    public String genOrder(HttpServletRequest request, Model model) {
        Integer productId = Integer.valueOf(request.getParameter("productId"));
        String customerName = request.getParameter("customerName");
        // String sex = request.getParameter("sex");
        String cellPhone = request.getParameter("cellPhone");
        String despositAmt = request.getParameter("depositAmt");
        String username = request.getParameter("username");
        // 检查fixprice中的数据是否可预订
        FixedPrice fp = fixedPriceService.selectByPrimaryKey(productId);
        if (null != fp && fp.getStatus() != 3) {
            return "redirect:/no-haggle/" + fp.getVehicleId();
        }
        Order order = new Order();
        order.setProductId(productId);
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String loginUserSid = null;
        if (userIdentity != null) {
            loginUserSid = userIdentity.getId();
        }
        order.setBidderSid(loginUserSid);
        order.setBidderName(customerName);
        order.setProductType(0);
        order.setBuyerCellphone(cellPhone);
        order.setOrderType(1);
        order.setSource(OrderConstans.ORDER_SOURCE_WEBSITE);
        String orderNo = null;
        try {
            orderNo = orderService.createOrder(order);
        } catch (GenericEntityException e) {
            LOGGER.error(e.getMessage(), e);
        }

        try {
            LOGGER.info("渠道推广插入数据开始");
            Cookie cookie = CookieUtils.getCookie(request, Constants.ORDER_COOKIE);
            String channelSource = null;
            if (null != cookie) {
                channelSource = cookie.getValue();
            }

            OrderSourceInfo orderSourceInfo = OrderResourceUtil.createOrderSourceInfo(orderNo, channelSource,
                    Integer.valueOf(com.autostreets.constants.OrderConstants.VOLVO_ORDER_PAY_TYPE), "new_vehicle_order",
                    order.getBidderName());
            orderSourceInfoService.insert(orderSourceInfo);
        } catch (Exception e) {
            LOGGER.error("生成订单调用BI失败orderNo:", e);
        }
        // model.addAttribute("billNo", SequenceUtils.nextValue("netpay_id"));
        model.addAttribute("orgbillNo", orderNo);
        model.addAttribute("despositAmt", despositAmt);
        model.addAttribute("cellPhone", cellPhone);
        model.addAttribute("orderType", "04");
        model.addAttribute("username", username);

        SimpleDateFormat billDateFmt = new SimpleDateFormat("yyyyMMdd");
        model.addAttribute("billDate", billDateFmt.format(new Date()));
        order = orderService.loadByOrderNo(orderNo);
        return "redirect:/no-haggle/netpay?orderId=" + order.getId();
    }

    /**
     * 
     * 功能描述: <br>
     * 统一到支付网关 〈功能详细描述〉
     * 
     * @param request
     * @param orgbillNo
     * @param model
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * @Date 2015年2月27日 上午9:43:51
     * @author tao.huang
     */
    @RequestMapping(value = "/no-haggle/netpay", method = RequestMethod.GET)
    public String netpay(HttpServletRequest request, Integer orderId, Model model) {
        Order order = orderService.selectByPrimaryKey(orderId);
        if (order == null) {
            LOGGER.warn("订单不存在,id:" + orderId);
            return null;
        }
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(order.getId());
        Vehicle vehicle = null;
        if (null != orderItem) {
            vehicle = vehicleService.selectByPrimaryKey(orderItem.getVehicleId());
        }
        Map<String, String> params = new HashMap<>();
        // 订单号
        params.put("outTradeNo", order.getOrderNo());
        // 金额,单位元 格式 100.00
        if (null != orderItem.getPrePrice()) {
            params.put("amount", orderItem.getPrePrice().toString());
        }
        // 用户名称
        params.put("userName", order.getBidderName());
        // 商户号
        params.put("merctNo", OrderConstants.MERCT_NO);
        PayMerchant merchant = payMerchantService.loadPayMerctByMerctNo(OrderConstants.MERCT_NO);

        // 去除二手车销售名字和车型重复 add by weiyi.wang
        String selledName = vehicle.getSelledName();
        String vehicleModel = vehicle.getVehicleModel();
        if (!Strings.isNullOrEmpty(selledName) && selledName.startsWith(vehicleModel)) {
            selledName = selledName.replace(vehicleModel, "");
        } else {
            selledName = "";
        }
        // 产品名称
        params.put("mdseName", null == vehicle ? "二手车 " : vehicle.getBrand() + vehicle.getVehicleModel() + selledName);
        params.put("body", null == vehicle ? "二手车 " : vehicle.getBrand() + vehicle.getVehicleModel() + selledName);
        // 异步通知URL
        params.put("notifyUrl", Constants.ASYN_CALLBACK_URL);
        // 同步通知URL
        params.put("returnUrl", Constants.SYN_CALLBACK_URL);
        // 支付完成URL
        params.put("finishUrl", Constants.RESULT_CALLBACK_URL + "/no-haggle/payResult?orderNo=" + order.getOrderNo()
                + "&payType=" + OrderConstants.USED_VEHICLE_ORDER_PAY_TYPE);
        // 终端类型
        params.put("terminalType", String.valueOf(com.autostreets.biz.payment.constants.Constants.TERMINAL_TYPE_PC));
        // 二手车超时时间
        params.put("timeout", auctionDictionaryService.getValueByCategoryName("nohaggle_paytime", "精品二手车支付时限"));
        params.put("outTradeCreateTime", String.valueOf(order.getDealTimestamp().getTime()));
        params.put("orderType", OrderConstants.USED_VEHICLE_ORDER_PAY_TYPE);

        /*
         * // 商户自定义参数 （当前放的是订单类型，业务系统可自定义） params.put("merctParam",
         * OrderConstants.USED_VEHICLE_ORDER_PAY_TYPE);
         */
        model.addAttribute("form", PayUtils.buildForm(params, Constants.PAYMENT_GATEWAY, merchant.getPublicKey()));
        return "pay/payForm";
    }

    @RequestMapping(value = "/payResult")
    public String doToPayOrder(Integer orderId, String payType, Model model) {

        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
        if (orderItem.getStatus() == OrderConstans.ORDER_STATUS_PAID_DEPOSIT
                || orderItem.getStatus() == OrderConstans.ORDER_STATUS_PAID_FULL) {
            model.addAttribute("payResult", "Y");
        } else {
            model.addAttribute("payResult", "N");
        }

        return "member/payResult";
    }

    @RequestMapping(value = "/no-haggle/payResult", method = RequestMethod.GET)
    public String payResult(String orderNo, String payType, HttpServletRequest request, Model model) {

        // 订单信息
        Order order = orderService.selectOrderByOrderNo(orderNo);
        if (order == null) {
            return null;
        }
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(order.getId());
        if (orderItem.getStatus() == OrderConstans.ORDER_STATUS_PAID_DEPOSIT
                || orderItem.getStatus() == OrderConstans.ORDER_STATUS_PAID_FULL) {
            model.addAttribute("payResult", "Y");
        } else {
            model.addAttribute("payResult", "N");
        }
        order.setVehicle(vehicleService.selectByPrimaryKey(orderItem.getVehicleId()));

        FixedPriceExample fixedPriceExample = new FixedPriceExample();
        FixedPriceExample.Criteria criteria = fixedPriceExample.createCriteria();
        criteria.andVehicleIdEqualTo(orderItem.getVehicleId());
        criteria.andEnabledEqualTo(true);
        criteria.andLatestEqualTo(true);
        List<FixedPrice> fixedPriceList = fixedPriceService.selectByExample(fixedPriceExample);
        FixedPrice fp = null;
        if (null != fixedPriceList && fixedPriceList.size() > 0) {
            fp = fixedPriceList.get(0);
        }

        // 未支付倒计时
        long endPayTime = 0;
        Integer intPayTime = auctionDictionaryService.selectPayTime();
        if (orderItem.getStatus() == 0) { // 待支付
            Date endTime = DateUtils.addMinutes(order.getCreatedTime(), intPayTime);
            endPayTime = endTime.getTime() - new Date().getTime();
            if (endPayTime < 0) {
                endPayTime = 0;
            }
        }

        model.addAttribute("endPayTime", endPayTime);

        model.addAttribute("prepayOrder", order);
        model.addAttribute("fp", fp);
        model.addAttribute("despositAmt", orderItem.getPrePrice());

        return "no-haggle/payResult";
    }

    @RequestMapping(value = "/no-haggle/paydetail/{orderId}", method = RequestMethod.GET)
    public String orderDetail(@PathVariable @ModelAttribute("orderId") Integer orderId, HttpServletRequest request,
            Model model) {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }

        // 订单信息
        Order order = orderService.selectByPrimaryKey(orderId);
        if (order == null) {
            return null;
        }
        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        if (userIdentity == null || !userIdentity.getId().equals(order.getBidderSid())) {
            return null;
        }
        OrderItem orderItem = orderItemService.selectOrderItemByOrderId(orderId);
        order.setItem(orderItem);
        Vehicle v = vehicleService.selectByPrimaryKey(orderItem.getVehicleId());
        order.setVehicle(v);

        FixedPriceExample fixedPriceExample = new FixedPriceExample();
        FixedPriceExample.Criteria criteria = fixedPriceExample.createCriteria();
        criteria.andVehicleIdEqualTo(orderItem.getVehicleId());
        criteria.andEnabledEqualTo(true);
        List<FixedPrice> fixedPriceList = fixedPriceService.selectByExample(fixedPriceExample);
        FixedPrice fp = null;
        if (null != fixedPriceList && fixedPriceList.size() > 0) {
            fp = fixedPriceList.get(0);
        }

        // 未支付倒计时
        long endPayTime = 0;
        Integer intPayTime = auctionDictionaryService.selectPayTime();
        if (orderItem.getStatus() == 0) { // 待支付
            Date endTime = DateUtils.addMinutes(order.getCreatedTime(), intPayTime);
            endPayTime = endTime.getTime() - new Date().getTime();
            if (endPayTime < 0) {
                endPayTime = 0;
            }
        }
        model.addAttribute("endPayTime", endPayTime);

        model.addAttribute("prepayOrder", order);
        model.addAttribute("fp", fp);
        model.addAttribute("despositAmt", orderItem.getPrePrice() == null ? 0 : orderItem.getPrePrice());

        return "no-haggle/orderDetail";
    }

    @RequestMapping(value = "/no-haggle/appoint", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createAppoint(String customerName, String cellPhone, String province, String city, Integer id) {
        JsonResult jr;
        if (null == id) {
            jr = new JsonResult(false);
        }

        try {
            AppointmentUsedcar appoint = new AppointmentUsedcar();
            appoint.setSource("0"); // 来源：0-web
            appoint.setSaleType("2"); // 一口价
            appoint.setRefSid(id);
            appoint.setCustomerName(customerName);
            appoint.setCellNo(cellPhone);
            appoint.setProvince(province);
            appoint.setCity(city);
            appoint.setCreateTime(new Date());

            appointmentUsedcarService.insert(appoint);
            jr = new JsonResult(true);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            jr = new JsonResult(false);
        }

        return jr;
    }

    @RequestMapping(value = "/no-haggle/cancel_order", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult cancelOrderByUser(HttpServletRequest request, HttpServletResponse response, Integer orderId) {
        if (null == orderId) {

            return new JsonResult(false);
        }

        UserIdentity userIdentity = UserIdentityUtils.getUserIdentity(request);
        String memberId = null;
        if (userIdentity != null) {
            memberId = userIdentity.getId();
        }
        if (StringUtils.isBlank(memberId)) {

            return new JsonResult(false);
        }

        try {
            Order order = orderService.selectByPrimaryKey(orderId);
            // 前台 且 用户取消
            orderService.cancelOrder(order.getOrderNo(), null, memberId, 2);
            return new JsonResult(true);
        } catch (Exception e) {
            LOGGER.error("取消订单出错：" + e);
            return new JsonResult(false);
        }

    }

    @RequestMapping(value = "/no-haggle/replUrl", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult fetchUrl(String param, String value, String url) {
        JsonResult jr;

        String[] names = null;
        String[] values = null;
        if (!Strings.isNullOrEmpty(param)) {
            names = param.split(",");
        }
        if (!Strings.isNullOrEmpty(value)) {
            values = value.split(",");
        }

        Map<String, String> mapParam = Maps.newHashMap();
        if (names != null && (names.length > 0)) {
            for (int i = 0; i < names.length; i++) {
                if (!Strings.isNullOrEmpty(names[i])) {
                    String nameTemp = names[i].trim();
                    String valueTemp = "";
                    try {
                        valueTemp = values[i].trim();
                    } catch (Exception ex) {
                        valueTemp = "";
                    }
                    mapParam.put(nameTemp, valueTemp);
                }
            }
        }

        String strUrl = RequestUtils.replaceParamValue(url, mapParam);

        jr = new JsonResult(true);
        jr.setData(strUrl);
        return jr;
    }

    public String getUrl(String name, String value) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String url = RequestUtils.getRequestURIWithQueryString(request);

        String[] names = null;
        String[] values = null;
        if (!Strings.isNullOrEmpty(name)) {
            names = name.split(",");
        }
        if (!Strings.isNullOrEmpty(value)) {
            values = value.split(",");
        }

        Map<String, String> mapParam = Maps.newHashMap();
        if (names != null && (names.length > 0)) {
            for (int i = 0; i < names.length; i++) {
                if (!Strings.isNullOrEmpty(names[i])) {
                    String nameTemp = names[i].trim();
                    String valueTemp = "";
                    try {
                        valueTemp = values[i].trim();
                    } catch (Exception ex) {
                        LOGGER.error(ex.getMessage(), ex);
                        valueTemp = "";
                    }
                    mapParam.put(nameTemp, valueTemp);
                }
            }
        }

        return replaceParamValue(url, mapParam);
    }

    // 由于RequestUtils中replaceParamValue 不方便修改，特此冗余一份代码
    public static String replaceParamValue(String url, Map<String, String> paramMap) {
        StringBuilder sb = new StringBuilder();

        int idx = url.indexOf("?");
        if (idx != -1) {
            Map<String, String> params = Maps.newLinkedHashMap();

            String qs = url.substring(idx + 1);
            String[] ss = qs.split("&");
            for (String s : ss) {
                String[] tt = s.split("=");
                if (tt.length == 2) {
                    // 中文乱码问题
                    if (tt[0].equals("city") || tt[0].equals("brand") || tt[0].equals("pro")) {
                        params.put(tt[0], Utf8Decoder.decodeToUtf8(tt[1]));
                    } else {
                        params.put(tt[0], tt[1]);
                    }
                }
            }

            // 替换新值
            if (paramMap != null && paramMap.size() > 0) {
                for (Map.Entry<String, String> e : paramMap.entrySet()) {
                    if (params.containsKey(e.getKey())) {
                        if (StringUtils.isNotBlank(e.getValue())) {
                            params.put(e.getKey(), e.getValue());
                        } else {
                            params.remove(e.getKey());
                        }
                    } else {
                        if (StringUtils.isNotBlank(e.getValue())) {
                            params.put(e.getKey(), e.getValue());
                        }
                    }
                }
            }

            sb.append(url.substring(0, idx));

            boolean first = true;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (first) {
                    sb.append("?");
                    first = false;
                } else {
                    sb.append("&");
                }
                sb.append(entry.getKey()).append("=").append(entry.getValue());
            }
        } else {
            sb.append(url);
            boolean pFirst = true;
            if (paramMap != null && paramMap.size() > 0) {
                for (Map.Entry<String, String> paraEntity : paramMap.entrySet()) {
                    if (StringUtils.isNotBlank(paraEntity.getValue())) {
                        if (pFirst) {
                            sb.append("?");
                            pFirst = false;
                        } else {
                            sb.append("&");
                        }
                        sb.append(paraEntity.getKey()).append("=").append(paraEntity.getValue());
                    }
                }
            }
        }

        return sb.toString();
    }

    @RequestMapping(value = "/no-haggle/count", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updateClickCount(Integer id) {

        if (null == id) {
            return new JsonResult(false);
        }

        try {
            FixedPrice fp = fixedPriceService.selectByPrimaryKey(id);

            FixedPrice fpEntity = new FixedPrice();
            fpEntity.setId(id);
            fpEntity.setClickCount(((fp.getClickCount() == null) ? 0 : fp.getClickCount()) + 1);
            fixedPriceService.updateByPrimaryKeySelective(fpEntity);
            return new JsonResult(true);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return new JsonResult(false);
        }
    }

    @RequestMapping(value = "/no-haggle/getUsedcarCity", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getUsedcarCityByProvince(String province) {
        JsonResult jr;

        if (Strings.isNullOrEmpty(province)) {
            jr = new JsonResult(false);
            return jr;
        }

        try {
            List<String> cityList = selectCityByVehicleProvince(province);
            jr = new JsonResult(true, cityList);
            return jr;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            jr = new JsonResult(false);
            return jr;
        }
    }

    public List<String> selectCityByVehicleProvince(String province) {
        return fixedPriceService.selectCityByVehicleProvince(province);
    }

    public List<TreeMap<String, String>> paramList(int type) {
        if (type == 1) {
            return NoHagglePriceRangeEnum.getList();
        } else if (type == 2) {
            return NoHaggleAgeRangeEnum.getList();
        } else if (type == 3) {
            return NoHaggleMileRangeEnum.getList();
        } else {
            return Lists.newArrayList();
        }
    }

    /**
     * 获取枚举显示值
     * 
     * @author chunfeng.huang
     * @param type
     * @param code
     * @return
     */
    public String paramName(int type, int code) {
        if (type == 1) {
            return NoHagglePriceRangeEnum.lookupName(code);
        } else if (type == 2) {
            return NoHaggleAgeRangeEnum.lookupName(code);
        } else if (type == 3) {
            return NoHaggleMileRangeEnum.lookupName(code);
        } else {
            return "";
        }
    }

    /**
     * 根据店铺sid-即org_sid 获取店铺名称(简称):店铺名称目前就是机构名称
     * 
     * @param org_sid
     * @return
     */
    public String getUsedcarDealerName(Integer orgSid) {
        Organization org = null;
        String name = "无名";
        try {
            org = organizationService.selectByPrimaryKey(orgSid);
            if (org != null) {
                name = org.getOrgNameAbbr();
            }
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            name = "无名";
        }
        return name;
    }

    /**
     * 功能描述: <br>
     * 
     * <pre>
     * 功能详细描述
     * </pre>
     *
     * @param url
     * @param spec
     * @return
     * @author jingzhou.zhao
     * @datetime 2016年6月2日 下午4:30:55
     * @version 1.0.0
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public String getAdPic(String url, String spec) {
        if (StringUtils.isNotEmpty(url) && StringUtils.isNotEmpty(spec)) {
            url = url.substring(0, url.lastIndexOf(".")) + "*" + spec + url.substring(url.lastIndexOf("."));
        }
        return url;
    }
}