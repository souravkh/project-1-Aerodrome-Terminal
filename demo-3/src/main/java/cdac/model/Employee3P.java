package cdac.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;



@Component
@Entity
@Table(name="3rd_Party_Employee")
public class  Employee3P {
	
	@Id
	String employee_id;
	
	@NotBlank(message="Employee name is mandatory")
	String e_name; 
	@NotBlank(message="please enter Assgined mananger")
	String manager_id;
	
	@NotBlank(message="Service Company name is mandatory")
	String company_name; 
	@NotBlank(message="please enter the role ")
	String role; 
	@NotBlank(message="working line is mandatory")
	String Location;
	
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	@Override
	public String toString() {
		return "Employee3P [employee_id=" + employee_id + ", e_name=" + e_name + ", manager_id=" + manager_id
				+ ", company_name=" + company_name + ", role=" + role + ", Location=" + Location + "]";
	}
	
	
	
}
