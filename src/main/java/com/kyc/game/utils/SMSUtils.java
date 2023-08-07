package com.kyc.game.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.jooq.tools.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class SMSUtils {

    public static void main(String[] args) {
        System.out.println(sendMessage("15189787609"));
    }

    private static final DecimalFormat df = new DecimalFormat("000000");

    public static int sendMessage(String phoneNumber) {
        /*String accessKeyId = AliyunOssConfig.ACCESS_KEY_ID;
        String accessKeySecret = AliyunOssConfig.ACCESS_KEY_SECRET;*/

        String accessKeyId = "LTAI5tG3NnvvoBN5z1XicKxT";
        String accessKeySecret = "TBLBHvjjDEb4grzYqwAZ1jTZ1Y0ncN";

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        // 构建请求：
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        // 自定义参数：
        request.putQueryParameter("PhoneNumbers", phoneNumber);// 手机号
        request.putQueryParameter("SignName", "gmzzkyc");// 短信签名
        request.putQueryParameter("TemplateCode", "SMS_462006376");// 短信模版CODE
        // 构建短信验证码 必须和模板保持一致
        Map<String, Object> map = new HashMap<>();
        int code = Integer.parseInt(df.format(Math.random() * 100000));
        map.put("code", code);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return code;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


}
