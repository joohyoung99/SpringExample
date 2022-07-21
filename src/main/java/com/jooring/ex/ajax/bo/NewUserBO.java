package com.jooring.ex.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooring.ex.ajax.dao.NewUserDAO;
import com.jooring.ex.ajax.model.NewUser;

@Service
public class NewUserBO {
	
	
	@Autowired
	private NewUserDAO newUserDAO;
	
	
	//new_user 체이블 모든 내용 얻어오기
	public List<NewUser> getUserList(){
		
		return newUserDAO.selectUserList();
	}
	
	public int addUser(String name, String birthday, String introduce, String email) {
		return newUserDAO.insertUser(name, birthday, introduce, email);
	}

}
