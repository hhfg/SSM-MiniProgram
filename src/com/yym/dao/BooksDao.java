package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.BooksType;
import com.yym.entity.WordBooks;

public interface BooksDao {
//	查找所有单词书的类型
	List<BooksType> selAllType();
//	按类型查找单词书名
	List<WordBooks> selByType(@Param("type")String type);

}
