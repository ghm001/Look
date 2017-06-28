package com.look.app.BrowsePicture.service;

import com.google.gson.JsonArray;
import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.service.labelservice;
import com.look.Administration.upimage.model.imageInfo;
import com.look.Administration.upimage.service.upimageService;
import com.look.app.BrowsePicture.model.FirstLabelGroup;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.picture.pushPicture.model.mostFirstLabel;
import com.look.picture.pushPicture.model.pushtable;
import com.look.picture.pushPicture.service.pushPiceturService;
import com.look.utils.JsonUtil;
import com.look.utils.nameUtil.SetNameUtilService;
import com.look.utils.setObjValueUtil;
import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class BrowsePictureServiceTest {
    @Resource
    BrowsePictureService  browsepicture;
    @Resource
    labelservice    labelService;
    @Resource
    UserService userservice;
    @Resource
    pushPiceturService pushService;
    @Resource
    upimageService   upimageservice;
    /*
    每日推荐
     */
    @Test
    public void getPictureForRandom() throws Exception {
        List<FinshPictureModel> list=browsepicture.getPictureForRandom();
        System.out.println(JsonUtil.listJson(list));
    }

    /*
    喜欢  按照分类来进行推送，使用appImageGroup数组
     */
    @Test
    public void TestLikePush()
    {
        List<FirstLabelGroup> list=browsepicture.getMostFirst();
        List<appImageGrouping> appImageFroupList=new ArrayList<appImageGrouping>();
        int temp=0;
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).toString());
            first  f= labelService.getfirstInfo(list.get(i).getFirstLabelId());
            List<FinshPictureModel>  finList=browsepicture.getPictureFromId(list.get(i).getFirstLabelId());
            System.out.println(finList.size());
            appImageGrouping a=new appImageGrouping();

            for (int j = 1; j <=finList.size() ; j++) {
                System.out.println(finList.get(j-1).toString());

                temp=j%6;
              if(temp==1&&j!=1) {
                  a.setSecondlabelName(f.getLabelOne());
                  appImageFroupList.add(a);
                  a = new appImageGrouping();
              }
              if(temp==0)
              {
                  temp=6;
              }
                 setObjValueUtil.setAttributeValueFromObj("imageId",a,temp,finList.get(j-1).getImageId());
                  setObjValueUtil.setAttributeValueFromObj("label",a,temp,finList.get(j-1).getLabels());
                setObjValueUtil.setAttributeValueFromObj("imageUrl",a,temp,finList.get(j-1).getImageUrl());
            }
            a.setSecondlabelName(f.getLabelOne());
            appImageFroupList.add(a);
        }

        System.out.println(JsonUtil.listJson(appImageFroupList));
    }

    /*
    领域推送   得到用户的id进行查找，封装推送
     */
    @Test
    public void TeseLingyuPush()
    {
        //int id=Integer.parseInt(request.getParameter("id"));
        int id=17;
        user u=userservice.getUserInfoByID(id);
        String[] hobby=u.getUserHobby().split("-");
        Map<String ,Object> map=new HashMap<String,Object>();
        List<appImageGrouping> list=new ArrayList<appImageGrouping>();
        for (int i = 0; i <hobby.length ; i++) {
            first  f=labelService.getfirstByLabelName(hobby[i]);
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
            imageGroup.setPushWay("美图浏览");
            imageGroup.setImageNum(6);
            list.add(imageGroup);
        }
        System.out.println(JsonUtil.listJson(list));

    }

    @Test
    public void otherPush()
    {
        List<FinshPictureModel> list=browsepicture.getPictureForRandom();
        System.out.println(JsonUtil.listJson(list));

    }

    @Test
    public void getFinishPictureAll()
    {
        List<FinshPictureModel> list=browsepicture.getAll();
        List<String> list3=new ArrayList<String>();
        List<Map<String,Object> > list1=new ArrayList<Map<String, Object>>();
        JsonArray j=new JsonArray();
        for (int i = 0; i < list.size(); i++) {
            Map <String,Object> a=new HashMap<String, Object>();
            a.put("picture_name","picture"+i+".jpg");
            a.put("finish_time",list.get(i).getFinishTime()+"T"+ (new Random().nextInt(23)+1)+":"+(new Random().nextInt(59)+1)+":"+(new Random().nextInt(59)+1)+"Z");
            a.put("labels",list.get(i).getLabels().split("-"));
            int id=list.get(i).getImageId();
            imageInfo f=upimageservice.getImageInfoFromImageId(id);
            a.put("url",f.getImageUrl());

            StringBuffer s =new StringBuffer();
           s.append(" <p> ");
            s.append(JsonUtil.mapJson(a));
            s.append(" </p> ");
            System.out.println(s.toString());
           // String json="<p>"+JsonUtil.mapJson(a)+"</p>";
           // System.out.println(json);
            list3.add(s.toString());
            list1.add(a);

        }


       // System.out.println(JsonUtil.listJson(list1));
        System.out.println(JsonUtil.listJson(list3));
    }
}