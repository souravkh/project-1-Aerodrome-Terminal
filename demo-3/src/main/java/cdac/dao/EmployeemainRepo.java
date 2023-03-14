package cdac.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cdac.model.Employeemain;


@Repository
public interface EmployeemainRepo extends CrudRepository<Employeemain,Integer>{

}
