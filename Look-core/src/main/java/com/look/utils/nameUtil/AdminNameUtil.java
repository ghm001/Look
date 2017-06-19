package com.look.utils.nameUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaohongming on 2017/5/20.
 */
public class AdminNameUtil {

    public static String photoSetName(String userNickName ,int num )
    {
        String imageName;
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String time=dateFormat.format(date);
        //图片文件的名称
        imageName=userNickName.trim()+"/"+time.trim()+"/"+"1.jpg";
        return imageName;
    }
}
