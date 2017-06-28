package com.look.Administration.labelutil.dao;

import com.look.Administration.labelutil.model.*;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/17.
 */
@MyBatisScan
@Repository
public interface labelDao {

    List<first> searchFirst(String label);

    List<second> searchSecond(String label);

    List<fifth> searchFifth(String label);

    List<fourth> searchFourth(String label);

    List<third> searchThird(String label);

    first getfirstInfo(int id);

    second getsecondInfo(int id);

    third getThirdInfo(int id);

    fourth getFourthInfo(int id);

    fifth getFifthInfo(int id);

    first getfirstByLabelName(String s);

    List<first> getfirstAllInfo();
}
