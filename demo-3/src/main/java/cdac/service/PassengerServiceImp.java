package cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.dao.PassengerofflineRepo;
import cdac.model.Passengeroffline;



@Service
public class PassengerServiceImp implements PassengerService{

	@Autowired
	PassengerofflineRepo prepo;
	
	@Override
	public Passengeroffline savepassenger(Passengeroffline passengeroffline) {
		// TODO Auto-generated method stub
		return prepo.save(passengeroffline);
	}

	@Override
	public List<Passengeroffline> showallpassenger() {
		return(List<Passengeroffline>)prepo.findAll();
	}

	@Override
	public void deletepassenger(int passenger_id) {
		prepo.deleteById(passenger_id);
	}

	//@Override
	//public void findticket(int passenger_id) {
		//prepo.findTicket(passenger_id);
		
	//}

	@Override
	public Passengeroffline findusingpassengerofflineid(int passenger_id) {
		Optional <Passengeroffline> op=prepo.findById(passenger_id);
		if(op.isEmpty()) {op=null; return null;}
		else
			{return op.get();}
	
	}
	
	
}
