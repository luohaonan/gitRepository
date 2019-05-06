//create by howard in 20190506
//转换工具类
package com.ordersystem.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.ordersystem.dataobject.OrderMaster;
import com.ordersystem.dto.OrderDTO;

import org.springframework.beans.BeanUtils;

public class OrderMaster2OrderDTOConverter{
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
    }
}