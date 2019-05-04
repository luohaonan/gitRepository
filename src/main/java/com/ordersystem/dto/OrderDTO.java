//create by howard in 20190504
//dto对象 对数据进行转换import lombok.Data;
package com.ordersystem.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ordersystem.dataobject.OrderDetail;

import lombok.Data;

@Data
public class OrderDTO{
    //订单ID
    private String orderId;
    //买家名字
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //买家微信号
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单状态,默认为新下单
    private Integer orderStatus;
    //支付状态
    private Integer payStatus;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;

    List<OrderDetail> orderDetailList;

}