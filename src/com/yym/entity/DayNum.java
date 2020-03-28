package com.yym.entity;

public class DayNum {
	private int num;
	private String date;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "DayNum [num=" + num + ", date=" + date + "]";
	}
	
}
