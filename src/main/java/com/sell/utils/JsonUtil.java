//create by howard in 20190513
//转化JSON的工具类
package com.sell.utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}