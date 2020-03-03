package com.yym.controller;



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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.util.GetOpenIdUtil;

import net.sf.json.JSONObject;
@Controller
public class DecodeUserController {
	@RequestMapping("/decodeUsers.do")
	@ResponseBody
	public void decodeUser(String code,HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");     
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
		String session_key=jsonObject.getString("session_key");
		
		System.out.println("openid:"+openid);
		System.out.println("session_key:"+session_key);
		
		//返回值给微信小程序
		response.setCharacterEncoding("UTF-8");
        Writer out = response.getWriter();
        //out.write("进入后台了"+json);
        
        out.write(jsonObject.toString());
        out.flush();
	}
}
