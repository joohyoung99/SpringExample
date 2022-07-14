package com.jooring.ex.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooring.ex.jsp.dao.UserDAO;
import com.jooring.ex.jsp.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO ;
	
	public int addUser(String name, String yyyymmdd, String introduce, String email) {
		
		return userDAO.insertUser(name, yyyymmdd, introduce, email);
	}
	
	//가장 최신 등록된 사용자 정보 얻어와
	public User getLastUser() {
		return userDAO.selectLastUser();
	}
	
	public int addUserWithId(User user) {
		
//		//객체로 insert
//		User user = new User();
//		user.setName(name);
//		user.setYyyymmdd(yyyymmdd);
//		user.setIntroduce(introduce);
//		user.setEmail(email);
		
		return userDAO.insertUserWithId(user);
		
	}

}
