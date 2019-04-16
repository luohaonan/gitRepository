package com.ordersystem.dao;

import java.util.List;

import com.ordersystem.dataobject.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;

//使用了SpringJPA
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}