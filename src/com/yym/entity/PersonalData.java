package com.yym.entity;

import java.util.Date;

public class PersonalData {
	private int id;
	private int uid;            //用户的id
	private int bookid;         //用户选择的单词书的id
	private int clockInDay;     //打卡天数
	private int completedNum;   //已学习的单词量
	private int haveToLearn;    //每天需要学习的单词数
	private int haveToReview;   //需要复习的单词数
	private Date startUseDate;  //用户首次使用的日期
	private Date endTime;       //预计完成的日期
	private Date startTime;     //开始使用小程序的日期
	private int learningDay;    //预计学习的天数
	private int lastWordId;     //最后背诵的一个id
	private int dayNum;         //定制的计划 每天需要学习的单词量
	private int continue_sign;  //连续签到天数
	private int haveLearned;    //总的学习的词汇数
	private String bank;        //选择的题库
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
	public Date getStartUseDate() {
		return startUseDate;
	}
	public void setStartUseDate(Date startUseDate) {
		this.startUseDate = startUseDate;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public int getLearningDay() {
		return learningDay;
	}
	public void setLearningDay(int learningDay) {
		this.learningDay = learningDay;
	}
	public int getLastWordId() {
		return lastWordId;
	}
	public void setLastWordId(int lastWordId) {
		this.lastWordId = lastWordId;
	}
	public int getDayNum() {
		return dayNum;
	}
	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}
	
	public int getContinue_sign() {
		return continue_sign;
	}
	public void setContinue_sign(int continue_sign) {
		this.continue_sign = continue_sign;
	}
	public int getHaveLearned() {
		return haveLearned;
	}
	public void setHaveLearned(int haveLearned) {
		this.haveLearned = haveLearned;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	@Override
	public String toString() {
		return "PersonalData [id=" + id + ", uid=" + uid + ", bookid=" + bookid + ", clockInDay=" + clockInDay
				+ ", completedNum=" + completedNum + ", haveToLearn=" + haveToLearn + ", haveToReview=" + haveToReview
				+ ", startUseDate=" + startUseDate + ", endTime=" + endTime + ", startTime=" + startTime
				+ ", learningDay=" + learningDay + ", lastWordId=" + lastWordId + ", dayNum=" + dayNum
				+ ", continue_sign=" + continue_sign + ", haveLearned=" + haveLearned + ", bank=" + bank + "]";
	}
	
	
}
