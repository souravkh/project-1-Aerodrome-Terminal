package cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.dao.FlightRepo;
import cdac.model.Flight;



@Service
public class FlightSeriveImpl implements FlightService{
	@Autowired
	FlightRepo frepo;
	
	@Override
	public Flight flightSave(Flight flight) {
		
		return frepo.save(flight);
	}

	@Override
	public void deleteFlight(String flight_no) {
		frepo.deleteById(flight_no);
		
	}

	@Override
	public Flight findflight(String flight_no) {
		Optional<Flight> opt= frepo.findById(flight_no);
		return opt.get();
	}

	@Override
	public void updateFlight(Flight flight) {
		frepo.save(flight);
		
	}

	@Override
	public List<Flight> ShowallFlight() {		
		return (List<Flight>)frepo.findAll();
	}

	@Override
	public List<Flight> showFlightsource2destination(String source,String destination) {
		return (List<Flight>)frepo.getBySourceandDestination(source, destination);
	}

	@Override
	public void flightupdateavailable(String flight_no) {
		frepo.updateAvailableonflight(flight_no);
		
	}

}
