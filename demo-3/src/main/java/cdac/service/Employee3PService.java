package cdac.service;

import java.util.List;

import cdac.model.Employee3P;



public interface Employee3PService {
public Employee3P save(Employee3P employee3p);
public List<Employee3P> showall3pEmployee();
public String update(Employee3P employee3p);
public Employee3P find3p(String employee_id );
public void delete(String employee_id);

}
