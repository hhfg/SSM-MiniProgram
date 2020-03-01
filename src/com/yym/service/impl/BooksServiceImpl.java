package com.yym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.BooksDao;
import com.yym.entity.BooksType;
import com.yym.entity.WordBooks;
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
	public List<WordBooks> selByType(String type) {
		// TODO Auto-generated method stub
		List<WordBooks> list=booksDao.selByType(type);
		return list;
	}


}
