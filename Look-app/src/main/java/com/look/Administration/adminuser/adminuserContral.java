package com.look.Administration.adminuser;

import com.look.Administration.adminuser.model.adminB;
import com.look.Administration.adminuser.service.adminService;
import com.look.utils.JsonUtil;
import com.look.utils.LanguageUtil.LanguageTransforma;
import com.look.utils.ReturnUtil;
import com.look.utils.appUpImageUtile.ThreadUpImage;
import com.look.utils.nameUtil.AdminNameUtil;
import com.look.utils.nameUtil.SetNameUtilService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaohongming on 2017/5/20.
 */
@Controller
public class adminuserContral {
    @Resource
    adminService adminservice;


    /*
    this is a test

     */

    /**
    *@Author Gaohongming
    *@Description: 管理员注册  传入完整的用户信息  需要初始化一下信息
    *@return:
    *@Data 18:50 2017/5/20
    */
    @ResponseBody
    @RequestMapping(value="/look/adminB/Register",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String Register (HttpServletRequest request)
    {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("新管理员进行注册");

        adminB a=new adminB();
        String username=request.getParameter("userName");
        String carId=request.getParameter("cardId");
        String company=request.getParameter("company");
        String name=request.getParameter("name");
        try {
             username   = new String( username.getBytes("ISO-8859-1"),"UTF-8");
            company   = new String( company.getBytes("ISO-8859-1"),"UTF-8");
            name   = new String( name.getBytes("ISO-8859-1"),"UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("用户名为"+username);
        adminB temp=adminservice.judgeAdminB(username);
        if(temp!=null)
        {
            return ReturnUtil.error();
        }
        adminB temp2=adminservice.judgeAdminBbycardId(carId);
        if(temp2!=null)
        {
            return ReturnUtil.error();
        }
        a.setUserName(username);
        a.setPassWord(request.getParameter("passWord"));
        a.setCardId(carId);
        a.setCompany(company);
        a.setEmail(request.getParameter("email"));
        a.setName(name);
        a.setImageUrl("http://obs.myhwclouds.com/look.admin.photo/1176473685/adminB.png");
        a.setBalance(0);
        a.setJurisdiction("B");
        a.setFlag("N");
        a.setLoginIp("");
        a.setNickName("");
        System.out.println("进行注册"+a.toString());
        a.setRegistTime(SetNameUtilService.getAccurateTime());
        adminservice.setAdminInfo(a);
        return  ReturnUtil.success();
    }



    /*、
    修改用户信息
     */
    @ResponseBody
    @RequestMapping(value="/look/adminB/changeAdminBInfo",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String changeAdminBInfo (HttpServletRequest request)
    {
        adminB a=new adminB();
       a.setCompany(LanguageTransforma.TransformUTF8( request.getParameter("company")));
        a.setEmail(request.getParameter("email"));
        a.setName(LanguageTransforma.TransformUTF8(request.getParameter("name")));
        a.setNickName(LanguageTransforma.TransformUTF8(request.getParameter("nickName")));
        a.setId(Integer.parseInt(request.getParameter("id")));
        adminservice.changeAdminBInfo(a);
        return  ReturnUtil.success();
    }
    /*
    增加积分  相当于充值
     */
    @ResponseBody
    @RequestMapping(value="/look/adminB/addAdminbalance",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String addAdminbalance (HttpServletRequest request)
    {
        adminB a=new adminB();
        a.setId(Integer.parseInt(request.getParameter("id")));
        a.setBalance(Integer.parseInt(request.getParameter("balance")));
        adminservice.addAdminbalance(a);
        return ReturnUtil.success();
    }

    /*
    上传头像     默认为Springle的图片上传
        分为初次上传和下次上传，这里需要注册的时候进行初始化一个默认的头像地址
     */
    @ResponseBody
    @RequestMapping(value="/look/adminB/upheadImage",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String upheadImage(HttpServletRequest request)
    {
        System.out.println(request.getParameter("id"));
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
     //   int id=Integer.parseInt(multipartHttpServletRequest.getParameter("id"));
       // String nickName=multipartHttpServletRequest.getParameter("nickName");
        //System.out.println(id+""+"------"+nickName);
        MultipartFile file=multipartHttpServletRequest.getFile(multipartHttpServletRequest.getFileNames().next());
        System.out.println(file.getOriginalFilename()+"------------------------");
        InputStream input=null;
        try {
             input=file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        adminB a=new adminB();
        a.setId(1);
        a.setNickName("高");
        //先上传到obs中
        String[] imageName={AdminNameUtil.photoSetName(a.getNickName(),1)};
        String url="http://obs.myhwclouds.com/"+"look.admin.photo/"+imageName[0];
        a.setImageUrl(url);

        ThreadUpImage up=new ThreadUpImage();
        //设置桶名字
        up.setBuctetName("look.admin.photo");
        //设置图片名字
        up.setImageName(imageName);
        //设置file
        up.setFile(input);
        up.start();
     adminservice.upheadImage(a);
        return ReturnUtil.success();
    }
    /*
    登陆的，登陆成功返回用户的所有的信
     */

    @ResponseBody
    @RequestMapping(value="/look/adminB/UserNameLogin",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String UserNameLogin(HttpServletRequest request) {
        String loginIp=request.getRemoteAddr();
        String username=request.getParameter("userName");
        String password=request.getParameter("passWord");
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        }catch (Exception e)
        {
            return ReturnUtil.error();
        }
        adminB temp=adminservice.judgeAdminB(username);
        if(temp==null)
        {
            return ReturnUtil.error();
        }else {
            if(temp.getPassWord().equals(password))
            {
                temp.setLoginIp(loginIp);
                System.out.println(temp.toString()+"登陆成功");
                //修改登录状态
                adminservice.login(temp);
                map.put("tag","success");
                map.put("user",temp);
            }
            else {
                System.out.println(temp.toString()+"登陆失败");
                map.put("tag","error");
            }
        }
        return JsonUtil.mapJson(map);
    }


    @ResponseBody
    @RequestMapping(value="/look/adminB/adminLogin",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String adminLogin(HttpServletRequest request) {
        String loginIp=request.getRemoteAddr();
        String id=request.getParameter("id");
        adminB b=new adminB();
        b.setId(Integer.parseInt(id));
        b.setLoginIp(loginIp);
        adminservice.login(b);
    //    adminB a=adminservice.adminLogin(loginIp,id);
        adminB c=adminservice.adminLogin(b.getId());
        return JsonUtil.objectToJson(c);
    }
    /*
    退出登录
     */
    @ResponseBody
    @RequestMapping(value="/look/adminB/outLogin",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String outLogin(HttpServletRequest request) {
        adminservice.outLogin(Integer.parseInt(request.getParameter("id")));
        return ReturnUtil.success();
    }

    /*

     */


}
