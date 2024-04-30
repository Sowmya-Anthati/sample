package com.example.practice.service;

import com.example.practice.entity.EmployeeDto;
import com.example.practice.model.EmployeeResponseModel;
import com.example.practice.model.SatusModel;

public interface EmployeeService {

	public SatusModel createEmployee(EmployeeDto reqObj);

	public EmployeeResponseModel employeesTaxDeduction();

}
