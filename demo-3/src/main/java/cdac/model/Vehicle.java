package cdac.model;


import java.time.LocalTime;
import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="Vehicle")
public class Vehicle {
	@Id
	@Size(min=9,message="Please enter valid size")
	String vehicle_no;
	float amount=0;
	
	@PastOrPresent(message="Please enter Correct Date")
	Date date_from;
	
	LocalTime from_time;
	
	//@FutureOrPresent(message="Please Enter Correct date")
	Date date_to;
	

	LocalTime to_time;
	
	@NotEmpty(message="Please enter the owner's Name")
	String owner_name;
	
	
	
	@Override
	public String toString() {
		return "Vehicle [vehicle_no=" + vehicle_no + ", amount=" + amount + ", date_from=" + date_from + 
				", date_to=" + date_to + ", from_time="
				+ from_time +  ", to_time=" + to_time + ", owner_name=" + owner_name + "]";
	}
	
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public Date getDate_from() {
		return date_from;
	}
	public void setDate_from(String date_from) {		
		Date d= Date.valueOf(date_from);
		this.date_from = d;	
	}
	public Date getDate_to() {
		return date_to;
	}
	public void setDate_to(String date_to) {
		Date d0= Date.valueOf(date_to);
		
		this.date_to = d0;
	}
	public LocalTime getFrom_time() {
		return from_time;
	}
	public void setFrom_time(LocalTime from_time) {
		
		this.from_time = from_time;
	}
	public LocalTime getTo_time() {
		return to_time;
	}
	public void setTo_time(LocalTime to_time) {

		this.to_time = to_time;
		
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount=amount;
	}
	
}

