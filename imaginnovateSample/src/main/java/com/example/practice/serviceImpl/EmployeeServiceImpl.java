package com.example.practice.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.entity.EmployeeDto;
import com.example.practice.model.EmployeeResponseModel;
import com.example.practice.model.SatusModel;
import com.example.practice.model.TaxDeductionResponse;
import com.example.practice.repository.EmployeeRepository;
import com.example.practice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public SatusModel createEmployee(EmployeeDto reqObj) {
		SatusModel response = new SatusModel();
		try {

			if (null != reqObj) {
				EmployeeDto save = employeeRepository.save(reqObj);
				if (save != null) {
					response.setStatusCode(201);
					response.setStatus(true);
					response.setMessage("Employee Details Saved Successfully");
				} else {
					response.setStatusCode(200);
					response.setStatus(false);
					response.setMessage("Failed to save");
				}
			} else {
				response.setStatus(false);
				response.setMessage("your sending null values");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	
	
	

	@Override
	public EmployeeResponseModel employeesTaxDeduction() {
		EmployeeResponseModel response=new EmployeeResponseModel();
		 List<TaxDeductionResponse> taxList = new ArrayList<TaxDeductionResponse>();
		try {
			   LocalDate today = LocalDate.now();
//		       LocalDate financialYearStart = LocalDate.of(today.getYear(), 4, 1); 
               LocalDate lastDayOfFinancialYear = LocalDate.of(today.getYear() + 1, 3, 31);
			
			Optional<List<EmployeeDto>> optObj=employeeRepository.findByIsActive(1);
			
			if(optObj.isPresent()) {
				
			
				List<EmployeeDto> list=optObj.get();
				
				for(EmployeeDto employee:list) {

		            LocalDate dojAdjusted = employee.getDoj().withDayOfMonth(1); 

		            int monthsWorkedInFinancialYear = 0;
		            
			         while (!dojAdjusted.isAfter(lastDayOfFinancialYear)) {

			             monthsWorkedInFinancialYear++;

			             dojAdjusted = dojAdjusted.plusMonths(1);

			         }

			         int monthsInFinancialYear = Math.max(0, monthsWorkedInFinancialYear);

		            double totalSalary = employee.getSalaryPerMonth() * monthsInFinancialYear;

		            double taxAmount = 0;
		            
		            if (totalSalary > 250000 && totalSalary <= 500000) {

		                taxAmount = (totalSalary - 250000) * 0.05;

		            } else if (totalSalary > 500000 && totalSalary <= 1000000) {

		                taxAmount = 12500 + (totalSalary - 500000) * 0.1;

		            } else if (totalSalary > 1000000) {

		                taxAmount = 62500 + (totalSalary - 1000000) * 0.2;

		            }


		            double cessAmount = (totalSalary > 2500000) ? (totalSalary - 2500000) * 0.02 : 0;
		            
		            TaxDeductionResponse taxResp = new TaxDeductionResponse(

		                    employee.getEmployeeId(),

		                    employee.getFirstName(),

		                    employee.getLastName(),

		                    totalSalary,

		                    taxAmount,

		                    cessAmount

		                );

		                System.out.println(response.toString());
		                taxList.add(taxResp);

		            }
				response.setEmployeesTax(taxList);

			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
