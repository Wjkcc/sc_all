package com.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration;

public class Test01
{
    public static void main(String[] args)
    {
        String payDetailJosn = "";
        String json = "[{\"AP_AMT\":96,\"discount\":\"1.0\"},{\"MGB_AMT\":4,\"discount\":\"1.0\"}]";
        try {
            String string = com.alibaba.fastjson.JSONObject.parseArray(json).getString(1);
            com.alibaba.fastjson.JSONObject j1 = com.alibaba.fastjson.JSONObject.parseObject(string);
            String a = null;
            a.toString();
            String mgjf_amt = j1.get("MGJF_AMT").toString();
            payDetailJosn = mgjf_amt;
        } catch (Exception e) {
            e.printStackTrace();
        }
//        JSONObject jsonObject = new JSONObject();
//        String b = jsonObject.getString("a");
////        System.out.println(a);
//        String a = "";
//        a=b;
    }
}
