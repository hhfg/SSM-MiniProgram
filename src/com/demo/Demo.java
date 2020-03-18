package com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class Demo {
	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		//获取当天日期
//		Date todayDate = new Date(System.currentTimeMillis());
//		String date="2020-12-14";
//		Date endDate=formatter.parse(date);
//		long betweenDate=(endDate.getTime()-todayDate.getTime())/(60*60*24*1000);
//		System.out.println(betweenDate);
		String specifiedDay="2020-03-01";
		System.out.println(getSpecifiedDayBefore(specifiedDay));
	}
	public static String getSpecifiedDayBefore(String specifiedDay) {
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
 
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayBefore;
	}
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
 
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
		return dayAfter;
	}
}