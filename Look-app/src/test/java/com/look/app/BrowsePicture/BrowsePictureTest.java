package com.look.app.BrowsePicture;

import com.look.app.BrowsePicture.service.BrowsePictureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/6/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class BrowsePictureTest {

    @Resource
    BrowsePictureService browsepicture;

    @Test
    public void TestEveryDayPicturePush()
    {

    }
    @Test
    public void TestGuesLikeFromFinish()
    {

    }
    @Test
    public void TestUserInfoPush()
    {

    }
    @Test
    public void TestLookSoomPicture()
    {

    }

}