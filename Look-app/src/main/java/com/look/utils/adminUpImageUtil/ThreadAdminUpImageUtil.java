package com.look.utils.adminUpImageUtil;

import com.look.Administration.labelutil.model.*;
import com.look.Administration.labelutil.service.labelserviceImpl;
import com.look.Administration.upimage.model.imageInfo;
import com.look.Administration.upimage.service.upimageServiceImpl;
import com.look.picture.judgeLabel.model.judgetable;
import com.look.picture.judgeLabel.service.judgeLabelServiceImpl;
import com.look.picture.pushPicture.model.originPushtable;
import com.look.picture.pushPicture.model.pushtable;
import com.look.picture.pushPicture.service.pushPictureServiceImpl;
import com.look.utils.ObsUtil;
import com.look.utils.SetNameUtil;
import com.look.utils.Similaritydegree.labelSimilarity;
import com.look.utils.Tenyoutu.youtuBean;
import com.look.utils.Tenyoutu.youtuUtil;
import com.look.utils.labelUtil.ServiceUtils;
import com.look.utils.setObjValueUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gaohongming on 2017/5/21.
 */
public class ThreadAdminUpImageUtil extends Thread  {

   private int imageId;
    private String imageUrl;
    private String buctetName;
    private InputStream file;
    private String imageName;
    private imageInfo imageinf;

    public imageInfo getImageinfo() {
        return imageinf;
    }

