package com.yym.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.service.LearningRecordService;

@Controller
public class LearningRecordController {
	@Autowired
	private LearningRecordService learningRecordService;
	@ResponseBody
	@RequestMapping("/selCount.do")
	public int selCount(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String table_name=nickName+"_word";
		int count=learningRecordService.selCount(table_name);
		return count;
	}
	
}
