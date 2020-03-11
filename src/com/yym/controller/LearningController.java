package com.yym.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	@ResponseBody
	@RequestMapping("/selWords.do")
	public List<UserWords> selWords(String nickName,String bookName,int num,int start,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userTableName=nickName+"_word";
		int count=learningService.getCount(userTableName);
		//����û����ʱ����������ݣ��Ȼ�ȡ����status=0(��ʾ��δѧϰ�ĵ���)
		List<UserWords> list=new ArrayList<UserWords>();
		if(count>0) {
			list=learningService.getWords(userTableName);
			return list;
		}
		return list;
		//      ��ȡ�����������ݿ�ı���
//		String tableName=learningService.selTableName(bookName);
//		List<Words> list=learningService.selWords(tableName,start,(start+num));
//		List<UserWords> words=new ArrayList<UserWords>();
//		UserWords u=new UserWords();
//		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date(System.currentTimeMillis());
//		for(Words w:list) {
//			learningService.insWords("yonney_word", w.getWord(), w.getUs_pron(), w.getUk_pron(), w.getUs_mp3(), w.getUk_mp3(), w.getExplanation(), w.getVal_ex1(), w.getBil_ex1(), w.getVal_ex2(), w.getBil_ex2(), w.getVal_ex3(), w.getBil_ex3(), w.getCollocation(), 0, date);
//		}
//		return list;
	}
	@ResponseBody
	@RequestMapping("/updStatus.do")
	public void updStatus(String nickName,int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userTableName=nickName+"_word";
		int result=learningService.updStatus(userTableName,id);
	}
}
