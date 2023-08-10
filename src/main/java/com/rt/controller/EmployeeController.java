package com.rt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rt.entity.Employee;
import com.rt.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empServive;

	
	@RequestMapping("/")
	public String homePage() {
		return "login";
	}
	
	@RequestMapping("/registerForm")
	public String registerForm() {
		return "register";
	}
	
	@RequestMapping("/register")
	public String registerData(@ModelAttribute Employee e, Model m, HttpServletRequest req) {
		
		String user = (String) req.getSession().getAttribute("user");
		
		boolean isAdded = empServive.register(e,user);
		
		if(isAdded){
			m.addAttribute("successMsg","Employee Added Successfully...");
		}else{
			m.addAttribute("errMsg","Unable to Add...");
		}
		
		return "redirect:selectAllEmployees";
	}
	

	@RequestMapping("/updateForm")
	public String updateForm() {
		return "update";
	}
	
	@RequestMapping("/update")
	public String updateData(@ModelAttribute Employee e, Model m) {
		
		boolean isUpdated = empServive.update(e);
		
		if(isUpdated){
			m.addAttribute("successMsg","Employee Updated Successfully...");
		}else{
			m.addAttribute("errMsg","Unable to Update...");
		}
		
		return "update";
	}
	
	
	@RequestMapping("/selectEmployeeForm")
	public String selectEmployeeForm() {
		return "selectEmployee";
	}
	
	@RequestMapping("/selectEmpIloyeeById")
	public String selectEmployeeById(@RequestParam int id, Model m) {
		
		Employee e = empServive.selectEmployeeById(id);
		
		m.addAttribute("empData", e);
		
		return "display";
	}

	@RequestMapping("/selectAllEmployees")
	public String selectAllEmployees(Model m, HttpServletRequest req) {
		
		String user = (String) req.getSession().getAttribute("user");
		
		List<Employee> list = empServive.selectAllEmployees(user);
		
		m.addAttribute("empList", list);
		
		return "displayAll";
	}

}
