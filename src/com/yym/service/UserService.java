package com.yym.service;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.User;
import com.yym.entity.WordBooks;

public interface UserService {
    //	�����û�
	int insUser(User user);
	
	//ͨ��openid�����û���id
	int getUserId(String openid);
	
	//��personal_data���������û�
	int insPersonalData(int uid,int learningDays);
	
	//  �����û��ڱ��е�id
	int selUserId(String nickName);
	
	//�����û���personal_data���е���Ϣ
	PersonalData selPersonalData(int uid);
	
    //  �����û�ѡ��ĵ������id
	int setMyBookId(String username,int bookid);
    //  ��ȡ�û�ѡ��ĵ��������Ϣ
	WordBooks selBookByUser(String username);
	
}
