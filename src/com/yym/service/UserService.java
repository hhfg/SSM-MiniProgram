package com.yym.service;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.User;
import com.yym.entity.WordBooks;

public interface UserService {
    //	插入用户
	int insUser(User user);
	//通过openid查找用户的id
	//int getUserId(String openid);
	//在personal_data表中新增用户
	//int insPersonalData(int uid);
	
	//  查找用户在表中的id
//	int selUserId(@Param("username")String username);
    //  更新用户选择的单词书的id
	int setMyBookId(String username,int bookid);
    //  获取用户选择的单词书的信息
	WordBooks selBookByUser(String username);
	int insPersonalData(int uid,int learningDay,int completedNum,int haveToLearn,int haveToReview,String endTime);
}
