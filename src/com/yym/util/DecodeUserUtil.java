package com.yym.util;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



import net.sf.json.JSONObject;

public class DecodeUserUtil {

	public String decodeUser(String code){

        //С����appid
        String appid = "wx4fb94ff26fc9d776";
        //С������Կ
        String secret = "5ff26279f39b973c97afbd8853dfb28c";
		GetOpenIdUtil getopenid=new GetOpenIdUtil();
		//���÷���΢�ŷ��������߷�������������������ȡ����openid��session_key��json�ַ���
		String jsonId=getopenid.getopenid(appid,code,secret);
		JSONObject jsonObject = JSONObject.fromObject(jsonId); 
		//��json�ַ�����ȡopenid��session_key
		String openid=jsonObject.getString("openid");
		return openid;
	}
}
