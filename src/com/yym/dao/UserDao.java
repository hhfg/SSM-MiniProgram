package com.yym.dao;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.User;
import com.yym.entity.WordBooks;

public interface UserDao {
    //	�����û�
	int insUser(User user);
	
	//ͨ��openid�����û���id
	int getUserId(@Param("openid")String openid);
	
	//��personal_data���������û�
	int insPersonalData(@Param("uid")int uid,@Param("learningDays")int learningDays);

	//  �����û��ڱ��е�id
	int selUserId(@Param("nickName")String nickName);
	//�����û���personal_data���е���Ϣ
	PersonalData selPersonalData(@Param("uid")int uid);
	//  �����û�ѡ��ĵ������id
	int setMyBookId(@Param("username")String username,@Param("bookid")int bookid);
	//  ��ȡ�û�ѡ��ĵ��������Ϣ
	WordBooks selBookByUser(@Param("username")String username);
}
