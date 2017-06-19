package com.look.utils.Tenyoutu;


import com.look.utils.jsonUtilforSService.JsonUtilforService;
import com.youtu.Youtu;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohongming on 2017/5/17.
 */
public class youtuUtil {
    public static final String USER_ID = "1176473685";
    public static final String APP_ID = "10082984";
    public static final String SECRET_ID = "AKIDY1TjniA2PjuwmQs6A2iBRYt59GBxP5Vj";
    public static final String SECRET_KEY = "9kNo2743sWxCHE1c5NcliS1OZZP2V6cz";

    public static void main(String[] args) {
       /* try {
            Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT);
            JSONObject respose;
            //respose= faceYoutu.FaceCompareUrl("http://open.youtu.qq.com/content/img/slide-1.jpg","http://open.youtu.qq.com/content/img/slide-1.jpg");
            respose=	faceYoutu.ImageTag("D://唔到千岁/1.jpg");
            //get respose
            System.out.println(respose.toString());
            List list=new ArrayList();
            JSONArray A= respose.getJSONArray("tags");
            System.out.println(A.length());
            String name=A.getJSONObject(0).getString("tag_name");
            String hha=A.getJSONObject(0).getString("tag_confidence");
            System.out.println(A.toString());
            System.out.println(name);
            System.out.println(hha);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        List<youtuBean> list=  getLableFromTenYouTu("https://obs.myhwclouds.com/look.app.share/gaohongming/20170430133517/1.jpg");
        System.out.println(list.size());
        System.out.println("hahahahahaaaaa");
        System.out.println(((youtuBean)list.get(0)).toString());
    }
    public static List<youtuBean> getLableFromTenYouTu(String url)
    {
        List<youtuBean> list=new ArrayList<youtuBean>();
        try {
            Youtu faceYoutu =new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT,USER_ID);
            JSONObject respose;

           // System.out.println(faceYoutu.ImageTagUrl(url).toString());
            respose = faceYoutu.ImageTagUrl(url);
            System.out.println(respose.toString());
            JSONArray A = respose.getJSONArray("tags");
            for (int i=0;i<A.length();i++)
            {
                JSONObject j=A.getJSONObject(i);
                youtuBean y=new youtuBean(j.getString("tag_confidence"),j.getString("tag_name"));
                list.add(y);
            }
            System.out.println(list.size());
        }
             catch (Exception e) {
                e.printStackTrace();
            }
        return list;
    }

}
