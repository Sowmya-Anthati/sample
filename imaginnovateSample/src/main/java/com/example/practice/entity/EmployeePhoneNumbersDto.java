package com.example.practice.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employee_phone_numbers")
public class EmployeePhoneNumbersDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4753757635103821019L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="phone_no_id")
	private int phoneNoId;
	
	@Column(name="employee_id")
	private String employeeId;
	
	@NotBlank(message = "Phone number must not be blank")
    @Pattern(regexp="[0-9]+", message="Phone number must contain only digits")
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name = "is_active",columnDefinition = "INTEGER DEFAULT 1")
	private int isActive;

	@Column(name = "created_by",columnDefinition = "INTEGER DEFAULT 1")
	private int createdBy;

	@Column(name = "created_on",columnDefinition = "DATE DEFAULT CURRENT_DATETIME", insertable = false, updatable = false)
	private LocalDate createdOn;
}
