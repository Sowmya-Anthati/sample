package com.example.practice.model;

import java.io.Serializable;

public class SatusModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7733734583099513560L;

	private int statusCode;
	private Boolean status;
	private String message;
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
