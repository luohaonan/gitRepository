//creat by howard 2019.4.15 22：24
//接口的实现类
package com.sell.service.impl;

import java.util.List;

import com.sell.dao.ProductCategoryDao;
import com.sell.dataobject.ProductCategory;
import com.sell.service.ProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao dao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return dao.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return dao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return dao.save(productCategory);
    }

}