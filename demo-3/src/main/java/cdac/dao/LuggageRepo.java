package cdac.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cdac.model.Luggage;



@Repository
public interface LuggageRepo extends CrudRepository<Luggage,Integer>{		
	@Query(value="select * from Luggage l  where l.passenger_id=?1",nativeQuery=true)
	public List <Luggage> findByPassenger(int passenger_id);
}
