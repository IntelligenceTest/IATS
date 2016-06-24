package com.autostreets.biz.auction.constants;

/**
 * 订单常量类
 * 
 * @author zhenxing.li
 *
 */
public final class OrderConstans {

    // order 二手车订单状态
    public final static Integer ORDER_STATUS_CREATED = 0; // 已创建(未支付)
    public final static Integer ORDER_STATUS_MANAGE_USER_CANCEL = 1; // 后台业务取消
    public final static Integer ORDER_STATUS_WEB_USER_CANCEL = 2; // 前台用户取消
    public final static Integer ORDER_STATUS_PAY_OVERTIME = 3; // 超时未支付取消
    public final static Integer ORDER_STATUS_PAID_DEPOSIT = 4; // 已付订金
    public final static Integer ORDER_STATUS_PAID_FULL = 5; // 已付全款
    public final static Integer ORDER_STATUS_REFUND_DEPOSIT = 6; // 已退订金
    public final static Integer ORDER_STATUS_REFUND_FULL = 7; // 已退全款
    public final static Integer ORDER_STATUS_DEAL_SUCCESS = 8; // 交易成功
    public final static Integer ORDER_STATUS_CONSULT_REFUND_DEPOSIT = 9; // 协商退款
    public final static short ORDER_REFUND_FAILURE = 10;
    public final static Integer ORDER_STATUS_RECEIPT_CONFIRM = 11; // 收款确认
    public final static Integer ORDER_STATUS_PAY_CONFIRM = 12; // 支付确认
    public final static Integer ORDER_STATUS_PAY_REFUND = 13; // 付款已拒绝

    // new_mall_order '状态：0 已下单, 1 已支付, 2 退款中, 3 等待商家退款, 4 已退款, 5 已完成,
    // 6拒绝退款，7取消订单,8 退款失败',
    public final static String NEW_MALL_ORDER_REFUND_SUCCESS = "4";
    public final static String NEW_MALL_ORDER_REFUND_FAILURE = "8";

    // new_vehicle_order '交易状态(0未支付 1 已支付定金 2 交易关闭 3交易成功 4退款成功 5退款失败)'
    public final static String NEW_VEHICLE_ORDER_REFUND_SUCCESS = "4";
    public final static String NEW_VEHICLE_ORDER_REFUND_FAILURE = "5";

    public final static Integer FINANCE_AUDIT_STATUS_NO = 0; // 未审核
    public final static Integer FINANCE_AUDIT_STATUS_YES = 1; // 已审核

    public final static short USER_TYPE_USER = 1; // 后台用户（user）
    public final static short USER_TYPE_MEMBER = 2; // 前台用户（member）

    public final static String ORDER_SOURCE_OFFLINE = "线下"; // 线下订单
    public final static String ORDER_SOURCE_WEBSITE = "website"; // 主网站
    public final static String ORDER_SOURCE_CMBWAP = "cmbwap"; // 招行网站
    public final static String ORDER_SOURCE_WAP = "wap"; // 手机版网页
    public final static String ORDER_SOURCE_APP_IOS = "ios"; // ios
    public final static String ORDER_SOURCE_APP_ANDROID = "android"; // android

    /**
     * 获取订单状态描述
     * 
     * @param orderType
     *            订单类型【注：1.新车；2.二手车】
     * @param status
     *            状态标识
     * @return 状态描述信息
     */
    public static String getStatusDescForApp(Integer orderType, Short status) {
        String statusDesc = "";
        switch (orderType) {
            case 1: // 新车
                switch (status) {
                    case 0:
                        statusDesc = "已下单";
                        break;
                    case 1:
                        statusDesc = "已支付";
                        break;
                    case 2:
                        statusDesc = "退款中";
                        break;
                    case 3:
                        statusDesc = "等待商家退款";
                        break;
                    case 4:
                        statusDesc = "已退款";
                        break;
                    case 5:
                        statusDesc = "已完成";
                        break;
                    case 6:
                        statusDesc = "拒绝退款";
                        break;
                    case 7:
                        statusDesc = "取消订单";
                        break;
                    default:
                        break;
                }
                break;
            case 2: // 二手车
                switch (status) {
                    case 0:
                        statusDesc = "未支付";
                        break;
                    case 1:
                    case 2:
                    case 3:
                        statusDesc = "交易关闭";
                        break;
                    case 4:
                    case 5:
                    case 9:
                        statusDesc = "已付订金";
                        break;
                    case 6:
                        statusDesc = "已退订金";
                        break;
                    case 7:
                        statusDesc = "已退全款";
                        break;
                    case 8:
                        statusDesc = "交易成功";
                        break;
                    case 10:
                        statusDesc = "退款失败";
                        break;
                    case 11:
                        statusDesc = "收款确认";
                        break;
                    case 12:
                        statusDesc = "支付确认";
                        break;
                    default:
                        break;
                }
                break;
            case 3: // 代缴罚款
                switch (status) {
                    case 0:
                        statusDesc = "订单创建";
                        break;
                    case 1:
                        statusDesc = "订单支付";
                        break;
                    case 2:
                        statusDesc = "正在办理";
                        break;
                    case 3:
                        statusDesc = "办理成功";
                        break;
                    case 4:
                        statusDesc = "办理失败";
                        break;
                    case 5:
                        statusDesc = "申请退款";
                        break;
                    case 6:
                        statusDesc = "退款成功";
                        break;
                    case 7:
                        statusDesc = "退款失败";
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return statusDesc;
    }
}
