package com.yym.entity;

import java.util.Date;

public class PersonalData {
	private int id;
	private int uid;          //�û���id
	private int bookid;       //�û�ѡ��ĵ������id
	private int clockInDay;   //������
	private int completedNum;//��ѧϰ�ĵ�����
	private int haveToLearn;  //ÿ����Ҫѧϰ�ĵ�����
	private int haveToReview; //��Ҫ��ϰ�ĵ�����
	private String endTime;   //Ԥ����ɵ�����
	private int learningDay;  //Ԥ��ѧϰ������
	private int lastWordId;   //����е�һ��id
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
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getLearningDay() {
		return learningDay;
	}
	public void setLearningDay(int learningDay) {
		this.learningDay = learningDay;
	}
	@Override
	public String toString() {
		return "PersonalData [id=" + id + ", uid=" + uid + ", bookid=" + bookid + ", clockInDay=" + clockInDay
				+ ", completedNum=" + completedNum + ", haveToLearn=" + haveToLearn + ", haveToReview=" + haveToReview
				+ ", endTime=" + endTime + ", learningDay=" + learningDay + ", lastWordId=" + lastWordId + "]";
	}

	

}
