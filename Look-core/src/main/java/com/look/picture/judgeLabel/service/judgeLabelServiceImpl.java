package com.look.picture.judgeLabel.service;

import com.look.picture.judgeLabel.dao.judgeLabelDao;
import com.look.picture.judgeLabel.model.judgetable;
import com.look.picture.pushPicture.model.appImageGrouping;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gaohongming on 2017/5/25.
 */
@Service
public class judgeLabelServiceImpl implements judgeLabelService {
    @Resource
    judgeLabelDao  judgelabeldao;

    //保存图片信息到判定表之中
    @Override
    public void saveLabelAtFirst(judgetable ju) {
        judgelabeldao.saveLabelAtFirst(ju);
    }

    //保存用户上传图片信息到记录表之中
    @Override
    public void saveUserUpImageInfo(appImageGrouping appGroup) {
        judgelabeldao.saveUserUpImageInfo(appGroup);
    }

    //根据id来获取图片的信息
    @Override
    public judgetable getJudgeTableInfoByImageId(int id) {
        return judgelabeldao.getJudgeTableInfoByImageId(id);
    }

    //服务于用户再次在历史记录中进行的保存或者提交操作
    @Override
    public void ChangeUserUpImageInfo(appImageGrouping appGroup) {
        judgelabeldao.ChangeUserUpImageInfo(appGroup);
    }

    //改变判定表之中的信息
    @Override
    public void ChangeJudgeInfo(judgetable reImageInfo) {
        judgelabeldao.ChangeJudgeInfo(reImageInfo);
    }
}
