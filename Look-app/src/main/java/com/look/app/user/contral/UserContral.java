package com.look.app.user.contral;


import com.look.Administration.labelutil.model.first;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.utils.JsonUtil;
import com.look.utils.LanguageUtil.LanguageTransforma;
import com.look.utils.ReturnUtil;

import com.look.utils.SetNameUtil;
import com.look.utils.appUpImageUtile.ThreadUpImage;
import com.look.utils.nameUtil.AdminNameUtil;
import org.apache.commons.collections.functors.StringValueTransformer;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by gaohongming on 2017/4/18.
 */
@Controller
public class UserContral {
    @Resource
    UserService userservice;
    /**
    *@Author Gaohongming
    *@Description:  判断手机号用户是否被注册
    *@return:    flag:success  or  error
    *@Data 12:48 2017/4/26
     * parameter:    {phoneNumber:value}
     * /look/app/JudgeUser?phoneNumber=15354506916
    */
    @ResponseBody
    @RequestMapping(value="/look/app/JudgeUser",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String JudgeUser(HttpServletRequest request)
    {
        System.out.println("新用户注册判定");
        String phoneNumber=request.getParameter("phoneNumber");
        System.out.println("用户"+phoneNumber+"进行请求注册");
        int num=0;
        try {
            num=userservice.JudgeUser(phoneNumber);
        }catch (Exception o)
        {
            System.out.println("成功，可以进行注册");
            return ReturnUtil.success();
        }
        System.out.println("查询到已有id"+num);
       if (num!=0)
       {
           System.out.println("失败，不可以进行注册");
           return ReturnUtil.error();
       }
        System.out.println("成功，可以进行注册");
        return ReturnUtil.success();
    }

    /**
    *@Author Gaohongming
    *@Description:    进行手机号注册
    *@return:  flag:success  or  error
    *@Data 19:46 2017/4/26
     * parameter:    {phoneNumber:value  passWord:value}
     * /look/app/SaveUser?phoneNumber=15354506916&passWord=654321
    */
    @ResponseBody
    @RequestMapping(value="/look/app/SaveUser",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String SaveUser(HttpServletRequest request)
    {
        System.out.println("新用户进行注册");
        String phoneNumber=request.getParameter("phoneNumber");
        String passWord=request.getParameter("passWord");
        System.out.println("用户手机号"+phoneNumber+"---"+"用户密码"+passWord);
        try {
            userservice.SaveUser(phoneNumber, passWord);
        }catch (Exception o)
        {
            System.out.println("注册失败");
            return ReturnUtil.error();
        }
        System.out.println("注册成功");
        return ReturnUtil.success();
    }

    /*
    密码重置  直接覆盖
     */
    /**
    *@Author Gaohongming
    *@Description:   密码修改
    *@return:     flag:success  or  error
    *@Data 21:15 2017/4/26
     * parameter:    {phoneNumber:value  passWord:value}
    */
    @ResponseBody
    @RequestMapping(value="/look/app/ChangeUserPassword",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String ChangeUserPassword(HttpServletRequest request)
    {
        System.out.println("用户进行修改密码");
        String phoneNumber=request.getParameter("phoneNumber");
        String passWord=request.getParameter("passWord");
        System.out.println(phoneNumber+"用户进行修改密码成功");
        userservice.ChangeUserPassword(phoneNumber,passWord);
        return ReturnUtil.success();
    }

    /*
    信息修改  直接覆盖
     */
    @ResponseBody
    @RequestMapping(value="/look/app/ChangeUserInfo",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String ChangeUserInfo(HttpServletRequest request)
    {
        Map<String,String> map=new HashMap<String, String>();

        System.out.println("用户进行修改信息");
        user u=new user();
        String userjson= request.getParameter("user");
        u.setPhoneNumber("17843128994");
        System.out.println("用户数据"+userjson.toString());
        u=(user)JsonUtil.jsonToObj(userjson,user.class);
        System.out.println("用户对象"+u.toString());
        //进行保存头像
        String[] imageName={SetNameUtil.shareSetName(u.getId()+"",1)};
        String url="http://obs.myhwclouds.com/"+"look.app.photo/"+imageName[0];
        ThreadUpImage up=new ThreadUpImage();
        //设置桶名字
        up.setBuctetName("look.app.photo");
        //设置图片名字
        up.setImageName(imageName);
        String []imageContent={u.getUserHeadImage()};
        up.setImageContext(imageContent);
        u.setUserHeadImage(url);
        up.start();
        userservice.ChangeUserInfo(u);
        map.put("tag","success");
        map.put("url",u.getUserHeadImage());
        return JsonUtil.mapJson(map);
    }



    /*
    第三方登录
        1：先判断是首次登陆还是登陆过
        2;获取信息
     */
    @ResponseBody
    @RequestMapping(value="/look/app/otherLogin",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String otherLogin(HttpServletRequest request)
    {
        System.out.println("用户进行第三方登录");
        //先判断是否存在此用户，存在则登陆成功返回用户信息，不存在则进行录取初始化
        String otherLogin=request.getParameter("otherLogin");
        int num=0;
        try {
            num=userservice.JudegOtherLogin(otherLogin);
        }catch (Exception o)
        {
            //未查到，进行初始化
            user u=new user();
            u.setOtherLogin(otherLogin);
            u.setUserNickName(request.getParameter("userNickName"));
            u.setUserHeadImage(request.getParameter("userHeadImage"));
            userservice.saveOtherLogin(u);
            Map<String,Object> m=new HashMap<String,Object>();
            m.put("tag","success");
            m.put("user",u);
            return JsonUtil.mapJson(m);
        }
        if (num!=0)
        {
            user tu=new user();
            tu=userservice.getOtherLogin(otherLogin);
            Map<String,Object> m=new HashMap<String,Object>();
            m.put("tag","success");
            m.put("user",tu);
            return JsonUtil.mapJson(m);
        }
        return ReturnUtil.success();
    }


    /*
    登陆
     */
    /**
    *@Author Gaohongming
    *@Description:   登陆，返回用户的信息
    *@return:
    *@Data 19:29 2017/5/24
    */
    @ResponseBody
    @RequestMapping(value="/look/app/userLogin",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String userLogin(HttpServletRequest request)
    {
        System.out.println("用户进行账号密码登录");
        String phoneNumber=request.getParameter("phoneNumber");
        String passWord=request.getParameter("passWord");
        System.out.println(phoneNumber+"---"+passWord);
        System.out.println("用户"+phoneNumber+"-----"+passWord);
        user u=new user();
        u.setPhoneNumber("17843128994");
        u.setId(0);
        try {
            u = userservice.getUser(phoneNumber, passWord);
        }catch (Exception e)
        {
            System.out.println("登陆失败");
            Map<String ,Object> m=new HashMap<String ,Object>();
            m.put("tag","error");
            m.put("user",null);
            return JsonUtil.mapJson(m);
        }
        System.out.println("查找到用户"+u.toString());
        if (u.getId()!=0||u.getPassWord().equals(passWord))
        {
            System.out.println("登陆成功，进行修改用户信息");
            userservice.ChangeLoginFlag(u.getId());
            Map<String ,Object> m=new HashMap<String ,Object>();
            m.put("tag","success");
            m.put("user",u);
            System.out.println("返回的的数据");
            return JsonUtil.mapJson(m);
        }
        else {
            System.out.println("登陆失败2");
            Map<String ,Object> m=new HashMap<String ,Object>();
            m.put("tag","error");
            m.put("user",null);
            return JsonUtil.mapJson(m);
        }
    }

    /*
    退出登录
     */
    @ResponseBody
    @RequestMapping(value="/look/app/outLogin",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String outLogin(HttpServletRequest request)
    {
        System.out.println("用户进行退出登录");
        int id=Integer.parseInt(request.getParameter("id"));
        userservice.outLogin(id);
        return ReturnUtil.success();
    }

    /*
    获取兴趣
     */
    @ResponseBody
    @RequestMapping(value="/look/app/getHobby",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String getHobby(HttpServletRequest request)
    {
        List<first> a=userservice.getHobby();
        return JsonUtil.listJson(a);
    }



}
