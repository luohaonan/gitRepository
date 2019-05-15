package com.sell.dataobject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

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
    //类目名称
    private String categoryName;
    //类目编号
    private Integer categoryType;
    @UpdateTimestamp////当在持久化实体属性上添加该注解，表明让Hibernate在保存该实体时，自动设置上更新时间，不需要用户对该属性进行管理
    private Date createTime;
    @UpdateTimestamp////当在持久化实体属性上添加该注解，表明让Hibernate在保存该实体时，自动设置上更新时间，不需要用户对该属性进行管理
    private Date updateTime;

    public ProductCategory(){};

    public ProductCategory(String categoryName, Integer categoryType){
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}