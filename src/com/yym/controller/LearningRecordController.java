package com.yym.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.DayNum;
import com.yym.entity.SignRecord;
import com.yym.service.LearningRecordService;
import com.yym.util.GetSpecifiedDay;

@Controller
public class LearningRecordController {
	@Autowired
	private LearningRecordService learningRecordService;
	@ResponseBody
	@RequestMapping("/selCount.do")
	public List<DayNum> selCount(int uid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ParseException{
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date todayDate=new Date(System.currentTimeMillis());
		String time=formatter.format(todayDate);
		GetSpecifiedDay getSpecifiedDay=new GetSpecifiedDay();
		//获取过去七天的日期
		List<String> dateList=getSpecifiedDay.pastDay(time);
		SignRecord sign=new SignRecord();
		List<DayNum> list=new ArrayList<DayNum>();
		Date sign_date;
		DayNum d=new DayNum();
		for(String s:dateList) {
			sign_date=formatter.parse(s);
			sign=learningRecordService.selDate(sign_date, uid);
			d.setDate(s);
			if(sign==null) {
				d.setNum(0);
			}else {
				d.setNum(sign.getLearned_num());
			}
			list.add(d);
		}
		return list;
	}

	
}
