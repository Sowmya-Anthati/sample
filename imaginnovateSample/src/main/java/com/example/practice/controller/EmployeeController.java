package com.example.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.entity.EmployeeDto;
import com.example.practice.model.EmployeeResponseModel;
import com.example.practice.model.SatusModel;
import com.example.practice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/storeEmployeeDetails")
	public SatusModel createEmployee(@RequestBody EmployeeDto reqObj) {
		return employeeService.createEmployee(reqObj);
	}
	
	@GetMapping("/employeesTaxDeduction")
	public EmployeeResponseModel employeesTaxDeduction() {
		return employeeService.employeesTaxDeduction();
	}
	
}
