//create by howard in 20190504
package com.ordersystem.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import com.ordersystem.dao.OrderDetailDao;
import com.ordersystem.dao.OrderMasterDao;
import com.ordersystem.dataobject.OrderDetail;
import com.ordersystem.dataobject.OrderMaster;
import com.ordersystem.dataobject.ProductInfo;
import com.ordersystem.dto.CartDTO;
import com.ordersystem.dto.OrderDTO;
import com.ordersystem.enums.OrderStatusEnum;
import com.ordersystem.enums.PayStatusEnum;
import com.ordersystem.enums.ResultEnum;
import com.ordersystem.exception.SellException;
import com.ordersystem.service.OrderService;
import com.ordersystem.service.ProductService;
import com.ordersystem.utils.KeyUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    @Transactional//使用事务，创建订单失败抛出异常会回滚 不进行操作
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //List<CartDTO> cartDTOList = new ArrayList<>();
        
        //1.查询商品（数量，价格）
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算订单总价（每一件商品总价相加 ）
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
            //3.写入订单详情
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailDao.save(orderDetail);
            
            
            //库存管理           
            //CartDTO cartDTO = new CartDTO(orderDetail.getProductId() , orderDetail.getProductQuantity());
            //cartDTOList.add(cartDTO);
            //productService.decreaseStock(cartDTOList);
        }
        //4.写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);     
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.save(orderMaster);
        //库存管理
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        
        return orderDTO;
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
