package com.yym.dao;

import org.apache.ibatis.annotations.Param;

public interface LearningRecordDao {
	//获取用户单词书中已学的单词
	int selCount(@Param("table_name")String table_name);
}
