package com.yym.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;


//@Controller
public class CopyOfWxLoginAction {
	//小程序appid
	public static final String appid="wx4fb94ff26fc9d776";
	//微信服务器会话验证
	public static final String access_token_url="https://api.weixin.qq.com/sns/jscode2session";
	//授权类型
	public static final String grant_type="authorization_code";
	//小程序密钥
	public static final String app_secret="5ff26279f39b973c97afbd8853dfb28c";


//	@RequestMapping("/decodeUser.do")
//	@ResponseBody
	public static Map<String,Object> login(String code) throws Exception{
	
		if(code==null||code.equals("")) {
			throw new Exception("小程序登录凭证不能为空");
		}
		//返回结果
		Map<String,Object> ret=new HashMap<String,Object>();
		Map<String,String> params=new HashMap<String,String>();
		params.put("grant_type", grant_type);
		params.put("appid",appid);
		params.put("secret",app_secret);
		params.put("js_code", code);
		//调用获取access_token接口
		String result=httpPost(access_token_url,params);
		System.out.println(result);
		//根据请求结果判定，是否验证成功
		JSONObject obj=JSONObject.fromObject(result);
		if(obj!=null) {
			Object errCode=obj.get("errcode");
			if(errCode!=null) {
				throw new Exception("errCode:"+errCode);
			}else {
				Object session_key=obj.get("session_key");//会话密钥
				Object openid=obj.get("openid");//唯一标识
				ret.put("session_key", session_key);
				ret.put("openid", openid);
			}
		}	
		return ret;
	}
	public static String httpGet(String url) {
		DefaultHttpClient httpclient=new DefaultHttpClient();
		String body=null;
		HttpGet get=new HttpGet(url);
		body=invoke(httpclient,get);
		httpclient.getConnectionManager().shutdown();
		return body;
	}
	public static String httpPost(String url,Map<String,String> params) {
		System.out.println("httpPost:"+params+"url:"+url);
		DefaultHttpClient httpclient=new DefaultHttpClient();
		String body=null;
		HttpPost post=postForm(url,params);
		body=invoke(httpclient,post);
		httpclient.getConnectionManager();
		return body;
	}
	private static HttpPost postForm(String url,Map<String,String>params) {
		HttpPost httppost=new HttpPost();
		System.out.println(httppost);
		List<NameValuePair> nvps=new ArrayList<NameValuePair>();
		for(String key:params.keySet()) {
			if(key!=null) {
				nvps.add(new BasicNameValuePair(key,params.get(key)));
			}		
		}
		try {
			httppost.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return httppost;
	}
	
	private static String invoke(DefaultHttpClient httpclient,HttpUriRequest httppost) {
		HttpResponse response=sendRequest(httpclient,httppost);
		String body=parseResponse(response);
		return body;
	}
	private static HttpResponse sendRequest(DefaultHttpClient httpclient,HttpUriRequest httppost) {
		HttpResponse response=null;
		try {
			response=httpclient.execute(httppost);
			System.out.println(response);
		}catch(ClientProtocolException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	private static String parseResponse(HttpResponse response) {
		HttpEntity entity=response.getEntity();
		String charset=EntityUtils.getContentCharSet(entity);
		charset=StringUtils.isEmpty(charset)?"utf-8":charset;
		String body=null;
		try {
			body=EntityUtils.toString(entity,charset);
		}catch(ParseException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return body;
	}
}
