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

import com.yym.entity.PersonalData;
import com.yym.entity.UserWords;
import com.yym.entity.Words;
import com.yym.service.LearningService;

@Controller
@SessionAttributes("userTableName")
public class LearningController {
	@Autowired
	private LearningService learningService;
	//�Ƿ���Ҫ��ϰ
	@ResponseBody
	@RequestMapping("/selReview.do")
	public List<UserWords> ifReview(String nickName,int bookid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userTableName=nickName+"_word";
		//��ȡ���������
		Date dates = new Date(System.currentTimeMillis());
		List<UserWords> list=learningService.selReview(userTableName, dates);
		//System.out.println(list);
		return list;
	}
	/*
	 * ��ȡ��Ҫѧϰ�ĵ���
	 */
	@ResponseBody
	@RequestMapping("/selLearningWords.do")
	public List<UserWords> selWords(String nickName,int num,int start,int bookid,int uid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userTableName=nickName+"_word";
		//���û����ʱ��ȡstatus=0�ļ�¼
		List<UserWords> list=learningService.getWords(userTableName, 0, bookid);
		//���listΪ�գ�˵�������Ѵ򿨹����ȴӵ�������л�ȡ����
		if(list.size()==0) {
			//�Ȼ�ȡѡ���������Ӧ�ĵ��������
			String tableName=learningService.selTableName(bookid);
			List<Words> words=learningService.selWords(tableName, start+1, start+num);
			Date dates=new Date(System.currentTimeMillis());
			//�����ʴ����û����ʱ���
			for(Words w:words) {
				learningService.insWords(userTableName, w.getWord(), w.getUs_pron(), w.getUk_pron(), w.getUs_mp3(), w.getUk_mp3(), w.getExplanation(), w.getVal_ex1(), w.getBil_ex1(), w.getVal_ex2(), w.getBil_ex2(), w.getVal_ex3(), w.getBil_ex3(), w.getCollocation(),0, dates, bookid,0);
			}
			int haveToLearn=learningService.selLearning(userTableName, dates, bookid);
			learningService.updLearning(haveToLearn, uid);
			list=learningService.getWords(userTableName, 0, bookid);
			return list;
		}else {
			//����ֱ�ӷ��ز�ѯ����list
			return list;
		}
		//return list;
	}
	/*
	 * ���µ��ʵ�״̬
	 */
	@ResponseBody
	@RequestMapping("/updStatus.do")
	public int updStatus(String nickName,int status,int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userTableName=nickName+"_word";
		int result=learningService.updStatus(userTableName,status,id);
		return result;
	}
	/*
	 * ��ȡ��Ҫ��ϰ�ĵ���
	 */
	@ResponseBody
	@RequestMapping("/selReviewWords.do")
	public List<UserWords> selReviewWords(String nickName,int review,int bookid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userTableName=nickName+"_word";
		List<UserWords> list=new ArrayList<UserWords>();
		System.out.println(bookid);
		Date dates = new Date(System.currentTimeMillis());
		if(review==0) {
			list=learningService.selReview(userTableName, dates);
		}
		else{
			//��ȡ��Ҫ��ϰ�ĵ���
			list=learningService.selPractise(userTableName,bookid);
		}
		int index=0;
		for(UserWords u:list) {
			Set<String> explanation=learningService.selExplanation();
			Set<String> word=learningService.selRanWord();
			explanation.add(u.getExplanation());
			word.add(u.getWord());
			u.setChoose(explanation);
			u.setChooseEn(word);
		}
		return list;
	}
	/*
	 * ���������Ƿ��ղ�
	 */
	@ResponseBody
	@RequestMapping("/setCollect.do")
	public int setCollect(String nickName,int collect,int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String table_name=nickName+"_word";
		int result=learningService.setCollect(table_name, collect, id);
		return result;
	}

}
