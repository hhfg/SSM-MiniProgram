package com.yym.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GetSpecifiedDay {
	public String getSpecifiedDayBefore(String specifiedDay) {
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
	/**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past,Date date) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)-past);
        Date today=calendar.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String result=sdf.format(today);
        return result;
    }

	/**
     * 获取过去7天内的日期数组
     * @return  日期数组
     */
    public static List<String> pastDay(String time){
        List<String> pastDaysList = new ArrayList<>();
        try {
        	//我这里传来的时间是个string类型的，所以要先转为date类型的。
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(time);
            for (int i = 6; i >= 0; i--) {
                pastDaysList.add(getPastDate(i,date));
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return pastDaysList;
    }
}
