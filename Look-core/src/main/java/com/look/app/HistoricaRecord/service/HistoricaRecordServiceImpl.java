package com.look.app.HistoricaRecord.service;

import com.look.app.HistoricaRecord.dao.HistoriRecordDao;
import com.look.picture.pushPicture.model.appImageGrouping;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/5/30.
 */
@Service
public class HistoricaRecordServiceImpl implements HistoricaRecordService {
    @Resource
    HistoriRecordDao hisoryrecorddao;

    @Override
    public List<appImageGrouping> getUserHistory(int id) {
        return hisoryrecorddao.getUserHistory(id);
    }

    @Override
    public void deleteHistoryById(int id) {
        hisoryrecorddao.deleteHistoryById(id);
    }
}
