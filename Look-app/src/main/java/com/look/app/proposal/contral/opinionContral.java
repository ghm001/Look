package com.look.app.proposal.contral;


import com.look.app.proposal.model.opinion;
import com.look.app.proposal.service.opinionService;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.utils.JsonUtil;
import com.look.utils.LanguageUtil.LanguageTransforma;
import com.look.utils.ReturnUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gaohongming on 2017/4/22.
 */
@Controller
public class opinionContral {
   @Resource
   opinionService opinionservice;
    @Resource
    UserService userservice;

       /**
       *@Author Gaohongming
       *@Description: 接受用户提送的建议
       *@return:   flag：success  or  error
       *@title 23:48 2017/4/22
        * 参数：opinion={"id":0,"uId":1,"title":"2015","userImageUrl":"","userNickname":""}
       */
    @ResponseBody
    @RequestMapping(value="/look/app/AcceptAnOffer",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
public String AcceptAnOffer(HttpServletRequest request)
{
    int num=0;
    System.out.println("用户提交建议：");
    System.out.println(request.getParameter("opinion"));
    opinion opn= (opinion) JsonUtil.jsonToObj(LanguageTransforma.TransformUTF8(request.getParameter("opinion")),opinion.class);
    System.out.println("用户id为："+opn.getuId());
    //获取这个用户的基本信息
     user u=userservice.getUserInfoByID(opn.getuId());
    System.out.println("用户"+u.toString());
    opn.setUserImageUrl(u.getUserHeadImage());
    opn.setUserNickname(u.getUserNickName());
    //将完整信息写入到数据库中
      num= opinionservice.insertInfo(opn);
    if(num==0)
    {
        return ReturnUtil.error();
    }
        return ReturnUtil.success() ;
}

/**
*@Author Gaohongming
*@Description:   获取到所有用户的反馈信息
*@return:    包含所有用户反馈的list
*@Data 16:21 2017/5/23
*/
    @ResponseBody
    @RequestMapping(value="/look/app/getAllOffer",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String getAllOffer(HttpServletRequest request)
    {
        List<opinion> op=opinionservice.getAllOffer();
        return JsonUtil.listJson(op);

    }
}
