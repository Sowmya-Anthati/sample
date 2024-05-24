package com.global.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.test.entity.Admin;
import com.global.test.entity.Category;
import com.global.test.entity.LoginDto;
import com.global.test.entity.Product;
import com.global.test.model.StatusModel;
import com.global.test.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/save")
	public StatusModel createAdmin(@RequestBody Admin reqObj) {
		return adminService.createAdmin(reqObj);
		
	}
	
	@PostMapping("/login")
	public StatusModel login(@RequestBody LoginDto reqObj) {
		return adminService.login(reqObj);
	}

	@PostMapping("/saveCategory")
	public StatusModel createCategory(@RequestBody Category reqObj) {
		return adminService.createCategory(reqObj);
		
	}
	
	@PostMapping("/saveProduct")
	public StatusModel createProduct(@RequestBody Product reqObj) {
		return adminService.createProduct(reqObj);
		
	}
}
