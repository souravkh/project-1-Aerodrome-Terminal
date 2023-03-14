package cdac.model;

import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "Passengeroffline")
public class Passengeroffline {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int passenger_id;
	
	String first_name;
	String last_name;
	float amount = 1000;
	
	
	String mobile_no;
	
	@ManyToOne
	@JoinColumn(name ="flight_no")
	Flight flight;

	@OneToMany(mappedBy="passengeroffline",cascade=CascadeType.ALL)
	Set<Luggage> luggage;


	@Override
	public String toString() {
		return "Passengeroffline [passenger_id=" + passenger_id + ", first_name=" + first_name + ", last_name="
				+ last_name + ", amount=" + amount + ", mobile_no=" + mobile_no + ", flight=" + flight + ", luggage="
				+ luggage + "]";
	}







	public Passengeroffline(int passenger_id, String first_name, String last_name, float amount,
			String mobile_no, Flight flight,
			Set<Luggage> luggage) {
		super();
		this.passenger_id = passenger_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.amount = amount;
		this.mobile_no = mobile_no;
		this.flight = flight;
		this.luggage = luggage;
	}







	public int getPassenger_id() {
		return passenger_id;
	}







	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
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







	public float getAmount() {
		return amount;
	}







	public void setAmount(float amount) {
		this.amount = amount;
	}







	public String getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}




	public Flight getFlight() {
		return flight;
	}







	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	public Set<Luggage> getLuggage() {
		return luggage;
	}







	public void setLuggage(Set<Luggage> luggage) {
		this.luggage = luggage;
	}







	public Passengeroffline() {
	};

}
