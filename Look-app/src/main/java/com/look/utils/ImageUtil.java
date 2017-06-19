package com.look.utils;

import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gaohongming on 2017/4/14.
 */
public class ImageUtil {
    /*
    将String转换为输入流
     */
    public static ByteArrayInputStream getImageInputStream(String ImageContext)
    {

        ByteArrayInputStream bais=null;
        try {
            byte [] bytes=new BASE64Decoder().decodeBuffer(ImageContext);
            System.out.println("文件的总大小为"+bytes.length);
            bais = new ByteArrayInputStream(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bais;
    }
}
