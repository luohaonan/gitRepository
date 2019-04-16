//create by howard 2019.4.15 20:07
package com.ordersystem.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ordersystem.dataobject.ProductInfo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest{
    @Autowired
    private ProductInfoDao dao;
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("小炒肉");
        productInfo.setProductPrice(new BigDecimal(8.8));
        productInfo.setProductStack(100);
        productInfo.setProductDescription("这是一份简单的小炒肉");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = dao.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList = dao.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }

}