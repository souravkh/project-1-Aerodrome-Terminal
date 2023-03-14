package cdac.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cdac.model.Passengeroffline;



@Repository
public interface PassengerofflineRepo extends CrudRepository<Passengeroffline,Integer>{
	
//@Query(value="select p.passenger_id,p.mobile_no,f.flight_no,f.source,f.destination,f.arrival"
	//	+ ",f.destination,f.departure frompassengeroffline p "
		//+ "inner join flight f on p.flight_no=f.flight_no where p.passenger_id=?1", nativeQuery = true)
//public void findTicket(int passenger_id);

	
}
