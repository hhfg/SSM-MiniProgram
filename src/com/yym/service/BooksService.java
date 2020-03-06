package com.yym.service;

import java.util.List;

import com.yym.entity.BooksType;
import com.yym.entity.WordBooks;

public interface BooksService {
    //	���ҵ��������������
	List<BooksType> selAllType();
    //	�����Ͳ��ҵ�����
	List<WordBooks> selByType(int bid);
	//  ͨ��id���ҵ�����
	WordBooks selBookById(int id);
}
