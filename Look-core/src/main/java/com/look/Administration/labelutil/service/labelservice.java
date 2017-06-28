package com.look.Administration.labelutil.service;

import com.look.Administration.labelutil.model.*;

import java.util.List;

/**
 * Created by gaohongming on 2017/5/17.
 */
public interface labelservice {

    List<first> searchFirst(String label);
    List<second> searchSecond(String label);
    List<third> searchThird(String label);
    List<fourth> searchFourth(String label);
    List<fifth> searchFifth(String label);
    void getBestSimilary(String label);

    first  getfirstInfo(int id);
    second getsecondInfo(int id);
    third getThirdInfo(int id);
    fourth getFourthInfo(int id);
    fifth  getFifthInfo(int id);

    first getfirstByLabelName(String s);

    List<first> getfirstAllInfo();
}
