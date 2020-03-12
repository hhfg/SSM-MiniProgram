package com.yym.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yym.entity.ChooseWords;
import com.yym.entity.UserWords;
import com.yym.entity.Words;
import com.yym.service.LearningService;

@Controller
@SessionAttributes("userTableName")
public class LearningController {
	@Autowired
	private LearningService learningService;
	@ResponseBody
	@RequestMapping("/selWords.do")
	public List<UserWords> selWords(String nickName,String bookName,int num,int start,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userTableName=nickName+"_word";
		//获取用户单词表中记录的个数
		int count=learningService.getCount(userTableName);				
		List<UserWords> list=new ArrayList<UserWords>();
		//如果有记录
		if(count>0) {
			//如果用户单词表中已有数据，先获取表中status=0(表示还未学习的单词)
			list=learningService.getWords(userTableName,0);
			return list;
		}
		//如果没有，表示用户是第一次学习，先从单词书表中获取数据
		else {
			//获取单词书在数据库的表名
			String tableName=learningService.selTableName(bookName);
			//从单词书中获取数据
			List<Words> words=learningService.selWords(tableName, start, (start+num));
			//获取今天的日期
			Date date = new Date(System.currentTimeMillis());
			//将从单词书表中获取的单词加入到用户单词表中
			for(Words w:words) {
				learningService.insWords(userTableName, w.getWord(), w.getUs_pron(), w.getUk_pron(), w.getUs_mp3(), w.getUk_mp3(), w.getExplanation(), w.getVal_ex1(), w.getBil_ex1(), w.getVal_ex2(), w.getBil_ex2(), w.getVal_ex3(), w.getBil_ex3(), w.getCollocation(), 0, date);
			}
			list=learningService.getWords(userTableName,0);
			return list;
		}

	}
	@ResponseBody
	@RequestMapping("/updStatus.do")
	public void updStatus(String nickName,int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userTableName=nickName+"_word";
		int result=learningService.updStatus(userTableName,id);
	}
	@ResponseBody
	@RequestMapping("/selReviewWords.do")
	public Set<ChooseWords> selReviewWords(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userTableName=nickName+"_word";
		Set<ChooseWords> words=new HashSet<ChooseWords>();
		List<UserWords> list=new ArrayList<UserWords>();
		list=learningService.getWords(userTableName,0);
		int index=0;
		for(UserWords u:list) {
			ChooseWords c=new ChooseWords();
			c.setId(index);
			c.setWord(u.getWord());
			c.setPron(u.getUs_pron());
			c.setPron_mp3(u.getUs_mp3());
			c.setCorrectEx(u.getExplanation());
			Set<String> s=learningService.selExplanation();
			s.add(u.getExplanation());
			c.setExplanation(s);
			words.add(c);
			index++;
		}
		return words;
	}
}
