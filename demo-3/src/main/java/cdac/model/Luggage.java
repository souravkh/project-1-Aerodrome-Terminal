package cdac.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="luggage")
public class Luggage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int luggage_id;
	
	@ManyToOne
	@JoinColumn(name="Passenger_id")
	Passengeroffline passengeroffline;

	public int getLuggage_id() {
		return luggage_id;
	}

	public void setLuggage_id(int luggage_id) {
		this.luggage_id = luggage_id;
	}

	public Passengeroffline getPassenger() {
		return passengeroffline;
	}

	public void setPassenger(Passengeroffline passengeroffline) {
		this.passengeroffline = passengeroffline;
	}

	@Override
	public String toString() {
		return "Luggage [luggage_id=" + luggage_id + ", passengeroffline=" + passengeroffline + "]";
	}

	public Luggage(int luggage_id, Passengeroffline passengeroffline) {
		super();
		this.luggage_id = luggage_id;
		this.passengeroffline = passengeroffline;
	}
	
	public Luggage() {}
	
}
