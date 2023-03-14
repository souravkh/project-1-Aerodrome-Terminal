package cdac.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Component
@Entity
@Table(name="Food")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int food_id;
	@NotBlank(message=" please enter food name")
	String food_name;
	int price;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	Customer customer;

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", food_name=" + food_name + ", price=" + price + ", customer=" + customer
				+ "]";
	}

	public Food(int food_id, String food_name, int price, Customer customer) {
		super();
		this.food_id = food_id;
		this.food_name = food_name;
		this.price = price;
		this.customer = customer;
	}
	
	public Food() {};
	
}
