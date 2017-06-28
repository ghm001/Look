package com.look.picture.pushPicture.service;

import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.model.second;
import com.look.Administration.labelutil.service.labelservice;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.picture.pushPicture.model.*;
import com.look.utils.JsonUtil;
import com.look.utils.setObjValueUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/5/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class pushPictureServiceImplTest {
    @Resource
    pushPiceturService pushservice;
    @Resource
    labelservice labelutil;
    @Resource
    UserService userservice;
    @Test
    public void testsaveOriginPicrureInfo()
    {
     /*   originPushtable  origintable=new originPushtable();
        origintable.setAdminId(1);
        origintable.setImageUrl("test1");
        origintable.setImageId(1);
        origintable.setProduceTime("test2");
        origintable.setAdminName("test3");
        pushservice.saveOriginPicrureInfo(origintable);*/
    }

    @Test
    public void testgetMostClassifcation()
    {
        List<mostclassification>  list=pushservice.getMostClassifcation();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void testgetSixPictureLimitSecondId()
    {
        List<pushtable> li=pushservice.getSixPictureLimitSecondId(713);
        for (int i = 0; i <li.size() ; i++) {
            System.out.println(li.get(i).toString());
        }
    }

    @Test
    public void testgetHotPush()
    {
       /* Map<String ,Object> map=new HashMap<String,Object>();
        //存放种类最多的六个数据 目前数据太少，暂定为一级
        List<mostclassification> list= pushservice.getMostClassifcation();
        //List<mostFirstId> list=pushservice.getMostFirstId();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).toString());
        }
        System.out.println(list.size());
        List<appImageGrouping> appImageGroupinglist=new ArrayList<appImageGrouping>();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getSecondId());
            second se=labelutil.getsecondInfo(list.get(i).getSecondId());
            System.out.println(se.toString());
            //每次循环一次都会新产生六张图片
            //这个List中存放有六张图片
            List<pushtable>   pushtableList=pushservice.getSixPictureLimitSecondId(list.get(i).getSecondId());
            appImageGrouping a=new appImageGrouping();
            for (int j = 0; j <pushtableList.size() ; j++) {
                System.out.println(pushtableList.get(j).toString());
                StringBuffer b=new StringBuffer("imageId");
                b.append(j+1);
                setObjValueUtil.setData(a,b.toString(),pushtableList.get(j).getImageId());
                StringBuffer c=new StringBuffer("imageUrl");
                c.append(j+1);
                setObjValueUtil.setData(a,c.toString(),pushtableList.get(j).getImageUrl());
            }
            a.setPushWay("热门分类");
            a.setSecondlabelName(se.getLabelSecond());
            //生成推送数组对象完成，放入list中
            appImageGroupinglist.add(a);
        }
        map.put("TAG","热门分类");
        map.put("picyure",appImageGroupinglist);
        System.out.println(JsonUtil.mapJson(map));*/

    }

    @Test
    public void testGetHobbyPushByFirstId()
    {
        List<pushtable> pu=pushservice.getHobbyPushByFirstId(20);
        for (int i = 0; i <pu.size() ; i++) {
            System.out.println(pu.get(i).toString());
        }
    }

    @Test
    public void testsuijiPush()
    {
          /*
        进行随机推送
         */
      /*    int temp=0;
        Map<String ,Object> map=new HashMap<String,Object>();
        List<originPushtable> list=pushservice.getOriginPush();
        List<appImageGrouping> pushlist=new ArrayList<appImageGrouping>();
        for (int i = 0; i <2 ; i++) {
            appImageGrouping a=new appImageGrouping();
            for (int j = i*6; j <6+i*6 ; j++) {
                temp=j%6;
                StringBuffer b=new StringBuffer("imageId");
                b.append(temp+1);
                setObjValueUtil.setData(a,b.toString(),list.get(j).getImageId());
                StringBuffer c=new StringBuffer("imageUrl");
                c.append(temp+1);
                setObjValueUtil.setData(a,c.toString(),list.get(j).getImageUrl());
            }
            a.setImageNum(6);
            a.setPushWay("随机推送");
            pushlist.add(a);
        }
        map.put("TAG","随机推送");
        map.put("picture",pushlist);

        System.out.println(JsonUtil.mapJson(map));*/
    }

@Test
public void testjudge()
{
   /* List<appImageGrouping> list=new ArrayList<appImageGrouping>();
    List<pushtable> push=pushservice.getHobbyPushByFirstId(39);
    appImageGrouping imageGroup=new appImageGrouping();
    for (int j = 0; j <6 ; j++) {
        //封装到一组中
        StringBuffer b=new StringBuffer("imageId");
        b.append(j+1);
        setObjValueUtil.setData(imageGroup,b.toString(),push.get(j).getImageId());
        StringBuffer c=new StringBuffer("imageUrl");
        c.append(j+1);
        setObjValueUtil.setData(imageGroup,c.toString(),push.get(j).getImageUrl());
    }
    imageGroup.setPushWay("兴趣推送");
    imageGroup.setImageNum(6);
    list.add(imageGroup);
    System.out.println(JsonUtil.listJson(list));*/
}

    @Test
    public void testHobbyPush()
    {
        //获取用户的兴趣
        int id=17;
        user u=userservice.getUserInfoByID(id);
        String[] hobby=u.getUserHobby().split("-");
        List<appImageGrouping> list=new ArrayList<appImageGrouping>();
        for (int i = 0; i <hobby.length ; i++) {
            first f=labelutil.getfirstByLabelName(hobby[i]);
            System.out.println(f.toString());
            //然后在进行查找推送库
            List<pushtable> push=pushservice.getHobbyPushByFirstId(f.getId());
            System.out.println(push.size());
            if (push.size()==0)
            {
                continue;
            }
            //进行封装
            appImageGrouping imageGroup=new appImageGrouping();
            for (int j = 0; j <6 ; j++) {
                //封装到一组中
                StringBuffer b=new StringBuffer("imageId");
                b.append(j+1);
                setObjValueUtil.setData(imageGroup,b.toString(),push.get(j).getImageId());
                StringBuffer c=new StringBuffer("imageUrl");
                c.append(j+1);
                setObjValueUtil.setData(imageGroup,c.toString(),push.get(j).getImageUrl());
            }
            imageGroup.setPushWay("兴趣推送");
            imageGroup.setImageNum(6);
            list.add(imageGroup);
        }
        System.out.println(JsonUtil.listJson(list));

    }

    @Test
    public void getOriginPush()
    {
        List<originPushtable> list=pushservice.getOriginPush();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void getfirstMAxLael()
    {
        List<mostFirstLabel> list=pushservice.getFirstMax();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void testgetSecondByFirstLabelId()
    {
        List<pushtable> pu=pushservice.getSecondByFirstLabelId(44);
        for (int i = 0; i <pu.size() ; i++) {
            System.out.println(pu.get(i).toString());
        }
    }

    @Test
    public void testSelectPush()
    {
        int temp=0;
        List<mostFirstLabel>  firstList=pushservice.getFirstMax();//得到最多的三个一级标签
        Map<String,Object> map=new HashMap<String ,Object>();


        //在依次读取对应的二级标签并进行封装
        for (int i = 0; i <firstList.size() ; i++) {


            first f=labelutil.getfirstInfo(firstList.get(i).getFirstId());
            List<appImageGrouping> listGroup=new ArrayList<appImageGrouping>();

            System.out.println(f.toString());
            //根据一级标签的到30个二级标签
            List<pushtable> pushSecond=pushservice.getSecondByFirstLabelId(firstList.get(i).getFirstId());

            System.out.println(pushSecond.size());

            appImageGrouping imageGroup = new appImageGrouping();
            for (int j = 0; j <pushSecond.size() ; j++) {
                System.out.println(pushSecond.get(j).toString());

                //然后在进行随机封装
                temp=j%6;
                System.out.println(temp);
                if(temp==0&&j!=0) {
                    imageGroup.setPushWay("精选分类");
                    imageGroup.setImageNum(6);
                    System.out.println("初始化");
                    listGroup.add(imageGroup);
                    imageGroup = new appImageGrouping();
                }
                System.out.println(imageGroup.toString());
                System.out.println(j+"---"+pushSecond.get(j).getImageId()+"--"+pushSecond.get(j).getImageUrl());
                StringBuffer b=new StringBuffer("imageId");
                b.append(temp+1);
                setObjValueUtil.setData(imageGroup,b.toString(),pushSecond.get(j).getImageId());
                StringBuffer c=new StringBuffer("imageUrl");
                c.append(temp+1);
                setObjValueUtil.setData(imageGroup,c.toString(),pushSecond.get(j).getImageUrl());
                if(j==pushSecond.size()-1)
                {
                    imageGroup.setPushWay("精选分类");
                    imageGroup.setImageNum(6);
                    listGroup.add(imageGroup);
                }
            }
            map.put(f.getLabelOne(),listGroup);
        }
        map.put("TAG","精选种类");
        System.out.println(JsonUtil.mapJson(map));
    }

}