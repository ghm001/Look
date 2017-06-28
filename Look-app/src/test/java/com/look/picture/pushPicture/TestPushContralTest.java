package com.look.picture.pushPicture;

import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.service.labelservice;
import com.look.Administration.upimage.model.imageInfo;
import com.look.Administration.upimage.service.upimageService;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.FinishPicture.service.FinishPictureService;
import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.picture.pushPicture.model.originPushtable;
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
 * Created by gaohongming on 2017/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class TestPushContralTest {
    @Resource
    pushPiceturService pushService;

    @Resource
    labelservice labelutil;

    @Resource
    UserService userservice;

    @Resource
    upimageService  upimage;
    @Resource
    FinishPictureService   finish;




@Test
public void removeS()
{
  /* List<FinshPictureModel> f=finish.getAllPicture();
    for (int i = 0; i <f.size() ; i++) {
        String url=f.get(i).getImageUrl();
        int j=url.indexOf("s");
        url=url.substring(0, j)+url.substring(j+1);
        FinshPictureModel q=f.get(i);
        q.setImageUrl(url);
        finish.changeUrl(q);

   }*/


}




    @Test
    public void testSelectedPush() throws Exception {
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
                    imageGroup.setPushWay("精选分类");
                    imageGroup.setImageNum(6);
                    listGroup.add(imageGroup);
                }
            }
            imageGroup.setSecondlabelName(f.getLabelOne());
        }
        map.put("picture",listGroup);
        map.put("TAG","精选种类");
        System.out.println(JsonUtil.mapJson(map));

    }

    @Test
    public void TestHotcategoriesPush()
    {
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
    }

    @Test
    public void TestGuesYouLike()
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

    }

    @Test
    public void Testsuiji()
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
    }

    @Test
    public void TestHobbyPush()
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
    }


    //读取图片信息表，录入到完成库中
    @Test
    public void Finshtable()
    {
        List<imageInfo> list=new ArrayList<imageInfo>();
        list=upimage.getallImageInfo();
        for (int i = 121; i <132 ; i++) {
            imageInfo image=list.get(i);
         pushtable pu=pushService.getPushInfoByImageId(image.getId());

            System.out.println("图片的信息"+pu.toString());

            FinshPictureModel   f=new FinshPictureModel();
            f.setImageId(list.get(i).getId());
            f.setAdminId(list.get(i).getAdminId());
            f.setJudgetableId(list.get(i).getId());
            f.setImageUrl(list.get(i).getImageUrl());
            f.setFinishTime(list.get(i).getPushTime());

            f.setFirstLabelId(pu.getFirstId());
            f.setSecondLabelId(pu.getSecondId());

            String[] name=image.getImageUrl().split("/");
            f.setImagename(name[name.length-1]);
            f.setLabels(name[name.length-1].substring(0,name[name.length-1].lastIndexOf(".")));
            System.out.println("图片的信息是2"+f.toString());
           // finish.savePictureInfo(f);
        finish.ChangeImageInfo(f);
        }
    }

}