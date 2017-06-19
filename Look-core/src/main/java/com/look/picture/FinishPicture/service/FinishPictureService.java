package com.look.picture.FinishPicture.service;

import com.look.picture.FinishPicture.model.FinshPictureModel;

import java.util.List;

/**
 * Created by gaohongming on 2017/6/6.
 */
public interface FinishPictureService {
    void savePictureInfo(FinshPictureModel finishpicture);

    void ChangeImageInfo(FinshPictureModel f);

    List<FinshPictureModel> getAllPicture();

    void changeUrl(FinshPictureModel q);
}
