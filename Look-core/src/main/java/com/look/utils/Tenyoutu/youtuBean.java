package com.look.utils.Tenyoutu;

/**
 * Created by gaohongming on 2017/5/25.
 */
public class youtuBean {
    private String tag_confidence;
    private String tag_name;

    public youtuBean(String tag_confidence, String tag_name) {
        this.tag_confidence = tag_confidence;
        this.tag_name = tag_name;
    }

    public youtuBean() {
    }

    public String getTag_confidence() {
        return tag_confidence;
    }

    public void setTag_confidence(String tag_confidence) {
        this.tag_confidence = tag_confidence;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    @Override
    public String toString() {
        return "youtuBean{" +
                "tag_confidence='" + tag_confidence + '\'' +
                ", tag_name='" + tag_name + '\'' +
                '}';
    }
}
