package com.jooring.ex.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooring.ex.database.dao.UsedGoodsDAO;
import com.jooring.ex.database.model.UsedGoods;

@Service //data 조작하기
public class UsedGoodsBO {

	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
		
		
		
		//used_goods 데이터 모두 가져오는 메소드
	public List<UsedGoods> getUsedGoodsList() {
	
		List<UsedGoods> list = usedGoodsDAO.selectUsedGoodsList();
		//데이터 조작(가져온 데이터 조작하기 )
		
		return list;
		
	}
}
