package com.look.Administration.adminuser.service;

import com.look.Administration.adminuser.dao.adminUserDao;
import com.look.Administration.adminuser.model.adminB;
import com.look.Administration.adminuser.model.adminBuprecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gaohongming on 2017/5/20.
 */
@Service
public class AdminServiceImpl implements adminService {
    @Resource
    adminUserDao    admindao;

    //判断是否存在此管理员
    @Override
    public adminB judgeAdminB(String username) {
        return admindao.judgeAdminB(username);
    }

    //判断此身份证号是否进行过注册
    @Override
    public adminB judgeAdminBbycardId(String carId) {
        return admindao.judgeAdminBbycardId(carId);
    }

    //进行注册
    @Override
    public void setAdminInfo(adminB a) {
        admindao.setAdminInfo(a);
    }

    //记录管理员上传的图片的数据信息
    @Override
    public void setAdminuprecord(adminBuprecord b) {
        admindao.setAdminuprecord(b);
    }
    //修改管理员信息
    @Override
    public void changeAdminBInfo(adminB a) {
        admindao.changeAdminBInfo(a);
    }
   //增加管理员积分
    @Override
    public void addAdminbalance(adminB a) {
        admindao.addAdminbalance(a);
    }
   //管理员上传头像
    @Override
    public String upheadImage(@Param("a") adminB a) {
      admindao.upheadImage(a);
        return null;
    }

    @Override
    public adminB adminLogin(@Param("id") int id) {
        return admindao.adminLogin(id);
    }

    @Override
    public void login(adminB b) {
        admindao.login(b);
    }

    @Override
    public void outLogin(int id) {
        admindao.outLogin(id);
    }


}
