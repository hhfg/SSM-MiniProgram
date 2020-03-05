package com.yym.entity;

import java.util.List;

public class BooksType {
	private int id;
	private String typename;
	private String typecode;
	private List<WordBooks> wordBooks;
	public List<WordBooks> getWordBooks() {
		return wordBooks;
	}
	public void setWordBooks(List<WordBooks> wordBooks) {
		this.wordBooks = wordBooks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	@Override
	public String toString() {
		return "BooksType [id=" + id + ", typename=" + typename + ", typecode=" + typecode + ", wordBooks=" + wordBooks
				+ "]";
	}
	
	
}
