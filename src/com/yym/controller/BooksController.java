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
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;
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
	@ResponseBody
	@RequestMapping("/selBookById.do")
	public WordBooks selBookById(int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		WordBooks s=booksService.selBookById(id);
		return s;
	}
	@ResponseBody
	@RequestMapping("/selAllWords.do")
	public List<Words> selAllWords(String nickName,int page,int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		WordBooks w=booksService.selBookById(id);
		String table_name=w.getTableName();
		int start=page*15+1;
		int end=page*15+15;
		List<Words> list=booksService.selAllWords(table_name,start,end);
		return list;
	}
	@ResponseBody
	@RequestMapping("selLearnedWords.do")
	public List<UserWords> selLearnedWords(String nickName,int page,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String table_name=nickName+"_word";
		List<UserWords> list=booksService.selLearnedWords(table_name);
		if(list.size()>15) {
			int start=page*15+1;
			int end=page*15+15;
			if(list.size()<end) {
				end=list.size();
			}
			list=booksService.selPartWords(table_name, start, end);
		}
		return list;
	}
	@ResponseBody
	@RequestMapping("selCollectWords.do")
	public List<UserWords> selCollectWords(String nickName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String table_name=nickName+"_word";
		List<UserWords> list=booksService.selCollectWords(table_name);
		return list;
	}
}
