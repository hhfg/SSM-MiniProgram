package com.yym.service;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.User;
import com.yym.entity.WordBooks;

public interface UserService {
    //	�����û�
	int insUser(User user);
	//ͨ��openid�����û���id
	//int getUserId(String openid);
	//��personal_data���������û�
	//int insPersonalData(int uid);
	
	//  �����û��ڱ��е�id
//	int selUserId(@Param("username")String username);
    //  �����û�ѡ��ĵ������id
	int setMyBookId(String username,int bookid);
    //  ��ȡ�û�ѡ��ĵ��������Ϣ
	WordBooks selBookByUser(String username);
	int insPersonalData(int uid,int learningDay,int completedNum,int haveToLearn,int haveToReview,String endTime);
}
