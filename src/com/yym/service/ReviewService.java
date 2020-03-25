package com.yym.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.UserWords;

public interface ReviewService {
	List<UserWords> getReviewWords(String table_name,Date dates);
}
