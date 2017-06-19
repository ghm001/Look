package com.look.utils.LanguageUtil;

import java.io.UnsupportedEncodingException;

/**
 * Created by gaohongming on 2017/6/15.
 */
public class LanguageTransforma {

    public static String TransformUTF8(String jsonstr)
    {
        try {
            jsonstr=new String( jsonstr.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonstr;
    }
}
