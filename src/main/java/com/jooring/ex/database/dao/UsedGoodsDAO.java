package com.jooring.ex.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jooring.ex.database.model.UsedGoods;

@Repository //mvc의 모델
public interface UsedGoodsDAO {
	
	//usedgoods에서 모든 데이터 조회
	public List<UsedGoods> selectUsedGoodsList();

}
