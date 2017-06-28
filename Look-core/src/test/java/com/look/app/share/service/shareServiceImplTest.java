package com.look.app.share.service;

import com.google.gson.JsonObject;
import com.google.gson.internal.ObjectConstructor;
import com.look.app.share.model.share;
import com.look.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class shareServiceImplTest {
    @Resource
    shareService shservice;
    @Test
    public void deleteShare() throws Exception {
     shservice.deleteOneShare(10);
    }

    @Test
    public void getUserOne()
    {
        List<share> list=shservice.getUserShare(17);
        System.out.println(list.size());
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).toString());
            System.out.println(JsonUtil.objectToJson(list.get(i)));
        }
        System.out.println(JsonUtil.listJson(list));
    }

    @Test
    public void getTop10()
    {
        List<share> sh=shservice.getTop10();
        for (int i = 0; i < sh.size(); i++) {
            System.out.println(sh.get(i).toString());
        }
        System.out.println(JsonUtil.listJson(sh));
    }
    @Test
    public void getSomeShare() throws Exception {
       /* List<share> list=shservice.getSomeShare(11);
        System.out.println(list.size());
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).toString());
        }

        Map<String ,Object>  m=new HashMap<String, Object>();
        m.put("share",list.get(0));
        m.put("test","200");
        System.out.println(JsonUtil.mapJson(m));

        JsonObject jsonObject = new JsonObject();
*/
    }

}