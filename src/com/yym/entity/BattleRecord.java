package com.yym.entity;

public class BattleRecord {
	private int id;
	private int roomid;
	private int playA;
	private int playB;
	private int ascore;
	private int bscore;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public int getPlayA() {
		return playA;
	}
	public void setPlayA(int playA) {
		this.playA = playA;
	}
	public int getPlayB() {
		return playB;
	}
	public void setPlayB(int playB) {
		this.playB = playB;
	}
	
	public int getAscore() {
		return ascore;
	}
	public void setAscore(int ascore) {
		this.ascore = ascore;
	}
	public int getBscore() {
		return bscore;
	}
	public void setBscore(int bscore) {
		this.bscore = bscore;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
