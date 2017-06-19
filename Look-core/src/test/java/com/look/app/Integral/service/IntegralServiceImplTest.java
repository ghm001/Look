package com.look.app.Integral.service;

import com.look.app.Integral.model.IntegralHistory;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.utils.JsonUtil;
import com.look.utils.ReturnUtil;
import com.look.utils.nameUtil.SetNameUtilService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class IntegralServiceImplTest {
    @Resource
    IntegralService Integralservice;
    @Resource
    UserService userservice;

    //测试生成一条记录
    @Test
    public void saveOneRecord() throws Exception {

        IntegralHistory in=new IntegralHistory();
        in.setUserId(17);
        in.setProdata(SetNameUtilService.getAccurateTime());
        in.setOperation("+");
        in.setOperationNum(30);
        in.setExplan("图片标签");
        user u=userservice.getUserInfoByID(17);
        u.setIntegral(u.getIntegral()+20);
        Integralservice.saveOneRecord(in);
        userservice.ChangeUserIntrgral(u);
    }

    //测试记录的减少
    @Test
    public void userIntegrareduce() throws Exception {

        int id=Integer.parseInt(17+"");
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
    }
    //测试得到用户的所有记录

    @Test
    public void getUserIntegraHistory() throws Exception {
        int id=Integer.parseInt(17+"");
        List<IntegralHistory> list=Integralservice.getUserIntegraHistory(id);
        System.out.println(JsonUtil.listJson(list));


    }
//测试得到所有用户的记录
    @Test
    public void getAllHistory() throws Exception {
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
        for (int i = obj.length-1; i >=0 ; i--) {
            list2.add(map.get(obj[i]));
        }
        System.out.println(JsonUtil.listJson(list2));
    }

}