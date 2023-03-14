package cdac.service;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import cdac.model.Vehicle;

public interface VehicleService {
	public Vehicle validate(String vehicle_no);
	public Vehicle savevehicle(Vehicle vehicle);
	public void delete(String vehicle_no);
	public List<Vehicle> showall();
	public int update(Vehicle vehicle);
	public void updateAmount(String vehicle_no,Date date_from,Date date_to,
			LocalTime from_time,LocalTime to_time);
	
	public List<Vehicle> getVehiclebyDate(Date date_from,Date date_to);
}
