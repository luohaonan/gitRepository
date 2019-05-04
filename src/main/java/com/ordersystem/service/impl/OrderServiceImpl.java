//create by howard in 20190504
package com.ordersystem.service.impl;

import com.ordersystem.dto.OrderDTO;
import com.ordersystem.service.OrderService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO pay(OrderDTO orderDTO) {
        return null;
    }
    
}
