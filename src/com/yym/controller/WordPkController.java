package com.yym.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.service.WordPkService;

@Controller
public class WordPkController {
	@Autowired
	private WordPkService wordPkService;
	
	@ResponseBody
	@RequestMapping("/updBankId.do")
	public int updBankId(int uid,int bankId,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=wordPkService.updBankId(bankId, uid);
		return result;
	}
	
}
