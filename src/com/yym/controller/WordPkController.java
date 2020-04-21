package com.yym.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.ErrorWords;
import com.yym.entity.PKWords;
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
	@RequestMapping("/insErrorWords.do")
	public void insErrorBook(String nickName,String pkwords,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String table_name=nickName+"_eBook";
		boolean flag=this.selTable(table_name, request, response);//判断表是否存在
		if(flag==false) {//如果不存在，则创建表
			this.createUserErrorBook(table_name, request, response);
		}
		JSONArray array=JSONArray.fromObject(pkwords);
		List<PKWords> list = (List<PKWords>)JSONArray.toCollection(array, PKWords.class);
		Date dates=new Date(System.currentTimeMillis());
		for(int i=0;i<list.size();i++) {
			PKWords pk=list.get(i);
			wordPkService.insErrorWord(table_name,pk.getWord(), pk.getUs_pron(), pk.getUs_mp3(), 
					pk.getExplanation(), dates);
		}
	}
	@ResponseBody
	@RequestMapping("/selErrorWords.do")
	public Map<String,List<ErrorWords>> selErrorWords(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String table_name=nickName+"_eBook";
		List<ErrorWords> list=wordPkService.selErrorWords(table_name);
		Map<String,List<ErrorWords>> words=new TreeMap<String,List<ErrorWords>>(new Comparator<String>() {
			public int compare(String str1,String str2) {
				return str2.compareTo(str1);
			}
		});
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		for(ErrorWords e:list) {
			String date=formatter.format(e.getDates());//转换成字符串
			List<ErrorWords> word=new ArrayList<ErrorWords>();
			word.add(e);
			if(words.get(date)!=null) {                //如果key已经存在，则加入到其value值中
				List<ErrorWords> w=words.get(date);
				w.add(e);
				words.put(date, w);
			}else {                                    //否则直接加入到map中
				words.put(date, word);
			}
		}
		return words;
	}

}
