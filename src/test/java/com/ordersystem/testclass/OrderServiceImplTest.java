//create by howard in20190505
package com.ordersystem.testclass;

import java.util.ArrayList;
import java.util.List;

import com.ordersystem.dataobject.OrderDetail;
import com.ordersystem.dto.OrderDTO;
import com.ordersystem.service.impl.OrderServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest{
    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "1234567";
    //private final String ORDER_ID = "1497183332311989948";
    @Test
    public void create() throws Exception{
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("罗先生");
        orderDTO.setBuyerAddress("重庆邮电大学");
        orderDTO.setBuyerPhone("1234456789");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123457");
        o1.setProductQuantity(1);

        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        //使用日志打印输出
        log.info("【创建订单】 result{}", result);
        Assert.assertNotNull(result);

    }
    @Test
    public void findOne() throws Exception{

    }
    @Test
    public void findList() throws Exception{

    }
    @Test
    public void cancel() throws Exception{

    }
    @Test
    public void finish() throws Exception{

    }

}