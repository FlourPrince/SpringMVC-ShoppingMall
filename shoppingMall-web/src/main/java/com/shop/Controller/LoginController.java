package com.shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/index")
public class LoginController {

	
	@RequestMapping(path="/login")
	public String login() {
		
		return "admin";
	}
}
