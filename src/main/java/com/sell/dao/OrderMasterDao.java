//create by howard 20190503
package com.sell.dao;
import com.sell.dataobject.OrderMaster;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterDao extends JpaRepository<OrderMaster,String>{
    //分页查询，返回PAGE对象
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}