package cdac.service;

import java.util.List;

import cdac.model.Customer;


public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	public Customer findbycustomerid(int customer_id);
	public List<Customer> showallcustomer();
}
