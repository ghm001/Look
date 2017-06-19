package com.look.utils.appUpImageUtile;

import com.look.utils.ImageUtil;
import com.look.utils.ObsUtil;
import com.look.utils.SetNameUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by gaohongming on 2017/4/30.
 */
public class ThreadUpImage extends Thread {
    /*
    这个线程进行上传图片到华为obs操作
     传入图片名字数组  和图片数据数组
     */
    private String[] imageContext;
    private String[] imageName;
    /*
           分享图片仓库：look.app.share
           头像仓库名：look.app.photo
           管理员头像仓库名  look.admin.photo
     */
    private String buctetName;
    private InputStream file;

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public String getBuctetName() {
        return buctetName;
    }

    public void setBuctetName(String buctetName) {
        this.buctetName = buctetName;
    }

    public String[] getImageName() {
        return imageName;
    }
    public void setImageName(String[] imageName) {
        this.imageName = imageName;
    }

    public String[] getImageContext() {
        return imageContext;
    }
    public void setImageContext(String[] imageContext) {
        this.imageContext = imageContext;
    }

    public void run() {
        System.out.println("进入子线程运行");
        if(imageContext!=null) {
            for (int i = 0; i < imageContext.length; i++) {
                ByteArrayInputStream file = ImageUtil.getImageInputStream(imageContext[i]);
                String urls = ObsUtil.putImage(imageName[i], buctetName, file);
                System.out.println("上传成功，地址为" + urls);
            }
        }
        if (imageContext==null)
        {
            String urls = ObsUtil.putImage(imageName[0], buctetName,file);
            System.out.println("上传成功，地址为" + urls);
        }
    }
}
