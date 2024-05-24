package com.global.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.test.entity.Cart;
import com.global.test.entity.User;
import com.global.test.entity.WishList;
import com.global.test.model.StatusModel;
import com.global.test.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/save")
	public StatusModel createUser(@RequestBody User reqObj) {
		return userService.createUser(reqObj);
		
	}
	
	@PostMapping("/saveWishList")
	public StatusModel createWishList(@RequestBody WishList reqObj) {
		return userService.createWishList(reqObj);
		
	}
	
	@PostMapping("/addToCart")
	public StatusModel addToCart(@RequestBody Cart reqObj) {
		return userService.addToCart(reqObj);
		
	}
}
