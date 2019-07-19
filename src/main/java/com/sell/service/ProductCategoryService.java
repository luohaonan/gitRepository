//creat by howard 2019.4.13 17:14
package com.sell.service;

import java.util.List;

import com.sell.dataobject.ProductCategory;

public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}