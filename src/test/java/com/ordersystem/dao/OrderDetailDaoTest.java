//create by howard in 20190504
package com.ordersystem.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ordersystem.dataobject.OrderDetail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest{
    @Autowired
    private OrderDetailDao dao;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("123456789");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("12345678");
        orderDetail.setProductName("红烧肉");
        orderDetail.setProductPrice(new BigDecimal(8.8));
        orderDetail.setProductQuantity(2);

        OrderDetail result =  dao.save(orderDetail);
        Assert.assertNotNull(result);

    }
    @Test
    public void findByOrderId() throws Exception{
        List<OrderDetail> orderDetailList = dao.findByOrderId("123456789");
        Assert.assertNotEquals(0, orderDetailList.size());
    }

}