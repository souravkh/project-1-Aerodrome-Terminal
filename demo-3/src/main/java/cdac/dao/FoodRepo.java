package cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cdac.model.Food;


@Repository
public interface FoodRepo extends CrudRepository<Food,Integer>{
	
	@Query(value="select * from food f where c.customerid=:c",nativeQuery=true)
	public List<Food> getbyfooddetailsbycustomerid(@Param("c") int customer_id);
}
