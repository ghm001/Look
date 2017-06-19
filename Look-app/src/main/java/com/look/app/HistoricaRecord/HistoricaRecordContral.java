package com.look.app.HistoricaRecord;

import com.look.app.HistoricaRecord.service.HistoricaRecordService;
import com.look.picture.pushPicture.model.appImageGrouping;
import com.look.utils.JsonUtil;
import com.look.utils.SetNameUtil;
import com.look.utils.nameUtil.SetNameUtilService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by gaohongming on 2017/5/30.
 */
@Controller
public class HistoricaRecordContral {
    @Resource
    HistoricaRecordService   historyService;

    /*
    发送用户的记录数据
     */
    @ResponseBody
    @RequestMapping(value="/look/app/GetUserHistory",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String GetUserHistory(HttpServletRequest request)
    {
        System.out.println("用户"+"进行请求历史记录");
        int id=Integer.parseInt(request.getParameter("userId"));
        System.out.println("用户"+id+"进行请求历史记录");
        List<appImageGrouping> list=historyService.getUserHistory(id);
        SetNameUtilService.ChangeTimeStyle(list);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("TAG","历史记录");
        map.put("picture",list);
        return JsonUtil.mapJson(map);

    }
    /*
    删除某条历史记录
     */
    @ResponseBody
    @RequestMapping(value="/look/app/DeleteUserHistoryById",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String DeleteUserHistoryById(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("id"));
        historyService.deleteHistoryById(id);
        return null;
    }



    /*
    统计用户的总的完成次数  已完成  未完成   总共
     */
    @ResponseBody
    @RequestMapping(value="/look/app/GetUserTaskInfo",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String GetUserTaskInfo(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("userId"));
        List<appImageGrouping> list=historyService.getUserHistory(id);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("ALL",list.size());
        int temp1=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getFlag().equals("S"))
            {
                temp1++;
            }
        }
        map.put("Finish",list.size()-temp1);
        map.put("Save",temp1);
        return JsonUtil.mapJson(map);

    }


    /*
    最近七天的完成的次数
     */
    @ResponseBody
    @RequestMapping(value="/look/app/SevenDaysHistory",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String SevenDaysHistory(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("userId"));
        List<appImageGrouping> list2=new ArrayList<appImageGrouping>();
        Map<Integer,appImageGrouping> map=new IdentityHashMap();
        List<appImageGrouping> list=historyService.getUserHistory(id);
        String time= SetNameUtilService.getDay();
        String[]b=time.split("-");
        StringBuffer dayTemp=new StringBuffer();
        for (int i = 0; i <b.length; i++) {
            dayTemp.append(b[i]);
        }
        int day=Integer.parseInt(dayTemp.toString());
        for (int i = 0; i <list.size() ; i++) {
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
        }  SetNameUtilService.ChangeTimeStyle(list2);

        return JsonUtil.listJson(list2);
    }


    /*
    每天完成的次数  根据id来获取用户记录
     */
    @ResponseBody
    @RequestMapping(value="/look/app/GetUserFinishByDayNum",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/plain;charset=UTF-8")
    public String GetUserFinishByDayNum(HttpServletRequest request)
    {
        int id=Integer.parseInt(request.getParameter("userId"));
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
        return JsonUtil.mapJson(map);
    }



}
