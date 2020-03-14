package com.yym.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.UserWords;
import com.yym.entity.Words;

public interface LearningDao {
	//从单词书表中获取单词
	List<Words> selWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
	//根据单词书的id获取所对应的表
	String selTableName(@Param("id")int id);
	//将单词插入到用户的单词表中
	int insWords(@Param("table_name")String tabel_name,@Param("id")int id,@Param("word")String word,@Param("us_pron")String us_pron,
			@Param("uk_pron")String uk_pron,@Param("us_mp3")String us_mp3,@Param("uk_mp3")String uk_mp3,@Param("explanation")String explanation
			,@Param("val_ex1")String val_ex1,@Param("bil_ex1")String bil_ex1,@Param("val_ex2")String val_ex2,@Param("bil_ex2")String bil_ex2,
			@Param("val_ex3")String val_ex3,@Param("bil_ex3")String bil_ex3,@Param("collocation")String collocation,@Param("status")int status,
			@Param("dates")Date dates,@Param("bookid")int bookid);
	//获取用户单词表的count，用来判断是否有数据 -
	int getCount(@Param("table_name")String table_name);
	//从单词表中获取status=0即未学的单词 
	List<UserWords> getWords(@Param("table_name")String table_name,@Param("status")int status,@Param("bookid")int bookid);
	//设置单词为已学status=0
	int updStatus(@Param("table_name")String table_name,@Param("status")int status,@Param("id")int id);
	// 随机从数据库取三条记录
	Set<String> selExplanation();
	// 从用户单词表中获取当前status=0的个数
	int selLearningCount(@Param("table_name")String table_name);
	//从用户单词表中获取status=1且日期不等于当天的单词（需要复习的单词
	List<UserWords> selReview(@Param("table_name")String table_name,@Param("dates")Date dates);
	//获取需要练习的单词
	List<UserWords> selPractise(@Param("table_name")String table_name,@Param("dates")Date dates);
}
