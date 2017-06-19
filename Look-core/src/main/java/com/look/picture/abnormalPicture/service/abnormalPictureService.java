package com.look.picture.abnormalPicture.service;

import com.look.picture.abnormalPicture.model.abnormalimage;

/**
 * Created by gaohongming on 2017/6/6.
 */
public interface abnormalPictureService {
    abnormalimage getPictureInfoFromAbnormal(int id);

    void saveAbnormalInfo(abnormalimage abnor);

    void ChangeAbnormalInfo(abnormalimage abnor);
}
