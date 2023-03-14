package cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cdac.model.Flight;



@Repository
public interface FlightRepo extends CrudRepository<Flight,String> {
	
	@Procedure(value="updateavailable")
	public void updateAvailableonflight(String flight_no);
	
	
	@Query("Select f from Flight f where f.source=:n and f.destination=:c")
	public List<Flight> getBySourceandDestination(@Param("n")String source,@Param("c")String destination);
}
