//create by howard 20190503
//订单表的映射
package com.ordersystem.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ordersystem.enums.OrderStatusEnum;
import com.ordersystem.enums.PayStatusEnum;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@DynamicUpdate//时间自动更新
public class OrderMaster{
    //订单ID
    @Id
    //@GeneratedValue
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    //支付状态
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    //创建时间
    @CreationTimestamp
    private Date createTime;
    //修改时间
    @UpdateTimestamp
    private Date updateTime;
    //@Transient//忽略匹配数据库字段
    //private List<OrderDetail> OrderDetailList;
    

}
