package com.yym.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.SignRecord;
import com.yym.entity.UserWords;
import com.yym.entity.Words;

public interface LearningService {
	//�ӵ�������л�ȡ����
	List<Words> selWords(String table,int start,int end);
	//���ݵ������id�õ�������Ӧ�ı�
	String selTableName(int id);
	//�����ʲ��뵽�û��ĵ��ʱ���
	int insWords(String tabel_name,int id,String word,String us_pron,String uk_pron,String us_mp3,String uk_mp3,String explanation
			,String val_ex1,String bil_ex1,String val_ex2,String bil_ex2,String val_ex3,String bil_ex3,String collocation,int status,
			Date dates,int bookid);
	 //��ȡ�û����ʱ��count�������ж��Ƿ������� 
	int getCount(String table_name);
	//���û����ʱ��в�ѯstatusΪ0������(0��ʾ��δѧϰ
	List<UserWords> getWords(String table_name,int status,int bookid);
	//���õ���Ϊ��ѧstatus=0
	int updStatus(String table_name,int status,int id);
	// ��������ݿ�ȡ������¼
	Set<String> selExplanation();
	// ���û����ʱ��л�ȡ��ǰstatus=0�ĸ���
	int selLearningCount(String table_name);
	//��ȡ��Ҫ��ϰ�ĵ���
	List<UserWords> selReview(String table_name,Date dates);
	//��ȡ��Ҫ��ϰ�ĵ���
	List<UserWords> selPractise(String table_name,Date dates);

}
