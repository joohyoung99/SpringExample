package com.jooring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jooring.ex.database.bo.UsedGoodsBO;
import com.jooring.ex.database.model.UsedGoods;

@Controller
public class UsedGoodsController {

	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	
	//used_goods 안에 있는 모든 내용을 json 으로 전달한다.
	@ResponseBody
	@RequestMapping("/database/ex01/1")
	public List<UsedGoods> ex01() {
		
		List<UsedGoods> list = usedGoodsBO.getUsedGoodsList();
		
		return list;
	}
}
