package com.look.Administration.pictureInfoContral;

import com.look.Administration.adminuser.model.adminB;
import com.look.Administration.adminuser.service.adminService;
import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.model.second;
import com.look.Administration.labelutil.service.labelservice;
import com.look.Administration.pictureInfoContral.model.FinishModel;
import com.look.Administration.pictureInfoContral.model.PictureInfoModel;
import com.look.Administration.pictureInfoContral.service.pictureInfoService;
import com.look.Administration.upimage.model.imageInfo;
import com.look.Administration.upimage.service.upimageService;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.originPushtable;
import com.look.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohongming on 2017/5/29.
 */
@Controller
public class pictureInfoContral {
    @Resource
    pictureInfoService pictureInfoservice;
    @Resource
    labelservice    labelService;

    @Resource
    adminService    adminservice;
    @Resource
    upimageService    imageService;
    /*
    初始库信息查询
     */
    @ResponseBody
    @RequestMapping(value="/look/AdminB/originPicture",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String originPicture(HttpServletRequest request) {
        List<originPushtable> list=pictureInfoservice.getoriginPicture();
        List<PictureInfoModel>  infoList=new ArrayList<PictureInfoModel>();
        for (int i = 0; i <list.size() ; i++) {
            PictureInfoModel p=new PictureInfoModel(list.get(i).getImageId(),list.get(i).getAdminName(),list.get(i).getProduceTime(),list.get(i).getImageUrl());
            infoList.add(p);
        }
        return JsonUtil.listJson(infoList);
    }

    /*
    异常图片信息查询
     */
    @ResponseBody
    @RequestMapping(value="/look/AdminB/abnormalimageTable",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String abnormalimagetable(HttpServletRequest request) {
        return null;
    }

    /*
    完成库导出
     */
    @ResponseBody
    @RequestMapping(value="/look/AdminB/Finishtable",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String Finishtable(HttpServletRequest request) {
        System.out.println("进行完成库访问");
        List<FinshPictureModel> list=pictureInfoservice.getFinishtable();
        List<FinishModel> finList=new ArrayList<FinishModel>();
         String  templabel="";
        for (int i = 0; i <list.size() ; i++) {
       adminB a= adminservice.adminLogin(list.get(i).getAdminId());
            first f=labelService.getfirstInfo(list.get(i).getFirstLabelId());
            templabel=f.getLabelOne();
            if (list.get(i).getSecondLabelId()!=0){
                second  s=labelService.getsecondInfo(list.get(i).getSecondLabelId());
                templabel=s.getLabelSecond();
            }
            FinishModel  fin=new FinishModel(list.get(i).getImageId(),a.getCompany(),list.get(i).getFinishTime(),list.get(i).getImageUrl(),f.getLabelOne(),templabel);
           finList.add(fin);
        }
        return JsonUtil.listJson(finList);
    }
    /*
    推送库导出
     */
    @ResponseBody
    @RequestMapping(value="/look/AdminB/pushtable",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String pushtable(HttpServletRequest request) {
      List<imageInfo> list=pictureInfoservice.getCanPushPicture();
        List<PictureInfoModel>  infoList=new ArrayList<PictureInfoModel>();
        for (int i = 0; i <list.size() ; i++) {
            PictureInfoModel p=new PictureInfoModel(list.get(i).getId(),list.get(i).getAdminName(),list.get(i).getPushTime(),list.get(i).getImageUrl());
            infoList.add(p);
        }

        return JsonUtil.listJson(infoList);
    }
    /*
    标签信息导出
     */
    @ResponseBody
    @RequestMapping(value="/look/AdminB/getPictureLabel",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String getPictureLabel(HttpServletRequest request) {
        return null;
    }

}
