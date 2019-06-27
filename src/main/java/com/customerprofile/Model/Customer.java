package com.customerprofile.Model;

public class Customer {

	public Customer(int id, String customername, double phoneno, String role) {
		super();
		this.id = id;
		this.customername = customername;
		this.phoneno = phoneno;
		this.role = role;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private String customername;
	private double phoneno;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

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

}
