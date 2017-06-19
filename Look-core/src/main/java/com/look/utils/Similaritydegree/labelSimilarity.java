package com.look.utils.Similaritydegree;

import com.look.Administration.labelutil.model.*;
import com.look.picture.judgeLabel.model.judgetable;
import com.look.utils.setObjValueUtil;

import java.util.*;


/**
 * Created by gaohongming on 2017/5/17.
 */
public class labelSimilarity {

    /*
        编辑距离算法   返回字符串对应的相似度
     */
    public static double levenshtein(String str1, String str2) {
        // 计算两个字符串的长度。
        int tempnum=0;
        int len1 = str1.length();
        int len2 = str2.length();
        // 建立上面说的数组，比字符长度大一个空间
        int[][] dif = new int[len1 + 1][len2 + 1];
        // 赋初值，步骤B。
        for (int a = 0; a <= len1; a++) {
            dif[a][0] = a;
        }
        for (int a = 0; a <= len2; a++) {
            dif[0][a] = a;
        }
        // 计算两个字符是否一样，计算左上的值
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
               /* System.out.println("i = " + i + " j = " + j + " str1 = "
                        + str1.charAt(i - 1) + " str2 = " + str2.charAt(j - 1));*/
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                tempnum=(dif[i - 1][j - 1] + temp<dif[i][j - 1] + 1)?dif[i - 1][j - 1] + temp:dif[i][j - 1] + 1;
                tempnum=(tempnum<dif[i - 1][j] + 1)?tempnum:dif[i - 1][j] + 1;
                dif[i][j] = tempnum;
              /*  System.out.println("i = " + i + ", j = " + j + ", dif[i][j] = "
                        + dif[i][j]);*/
            }
        }
      //  System.out.println("字符串\"" + str1 + "\"与\"" + str2 + "\"的比较");
        // 取数组右下角的值，同样不同位置代表不同字符串的比较
        //System.out.println("差异步骤：" + dif[len1][len2]);
        // 计算相似度
        float similarity = 1 - (float) dif[len1][len2]
                / Math.max(str1.length(), str2.length());
      //  System.out.println("相似度：" + similarity);
        return similarity;
    }


    /*
    进行标签取重
     */
    public static String getSame(String s1,String s2)
    {
        String s3 = s2;
        int begin = 0;
        int end = s2.length();
        int i = 1;
        while (!s1.contains(s3))
        {
            if (end == s2.length())
            {
                begin = 0;
                end = (s2.length()) - (i++);
            }
            else
            {
                begin++;end++;
            }
            s3 = s2.substring(begin, end);
            System.out.println(s3);
            System.out.println("--------");
        }
        System.out.println("提取的共同的"+"---------------"+s3);
        return s3;
    }
    /*
   这里得到  五组标签的数据，并且返回可以进行推送的，封装到map之中   使用编辑距离算法进行比较
    只为图片的艘次标注进行服务   这里以后再进行改进  暂定为找出相似度最大的三个标签   直接找到二级分类然后进行推送
    找分类的工作交给另一个工具类进行工作
 */
  public static List getBest(List<first> firstList,List<second> secondList,List<third> thirdList,List<fourth> fourtList,List<fifth> fifthList,String label )
  {

      int temp2=0;
       Map<Double,Object> map=new IdentityHashMap();

      List<Double> temp=new ArrayList<Double>();
      List li=new ArrayList();
      //先将所有的数据放到map之中
      System.out.println("-----------一级标签---------");
      for (int i = 0; i <firstList.size() ; i++) {
          temp.add(levenshtein(firstList.get(i).getLabelOne(),label));
          map.put(levenshtein(firstList.get(i).getLabelOne(),label),fifthList.get(i));
          temp2=temp2+1;
          System.out.println(levenshtein(firstList.get(i).getLabelOne(),label)+"--------"+fifthList.get(i).getLabelFifth());
      }
      System.out.println("-----------二级标签---------");
      for (int i = 0; i <secondList.size() ; i++) {
          temp.add(levenshtein(secondList.get(i).getLabelSecond(),label));
          map.put(levenshtein(secondList.get(i).getLabelSecond(),label),secondList.get(i));
          temp2=temp2+1;
          System.out.println(levenshtein(secondList.get(i).getLabelSecond(),label)+"-------"+secondList.get(i).getLabelSecond());
      }
      System.out.println("-----------三级标签---------");
      for (int i = 0; i <thirdList.size() ; i++) {
          temp.add(levenshtein(thirdList.get(i).getLabelThird(),label));
          map.put(levenshtein(thirdList.get(i).getLabelThird(),label),thirdList.get(i));
          temp2=temp2+1;
          System.out.println(levenshtein(thirdList.get(i).getLabelThird(),label)+"-------"+thirdList.get(i).getLabelThird());
      }
      System.out.println("-----------四级标签---------");
      for (int i = 0; i <fourtList.size() ; i++) {
          temp.add(levenshtein(fourtList.get(i).getLabelFourth(),label));
          map.put(levenshtein(fourtList.get(i).getLabelFourth(),label),fourtList.get(i));
          temp2=temp2+1;
          System.out.println(levenshtein(fourtList.get(i).getLabelFourth(),label)+"---------"+fourtList.get(i).getLabelFourth());
      }
      System.out.println("-----------五级标签---------");
      for (int j = 0; j <fifthList.size() ; j++) {
          temp.add(levenshtein(fifthList.get(j).getLabelFifth(),label));
          map.put(levenshtein(fifthList.get(j).getLabelFifth(),label),fifthList.get(j));
          temp2=temp2+1;
          System.out.println(levenshtein(fifthList.get(j).getLabelFifth(),label)+"---------"+fifthList.get(j).getLabelFifth());
      }
      System.out.println("map的长度"+map.size());
      Collections.sort(temp);
      //这时候obj.size-1为最大的三个
      //取出最大的三个，封装
   //   System.out.println(temp.size());
      Set<Double> set = map.keySet();
      Object[] obj = set.toArray();
      Arrays.sort(obj);
      System.out.println(obj.length+"长度");
      for (int i = 0; i <obj.length ; i++) {
          System.out.println(obj[i]);
      }
      if(obj.length>=3) {
          for (int i = obj.length-1; i >obj.length-4; i--) {
              System.out.println(i);
              li.add(map.get(obj[i]));
              System.out.println(map.get(obj[i]).toString()+"相似度"+obj[i]);
          }
          return li;
      }else
      {
          for (int i = 0; i <obj.length ; i++) {
              li.add(map.get(obj[i]));
              System.out.println(map.get(obj[i]));
          }
          return li;
      }
  }

  public static Map Duplicateremoval(List li)
  {
      Map temp=new HashMap();
      String[] number={};
      for(int i=0;i<li.size();i++)
      {
          if(li.get(i).getClass()==first.class)
          {
              first f=(first) li.get(i);
              number=f.getLabelNumber().split("-");
              if (!temp.containsKey(number[1]))
              {
                  temp.put(number[0]+"-"+number[1],li.get(i));

              }
          }
         if(li.get(i).getClass()==second.class)
         {
             second f=(second) li.get(i);
             number=f.getLabelNumber().split("-");
             if (!temp.containsKey(number[1]))
             {
                 temp.put(number[0]+"-"+number[1],li.get(i));

             }
         }
         if(li.get(i).getClass()==third.class)
         {
             third f=(third) li.get(i);
             number=f.getLabelNumber().split("-");
             if (!temp.containsKey(number[1]))
             {
                 temp.put(number[0]+"-"+number[1],li.get(i));
             }
         }
         if(li.get(i).getClass()==fourth.class)
         {
             fourth f=(fourth) li.get(i);
             number=f.getLabelNumber().split("-");
             if (!temp.containsKey(number[1]))
             {
                 temp.put(number[0]+"-"+number[1],li.get(i));

             }
         }
         if(li.get(i).getClass()==fifth.class)
         {
             fifth f=(fifth) li.get(i);
             number=f.getLabelNumber().split("-");
             if (!temp.containsKey(number[1]))
             {
                 temp.put(number[0]+"-"+number[1],li.get(i));

             }
         }
      }
      return temp;
  }


  /*
  为用户标签判定服务的函数     传入一个用户的标签    传入一个当前标签库之中的标签   返回相似的标签位置  ，并且进行取重处理，处理结果放入到传进来的标签库对象之中
   */
  public static int getSimilaryBest(String label, judgetable ju)
  {
      Map<Double,Integer> map=new IdentityHashMap();
      for (int i = 0; i <ju.getLabelNum() ; i++) {
          //进行判定
          StringBuffer b=new StringBuffer("label");
          b.append(i+1);
          map.put(levenshtein((String )setObjValueUtil.getData(ju,b.toString()),label),i+1);
      }
      Set<Double> set = map.keySet();
      //obj中的就是经过排序后的
      Object[] obj = set.toArray();
      Arrays.sort(obj);
      double d=(Double) obj[obj.length-1];
      if(d==0.0)
      {
          return 0;
      }
         else {
             //设置对象中对应的标签的状态
        //  StringBuffer b=new StringBuffer("Flag");
          //b.append(map.get(obj[obj.length-1]));
          //setObjValueUtil.setData(ju,b.toString(),(Integer.parseInt(ju.getFlag1())+1)+"");
             return map.get(obj[obj.length-1]);
      }
  }

    public static void main(String[] args) {

        Map <String ,Double> dataMap=new HashMap<String, Double>();

    }








}
