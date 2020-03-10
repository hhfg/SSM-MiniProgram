package com.yym.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.setContentType("text/html;charset=utf-8");          
        response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  	
        DecodeUserUtil decode=new DecodeUserUtil();
        String openid=decode.decodeUser(code);
       
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
		int result=userService.insPersonalData(id,clockInDay);
		return result;
	}
	@ResponseBody
	@RequestMapping("/selPersonalData.do")
	public PersonalData selPersonalData(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, ParseException {
		int uid=userService.getUserIdByName(nickName);
		PersonalData p=userService.selPersonalData(uid);
		//获取当天日期
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date todayDate = new Date(System.currentTimeMillis());
		Date endDate=formatter.parse(p.getEndTime());
		long betweenDate=(endDate.getTime()-todayDate.getTime())/(60*60*24*1000);
		return p;
	}
	
	@ResponseBody
	@RequestMapping("/setMyBook.do")
	public int setMyBook(String nickName,int bookid,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");          
        response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST"); 
        int uid=userService.getUserIdByName(nickName);
		//int result=userService.setMyBook(bookid,uid);
        PersonalData p=new PersonalData();
        p.setBookid(bookid);
        p.setUid(uid);
        int result=userService.updPersonalData(p);
		return result;
	}

	@ResponseBody
	@RequestMapping("/updPersonalData.do")
	public int updPersonalData(String nickName,int haveToLearn,String endTime,int learningDay,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int uid=userService.getUserIdByName(nickName);
		PersonalData p=new PersonalData();
		p.setHaveToLearn(haveToLearn);
		p.setEndTime(endTime);
		p.setLearningDay(learningDay);
		p.setUid(uid);
		int result=userService.updPersonalData(p);
		return result;
	}
}
