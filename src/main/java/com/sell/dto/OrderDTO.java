//create by howard in 20190504
//dto对象 对数据进行转换import lombok.Data;
package com.sell.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sell.dataobject.OrderDetail;
import com.sell.enums.OrderStatusEnum;
import com.sell.enums.PayStatusEnum;
import com.sell.utils.EnumUtil;
import com.sell.utils.serializer.Date2LongSerializer;


import lombok.Data;

@Data
//如果传输的JSON数据中有对象为空，忽略此对象
//@JsonInclude(JsonInclude.Include.NON_NULL)
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
    //时间戳的转换
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    //修改时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}