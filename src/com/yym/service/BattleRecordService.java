package com.yym.service;

public interface BattleRecordService {
	int insRecord(int playA,int playB,int status);
	int selId(int playA,int status);
	int updRecord(int playB,int status,int id);
}
