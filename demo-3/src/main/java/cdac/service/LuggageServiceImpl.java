package cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.dao.LuggageRepo;
import cdac.model.Luggage;


@Service
public class LuggageServiceImpl implements LuggageService{
	
	@Autowired
	LuggageRepo lrepo;
	
	public void deletebyid(int luggage_id){
		lrepo.deleteById(luggage_id);
	}
	public Luggage updateLuggage(Luggage luggage){
		return lrepo.save(luggage);
	}
	public Luggage saveLuggage(Luggage luggage){
		return lrepo.save(luggage);
	}
	public List<Luggage> getallluggage(){
		return (List<Luggage>)lrepo.findAll();
	}
	public Luggage findLuaggage(int luggage_id){
		Optional<Luggage> opt= lrepo.findById(luggage_id);
		return opt.get();
	}
	//@Override
	//public List<Luggage> findluggagebyPassengerid(Passengeroffline passengeroffline) {
		//return (List<Luggage>)lrepo.findByPassengerId(passengeroffline);
	//}
	@Override
	public List<Luggage> findLuaggagebypassengerid(int passenger_id) {
		return(List<Luggage>)lrepo.findByPassenger(passenger_id);
		
}
}