package com.look.picture.pushPicture;

import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.service.labelservice;
import com.look.Administration.upimage.service.upimageService;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.picture.pushPicture.model.originPushtable;
import com.look.picture.pushPicture.model.pushtable;
import com.look.picture.pushPicture.service.pushPiceturService;
import com.look.utils.JsonUtil;
import com.look.utils.setObjValueUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaohongming on 2017/6/10.
 */
@Controller
public class TestPushContral {
    @Resource
    pushPiceturService pushService;

    @Resource
    labelservice labelutil;

    @Resource
    UserService userservice;
    /*
        精选种类
         */
    @ResponseBody
    @RequestMapping(value="/look/picture/TestSelectedPush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String TestSelectedPush(HttpServletRequest request)
    {
        //电器  工具   交通
        int []idgroup={37,32,35};
        int temp=0;
        Map<String,Object> map=new HashMap<String ,Object>();
        //在依次读取对应的二级标签并进行封装
        List<appImageGrouping> listGroup=new ArrayList<appImageGrouping>();
        for (int i = 0; i <idgroup.length ; i++) {
            first f=labelutil.getfirstInfo(idgroup[i]);

            System.out.println(f.toString());
            //根据一级标签的到30个二级标签
            List<pushtable> pushSecond=pushService.getSecondByFirstLabelId(idgroup[i]);
            System.out.println(pushSecond.size());
            appImageGrouping imageGroup = new appImageGrouping();
            for (int j = 0; j <pushSecond.size() ; j++) {
                System.out.println(pushSecond.get(j).toString());

                //然后在进行随机封装
                temp=j%6;
                System.out.println(temp);
                if(temp==0&&j!=0) {
                    imageGroup.setPushWay("精选种类");
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
                    imageGroup.setPushWay("精选种类");
                    imageGroup.setImageNum(6);
                    listGroup.add(imageGroup);
                }
            }
            imageGroup.setSecondlabelName(f.getLabelOne());
        }
        map.put("picture",listGroup);
        map.put("TAG","精选种类");
        System.out.println(JsonUtil.mapJson(map));
        return JsonUtil.mapJson(map);
    }

//热门分类
    @ResponseBody
    @RequestMapping(value="/look/picture/TestHotcategoriesPush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String TestHotcategoriesPush(HttpServletRequest request) {
        Map<String ,Object> map=new HashMap<String,Object>();
        List<appImageGrouping> list=new ArrayList<appImageGrouping>();
        int [] temp={12,22,41,44,43,42};
        for (int i = 0; i <temp.length ; i++) {
            first f=labelutil.getfirstInfo(temp[i]);
            List<pushtable> push=pushService.getHobbyPushByFirstId(temp[i]);
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
            imageGroup.setSecondlabelName(f.getLabelOne());
            imageGroup.setPushWay("热门分类");
            imageGroup.setImageNum(6);
            list.add(imageGroup);

        }
        map.put("TAG","热门分类");
        map.put("picture",list);

        System.out.println(JsonUtil.mapJson(map));
        return JsonUtil.mapJson(map);

    }
//猜你喜欢
    @ResponseBody
    @RequestMapping(value="/look/picture/TestguessLikePush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String TestguessLikePush(HttpServletRequest request)
    {
        String[] like={"生活场景","自然风景"  };
        int[] lileint={42,43};

        int temp=0;
        Map<String,Object> map=new HashMap<String ,Object>();
        //在依次读取对应的二级标签并进行封装
        List<appImageGrouping> listGroup=new ArrayList<appImageGrouping>();
        for (int i = 0; i <lileint.length ; i++) {
            first f=labelutil.getfirstInfo(lileint[i]);

            System.out.println(f.toString());
            //根据一级标签的到30个二级标签
            List<pushtable> pushSecond=pushService.getSecondByFirstLabelId(lileint[i]);
            System.out.println(pushSecond.size());
            appImageGrouping imageGroup = new appImageGrouping();
            for (int j = 0; j <pushSecond.size() ; j++) {
                System.out.println(pushSecond.get(j).toString());

                //然后在进行随机封装
                temp=j%6;
                System.out.println(temp);
                if(temp==0&&j!=0) {
                    imageGroup.setPushWay("猜你喜欢");
                    imageGroup.setImageNum(6);
                    System.out.println("初始化");
                    listGroup.add(imageGroup);
                    imageGroup = new appImageGrouping();
                    imageGroup.setSecondlabelName(f.getLabelOne());
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
                    imageGroup.setPushWay("猜你喜欢");
                    imageGroup.setImageNum(6);
                    listGroup.add(imageGroup);
                    imageGroup.setSecondlabelName(f.getLabelOne());
                }
            }
            imageGroup.setSecondlabelName(f.getLabelOne());
        }
        map.put("picture",listGroup);
        map.put("TAG","猜你喜欢");
        System.out.println(JsonUtil.mapJson(map));
  return JsonUtil.mapJson(map);
    }

//兴趣推送
    @ResponseBody
    @RequestMapping(value="/look/picture/TestHobbyPush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String TestHobbyPush(HttpServletRequest request)
    {
        //获取用户的兴趣
        int id=Integer.parseInt(17+"");
        user u=userservice.getUserInfoByID(id);
        String[] hobby=u.getUserHobby().split("-");
        Map<String ,Object> map=new HashMap<String,Object>();
        List<appImageGrouping> list=new ArrayList<appImageGrouping>();
        for (int i = 0; i <hobby.length ; i++) {
            first  f=labelutil.getfirstByLabelName(hobby[i]);
            //然后在进行查找推送库
            List<pushtable> push=pushService.getHobbyPushByFirstId(f.getId());
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
        map.put("TAG","兴趣推送");
        map.put("picture",list);
        System.out.println(JsonUtil.mapJson(map));
        return JsonUtil.mapJson(map);
    }

    @ResponseBody
    @RequestMapping(value="/look/picture/TestrandomPush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String TestrandomPush(HttpServletRequest request)
    {
        Map<String ,Object> map=new HashMap<String,Object>();
        List<originPushtable> list=new ArrayList<originPushtable>();
        int [] test1={1,7,13,2,8,14};
        int[] test2={3,9,15,4,10,16};
        for (int i = 0; i <6 ; i++) {
            originPushtable o=pushService.getoriginPushById(test1[i]);
            list.add(o);
        }
        for (int i = 0; i <6 ; i++) {
            originPushtable o=pushService.getoriginPushById(test2[i]);
            list.add(o);
        }
        //  List<originPushtable> list=pushService.getOriginPush();
        System.out.println(list.size());
        List<appImageGrouping> pushlist=new ArrayList<appImageGrouping>();
        for (int i = 0; i <2 ; i++) {
            appImageGrouping a=new appImageGrouping();
            for (int j = i*6; j <6+i*6 ; j++) {
                int temp=j%6;
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

        System.out.println(JsonUtil.mapJson(map));
        return JsonUtil.mapJson(map);
    }
}
