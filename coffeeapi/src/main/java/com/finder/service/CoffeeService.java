package com.finder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.finder.database.DatabaseStub;
import com.finder.model.Coffee;

public class CoffeeService {
	

	private DatabaseStub databaseStub = DatabaseStub.getInstance(); //get the singleton instance of the DatabaseStub class
	
	public List<Coffee> retrieveAllCoffees(){
		List<Coffee> coffeeList = new ArrayList<Coffee>(databaseStub.getCoffeeMap().values());	
		return coffeeList;
	}
	
	public Coffee retrieveCoffeeByID(int id){
		Coffee coffee = databaseStub.getCoffeeMap().get(id);
		return coffee;
	}
	
	public Coffee addCoffee(Coffee coffee){
		int id = databaseStub.coffeeMapIdIndex + 1; //get the id index for coffeeMap then + 1
		coffee.setId(id);
		databaseStub.getCoffeeMap().put(id, coffee);
		databaseStub.coffeeMapIdIndex++;	//increment the id index after adding
		return coffee;
	}
	
	public Coffee updateCoffeeByID(Coffee coffee){
		if(databaseStub.getCoffeeMap().containsKey(coffee.getId())){	//check first if the map contains the coffee to be updated
			coffee.setUpdated(new Date());	//modify the Date attr 'updated' to the current date instance
			databaseStub.getCoffeeMap().put(coffee.getId(), coffee);
		}
		
		return coffee;
	}
	
	public void deleteCoffeeByID(int id){
		databaseStub.getCoffeeMap().remove(id);
	}
}
