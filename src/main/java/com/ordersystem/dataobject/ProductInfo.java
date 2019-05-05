//create by howard 2019.4.15.19:52
//商品表的映射
package com.ordersystem.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class ProductInfo{
    @Id
    //ID为随机字符串 不需要自增
    private String productId;
    //名字
    private String productName;
    //单价
    private BigDecimal productPrice;
    //库存
    private Integer productStack;
    //描述
    private String productDescription;
    //小图（链接地址）
    private String productIcon;
    //商品状态 0正常1已下架
    private Integer productStatus;
    //类目编号
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

}