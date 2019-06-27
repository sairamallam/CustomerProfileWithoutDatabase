package com.customerprofile.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customerprofile.IService.CustomerService;
import com.customerprofile.Model.Customer;
import com.customerprofile.dto.ResponseDto;
import com.customerprofile.dto.UpdateDto;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/addcustomer")
	public ResponseEntity<ResponseDto> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<ResponseDto>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<ResponseDto> updateCustomer(@RequestBody UpdateDto updateDto) {
		return new ResponseEntity<ResponseDto>(customerService.updateCustomer(updateDto), HttpStatus.OK);
	}

	@GetMapping("/searchCustomer")
	public ResponseEntity<ResponseDto> searchCustomer(@RequestParam(value = "id", required = false) Integer id) {
		System.out.println("passed value" + id);
		return new ResponseEntity<ResponseDto>(customerService.searchCustomer(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<ResponseDto> deleteCustomer(@PathVariable int id) {
		return new ResponseEntity<ResponseDto>(customerService.deleteCustomer(id), HttpStatus.OK);
	}

	@GetMapping("/getCustomer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
}
