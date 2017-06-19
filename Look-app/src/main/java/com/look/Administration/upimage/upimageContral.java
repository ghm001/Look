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
    @RequestMapping("/moreUpload")
    public String moreUpload(HttpServletRequest request){


        //先进行转换
       System.out.println("进入多文件上传之中");
        System.out.println(request.getParameter("login"));
        System.out.println(request.getParameter("formData"));
        System.out.println(request.getParameter("loginName"));
        System.out.println(request.toString());
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Map<String, MultipartFile> files = multipartHttpServletRequest.getFileMap();
        System.out.println(multipartHttpServletRequest.getParameter("formData"));
        System.out.println(multipartHttpServletRequest.getParameter("loginName"));
        System.out.println(multipartHttpServletRequest.getParameter("login"));
        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "upload/";
        System.out.println(uploadUrl);
        File dir = new File(uploadUrl);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        int i=0;
        List<String> fileList = new ArrayList<String>();
        for (MultipartFile file :  files.values()) {
            i=i+1;
            System.out.println("----------------"+file.getName());
            File targetFile = new File(uploadUrl + file.getOriginalFilename());
            if (!targetFile.exists()) {
                try {
                    targetFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    file.transferTo(targetFile);

                    fileList.add("http://localhost:8080/lesson5/upload/" + file.getOriginalFilename());
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        request.setAttribute("files", fileList);
        return "moreUploadResult";
    }


}
