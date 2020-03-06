package com.yym.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		List<BooksType> booksType=booksService.selAllType();
		for(BooksType s:booksType) {
			s.setWordBooks(booksService.selByType(s.getId()));
		}		
		return booksType;
	}	
}
