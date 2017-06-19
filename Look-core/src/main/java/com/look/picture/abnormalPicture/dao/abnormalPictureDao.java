package com.look.picture.abnormalPicture.dao;

import com.look.picture.abnormalPicture.model.abnormalimage;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by gaohongming on 2017/6/6.
 */
@MyBatisScan
@Repository
public interface abnormalPictureDao {
    abnormalimage getPictureInfoFromAbnormal(int id);

    void saveAbnormalInfo(abnormalimage abnor);

    void ChangeAbnormalInfo(abnormalimage abnor);
}
