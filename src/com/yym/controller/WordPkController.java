package com.yym.controller;

import java.io.IOException;
import java.util.ArrayList;
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
	//≈–∂œ±Ì «∑Ò¥Ê‘⁄
	@ResponseBody
	@RequestMapping("/selTable.do")
	public boolean selTable(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String table_name=nickName+"_eBook";
		String str=wordPkService.selTable(table_name);
		if(str!=null) {
			return true;
		}else {
			return false;
		}
	}
	@ResponseBody
	@RequestMapping("/createUserErrorBook.do")
	public int createUserErrorBook(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println(nickName);
		String table_name=nickName+"_eBook";
		int result=wordPkService.createUserErrorBook(table_name);
		return result;
	}
	@ResponseBody
	@RequestMapping("/insPkWords.do")
	public void insErrorBook(String nickName,String pkwords,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		JSONArray array=JSONArray.fromObject(pkwords);
		System.out.println(array);
	}
	
}
