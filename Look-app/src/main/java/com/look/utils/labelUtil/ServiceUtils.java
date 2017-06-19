package com.look.utils.labelUtil;

import com.look.Administration.labelutil.service.labelserviceImpl;
import com.look.Administration.upimage.service.upimageServiceImpl;
import com.look.picture.judgeLabel.service.judgeLabelServiceImpl;
import com.look.picture.pushPicture.service.pushPictureServiceImpl;
import com.look.utils.springContextUtil.SpringContextUtil;

/**
 * Created by gaohongming on 2017/5/25.
 */
public class ServiceUtils {

    /*
    得到labelserviceImpl在非Contral进行使用
     */
    public static labelserviceImpl getLabelServiceImpl()
    {
        labelserviceImpl laService = (labelserviceImpl) SpringContextUtil.getBean("labelserviceImpl");
        return laService;
    }
    /*
    得到judgeLabelServiceImpl   在非Contral之中进行使用
     */
    public   static judgeLabelServiceImpl getjudgeLabelServiceImpl()
    {
        judgeLabelServiceImpl judgeLabelService=(judgeLabelServiceImpl)SpringContextUtil.getBean("judgeLabelServiceImpl");
        return judgeLabelService;
    }
    /*
    得到pushPictureServiceImpl
     */
    public static pushPictureServiceImpl  getpushPictureServiceImpl()
    {
        pushPictureServiceImpl   pushPictureService=(pushPictureServiceImpl)SpringContextUtil.getBean("pushPictureServiceImpl");
        return  pushPictureService;
    }

    public static upimageServiceImpl getupImageService() {
        upimageServiceImpl   upPictureService=(upimageServiceImpl)SpringContextUtil.getBean("upimageServiceImpl");
        return  upPictureService;
    }
}
