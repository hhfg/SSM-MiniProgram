package com.yym.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
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

import com.yym.entity.UserWords;
import com.yym.entity.Words;
import com.yym.service.LearningService;

@Controller
@SessionAttributes("userTableName")
public class LearningController {
	@Autowired
	private LearningService learningService;
	//是否需要复习
	@ResponseBody
	@RequestMapping("/selReview.do")
	public List<UserWords> ifReview(String nickName,int bookid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userTableName=nickName+"_word";
		//获取今天的日期
		Date dates = new Date(System.currentTimeMillis());
		List<UserWords> list=learningService.selReview(userTableName, dates,bookid);
		//System.out.println(list);
		return list;
	}
	@ResponseBody
	@RequestMapping("/selLearningWords.do")
	public List<UserWords> selWords(String nickName,int num,int start,int bookid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userTableName=nickName+"_word";
		//从用户单词表获取status=0的记录
		List<UserWords> list=learningService.getWords(userTableName, 0, bookid);
		//如果list为空，说明是当天的第一次学习，先从单词书表中获取单词
		if(list.size()==0) {
			//先获取选择的书所对应的单词书表名
			String tableName=learningService.selTableName(bookid);
			List<Words> words=learningService.selWords(tableName, start+1, start+num);
			Date dates=new Date(System.currentTimeMillis());
			//将单词存入用户单词表中
			for(Words w:words) {
				learningService.insWords(userTableName, w.getWid(), w.getWord(), w.getUs_pron(), w.getUk_pron(), w.getUs_mp3(), w.getUk_mp3(), w.getExplanation(), w.getVal_ex1(), w.getBil_ex1(), w.getVal_ex2(), w.getBil_ex2(), w.getVal_ex3(), w.getBil_ex3(), w.getCollocation(),0, dates, bookid);
			}
			list=learningService.getWords(userTableName, 0, bookid);
			return list;
		}else {
			//否则直接返回查询到的list
			return list;
		}
		//return list;
	}
	@ResponseBody
	@RequestMapping("/updStatus.do")
	public int updStatus(String nickName,int status,int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userTableName=nickName+"_word";
		int result=learningService.updStatus(userTableName,status,id);
		return result;
	}
	@ResponseBody
	@RequestMapping("/selReviewWords.do")
	public List<UserWords> selReviewWords(String nickName,int review,int bookid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userTableName=nickName+"_word";
		List<UserWords> list=new ArrayList<UserWords>();
		System.out.println(bookid);
		Date dates = new Date(System.currentTimeMillis());
		if(review==0) {
			list=learningService.selReview(userTableName, dates,bookid);
		}
		else{
			//获取需要练习的单词
			list=learningService.selPractise(userTableName,bookid);
			System.out.println(list);
		}
		int index=0;
		for(UserWords u:list) {
			Set<String> s=learningService.selExplanation();
			s.add(u.getExplanation());
			u.setChoose(s);
		}
		return list;
	}

}
