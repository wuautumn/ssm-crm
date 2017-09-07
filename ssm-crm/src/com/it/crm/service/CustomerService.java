package com.it.crm.service;

import java.util.List;

import com.it.crm.pojo.Customer;
import com.it.crm.pojo.QueryVo;
import com.it.crm.util.Page;

public interface CustomerService {
	public Page<Customer> getCustomerList(QueryVo queryVo);
	Customer getCustomerById(Long id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Long id);
}
