package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.dto.LoginDTO;
import com.nt.model.Login;
import com.nt.service.ILoginService;

@Controller
public class LoginController {
	@Autowired
	private ILoginService service;
	@GetMapping("/login")
public String displayLoginPage(Map<String, Object> map) {
	System.out.println("LoginController.displayLoginPage()");
	Login login=new Login();
	map.put("modelLog",login );
	return "login_page";
}
	@PostMapping("/login")
	public String showResult(Map<String,Object> map,@ModelAttribute("modelLog")Login log) {
		String result=null;
		map.get("modelLog");
		LoginDTO dto=new LoginDTO();
		BeanUtils.copyProperties(log, dto);
		//use service
		result=service.login(dto);
		map.put("result", result);
		return "login_page";
	}
}
