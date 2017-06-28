package com.look.Administration.upimage.service;

import com.look.Administration.adminuser.service.adminService;
import com.look.Administration.labelutil.service.labelservice;
import com.look.Administration.pictureInfoContral.model.PictureInfoModel;
import com.look.Administration.upimage.model.imageInfo;
import com.look.picture.pushPicture.model.originPushtable;
import com.look.utils.JsonUtil;
import com.look.utils.nameUtil.SetNameUtilService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/5/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class upimageServiceImplTest {
    @Resource
    upimageService upimageservice;

    @Test
    public void saveImageInfo() throws Exception {
    }
    @Test
    public void testChangeImageFlag()
    {
        imageInfo imahe=new imageInfo();
        imahe.setId(1);
        imahe.setPushTime(SetNameUtilService.getAccurateTime());
        imahe.setImageFlag("P");
      //  upimageservice.ChangeImageFlag(imahe);
    }





}