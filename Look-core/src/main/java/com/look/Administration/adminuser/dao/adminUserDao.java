package com.look.Administration.adminuser.dao;

import com.look.Administration.adminuser.model.adminB;
import com.look.Administration.adminuser.model.adminBuprecord;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

/**
 * Created by gaohongming on 2017/5/20.
 */
@MyBatisScan
@Repository
public interface adminUserDao {
    //判断用户是否存在
    adminB judgeAdminB(String username);
    //判断身份证号是否注册过
    adminB judgeAdminBbycardId(String carId);
    //注册
    void setAdminInfo(adminB a);
    //记录管理员上传图片的信息
    void setAdminuprecord(adminBuprecord b);
    //修改管理员信息
    void changeAdminBInfo(adminB a);
    //修改管理员积分
    void addAdminbalance(adminB a);
    //上传头像
    void upheadImage(adminB a);
    //登陆
    adminB adminLogin(int id);
    void login(adminB b);
    //注销
    void outLogin(int id);
}
