package com.customerprofile.IService;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.customerprofile.Model.Customer;
import com.customerprofile.dto.ResponseDto;
import com.customerprofile.dto.UpdateDto;
import com.customerprofile.exception.ApplicationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService implements ICustomerService {

	private List<Customer> clist = new ArrayList<Customer>();

	private static List<Customer> customerList = new ArrayList<Customer>();

	static {
		parseJson();
	}

	@Override
	public ResponseDto addCustomer(Customer customer) {
		customerList.add(customer);
		return new ResponseDto("Customer added sucessfully");
	}

	@Override
	public ResponseDto updateCustomer(UpdateDto updateDto) {
		Optional<Customer> updatecustomer = customerList.stream().filter(c -> c.getId() == updateDto.getId()).findAny();

		if (!updatecustomer.isPresent())
			throw new ApplicationException("Customer not found");
		else {
			updatecustomer.get().setPhoneno(updateDto.getPhoneno());

			if (updateDto.getCustomername() != null && !updateDto.getCustomername().isEmpty())
				updatecustomer.get().setCustomername(updateDto.getCustomername());

			if (updateDto.getRole() != null && !updateDto.getRole().isEmpty())
				updatecustomer.get().setRole(updateDto.getRole());

			// customerList.set(, updatecustomer.)

			for (int i = 0; i < customerList.size(); i++) {
				if (customerList.get(i).getId() == updateDto.getId())
					customerList.set(i, updatecustomer.get());
			}
			return new ResponseDto("Customer updated sucessfully");
		}

	}

	@Override
	public ResponseDto searchCustomer(Integer id) {
		ResponseDto rs = new ResponseDto();
		System.out.println("passed id is" + id);

		if (id == null) {
			rs.setCustomers(parseJson());
			return rs;
		} else if ((customerList.stream().filter(c -> c.getId() == id).findAny().orElse(null)) == null) {

			throw new ApplicationException("Customer not found");
		} else {

			rs.setCustomer(customerList.stream().filter(c -> c.getId() == id).findAny());
			return rs;
		}

	}

	@Override
	public ResponseDto deleteCustomer(Integer id) {
		Optional<Customer> filteredList = customerList.stream().filter(c -> c.getId() == id).findAny();
		if (!filteredList.isPresent()) {
			throw new ApplicationException("Customer not found");
		} else {
			customerList.remove(filteredList.get());
			return new ResponseDto("Customer deleted sucessfully");
		}
	}

	public ResponseDto addCustomerList(List<Customer> customerlist) {
		customerlist.stream().forEach(c -> clist.add(c));
		return new ResponseDto("Customer added sucessfully");
	}

	public List<Customer> getAllCustomers() {

		// return parseJson();
		return customerList;
	}

	public ResponseDto updateCustomer(String attribute, String value) throws NoSuchFieldException, SecurityException {

		return new ResponseDto("Customer updated sucessfully");
	}

	public static List<Customer> parseJson() {

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/static/customer.json");
		try {
			customerList = objectMapper.readValue(inputStream, typeReference);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return customerList;

	}

}
