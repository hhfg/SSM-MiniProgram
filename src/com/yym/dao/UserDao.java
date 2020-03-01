package com.yym.dao;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.WordBooks;

public interface UserDao {
    //	�����û�
	int insUser(@Param("username")String username,@Param("profileUrl")String profileUrl);
	//  �����û��ڱ��е�id
	int selUserId(@Param("username")String username);
	//  �����û�ѡ��ĵ������id
	int setMyBookId(@Param("username")String username,@Param("bookid")int bookid);
	//  ��ȡ�û�ѡ��ĵ��������Ϣ
	WordBooks selBookByUser(@Param("username")String username);
	int insPersonalData(@Param("uid")int uid,@Param("learningDay")int learningDay,@Param("completedNum")int completedNum
			,@Param("haveToLearn")int haveToLearn,@Param("haveToReview")int haveToReview,@Param("endTime")String endTime);
}
