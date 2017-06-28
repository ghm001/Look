package com.look.picture.judgeLabel;

import com.look.Administration.labelutil.model.*;
import com.look.Administration.labelutil.service.labelservice;
import com.look.Administration.upimage.model.imageInfo;
import com.look.Administration.upimage.service.upimageService;
import com.look.app.Integral.model.IntegralHistory;
import com.look.app.Integral.service.IntegralService;
import com.look.app.user.model.user;
import com.look.app.user.service.UserService;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.FinishPicture.service.FinishPictureService;
import com.look.picture.abnormalPicture.model.abnormalimage;
import com.look.picture.abnormalPicture.service.abnormalPictureService;
import com.look.picture.judgeLabel.model.judgetable;
import com.look.picture.judgeLabel.service.judgeLabelService;
import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.picture.pushPicture.model.pushtable;
import com.look.picture.pushPicture.service.pushPiceturService;
import com.look.utils.JsonUtil;
import com.look.utils.LanguageUtil.LanguageTransforma;
import com.look.utils.ReturnUtil;
import com.look.utils.SetNameUtil;
import com.look.utils.Similaritydegree.labelSimilarity;
import com.look.utils.labelUtil.GetAllLabelUtil;
import com.look.utils.setObjValueUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by gaohongming on 2017/5/25.
 */
@Controller
public class JudgeLabelContral {

    @Resource
    judgeLabelService judgelabelservice;

    @Resource
    upimageService imageInfoService;

    @Resource
    labelservice labelUtil;
    @Resource
    UserService userservice;
    @Resource
    pushPiceturService pushpictureservice;
    @Resource
    IntegralService Integralservice;
    @Resource
    FinishPictureService finishService;
    @Resource
    abnormalPictureService abnormalService;
    /*
    接受用户的标签并进行判定
     */

