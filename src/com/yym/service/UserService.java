package com.yym.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.SignRecord;
import com.yym.entity.User;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;

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
	//��ȡ������Ҫ��ϰ�ĵ�����
	int selReviewCount(String table_name,Date dates);
	//��ȡ������Ҫѧϰ�ĵ�����
	int selLearningCount(String table_name,Date dates,int bookid);
	//�ӵ�������л�ȡ����
	List<Words> selWords(String table,int start,int end);
	//�����ʲ��뵽�û��ĵ��ʱ���
	int insWords(String tabel_name,String word,String us_pron,String uk_pron,String us_mp3,String uk_mp3,String explanation
			,String val_ex1,String bil_ex1,String val_ex2,String bil_ex2,String val_ex3,String bil_ex3,String collocation,int status,
			Date dates,int bookid,int collect);
	//���ݵ������id��ȡ����Ӧ�ı�
	String selTableName(int id);
	////�鿴datesΪ�������ڵĸ���
	int selCountToday(String table_name,Date dates,int bookid);
	//�����򿨼�¼
	int insSignRecord(SignRecord signRecord);
	//�鿴�Ƿ����ض����ڵĴ򿨼�¼
	SignRecord selSignRecord(int uid,Date sign_date);
	//��ȡ��δѧϰ�ĵ���
	List<UserWords> selNotLearned(String table_name,int bookid);
	//�鿴�����Ƿ��Ѵ�
	SignRecord selTodaySign(int uid,Date sign_date);
	int updSignRecord(int learned_num,int uid,Date sign_date);

}
