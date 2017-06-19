package com.look.picture.pushPicture.dao;

import com.look.picture.pushPicture.model.*;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/28.
 */
@MyBatisScan
@Repository
public interface pushPictureDao {
    void saveOriginPicrureInfo(originPushtable originpush);

    void savePushtable(pushtable push);

    List<mostclassification> getMostClassifcation();

    List<pushtable> getSixPictureLimitSecondId(int secondId);

    List<pushtable> getHobbyPushByFirstId(int id);

    List<originPushtable> getOriginPush();

    List<mostFirstLabel> getFirstMax();

    List<pushtable> getSecondByFirstLabelId(int firstId);

    void deleteInfoFromOriginTable(int id);

    void deleteInfoFromPushTable(int id);

    List<mostFirstId> getMostFirstId();

    originPushtable getOrifinPushById(int id);

    pushtable getPushInfoByImageId(int id);
}
