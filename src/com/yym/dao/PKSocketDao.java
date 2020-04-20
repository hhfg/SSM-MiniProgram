package com.yym.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.Player;
import com.yym.entity.Words;

public interface PKSocketDao {
	Player selPlayer(@Param("uid")int uid);
	List<Words> selPKWords(@Param("table_name")String table_name);
	Set<String> selChoose(@Param("table_name")String table_name);
	String selBank(@Param("uid")int uid);
}
