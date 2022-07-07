package com.jooring.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jooring.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {
	
	//new_review 테이블에서 id 3인 리뷰 가져오기
	
	public Review selectReview(@Param("id")int id);
	
}
