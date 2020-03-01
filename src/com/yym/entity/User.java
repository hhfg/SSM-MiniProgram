package com.yym.entity;

public class User {
	private int id;
	private String username;
	private String profileUrl;
	private int bookid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", profileUrl=" + profileUrl + ", bookid=" + bookid + "]";
	}
	
	
}
