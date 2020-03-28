package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.BooksType;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;

public interface BooksDao {
//	�������е����������
	List<BooksType> selAllType();
//	�����Ͳ��ҵ�������
	List<WordBooks> selByType(@Param("bid")int bid);
	//ͨ��id���ҵ�����
	WordBooks selBookById(@Param("id")int id);
	//��ȡ������ĵ���
	List<Words> selAllWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
	//��ȡ��ѧ����
	List<UserWords> selLearnedWords(@Param("table_name")String table_name);
	//��ȡ�ղصĵ���
	List<UserWords> selCollectWords(@Param("table_name")String table_name);
	//��ȡ������ѧ����
	List<UserWords> selPartWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
	int selLearnedCount(@Param("table_name")String table_name);
	int selCollectCount(@Param("table_name")String table_name);
}
