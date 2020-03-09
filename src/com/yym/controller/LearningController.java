package com.yym.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.UserWords;
import com.yym.entity.Words;
import com.yym.service.LearningService;

@Controller
public class LearningController {
	@Autowired
	private LearningService learningService;
	@ResponseBody
	@RequestMapping("/selWords.do")
	public List<Words> selWords(String bookName,int num,int start,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");          
		/* 设置响应头允许ajax跨域访问 */  
		response.setHeader("Access-Control-Allow-Origin", "*");  
		/* 星号表示所有的异域请求都可以接受， */  
		response.setHeader("Access-Control-Allow-Methods", "GET,POST"); 
//        获取单词书在数据库的表名
		System.out.println(num+":"+start);
		String tableName=learningService.selTableName(bookName);
		List<Words> list=learningService.selWords(tableName,start,(start+num));
		List<UserWords> words=new ArrayList<UserWords>();
		UserWords u=new UserWords();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		for(Words w:list) {
			learningService.insWords("yonney_word", w.getWord(), w.getUs_pron(), w.getUk_pron(), w.getUs_mp3(), w.getUk_mp3(), w.getExplanation(), w.getVal_ex1(), w.getBil_ex1(), w.getVal_ex2(), w.getBil_ex2(), w.getVal_ex3(), w.getBil_ex3(), w.getCollocation(), 0, date);
		}
		return list;
		
	}
	
}
