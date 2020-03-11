package com.yym.entity;

import java.util.Date;

public class PersonalData {
	private int id;
	private int uid;          //用户的id
	private int bookid;       //用户选择的单词书的id
	private int clockInDay;   //打卡天数
	private int completedNum;//已学习的单词量
	private int haveToLearn;  //每天需要学习的单词数
	private int haveToReview; //需要复习的单词数
	private Date endTime;   //预计完成的日期
	private Date startTime; //开始使用小程序的日期
	private int learningDay;  //预计学习的天数
	private int lastWordId;   //最后背诵的一个id
	public int getLastWordId() {
		return lastWordId;
	}
	public void setLastWordId(int lastWordId) {
		this.lastWordId = lastWordId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getClockInDay() {
		return clockInDay;
	}
	public void setClockInDay(int clockInDay) {
		this.clockInDay = clockInDay;
	}
	public int getCompletedNum() {
		return completedNum;
	}
	public void setCompletedNum(int completedNum) {
		this.completedNum = completedNum;
	}
	public int getHaveToLearn() {
		return haveToLearn;
	}
	public void setHaveToLearn(int haveToLearn) {
		this.haveToLearn = haveToLearn;
	}
	public int getHaveToReview() {
		return haveToReview;
	}
	public void setHaveToReview(int haveToReview) {
		this.haveToReview = haveToReview;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getLearningDay() {
		return learningDay;
	}
	public void setLearningDay(int learningDay) {
		this.learningDay = learningDay;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@Override
	public String toString() {
		return "PersonalData [id=" + id + ", uid=" + uid + ", bookid=" + bookid + ", clockInDay=" + clockInDay
				+ ", completedNum=" + completedNum + ", haveToLearn=" + haveToLearn + ", haveToReview=" + haveToReview
				+ ", endTime=" + endTime + ", startTime=" + startTime + ", learningDay=" + learningDay + ", lastWordId="
				+ lastWordId + "]";
	}

}
