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
		String session_key=jsonObject.getString("session_key");
		
		System.out.println("openid:"+openid);
		System.out.println("session_key:"+session_key);
		
		//����ֵ��΢��С����
		response.setCharacterEncoding("UTF-8");
        Writer out = response.getWriter();
        //out.write("�����̨��"+json);
        
        out.write(jsonObject.toString());
        out.flush();
	}
}
