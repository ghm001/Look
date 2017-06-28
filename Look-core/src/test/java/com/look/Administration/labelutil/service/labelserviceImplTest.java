package com.look.Administration.labelutil.service;

import com.look.Administration.labelutil.model.*;
import com.look.utils.JsonUtil;
import com.look.utils.Similaritydegree.labelSimilarity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class labelserviceImplTest {
    @Resource
    labelservice labelsearcher;
    @Test
    public void searchFirst() throws Exception {
        long startTime=System.currentTimeMillis();   //获取开始时间
        //这里开始模拟contral的功能
        /*
        直接从二级标签开始遍历，当找到有相似的之后，将这些相似的三级标签找出，如果找到三级标签中也有相似的，继续找四级标签，在这所有的标签中
        找到相似度最大的一个标签，产生推送。
         */
        int temp=0;
     List<fourth> fourLabel= labelsearcher.searchFourth("%水果%");
        System.out.println("-----");
      List<fifth>  fifthLabel=  labelsearcher.searchFifth("%水果%");
        System.out.println("----------");
       List<third> thirdLabel= labelsearcher.searchThird("%水果%");
        System.out.println("------------");
       List<first> firstLabel= labelsearcher.searchFirst("%水果%");
        System.out.println("---------");
       List<second> secondLabel= labelsearcher.searchSecond("%水果%");
        System.out.println("-----");
        //得到去重的推送数据
        List m=labelSimilarity.getBest(firstLabel,secondLabel,thirdLabel,fourLabel,fifthLabel,"水果");
        //Map m=labelSimilarityTest
        System.out.println(m.get(0).getClass()+"---"+m.get(0).toString());
        System.out.println(m.get(1).getClass());
        System.out.println(m.get(2).getClass());
        Map<String ,Object> z=labelSimilarity.Duplicateremoval(m);
        System.out.println(z.keySet().toString());

        for(String key:z.keySet())
        {
            if(temp<=(z.size()/2)+1)
            {
                parent p=(parent) z.get(key);
                System.out.println(p.toString()+"什么鬼");
                String[] labe=p.getLabelNumber().split("-");
                System.out.println(labe.length);
                System.out.println(key+"---"+z.get(key)+"----");
                temp++;
            }
        }

        //然后在放到数据库之中
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    @Test
    public void getFirstBylabelName()
    {

    }
    @Test
    public void getFirst()
    {
        List<first> f=labelsearcher.getfirstAllInfo();
        List<String> str=new ArrayList<String>();
        for (int i = 0; i < f.size(); i++) {
            str.add(f.get(i).getLabelOne());
        }
        System.out.println(JsonUtil.listJson(str));
    }

}