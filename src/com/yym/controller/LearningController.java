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
		/* ������Ӧͷ����ajax������� */  
		response.setHeader("Access-Control-Allow-Origin", "*");  
		/* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
		response.setHeader("Access-Control-Allow-Methods", "GET,POST"); 
//        ��ȡ�����������ݿ�ı���
		String tableName=learningService.selTableName(bookName);
		List<Words> list=learningService.selWords(tableName,1,3);
		return list;
		
	}
	
}
