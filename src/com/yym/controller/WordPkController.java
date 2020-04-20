package com.yym.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.PKWords;
import com.yym.entity.Player;
import com.yym.entity.Words;
import com.yym.service.WordPkService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class WordPkController {
	@Autowired
	private WordPkService wordPkService;
	
	@ResponseBody
	@RequestMapping("/updBank.do")
	public int updBankId(int uid,String bank,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=wordPkService.updBank(bank, uid);
		return result;
	}
	//判断表是否存在
	public boolean selTable(String table_name,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String str=wordPkService.selTable(table_name);
		if(str!=null) {
			return true;
		}else {
			return false;
		}
	}

	public int createUserErrorBook(String table_name,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=wordPkService.createUserErrorBook(table_name);
		return result;
	}
	@ResponseBody
	@RequestMapping("/insPkWords.do")
	public void insErrorBook(String nickName,String pkwords,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String table_name=nickName+"_eBook";
		boolean flag=this.selTable(table_name, request, response);//判断表是否存在
		if(flag==false) {//如果不存在，则创建表
			this.createUserErrorBook(table_name, request, response);
		}
		JSONArray array=JSONArray.fromObject(pkwords);
		List<PKWords> list = (List<PKWords>)JSONArray.toCollection(array, PKWords.class);
		System.out.println(list);		
		Date dates=new Date(System.currentTimeMillis());
		for(int i=0;i<list.size();i++) {
			PKWords pk=list.get(i);
			wordPkService.insErrorWord(table_name,pk.getWord(), pk.getUs_pron(), pk.getUs_mp3(), 
					pk.getExplanation(), dates);
		}
	}
	
}
