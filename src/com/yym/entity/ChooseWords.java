package com.yym.entity;

import java.util.List;
import java.util.Set;

public class ChooseWords {
	private int id;
	private String word;
	private String pron;
	private String pron_mp3;
	private Set<String> explanation;
	//正确的释义
	private String correctEx;
	public String getCorrectEx() {
		return correctEx;
	}
	public void setCorrectEx(String correctEx) {
		this.correctEx = correctEx;
	}

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
	
	public String getPron() {
		return pron;
	}
	public void setPron(String pron) {
		this.pron = pron;
	}
	public String getPron_mp3() {
		return pron_mp3;
	}
	public void setPron_mp3(String pron_mp3) {
		this.pron_mp3 = pron_mp3;
	}
	public Set<String> getExplanation() {
		return explanation;
	}
	public void setExplanation(Set<String> explanation) {
		this.explanation = explanation;
	}
	@Override
	public String toString() {
		return "ChooseWords [id=" + id + ", word=" + word + ", pron=" + pron + ", pron_mp3=" + pron_mp3 + ", correctEx="
				+ correctEx + ", explanation=" + explanation + "]";
	}
	
}
