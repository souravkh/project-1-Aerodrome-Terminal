package cdac.service;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.dao.Vehiclerepo;
import cdac.model.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	Vehiclerepo vrep;
	
	@Override
	public Vehicle validate(String vehicle_no) {
		Optional<Vehicle> opt= vrep.findById(vehicle_no);
		if(opt.isPresent()) {
		return opt.get();}
		else return null;
	}

	@Override
	public Vehicle savevehicle(Vehicle vehicle) {
		return vrep.save(vehicle);
	}

	@Override
	public void delete(String vehicle_no) {
		vrep.deleteById(vehicle_no);
		
	}

	@Override
	public List<Vehicle> showall() {
		return (List<Vehicle>)vrep.findAll();
	}

	@Override
	public int update(Vehicle vehicle) {
		vrep.save(vehicle);
		return 0;
	}

	@Override
	public void updateAmount(String vehicle_no, Date date_from, Date date_to, LocalTime from_time, LocalTime to_time) {
		vrep.updateAmountProcedure(vehicle_no, date_from, date_to, from_time, to_time);
		
	}

	@Override
	public List<Vehicle> getVehiclebyDate(Date date_from, Date date_to) {
		return (List<Vehicle>)vrep.getbtwdate(date_from, date_to);
	}

}
