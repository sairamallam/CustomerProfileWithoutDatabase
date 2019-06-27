package com.customerprofile.IService;

import java.util.List;

import com.customerprofile.Model.Customer;
import com.customerprofile.dto.ResponseDto;
import com.customerprofile.dto.UpdateDto;

public interface ICustomerService {

	public ResponseDto addCustomer(Customer customer);

	public ResponseDto updateCustomer(UpdateDto updateDto);

	public ResponseDto searchCustomer(Integer id);

	public ResponseDto deleteCustomer(Integer id);
	public ResponseDto addCustomerList(List<Customer> clist);
}
