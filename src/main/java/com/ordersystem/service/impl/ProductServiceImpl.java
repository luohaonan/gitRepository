//create by howard 20190416 14:02
//商品Service的实现
package com.ordersystem.service.impl;

import java.util.List;

import com.ordersystem.dao.ProductInfoDao;
import com.ordersystem.dataobject.ProductInfo;
import com.ordersystem.dto.CartDTO;
import com.ordersystem.enums.ProductStatusEnum;
import com.ordersystem.enums.ResultEnum;
import com.ordersystem.exception.SellException;
import com.ordersystem.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional//使用List时应使用事务
    //加库存
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO: cartDTOList){
            //首先从购物车DTO中查询商品信息
            ProductInfo productInfo = dao.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStack()+cartDTO.getProductQuantity();
            productInfo.setProductStack(result);
            dao.save(productInfo);
        }

    }

    @Override
    @Transactional//使用List时应使用事务
    //减库存
    public void decreaseStock(List<CartDTO> cartDTOList) {
        //遍历购物车 寻找里面的商品信息
        for(CartDTO cartDTO: cartDTOList){
            ProductInfo productInfo = dao.findById(cartDTO.getProductId()).get();
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStack() - cartDTO.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStack(result);
            dao.save(productInfo);

        }

    }

}