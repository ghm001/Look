package com.look.app.Integral;

import com.look.app.Integral.model.IntegralHistory;
import com.look.app.Integral.service.IntegralService;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.utils.JsonUtil;
import com.look.utils.ReturnUtil;
import com.look.utils.nameUtil.SetNameUtilService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by gaohongming on 2017/6/4.
 */
@Controller
public class IntegralContral {
    @Resource
    IntegralService Integralservice;
    @Resource
    UserService   userservice;

    /*
    用户积分的减少
     */
    @ResponseBody
    @RequestMapping(value="/look/app/UserIntegrareduce",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String UserIntegrareduce(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("userId"));
        user u=userservice.getUserInfoByID(id);
        u.setIntegral(u.getIntegral()-50);
        userservice.ChangeUserIntrgral(u);
        IntegralHistory in=new IntegralHistory();
        in.setUserId(id);
        in.setExplan("换取商品");
        in.setOperationNum(50);
        in.setOperation("-");
        in.setProdata(SetNameUtilService.getAccurateTime());
        Integralservice.UserIntegrareduce(in);
        return ReturnUtil.success();
    }

    /*
    积分记录
     */
    @ResponseBody
    @RequestMapping(value="/look/app/GetUserIngraHistory",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String GetUserIngraHistory(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("userId"));
        List<IntegralHistory> list=Integralservice.getUserIntegraHistory(id);
        return JsonUtil.listJson(list);
    }

    /*
    根据积分排名用户 一列用户的信息
     */
    @ResponseBody
    @RequestMapping(value="/look/app/GetUserRank",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String GetUserRank(HttpServletRequest request)
    {
        List<user> list=userservice.GetAllUserInfo();
        Map<Integer,user> map= new IdentityHashMap();
        List<user> list2=new ArrayList<user>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getIntegral(),list.get(i));
        }
        Set<Integer> set = map.keySet();
        //obj中的就是经过排序后的
        Object[] obj = set.toArray();
        Arrays.sort(obj);
        for (int i = obj.length; i >=0 ; i--) {
            list2.add(map.get(obj[i]));
        }
        return JsonUtil.listJson(list2);
    }



}
