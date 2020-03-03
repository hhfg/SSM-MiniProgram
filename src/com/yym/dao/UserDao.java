package com.yym.dao;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.User;
import com.yym.entity.WordBooks;

public interface UserDao {
    //	插入用户
	int insUser(User user);
	
	//通过openid查找用户的id
	//int getUserId(@Param("openid")String openid);
	
	//在personal_data表中新增用户
	//int insPersonalData(@Param("uid")int uid);

	//  查找用户在表中的id
	//int selUserId(@Param("username")String username);
	//  更新用户选择的单词书的id
	int setMyBookId(@Param("username")String username,@Param("bookid")int bookid);
	//  获取用户选择的单词书的信息
	WordBooks selBookByUser(@Param("username")String username);
	int insPersonalData(@Param("uid")int uid,@Param("learningDay")int learningDay,@Param("completedNum")int completedNum
			,@Param("haveToLearn")int haveToLearn,@Param("haveToReview")int haveToReview,@Param("endTime")String endTime);
}
