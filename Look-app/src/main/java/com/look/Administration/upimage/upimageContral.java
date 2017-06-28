package com.look.Administration.upimage;

import com.look.Administration.upimage.model.imageInfo;
import com.look.Administration.upimage.service.upimageService;
import com.look.utils.LanguageUtil.LanguageTransforma;
import com.look.utils.ReturnUtil;
import com.look.utils.SetNameUtil;
import com.look.utils.adminUpImageUtil.ThreadAdminUpImageUtil;
import com.look.utils.utilTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gaohongming on 2017/5/16.
 */
@Controller
public class upimageContral {
    @Resource
    upimageService   upimageservice;

    @ResponseBody
    @RequestMapping(value="/look/AdminB/upImage",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String AdminBupImage(HttpServletRequest request)
    {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        int id=Integer.parseInt(request.getParameter("id"));
        String upTime=SetNameUtil.getTime();
       String adminName= LanguageTransforma.TransformUTF8(request.getParameter("company"));;
        Map<String, MultipartFile> files = multipartHttpServletRequest.getFileMap();
        MultipartFile file=multipartHttpServletRequest.getFile(multipartHttpServletRequest.getFileNames().next());
        String name=SetNameUtil.getImageNaem(adminName,file.getOriginalFilename(),upTime);
        String url="http://obs.myhwclouds.com/"+"look.admin.image/"+name;
        imageInfo  image=new imageInfo();
        image.setAdminId(id);
        image.setUpTime(upTime);
        image.setAdminName(adminName);
        image.setImageUrl(url);
        image.setImageFlag("N");
        upimageservice.saveImageInfo(image);
        InputStream input=null;
        try {
            input=file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("记录成功"+"-----"+image.toString()+"-----"+"开始进入子线程"+"---"+"File文件"+input.toString());
        ThreadAdminUpImageUtil thread=new ThreadAdminUpImageUtil();
        thread.setImageUrl(url);
        thread.setFile(input);
        thread.setImageinfo(image);
        thread.setBuctetName("look.admin.image");
        thread.setImageName(name);
        thread.setImageId(image.getId());
        thread.start();
        return ReturnUtil.success();
    }

    /**
    *@Author Gaohongming
    *@Description:   测试框架接受图片文件
    *@return:
    *@Data 23:05 2017/5/16
    */
    @ResponseBody
    @RequestMapping("/moreUpload")
    public String moreUpload(HttpServletRequest request){

        return ReturnUtil.success();
    }


}
