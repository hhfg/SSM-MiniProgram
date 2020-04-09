package com.yym.entity;

public class BattleRecord {
	private int id;
	private int playA;
	private int playB;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BattleRecord [id=" + id + ", playA=" + playA + ", playB=" + playB + ", status=" + status + "]";
	}
	
}
