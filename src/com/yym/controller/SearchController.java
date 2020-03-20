package com.yym.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.Words;
import com.yym.service.SearchService;

@Controller
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	@ResponseBody
	@RequestMapping("/searchWord.do")
	public Words searchWord(String word,HttpServletRequest request,HttpServletResponse response) {
		List<Words> w=searchService.searchWord(word);
		if(w.size()==0) {
			return null;
		}else {
			Words ww=w.get(0);
			return ww;
		}
	}
}
