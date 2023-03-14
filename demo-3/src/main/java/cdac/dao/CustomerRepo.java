package cdac.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cdac.model.Customer;


@Repository
public interface CustomerRepo extends CrudRepository<Customer,Integer>{

}
