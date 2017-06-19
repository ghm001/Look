package com.look.app.user.service;

import com.look.Administration.labelutil.model.first;
import com.look.app.user.dao.UserDao;
import com.look.app.user.model.user;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/4/24.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userdao;


    //根据用户ID得到用户信息
    public user getUserInfoByID(int id) {
        return userdao.getUserInfoByID(id);
    }

//判断用户是否注册过
    public int JudgeUser(String phoneNumber) {
        return  userdao.JudgeUser(phoneNumber);
    }

//保存用户信息
    public int SaveUser(@Param("phoneNumber") String phoneNumber, @Param("passWord") String passWord) {
        return userdao.SaveUser(phoneNumber,passWord);
    }

//改变用户密码
    public void ChangeUserPassword(@Param("phoneNumber") String phoneNumber, @Param("passWord") String passWord) {
        userdao.ChangeUserPassword(phoneNumber,passWord);
    }
//得到所有的爱好种类 查找一级分类表
    @Override
    public List<first> getHobby() {
        return userdao.getHobby();
    }
//改变用户的信息
    @Override
    public void ChangeUserInfo(user u) {
        userdao.ChangeUserInfo(u);
    }
//判断第三方登录
    @Override
    public int JudegOtherLogin(String otherLogin) {
        return userdao.JudegOtherLogin(otherLogin);
    }
//保存第三方登录的信息
    @Override
    public void saveOtherLogin(user u) {
        userdao.saveOtherLogin(u);
    }
//得到第三方登录的信息
    @Override
    public user getOtherLogin(String otherLogin) {
        return userdao.getOtherLogin(otherLogin);
    }
//登录
    @Override
    public user getUser(@ Param("phoneNumber") String phoneNumber,@Param("passWord") String passWord) {
        return userdao.getUser(phoneNumber,passWord);
    }
//改变用户的登陆状态
    @Override
    public void ChangeLoginFlag(int id) {
        userdao.ChangeLoginFlag(id);
    }
//退出登录
    @Override
    public void outLogin(int id) {
        userdao.outLogin(id);
    }
//改变用户的积分
    @Override
    public void ChangeUserIntrgral(user u) {
        userdao.ChangeUserIntrgral(u);
    }
//得到所有的用户信息
    @Override
    public List<user> GetAllUserInfo() {
        return userdao.GetAllUserInfo();
    }
}
