package com.example.practice.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@Entity
@Table(name = "employee")
public class EmployeeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8368619268128195205L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private String employeeId;

	@NotBlank(message = "First name must not be blank")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Last name must not be blank")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "Email must not be blank")
	@Email(message = "Invalid email format")
	@Column(name = "email")
	private String email;

	@NotNull(message = "Date of joining must not be null")
	@Column(name = "doj")
	private LocalDate doj;

	@PositiveOrZero(message = "Salary must be a positive or zero value")
	@Column(name = "salary")
	private double salaryPerMonth;
	
	@Column(name = "is_active",columnDefinition = "INTEGER DEFAULT 1")
	private int isActive;

	@Column(name = "created_by",columnDefinition = "INTEGER DEFAULT 1")
	private int createdBy;

	@Column(name = "created_on",columnDefinition = "DATE DEFAULT CURRENT_DATETIME")
	private LocalDate createdOn;

	@NotNull(message = "Phone numbers list must not be null")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private List<EmployeePhoneNumbersDto> phoneNumers;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public double getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setSalaryPerMonth(double salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public List<EmployeePhoneNumbersDto> getPhoneNumers() {
		return phoneNumers;
	}

	public void setPhoneNumers(List<EmployeePhoneNumbersDto> phoneNumers) {
		this.phoneNumers = phoneNumers;
	}
	
	

}
