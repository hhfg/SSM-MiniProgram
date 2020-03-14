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
	@ResponseBody
	@RequestMapping("/selWords.do")
	public List<UserWords> selWords(String nickName,String bookName,int num,int start,int bookid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userTableName=nickName+"_word";
		//��ȡ�û����ʱ��м�¼�ĸ���
		/*
		 * int count=learningService.getCount(userTableName); List<UserWords> list=new
		 * ArrayList<UserWords>(); //����м�¼ if(count>0) {
		 * //����û����ʱ����������ݣ��Ȼ�ȡ����status=0(��ʾ��δѧϰ�ĵ���)
		 * list=learningService.getWords(userTableName,0); return list; }
		 * //���û�У���ʾ�û��ǵ�һ��ѧϰ���ȴӵ�������л�ȡ���� else { //��ȡ�����������ݿ�ı��� String
		 * tableName=learningService.selTableName(bookName); //�ӵ������л�ȡ���� List<Words>
		 * words=learningService.selWords(tableName, start, (start+num)); //��ȡ��������� Date
		 * date = new Date(System.currentTimeMillis()); //���ӵ�������л�ȡ�ĵ��ʼ��뵽�û����ʱ���
		 * for(Words w:words) { learningService.insWords(userTableName, w.getWord(),
		 * w.getUs_pron(), w.getUk_pron(), w.getUs_mp3(), w.getUk_mp3(),
		 * w.getExplanation(), w.getVal_ex1(), w.getBil_ex1(), w.getVal_ex2(),
		 * w.getBil_ex2(), w.getVal_ex3(), w.getBil_ex3(), w.getCollocation(), 0,
		 * date,bookid); } list=learningService.getWords(userTableName,0); return list;
		 * }
		 */
		//���û����ʱ��ȡstatus=0�ļ�¼
		List<UserWords> list=learningService.getWords(userTableName, 0);
		//���listΪ�գ�˵���ǵ���ĵ�һ��ѧϰ���ȴӵ�������л�ȡ����
		if(list==null) {
			//�Ȼ�ȡѡ���������Ӧ�ĵ��������
			String tableName=learningService.selTableName(bookName);
			List<Words> words=learningService.selWords(userTableName, start, start+num);
		}else {
			//����ֱ�ӷ��ز�ѯ����list
			return list;
		}
		return list;
	}
	@ResponseBody
	@RequestMapping("/updStatus.do")
	public void updStatus(String nickName,int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userTableName=nickName+"_word";
		int result=learningService.updStatus(userTableName,id);
	}
	@ResponseBody
	@RequestMapping("/selReviewWords.do")
	public List<UserWords> selReviewWords(String nickName,int review,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String userTableName=nickName+"_word";
		Set<ChooseWords> words=new HashSet<ChooseWords>();
		List<UserWords> list=new ArrayList<UserWords>();
		Date dates = new Date(System.currentTimeMillis());
		if(review==0) {
			list=learningService.selReview(userTableName, dates);
		}
		else{
			//��ȡ��Ҫ��ϰ�ĵ���
			list=learningService.selPractise(userTableName, dates);
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
