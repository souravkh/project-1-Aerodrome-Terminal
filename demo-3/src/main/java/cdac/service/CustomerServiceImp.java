package cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.dao.CustomerRepo;
import cdac.model.Customer;


@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	CustomerRepo curepo;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return curepo.save(customer);
	}

	@Override
	public Customer findbycustomerid(int customer_id) {
		Optional<Customer> op= curepo.findById(customer_id);
		return op.get();
	}

	@Override
	public List<Customer> showallcustomer() {
		// TODO Auto-generated method stub
		return (List<Customer>)curepo.findAll();
	}

}
