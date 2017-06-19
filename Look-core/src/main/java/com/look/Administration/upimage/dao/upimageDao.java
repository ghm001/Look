package com.look.Administration.upimage.dao;

import com.look.Administration.upimage.model.imageInfo;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/25.
 */
@MyBatisScan
@Repository
public interface upimageDao {
    void saveImageInfo(imageInfo image);

    void deleteImageInfo(int id);

    void ChangeImageFlag(imageInfo imageinfo);

    imageInfo getImageInfoFromImageId(int id);

    void SaveFinishTime(imageInfo imageinf);

    List<imageInfo> getallImageInfo();
}
