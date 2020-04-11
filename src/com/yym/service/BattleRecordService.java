package com.yym.service;

public interface BattleRecordService {
	int insRecord(int roomid,int playA,int status);
	int selId(int playA,int status);
	int updRecord(int playB,int status,int id);
}
