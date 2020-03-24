package com.shop.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/index")
public class LoginController {

	
	@RequestMapping(path="/login")
	public String adminPage(HttpServletRequest request,Model mv) throws Exception {
		System.out.println("入口登录测试");
		//1.获取当前Subject,调用SecurityUtils.getSubject
		Subject subject=SecurityUtils.getSubject();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		//2.判断当前用户是否已登录，调用
		if(!subject.isAuthenticated()) {
			UsernamePasswordToken upToken=new UsernamePasswordToken(name,password);
			upToken.setRememberMe(true);
			try {
				subject.login(upToken);
			}
			catch (UnknownAccountException e) {
				System.out.println("登录失败");
				return "fail";
			}
		}

		return "admin";
	}  

}
