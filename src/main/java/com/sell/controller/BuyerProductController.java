//create by howard 20190416 23:46
package com.sell.controller;

import java.util.ArrayList;
import java.util.List;

import com.sell.dataobject.ProductCategory;
import com.sell.dataobject.ProductInfo;
import com.sell.service.ProductCategoryService;
import com.sell.service.ProductService;
import com.sell.utils.ResultVOUtil;
import com.sell.vo.ProductInfoVO;
import com.sell.vo.ProductVO;
import com.sell.vo.ResultVO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回JSON格式
@RequestMapping("/buyer/product")//加上前缀
public class BuyerProductController{

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/list")
    @SuppressWarnings("rawtypes")
    public ResultVO list(){
        //查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //查询类目
        List<Integer> categoryTypeList = new ArrayList<>();
        for(ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        //List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        
        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory: productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList); 
            productVOList.add(productVO);
        }

       return ResultVOUtil.success(productVOList);
        
    }

}