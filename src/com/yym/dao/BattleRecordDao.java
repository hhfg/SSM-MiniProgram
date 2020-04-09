package com.yym.dao;

import org.apache.ibatis.annotations.Param;

public interface BattleRecordDao {
	int insRecord(@Param("playA")int playA,@Param("status")int status);
}
