package com.autostreets.biz.auction.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.autostreets.biz.auction.constants.Constants;
import com.autostreets.biz.auction.constants.SmsTemplateConstants;
import com.autostreets.biz.auction.exception.GenericEntityException;
import com.autostreets.biz.auction.model.Order;
import com.autostreets.biz.auction.model.OrderItem;
import com.autostreets.biz.auction.service.OrderItemService;
import com.autostreets.biz.auction.service.OrderService;
import com.autostreets.biz.payment.model.PayMerchant;
import com.autostreets.biz.payment.service.PayMerchantService;
import com.autostreets.biz.payment.utils.SignUtil;
import com.autostreets.biz.sms.service.SyncSmsService;
import com.autostreets.biz.sms.utils.IPUtils;
import com.autostreets.constants.OrderConstants;
import com.autostreets.framework.common.web.utils.RequestUtils;

/**
 * @ClassName: CmbNetpayController
 * @Description: 招行网上支付
 * @author youpeng.zhang
 * @date 2014年7月7日 下午4:37:20
 */
@Controller
@RequestMapping("/netpay")
public class CmbNetpayController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmbNetpayController.class);

    @Autowired
    private SyncSmsService syncSmsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private PayMerchantService payMerchantService;

    @RequestMapping(value = "/index")
    public String doToIndex() {
        return "netpay/netpay";
    }

    /**
     * 
     * 功能描述: <br>
     * 异步支付调用方法
     * 
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     * @Date 2015年1月29日 下午2:55:57
     * @author tao.huang
     */
    @ResponseBody
    @RequestMapping(value = "/asynCallback")
    public synchronized String asynCallback(HttpServletRequest request) {
        Map<String, String> backParams = RequestUtils.getRequestParams(request);
        logger.info("支付异步回调参数:{}", JSON.toJSONString(backParams));
        String orderNo = request.getParameter("outTradeNo");
        // 支付类型:01,02-新车 03-置换 04 -一口价
        String orderType = request.getParameter("orderType");
        String price = request.getParameter("amount");
        // 支付状态:1-处理中，2-成功，3-失败，4-已退款，5-已关闭
        String payStatus = request.getParameter("payStatus");
        String merctNo = request.getParameter("merctNo");
        String sign = request.getParameter("sign");
        PayMerchant payMerchant = payMerchantService.loadPayMerctByMerctNo(merctNo);
        // 验证签名
        boolean is_check = SignUtil.verifySign(backParams, payMerchant.getPublicKey(), sign);
        // 二手车订单定金
        if (OrderConstants.USED_VEHICLE_ORDER_PAY_TYPE.equals(orderType)) {
            Order order = orderService.selectOrderByOrderNo(orderNo);
            OrderItem orderItem = orderItemService.selectOrderItemByOrderId(order.getId());
            try {
                if (String.valueOf(com.autostreets.biz.payment.constants.Constants.PMT_STATUS_SUCCESS)
                        .equals(payStatus)
                        && is_check
                        && null != orderItem
                        && (null == orderItem.getStatus() || 0 == orderItem.getStatus() || 3 == orderItem.getStatus())) {
                    orderService.changeOrderStatusByPrice(orderNo, new BigDecimal(price));
                    Map<String, String> model = new HashMap<String, String>();
                    model.put("payAmount", price);
                    model.put("orderNo", orderNo);
                    syncSmsService.sendSms(order.getBuyerCellphone(), SmsTemplateConstants.SMS_FIXEDPRICE_STATUS,
                            IPUtils.ipToInt(RequestUtils.getClientIp(request)), model);
                    logger.info("异步修改一口价订单状态为支付成功.");
                }
            } catch (GenericEntityException e) {
                LOGGER.error(e.getMessage(), e);
                logger.error(e.getMessage(), e);
            }
        }
        return "success";
    }

    @RequestMapping(value = "/synCallback")
    public synchronized String synCallback(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> backParams = RequestUtils.getRequestParams(request);
        logger.info("支付同步回调参数:{}", JSON.toJSONString(backParams));
        String orderNo = request.getParameter("outTradeNo");
        // 支付类型:01,02-新车 03-置换 04 -一口价
        String orderType = request.getParameter("orderType");
        String price = request.getParameter("amount");
        // 支付状态:1-处理中，2-成功，3-失败，4-已退款，5-已关闭
        String payStatus = request.getParameter("payStatus");
        String merctNo = request.getParameter("merctNo");
        String sign = request.getParameter("sign");
        PayMerchant payMerchant = payMerchantService.loadPayMerctByMerctNo(merctNo);
        // 验证签名
        boolean is_check = SignUtil.verifySign(backParams, payMerchant.getPublicKey(), sign);
        String url = "";
        if (OrderConstants.USED_VEHICLE_ORDER_PAY_TYPE.equals(orderType)) {
            Order order = orderService.selectOrderByOrderNo(orderNo);
            OrderItem orderItem = orderItemService.selectOrderItemByOrderId(order.getId());
            try {
                if (com.autostreets.biz.payment.constants.Constants.PMT_STATUS_SUCCESS == Integer.parseInt(payStatus)
                        && is_check && null != orderItem
                        && (null == orderItem.getStatus() || 0 == orderItem.getStatus() || 3 == orderItem.getStatus())) {
                    orderService.changeOrderStatusByPrice(orderNo, new BigDecimal(price));
                    Map<String, String> model = new HashMap<String, String>();
                    model.put("payAmount", price);
                    model.put("orderNo", orderNo);
                    syncSmsService.sendSms(order.getBuyerCellphone(), SmsTemplateConstants.SMS_FIXEDPRICE_STATUS,
                            IPUtils.ipToInt(RequestUtils.getClientIp(request)), model);
                    logger.info("同步修改一口价订单状态为支付成功.");
                }
                url = Constants.RESULT_CALLBACK_URL + "/no-haggle/payResult?orderNo=" + orderNo + "&payType="
                        + OrderConstants.USED_VEHICLE_ORDER_PAY_TYPE + "&amount=" + price;
                response.sendRedirect(url);
            } catch (GenericEntityException e) {
                LOGGER.error(e.getMessage(), e);
                logger.info("同步修改一口价订单状态失败.", e);
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
                logger.info("跳转失败.", e);
            }
        }
        return null;
    }
}