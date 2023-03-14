package cdac.service;

import java.util.List;

import cdac.model.Food;


public interface FoodService {

	public Food savefooditems(Food food);
	public List<Food> showall();
	public void updatefood(Food food);
	public void deletefood(int food_id);
	public Food searchfooditem(int food_id);
	public List<Food> foodbycustomer(int customer_id);
}
