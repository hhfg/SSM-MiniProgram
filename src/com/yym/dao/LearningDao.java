package com.yym.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.UserWords;
import com.yym.entity.Words;

public interface LearningDao {
	//从单词书表中获取单词
	List<Words> selWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
	//根据书名得到其所对应的表
	String selTableName(@Param("bookName")String bookName);
	//将单词插入到用户的单词表中
	int insWords(@Param("table_name")String tabel_name,@Param("word")String word,@Param("us_pron")String us_pron,
			@Param("uk_pron")String uk_pron,@Param("us_mp3")String us_mp3,@Param("uk_mp3")String uk_mp3,@Param("explanation")String explanation
			,@Param("val_ex1")String val_ex1,@Param("bil_ex1")String bil_ex1,@Param("val_ex2")String val_ex2,@Param("bil_ex2")String bil_ex2,
			@Param("val_ex3")String val_ex3,@Param("bil_ex3")String bil_ex3,@Param("collocation")String collocation,@Param("completed")int completed,
			@Param("dates")Date dates);
	//获取用户单词表的count，用来判断是否有数据 -
	int getCount(@Param("table_name")String table_name);
	List<UserWords> getWords(@Param("table_name")String table_name);
}
