package com.yym.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.SignRecord;
import com.yym.entity.User;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;

public interface UserService {
	User selUser(String openid);
    //	插入用户
	int insUser(User user);
	
	//通过openid查找用户的id
	int getUserId(String openid);
	
	//在personal_data表中新增用户
	int insPersonalData(int uid,int clockInDay,Date startUseDate);
	
	//  查找用户在表中的id
	int getUserIdByName(String nickName);
	
	//查找用户在personal_data表中的信息
	PersonalData selPersonalData(int uid);
	
	//设置用于选择的单词书的id
	int setMyBook(int bookid,int uid);
	
	//更新用户需要学习的单词和学习计划截至日期
	int updPersonalData(PersonalData personalData);
	//创建用户的单词表
	int createUserWordTable(String tableName);
	//获取当天需要复习的单词量
	int selReviewCount(String table_name,Date dates);
	//获取当天需要学习的单词量
	int selLearningCount(String table_name,Date dates,int bookid);
	//从单词书表中获取单词
	List<Words> selWords(String table,int start,int end);
	//将单词插入到用户的单词表中
	int insWords(String tabel_name,String word,String us_pron,String uk_pron,String us_mp3,String uk_mp3,String explanation
			,String val_ex1,String bil_ex1,String val_ex2,String bil_ex2,String val_ex3,String bil_ex3,String collocation,int status,
			Date dates,int bookid,int collect);
	//根据单词书的id获取所对应的表
	String selTableName(int id);
	////查看dates为当天日期的个数
	int selCountToday(String table_name,Date dates,int bookid);
	//新增打卡记录
	int insSignRecord(SignRecord signRecord);
	//查看是否有特定日期的打卡记录
	SignRecord selSignRecord(int uid,Date sign_date);
	//获取还未学习的单词
	List<UserWords> selNotLearned(String table_name,int bookid);
	//查看今日是否已打卡
	SignRecord selTodaySign(int uid,Date sign_date);
	int updSignRecord(int learned_num,int uid,Date sign_date);

}
