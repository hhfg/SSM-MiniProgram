package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.BooksType;
import com.yym.entity.WordBooks;

public interface BooksDao {
//	�������е����������
	List<BooksType> selAllType();
//	�����Ͳ��ҵ�������
	List<WordBooks> selByType(@Param("type")String type);

}
