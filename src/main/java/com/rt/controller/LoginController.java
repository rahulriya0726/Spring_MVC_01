package com.rt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String selectEmployeeById(@RequestParam String userName, @RequestParam String password, HttpSession session,
			Model m) {

		if (userName.equals(password)) {
			session.setAttribute("user", userName);
		} else {
			m.addAttribute("errMsg", "Invalid Cred...");
			return "login";
		}

		return "home";
	}
	

	@RequestMapping("/inbox")
	public String inbox(HttpServletRequest req) {
		
		String name = (String) req.getSession().getAttribute("user");
		System.out.println(name);
		return "register";
	}

}
