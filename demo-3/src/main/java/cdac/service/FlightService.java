package cdac.service;

import java.util.List;

import cdac.model.Flight;


public interface FlightService{
public Flight flightSave(Flight flight );
public void deleteFlight(String flight_no);
public Flight findflight(String flight_no);
public void updateFlight(Flight flight);
public List<Flight> ShowallFlight(); 
public List<Flight> showFlightsource2destination(String source,String destination);
public void flightupdateavailable(String flight_no);
}
