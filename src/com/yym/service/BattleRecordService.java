package com.yym.service;

import com.yym.entity.BattleRecord;
import com.yym.entity.User;

public interface BattleRecordService {
	int insRecord(int roomid,int playA,int status);
	int selId(BattleRecord battleRecord);
	int updRecord(int playB,int status,int roomid);
	BattleRecord selUid(int id);
	User selUser(int id);
	int updRoomStatus(int status,int roomid,int playA,int playB);
}
