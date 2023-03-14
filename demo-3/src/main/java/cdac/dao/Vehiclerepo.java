package cdac.dao;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cdac.model.Vehicle;


@Repository
public interface Vehiclerepo extends CrudRepository<Vehicle,String> {
	
	@Procedure(value="updateamount")
	public void updateAmountProcedure(String vehicle_no,Date date_from,Date date_to,
			LocalTime from_time,LocalTime to_time);
	
	@Query("select v from Vehicle v where v.date_from between ?1 and ?2")
	public List<Vehicle> getbtwdate(Date date_from,Date date_to );
}
