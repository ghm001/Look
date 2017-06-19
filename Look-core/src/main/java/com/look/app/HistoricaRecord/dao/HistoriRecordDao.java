package com.look.app.HistoricaRecord.dao;

import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/30.
 */
@MyBatisScan
@Repository
public interface HistoriRecordDao {
    List<appImageGrouping> getUserHistory(int id);

    void deleteHistoryById(int id);


}
