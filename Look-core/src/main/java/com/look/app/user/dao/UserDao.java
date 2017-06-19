package com.look.app.user.dao;

import com.look.Administration.labelutil.model.first;
import com.look.app.user.model.user;
import com.look.utils.annotation.MyBatisScan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/4/18.
 */
@MyBatisScan
@Repository
public interface UserDao {
    user getUserInfoByID(int id);

    int JudgeUser(String phoneNumber);

    int SaveUser(@Param("phoneNumber") String phoneNumber, @Param("passWord") String passWord);

    void ChangeUserPassword(@Param("phoneNumber") String phoneNumber, @Param("passWord") String passWord);

    List<first> getHobby();

    void ChangeUserInfo(user u);

    int JudegOtherLogin(String otherLogin);

    void saveOtherLogin(user u);

    user getOtherLogin(String otherLogin);

    user getUser(@ Param("phoneNumber") String phoneNumber,@Param("passWord") String passWord);

    void ChangeLoginFlag(int id);

    void outLogin(int id);

    void ChangeUserIntrgral(user u);

    List<user> GetAllUserInfo();
}
