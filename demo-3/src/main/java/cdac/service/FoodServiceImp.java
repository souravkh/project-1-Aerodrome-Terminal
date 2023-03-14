package cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdac.dao.FoodRepo;
import cdac.model.Food;


@Service
public class FoodServiceImp implements FoodService {
	
	
	@Autowired
	FoodRepo frepo;
	
	
	@Override
	public Food savefooditems(Food food) {
		return frepo.save(food);
	}

	@Override
	public List<Food> showall() {
	
		return (List<Food>)frepo.findAll();
	}

	@Override
	public void updatefood(Food food) {
		frepo.save(food);
		
	}

	@Override
	public void deletefood(int food_id) {
		frepo.deleteById(food_id);
		
	}

	@Override
	public Food searchfooditem(int food_id) {
		Optional<Food> op = frepo.findById(food_id);
		return op.get();
	}

	@Override
	public List<Food> foodbycustomer(int customer_id) {
		return (List<Food>)frepo.getbyfooddetailsbycustomerid(customer_id);
	}

}
