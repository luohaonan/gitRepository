//create by howard 20190503
package com.ordersystem.dao;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import com.ordersystem.dataobject.OrderMaster;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest{
    @Autowired
    private OrderMasterDao dao;
    @Test
    @Transactional//测完回滚
    public void saveTest(){
        OrderMaster  orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("howard");
        orderMaster.setBuyerPhone("18983654537");
        orderMaster.setBuyerAddress("重庆邮电大学");
        orderMaster.setBuyerOpenid("123456");
        orderMaster.setOrderAmount(new BigDecimal(8.8));

        OrderMaster result =  dao.save(orderMaster);
        Assert.assertNotNull(result);

    }
    @Test
    public void findByBuyerOpenid() throws Exception{
        PageRequest request =  PageRequest.of(0,1);//第1页 每页一个 request继承pageable接口
        Page<OrderMaster> result = dao.findByBuyerOpenid("123456", request);
        Assert.assertNotEquals(0,result.getTotalElements());

    }
}