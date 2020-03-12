package com.yym.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.UserWords;
import com.yym.entity.Words;

public interface LearningService {
	//从单词书表中获取单词
	List<Words> selWords(String table,int start,int end);
	//根据书名得到其所对应的表
	String selTableName(String bookName);
	//将单词插入到用户的单词表中
	int insWords(String tabel_name,String word,String us_pron,String uk_pron,String us_mp3,String uk_mp3,String explanation
			,String val_ex1,String bil_ex1,String val_ex2,String bil_ex2,String val_ex3,String bil_ex3,String collocation,int status,
			Date dates);
	 //获取用户单词表的count，用来判断是否有数据 
	int getCount(String table_name);
	//从用户单词表中查询status为0的数据(0表示还未学习
	List<UserWords> getWords(String table_name,int status);
	//设置单词为已学status=0
	int updStatus(String table_name,int id);
	// 随机从数据库取三条记录
	Set<String> selExplanation();
	// 从用户单词表中获取当前status=0的个数
	int selLearningCount(@Param("table_name")String table_name);
}
