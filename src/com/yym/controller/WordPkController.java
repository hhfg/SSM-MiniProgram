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

@Controller
public class WordPkController {
	@Autowired
	private WordPkService wordPkService;
	
	@ResponseBody
	@RequestMapping("/updBank.do")
	public int updBankId(int uid,String bank,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println(uid+":"+bank);
		int result=wordPkService.updBank(bank, uid);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/getPlayerData.do")
	public Player getPlayerData(int uid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Player p=wordPkService.selPlayer(uid);
		return p;
	}
	@ResponseBody
	@RequestMapping("/selPKWords.do")
	public List<PKWords> selPKWords(int uid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Player p=wordPkService.selPlayer(uid);
		String table_name="";
		if(p.getBank()=="高中题库") {
			table_name="highword";
		}else if(p.getBank()=="四级题库") {
			table_name="cet4word";
		}else if(p.getBank()=="六级题库") {
			table_name="cet6word";
		}else {
			table_name="postgraduateword";
		}
		List<PKWords> words=new ArrayList<PKWords>();
		List<Words> list=wordPkService.selPKWords(table_name);
		int index=0;
		for(Words w:list) {
			PKWords pk=new PKWords();
			pk.setId(index);
			pk.setWord(w.getWord());
			pk.setUs_pron(w.getUs_pron());
			pk.setUs_mp3(w.getUs_mp3());
			pk.setExplanation(w.getExplanation());
			Set<String> s=wordPkService.selChoose(table_name);
			s.add(w.getExplanation());
			pk.setChoose(s);
			words.add(pk);
			index++;
		}
		System.out.println(words);
		return words; 
	}
	
}
