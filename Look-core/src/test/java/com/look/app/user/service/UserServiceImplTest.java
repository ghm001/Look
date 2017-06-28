package com.look.app.user.service;


import com.google.gson.Gson;
import com.look.Administration.labelutil.model.first;
import com.look.app.proposal.model.opinion;
import com.look.app.proposal.service.opinionService;
import com.look.app.user.model.user;
import com.look.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaohongming on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class UserServiceImplTest {
    @Resource
    opinionService opiniona;
    @Resource
    UserService uservice;

   @Test
   public void saveUser()
   {
       uservice.SaveUser("987654321","123456789");
   }

   //测试意见
    @Test
    public void testgetUserInfoByID()
    {
    /*    opinion o=new opinion();
        o.settitle("test");
        o.setUptime("2015");
        o.setuId(1);
        o.setId(0);
        o.setUserImageUrl("");
        o.setUserNickname("");
       Map<String, opinion> map=new HashMap<String, opinion>();
        //实际得到的对象json
        String objstring=new Gson().toJson(o);
        map.put("opinion", o);
        String jsonString=new Gson().toJson(map);
        System.out.println(jsonString);
        opinion opns= (opinion) JsonUtil.jsonToObj(objstring,opinion.class);
        //获取这个用户的基本信息
        System.out.println("用户的id为："+opns.getuId());
       user u=uservice.getUserInfoByID(opns.getuId());
        System.out.println("用户"+u.toString());
        o.setUserImageUrl(u.getUserHeadImage());
        o.setUserNickname(u.getUserNickName());
        //将完整信息写入到数据库中
        int num= opiniona.insertInfo(o);
        System.out.println(num);*/
    }

    //测试登陆
    @Test
    public  void getOtherLogin()
    {
        String OtherLogin="1176473685";
        int num=0;
        try {
            num = uservice.JudegOtherLogin(OtherLogin);
            System.out.println(num);
        }catch (Exception e)
        {
            System.out.println(num);
            System.out.println(num);
            user u=new user();
            u.setUserHeadImage("第三方登录测试");
            u.setUserNickName("qq名字");
            u.setOtherLogin(OtherLogin);
            uservice.saveOtherLogin(u);
            System.out.println(u.toString());
        }

    }

    //测试登陆
    @Test
    public void LoginTest()
    {
        String phoneNumber="12345789";
        String passWord="0";
        user u=new user();
        u.setId(0);
        u=uservice.getUser(phoneNumber,passWord);
        if (u!=null)
        {
            uservice.ChangeLoginFlag(u.getId());
            Map<String ,Object> m=new HashMap<String ,Object>();
            m.put("tag","success");
            m.put("user",u);
            System.out.println(JsonUtil.mapJson(m));
        }
        else {
            Map<String ,Object> m=new HashMap<String ,Object>();
            m.put("tag","error");
            System.out.println(JsonUtil.mapJson(m));
        }
    }

    //测试i修改用户信息
    @Test
    public  void ChangeUserInfo()
    {
        user u=new user();
        u.setId(12);
        u.setUserHeadImage("juit测试");
        u.setUserNickName("昵称测试");
        u.setUserAge("15");
        u.setUserSex("男");
        u.setPhoneNumber("1176473685");
        u.setUserHobby("性却测试。测试");
        Map<String ,Object> m=new HashMap<String,Object>();
        m.put("user",u);
        System.out.println(JsonUtil.mapJson(m));
        uservice.ChangeUserInfo(u);
    }

    //测试获取兴趣分类
    @Test
    public void getHobby()
    {
       List<first> a= uservice.getHobby();
        List<String> b=new ArrayList<String>();
        for (int i = 0; i <a.size() ; i++) {
            System.out.println(a.get(i).toString());
            b.add(a.get(i).getLabelOne());
        }
        String c=new Gson().toJson(b);
        System.out.println(c);
       //System.out.println(JsonUtil.listJson(a));
    }

}