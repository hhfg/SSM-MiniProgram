package com.yym.service;

import java.util.List;

import com.yym.entity.BooksType;
import com.yym.entity.WordBooks;

public interface BooksService {
    //	查找单词书的所有类型
	List<BooksType> selAllType();
    //	按类型查找单词书
	List<WordBooks> selByType(int bid);
	//  通过id查找单词书
	WordBooks selBookById(int id);
}
