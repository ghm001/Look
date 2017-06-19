package com.look.app.Integral.dao;

import com.look.app.Integral.model.IntegralHistory;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/6/4.
 */
@MyBatisScan
@Repository
public interface IntegralDao {
    void saveOneRecord(IntegralHistory intehral);

    void UserIntegrareduce(IntegralHistory in);

    List<IntegralHistory> getUserIntegraHistory(int id);

    List<IntegralHistory> getAllHistory();
}
