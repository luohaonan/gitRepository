//create by howard 20190416 14:02
//商品Service的实现
package com.ordersystem.service.impl;

import java.util.List;

import com.ordersystem.dao.ProductInfoDao;
import com.ordersystem.dataobject.ProductInfo;
import com.ordersystem.enums.ProductStatusEnum;
import com.ordersystem.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao dao;

    @Override
    public ProductInfo findOne(String productId) {
        return dao.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return dao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return dao.save(productInfo);
    }

}