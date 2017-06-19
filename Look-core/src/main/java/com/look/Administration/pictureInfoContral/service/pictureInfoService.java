package com.look.Administration.pictureInfoContral.service;

import com.look.Administration.pictureInfoContral.model.test;
import com.look.Administration.upimage.model.imageInfo;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.originPushtable;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/29.
 */
public interface pictureInfoService {
    List<test> gettest();

    List<originPushtable> getoriginPicture();

    List<FinshPictureModel> getFinishtable();

    List<imageInfo> getCanPushPicture();
}
