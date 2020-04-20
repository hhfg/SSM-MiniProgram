package com.yym.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.Player;
import com.yym.entity.Words;

public interface WordPkDao {
	int updBank(@Param("bank")String bank,@Param("uid")int uid);
	String selTable(@Param("table_name")String table_name);
	int createUserErrorBook(@Param("table_name")String table_name);
}
