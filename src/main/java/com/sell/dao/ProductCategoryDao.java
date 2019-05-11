package com.sell.dao;

import java.util.List;

import com.sell.dataobject.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;

//使用了SpringJPA
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}