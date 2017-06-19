package com.look.app.Integral.service;

import com.look.app.Integral.model.IntegralHistory;

import java.util.List;

/**
 * Created by gaohongming on 2017/6/4.
 */
public interface IntegralService {
    void saveOneRecord(IntegralHistory intehral);

    void UserIntegrareduce(IntegralHistory in);

    List<IntegralHistory> getUserIntegraHistory(int id);

    List<IntegralHistory> getAllHistory();
}
