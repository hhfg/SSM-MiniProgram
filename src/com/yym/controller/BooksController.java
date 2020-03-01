package com.yym.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.BooksType;
import com.yym.entity.WordBooks;
import com.yym.service.BooksService;

@Controller
public class BooksController {
	@Autowired
	private BooksService booksService;
	@ResponseBody
	@RequestMapping("/selAllType.do")
	public List<BooksType> selAllType(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<BooksType> list=booksService.selAllType();
		return list;
	}
	@ResponseBody
	@RequestMapping("/selByType.do")
	public List<WordBooks> selByType(String type,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//		String type="cet4";
		List<WordBooks> list=booksService.selByType(type);
		return list;
	}
	
}
