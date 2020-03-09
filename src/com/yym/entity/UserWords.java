package com.yym.entity;

import java.util.Date;

public class UserWords {
	private int id;
	private String word;
	private String us_pron;
	private String uk_pron;
	private String us_mp3;
	private String uk_mp3;
	private String explanation;
	private String val_ex1;
	private String bil_ex1;
	private String val_ex2;
	private String bil_ex2;
	private String val_ex3;
	private String bil_ex3;
	private String collocation;
	private int completed;
	private Date dates;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getUs_pron() {
		return us_pron;
	}
	public void setUs_pron(String us_pron) {
		this.us_pron = us_pron;
	}
	public String getUk_pron() {
		return uk_pron;
	}
	public void setUk_pron(String uk_pron) {
		this.uk_pron = uk_pron;
	}
	public String getUs_mp3() {
		return us_mp3;
	}
	public void setUs_mp3(String us_mp3) {
		this.us_mp3 = us_mp3;
	}
	public String getUk_mp3() {
		return uk_mp3;
	}
	public void setUk_mp3(String uk_mp3) {
		this.uk_mp3 = uk_mp3;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getVal_ex1() {
		return val_ex1;
	}
	public void setVal_ex1(String val_ex1) {
		this.val_ex1 = val_ex1;
	}
	public String getBil_ex1() {
		return bil_ex1;
	}
	public void setBil_ex1(String bil_ex1) {
		this.bil_ex1 = bil_ex1;
	}
	public String getVal_ex2() {
		return val_ex2;
	}
	public void setVal_ex2(String val_ex2) {
		this.val_ex2 = val_ex2;
	}
	public String getBil_ex2() {
		return bil_ex2;
	}
	public void setBil_ex2(String bil_ex2) {
		this.bil_ex2 = bil_ex2;
	}
	public String getVal_ex3() {
		return val_ex3;
	}
	public void setVal_ex3(String val_ex3) {
		this.val_ex3 = val_ex3;
	}
	public String getBil_ex3() {
		return bil_ex3;
	}
	public void setBil_ex3(String bil_ex3) {
		this.bil_ex3 = bil_ex3;
	}
	public String getCollocation() {
		return collocation;
	}
	public void setCollocation(String collocation) {
		this.collocation = collocation;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	@Override
	public String toString() {
		return "UserWords [id=" + id + ", word=" + word + ", us_pron=" + us_pron + ", uk_pron=" + uk_pron + ", us_mp3="
				+ us_mp3 + ", uk_mp3=" + uk_mp3 + ", explanation=" + explanation + ", val_ex1=" + val_ex1 + ", bil_ex1="
				+ bil_ex1 + ", val_ex2=" + val_ex2 + ", bil_ex2=" + bil_ex2 + ", val_ex3=" + val_ex3 + ", bil_ex3="
				+ bil_ex3 + ", collocation=" + collocation + ", completed=" + completed + ", dates=" + dates + "]";
	}
	
}
