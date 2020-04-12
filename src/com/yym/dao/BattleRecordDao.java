package com.yym.dao;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.BattleRecord;
import com.yym.entity.User;

public interface BattleRecordDao {
	int insRecord(@Param("roomid")int roomid,@Param("playA")int playA,@Param("status")int status);
	int selId(BattleRecord battleRecord);
	int updRecord(@Param("playB")int playB,@Param("status")int status,@Param("roomid")int roomid);
	User selUser(@Param("id")int id);
}