    /*
    保存用户的标签
     */
         /*
    接受用户的保存
         */
    @ResponseBody
    @RequestMapping(value = "/look/picture/saveUserUpImageInfo", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/plain;charset=UTF-8")
    public String saveUserUpImageInfo(HttpServletRequest request) {
            /*
            这里标签不进行解析，直接原封不动
             */
        appImageGrouping appGroup = new appImageGrouping();
        String appGroupInfoJson = request.getParameter("appImageGrouping");
        appGroup = (appImageGrouping) JsonUtil.jsonToObj(appGroupInfoJson, appImageGrouping.class);
        //获取时间
        appGroup.setSetTime(SetNameUtil.getAccurateTime());
        if(appGroup.getFlag().equals("N"))
        {
            appGroup.setFlag("S");//代表保存的S
            appGroup.setSecondlabelName("生活场景");
            judgelabelservice.saveUserUpImageInfo(appGroup);
        }else
        {
            judgelabelservice.ChangeUserUpImageInfo(appGroup);
        }
        return ReturnUtil.success();
    }

    /*
    接受用户的提交的标签
     */
    @ResponseBody
    @RequestMapping(value = "/look/picture/judgeUserUpInageLabelInfo", method = {RequestMethod.POST, RequestMethod.GET}, produces = "text/plain;charset=UTF-8")
    public String judgeUserUpInageLabelInfo(HttpServletRequest request) {



        boolean isBronPush=false;
        int temp2 = 0;  //记录去除的标签的遍历状态
        appImageGrouping appGroup = new appImageGrouping();
        System.out.println(request.getParameter("appImageGrouping")+"------------------");
        String appGroupInfoJson= request.getParameter("appImageGrouping");

        System.out.println("接受到标签数据"+appGroupInfoJson);
        appGroup = (appImageGrouping) JsonUtil.jsonToObj(appGroupInfoJson, appImageGrouping.class);
        appGroup.setSetTime(SetNameUtil.getAccurateTime());
        appGroup.setSecondlabelName("生活场景");
        //得到用户的信息
        //改变用户的积分状态   记录积分的增加
        //记录本次标签的状态  preservation表   并且设定为提交的
        user u = userservice.getUserInfoByID(appGroup.getUserId());
        System.out.println("用户的信息" + u.toString());
        IntegralHistory intehral=new IntegralHistory();
        intehral.setUserId(u.getId());
        intehral.setOperation("+");
        intehral.setProdata(appGroup.getSetTime());
        intehral.setExplan("图片标签");
        intehral.setOperationNum(30);
        u.setIntegral(u.getIntegral()+30);
        userservice.ChangeUserIntrgral(u);
        Integralservice.saveOneRecord(intehral);

        //如果是S，则代表是已经在数据库中保存过的，从历史记录过去的再次提交的  这里改变记录的状态为S，并且更新标签信息
        if(appGroup.getFlag().equals("N"))
        {
            appGroup.setFlag("T");//代表保存的S
            judgelabelservice.saveUserUpImageInfo(appGroup);
        }
        if(appGroup.getFlag().equals("S"))
        {
            appGroup.setFlag("T");
            judgelabelservice.ChangeUserUpImageInfo(appGroup);
        }
        if(appGroup.getPushWay().equals("随机推送"))
        {
            for (int i = 0; i < appGroup.getImageNum(); i++)
            {
                int id = (Integer) setObjValueUtil.getAttributeValueFromObj("imageId", appGroup, (i + 1));
                System.out.println("当前正在进行判定的图片的id是" + id + "-------------------------------");
                String imageUrl = (String) setObjValueUtil.getAttributeValueFromObj("imageUrl", appGroup, (i + 1));
                System.out.println("图片的地址" + imageUrl);
                imageInfo imageinf = imageInfoService.getImageInfoFromImageId(id);
                judgetable ReImageInfo = judgelabelservice.getJudgeTableInfoByImageId(id);
                if(ReImageInfo==null)
                {
                    System.out.println("判定库中没有这张图片的信息，进行新建");
                    judgetable ju=new judgetable();
                    ju.setImageId(id);
                    ju.setUseNum(1);
                    ju.setState("N");
                    ju.setImageUrl(imageinf.getImageUrl());
                    String labelTemp = (String) setObjValueUtil.getAttributeValueFromObj("label", appGroup, (i + 1));
                    System.out.println("上传的的本图片的标签" + labelTemp);
                    if (!labelTemp.equals(""))
                    {
                        String[] label = labelTemp.split("-");
                        System.out.println("上传的标签的数量" + label.length);
                        for (int j = 0; j < label.length; j++)
                        {
                            setObjValueUtil.setAttributeValueFromObj("label",ju,(j+1),label[j]);
                            List<first> firList = labelUtil.searchFirst("%" + label[j] + "%");
                            List<second> sedList = labelUtil.searchSecond("%" + label[j] + "%");
                            List<third> thList = labelUtil.searchThird("%" + label[j] + "%");
                            List<fourth> foList = labelUtil.searchFourth("%" + label[j] + "%");
                            List<fifth> fifList = labelUtil.searchFifth("%" + label[j] + "%");
                            List m = labelSimilarity.getBest(firList, sedList, thList, foList, fifList, label[j]);
                            if (m.size() != 0)
                            {
                                System.out.println("产生了推送");
                                isBronPush=true;
                                setObjValueUtil.setAttributeValueFromObj("Flag", ju, (j+1), 1 + "");
                                ju.setLabelNum(ju.getLabelNum()+1);
                                System.out.println("进行录入在标签树上找到的标签，并设定为状态为" + (ju.getLabelNum() ));
                            } else
                            {
                                setObjValueUtil.setAttributeValueFromObj("Flag", ju, (j+1), "E");
                                ju.setLabelNum(ju.getLabelNum()+1);
                                System.out.println("进行录入没有在标签树上找到的标签，并设定为状态为" + (ju.getLabelNum()));
                            }
                            Map<String, Object> z = labelSimilarity.Duplicateremoval(m);
                            for (String key : z.keySet())
                            {
                                if (temp2 <= (z.size() / 2) + 1)
                                {
                                    System.out.println(key + "---" + z.get(key) + "----");
                                    pushtable push = new pushtable();
                                    push.setImageId(id);
                                    push.setAdminId(imageinf.getAdminId());
                                    push.setImageUrl(imageinf.getImageUrl());
                                    push.setProduceTime(SetNameUtil.getAccurateTime());
                                    //取数据放入到push之中
                                    parent p = (parent) z.get(key);
                                    String[] labelId = p.getLabelNumber().split("-");
                                    System.out.println(labelId.length + "**********" + p.toString());
                                    for (int k = 0; k < labelId.length; k++)
                                    {
                                        switch (k)
                                        {
                                            case 0:
                                                push.setFirstId(Integer.parseInt(labelId[k]));
                                                break;
                                            case 1:
                                                push.setSecondId(Integer.parseInt(labelId[k]));
                                                break;
                                            case 2:
                                                push.setThirdId(Integer.parseInt(labelId[k]));
                                                break;
                                            case 3:
                                                push.setFourId(Integer.parseInt(labelId[k]));
                                                break;
                                            case 4:
                                                push.setFifthId(Integer.parseInt(labelId[k]));
                                                break;
                                        }
                                    }
                                    push.setProduceName(u.getUserNickName());
                                    push.setProducerId(u.getId());
                                    push.setImageUrl(imageUrl);
                                    System.out.println("产生推送信息" + push.toString());
                                    //写入到推送表之中
                                    // pushpictureservice.savePushtable(push);
                                }
                            }
                        }
                    }
                    if(isBronPush)
                    {
                        //产生了推送 修改图片信息表信息并且删除初始库之中数据
                        imageinf.setImageFlag("P");
                        imageinf.setPushTime(SetNameUtil.getAccurateTime());
                        //   imageInfoService.ChangeImageFlag(imageinf);
                        //  pushpictureservice.deleteInfoFromOriginTable(id);
                    }
                    //写入判定表之中数据
                    System.out.println("录入新的判定表的数据"+ju.toString());
                    // judgelabelservice.saveLabelAtFirst(ju);
                }
                else
                {
                    System.out.println("判定哭中有这张图片的信息，进行修改并且录去");
                    ReImageInfo.setUseNum(ReImageInfo.getUseNum() + 1);
                    System.out.println("修改本张判定表之中的图片的信息人数+1");
                    //从上传本组信息中得到标签的信息
                    String labelTemp = (String) setObjValueUtil.getAttributeValueFromObj("label", appGroup, (i + 1));
                    System.out.println("上传的的本图片的标签" + labelTemp);
                    if (!labelTemp.equals(""))
                    {
                        String[] label = labelTemp.split("-");
                        System.out.println(label[0] + "------------------------------");
                        System.out.println("上传的标签的数量" + label.length);
                        //先获取这张图片的异常
                        abnormalimage   abnor=abnormalService.getPictureInfoFromAbnormal(imageinf.getId());
                        StringBuffer abnortempLabel=new StringBuffer();
                        //定义一个状态来记录是否产生了异常
                        boolean isHasabnorma=false;
                        boolean isHasabnormaltable=true;
                        for (int j = 0; j < label.length; j++)
                        {
                            //得到每个标签对应的判定表之中的位置   0即未找到相同的
                            int locate = labelSimilarity.getSimilaryBest(label[j], ReImageInfo);
                            System.out.println("最相似的位置" + locate);
                            if (locate == 0)
                            {
                                if(ReImageInfo.getLabelNum()>=10)
                                {
                                    isHasabnorma=true;
                                    System.out.println("标签数量超过限制，录取额外的异常表，不再进行判定和生成推送");
                                    System.out.println("进行查找异常表看是否存在这张图片的异常");
                                    if (abnor==null)
                                    {
                                        isHasabnormaltable=false;
                                        System.out.println("新建异常表");
                                        abnor=new abnormalimage();
                                        abnor.setImageUrl(imageinf.getImageUrl());
                                        abnor.setJudgetableId(ReImageInfo.getId());
                                        abnor.setAdminId(imageinf.getAdminId());
                                        abnor.setProductTime(SetNameUtil.getAccurateTime());
                                        abnor.setImageId(imageinf.getId());
                                        abnortempLabel.append(label[j]+"-");
                                        abnor.setLabels(abnortempLabel.toString());
                                        continue;
                                    }else {
                                        System.out.println("异常表进行标签的累加");
                                        abnortempLabel=new StringBuffer(abnor.getLabels());
                                        abnortempLabel.append(label[j]+"-");
                                        abnor.setLabels(abnortempLabel.toString());
                                        continue;
                                    }

                                }
                                List<first> firList = labelUtil.searchFirst("%" + label[j] + "%");
                                List<second> sedList = labelUtil.searchSecond("%" + label[j] + "%");
                                List<third> thList = labelUtil.searchThird("%" + label[j] + "%");
                                List<fourth> foList = labelUtil.searchFourth("%" + label[j] + "%");
                                List<fifth> fifList = labelUtil.searchFifth("%" + label[j] + "%");
                                List m = labelSimilarity.getBest(firList, sedList, thList, foList, fifList, label[j]);
                                //修改图片判定表中的数据
                                setObjValueUtil.setAttributeValueFromObj("label", ReImageInfo, (ReImageInfo.getLabelNum()+ 1), label[j]);
                                if (m.size() != 0)
                                {
                                    System.out.println("产生了推送");
                                    isBronPush=true;
                                    //即在标签树上找到了标签设置图片信息表的信息
                                    setObjValueUtil.setAttributeValueFromObj("Flag", ReImageInfo, (ReImageInfo.getLabelNum() + 1), 1 + "");
                                    System.out.println("进行录入在标签树上找到的标签，并设定为状态为" + (ReImageInfo.getLabelNum() + 1));
                                    ReImageInfo.setLabelNum(ReImageInfo.getLabelNum()+1);
                                }
                                else
                                {
                                    setObjValueUtil.setAttributeValueFromObj("Flag", ReImageInfo, (ReImageInfo.getLabelNum() + 1), "E");
                                    System.out.println("进行录入没有在标签树上找到的标签，并设定为状态为" + (ReImageInfo.getLabelNum() + 1));
                                    ReImageInfo.setLabelNum(ReImageInfo.getLabelNum()+1);
                                }
                                Map<String, Object> z = labelSimilarity.Duplicateremoval(m);
                                //下面为产生推送数据
                                for (String key : z.keySet())
                                {
                                    if (temp2 <= (z.size() / 2) + 1)
                                    {
                                        System.out.println(key + "---" + z.get(key) + "----");
                                        pushtable push = new pushtable();
                                        push.setImageId(id);
                                        push.setAdminId(imageinf.getAdminId());
                                        push.setImageUrl(imageinf.getImageUrl());
                                        push.setProduceTime(SetNameUtil.getAccurateTime());
                                        //取数据放入到push之中
                                        parent p = (parent) z.get(key);
                                        String[] labelId = p.getLabelNumber().split("-");
                                        System.out.println(labelId.length + "**********" + p.toString());
                                        for (int k = 0; k < labelId.length; k++)
                                        {
                                            switch (k)
                                            {
                                                case 0:
                                                    push.setFirstId(Integer.parseInt(labelId[k]));
                                                    break;
                                                case 1:
                                                    push.setSecondId(Integer.parseInt(labelId[k]));
                                                    break;
                                                case 2:
                                                    push.setThirdId(Integer.parseInt(labelId[k]));
                                                    break;
                                                case 3:
                                                    push.setFourId(Integer.parseInt(labelId[k]));
                                                    break;
                                                case 4:
                                                    push.setFifthId(Integer.parseInt(labelId[k]));
                                                    break;
                                            }
                                        }
                                        push.setProduceName(u.getUserNickName());
                                        push.setProducerId(u.getId());
                                        push.setImageUrl(imageUrl);
                                        System.out.println("产生推送信息" + push.toString());
                                        //写入到推送表之中
                                        // pushpictureservice.savePushtable(push);
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("找到相似的标签，进行去重复，并设定状态");
                                //进行为对应的位置的标签取重，并且修改图片判定表中需要更改的数据，
                                setObjValueUtil.setAttributeValueFromObj("label", ReImageInfo, locate,
                                        labelSimilarity.getSame(label[j], (String) setObjValueUtil.getAttributeValueFromObj("label", ReImageInfo, locate)));
                                System.out.println("取重复完毕" + (String) setObjValueUtil.getAttributeValueFromObj("label", ReImageInfo, locate));
                                if (setObjValueUtil.getAttributeValueFromObj("Flag", ReImageInfo, locate).equals("E"))
                                {
                                    System.out.println("现在判定表欧忠的信息是"+ReImageInfo.toString());
                                    System.out.println("locate"+locate);
                                    //如果标签的状态是E，代表是上一轮中找到的标签，但是在标签树上未找到的标签，这里可以设定为异常状态
                                    setObjValueUtil.setAttributeValueFromObj("Flag", ReImageInfo, locate, 2+"");
                                    System.out.println((String) setObjValueUtil.getAttributeValueFromObj("Flag", ReImageInfo, locate) + "-----------");

                                }
                                else
                                {
                                    setObjValueUtil.setAttributeValueFromObj("Flag", ReImageInfo, locate,
                                            (Integer.parseInt((String) setObjValueUtil.getAttributeValueFromObj("Flag", ReImageInfo, locate)) + 1) + ""
                                    );

                                    System.out.println("进行设置状态完毕" + (String) setObjValueUtil.getAttributeValueFromObj("Flag", ReImageInfo, locate));
                                }
                            }
                        }
                        System.out.println("最终的数据" + ReImageInfo.toString());
                        //    judgelabelservice.saveLabelAtFirst(ReImageInfo);
                        //写入信息到异常表之中
                        if(isHasabnorma)
                        {
                            //产生了异常
                            System.out.println("产生的异常信息是"+abnor.toString());
                            if(!isHasabnormaltable)
                            {
                                abnormalService.saveAbnormalInfo(abnor);
                            }else {
                                abnormalService.ChangeAbnormalInfo(abnor);
                            }
                        }
                    }
                    if(isBronPush)
                    {
                        //产生了推送 修改图片信息表信息并且删除初始库之中数据
                        imageinf.setImageFlag("P");
                        imageinf.setPushTime(SetNameUtil.getAccurateTime());
                        System.out.println("进行修改图片信息表信息为"+imageinf.toString());
                        System.out.println("进行删除初始库之中的信息id为："+id);
                        //       imageInfoService.ChangeImageFlag(imageinf);
                        //  pushpictureservice.deleteInfoFromOriginTable(imageinf.getId());
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < appGroup.getImageNum(); i++)
            {
                //先设定图片的状态为true，如果新标签产生，则改变状态，不进行完成化判断
                boolean state = true;
                //从appGroup之中得到图片的信息
                int id = (Integer) setObjValueUtil.getAttributeValueFromObj("imageId", appGroup, (i + 1));
                System.out.println("当前正在进行判定的图片的id是" + id + "-------------------------------");
                //得到图片的基本信息
                imageInfo imageinf = imageInfoService.getImageInfoFromImageId(id);
                //得到这张图片对应的判定表之中的数据
                judgetable ReImageInfo = judgelabelservice.getJudgeTableInfoByImageId(id);
                System.out.println("进行判定的判定表中的图片的信息" + ReImageInfo.toString());
                ReImageInfo.setUseNum(ReImageInfo.getUseNum() + 1);
                System.out.println("修改本张判定表之中的图片的信息人数+1");
                //从上传的本组信息中得到标签的信息
                String labelTemp = (String) setObjValueUtil.getAttributeValueFromObj("label", appGroup, (i + 1));
                System.out.println("上传的的本图片的标签" + labelTemp);
                //先获取这张图片的异常
                abnormalimage   abnor=abnormalService.getPictureInfoFromAbnormal(imageinf.getId());
                StringBuffer abnortempLabel=new StringBuffer();
                //定义一个状态来记录是否产生了异常
                boolean isHasabnorma=false;
                boolean isHasabnormaltable=true;
                if (!labelTemp.equals(""))
                {
                    String[] label = labelTemp.split("-");
                    System.out.println("上传的标签的数量" + label.length);
                    //获得当前图片的地址
                    String imageUrl = (String) setObjValueUtil.getAttributeValueFromObj("imageUrl", appGroup, (i + 1));
                    System.out.println("图片的地址" + imageUrl);

                    for (int j = 0; j < label.length; j++)
                    {
                        //得到每个标签对应的判定表之中的位置   0即未找到相同的
                        int locate = labelSimilarity.getSimilaryBest(label[j], ReImageInfo);
                        System.out.println("最相似的位置" + locate);

                        if (locate == 0)
                        {
                            if(ReImageInfo.getLabelNum()>=10)
                            {
                                isHasabnorma=true;
                                System.out.println("标签数量超过限制，录取额外的异常表，不再进行判定和生成推送");
                                System.out.println("进行查找异常表看是否存在这张图片的异常");
                                if (abnor==null)
                                {
                                    isHasabnormaltable=false;
                                    abnor=new abnormalimage();
                                    abnor.setImageUrl(imageinf.getImageUrl());
                                    abnor.setJudgetableId(ReImageInfo.getId());
                                    abnor.setAdminId(imageinf.getAdminId());
                                    abnor.setProductTime(GetAllLabelUtil.getAllLabel(ReImageInfo));
                                    abnor.setImageId(imageinf.getId());
                                    abnortempLabel.append(label[j]+"-");
                                    abnor.setLabels(abnortempLabel.toString());
                                }else {
                                    abnortempLabel=new StringBuffer(abnor.getLabels());
                                    abnortempLabel.append(label[j]+"-");
                                    abnor.setLabels(abnortempLabel.toString());
                                }

                            }
                            state = false;//不进行完成化判断
                            //产生新的推送  并且修改图片判定表之中的数据  并且完成化判定标志被设定为false
                            //产生新的推送
                            List<first> firList = labelUtil.searchFirst("%" + label[j] + "%");
                            List<second> sedList = labelUtil.searchSecond("%" + label[j] + "%");
                            List<third> thList = labelUtil.searchThird("%" + label[j] + "%");
                            List<fourth> foList = labelUtil.searchFourth("%" + label[j] + "%");
                            List<fifth> fifList = labelUtil.searchFifth("%" + label[j] + "%");
                            //进行判断得到最大三组推送，最少没有并且这个标签异常  最后在修改判定表中的数据
                            //z中存放的是经过去重之后的数据，然后在包装推送对象 m中是经过筛选的数据
                            List m = labelSimilarity.getBest(firList, sedList, thList, foList, fifList, label[j]);
                            //修改图片判定表中的数据
                            setObjValueUtil.setAttributeValueFromObj("label", ReImageInfo, (ReImageInfo.getLabelNum() + 1), label[j]);
                            if (m.size() != 0)
                            {
                                //即在标签树上找到了标签设置图片信息表的信息
                                setObjValueUtil.setAttributeValueFromObj("Flag", ReImageInfo, (ReImageInfo.getLabelNum() + 1), 1 + "");
                                System.out.println("进行录入在标签树上找到的标签，并设定为状态为" + (ReImageInfo.getLabelNum() + 1));
                                ReImageInfo.setLabelNum(ReImageInfo.getLabelNum()+1);
                            }
                            else
                            {
                                setObjValueUtil.setAttributeValueFromObj("Flag", ReImageInfo, (ReImageInfo.getLabelNum() + 1), "E");
                                System.out.println("进行录入没有在标签树上找到的标签，并设定为状态为" + (ReImageInfo.getLabelNum() + 1));
                                ReImageInfo.setLabelNum(ReImageInfo.getLabelNum()+1);
                            }
                            Map<String, Object> z = labelSimilarity.Duplicateremoval(m);
                            //下面为产生推送数据
                            for (String key : z.keySet())
                            {
                                if (temp2 <= (z.size() / 2) + 1)
                                {
                                    System.out.println(key + "---" + z.get(key) + "----");
                                    pushtable push = new pushtable();
                                    push.setImageId(id);
                                    push.setAdminId(imageinf.getAdminId());
                                    push.setImageUrl(imageinf.getImageUrl());
                                    push.setProduceTime(SetNameUtil.getAccurateTime());
                                    //取数据放入到push之中
                                    parent p = (parent) z.get(key);
                                    String[] labelId = p.getLabelNumber().split("-");
                                    System.out.println(labelId.length + "**********" + p.toString());
                                    for (int k = 0; k < labelId.length; k++)
                                    {
                                        switch (k)
                                        {
                                            case 0:
                                                push.setFirstId(Integer.parseInt(labelId[k]));
                                                break;
                                            case 1:
                                                push.setSecondId(Integer.parseInt(labelId[k]));
                                                break;
                                            case 2:
                                                push.setThirdId(Integer.parseInt(labelId[k]));
                                                break;
                                            case 3:
                                                push.setFourId(Integer.parseInt(labelId[k]));
                                                break;
                                            case 4:
                                                push.setFifthId(Integer.parseInt(labelId[k]));
                                                break;
                                        }
                                    }
                                    push.setProduceName(u.getUserNickName());
                                    push.setProducerId(u.getId());
                                    push.setImageUrl(imageUrl);
                                    System.out.println("产生推送信息" + push.toString());
                                    //写入到推送表之中
                                    //pushpictureservice.savePushtable(push);
                                }
                            }
                        }
                        else
                        {
                            System.out.println("找到相似的标签，进行去重复，并设定状态");

                            //进行为对应的位置的标签取重，并且修改图片判定表中需要更改的数据，
                            setObjValueUtil.setAttributeValueFromObj("label", ReImageInfo, locate,
                                    labelSimilarity.getSame(label[j], (String) setObjValueUtil.getAttributeValueFromObj("label", ReImageInfo, locate)));
                            System.out.println("取重复完毕" + (String) setObjValueUtil.getAttributeValueFromObj("label", ReImageInfo, locate));
                            if (setObjValueUtil.getAttributeValueFromObj("Flag", ReImageInfo, locate).equals("E"))
                            {
                                //如果标签的状态是E，代表是上一轮中找到的标签，但是在标签树上未找到的标签，这里可以设定为异常状态
                                setObjValueUtil.setAttributeValueFromObj("Flag", ReImageInfo, locate, 2);
                                System.out.println((String) setObjValueUtil.getAttributeValueFromObj("Flag", ReImageInfo, locate) + "-----------");
                            }
                            else
                            {
                                setObjValueUtil.setAttributeValueFromObj("Flag", ReImageInfo, locate,
                                        (Integer.parseInt((String) setObjValueUtil.getAttributeValueFromObj("Flag", ReImageInfo, locate)) + 1) + ""
                                );
                                System.out.println("进行设置状态完毕" + (String) setObjValueUtil.getAttributeValueFromObj("Flag", ReImageInfo, locate));
                            }
                        }
                    }
                    System.out.println("最终的数据" + ReImageInfo.toString());
                    //judgelabelservice.ChangeJudgeInfo(ReImageInfo);
                    //写入信息到异常表之中
                    if(isHasabnorma)
                    {
                        //产生了异常
                        System.out.println("产生的异常信息是"+abnor.toString());
                        if(!isHasabnormaltable)
                        {
                            abnormalService.saveAbnormalInfo(abnor);
                        }else {
                            abnormalService.ChangeAbnormalInfo(abnor);
                        }
                    }
                    if (state)
                    {
                        int tempstate = 1;
                        ReImageInfo.setState(tempstate + "");
                        if (ReImageInfo.getState().equals("3"))
                        {
                            System.out.println("进行完成化判断");
                            //如果有三次完整的标签存入的话，这张图片进入完成化阶段 进行完成化处理
                            //封装完成化表
                            FinshPictureModel finishpicture=new FinshPictureModel();
                            finishpicture.setImageId(ReImageInfo.getImageId());
                            finishpicture.setAdminId(imageinf.getAdminId());
                            finishpicture.setImageUrl(imageinf.getImageUrl());
                            finishpicture.setFinishTime(SetNameUtil.getAccurateTime());
                            finishpicture.setImagename(imageinf.getImageUrl().split("/")[imageinf.getImageUrl().split("/").length-1]);
                            finishpicture.setJudgetableId(ReImageInfo.getId());
                            finishpicture.setLabels(GetAllLabelUtil.getAllLabel(ReImageInfo));
                            //写进完成化表之中
                            System.out.println("进行完成化的信息"+finishpicture.toString());
                            //   finishService.savePictureInfo(finishpicture);
                            //改变图片信息表的数据
                            imageinf.setFinishTime(GetAllLabelUtil.getAllLabel(ReImageInfo));
                            imageinf.setImageFlag("F");
                            // imageInfoService.SaveFinishTime(imageinf);
                            //删除推送表中的数据
                            System.out.println("进行删除推送库之中的数据");
                            // pushpictureservice.deleteInfoFromPushTable(imageinf.getId());
                        }
                    }
                }

            }
        }


        return ReturnUtil.success();
    }
}
