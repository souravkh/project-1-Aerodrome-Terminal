package cdac.model;

import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Component
@Entity
@Table(name="Employeemain")
public class Employeemain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int employee_no;
	
	@NotBlank(message="First name is Mandatory")
	String first_name;
	@NotBlank(message="Last name is Mandatory")
	String last_name;
	@NotBlank(message="Please  enter role ")
	String role;
	
	@ManyToMany(mappedBy="employee",cascade=CascadeType.ALL)
	Set<Task> task;

	public int getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(int employee_no) {
		this.employee_no = employee_no;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Task> getTask() {
		return task;
	}

	public void setTask(Set<Task> task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "EmployeeMain [employee_no=" + employee_no + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", role=" + role + ", task=" + task + "]";
	}

	public Employeemain(int employee_no, String first_name, String last_name, String role, Set<Task> task) {
		
		this.employee_no = employee_no;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
		this.task = task;
	}

public Employeemain() {};
	
	
	
}
