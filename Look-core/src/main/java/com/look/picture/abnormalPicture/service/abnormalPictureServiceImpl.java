package com.look.picture.abnormalPicture.service;

import com.look.picture.abnormalPicture.dao.abnormalPictureDao;
import com.look.picture.abnormalPicture.model.abnormalimage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gaohongming on 2017/6/6.
 */
@Service
public class abnormalPictureServiceImpl implements abnormalPictureService {
    @Resource
    abnormalPictureDao  abnormalpicturedao;

    @Override
    public abnormalimage getPictureInfoFromAbnormal(int id) {
        return abnormalpicturedao.getPictureInfoFromAbnormal(id);
    }

    @Override
    public void saveAbnormalInfo(abnormalimage abnor) {
        abnormalpicturedao.saveAbnormalInfo(abnor);

    }

    @Override
    public void ChangeAbnormalInfo(abnormalimage abnor) {
        abnormalpicturedao.ChangeAbnormalInfo(abnor);
    }
}
