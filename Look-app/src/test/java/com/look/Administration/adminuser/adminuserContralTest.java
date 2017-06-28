package com.look.Administration.adminuser;

import com.look.Administration.upimage.model.imageInfo;
import com.look.Administration.upimage.service.upimageService;
import com.look.picture.judgeLabel.model.judgetable;
import com.look.picture.judgeLabel.service.judgeLabelService;
import com.look.picture.pushPicture.model.originPushtable;
import com.look.picture.pushPicture.model.pushtable;
import com.look.picture.pushPicture.service.pushPiceturService;
import com.look.utils.ObsUtil;
import com.look.utils.setObjValueUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/6/10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class adminuserContralTest {

    @Resource
    pushPiceturService pushservice;
    @Resource
    upimageService   upimahe;
    @Resource
    judgeLabelService  judgeService;
    @Test
    public void TestsuijiPush()
    {

    }



}