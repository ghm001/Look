package com.look.app.BrowsePicture.service;

import com.look.app.BrowsePicture.model.FirstLabelGroup;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.mostFirstLabel;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/30.
 */
public interface BrowsePictureService {
    List<FinshPictureModel> getPictureForRandom();

    List<FirstLabelGroup> getMostFirst();

    List<FinshPictureModel> getPictureFromId(int id);

    List<FinshPictureModel> getAll();
}
