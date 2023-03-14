package cdac.service;

import java.util.List;

import cdac.model.Employeemain;



public interface EmployeemainService {
public Employeemain save(Employeemain employeemain);
public void delete(int employee_no);
public void update(Employeemain employeemain);
public List<Employeemain> showall();
public Employeemain findemployee(int employee_no);
	
}
