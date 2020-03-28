package com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Demo {
	public static void main(String[] args) throws ParseException {
		String time="2020-03-28";
		System.out.println(pastDay(time));
	}
	/**
     * ��ȡ��ȥ�ڼ��������
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
     * ��ȡ��ȥ7���ڵ���������
     * @return  ��������
     */
    public static ArrayList<String> pastDay(String time){
        ArrayList<String> pastDaysList = new ArrayList<>();
        try {
        	//�����ﴫ����ʱ���Ǹ�string���͵ģ�����Ҫ��תΪdate���͵ġ�
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