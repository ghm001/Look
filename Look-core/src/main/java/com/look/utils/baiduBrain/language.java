package com.look.utils.baiduBrain;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gaohongming on 2017/5/26.
 */
public class language {
    //设置APPID/AK/SK
    public static final String APP_ID = "9668762";
    public static final String API_KEY = "4aK0xyIWxWyCuVjBSlGfMX85";
    public static final String SECRET_KEY = "PRqyVNgURmPirvk5YnjYxaBZzG5Zq50G";
    public static AipNlp client= new AipNlp(APP_ID, API_KEY, SECRET_KEY);

    public static void main(String[] args) {
        test();
    }
  public static void conn()
  {
      client.setConnectionTimeoutInMillis(2000);
      client.setSocketTimeoutInMillis(60000);
  }

  public static double Similarity(String labelJudge,String upLabel)
  {
      conn();
      JSONObject response = client.simnet(labelJudge,upLabel);
      String sm="0";
      try {
          sm=response.getJSONObject("output").getString("score");
          System.out.println("相似度："+sm);
      } catch (JSONException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      return Double.valueOf(sm);

  }
    public static double test() {
        JSONObject response = client.simnet("电脑", "哈哈哈电脑桌子");
        System.out.println(response.toString());
        String sm="0";
        try {
            sm=response.getJSONObject("output").getString("score");
            System.out.println("相似度："+sm);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Double.valueOf(sm);
    }
}
