package com.yym.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.PersonalData;
import com.yym.entity.SignRecord;
import com.yym.entity.User;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;

public interface UserDao {
	//����openid�ж��Ƿ����û�
	User selUser(@Param("openid")String openid);
    //	�����û�
	int insUser(User user);
	
	//ͨ��openid�����û���id
	int getUserId(@Param("openid")String openid);
	
	//��personal_data���������û�
	int insPersonalData(@Param("uid")int uid,@Param("clockInDay")int clockInDay,
			@Param("startUseDate")Date startUseDate);

	//  ͨ���û��������û��ڱ��е�id
	int getUserIdByName(@Param("nickName")String nickName);
	
	//�����û���personal_data���е���Ϣ
	PersonalData selPersonalData(@Param("uid")int uid);
	
	//��������ѡ��ĵ������id
	int setMyBook(@Param("bookid")int bookid,@Param("uid")int uid);
	//�����û���Ҫѧϰ�ĵ��ʺ�ѧϰ�ƻ���������
	int updPersonalData(PersonalData personalData);
	//�����û��ĵ��ʱ�
	int createUserWordTable(@Param("tableName")String tableName);
	//  �����û�ѡ��ĵ������id
	//int setMyBookId(@Param("username")String username,@Param("bookid")int bookid);
	//  ��ȡ�û�ѡ��ĵ��������Ϣ
	//WordBooks selBookByUser(@Param("username")String username);
	int selReviewCount(@Param("table_name")String table_name,@Param("dates")Date dates,@Param("bookid")int bookid);
	int selLearningCount(@Param("table_name")String table_name,@Param("dates")Date dates,@Param("bookid")int bookid);
	//�ӵ�������л�ȡ����
	List<Words> selWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
	//�����ʲ��뵽�û��ĵ��ʱ���
	int insWords(@Param("table_name")String tabel_name,@Param("word")String word,@Param("us_pron")String us_pron,
				@Param("uk_pron")String uk_pron,@Param("us_mp3")String us_mp3,@Param("uk_mp3")String uk_mp3,@Param("explanation")String explanation
				,@Param("val_ex1")String val_ex1,@Param("bil_ex1")String bil_ex1,@Param("val_ex2")String val_ex2,@Param("bil_ex2")String bil_ex2,
				@Param("val_ex3")String val_ex3,@Param("bil_ex3")String bil_ex3,@Param("collocation")String collocation,@Param("status")int status,
				@Param("dates")Date dates,@Param("bookid")int bookid);
	//���ݵ������id��ȡ����Ӧ�ı�
	String selTableName(@Param("id")int id);
	//�鿴datesΪ�������ڵĸ���
	int selCountToday(@Param("table_name")String table_name,@Param("dates")Date dates,@Param("bookid")int bookid);
	//�����򿨼�¼
	int insSignRecord(SignRecord signRecord);
	//�鿴�Ƿ����ض����ڵĴ򿨼�¼
	SignRecord selSignRecord(@Param("uid")int uid,@Param("sign_date")Date sign_date);
	//��ȡδѧϰ�ĵ���
	List<UserWords> selNotLearned(@Param("table_name")String table_name);
	//�鿴�����Ƿ��Ѵ�
	SignRecord selTodaySign(@Param("uid")int uid,@Param("sign_date")Date sign_date);
}
