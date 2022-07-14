package com.jooring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jooring.ex.jsp.bo.UserBO;
import com.jooring.ex.jsp.model.User;
@RequestMapping("/jsp/user")
@Controller
public class UserController {
	
	//사용자가 파라미터를 통해서 전달한 데이터로 사용자 정보 저장
	
	@Autowired
	private UserBO userBO;
	
	@ResponseBody
	//@RequestMapping(path="/jsp/user/insert" , method=RequestMethod.POST)
	@PostMapping("/insert")
	public String addUser(
			@RequestParam("name") String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam(value="introduce" ,required=false) String introduce
			,@RequestParam(value="email", required=false) String email) {
		int count = userBO.addUser(name, yyyymmdd, introduce, email);
		
		return "삽입 결과: " + count;
		
	}
	
	
	@PostMapping("/insert_view")
	public String addUserView(
			@ModelAttribute User user,
			Model model) {
		
		int count = userBO.addUserWithId(user);
		model.addAttribute("result", user);
		return "jsp/userInfo";
		
		
	}
	
	
	@GetMapping("/input_view")
	public String userInputView() {
		
		return "jsp/userInput";
	}
	
	@GetMapping("/info")
	public String userInfo(Model model) {
		
		//가장 최신 사용자정보 
		
		User user = userBO.getLastUser();
		
		model.addAttribute("result",user);
		
		return "/jsp/userInfo";
	}
	
	
	
	
}
