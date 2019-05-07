//create by howard in 20190507
package com.ordersystem.controller;

import java.util.Map;

import javax.validation.Valid;

import com.ordersystem.enums.ResultEnum;
import com.ordersystem.exception.SellException;
import com.ordersystem.form.OrderForm;
import com.ordersystem.service.OrderService;
import com.ordersystem.vo.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController{
    @Autowired
    private OrderService orderService;
    //创建订单
    //@Valid是使用hibernate validation的时候使用
    //@Valid和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        
        return null;

    }
    //订单列表
    //订单详情
    //取消订单


}