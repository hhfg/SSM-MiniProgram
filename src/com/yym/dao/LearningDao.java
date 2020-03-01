package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.Words;

public interface LearningDao {
	List<Words> selWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
	String selTableName(@Param("bookName")String bookName);
}
