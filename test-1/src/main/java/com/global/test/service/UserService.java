package com.global.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.test.entity.Cart;
import com.global.test.entity.User;
import com.global.test.entity.WishList;
import com.global.test.model.StatusModel;
import com.global.test.repository.CartRepo;
import com.global.test.repository.UserRepo;
import com.global.test.repository.WishListRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	WishListRepo wishListRepo;
	
	@Autowired
	CartRepo cartRepo;
	
	public StatusModel createUser(User reqObj) {
	StatusModel resp=new StatusModel();
		
	User findByEmail = userRepo.findByEmail(reqObj.getEmail());
		
		if(findByEmail !=null) {
			resp.setMessage("existing email");
		}else {
			User save = userRepo.save(reqObj);
			if(save!=null) {
				resp.setMessage("user saved successfully");
			}else {
				resp.setMessage("failed to save");
			}
		}

		return resp;
	}

	public StatusModel createWishList(WishList reqObj) {
		StatusModel resp=new StatusModel();
		WishList save = wishListRepo.save(reqObj);
				if(save!=null) {
					resp.setMessage("WishList added successfully");
				}else {
					resp.setMessage("failed to add");
				}
			return resp;
		}

	public StatusModel addToCart(Cart reqObj) {
	
		StatusModel resp=new StatusModel();
		Cart save = cartRepo.save(reqObj);
				if(save!=null) {
					resp.setMessage("added into a cart successfully");
				}else {
					resp.setMessage("failed to add");
				}
			return resp;
	}

}
