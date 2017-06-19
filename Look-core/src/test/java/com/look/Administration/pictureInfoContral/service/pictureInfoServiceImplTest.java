package com.look.Administration.pictureInfoContral.service;

import com.look.Administration.adminuser.model.adminB;
import com.look.Administration.adminuser.service.adminService;
import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.model.second;
import com.look.Administration.labelutil.service.labelservice;
import com.look.Administration.pictureInfoContral.model.FinishModel;
import com.look.Administration.pictureInfoContral.model.PictureInfoModel;
import com.look.Administration.pictureInfoContral.model.test;
import com.look.Administration.upimage.model.imageInfo;
import com.look.Administration.upimage.service.upimageService;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.originPushtable;
import com.look.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/5/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class pictureInfoServiceImplTest {
    @Resource
    pictureInfoService pictureInfoservice;
    @Resource
    labelservice labelService;

    @Resource
    adminService adminservice;
    @Resource
    upimageService imageService;
    @Test
    public void testget()
    {
        List<test> a=pictureInfoservice.gettest();
        System.out.println(a.size());
        for (int i = 0; i <a.size() ; i++) {
            System.out.println(a.get(i).toString());
        }
    }
    @Test
    public void TestoriginPicture()
    {
        List<originPushtable> list=pictureInfoservice.getoriginPicture();
        List<PictureInfoModel>  infoList=new ArrayList<PictureInfoModel>();
        for (int i = 0; i <list.size() ; i++) {
            PictureInfoModel p=new PictureInfoModel(list.get(i).getImageId(),list.get(i).getAdminName(),list.get(i).getProduceTime(),list.get(i).getImageUrl());
            infoList.add(p);
        }
        System.out.println(JsonUtil.listJson(infoList));
        //return JsonUtil.listJson(infoList);
    }
    @Test
    public void Testabnormalimagetable()
    {
        List<imageInfo> list=pictureInfoservice.getCanPushPicture();
        List<PictureInfoModel>  infoList=new ArrayList<PictureInfoModel>();
        for (int i = 0; i <list.size() ; i++) {
            PictureInfoModel p=new PictureInfoModel(list.get(i).getId(),list.get(i).getAdminName(),list.get(i).getPushTime(),list.get(i).getImageUrl());
            infoList.add(p);
        }
        System.out.println(JsonUtil.listJson(infoList));
       // return JsonUtil.listJson(infoList);
    }

    @Test
    public void Testpushtable()
    {

    }

    @Test
    public void TestFinishtable()
    {
        List<FinshPictureModel> list=pictureInfoservice.getFinishtable();
        List<FinishModel> finList=new ArrayList<FinishModel>();
        String  templabel="";
        for (int i = 0; i <list.size() ; i++) {
            adminB a= adminservice.adminLogin(list.get(i).getAdminId());
            first f=labelService.getfirstInfo(list.get(i).getFirstLabelId());
            templabel=f.getLabelOne();
            if (list.get(i).getSecondLabelId()!=0){
                second s=labelService.getsecondInfo(list.get(i).getSecondLabelId());
                templabel=s.getLabelSecond();
            }
            FinishModel  fin=new FinishModel(list.get(i).getImageId(),a.getCompany(),list.get(i).getFinishTime(),list.get(i).getImageUrl(),f.getLabelOne(),templabel);
            finList.add(fin);
        }
        System.out.println(JsonUtil.listJson(finList));
     //   return JsonUtil.listJson(finList);
    }

}