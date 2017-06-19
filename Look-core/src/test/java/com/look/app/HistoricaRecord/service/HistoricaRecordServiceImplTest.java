package com.look.app.HistoricaRecord.service;

import com.look.app.HistoricaRecord.dao.HistoriRecordDao;
import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.utils.JsonUtil;
import com.look.utils.nameUtil.SetNameUtilService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class HistoricaRecordServiceImplTest {
    @Resource
    HistoriRecordDao historyService;
    @Test
    public void getUserHistory() throws Exception {
        List<appImageGrouping> list=historyService.getUserHistory(17);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    SetNameUtilService.ChangeTimeStyle(list);
        System.out.println(JsonUtil.listJson(list));
    }
    @Test
    public void testGetUserTaskInfo()
    {
        Map<String ,Object> map=new HashMap<String, Object>();
        int id=17;
        List<appImageGrouping> list=historyService.getUserHistory(17);
        int temp1=0;
        map.put("ALL",list.size());
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getFlag().equals("S"))
            {
                temp1++;
            }
        }
        map.put("Finish",list.size()-temp1);
        map.put("Save",temp1);
        System.out.println("总数"+list.size()+"未完成"+temp1+"已完成"+(list.size()-temp1));
        System.out.println(JsonUtil.mapJson(map));
    }

    @Test
    public void TestGetSevdenDaysHistory()
    {
        List<appImageGrouping> list2=new ArrayList<appImageGrouping>();
        Map<Integer,appImageGrouping> map=new IdentityHashMap();
        List<appImageGrouping> list=historyService.getUserHistory(17);
        String time= SetNameUtilService.getDay();
        String[]b=time.split("-");
        StringBuffer dayTemp=new StringBuffer();
        for (int i = 0; i <b.length; i++) {
            dayTemp.append(b[i]);
        }
        int day=Integer.parseInt(dayTemp.toString());
        for (int i = 0; i <list.size() ; i++) {
            //
            String[] a=list.get(i).getSetTime().split("-");
            StringBuffer data=new StringBuffer();
            int temp=0;
            for (int j = 0; j < 3; j++) {
                data.append(a[j]);
            }
            int day2=Integer.parseInt(data.toString());
            if(day-day2<3)
            {
                System.out.println("符合条件"+list.get(i).toString());
                map.put(day2,list.get(i));
            }
        }
        //根据时间进行排序
        Set<Integer> set = map.keySet();
        //obj中的就是经过排序后的
        Object[] obj = set.toArray();
        Arrays.sort(obj);
        for (int i = obj.length-1; i >= 0; i--) {
            list2.add(map.get(obj[i]));
        }
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).toString()+"-------");
        }
        SetNameUtilService.ChangeTimeStyle(list2);
        System.out.println(JsonUtil.listJson(list2));
    }

    @Test
    public void TestGetUserFinishByDayNum()
    {
        int id=Integer.parseInt(17+"");
        List<appImageGrouping> list=historyService.getUserHistory(id);
        Map<String ,Integer> map=new HashMap<String, Integer>();
        String time= SetNameUtilService.getDay();
        String[]b=time.split("-");
        StringBuffer dayTemp=new StringBuffer();
        for (int i = 0; i <b.length; i++) {
            dayTemp.append(b[i]);
        }
        int day=Integer.parseInt(dayTemp.toString());
        for (int i = 0; i < list.size(); i++) {
            String[] a=list.get(i).getSetTime().split("-");
            StringBuffer data=new StringBuffer();
            int temp=0;
            for (int j = 0; j < 3; j++) {
                data.append(a[j]);
            }
            int day2=Integer.parseInt(data.toString());
            if(day-day2<3)
            {
                System.out.println("符合条件"+list.get(i).toString());
                if (map.containsKey(data.toString()))
                {
                    map.put(data.toString(),(map.get(data.toString())+1));
                }else
                {
                    map.put(data.toString(),1);
                }
            }
        }
        for (String s : map.keySet()) {
            System.out.println(s+"----"+map.get(s));
        }
        System.out.println(JsonUtil.mapJson(map));
    }
    @Test
    public void Testdelete()
    {
        historyService.deleteHistoryById(14);
    }

}