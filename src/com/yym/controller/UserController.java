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
        System.out.println(openid);
        User user=new User();
        user.setOpenid(openid);
        user.setNickName(nickName);
        user.setAvatarUrl(avatarUrl);
        user.setGender(gender);
        user.setProvince(province);
        user.setCity(city);
        //≤Â»Î”√ªß 
        int result=userService.insUser(user);
        return "redirect:/getUserId.do?openid="+openid; 
	}
	@RequestMapping("/getUserId.do")
	public String getUserId(String openid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int id=userService.getUserId(openid);
		return "redirect:/insPersonalData.do?id="+id;
	}
	@ResponseBody
	@RequestMapping("/insPersonalData.do")
	public int insPersonalData(int id,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		int learningDays=1;
		int result=userService.insPersonalData(id,learningDays);
		return result;
	}
	@ResponseBody
	@RequestMapping("/selPersonalData.do")
	public PersonalData selPersonalData(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		System.out.println(nickName);
		int uid=userService.selUserId(nickName);
		System.out.println(uid);
		PersonalData p=userService.selPersonalData(uid);
		return p;
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
	
	
}
