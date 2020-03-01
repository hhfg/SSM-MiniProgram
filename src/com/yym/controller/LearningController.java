package com.yym.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.Words;
import com.yym.service.LearningService;

@Controller
public class LearningController {
	@Autowired
	private LearningService learningService;
	@ResponseBody
	@RequestMapping("/selWords.do")
	public List<Words> selWords(String bookName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");          
		/* 设置响应头允许ajax跨域访问 */  
		response.setHeader("Access-Control-Allow-Origin", "*");  
		/* 星号表示所有的异域请求都可以接受， */  
		response.setHeader("Access-Control-Allow-Methods", "GET,POST"); 
//        获取单词书在数据库的表名
		String tableName=learningService.selTableName(bookName);
		List<Words> list=learningService.selWords(tableName,1,3);
		return list;
		
	}
	
}
