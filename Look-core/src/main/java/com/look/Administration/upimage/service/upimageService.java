package com.look.Administration.upimage.service;

import com.look.Administration.upimage.model.imageInfo;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/25.
 */
public interface upimageService {
    void saveImageInfo(imageInfo image);

    void deleteImageInfo(int id);

    void ChangeImageFlag(imageInfo imageinfo);

    imageInfo getImageInfoFromImageId(int id);

    void SaveFinishTime(imageInfo imageinf);

    List<imageInfo> getallImageInfo();
}
