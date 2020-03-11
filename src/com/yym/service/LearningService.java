package com.yym.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.UserWords;
import com.yym.entity.Words;

public interface LearningService {
	//�ӵ�������л�ȡ����
	List<Words> selWords(String table,int start,int end);
	//���������õ�������Ӧ�ı�
	String selTableName(String bookName);
	//�����ʲ��뵽�û��ĵ��ʱ���
	int insWords(String tabel_name,String word,String us_pron,String uk_pron,String us_mp3,String uk_mp3,String explanation
			,String val_ex1,String bil_ex1,String val_ex2,String bil_ex2,String val_ex3,String bil_ex3,String collocation,int completed,
			Date dates);
	 //��ȡ�û����ʱ��count�������ж��Ƿ������� 
	int getCount(String table_name);
	//���û����ʱ��в�ѯstatusΪ0������(0��ʾ��δѧϰ
	List<UserWords> getWords(String table_name);
}