    public void setImageinfo(imageInfo imageinf) {
        this.imageinf = imageinf;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBuctetName() {
        return buctetName;
    }

    public void setBuctetName(String buctetName) {
        this.buctetName = buctetName;
    }

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("进入子线程运行");
        long startTime=System.currentTimeMillis();   //获取开始时间
        //上传到华为obs
        String urls = ObsUtil.putImage(imageName, buctetName,file);
        System.out.println("上传到华为云Obs成功，上传地址为："+"--"+urls);
        upimageServiceImpl  upimage=ServiceUtils.getupImageService();
        if(urls.equals("error"))
        {
            //错误则删除数据
            upimage.deleteImageInfo(imageinf.getId());
        }
        //调用腾讯优图
        List<youtuBean>  list= youtuUtil.getLableFromTenYouTu(urls);
//        System.out.println("调用腾讯优图成功，结果为"+list.size()+"*---"+list.get(0).toString());
        //记录去去除过错误标签的腾讯优图产生的标签
        List<String> listr=new ArrayList<String>();
        //得到推送service，用来保存数据
        pushPictureServiceImpl pushPictureservice=ServiceUtils.getpushPictureServiceImpl();
        //得到判定表service用来保存数据
        judgeLabelServiceImpl judgelabelservice = ServiceUtils.getjudgeLabelServiceImpl();
        //去除  其他  截图    然后录入
        int temp=0;   //记录标签的数量
        int temp2=0;  //记录去除的标签的遍历状态
        boolean fl=false;//记录在标签数中查找的结果的状态
        judgetable ju=new judgetable();
        for(int j=0;j<list.size();j++)
        {
            String label=list.get(j).getTag_name();
          if(!label.equals("其他")&&!label.equals("截图"))
          {
              listr.add(label);
              temp=temp+1;
              StringBuffer b=new StringBuffer("label");
              b.append(temp);
              setObjValueUtil.setData(ju,b.toString(),label);
              StringBuffer c=new StringBuffer("Flag");
              c.append(temp);
              //代表标签状态正常
              setObjValueUtil.setData(ju,c.toString(),"1");
          }
        }
        //如果腾讯优图未返回正确的标签，将图片放入另一个推送库中
        if(temp==0)
        {
            originPushtable   originpush=new originPushtable();
            originpush.setImageId(imageId);
            originpush.setImageUrl(imageUrl);
            originpush.setAdminName(imageinf.getAdminName());
            originpush.setProduceTime(imageinf.getUpTime());
            originpush.setAdminId(imageinf.getAdminId());
            //保存图片到初始化推送表之中
            pushPictureservice.saveOriginPicrureInfo(originpush);
        }

        //如果temp不等于0说明产生了标签，可以进行推送生成的操作
        if(temp!=0) {
            //设置图片的其他的信息
            ju.setImageUrl(imageUrl);
            ju.setState("0");
            ju.setLabelNum(temp);
            ju.setUseNum(0);
            ju.setImageId(imageId);
            //写进判定表之中
            judgelabelservice.saveLabelAtFirst(ju);
            System.out.println("图片对应的标签是" + ju.toString());
            //查找相似的标签  每次循环操控一个标签
            for (int i = 0; i < temp; i++) {
                String label = listr.get(i);
                //需要取出的子   其他   截图
                labelserviceImpl la = ServiceUtils.getLabelServiceImpl();
                //得到标签树中的标签
                List<first> firList = la.searchFirst("%" + label + "%");
                List<second> sedList = la.searchSecond("%" + label + "%");
                List<third> thList = la.searchThird("%" + label + "%");
                List<fourth> foList = la.searchFourth("%" + label + "%");
                List<fifth> fifList = la.searchFifth("%" + label + "%");
                //进行判断得到最大三组推送，最少没有并且这个标签异常  最后在修改判定表中的数据
                 //z中存放的是经过去重之后的数据，然后在包装推送对象 m中是经过筛选的数据
              List m= labelSimilarity.getBest(firList,sedList,thList,foList,fifList,label);
                if(m.size()!=0)
                {
                    //即在标签树上找到了标签 就会产生推送
                    fl=true;
                    imageinf.setImageFlag("P");
                }else
                {
                    //如果未找到，则跳出，继续下一个标签的执行
                    break;
                }
                Map<String ,Object> z=labelSimilarity.Duplicateremoval(m);
                //下面为产生推送数据
                for(String key:z.keySet())
                {
                    if(temp2<=(z.size()/2)+1)
                    {
                        System.out.println(key+"---"+z.get(key)+"----");
                        pushtable push=new pushtable();
                        push.setImageId(imageId);
                        push.setAdminId(imageinf.getAdminId());
                        push.setImageUrl(imageUrl);
                        push.setProduceTime(imageinf.getUpTime());
                     //取数据放入到push之中
                        parent p=(parent) z.get(key);
                        String[] labelId=p.getLabelNumber().split("-");
                        System.out.println(labelId.length+"**********");
                        for (int j = 0; j <labelId.length ; j++) {
                          switch (j)
                          {
                              case 0:push.setFirstId(Integer.parseInt(labelId[j]));break;
                              case 1:push.setSecondId(Integer.parseInt(labelId[j]));break;
                              case 2:push.setThirdId(Integer.parseInt(labelId[j]));break;
                              case 3:push.setFourId(Integer.parseInt(labelId[j]));break;
                              case 4:push.setFifthId(Integer.parseInt(labelId[j]));break;
                          }
                        }
                        push.setProduceName("腾讯优图");
                        push.setProducerId(0);
                        //写入到推送表之中
                        pushPictureservice.savePushtable(push);

                        temp2++;
                    }
                }
            }
            if (!fl)
            {
                //即没有产生推送
                originPushtable   originpush=new originPushtable();
                originpush.setImageId(imageId);
                originpush.setImageUrl(imageUrl);
                originpush.setAdminName(imageinf.getAdminName());
                originpush.setProduceTime(imageinf.getUpTime());
                originpush.setAdminId(imageinf.getAdminId());
                //保存图片到初始化推送表之中
                pushPictureservice.saveOriginPicrureInfo(originpush);
                //最后如果fl为false。即都没有在标签数中找到标签

            }else
            {
                //产生推送修改图片信息表的图片状态
                imageinf.setPushTime(SetNameUtil.getAccurateTime());
                upimage.ChangeImageFlag(imageinf);
            }
        }

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
