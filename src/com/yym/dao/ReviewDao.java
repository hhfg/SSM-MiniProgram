package com.yym.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.UserWords;

public interface ReviewDao {
	List<UserWords> getReviewWords(@Param("table_name")String table_name,@Param("dates")Date dates);
	Set<String> getRanExplanation();
	Set<String> getRanWord();	
}
