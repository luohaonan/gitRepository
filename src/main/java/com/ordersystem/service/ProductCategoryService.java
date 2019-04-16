//creat by howard 2019.4.13 17:14
package com.ordersystem.service;

import java.util.List;

import com.ordersystem.dataobject.ProductCategory;

public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}