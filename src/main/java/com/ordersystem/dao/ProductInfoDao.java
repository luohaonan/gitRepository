//create by howard 2019.4.15 20:02
package com.ordersystem.dao;

import java.util.List;

import com.ordersystem.dataobject.ProductInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoDao extends JpaRepository<ProductInfo,String>{
    List<ProductInfo> findByProductStatus(Integer productStatus);
}