package com.ordersystem.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * 产品l类目表的映射
 * Created by Howard
 * 2019.3.10 17:16
 */
//注解映射数据库字段
@Entity
@DynamicUpdate//动态更新
@Data//lombok
public class ProductCategory{
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增类型
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

    public ProductCategory(){};

    public ProductCategory(String categoryName, Integer categoryType){
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}