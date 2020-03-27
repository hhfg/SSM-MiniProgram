package com.yym.entity;

import java.util.Date;
import java.util.Set;

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
	private int status;
	private Date dates;
	private int bookid;  //单词对应的单词书
	private int collect; //是否收藏单词,0表示未收藏,1表示收藏
	private Set<String> choose;
	private Set<String> chooseEn;
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
		return status;
	}
	public void setCompleted(int status) {
		this.status = status;
	}

	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	public Set<String> getChoose() {
		return choose;
	}
	public void setChoose(Set<String> choose) {
		this.choose = choose;
	}
	public int getCollect() {
		return collect;
	}
	public void setCollect(int collect) {
		this.collect = collect;
	}
	public Set<String> getChooseEn() {
		return chooseEn;
	}
	public void setChooseEn(Set<String> chooseEn) {
		this.chooseEn = chooseEn;
	}
	@Override
	public String toString() {
		return "UserWords [id=" + id + ", word=" + word + ", us_pron=" + us_pron + ", uk_pron=" + uk_pron + ", us_mp3="
				+ us_mp3 + ", uk_mp3=" + uk_mp3 + ", explanation=" + explanation + ", val_ex1=" + val_ex1 + ", bil_ex1="
				+ bil_ex1 + ", val_ex2=" + val_ex2 + ", bil_ex2=" + bil_ex2 + ", val_ex3=" + val_ex3 + ", bil_ex3="
				+ bil_ex3 + ", collocation=" + collocation + ", status=" + status + ", dates=" + dates + ", bookid="
				+ bookid + ", collect=" + collect + ", choose=" + choose + ", chooseEn=" + chooseEn + "]";
	}
<<<<<<< HEAD

	

=======
	
>>>>>>> refs/remotes/origin/master
}
