package com.yym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.BooksDao;
import com.yym.entity.BooksType;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;
import com.yym.service.BooksService;

@Service
public class BooksServiceImpl implements BooksService{
	@Autowired
	private BooksDao booksDao;
	@Override
	public List<BooksType> selAllType() {
		// TODO Auto-generated method stub
		List<BooksType> list=booksDao.selAllType();
		return list;
	}
	@Override
	public List<WordBooks> selByType(int bid) {
		// TODO Auto-generated method stub
		List<WordBooks> list=booksDao.selByType(bid);
		return list;
	}
	@Override
	public WordBooks selBookById(int id) {
		// TODO Auto-generated method stub
		WordBooks w=booksDao.selBookById(id);
		return w;
	}
	@Override
	public List<Words> selAllWords(String table_name,int start,int end) {
		// TODO Auto-generated method stub
		return booksDao.selAllWords(table_name,start,end);
	}
	@Override
	public List<UserWords> selLearnedWords(String table_name) {
		// TODO Auto-generated method stub
		return booksDao.selLearnedWords(table_name);
	}
	@Override
	public List<UserWords> selCollectWords(String table_name) {
		// TODO Auto-generated method stub
		return booksDao.selCollectWords(table_name);
	}


}
