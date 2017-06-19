package com.look.Administration.pictureInfoContral.dao;

import com.look.Administration.pictureInfoContral.model.test;
import com.look.Administration.upimage.model.imageInfo;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.originPushtable;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/29.
 */
@MyBatisScan
@Repository
public interface pictureInfoDao {
    List<test> gettest();

    List<originPushtable> getoriginPicture();

    List<FinshPictureModel> getFinishtable();

    List<imageInfo> getCanPushPicture();
}
