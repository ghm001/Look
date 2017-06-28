package com.look.app.BrowsePicture.service;

import com.look.app.BrowsePicture.dao.BrowsePictureDao;
import com.look.app.BrowsePicture.model.FirstLabelGroup;
import com.look.picture.FinishPicture.model.FinshPictureModel;
import com.look.picture.pushPicture.model.mostFirstLabel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/5/30.
 */
@Service
public class BrowsePictureServiceImpl implements BrowsePictureService {
    @Resource
    BrowsePictureDao   browsePictureDao;
    @Override
    public List<FinshPictureModel> getPictureForRandom() {
        return browsePictureDao.getPictureForRandom();
    }

    @Override
    public List<FirstLabelGroup> getMostFirst() {
        return browsePictureDao.getMostFirst();
    }

    @Override
    public List<FinshPictureModel> getPictureFromId(int id) {
        return browsePictureDao.getPictureFromId(id);
    }

    @Override
    public List<FinshPictureModel> getAll() {
        return browsePictureDao.getAll();
    }
}
