package com.yym.service;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.User;
import com.yym.entity.WordBooks;

public interface UserService {
	User selUser(String openid);
    //	�����û�
	int insUser(User user);
	
	//ͨ��openid�����û���id
	int getUserId(String openid);
	
	//��personal_data���������û�
	int insPersonalData(int uid,int clockInDay,Date startUseDate);
	
	//  �����û��ڱ��е�id
	int getUserIdByName(String nickName);
	
	//�����û���personal_data���е���Ϣ
	PersonalData selPersonalData(int uid);
	
	//��������ѡ��ĵ������id
	int setMyBook(int bookid,int uid);
	
	//�����û���Ҫѧϰ�ĵ��ʺ�ѧϰ�ƻ���������
	int updPersonalData(PersonalData personalData);
	//�����û��ĵ��ʱ�
	int createUserWordTable(String tableName);
    //  �����û�ѡ��ĵ������id
	//int setMyBookId(String username,int bookid);
    //  ��ȡ�û�ѡ��ĵ��������Ϣ
	//WordBooks selBookByUser(String username);
	
}
