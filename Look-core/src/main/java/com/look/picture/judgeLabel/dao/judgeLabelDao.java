package com.look.picture.judgeLabel.dao;

import com.look.picture.judgeLabel.model.judgetable;
import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.utils.annotation.MyBatisScan;

import javax.annotation.Resource;

/**
 * Created by gaohongming on 2017/5/25.
 */
@MyBatisScan
@Resource
public interface judgeLabelDao {
    void saveLabelAtFirst(judgetable ju);

    void saveUserUpImageInfo(appImageGrouping appGroup);

    judgetable getJudgeTableInfoByImageId(int id);

    void ChangeUserUpImageInfo(appImageGrouping appGroup);

    void ChangeJudgeInfo(judgetable reImageInfo);
}
