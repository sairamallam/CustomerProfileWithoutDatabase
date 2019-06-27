package com.customerprofile.controller;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.customerprofile.Controller.CustomerController;
import com.customerprofile.IService.CustomerService;
import com.customerprofile.Model.Customer;
import com.customerprofile.dto.UpdateDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@InjectMocks
	private CustomerController customerController;

	private MockMvc mockmvc;

	@Mock
	private CustomerService customerService;

	List<Customer> customerList = null;
	Customer customer;

	@Before
	public void setUp() throws Exception {

		mockmvc = MockMvcBuilders.standaloneSetup(customerController).build();

		customerList = new ArrayList<Customer>();
		customer = new Customer(2, "hari", 68969, "admin");
		customer = new Customer(1, "priya", 3456, "it");
		customer = new Customer(3, "priya", 3456, "it");
		customerList.add(customer);

	}

	@Test
	public void testGetAll() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/getCustomer")).andExpect(status().isOk());

	}

	@Test
	public void testAddCustomer() throws Exception {

		mockmvc.perform(MockMvcRequestBuilders.post("/addcustomer").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(customer))).andExpect(status().isCreated());

	}

	@Test
	public void testSearchCustomer() throws Exception {

		mockmvc.perform(MockMvcRequestBuilders.get("/searchCustomer?id=1").contentType(MediaType.ALL)
				.accept(MediaType.ALL).content(asJsonString(customer))).andExpect(status().isOk());

	}

	@Test
	public void testUpdateCustomer() throws Exception {

		UpdateDto updateDto = new UpdateDto();
		updateDto.setId(1);
		updateDto.setCustomername("priya");
		updateDto.setPhoneno(4567);
		updateDto.setRole("adminn");

		mockmvc.perform(MockMvcRequestBuilders.put("/updateCustomer").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(updateDto))).andExpect(status().isOk());

	}

	@Test
	public void testDeleteCustomer() throws Exception {

		mockmvc.perform(MockMvcRequestBuilders.delete("/deleteCustomer/{id}", 1).contentType(MediaType.ALL)
				.accept(MediaType.ALL).content(asJsonString(customer))).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}