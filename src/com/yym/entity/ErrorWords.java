package com.yym.entity;

import java.util.Date;

public class ErrorWords {
	private int id;
	private String word;
	private String us_pron;
	private String us_mp3;
	private String explanation;
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
	public String getUs_mp3() {
		return us_mp3;
	}
	public void setUs_mp3(String us_mp3) {
		this.us_mp3 = us_mp3;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	@Override
	public String toString() {
		return "ErrorWords [id=" + id + ", word=" + word + ", us_pron=" + us_pron + ", us_mp3=" + us_mp3
				+ ", explanation=" + explanation + ", dates=" + dates + "]";
	}
	
}
