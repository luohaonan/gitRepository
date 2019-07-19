//create by howard in 20190504
//自定义 运行过程中抛出的异常
package com.sell.exception;

import com.sell.enums.ResultEnum;
public class SellException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")//消除警告
    private Integer code;
    public SellException(ResultEnum resultEnum){
        //传至父类的构造方法
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
	public SellException(Integer code, String message) {
        super(message);
        this.code = code;
	}

}