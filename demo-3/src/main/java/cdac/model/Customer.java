package cdac.model;

import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Component
@Entity
@Table(name="Customer")
public class Customer{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int customer_id;
	
	@NotBlank(message="please enter name")
	String name;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	Set<Food> food;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Food> getFood() {
		return food;
	}

	public void setFood(Set<Food> food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", food=" + food + "]";
	}

	public Customer(int customer_id, String name, Set<Food> food) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.food = food;
	} 
	
	
	public Customer() {};
	
}
