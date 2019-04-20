//create by howard 20190416 23:46
package com.ordersystem.controller;

import com.ordersystem.vo.ResultVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回JSON格式
@RequestMapping("/buyer/product")//加上前缀
public class BuyerProductController{

    @GetMapping("/List")
    @SuppressWarnings("rawtypes")
    public ResultVO list(){
        ResultVO resultVO = new ResultVO();
        return resultVO;
        
    }

}