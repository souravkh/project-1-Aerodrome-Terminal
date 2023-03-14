package cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.dao.Employee3PRepo;
import cdac.model.Employee3P;


@Service
public class Employee3PServiceimpl implements Employee3PService{
	@Autowired
	Employee3PRepo e3repo;
	
	@Override
	public Employee3P save(Employee3P employee3p) {
		return e3repo.save(employee3p);
	}

	@Override
	public List<Employee3P> showall3pEmployee() {
		return (List<Employee3P>)e3repo.findAll();
	}

	@Override
	public String update(Employee3P employee3p) {
		e3repo.save(employee3p);
		return null;
	}

	@Override
	public Employee3P find3p(String employee_id) {
		Optional<Employee3P> e=e3repo.findById(employee_id);
		if(e.isEmpty()) {return null;}
		else {return e.get();}
	}

	@Override
	public void delete(String employee_id) {
		e3repo.deleteById(employee_id);
		
	}

}
