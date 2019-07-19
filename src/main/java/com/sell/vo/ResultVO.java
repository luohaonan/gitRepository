//create by howard 20190416 23:55
//Http请求返回的最外层对象
package com.sell.vo;

import lombok.Data;

@Data
public class ResultVO<T>{
    //错误码 0为成功
    private Integer code;
    //提示信息
    private String msg;
    //具体内容,使用了泛型
    private T data;
}