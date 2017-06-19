package com.look.picture.judgeLabel.service;

import com.look.picture.judgeLabel.model.judgetable;
import com.look.picture.pushPicture.model.appImageGrouping;

/**
 * Created by gaohongming on 2017/5/25.
 */
public interface judgeLabelService {
    void saveLabelAtFirst(judgetable ju);

    void saveUserUpImageInfo(appImageGrouping appGroup);

    judgetable getJudgeTableInfoByImageId(int id);

    void ChangeUserUpImageInfo(appImageGrouping appGroup);

    void ChangeJudgeInfo(judgetable reImageInfo);
}
