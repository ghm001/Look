package com.look.Administration.labelutil.model;

/**
 * Created by gaohongming on 2017/5/29.
 */
public class parent {
    private String labelNumber;

    public parent() {
    }

    public String getLabelNumber() {
        return labelNumber;
    }

    @Override
    public String toString() {
        return "parent{" +
                "labelNumber='" + labelNumber + '\'' +
                '}';
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public parent(String labelNumber) {

        this.labelNumber = labelNumber;
    }
}
