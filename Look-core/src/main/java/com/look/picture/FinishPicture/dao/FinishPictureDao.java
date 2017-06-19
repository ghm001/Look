package com.look.picture.FinishPicture.dao;

import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/6/6.
 */
@MyBatisScan
@Repository
public interface FinishPictureDao {
    void saveFinishPictureInfo(FinshPictureModel finishpicture);

    void ChangeImageInfo(FinshPictureModel f);

    List<FinshPictureModel> getAllPicture();

    void changeUrl(FinshPictureModel q);
}
