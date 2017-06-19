package com.look.app.Integral.service;

import com.look.app.Integral.dao.IntegralDao;
import com.look.app.Integral.model.IntegralHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/6/4.
 */
@Service
public class IntegralServiceImpl implements IntegralService {
    @Resource
    IntegralDao integraldao;

    @Override
    public void saveOneRecord(IntegralHistory intehral) {
        integraldao.saveOneRecord(intehral);
    }

    @Override
    public void UserIntegrareduce(IntegralHistory in) {
        integraldao.UserIntegrareduce(in);
    }

    @Override
    public List<IntegralHistory> getUserIntegraHistory(int id) {
        return integraldao.getUserIntegraHistory(id);
    }

    @Override
    public List<IntegralHistory> getAllHistory() {
        return integraldao.getAllHistory();
    }
}
