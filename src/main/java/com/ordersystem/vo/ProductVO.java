//create by howard 20190420 16:58
//商品（包含类目）
package com.ordersystem.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductVO{

    @JsonProperty("name")//返回JSON是name,方便查看，下面为categoryName
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}