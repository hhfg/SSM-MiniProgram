package com.yym.dao;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.User;
import com.yym.entity.WordBooks;

public interface UserDao {
    //	插入用户
	int insUser(User user);
	
	//通过openid查找用户的id
	int getUserId(@Param("openid")String openid);
	
	//在personal_data表中新增用户
	int insPersonalData(@Param("uid")int uid,@Param("learningDays")int learningDays);

	//  通过用户名查找用户在表中的id
	int getUserIdByName(@Param("nickName")String nickName);
	
	//查找用户在personal_data表中的信息
	PersonalData selPersonalData(@Param("uid")int uid);
	
	//设置用于选择的单词书的id
	int setMyBook(@Param("bookid")int bookid,@Param("uid")int uid);
	//更新用户需要学习的单词和学习计划截至日期
	int updPersonalData(@Param("haveToLearn")int haveToLearn,@Param("endTime")String endTime);
	
	//  更新用户选择的单词书的id
	//int setMyBookId(@Param("username")String username,@Param("bookid")int bookid);
	//  获取用户选择的单词书的信息
	//WordBooks selBookByUser(@Param("username")String username);
}
