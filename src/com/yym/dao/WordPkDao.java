package com.yym.dao;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.Player;

public interface WordPkDao {
	int updBank(@Param("bank")String bank,@Param("uid")int uid);
	Player selPlayer(@Param("uid")int uid);
}
