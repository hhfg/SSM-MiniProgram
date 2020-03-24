package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.BooksType;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;

public interface BooksDao {
//	查找所有单词书的类型
	List<BooksType> selAllType();
//	按类型查找单词书名
	List<WordBooks> selByType(@Param("bid")int bid);
	//通过id查找单词书
	WordBooks selBookById(@Param("id")int id);
	//获取单词书的单词
	List<Words> selAllWords(@Param("table_name")String table_name,@Param("start")int start,@Param("end")int end);
}
