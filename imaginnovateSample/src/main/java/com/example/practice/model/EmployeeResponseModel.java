package com.example.practice.model;

import java.util.List;

public class EmployeeResponseModel extends SatusModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1630239254375678684L;
	
	List<TaxDeductionResponse> employeesTax;
	

	public List<TaxDeductionResponse> getEmployeesTax() {
		return employeesTax;
	}

	public void setEmployeesTax(List<TaxDeductionResponse> employeesTax) {
		this.employeesTax = employeesTax;
	}
	
	

}
