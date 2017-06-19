package com.look.utils;

import com.look.picture.pushPicture.model.appImageGrouping;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by gaohongming on 2017/5/26.
 */
public class setObjValueUtil {

    public static Object getAttributeValueFromObj(String AttributeName,Object obj,int position)
    {
        StringBuffer temp=new StringBuffer(AttributeName);
        temp.append(position);
        return getData(obj,temp.toString());
    }


    public static void setAttributeValueFromObj(String AttributeName,Object obj,int position,Object value)
    {
        StringBuffer temp=new StringBuffer(AttributeName);
        temp.append(position);
        setData(obj,temp.toString(),value);
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

    public static void main(String[] args) {
        appImageGrouping a=new appImageGrouping();
        for (int j = 1; j <7 ; j++) {
            StringBuffer b=new StringBuffer("imageId");
            b.append(j);
            setObjValueUtil.setData(a,b.toString(),j);
            StringBuffer c=new StringBuffer("imageUrl");
            c.append(j);
            setObjValueUtil.setData(a,c.toString(),"测试");
        }
        System.out.println(a.toString());
    }

    //使用反射技术来为对象中属性赋值
    public static void setData(Object obj, String field, Object value) {
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
