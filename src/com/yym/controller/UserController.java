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
import com.yym.entity.WordBooks;
import com.yym.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/login.do")
	public void login(String username,String profileUrl,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
       response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  	
        int result=userService.insUser(username, profileUrl);
        System.out.println(result);
        
//        //返回值给微信小程序
//        Writer out = response.getWriter(); 
//        out.write("登录成功");
//        out.flush();   
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
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/insertUser.do") public int insertUser(String openid,String
	 * nickName,String avatarUrl,String province,String city, HttpServletRequest
	 * request,HttpServletResponse response) throws ServletException,IOException{
	 * int result=userService.insertUser(openid, nickName, avatarUrl, province,
	 * city); return result; }
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/queryUser.do") public MiniUser queryUser(String
	 * openid,HttpServletRequest request,HttpServletResponse response) throws
	 * ServletException,IOException{ MiniUser u=userService.queryUser(openid);
	 * return u; }
	 */
	
}
