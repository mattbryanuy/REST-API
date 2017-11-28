package com.finder.database;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.finder.model.Coffee;
import com.finder.model.Order;

public class DatabaseStub {

	private Map<Integer, Coffee> coffeeMap = new LinkedHashMap<Integer, Coffee>();
	private Map<Integer, Order> orderMap = new LinkedHashMap<Integer, Order>();
	public int coffeeMapIdIndex = 0;
	public int orderMapIdIndex = 0;

	private static DatabaseStub databaseStub = null;
	
	private DatabaseStub(){ //set as private so that no other class could instantiate an object of this class
		init();
	}
	
	public static DatabaseStub getInstance(){
		if(databaseStub == null){
			return databaseStub = new DatabaseStub();
		}else{
			return databaseStub;
		}
	}
	
	private void init(){
		//Coffee
		Coffee coffee1 = new Coffee(1, "flatwhite");
		Coffee coffee2 = new Coffee(2, "piccolo");
		Coffee coffee3 = new Coffee(3, "cappuccino");
		Coffee coffee4 = new Coffee(4, "flatwhite");
		Coffee coffee5 = new Coffee(5, "latte");
		Coffee coffee6 = new Coffee(6, "macchiato");
		Coffee coffee7 = new Coffee(7, "flatwhite");
		Coffee coffee8 = new Coffee(8, "longblack");
		Coffee coffee9 = new Coffee(9, "cappuccino");
		Coffee coffee10 = new Coffee(10, "macchiato");
		Coffee coffee11 = new Coffee(11, "latte");
		
		coffeeMap.put(coffee1.getId(), coffee1);
		coffeeMap.put(coffee2.getId(), coffee2);
		coffeeMap.put(coffee3.getId(), coffee3);
		coffeeMap.put(coffee4.getId(), coffee4);
		coffeeMap.put(coffee5.getId(), coffee5);
		coffeeMap.put(coffee6.getId(), coffee6);
		coffeeMap.put(coffee7.getId(), coffee7);
		coffeeMap.put(coffee8.getId(), coffee8);
		coffeeMap.put(coffee9.getId(), coffee9);
		coffeeMap.put(coffee10.getId(), coffee10);
		coffeeMap.put(coffee11.getId(), coffee11);
		
		coffeeMapIdIndex = coffeeMap.size();	//set the number of coffee as the ID index
		
		//Order
		List<Coffee> coffeeList1 = new ArrayList<Coffee>();
		coffeeList1.add(coffee1);
		coffeeList1.add(coffee2);
		Order order1 = new Order(1, "awaiting", coffeeList1);
		
		List<Coffee> coffeeList2 = new ArrayList<Coffee>();
		coffeeList2.add(coffee3);
		Order order2 = new Order(2, "awaiting", coffeeList2);
		
		List<Coffee> coffeeList3 = new ArrayList<Coffee>();
		coffeeList3.add(coffee4);
		coffeeList3.add(coffee5);
		coffeeList3.add(coffee6);
		coffeeList3.add(coffee7);
		Order order3 = new Order(3, "awaiting", coffeeList3);
		
		List<Coffee> coffeeList4 = new ArrayList<Coffee>();
		coffeeList4.add(coffee8);
		coffeeList4.add(coffee9);
		Order order4 = new Order(4, "awaiting", coffeeList4);
		
		List<Coffee> coffeeList5 = new ArrayList<Coffee>();
		coffeeList5.add(coffee10);
		coffeeList5.add(coffee11);
		Order order5 = new Order(5, "awaiting", coffeeList5);
		
		orderMap.put(order1.getId(), order1);
		orderMap.put(order2.getId(), order2);
		orderMap.put(order3.getId(), order3);
		orderMap.put(order4.getId(), order4);
		orderMap.put(order5.getId(), order5);
		
		orderMapIdIndex = orderMap.size();
	}
	
	public Map<Integer, Coffee> getCoffeeMap() {
		return coffeeMap;
	}

	public Map<Integer, Order> getOrderMap() {
		return orderMap;
	}
	

}
