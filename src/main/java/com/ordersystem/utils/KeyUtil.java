//create by howard in 20190504
//生成唯一主键（时间+随机数）
package com.ordersystem.utils;

import java.util.Random;

public class KeyUtil{
    //加线程锁 防止订单号重复
    public static  synchronized String getUniqueKey(){
        Random radom = new Random();
        //生成6位随机数
        Integer a = radom.nextInt(900000)+100000;
        //当前毫秒数
        return System.currentTimeMillis()+String.valueOf(a);

    }
}