package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.BattleRecord;
import com.yym.entity.User;

public interface BattleRecordDao {
	//插入对战记录
	int insRecord(@Param("roomid")int roomid,@Param("playA")int playA,@Param("status")int status);
	//查找对应的id
	int selId(BattleRecord battleRecord);
	int selStatus(@Param("roomid")int roomid);
	//更新房间状态
	int updRecord(@Param("playB")int playB,@Param("status")int status,@Param("roomid")int roomid);
	//通过id查找对应的对战记录
	BattleRecord selUid(@Param("id")int id);
	//通过id查找user
	User selUser(@Param("id")int id);
	int updRoomStatus(@Param("status")int status,@Param("id")int id);
	int updateRecord(@Param("ascore")int ascore,@Param("bscore")int bscore,@Param("status")int status,@Param("id")int id);
	List<BattleRecord> selRecord(@Param("id")int id);
}
