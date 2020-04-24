package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.BattleRecord;
import com.yym.entity.User;

public interface BattleRecordDao {
	//�����ս��¼
	int insRecord(@Param("roomid")int roomid,@Param("playA")int playA,@Param("status")int status);
	//���Ҷ�Ӧ��id
	int selId(BattleRecord battleRecord);
	int selStatus(@Param("roomid")int roomid);
	//���·���״̬
	int updRecord(@Param("playB")int playB,@Param("status")int status,@Param("roomid")int roomid);
	//ͨ��id���Ҷ�Ӧ�Ķ�ս��¼
	BattleRecord selUid(@Param("id")int id);
	//ͨ��id����user
	User selUser(@Param("id")int id);
	int updRoomStatus(@Param("status")int status,@Param("id")int id);
	int updateRecord(@Param("ascore")int ascore,@Param("bscore")int bscore,@Param("status")int status,@Param("id")int id);
	List<BattleRecord> selRecord(@Param("id")int id);
}
