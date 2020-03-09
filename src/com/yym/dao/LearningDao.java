package com.yym.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.UserWords;
import com.yym.entity.Words;

public interface LearningDao {
	List<Words> selWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
	String selTableName(@Param("bookName")String bookName);
	int insWords(@Param("table_name")String tabel_name,@Param("word")String word,@Param("us_pron")String us_pron,
			@Param("uk_pron")String uk_pron,@Param("us_mp3")String us_mp3,@Param("uk_mp3")String uk_mp3,@Param("explanation")String explanation
			,@Param("val_ex1")String val_ex1,@Param("bil_ex1")String bil_ex1,@Param("val_ex2")String val_ex2,@Param("bil_ex2")String bil_ex2,
			@Param("val_ex3")String val_ex3,@Param("bil_ex3")String bil_ex3,@Param("collocation")String collocation,@Param("completed")int completed,
			@Param("dates")Date dates);
}
