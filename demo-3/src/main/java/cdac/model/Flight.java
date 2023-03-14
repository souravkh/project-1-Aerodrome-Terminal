package cdac.model;



import java.sql.Date;
import java.time.LocalTime;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;


@Component
@Entity
@Table(name="flight")
public class Flight {

	@Id
	String flight_no;
	@NotBlank(message="please enter valid flightname or company's name")
	String flight_name;
	String arrival;
	String departure;
	@NotBlank(message="please enter Source")
	String source;
	@NotBlank(message="please enter Destination")
	String destination;
	String days;
	LocalTime duration;
int Capacity;
int available;


@OneToMany(mappedBy="flight",cascade=CascadeType.ALL)
Set<Passengeroffline> passenger;


	public String getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Set<Passengeroffline> getPassenger() {
		return passenger;
	}

	public void setPassenger(Set<Passengeroffline> passenger) {
		this.passenger = passenger;
	}

	
	
	




public Flight() {
	
}

@Override
public String toString() {
	return "Flight [flight_no=" + flight_no + ", flight_name=" + flight_name + ", days=" + days + ", duration="
			+ duration + ", arrival=" + arrival + ", departure=" + departure + ", source=" + source
			+ ", destination=" + destination + ", Capacity=" + Capacity + ", available=" + available
			+ ", passenger=" + passenger + "]";
}




}