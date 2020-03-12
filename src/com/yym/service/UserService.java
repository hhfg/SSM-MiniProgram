package com.yym.service;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.User;
import com.yym.entity.WordBooks;

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
    //  更新用户选择的单词书的id
	//int setMyBookId(String username,int bookid);
    //  获取用户选择的单词书的信息
	//WordBooks selBookByUser(String username);
	
}
