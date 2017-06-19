package com.look.picture.pushPicture.service;

import com.look.picture.pushPicture.model.*;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/28.
 */
public interface pushPiceturService {
    void saveOriginPicrureInfo(originPushtable originpush);
    void savePushtable(pushtable push);
    List<mostclassification>  getMostClassifcation();
    List<pushtable> getSixPictureLimitSecondId(int secondId);

    List<pushtable> getHobbyPushByFirstId(int id);
    List<originPushtable> getOriginPush();

    List<mostFirstLabel> getFirstMax();

    List<pushtable> getSecondByFirstLabelId(int firstId);


    void deleteInfoFromOriginTable(int id);

    void deleteInfoFromPushTable(int id);

    List<mostFirstId> getMostFirstId();

    originPushtable getoriginPushById(int id);

    pushtable getPushInfoByImageId(int id);
}
