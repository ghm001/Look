package com.look.utils.appUpImageUtile;

import com.look.app.share.model.share;
import com.look.utils.SetNameUtil;
import com.look.utils.utilTest;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;



import java.lang.reflect.InvocationTargetException;

/**
 * Created by gaohongming on 2017/4/30.
 */
public class appUpImageUtil {
    /**
    *@Author Gaohongming
    *@Description:  用户分享图片的工具类
    *@return:        被修改过的share对象
    *@Data 19:03 2017/4/30
     * 参数：完整的share对象
    */
    public static share upImageForShare(share shw)
    {
        String[] imageName=new String[6];
        String[] imageContest=new String[shw.getImageNum()];
        for(int i=1;i<=shw.getImageNum();i++)
        {
            System.out.println(shw.getImageNum());
            StringBuffer b=new StringBuffer("imageUrl");
            b.append(i);
            //这里本意是解决从说说对象中拿到图片数据，并放到一个数组中，依次传递给下级的图片上传
            imageContest[i-1]= (String) getData(shw,b.toString());
            //这里依次为图片进行命名
            imageName[i-1]= SetNameUtil.shareSetName(shw.getUserNickName(),i);
            String url="http://obs.myhwclouds.com/"+"look.app.share/"+imageName[i-1];
            System.out.println(url);
            //将地址修改进bean对应的属性中
            setData(shw,b.toString(),url);
            System.out.println("qqqqqqqqqqqqqqqqqqqqqqqq"+shw.getImageUrl1()+"--");
        }
        ThreadUpImage up=new ThreadUpImage();
        up.setBuctetName("look.app.share");
        up.setImageContext(imageContest);
        up.setImageName(imageName);
        up.start();
        System.out.println("进入主线程");
        return shw;

    }


    public static void main(String[] args) {
        share shw = utilTest.getShare();
        long startTime=System.currentTimeMillis();   //获取开始时间


       appUpImageUtil.upImageForShare(shw);


        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
       System.out.println(shw.toString());

    }

    public static Object getData(Object obj, String filed) {
        Object result = null;
        try {
            Class clazz = obj.getClass();
            PropertyDescriptor pd = new PropertyDescriptor(filed, clazz);
            Method getMethod = pd.getReadMethod();// 获得get方法
            result = getMethod.invoke(obj);// 执行get方法返回一个Object
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
    //使用反射技术来为对象中属性赋值
    public static void setData(Object obj, String field, String value) {
        try {
            Class clazz = obj.getClass();
            PropertyDescriptor pd = new PropertyDescriptor(field, clazz);
            Method setMethod = pd.getWriteMethod();
            setMethod.invoke(obj, value);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
