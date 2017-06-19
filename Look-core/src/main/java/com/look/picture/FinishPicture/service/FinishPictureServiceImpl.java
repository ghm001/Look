package com.look.picture.FinishPicture.service;

import com.look.picture.FinishPicture.dao.FinishPictureDao;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/6/6.
 */
@Service
public class FinishPictureServiceImpl implements FinishPictureService {
    @Resource
    FinishPictureDao finishpictureDao;

    @Override
    public void savePictureInfo(FinshPictureModel finishpicture) {
        finishpictureDao.saveFinishPictureInfo(finishpicture);
    }
//改变图片的信息
    @Override
    public void ChangeImageInfo(FinshPictureModel f) {
        finishpictureDao.ChangeImageInfo(f);
    }

    @Override
    public List<FinshPictureModel> getAllPicture() {
        return finishpictureDao.getAllPicture();
    }

    @Override
    public void changeUrl(FinshPictureModel q) {
        finishpictureDao.changeUrl(q);
    }
}
