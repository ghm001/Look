package com.look.Administration.adminuser.service;

import com.look.Administration.adminuser.model.adminB;
import com.look.Administration.adminuser.model.adminBuprecord;

/**
 * Created by gaohongming on 2017/5/20.
 */
public interface adminService {
    adminB judgeAdminB(String username);

    adminB judgeAdminBbycardId(String carId);

    void setAdminInfo(adminB a);

    void setAdminuprecord(adminBuprecord b);

    void changeAdminBInfo(adminB a);

    void addAdminbalance(adminB a);

    String upheadImage(adminB a);

    adminB adminLogin( int id);

    void login(adminB b);

    void outLogin(int id);
}
