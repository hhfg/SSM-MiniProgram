package com.yym.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.UserWords;
import com.yym.service.ReviewService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@ResponseBody
	@RequestMapping("/getReviewWords.do")
	public List<UserWords> getReviewWords(String nickName,String date,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ParseException {
		String table_name=nickName+"_word";
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date dates=formatter.parse(date);
		List<UserWords> list=reviewService.getReviewWords(table_name, dates);
		for(UserWords u:list) {
<<<<<<< HEAD
			Set<String> explanation=reviewService.getRanExplanation();
			Set<String> word=reviewService.getRanWord();
=======
			Set<String> explanation=reviewService.RanExplanation();
			Set<String> word=reviewService.RanWord();
>>>>>>> refs/remotes/origin/master
			explanation.add(u.getExplanation());
			word.add(u.getWord());
			u.setChoose(explanation);
			u.setChooseEn(word);
		}
		return list;
	}
}
