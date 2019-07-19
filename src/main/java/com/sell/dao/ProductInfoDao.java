//create by howard 2019.4.15 20:02
package com.sell.dao;

import java.util.List;

import com.sell.dataobject.ProductInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoDao extends JpaRepository<ProductInfo,String>{
    List<ProductInfo> findByProductStatus(Integer productStatus);
}