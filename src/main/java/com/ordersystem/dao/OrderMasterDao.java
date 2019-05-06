//create by howard 20190503
package com.ordersystem.dao;
import com.ordersystem.dataobject.OrderMaster;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterDao extends JpaRepository<OrderMaster,String>{
    //分页查询，返回PAGE对象
    Page<OrderMaster> findByBuyerOpenId(String buyerOpenId, Pageable pageable);

}