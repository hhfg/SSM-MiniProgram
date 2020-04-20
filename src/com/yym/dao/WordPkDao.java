package com.yym.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.ErrorWords;
import com.yym.entity.Player;
import com.yym.entity.Words;

public interface WordPkDao {
	int updBank(@Param("bank")String bank,@Param("uid")int uid);
	String selTable(@Param("table_name")String table_name);
	int createUserErrorBook(@Param("table_name")String table_name);
	int insErrorWord(@Param("table_name")String table_name,@Param("word")String word,@Param("us_pron")String us_pron,@Param("us_mp3")String us_mp3,
			@Param("explanation")String explanation,@Param("dates")Date dates);
	List<ErrorWords> selErrorWords(@Param("table_name")String table_name);
	
}
