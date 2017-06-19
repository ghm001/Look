package com.look.app.Integral.model;

/**
 * Created by gaohongming on 2017/6/4.
 */
public class IntegralHistory {
    private int id;
    private int userId;
    //记录产生的时间
    private String Prodata;
    //对记录的说明
    private String explan;
    //操作
    private  String operation;
    //操作的数据量
    private int operationNum;

    public IntegralHistory() {
    }

    public IntegralHistory(int id, int userId, String prodata, String explan, String operation, int operationNum) {
        this.id = id;
        this.userId = userId;
        Prodata = prodata;
        this.explan = explan;
        this.operation = operation;
        this.operationNum = operationNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProdata() {
        return Prodata;
    }

    public void setProdata(String prodata) {
        Prodata = prodata;
    }

    public String getExplan() {
        return explan;
    }

    public void setExplan(String explan) {
        this.explan = explan;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getOperationNum() {
        return operationNum;
    }

    public void setOperationNum(int operationNum) {
        this.operationNum = operationNum;
    }

    @Override
    public String toString() {
        return "IntegralHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", Prodata='" + Prodata + '\'' +
                ", explan='" + explan + '\'' +
                ", operation='" + operation + '\'' +
                ", operationNum=" + operationNum +
                '}';
    }
}
