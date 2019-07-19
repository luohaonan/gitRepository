//creat by howard 20190416 13:56
package com.sell.service;

import java.util.List;

import com.sell.dataobject.ProductInfo;
import com.sell.dto.CartDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService{
    //查询商品
    ProductInfo findOne(String productId);
    //查询所有商品
    List<ProductInfo> findUpAll();
    //分页查询
    Page<ProductInfo> findAll(Pageable pageable);
    //储存
    ProductInfo save(ProductInfo productInfo);
    //加库存
    void increaseStack(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStack(List<CartDTO> cartDTOList);
    //上架
    ProductInfo onSale(String productId);
    //下架
    ProductInfo offSale(String productId);
}