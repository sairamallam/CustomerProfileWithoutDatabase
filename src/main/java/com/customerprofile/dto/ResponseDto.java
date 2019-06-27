package com.customerprofile.dto;

import java.util.List;
import java.util.Optional;

import com.customerprofile.Model.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResponseDto {
@JsonInclude(Include.NON_NULL)
private String message;
@JsonInclude(Include.NON_NULL)
private List<Customer> customers;
@JsonInclude(Include.NON_NULL)
private Optional<Customer> customer;

public String getMessage() {
	return message;
}

public ResponseDto() {
	super();
}



public Optional<Customer> getCustomer() {
	return customer;
}

public void setCustomer(Optional<Customer> customer) {
	this.customer = customer;
}

public List<Customer> getCustomers() {
	return customers;
}

public void setCustomers(List<Customer> customers) {
	this.customers = customers;
}

public ResponseDto(String message) {
	super();
	this.message = message;
}

public void setMessage(String message) {
	this.message = message;
}
}
