package com.yym.entity;

import java.util.Date;

public class SignRecord {
	private int id;
	private int uid;          //对应的用户id 
	private Date sign_date;   //打卡日期
	private int continue_sign;//连续签到打卡天数
	private int learned_num;  //学习的单词量
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
	public Date getSign_date() {
		return sign_date;
	}
	public void setSign_date(Date sign_date) {
		this.sign_date = sign_date;
	}
	public int getContinue_sign() {
		return continue_sign;
	}
	public void setContinue_sign(int continue_sign) {
		this.continue_sign = continue_sign;
	}
	public int getLearned_num() {
		return learned_num;
	}
	public void setLearned_num(int learned_num) {
		this.learned_num = learned_num;
	}
	@Override
	public String toString() {
		return "SignRecord [id=" + id + ", uid=" + uid + ", sign_date=" + sign_date + ", continue_sign=" + continue_sign
				+ ", learned_num=" + learned_num + "]";
	}
	
}
