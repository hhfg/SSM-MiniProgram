package com.yym.dao;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.User;
import com.yym.entity.WordBooks;

public interface UserDao {
    //	�����û�
	int insUser(User user);
	
	//ͨ��openid�����û���id
	//int getUserId(@Param("openid")String openid);
	
	//��personal_data���������û�
	//int insPersonalData(@Param("uid")int uid);

	//  �����û��ڱ��е�id
	//int selUserId(@Param("username")String username);
	//  �����û�ѡ��ĵ������id
	int setMyBookId(@Param("username")String username,@Param("bookid")int bookid);
	//  ��ȡ�û�ѡ��ĵ��������Ϣ
	WordBooks selBookByUser(@Param("username")String username);
	int insPersonalData(@Param("uid")int uid,@Param("learningDay")int learningDay,@Param("completedNum")int completedNum
			,@Param("haveToLearn")int haveToLearn,@Param("haveToReview")int haveToReview,@Param("endTime")String endTime);
}
