package com.yym.entity;

public class PersonalData {
	private int id;
	private int uid;          //�û���id
	private int bookid;       //�û�ѡ��ĵ������id
	private int learningDays; //��ѧϰ������
	private int completedNums;//��ѧϰ�ĵ�����
	private int haveToLearn;  //ÿ����Ҫѧϰ�ĵ�����
	private int haveToReview; //��Ҫ��ϰ�ĵ�����
	private String endTime;   //Ԥ����ɵ�����
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
