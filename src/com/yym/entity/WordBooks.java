package com.yym.entity;

public class WordBooks {
	private int id;
	private String bookName;
	private int wordNum;
	private String type;
	private String tableName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	@Override
	public String toString() {
		return "WordBooks [id=" + id + ", bookName=" + bookName + ", wordNum=" + wordNum + ", type=" + type
				+ ", tableName=" + tableName + "]";
	}
	
	
}
