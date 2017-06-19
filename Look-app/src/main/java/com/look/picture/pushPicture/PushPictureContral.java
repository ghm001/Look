package com.look.picture.pushPicture;

import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.model.second;
import com.look.Administration.labelutil.service.labelservice;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.picture.pushPicture.model.*;
import com.look.picture.pushPicture.service.pushPiceturService;
import com.look.utils.JsonUtil;
import com.look.utils.setObjValueUtil;
import org.apache.commons.collections.map.HashedMap;
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
 * Created by gaohongming on 2017/5/28.
 */
@Controller
public class PushPictureContral {
    @Resource
    pushPiceturService   pushService;

    @Resource
    labelservice labelutil;

    @Resource
    UserService userservice;
    /*
    兴趣推送   兴趣根据用户所选择的二级分类进行推送   如果二级分类中推送库没有，则查找这个二级分类对应的以及分类，包装推送库中的一级分类
     */
    @ResponseBody
    @RequestMapping(value="/look/picture/HobbyPush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String HobbyPush(HttpServletRequest request)
    {
           //获取用户的兴趣
        int id=Integer.parseInt(request.getParameter("id"));
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
        return JsonUtil.listJson(list);
    }

    /*
    随机推送   从初始化图片库中封装数据进行推送
     */
    @ResponseBody
    @RequestMapping(value="/look/picture/randomPush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String randomPush(HttpServletRequest request)
    {
        /*
        进行随机推送
         */
        Map<String ,Object> map=new HashMap<String,Object>();
        List<originPushtable> list=pushService.getOriginPush();
        List<appImageGrouping> pushlist=new ArrayList<appImageGrouping>();
        for (int i = 0; i <2 ; i++) {
            appImageGrouping a=new appImageGrouping();
            for (int j = i*6; j <6+i*6 ; j++) {
                StringBuffer b=new StringBuffer("imageId");
                b.append(j+1);
                setObjValueUtil.setData(a,b.toString(),list.get(j).getImageId());
                StringBuffer c=new StringBuffer("imageUrl");
                c.append(j+1);
                setObjValueUtil.setData(a,c.toString(),list.get(j).getImageUrl());
            }
            a.setImageNum(6);
            a.setPushWay("随机推送");
            pushlist.add(a);
        }
        map.put("TAG","随机推送");
        map.put("picture",pushlist);

        return JsonUtil.mapJson(map);
    }

    /*
    热门分类  推送一级分类    图片数量    或者一级分类对应二级分类都待定
     */
    @ResponseBody
    @RequestMapping(value="/look/picture/HotcategoriesPush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String HotcategoriesPush(HttpServletRequest request)
    {
        Map<String ,Object> map=new HashMap<String,Object>();
        //存放种类最多的六个数据
        List<mostclassification> list= pushService.getMostClassifcation();
        List<appImageGrouping> appImageGroupinglist=new ArrayList<appImageGrouping>();
        for (int i = 0; i <list.size() ; i++) {
            second   se=labelutil.getsecondInfo(list.get(i).getSecondId());
            //每次循环一次都会新产生六张图片
            //这个List中存放有六张图片
            List<pushtable>   pushtableList=pushService.getSixPictureLimitSecondId(list.get(i).getSecondId());
            appImageGrouping a=new appImageGrouping();
            for (int j = 0; j <pushtableList.size() ; j++) {
               StringBuffer b=new StringBuffer("imageId");
                b.append(j+1);
               setObjValueUtil.setData(a,b.toString(),pushtableList.get(j).getImageId());
                StringBuffer c=new StringBuffer("imageUrl");
                c.append(j+1);
                setObjValueUtil.setData(a,c.toString(),pushtableList.get(j).getImageUrl());
            }
            a.setImageNum(pushtableList.size());
            a.setPushWay("热门分类");
            a.setSecondlabelName(se.getLabelSecond());
            //生成推送数组对象完成，放入list中
            appImageGroupinglist.add(a);
        }
        map.put("TAG","热门分类");
        map.put("picture",appImageGroupinglist);
        System.out.println(JsonUtil.mapJson(map));
        return null;
    }
    /*
    猜你喜欢
     */
    @ResponseBody
    @RequestMapping(value="/look/picture/guessLikePush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String guessLikePush(HttpServletRequest request)
    {
             /*
             从完成库之中
             先查找用户点击过的  美图浏览的记录  查找到二级标签   然后再找一级标签，然后进行推送标签库下的一级标签
              */

        return null;
    }
    /*
    精选种类
     */
    @ResponseBody
    @RequestMapping(value="/look/picture/SelectedPush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String SelectedPush(HttpServletRequest request)
    {
        /*
        先取一级标签  然后查找对应的数据   然后再将二级标签分类并且封装
        再取二级标签*/
       int temp=0;
        List<mostFirstLabel>  firstList=pushService.getFirstMax();//得到最多的三个一级标签
        Map<String,Object> map=new HashMap<String ,Object>();
        //在依次读取对应的二级标签并进行封装
        for (int i = 0; i <firstList.size() ; i++) {
            first f=labelutil.getfirstInfo(firstList.get(i).getFirstId());
            List<appImageGrouping> listGroup=new ArrayList<appImageGrouping>();
            System.out.println(f.toString());
            //根据一级标签的到30个二级标签
            List<pushtable> pushSecond=pushService.getSecondByFirstLabelId(firstList.get(i).getFirstId());
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
        return JsonUtil.mapJson(map);
    }
}
