//create by howard in 20190504
//update by howard in 20190506
package com.ordersystem.enums;

import lombok.Getter;

@Getter
public enum ResultEnum{
    PRODUCT_NOT_EXIST(0,"商品不存在"),

    PRODUCT_STOCK_ERROR(1,"库存错误"),

    ORDER_NOT_EXIST(2,"订单不存在"),

    ORDERDETAIL_NOT_EXIST(3,"订单详情不存在"),

    ORDER_STATUS_ERROR(4, "订单状态不正确"),

    ORDER_UPDATE_FAIL(5, "订单更新失败"),

    ORDER_DETAIL_EMPTY(6, "订单详情为空"),

    ORDER_PAY_STATUS_ERROR(7, "订单支付状态不正确"),

    CART_EMPTY(8, "购物车为空"),

    ORDER_OWNER_ERROR(9, "该订单不属于当前用户"),

    WECHAT_MP_ERROR(10, "微信公众账号方面错误"),

    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(11, "微信支付异步通知金额校验不通过"),

    ORDER_CANCEL_SUCCESS(12, "订单取消成功"),

    ORDER_FINISH_SUCCESS(13, "订单完结成功"),

    PRODUCT_STATUS_ERROR(14, "商品状态不正确"),

    LOGIN_FAIL(15, "登录失败, 登录信息不正确"),

    LOGOUT_SUCCESS(16, "登出成功"),
    ;
    private Integer code;
    private String message;
    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}