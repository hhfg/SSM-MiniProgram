package com.yym.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.UserWords;
import com.yym.entity.Words;

public interface LearningDao {
	//�ӵ�������л�ȡ����
	List<Words> selWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
	//���ݵ������id��ȡ����Ӧ�ı�
	String selTableName(@Param("id")int id);
	//�����ʲ��뵽�û��ĵ��ʱ���
	int insWords(@Param("table_name")String tabel_name,@Param("id")int id,@Param("word")String word,@Param("us_pron")String us_pron,
			@Param("uk_pron")String uk_pron,@Param("us_mp3")String us_mp3,@Param("uk_mp3")String uk_mp3,@Param("explanation")String explanation
			,@Param("val_ex1")String val_ex1,@Param("bil_ex1")String bil_ex1,@Param("val_ex2")String val_ex2,@Param("bil_ex2")String bil_ex2,
			@Param("val_ex3")String val_ex3,@Param("bil_ex3")String bil_ex3,@Param("collocation")String collocation,@Param("status")int status,
			@Param("dates")Date dates,@Param("bookid")int bookid);
	//��ȡ�û����ʱ��count�������ж��Ƿ������� -
	int getCount(@Param("table_name")String table_name);
	//�ӵ��ʱ��л�ȡstatus=0��δѧ�ĵ��� 
	List<UserWords> getWords(@Param("table_name")String table_name,@Param("status")int status,@Param("bookid")int bookid);
	//���õ���Ϊ��ѧstatus=0
	int updStatus(@Param("table_name")String table_name,@Param("status")int status,@Param("id")int id);
	// ��������ݿ�ȡ������¼
	Set<String> selExplanation();
	// ���û����ʱ��л�ȡ��ǰstatus=0�ĸ���
	int selLearningCount(@Param("table_name")String table_name);
	//���û����ʱ��л�ȡstatus=1�����ڲ����ڵ���ĵ��ʣ���Ҫ��ϰ�ĵ���
	List<UserWords> selReview(@Param("table_name")String table_name,@Param("dates")Date dates);
	//��ȡ��Ҫ��ϰ�ĵ���
	List<UserWords> selPractise(@Param("table_name")String table_name,@Param("dates")Date dates);
}
