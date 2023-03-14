package cdac.service;

import java.util.List;

import cdac.model.Passengeroffline;


public interface PassengerService {
	
public Passengeroffline savepassenger(Passengeroffline passengeroffline);
public List<Passengeroffline> showallpassenger();
public void deletepassenger(int passenger_id);
//public void findticket(int passenger_id);
public Passengeroffline findusingpassengerofflineid(int passenger_id);
}
