package cdac.model;

import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Component
@Entity
@Table(name="Task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int task_id;
	
	@NotBlank(message="Task is mandatory")
	String task;
	
	@NotBlank(message="Status is mandatory")
	String status;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "employeemain_task")
	Set<Employeemain> employee;

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Employeemain> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employeemain> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task=" + task + ", status=" + status + ", employee=" + employee + "]";
	}

	public Task(int task_id,  String task,
			 String status, Set<Employeemain> employee) {
		super();
		this.task_id = task_id;
		this.task = task;
		this.status = status;
		this.employee = employee;
	}
	
	public Task() {};
	
}
