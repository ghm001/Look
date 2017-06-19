package com.look.app.BrowsePicture.service;

import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.service.labelservice;
import com.look.app.BrowsePicture.model.FirstLabelGroup;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.picture.pushPicture.model.mostFirstLabel;
import com.look.picture.pushPicture.model.pushtable;
import com.look.picture.pushPicture.service.pushPiceturService;
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
        map.put("TAG","美图浏览");
        map.put("picture",list);

    }

    @Test
    public void otherPush()
    {
        List<FinshPictureModel> list=browsepicture.getPictureForRandom();

    }
}