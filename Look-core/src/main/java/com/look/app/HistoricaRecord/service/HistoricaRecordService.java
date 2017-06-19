package com.look.app.HistoricaRecord.service;

import com.look.picture.pushPicture.model.appImageGrouping;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/30.
 */
public interface HistoricaRecordService {
    List<appImageGrouping> getUserHistory(int id);

    void deleteHistoryById(int id);
}
