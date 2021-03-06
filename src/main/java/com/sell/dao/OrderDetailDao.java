//create by howard 20190503
package com.sell.dao;

import java.util.List;

import com.sell.dataobject.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail,String>{
    List<OrderDetail> findByOrderId(String orderId);

}