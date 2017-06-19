package com.look.utils;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaohongming on 2017/4/18.
 */
public class ReturnUtil {


    /*
    返回失败信息
     */
    public static String error()
    {
        Map<String, String> aHashMap=new HashMap<String, String>();
        aHashMap.put("flag", "error");
        String json=new Gson().toJson(aHashMap);
        return json;
    }
    /*
    返回成功信息
     */
    public static String success()
    {
        Map<String, String> aHashMap=new HashMap<String, String>();
        aHashMap.put("flag", "success");
        String json=new Gson().toJson(aHashMap);
        return json;
    }
}
