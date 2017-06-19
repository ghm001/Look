package com.look.picture.pushPicture.service;

import com.look.picture.pushPicture.dao.pushPictureDao;
import com.look.picture.pushPicture.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/5/28.
 */
@Service
public class pushPictureServiceImpl implements pushPiceturService {
    @Resource
    pushPictureDao pushdao;

    //图片保存到初始化库之中
    @Override
    public void saveOriginPicrureInfo(originPushtable originpush) {
        pushdao.saveOriginPicrureInfo(originpush);
    }

    //保存推送信息到推送库之中
    @Override
    public void savePushtable(pushtable push) {
        pushdao.savePushtable(push);
    }

    //得到二级分类最多的六个·
    @Override
    public List<mostclassification> getMostClassifcation() {
        return pushdao.getMostClassifcation();
    }

    /**
    *@Author Gaohongming
    *@Description:  得到推送库中的数据，根据传入的二级标签  来获取六个
    *@return:
    *@Data 20:58 2017/5/30
    */
    @Override
    public List<pushtable> getSixPictureLimitSecondId(int secondId) {
        return pushdao.getSixPictureLimitSecondId(secondId);
    }

    //根据兴趣的一级分类进行推送
    @Override
    public List<pushtable> getHobbyPushByFirstId(int id) {
        return pushdao.getHobbyPushByFirstId(id);
    }

    //随机推送初始化库之中的图片
    @Override
    public List<originPushtable> getOriginPush() {
        return pushdao.getOriginPush();
    }
//查找推送库之中一级id最多的排名前三种的
    @Override
    public List<mostFirstLabel> getFirstMax() {
        return pushdao.getFirstMax();
    }
//根据一级标签id来查找符合的二级标签的id，限量30个
    @Override
    public List<pushtable> getSecondByFirstLabelId(int firstId) {
        return pushdao.getSecondByFirstLabelId(firstId);
    }
//删除初始化库之中的信息
    @Override
    public void deleteInfoFromOriginTable(int id) {
        pushdao.deleteInfoFromOriginTable(id);
    }
//删除推送库之中的信息
    @Override
    public void deleteInfoFromPushTable(int id) {
        pushdao.deleteInfoFromPushTable(id);
    }
//得到推送库之中最多的一级id
    @Override
    public List<mostFirstId> getMostFirstId() {
        return pushdao.getMostFirstId();
    }

    @Override
    public originPushtable getoriginPushById(int id) {
        return pushdao.getOrifinPushById(id) ;
    }

    //根据图片的id得到图片在推送库之中的信息
    @Override
    public pushtable getPushInfoByImageId(int id) {
        return pushdao.getPushInfoByImageId(id);
    }


}
