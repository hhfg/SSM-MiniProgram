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

        //小程序appid
        String appid = "wx4fb94ff26fc9d776";
        //小程序密钥
        String secret = "5ff26279f39b973c97afbd8853dfb28c";
		GetOpenIdUtil getopenid=new GetOpenIdUtil();
		//调用访问微信服务器工具方法，传入三个参数获取带有openid、session_key的json字符串
		String jsonId=getopenid.getopenid(appid,code,secret);
		JSONObject jsonObject = JSONObject.fromObject(jsonId); 
		//从json字符串获取openid和session_key
		String openid=jsonObject.getString("openid");
		return openid;
	}
}
