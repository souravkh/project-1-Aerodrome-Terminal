package cdac.service;

import java.util.List;

import cdac.model.Luggage;



public interface LuggageService{

	public void deletebyid(int luggage_id);
	public Luggage updateLuggage(Luggage luggage);
	public Luggage saveLuggage(Luggage luggage);
	public List<Luggage> getallluggage();
	public Luggage findLuaggage(int luggage_id);
	public List<Luggage> findLuaggagebypassengerid(int passenger_id);
	//public List<Luggage> findluggagebyPassengerid(Passengeroffline passengeroffline);
}
