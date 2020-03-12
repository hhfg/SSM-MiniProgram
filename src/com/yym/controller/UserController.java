package com.yym.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.PersonalData;
import com.yym.entity.User;
import com.yym.entity.WordBooks;
import com.yym.service.UserService;
import com.yym.util.DecodeUserUtil;
import com.yym.util.GetOpenIdUtil;

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
            //插入用户 
            int result=userService.insUser(user);
            return "redirect:/createUserWordTable.do?nickName="+nickName;
        }
	}
	@RequestMapping("/createUserWordTable.do")
	public String createUserWordTable(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=userService.createUserWordTable(nickName+"_word");
		return "redirect:/getUserIdByName.do?nickName="+nickName;
	}
	@RequestMapping("/getUserIdByName.do")
	public String getUserId(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int id=userService.getUserIdByName(nickName);
		return "redirect:/insPersonalData.do?id="+id;
	}
	@ResponseBody
	@RequestMapping("/insPersonalData.do")
	public int insPersonalData(int id,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		int clockInDay=1;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date startUseDate=new Date(System.currentTimeMillis());
		int result=userService.insPersonalData(id,clockInDay,startUseDate);
		return result;
	}
	@ResponseBody
	@RequestMapping("/selPersonalData.do")
	public PersonalData selPersonalData(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, ParseException {
		int uid=userService.getUserIdByName(nickName);
		PersonalData p=userService.selPersonalData(uid);
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date todayDate=new Date(System.currentTimeMillis());
		//如果还未设置预计完成时间且开始时间不等于当天日期
		if(p.getEndTime()!=null&&!formatter.format(todayDate).equals(formatter.format(p.getStartUseDate()))) {
			//转换预计完成时间
			Date endDate=p.getEndTime();
			//计算剩余天数
			int betweenDate=(int) ((endDate.getTime()-todayDate.getTime())/(60*60*24*1000));
			int clockInDay=(int) ((todayDate.getTime()-p.getStartUseDate().getTime())/(60*60*24*1000));
			PersonalData p1=new PersonalData();
			p1.setClockInDay(clockInDay+1);
			p1.setLearningDay(betweenDate);
			p1.setUid(uid);
			int result=userService.updPersonalData(p1);
			p=userService.selPersonalData(uid);
		}	
		return p;
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
        int result=userService.updPersonalData(p);
		return result;
	}

	@ResponseBody
	@RequestMapping("/updPersonalData.do")
	public int updPersonalData(String nickName,int haveToLearn,String endTime,int learningDay,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
		int uid=userService.getUserIdByName(nickName);
		PersonalData p=new PersonalData();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date=formatter.parse(endTime);
		//获取当天日期
		Date todayDate = new Date(System.currentTimeMillis());
		String today=formatter.format(todayDate);
		Date startTime=formatter.parse(today);
		p.setHaveToLearn(haveToLearn);
		p.setLearningDay(learningDay);
		p.setUid(uid);
		p.setEndTime(date);
		p.setStartTime(startTime);
		int result=userService.updPersonalData(p);
		return result;
	}
}
