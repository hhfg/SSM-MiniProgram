package com.yym.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.PersonalData;
import com.yym.entity.SignRecord;
import com.yym.entity.User;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;
import com.yym.service.UserService;
import com.yym.util.DecodeUserUtil;
import com.yym.util.GetOpenIdUtil;
import com.yym.util.GetSpecifiedDay;

import net.sf.json.JSONObject;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	public String login(String code,String nickName,String avatarUrl,int gender,String province,String city,
			String profileUrl,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DecodeUserUtil decode=new DecodeUserUtil();
        String openid=decode.decodeUser(code);
        User u=userService.selUser(openid);
        if(u!=null) {
        	return "redirect:/selPersonalData.do?nickName="+nickName;
        }
        else {
            User user=new User();
            user.setOpenid(openid);
            user.setNickName(nickName);
            user.setAvatarUrl(avatarUrl);
            user.setGender(gender);
            user.setProvince(province);
            user.setCity(city);
            //�����û� 
            int result=userService.insUser(user);
            return "redirect:/createUserWordTable.do?nickName="+nickName;
        }
	}
	//�����û����ʱ�
	@RequestMapping("/createUserWordTable.do")
	public String createUserWordTable(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=userService.createUserWordTable(nickName+"_word");
		return "redirect:/getUserIdByName.do?nickName="+nickName;
	}
	//ͨ��nickName��ѯid
	@RequestMapping("/getUserIdByName.do")
	public String getUserId(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int id=userService.getUserIdByName(nickName);
		return "redirect:/insPersonalData.do?id="+id;
	}
    //personal_data���������û���Ϣ 
	@ResponseBody
	@RequestMapping("/insPersonalData.do")
	public int insPersonalData(int id,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		int clockInDay=0;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date startUseDate=new Date(System.currentTimeMillis());
		int result=userService.insPersonalData(id,clockInDay,startUseDate);
		return result;
	}
	public SignRecord ifTheDayBeforSign(int uid) throws ParseException {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date todayDate=new Date(System.currentTimeMillis());
		String specifiedDay=formatter.format(todayDate);
		GetSpecifiedDay getSpecifiedDay=new GetSpecifiedDay();
		String d=getSpecifiedDay.getSpecifiedDayBefore(specifiedDay);
		Date sign_date=formatter.parse(d);
		SignRecord s=userService.selSignRecord(uid, sign_date);
		return s;
	}
	@ResponseBody
	@RequestMapping("/selPersonalData.do")
	public PersonalData selPersonalData(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, ParseException {
		int uid=userService.getUserIdByName(nickName);
		String table_name=nickName+"_word";
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date dates=new Date(System.currentTimeMillis());
		PersonalData p=userService.selPersonalData(uid);
		PersonalData p1=new PersonalData();				
		int haveToReview;
		int haveToLearn;
		//�鿴�����Ƿ��Ѵ�
		SignRecord todaySign=userService.selTodaySign(uid, dates);
		//��������Ѵ�
		if(todaySign!=null) {
			return p;
		}
		else {
			//�鿴ǰһ���Ƿ��д�
			SignRecord s=ifTheDayBeforSign(uid);
			//���û�еĻ�
			if(s==null) {
				//���û����л�ȡstatus=0�ĵ���
				List<UserWords> userWords=userService.selNotLearned(table_name);
				//������Ȳ�Ϊ0��˵������δѧϰ�ĵ���
				if(userWords.size()!=0) {
					haveToLearn=userWords.size();
					haveToReview=userService.selReviewCount(table_name, dates, p.getBookid());
				}
				//�����ʾ��һ�����Ѿ����꿨�� ��ûѧϰ��
				else {
					//ͨ���û�ѡ���bookid��ѯ��Ӧ�ĵ�����ı���
					String table=userService.selTableName(p.getBookid());
					List<Words> list=userService.selWords(table, p.getLastWordId()+1, p.getDayNum()+p.getLastWordId());
					for(Words w:list) {
						userService.insWords(table_name, w.getWord(), w.getUs_pron(), w.getUk_pron(), w.getUs_mp3(), w.getUk_mp3(), w.getExplanation(), w.getVal_ex1(), w.getBil_ex1(), w.getVal_ex2(), w.getBil_ex2(), w.getVal_ex3(), w.getBil_ex3(), w.getCollocation(),0, dates, p.getBookid());
					}
				}
			}else {//���ǰһ���д�
				//�鿴�û����ʱ����Ƿ��н���ĵ���
				int count=userService.selCountToday(table_name, dates,p.getBookid());
				//���û�У���ʾ���ջ�δ��ʼѧϰ������Ҫѧϰ�ĵ��ʼ��뵽�û����ʱ���
				if(count==0&&p.getEndTime()!=null) {
					//ͨ���û�ѡ���bookid��ѯ��Ӧ�ĵ�����ı���
					String table=userService.selTableName(p.getBookid());
					List<Words> list=userService.selWords(table, p.getLastWordId()+1, p.getDayNum()+p.getLastWordId());
					for(Words w:list) {
						userService.insWords(table_name, w.getWord(), w.getUs_pron(), w.getUk_pron(), w.getUs_mp3(), w.getUk_mp3(), w.getExplanation(), w.getVal_ex1(), w.getBil_ex1(), w.getVal_ex2(), w.getBil_ex2(), w.getVal_ex3(), w.getBil_ex3(), w.getCollocation(),0, dates, p.getBookid());
					}	
				}else {
					
				}
			}
			
			Date endDate=p.getEndTime();
			long learningDay=(endDate.getTime()-dates.getTime())/(60*60*24*1000);
			//��ȡ������Ҫѧϰ�͸�ϰ�ĵ�����
			haveToReview=userService.selReviewCount(table_name, dates,p.getBookid());
			haveToLearn=userService.selLearningCount(table_name, dates,p.getBookid());
			p1.setHaveToLearn(haveToLearn);
			p1.setHaveToReview(haveToReview);
			p1.setUid(uid);
			p1.setCompletedNum(p.getCompletedNum());
			p1.setLastWordId(p.getLastWordId());
			p1.setLearningDay((int)learningDay);
			p1.setContinue_sign(p.getContinue_sign());
			int result=userService.updPersonalData(p1);
			p=userService.selPersonalData(uid);
			return p;
		}
	}
	
	@ResponseBody
	@RequestMapping("/setMyBook.do")
	public int setMyBook(String nickName,int bookid,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");          
        response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST"); 
        int uid=userService.getUserIdByName(nickName);
        PersonalData p=new PersonalData();
        p.setBookid(bookid);
        p.setUid(uid);
        p.setLastWordId(0);
        p.setCompletedNum(0);
        int result=userService.updPersonalData(p);
		return result;
	}

	@ResponseBody
	@RequestMapping("/updLearningPlan.do")
	public int updPersonalData(String nickName,int dayNum,String endTime,int learningDay,int bookid,int lastWordId,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
		int uid=userService.getUserIdByName(nickName);
		String userTableName=nickName+"_word";
		PersonalData p=new PersonalData();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date=formatter.parse(endTime);
		//��ȡ��������
		Date todayDate = new Date(System.currentTimeMillis());
		String today=formatter.format(todayDate);
		Date startTime=formatter.parse(today);
		int haveToLearn=dayNum;
		p.setDayNum(dayNum);                 //�ƶ��ļƻ���ÿ����Ҫѧϰ�ĵ�����
		p.setLearningDay(learningDay);       //Ԥ��ѧϰ����
		p.setUid(uid);          
		p.setEndTime(date);                  //�ƻ���ʼ������
		p.setStartTime(startTime);           //�ƻ�����������
		p.setHaveToLearn(haveToLearn);       //һ���ƻ��ã����µ�����Ҫѧϰ�ĵ�����
		int result=userService.updPersonalData(p);
		return result;
	}

	@RequestMapping("/insSignRecord.do")
	public String insSignRecord(String nickName,String date,int learned_num,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ParseException {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date sign_date=formatter.parse(date);
		int uid=userService.getUserIdByName(nickName);
		SignRecord beforeDay=ifTheDayBeforSign(uid);
		System.out.println(beforeDay);
		SignRecord s=new SignRecord();
		PersonalData user=userService.selPersonalData(uid);
		PersonalData p=new PersonalData();
		if(beforeDay==null) {
			s.setContinue_sign(1);
			p.setContinue_sign(1);
		
		}else {
			s.setContinue_sign(beforeDay.getContinue_sign()+1);
			p.setContinue_sign(beforeDay.getContinue_sign()+1);
		}
		s.setUid(uid);
		s.setSign_date(sign_date);
		s.setLearned_num(learned_num);
		userService.insSignRecord(s);
		p.setUid(uid);
		p.setCompletedNum(user.getCompletedNum());
		p.setHaveToLearn(user.getHaveToLearn());
		p.setHaveToReview(user.getHaveToReview());
		p.setLastWordId(user.getLastWordId());
		userService.updPersonalData(p);
		return "redirect:/updateClock.do?nickName="+nickName;
	}
	@ResponseBody
	@RequestMapping("/updateClock.do")
	public int updateClock(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int uid=userService.getUserIdByName(nickName);
		PersonalData user=userService.selPersonalData(uid);
		PersonalData p=new PersonalData();
		int completedNum=user.getCompletedNum()+user.getDayNum();
		int lastWordId=user.getLastWordId()+user.getDayNum();
		p.setUid(uid);
		p.setClockInDay(user.getClockInDay()+1);
		p.setHaveToLearn(0);
		p.setHaveToReview(0);
		p.setCompletedNum(completedNum);
		p.setLastWordId(lastWordId);
		int result=userService.updPersonalData(p);
		return result;		
	}
}
