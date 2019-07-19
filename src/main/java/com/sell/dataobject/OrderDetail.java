package com.sell.dataobject;

import java.math.BigDecimal;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

//create by howard 20190503
//订单详情表的映射
@Entity
@Data
public class OrderDetail{
    @Id
    private  String detailId;
    //订单ID
    private String orderId;
    //商品ID
    private String productId;
    //商品名称
    private String productName;
    //单价
    private BigDecimal productPrice;
    //商品数量
    private Integer productQuantity;
    //商品小图
    private String productIcon;


}