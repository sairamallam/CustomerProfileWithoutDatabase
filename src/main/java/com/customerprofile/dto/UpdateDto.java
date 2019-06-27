package com.customerprofile.dto;

import org.springframework.lang.NonNull;

public class UpdateDto {

	@NonNull
	private Integer id;
	private String customername;
	private double phoneno;
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public double getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(double phoneno) {
		this.phoneno = phoneno;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
