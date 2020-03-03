package com.yym.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
 
/**
 *
 */
public class GetOpenIdUtil {
	
	 public String getopenid(String appid,String code,String secret) {  
	        BufferedReader in = null;  
	        //appid��secret�ǿ����߷ֱ���С����ID��С������Կ��������ͨ��΢�Ź���ƽ̨-������-���������þͿ���ֱ�ӻ�ȡ��
	        String url="https://api.weixin.qq.com/sns/jscode2session?appid="
	        +appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
	        try {  
				URL weChatUrl = new URL(url);  
	            // �򿪺�URL֮�������  
	            URLConnection connection = weChatUrl.openConnection();  
	            // ����ͨ�õ���������  
	            connection.setConnectTimeout(5000);  
	            connection.setReadTimeout(5000);  
	            // ����ʵ�ʵ�����  
	            connection.connect();  
	            // ���� BufferedReader����������ȡURL����Ӧ  
	            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
	            StringBuffer sb = new StringBuffer();  
	            String line;  
	            while ((line = in.readLine()) != null) {  
	                sb.append(line);  
	            }  
	            return sb.toString();  
	        } catch (Exception e1) {  
	        	throw new RuntimeException(e1);
	        }  
	        // ʹ��finally�����ر�������  
	        finally {  
	            try {  
	                if (in != null) {  
	                    in.close();  
	                }  
	            } catch (Exception e2) {  
	                e2.printStackTrace();  
	            }  
	        }  
	    }  
}