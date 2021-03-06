//create by howard in 20190506
//转换工具类
package com.sell.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.sell.dataobject.OrderMaster;
import com.sell.dto.OrderDTO;

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