package com.jooring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jooring.ex.ajax.bo.NewUserBO;
import com.jooring.ex.ajax.model.NewUser;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
	
	//new_user 테이블 결과 보기
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<NewUser> userList  =newUserBO.getUserList();
		
		model.addAttribute("userList", userList);
		return "ajax/userList"; 
	}
	
	
	//이름, 생년월일, 자기소개, 이메일 전달받고 저장
	@PostMapping("/insert")
	@ResponseBody
	public Map<String, String> addUser(
			@RequestParam("name")String name
			,@RequestParam("birthday")String birthday
			,@RequestParam("introduce") String introduce
			,@RequestParam("email") String email) {
		
		int count = newUserBO.addUser(name, birthday, introduce, email);
		//{"result":"success"}
		
		Map<String,String> result = new HashMap<>();
		
		
		if(count == 1) {
			//정상상태
			//{"result":"success"}
			result.put("result","success");
			
		
		}else {
			//문제상태
			//{"result":"fail"}
			result.put("result", "fail");
		}
		
		return result;
		
	
	
	}
	
	@GetMapping("/input")
	public String userInput() {
		
		return "ajax/userInput";
	}

}
