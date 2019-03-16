package com.ordersystem.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 产品l类目表的映射
 * Created by Howard
 * 2019.3.10 17:16
 */
//注解映射数据库字段
@Entity
public class ProductCategory{
    @Id//主键
    @GeneratedValue//自增类型
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;

    /**
     * @return the categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the categoryType
     */
    public Integer getCategoryType() {
        return categoryType;
    }

    /**
     * @param categoryType the categoryType to set
     */
    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
}