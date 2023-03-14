package cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.dao.EmployeemainRepo;
import cdac.model.Employeemain;



@Service
public class EmployeemainServiceImp implements EmployeemainService{
	@Autowired
	EmployeemainRepo emrepo;
	
	@Override
	public Employeemain save(Employeemain employeemain) {
		return emrepo.save(employeemain);
	}

	@Override
	public void delete(int employee_no) {
		emrepo.deleteById(employee_no);
		
	}

	@Override
	public void update(Employeemain employeemain) {
		emrepo.save(employeemain);
		
	}

	@Override
	public List<Employeemain> showall() {
		return (List<Employeemain>)emrepo.findAll();
	}

	@Override
	public Employeemain findemployee(int employee_no) {
		Optional<Employeemain> opt=emrepo.findById(employee_no);
		return opt.get();
	}

}
