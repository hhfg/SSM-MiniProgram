package com.yym.entity;

public class WordBooks {
	private int id;
	private int bid;
	private String bookName;
	private int wordNum;
	private String tableName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getWordNum() {
		return wordNum;
	}
	public void setWordNum(int wordNum) {
		this.wordNum = wordNum;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	@Override
	public String toString() {
		return "WordBooks [id=" + id + ", bid=" + bid + ", bookName=" + bookName + ", wordNum=" + wordNum
				+ ", tableName=" + tableName + "]";
	}
	
}
