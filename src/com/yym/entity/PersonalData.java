package com.yym.entity;

public class PersonalData {
	private int id;
	private int uid;          //用户的id
	private int bookid;       //用户选择的单词书的id
	private int learningDays; //已学习的天数
	private int completedNums;//已学习的单词量
	private int haveToLearn;  //每天需要学习的单词数
	private int haveToReview; //需要复习的单词数
	private String endTime;   //预计完成的日期
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
	public int getLearningDays() {
		return learningDays;
	}
	public void setLearningDays(int learningDays) {
		this.learningDays = learningDays;
	}
	public int getCompletedNums() {
		return completedNums;
	}
	public void setCompletedNums(int completedNums) {
		this.completedNums = completedNums;
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
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "PersonalData [id=" + id + ", uid=" + uid + ", learningDays=" + learningDays + ", completedNums="
				+ completedNums + ", haveToLearn=" + haveToLearn + ", haveToReview=" + haveToReview + ", endTime="
				+ endTime + "]";
	}
	
}
