package com.look.utils;

import com.look.Administration.labelutil.model.first;
import com.look.Administration.labelutil.model.fourth;
import com.look.Administration.labelutil.service.labelservice;
import com.look.Administration.labelutil.service.labelserviceImpl;
import com.look.app.share.model.share;
import com.look.utils.springContextUtil.SpringContextUtil;
import com.look.utils.springInit.SpringInit;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by gaohongming on 2017/4/28.
 */
public class utilTest {




    public static List<fourth> get(String name)
    {
       /* labelserviceImpl appcdService = (labelserviceImpl) SpringInit.getApplicationContext().getBean("labelserviceImpl");
        List<fourth> list= appcdService.searchFourth(name);
        System.out.println(list.size()+"------------------------");
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).toString());

        }*/
        labelserviceImpl dictService = (labelserviceImpl) SpringContextUtil.getBean("labelserviceImpl");
        List<fourth> list = (List<fourth>) dictService.searchFourth(name);
        System.out.println(list.size()+"---------------------------");
        return list;
    }

   /* public static void main(String [] args)
    {
        byte[] test=utilTest.getBytes("D:/科幻图片/wahaha.jpg");
        System.out.println("未转化的byte大小"+test.length);
        BASE64Encoder en=new BASE64Encoder ();
        //使用base将二进制数组进行加密成字符串
        String imageContext=en.encode(test);
       //  String imageContext=utilTest.getImageContext();
        String imageName=SetNameUtil.shareSetName("gaohongming",1);
        System.out.println("获取名字成功"+imageName);
        ByteArrayInputStream file=ImageUtil.getImageInputStream(imageContext);
        String buctetName="look.app.share";
       String url=ObsUtil.putImage(imageName,buctetName,file);
       System.out.println("上传成功，地址为"+url);
    }*/

    //测试本地文件，获取图片文件的二进制数组
    public static byte[] getBytes(String filePath){
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            System.out.println("文件的长度是"+file.length());
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(10000);
            byte[] b = new byte[10000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    //将图片写入本地文件
    public static String uploadImg(String imgName,String path,String ImageContent){

        //生成图片的随机数
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String time=dateFormat.format(date);
        //图片文件的名称

        String fileName="/"+imgName.trim()+time.trim()+".png";

        System.out.println(fileName);
        //创建图片文件
        File imgFile=new File(path+fileName);
        System.out.println(path+fileName);

        try {
            //向服务器端写文件
            byte [] bytes=new BASE64Decoder().decodeBuffer(ImageContent);
            OutputStream os=new FileOutputStream(imgFile);
            os.write(bytes,0,bytes.length);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }


    //为了测试，封装好6张图片对应的imageConttest
    public static String[] getImageContest()
    {
        String a[]=new String[6];
        for (int i=1;i<=1;i++)
        {
            StringBuffer s=new StringBuffer("D:/科幻图片/");
            s.append(i);
            s.append(".jpg");
            byte[] imagebyte=utilTest.getBytes(s.toString());
            System.out.println("未转化的byte大小"+imagebyte.length);
            BASE64Encoder end=new BASE64Encoder ();
            a[i-1]=end.encode(imagebyte);
        }
        return  a;
    }

    public static void main(String [] args)
    {
        System.out.println(5%6);

      // get("%苹果%");
       /* share sh=getShare();
        String json=JsonUtil.objectToJson(sh);
        System.out.println(json);*/
     //   share th=(share) JsonUtil.jsonToObj(json,share.class);
       // System.out.println(th.toString());
    }

    //封装好的一组说说信息
    public static share getShare()
    {
        share testsh=new share();
        testsh.setId(1);
        testsh.setuId(1);
        testsh.setUptime("2017-4-30");
        testsh.setImageNum(6);
        //String[] a=utilTest.getImageContest();
        String[] a={"1sdasdadasdasdasdasdasdas","2asdsadsadasfasgdsdfgdfgd","3dfgsdgsdfgsdfgsdfg","4dfsgdfsgdsfgdfgsd","5sdfgsdfgfdgsdfgd","6sdfgdfgfdgfdgfdgsdg"};
       testsh.setImageUrl1(a[0]);
        testsh.setImageUrl2(a[1]);
        testsh.setImageUrl3(a[2]);
        testsh.setImageUrl4(a[3]);
        testsh.setImageUrl5(a[4]);
        testsh.setImageUrl6(a[5]);
        testsh.setTitle("这是说说");
        /*
        根据用户的id进行获取
         */
        testsh.setUserNickName("测试数据");
        testsh.setUserPhotoUrl("测试数据");
        return testsh;
    }

}
