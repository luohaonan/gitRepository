package com.ordersystem.dao;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import com.ordersystem.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest{
    @Autowired
    private ProductCategoryDao dao;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = dao.findById(1).get();
        System.out.println(productCategory.toString());
    }
    @Test
    @Transactional//测完回滚
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女生最爱",4);
        ProductCategory result = dao.saveAndFlush(productCategory);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result =dao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}