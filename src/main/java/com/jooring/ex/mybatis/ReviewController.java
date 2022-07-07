package com.jooring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jooring.ex.mybatis.bo.ReviewBO;
import com.jooring.ex.mybatis.model.Review;

@Controller
public class ReviewController {

	@Autowired
	private ReviewBO reviewBO;
	
	
	//id가 3인 리뷰 가져오기
	@ResponseBody
	@RequestMapping("/mybatis/ex01/1")
	public Review review(@RequestParam("id")int id) {
		
		Review review = reviewBO.getReview(id);
		
		return review;
		
	}
}
