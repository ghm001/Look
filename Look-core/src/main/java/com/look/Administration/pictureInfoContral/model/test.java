package com.look.Administration.pictureInfoContral.model;

/**
 * Created by gaohongming on 2017/5/29.
 */
public class test {
    private int id;
    private String label;
    private String name;
    private int num;

    public test() {
    }

    public test(int id, String label, String name, int num) {
        this.id = id;
        this.label = label;
        this.name = name;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "test{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
