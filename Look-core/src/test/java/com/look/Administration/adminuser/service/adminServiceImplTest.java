package com.look.Administration.adminuser.service;

import com.look.Administration.adminuser.model.adminB;
import com.look.Administration.adminuser.model.adminBuprecord;
import com.look.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by gaohongming on 2017/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class adminServiceImplTest {
    @Resource
    adminService adminservice;

    //测试管理员用户的判断
    @Test
    public void judgeAdminB()
    {
        adminB a=adminservice.judgeAdminB("高ssss");
        if(a==null)
        {
            System.out.println("无此用户");
        }else {
            System.out.println(a.toString());
        }

    }
    //测试上传信息录入
    @Test
    public void setAdminuprecord()
    {
        adminBuprecord ad=new adminBuprecord();
        ad.setUserId(3);
        ad.setUpNum(8);
        ad.setUpTime("2017-5-24");
        adminservice.setAdminuprecord(ad);
    }
    //测试身份证的判断
    @Test
    public void judgeAdminBbycardId()
    {
        adminB a=adminservice.judgeAdminBbycardId("412727199504028099");
        if(a==null)
        {
            System.out.println("无此用户");
        }else {
            System.out.println(a.toString());
        }
    }

    //测试注册
    @Test
    public void setAdminInfo()
    {
        /*adminB a=new adminB();
        a.setUserName("腾讯");
        a.setPassWord("123456");
        a.setCardId("110110110");
        a.setCompany("中国腾讯");
        a.setEmail("110.qq.com");
        a.setName("Daney");
        a.setImageUrl("http://obs.myhwclouds.com/look.admin.photo/1176473685/adminB.png");
        a.setBalance(1000);
        a.setJurisdiction("B");
        a.setFlag("N");
        a.setLoginIp("110.110.110");
        a.setNickName("Daney");
        adminservice.setAdminInfo(a);
        System.out.println(a.getId());*/

    }
    //测试修改管理员信息
    @Test
    public void changeAdminBInfo()
    {
        adminB a=new adminB();
        a.setCompany("company");
        a.setEmail("email");
        a.setName("name");
        a.setNickName("nickname");
        a.setId(1);
        adminservice.changeAdminBInfo(a);
    }

    //测试增加积分
    @Test
    public  void addAdminbalance()
    {
        adminB a=new adminB();
        a.setId(1);
        a.setBalance(100);
        adminservice.addAdminbalance(a);
    }
    //测试上传管理员头像
    @Test
    public void upheadImage()
    {
        adminB a=new adminB();
        a.setId(1);
        a.setImageUrl("qqqqqqq");
        adminservice.upheadImage(a);
    }

    //登陆测试
    @Test
    public void LoginTest()
    {
        String loginIp="200.200.200.200";
        String id=1+"";
        adminB b=new adminB();
        b.setId(Integer.parseInt(id));
        b.setLoginIp(loginIp);
        adminservice.login(b);
        //    adminB a=adminservice.adminLogin(loginIp,id);
        adminB c=adminservice.adminLogin(b.getId());
        System.out.println(JsonUtil.objectToJson(c));
    }
//退出登录测试
    @Test
    public void outLogin()
    {
        adminservice.outLogin(1);
    }
}