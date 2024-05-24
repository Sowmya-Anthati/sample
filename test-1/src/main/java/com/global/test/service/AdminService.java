package com.global.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.test.entity.Admin;
import com.global.test.entity.Category;
import com.global.test.entity.LoginDto;
import com.global.test.entity.Product;
import com.global.test.entity.User;
import com.global.test.model.StatusModel;
import com.global.test.repository.AdminRepo;
import com.global.test.repository.CategoryRepo;
import com.global.test.repository.ProductRepo;
import com.global.test.repository.UserRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	ProductRepo productRepo;

	public StatusModel createAdmin(Admin reqObj) {
		StatusModel resp = new StatusModel();

		Admin findByEmail = adminRepo.findByEmail(reqObj.getEmail());

		if (findByEmail != null) {
			resp.setMessage("existing email");
		} else {
			Admin save = adminRepo.save(reqObj);
			if (save != null) {
				resp.setMessage("admin saved successfully");
			} else {
				resp.setMessage("failed to save");
			}
		}

		return resp;
	}

	public StatusModel login(LoginDto reqObj) {
		StatusModel resp = new StatusModel();

		if (reqObj.getRole().equalsIgnoreCase("admin")) {

			Admin findByEmail = adminRepo.findByEmail(reqObj.getEmail());

			if (reqObj.getEmail().equalsIgnoreCase(findByEmail.getEmail())
					&& reqObj.getPassword().equalsIgnoreCase(findByEmail.getPassword())) {

				resp.setMessage("admin login successfully");
			} else {
				resp.setMessage("invalid credentials");
			}

		} else if (reqObj.getRole().equalsIgnoreCase("user")) {

			User findByEmail = userRepo.findByEmail(reqObj.getEmail());

			if (reqObj.getEmail().equalsIgnoreCase(findByEmail.getEmail())
					&& reqObj.getPassword().equalsIgnoreCase(findByEmail.getPassword())) {

				resp.setMessage("user login successfully");
			} else {
				resp.setMessage("invalid credentials");
			}

		} else {
			resp.setMessage("invalid role");
		}
		return resp;
	}

	public StatusModel createCategory(Category reqObj) {
		StatusModel resp = new StatusModel();

		Category save = categoryRepo.save(reqObj);
		if (save != null) {
			resp.setMessage("Category saved successfully");
		} else {
			resp.setMessage("failed to save");
		}
		return resp;
	}

	public StatusModel createProduct(Product reqObj) {
		StatusModel resp = new StatusModel();

		Product save = productRepo.save(reqObj);
		if (save != null) {
			resp.setMessage("Product saved successfully");
		} else {
			resp.setMessage("failed to save");
		}
		return resp;
	}

}
