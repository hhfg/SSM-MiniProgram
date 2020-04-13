package com.yym.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.Player;
import com.yym.service.WordPkService;

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
	
	@ResponseBody
	@RequestMapping("/getPlayerData.do")
	public Player getPlayerData(int uid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Player p=wordPkService.selPlayer(uid);
		return p;
	}
	
}
