package com.look.app.BrowsePicture.dao;

import com.look.app.BrowsePicture.model.FirstLabelGroup;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.mostFirstLabel;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/30.
 */
@MyBatisScan
@Repository
public interface BrowsePictureDao {
    List<FinshPictureModel> getPictureForRandom();

    List<FirstLabelGroup> getMostFirst();

    List<FinshPictureModel> getPictureFromId(int id);

    List<FinshPictureModel> getAll();
}
