package com.yym.controller;

import java.io.IOException;
import java.io.Writer;

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

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/login.do")
	public int login(String openid,String nickName,String avatarUrl,int gender,String province,String city,
			String profileUrl,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");          
        response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  	
        User user=new User();
        user.setOpenid(openid);
        user.setNickName(nickName);
        user.setAvatarUrl(avatarUrl);
        user.setGender(gender);
        user.setProvince(province);
        user.setCity(city);
        //插入用户 
        int result=userService.insUser(user);
//        int uid=userService.getUserId(openid);
        //如果插入成功，在personal_data表中新增用户相关信息
//        if(result==1) {
//        	int t=userService.insPersonalData(uid);
//        }else {
//        	System.out.println("插入失败");
//        }
        return result; 
	}
	@ResponseBody
	@RequestMapping("/setMyBook.do")
	public int setMyBook(String username,int bookid,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");          
        response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  	
		int result=userService.setMyBookId(username, bookid);
		return result;
	}
	@ResponseBody
	@RequestMapping("/selBookByUser.do")
	public WordBooks selBookByUser(String username,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		WordBooks wordBook=userService.selBookByUser(username);
		return wordBook;
	}
	
	@ResponseBody
	@RequestMapping("/insPersonalData.do")
	public int insPersonalData(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		int uid=5;
		int learningDay=1;
		int completedNum=0;
		int haveToLearn=10;
		int haveToReview=0;
		String endTime="2020-04-10";
		int result=userService.insPersonalData(uid,learningDay,completedNum,haveToLearn,haveToReview,endTime);
		return result;
	}

	
}
