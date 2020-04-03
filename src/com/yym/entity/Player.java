package com.yym.entity;

public class Player {
	private int id;
	private int uid;
	private String nickName;
	private String bank;
	private String rank;
	private int stars;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", uid=" + uid + ", nickName=" + nickName + ", bank=" + bank + ", rank=" + rank
				+ ", stars=" + stars + "]";
	}

	
}
