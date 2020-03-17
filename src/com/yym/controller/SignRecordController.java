package com.yym.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.service.SignRecordService;

@Controller
public class SignRecordController {
	@Autowired
	private SignRecordService signRecordService;
	@ResponseBody
	@RequestMapping("/selSignDate.do")
	public List<String> selSignDate(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int uid=signRecordService.selUserId(nickName);
		List<String> signDate=signRecordService.selSignDate(uid);
		return signDate;
	}
	
}
