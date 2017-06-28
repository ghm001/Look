package com.look.Administration.labelutil.service;

import com.look.Administration.labelutil.dao.labelDao;
import com.look.Administration.labelutil.model.*;
import com.look.utils.Similaritydegree.labelSimilarity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/5/17.
 */
@Service
public class labelserviceImpl implements labelservice {
    @Resource
    labelDao labeldao;

/**
*@Author Gaohongming
*@Description:这里注意查找到为0的情况
*@return:
*@Data 19:10 2017/5/18
*/




    @Override
    public List<first> searchFirst(String label) {
        System.out.println("进行查找一级标签");
        List<first> list= labeldao.searchFirst(label);
        return list;
    }

    @Override
    public List<second> searchSecond(@Param("label") String label ) {
        System.out.println("进行查找二级标签");
        List<second> list=labeldao.searchSecond(label);
        return list;
    }

    @Override
    public List<third> searchThird(String label) {
        System.out.println("进行查找三级标签");
        List<third> list=labeldao.searchThird(label);
        return list;
    }

    @Override
    public List<fourth> searchFourth(String label) {
        System.out.println("进行查找四级标签");
        List<fourth> list=labeldao.searchFourth(label);
        return list;
    }

    @Override
    public List<fifth> searchFifth(String label ) {
        System.out.println("进行查找五级标签");
        List<fifth> list=labeldao.searchFifth(label);
        return list;
    }

    /*
        查出所有相关的标签，在使用util工具类查找出编辑距离最大的标签
     */
    @Override
    public void getBestSimilary(String label) {
            //先查找一级标签
           List<first> list1=labeldao.searchFirst(label);
        for (int i=0;i<list1.size();i++)
        {
            System.out.println(list1.get(i).toString());
        }
           List<second> list2=labeldao.searchSecond(label);
        for (int i=0;i<list2.size();i++)
        {
            System.out.println(list2.get(i).toString());
        }
            List<third> list3=labeldao.searchThird(label);
        for (int i=0;i<list3.size();i++)
        {
            System.out.println(list3.get(i).toString());
        }
            List<fourth> list4=labeldao.searchFourth(label);
        for (int i=0;i<list4.size();i++)
        {
            System.out.println(list4.get(i).toString());
        }
            List<fifth> list5=labeldao.searchFifth(label);
        for (int i=0;i<list5.size();i++)
        {
            System.out.println(list5.get(i).toString());
        }


    }

    @Override
    public first getfirstInfo(int id) {
        return labeldao.getfirstInfo(id);
    }

    @Override
    public second getsecondInfo(int id) {
        return labeldao.getsecondInfo(id);
    }

    @Override
    public third getThirdInfo(int id) {
        return labeldao.getThirdInfo(id);
    }

    @Override
    public fourth getFourthInfo(int id) {
        return labeldao.getFourthInfo(id);
    }

    @Override
    public fifth getFifthInfo(int id) {
        return labeldao.getFifthInfo(id);
    }

    @Override
    public first getfirstByLabelName(String s) {
        return labeldao.getfirstByLabelName(s);
    }

    @Override
    public List<first> getfirstAllInfo() {
        return labeldao.getfirstAllInfo();
    }


}
