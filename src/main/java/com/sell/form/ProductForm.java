//create by howard in20190515
//卖家管理产品用到的数据格式
//不需要上架状态
package com.sell.form;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductForm {


    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStack;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
