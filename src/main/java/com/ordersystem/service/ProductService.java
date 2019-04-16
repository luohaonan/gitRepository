//creat by howard 20190416 13:56
package com.ordersystem.service;

import java.util.List;

import com.ordersystem.dataobject.ProductInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService{
    ProductInfo findOne(String productId);
    //查询所有商品
    List<ProductInfo> findUpAll();
    //分页查询
    Page<ProductInfo> findAll(Pageable pageable);
    //储存
    ProductInfo save(ProductInfo productInfo);
    //库存管理
}