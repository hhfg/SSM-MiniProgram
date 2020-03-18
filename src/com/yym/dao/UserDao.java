package com.yym.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.SignRecord;
import com.yym.entity.User;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;

public interface UserDao {
	//根据openid判断是否有用户
	User selUser(@Param("openid")String openid);
    //	插入用户
	int insUser(User user);
	
	//通过openid查找用户的id
	int getUserId(@Param("openid")String openid);
	
	//在personal_data表中新增用户
	int insPersonalData(@Param("uid")int uid,@Param("clockInDay")int clockInDay,
			@Param("startUseDate")Date startUseDate);

	//  通过用户名查找用户在表中的id
	int getUserIdByName(@Param("nickName")String nickName);
	
	//查找用户在personal_data表中的信息
	PersonalData selPersonalData(@Param("uid")int uid);
	
	//设置用于选择的单词书的id
	int setMyBook(@Param("bookid")int bookid,@Param("uid")int uid);
	//更新用户需要学习的单词和学习计划截至日期
	int updPersonalData(PersonalData personalData);
	//创建用户的单词表
	int createUserWordTable(@Param("tableName")String tableName);
	//  更新用户选择的单词书的id
	//int setMyBookId(@Param("username")String username,@Param("bookid")int bookid);
	//  获取用户选择的单词书的信息
	//WordBooks selBookByUser(@Param("username")String username);
	int selReviewCount(@Param("table_name")String table_name,@Param("dates")Date dates,@Param("bookid")int bookid);
	int selLearningCount(@Param("table_name")String table_name,@Param("dates")Date dates,@Param("bookid")int bookid);
	//从单词书表中获取单词
	List<Words> selWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
	//将单词插入到用户的单词表中
	int insWords(@Param("table_name")String tabel_name,@Param("word")String word,@Param("us_pron")String us_pron,
				@Param("uk_pron")String uk_pron,@Param("us_mp3")String us_mp3,@Param("uk_mp3")String uk_mp3,@Param("explanation")String explanation
				,@Param("val_ex1")String val_ex1,@Param("bil_ex1")String bil_ex1,@Param("val_ex2")String val_ex2,@Param("bil_ex2")String bil_ex2,
				@Param("val_ex3")String val_ex3,@Param("bil_ex3")String bil_ex3,@Param("collocation")String collocation,@Param("status")int status,
				@Param("dates")Date dates,@Param("bookid")int bookid);
	//根据单词书的id获取所对应的表
	String selTableName(@Param("id")int id);
	//查看dates为当天日期的个数
	int selCountToday(@Param("table_name")String table_name,@Param("dates")Date dates,@Param("bookid")int bookid);
	//新增打卡记录
	int insSignRecord(SignRecord signRecord);
	//查看是否有特定日期的打卡记录
	SignRecord selSignRecord(@Param("uid")int uid,@Param("sign_date")Date sign_date);
	//获取未学习的单词
	List<UserWords> selNotLearned(@Param("table_name")String table_name);
	//查看今日是否已打卡
	SignRecord selTodaySign(@Param("uid")int uid,@Param("sign_date")Date sign_date);
}
