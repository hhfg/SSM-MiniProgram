package com.yym.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.ReviewDao;
import com.yym.entity.UserWords;
import com.yym.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDao reviewDao;
	@Override
	public List<UserWords> getReviewWords(String table_name, Date dates) {
		// TODO Auto-generated method stub
		return reviewDao.getReviewWords(table_name, dates);
	}

}
