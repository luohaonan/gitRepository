//creat by howard 20190416 19:52
//商品状态的枚举类
package com.ordersystem.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum{
    UP(0,"已上架"),
    DOWN(1,"已下架");
    
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}