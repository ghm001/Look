package com.look.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaohongming on 2017/4/28.
 */
public class SetNameUtil {

    /*
    生成 发表的分享中的图片的名字
    高红明/20170516225817/1.jpg
     */
    public static String shareSetName(String userNickName ,int num )
    {
        String imageName;
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String time=dateFormat.format(date);
        //图片文件的名称
         imageName=userNickName.trim()+"/"+time.trim()+"/"+num+".jpg";
        return imageName;
    }

public static String getImageNaem(String userName,String FileName,String time)
{
    return userName.trim()+"/"+time.trim()+"/"+FileName;

}


    /**
    *@Author Gaohongming
    *@Description:   测试
    *@return:
    *@Data 22:55 2017/5/16
    */
    public static void main(String[] args) {
       String test= shareSetName("高红明",1);
        System.out.println(test);
        System.out.println(getAccurateTime());
    }
    /**
    *@Author Gaohongming
    *@Description:      传入管理员的名字，封装成
    *@return:  返回一个管理员对应的图片名字
    *@Data 22:53 2017/5/16
    */
     public static String AdminB(String AdminName,int num)
     {
         String imageName;
         Date date=new Date();
         //以小时来进行划分
         DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH");
         String time=dateFormat.format(date);
         //图片文件的名称
         imageName=AdminName.trim()+"/"+time.trim()+"/"+num+".jpg";
          return null;
     }

     public static String  getTime()
     {
         Date date=new Date();
         //以小时来进行划分
         DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH");
         String time=dateFormat.format(date);
         return time;
     }
     public static String getAccurateTime()
     {
         Date date=new Date();
         //以小时来进行划分
         DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
         String time=dateFormat.format(date);
         return time;
     }


}
