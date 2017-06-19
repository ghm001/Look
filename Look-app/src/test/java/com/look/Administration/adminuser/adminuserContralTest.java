package com.look.Administration.adminuser;

import com.look.Administration.upimage.model.imageInfo;
import com.look.Administration.upimage.service.upimageService;
import com.look.picture.judgeLabel.model.judgetable;
import com.look.picture.judgeLabel.service.judgeLabelService;
import com.look.picture.pushPicture.model.originPushtable;
import com.look.picture.pushPicture.model.pushtable;
import com.look.picture.pushPicture.service.pushPiceturService;
import com.look.utils.ObsUtil;
import com.look.utils.setObjValueUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/6/10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class adminuserContralTest {

    @Resource
    pushPiceturService pushservice;
    @Resource
    upimageService   upimahe;
    @Resource
    judgeLabelService  judgeService;
    @Test
    public void TestsuijiPush()
    {
        String filepath="E:\\app测试i图片\\老马识图\\兴趣推送-43-";


        String BucketName="look.admin.image";
     //  File file = new File("E://app测试i图片//办公文教-2-热门种类1-精选种类1-22");
        try {
            File file = new File(filepath);
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        InputStream inputStream=new FileInputStream(readfile) ;
                        System.out.println("absolutepath="
                                + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());
                        //公司名+时间+文件名 时间精确到天


                        String imageName="老马识图/2017-5-25/"+readfile.getName();


                        String url= ObsUtil.putImage(imageName,BucketName,inputStream);
                        System.out.println(url+"-----------------");

                        //信息写入到数据库
                        //先进行录入兴趣推送
                            //判定表   图片信息表   推送表
                        imageInfo  image=new imageInfo();


                        image.setUpTime("2017-5-25");

                        image.setImageUrl(url);

                        image.setAdminName("老马识图");

                        image.setAdminId(3);
                        image.setImageFlag("P");
                       // image.setPushTime("2017-5-23");
                        upimahe.saveImageInfo(image);
                        System.out.println("图片的信息是"+image.toString());
                        //判定表
                        judgetable ju=new judgetable();
                        ju.setImageUrl(url);
                        ju.setImageId(image.getId());
                        ju.setState("NO");
                        ju.setUseNum(3);
                        String[] label=readfile.getName().split("-");
                        for (int j = 0; j <label.length ; j++) {
                           String temp=label[j];

                            if (temp.contains("."))
                            {
                                System.out.println(temp+"-------");
                                 temp=temp.substring(0,temp.lastIndexOf("."));

                            }
                            setObjValueUtil.setAttributeValueFromObj("label",ju,j+1,temp);
                            setObjValueUtil.setAttributeValueFromObj("Flag",ju,j+1,"2");
                        }
                        ju.setLabelNum(label.length);
                        System.out.println("判定表之中的信息是"+ju.toString());
                        judgeService.saveLabelAtFirst(ju);
                        //进行推送表的操作
                        pushtable pu=new pushtable();
                        pu.setImageId(image.getId());
                        pu.setImageUrl(url);
                        pu.setProduceName("警察");
                        pu.setAdminId(image.getAdminId());

                        pu.setProduceTime("2017-5-25");

                        pu.setProducerId(18);
                        pu.setFirstId(44);
                        pu.setSecondId(0);
                        System.out.println("判定表之中的信息是");
                        pu.toString();
                        pushservice.savePushtable(pu);

                    }
                }

        } catch (Exception e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }

    }



}