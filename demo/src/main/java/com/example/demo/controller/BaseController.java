package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class BaseController {

	@GetMapping("/login")
	public String lgInPage(ModelMap model) {
	   return "login";	
	}
	
	@PostMapping("/login")
	public String showLoginPage(ModelMap model,@RequestParam String name,@RequestParam String password) {
		
		boolean inValidUser = true;
		
		if(!inValidUser) {
	          model.put("errorMessage", "Invalid Credentials");
	            return "login";
	        }

	        model.put("name", name);
	        model.put("password", password);

	        return "inputData";
	    }

	@PostMapping("/inputData")
	public String inputDataPage(ModelMap model,@RequestParam String name,@RequestParam String email,
			@RequestParam String phoneNo) {
		
		System.out.println("name"+name+ "email"+email+"phoneNo"+phoneNo);
		
		boolean inValidUser = true;
		
		if(!inValidUser) {
	          model.put("errorMessage", "Invalid Credentials");
	            return "login";
	        }

	        model.put("name", name);
	        model.put("email", email);
	        model.put("phoneNo", phoneNo);

	        return "welcome";
	    }
}
