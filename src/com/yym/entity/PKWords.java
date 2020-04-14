package com.yym.entity;

import java.util.Set;

public class PKWords {
	private int id;
	private String word;
	private String us_pron;
	private String us_mp3;
	private String explanation;
	private Set<String> choose;
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
	public Set<String> getChoose() {
		return choose;
	}
	public void setChoose(Set<String> choose) {
		this.choose = choose;
	}
	@Override
	public String toString() {
		return "PKWords [id=" + id + ", word=" + word + ", us_pron=" + us_pron + ", us_mp3=" + us_mp3 + ", explanation="
				+ explanation + ", choose=" + choose + "]";
	}
	
}
