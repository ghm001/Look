package com.look.Administration.upimage.service;

import com.look.Administration.upimage.dao.upimageDao;
import com.look.Administration.upimage.model.imageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/5/25.
 */
@Service
public class upimageServiceImpl implements upimageService {
    @Resource
    upimageDao  upimagedao;

    //保存图片的信息
    @Override
    public void saveImageInfo(imageInfo image) {
        upimagedao.saveImageInfo(image);
    }
    //删除图片的信息
    @Override
    public void deleteImageInfo(int id) {
        upimagedao.deleteImageInfo(id);
    }
   //改变图片的状态
    @Override
    public void ChangeImageFlag(imageInfo imageinfo) {
        upimagedao.ChangeImageFlag(imageinfo);
    }
   //根据id获取图片对应的详细信息
    @Override
    public imageInfo getImageInfoFromImageId(int id) {
        return upimagedao.getImageInfoFromImageId(id);
    }
    //保存完成化时间
    @Override
    public void SaveFinishTime(imageInfo imageinf) {
        upimagedao.SaveFinishTime(imageinf);
    }

    //得到所有的图片信息表之中的信息
    @Override
    public List<imageInfo> getallImageInfo() {
        return upimagedao.getallImageInfo();
    }
}
