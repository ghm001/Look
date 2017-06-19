package com.look.app.BrowsePicture;

import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.service.labelservice;
import com.look.app.BrowsePicture.model.FirstLabelGroup;
import com.look.app.BrowsePicture.service.BrowsePictureService;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.picture.pushPicture.model.pushtable;
import com.look.picture.pushPicture.service.pushPiceturService;
import com.look.utils.JsonUtil;
import com.look.utils.setObjValueUtil;
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
 * Created by gaohongming on 2017/5/29.
 */
public class BrowsePicture {

    @Resource
    BrowsePictureService  browsepicture;
    @Resource
    labelservice labelService;
    @Resource
    UserService userservice;
    @Resource
    pushPiceturService pushService;
/*
    每日推荐    暂定位随机从完成化库之中进行推荐  随机单张
 */
@ResponseBody
@RequestMapping(value="/look/app/EveryDayPicturePush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
public String EveryDayPicturePush(HttpServletRequest request)
{
    List<FinshPictureModel>  list=browsepicture.getPictureForRandom();
    return JsonUtil.listJson(list);
}


/*
猜你喜欢           随机从完成库之中进行推荐 ,按照一级分类来进行和分组，  后期进行标签的匹配
 */
@ResponseBody
@RequestMapping(value="/look/app/GuesLikeFromFinish",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
public String GuesLikeFromFinish(HttpServletRequest request)
{
    List<FirstLabelGroup> list=browsepicture.getMostFirst();
    List<appImageGrouping> appImageFroupList=new ArrayList<appImageGrouping>();
    int temp=0;
    for (int i = 0; i <list.size() ; i++) {
        System.out.println(list.get(i).toString());
        first f= labelService.getfirstInfo(list.get(i).getFirstLabelId());
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
    return JsonUtil.listJson(appImageFroupList);
}
   /*
  领域推送   从完成库之中找到符合用户领域的图片  分类好的
    */

    @ResponseBody
    @RequestMapping(value="/look/app/UserInfoPush",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String UserInfoPush(HttpServletRequest request)
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
        return JsonUtil.mapJson(map);
    }

   /*
   其他   随机展示图片  单张
    */

    @ResponseBody
    @RequestMapping(value="/look/app/LookSoomPicture",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String LookSoomPicture(HttpServletRequest request) {
        List<FinshPictureModel> list=browsepicture.getPictureForRandom();
        return JsonUtil.listJson(list);
    }
}
