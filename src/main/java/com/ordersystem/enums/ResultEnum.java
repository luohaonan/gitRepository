//create by howard in 20190504
package com.ordersystem.enums;

import lombok.Getter;

@Getter
public enum ResultEnum{
    PRODUCT_NOT_EXIST(0,"商品不存在"),
    PRODUCT_STOCK_ERROR(1,"库存错误"),
    ORDER_NOT_EXIST(2,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(3,"订单详情不存在"),
    ;
    private Integer code;
    private String message;
    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}