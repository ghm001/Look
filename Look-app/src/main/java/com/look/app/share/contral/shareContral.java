package com.look.app.share.contral;


import com.look.app.share.model.share;
import com.look.app.share.service.shareService;
import com.look.utils.JsonUtil;
import com.look.utils.LanguageUtil.LanguageTransforma;
import com.look.utils.ReturnUtil;

import com.look.utils.appUpImageUtile.appUpImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaohongming on 2017/4/21.
 */
@Controller
public class shareContral {
    @Resource
    shareService shervice;

    /*
    接受用户分享
    1：接受图片并分别储存
    2：讲数据放到数据库中
     */
    /**
    *@Author Gaohongming
    *@Description:  接受用户所上传的说说对象，并且进行记录
    *@return:
    *@Data 18:44 2017/5/23
    */
    @ResponseBody
    @RequestMapping(value="/look/app/saveShare",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String saveShare(HttpServletRequest request)
    {
        Map<String,Object> obj=new HashMap<String,Object>();
        String sharejson= request.getParameter("share");

        share sh= new share();
        sh=  (share) JsonUtil.jsonToObj(sharejson,share.class);


        System.out.println(sh.getImageNum()+"----"+sh.getUserNickName()+"----"+sh.getId()+"-----");

        sh= appUpImageUtil.upImageForShare(sh);
        System.out.println(sh.getImageUrl1()+"************");
        System.out.println(sh.getImageUrl2()+"**********");



        System.out.println(sh.toString());
        shervice.saveShare(sh);


        obj.put("TAG","success");
        obj.put("share",sh);
        System.out.println(JsonUtil.mapJson(obj));
        return JsonUtil.mapJson(obj);
    }


    @ResponseBody
    @RequestMapping(value="/look/app/getNewShare",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String getNewShare(HttpServletRequest request)
    {
return null;
    }




    /*
    查询10条数据
     */
    /**
    *@Author Gaohongming
    *@Description:    用户上传当前手机内最大的说说的id号，这边跟再取出几条数据，具体数量app端根据list。size判断
    *@return:
    *@Data 18:47 2017/5/23
    */
    @ResponseBody
    @RequestMapping(value="/look/app/getSomeShare",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String getSomeShare(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("minId"));
        List<share> list=shervice.getSomeShare(id);
        return  JsonUtil.listJson(list);
    }

    /*
    删除某条数据
     */
    /**
    *@Author Gaohongming
    *@Description:  传过来具体的某条说说的id号即可
    *@return:
    *@Data 19:50 2017/5/23
    */

    @ResponseBody
    @RequestMapping(value="/look/app/deleteOneShare",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String deleteOneShare(HttpServletRequest request)
    {
        int id =Integer.parseInt(request.getParameter("id"));
        shervice.deleteOneShare(id);
        return ReturnUtil.success();
    }

    /*
    列出本用户所有的记录
     */
    /**
    *@Author Gaohongming
    *@Description: 获取本用户所发过的所有的说说   上传用户的id即可
    *@return:
    *@Data 20:04 2017/5/23
    */
    @ResponseBody
    @RequestMapping(value="/look/app/getUserShare",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String getUserShare(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("userId"));
        List<share> list= shervice.getUserShare(id);
        return JsonUtil.listJson(list);
    }

}
