//create by howard in20190505
package com.sell.testclass;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.sell.dataobject.OrderDetail;
import com.sell.dto.OrderDTO;
import com.sell.enums.OrderStatusEnum;
import com.sell.enums.PayStatusEnum;
import com.sell.service.impl.OrderServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;


import lombok.extern.slf4j.Slf4j;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest{
    @Autowired
    private OrderServiceImpl orderService;
    private final String BUYER_OPENID = "1234567";
    private final String ORDER_ID = "1557067494719664246";
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
        OrderDTO result =  orderService.findOne(ORDER_ID);
        log.info("查询单个订单 result{}",result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());

    }
    @Test
    public void findList() throws Exception{
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage =  orderService.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());

    }
    @Test
    @Transactional
    public void cancel() throws Exception{
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }
    @Test
    @Transactional
    public void finish() throws Exception{
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }
    @Test
    @Transactional
    public void pay() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.pay(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

}