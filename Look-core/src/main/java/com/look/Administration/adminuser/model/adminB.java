package com.look.Administration.adminuser.model;

/**
 * Created by gaohongming on 2017/5/20.
 */
public class adminB {
    private int id;
    //用户名
    private String userName;
    //密码
    private String passWord;
    //身份证
    private String cardId;
    //公司
    private String company;
    //邮箱
    private String email;
    //积分
    private int balance;
    //昵称
    private String nickName;
    //用户姓名
    private String name;
    //用户权限   A  或者   B
    private String jurisdiction;
    //用户头像地址  默认的：https://obs.myhwclouds.com/look.admin.photo/1176473685/adminB.png
    private String ImageUrl;
    //用户登陆状态
    private String Flag;
    //用户登陆地址的ip
    private String loginIp;
    //
    private String RegistTime;

    public adminB() {
    }

    public adminB(int id, String userName, String passWord, String cardId, String company, String email, int balance, String nickName, String name, String jurisdiction, String imageUrl, String flag, String loginIp, String registTime) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.cardId = cardId;
        this.company = company;
        this.email = email;
        this.balance = balance;
        this.nickName = nickName;
        this.name = name;
        this.jurisdiction = jurisdiction;
        ImageUrl = imageUrl;
        Flag = flag;
        this.loginIp = loginIp;
        RegistTime = registTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getRegistTime() {
        return RegistTime;
    }

    public void setRegistTime(String registTime) {
        RegistTime = registTime;
    }

    @Override
    public String toString() {
        return "adminB{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", cardId='" + cardId + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", Flag='" + Flag + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", RegistTime='" + RegistTime + '\'' +
                '}';
    }
}
