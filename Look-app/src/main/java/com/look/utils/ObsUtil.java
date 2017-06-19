package com.look.utils;

import com.huawei.obs.services.ObsClient;
import com.huawei.obs.services.ObsConfiguration;
import com.huawei.obs.services.exception.ObsException;
import com.huawei.obs.services.model.*;

import java.io.*;


/**
 * Created by gaohongming on 2017/4/18.
 */
public class ObsUtil {

    public static ObsClient obsClient = null;
    public static ObsConfiguration config;
    static final String endPoint = "obs.cn-north-1.myhwclouds.com"; //存储服务器地址
    static final int httpsPort = 80; //HTTPS请求对应的端口
    static   final String ak = "OCHPDTEZSMK4E28CVQF8"; //接入证书
    static final String sk = "xdoLs0fgxRtrSuBsltwt0rDmHwuencfSboaWNSB7"; //安全证书
    private static AccessControlList acl;
    static Owner own;
    private static CanonicalGrantee canonicalGrant1;
    private static GroupGrantee groupGrant;
    static {
        try {
            acl = new AccessControlList();
            own=new Owner();
            own.setId("36c7fe4af6dd40fcab61a5708899c8b2");
            own.setDisplayName("mikebest");
            acl.setOwner(own);
            canonicalGrant1 = new CanonicalGrantee("36c7fe4af6dd40fcab61a5708899c8b2");
            canonicalGrant1.setDisplayName("mikebest");
            acl.grantPermission(canonicalGrant1, Permission.PERMISSION_FULL_CONTROL);
            groupGrant= new GroupGrantee(
                    "http://acs.amazonaws.com/groups/global/AllUsers");
            acl.grantPermission(groupGrant, Permission.PERMISSION_READ);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void ConnectionObs()
    {
        config = new ObsConfiguration();
        config.setSocketTimeout(2000000);//设置socket超时时间
        config.setEndPoint(endPoint);
        config.setHttpsOnly(false);
        config.setEndpointHttpsPort(httpsPort);
        config.setDisableDnsBucket(true);
        config.setSignatString("v4");//V4鉴权
        config.setDefaultBucketLocation("DC1");
    }
    public static String putImage(String imagename,String bucketName,InputStream file) {
        ObsUtil.ConnectionObs();
        try {
            obsClient = new ObsClient(ak, sk, config);
            ObjectMetadata metadata = new ObjectMetadata();// 设置上传对象的元数据
            try {
                metadata.setContentLength((long) file.available());// 设置头信息中的文件长度
                System.out.println("文件大小"+(long)file.available());
            } catch (IOException e) {
                e.printStackTrace();
            }
            metadata.setContentType("image/jpeg");// 设置上传的文件类型
            PutObjectRequest request = new PutObjectRequest();
            request.setBucketName(bucketName);
            request.setInput(file);
            request.setMetadata(metadata);
            request.setObjectKey(imagename);
            PutObjectResult result = obsClient.putObject(request);
            System.out.println("Put object success. Object etag: " + result.getEtag());
        } catch (ObsException e) {
            System.out.println("Failed to reate object. Error message: " + e.getErrorMessage() + " ResponseCode: "
                    + e.getResponseCode());
            return "error";
        }
        String url=ObsUtil.changeObjALC(imagename,bucketName);
        return url;
    }

     public static String changeObjALC(String imagename,String bucketName)
     {
             own=new Owner();
            try {
                System.out.println("进行请求");
                obsClient.setObjectAcl(bucketName, imagename, null, acl, null);
                return "http://obs.myhwclouds.com/"+bucketName+"/"+imagename;
            } catch (ObsException e) {
                System.out.println("Error message: " + e.getErrorMessage() + " ResponseCode: " + e.getResponseCode()
                        + " ResponseStatus: " + e.getErrorCode());
            }
            return ReturnUtil.error();
        }

}



