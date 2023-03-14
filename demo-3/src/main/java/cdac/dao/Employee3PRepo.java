package cdac.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cdac.model.Employee3P;


@Repository
public interface Employee3PRepo extends CrudRepository<Employee3P,String>{

}
