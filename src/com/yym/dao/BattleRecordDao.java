package com.yym.dao;

import org.apache.ibatis.annotations.Param;

public interface BattleRecordDao {
	int insRecord(@Param("roomid")int roomid,@Param("playA")int playA,@Param("status")int status);
	int selId(@Param("playA")int playA,@Param("status")int status);
	int updRecord(@Param("playB")int playB,@Param("roomid")int roomid);
}
