package com.yym.service;

import java.util.List;

import com.yym.entity.BattleRecord;
import com.yym.entity.User;

public interface BattleRecordService {
	int insRecord(int roomid,int playA,int status);
	int selId(BattleRecord battleRecord);
	int selStatus(int roomid);
	int updRecord(int playB,int status,int roomid);
	BattleRecord selUid(int id);
	User selUser(int id);
	int updRoomStatus(int status,int id);
	int updateRecord(int ascore,int bscore,int status,int id);
	List<BattleRecord> selRecord(int id);
}
