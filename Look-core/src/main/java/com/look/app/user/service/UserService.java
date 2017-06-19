package com.look.app.user.service;

import com.look.Administration.labelutil.model.first;
import com.look.app.user.model.user;

import java.util.List;

/**
 * Created by gaohongming on 2017/4/18.
 */
public interface UserService {
    user getUserInfoByID(int id);

    int JudgeUser(String phoneNumber);

    int SaveUser(String phoneNumber, String passWord);

    void ChangeUserPassword(String phoneNumber, String passWord);

    List<first> getHobby();

    void ChangeUserInfo(user u);

    int JudegOtherLogin(String otherLogin);

    void saveOtherLogin(user u);

    user getOtherLogin(String otherLogin);

    user getUser(String phoneNumber, String passWord);

    void ChangeLoginFlag(int id);

    void outLogin(int id);

    void ChangeUserIntrgral(user u);

    List<user> GetAllUserInfo();
}
