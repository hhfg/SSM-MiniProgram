package com.yym.service;

import java.util.List;


import com.yym.entity.BooksType;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;

public interface BooksService {
    //	���ҵ��������������
	List<BooksType> selAllType();
    //	�����Ͳ��ҵ�����
	List<WordBooks> selByType(int bid);
	//  ͨ��id���ҵ�����
	WordBooks selBookById(int id);
	//��ȡ������ĵ���
	List<Words> selAllWords(String table_name,int start,int end);
	//��ȡ��ѧ����
	List<UserWords> selLearnedWords(String table_name);
}
