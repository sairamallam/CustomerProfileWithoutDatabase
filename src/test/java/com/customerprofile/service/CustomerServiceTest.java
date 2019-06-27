package com.customerprofile.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.customerprofile.IService.CustomerService;
import com.customerprofile.Model.Customer;
import com.customerprofile.dto.ResponseDto;
import com.customerprofile.dto.UpdateDto;
import com.customerprofile.exception.ApplicationException;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	List<Customer> customerList = null;

	@InjectMocks
	CustomerService customerService;

	Customer customer;

	@Before
	public void setUp() {
		customerList = new ArrayList<Customer>();
		customer = new Customer(2, "hari", 68969, "admin");
		customer = new Customer(1, "priya", 3456, "it");
		customer = new Customer(3, "priya", 3456, "it");
		customerList.add(customer);
	}

	@Test
	public void addCustomerTest() {

		ResponseDto actual = customerService.addCustomer(customer);
		assertEquals("Customer added sucessfully", actual.getMessage());

	}

	@Test
	public void updateCustomerTest() {

		UpdateDto updateDto = new UpdateDto();
		updateDto.setId(1);
		updateDto.setCustomername("priya");
		updateDto.setPhoneno(4567);
		updateDto.setRole("adminn");

		ResponseDto actual = customerService.updateCustomer(updateDto);
		assertEquals("Customer updated sucessfully", actual.getMessage());
	}

	@Test
	public void searchCustomerTest() {
		ResponseDto actual = customerService.searchCustomer(2);
		assertEquals("hari", actual.getCustomer().get().getCustomername());
	}

	@Test
	public void deleteCustomer() {
		ResponseDto actual = customerService.deleteCustomer(3);
		assertEquals("Customer deleted sucessfully", actual.getMessage());
	}

	@Test(expected = ApplicationException.class)
	public void updateCustomer_1() {
		UpdateDto updateDto = new UpdateDto();
		updateDto.setId(78);
		updateDto.setCustomername("priya");
		updateDto.setPhoneno(4567);
		updateDto.setRole("adminn");

		ResponseDto actual = customerService.updateCustomer(updateDto);
		assertEquals("Customer not found", actual.getMessage());
	}

	@Test(expected = ApplicationException.class)
	public void searchCustomer_1() {

		ResponseDto actual = customerService.searchCustomer(234);
		assertEquals("Customer not found", actual.getMessage());
	}
	
	@Test(expected = ApplicationException.class)
	public void deleteCustomer_1() {

		ResponseDto actual = customerService.deleteCustomer(234);
		assertEquals("Customer not found", actual.getMessage());
	}

}
