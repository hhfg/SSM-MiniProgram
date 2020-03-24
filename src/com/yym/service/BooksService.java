package com.yym.service;

import java.util.List;


import com.yym.entity.BooksType;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;

public interface BooksService {
    //	查找单词书的所有类型
	List<BooksType> selAllType();
    //	按类型查找单词书
	List<WordBooks> selByType(int bid);
	//  通过id查找单词书
	WordBooks selBookById(int id);
	//获取单词书的单词
	List<Words> selAllWords(String table_name,int start,int end);
	//获取已学单词
	List<UserWords> selLearnedWords(String table_name);
}
