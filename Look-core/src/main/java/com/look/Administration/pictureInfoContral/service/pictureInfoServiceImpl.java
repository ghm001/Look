package com.look.Administration.pictureInfoContral.service;

import com.look.Administration.pictureInfoContral.dao.pictureInfoDao;
import com.look.Administration.pictureInfoContral.model.test;
import com.look.Administration.upimage.model.imageInfo;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.originPushtable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/5/29.
 */
@Service
public class pictureInfoServiceImpl implements pictureInfoService {
    @Resource
    pictureInfoDao pictureinfodao;

    @Override
    public List<test> gettest() {
      List<test> t=pictureinfodao.gettest();
        return t;
    }

    @Override
    public List<originPushtable> getoriginPicture() {
        return pictureinfodao.getoriginPicture();
    }

    @Override
    public List<FinshPictureModel> getFinishtable() {
        return pictureinfodao.getFinishtable();
    }

    @Override
    public List<imageInfo> getCanPushPicture() {
        return pictureinfodao.getCanPushPicture();
    }
}
