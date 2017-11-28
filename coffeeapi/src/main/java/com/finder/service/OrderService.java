package com.finder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.finder.database.DatabaseStub;
import com.finder.model.Coffee;
import com.finder.model.Order;

public class OrderService {
	private DatabaseStub databaseStub = DatabaseStub.getInstance(); //get the singleton instance of the DatabaseStub class
	
	public List<Order> retrieveAllOrders(){
		List<Order> orderList = new ArrayList<Order>(databaseStub.getOrderMap().values());	
		return orderList;
	}
	
	public Order retrieveOrderByID(int id){
		Order order = databaseStub.getOrderMap().get(id);
		return order;
	}
	
	public Order addOrder(Order order){
		int id = databaseStub.orderMapIdIndex + 1; //get the id index for orderMap then + 1
		order.setId(id);
		databaseStub.getOrderMap().put(id, order);
		databaseStub.orderMapIdIndex++;	//increment the id index after adding
		return order;
	}
	
	public Order updateOrderByID(Order order){
		if(databaseStub.getOrderMap().containsKey(order.getId())){
			order.setUpdated(new Date());	//set the updated Date to the current date instance
			databaseStub.getOrderMap().put(order.getId(), order);
		}
		
		return order;
	}
	
	public void deleteOrderByID(int id){
		databaseStub.getOrderMap().remove(id);
	}
	
	public List<Coffee> retrieveCoffeesOfOrder(int id){
		Order order = databaseStub.getOrderMap().get(id);
		return order.getCoffeeList();
	}
	
	public Coffee retrieveCoffeeOfOrder(int orderId, int coffeeId){
		Order order = databaseStub.getOrderMap().get(orderId);
		for(Coffee coffee : order.getCoffeeList()){
			if(coffee.getId() == coffeeId){
				return coffee;
			}
		}
		return null;
	}
	
	public Coffee addCoffeeForOrder(int id, Coffee coffee){
		Order order = databaseStub.getOrderMap().get(id);
		int coffeeId = databaseStub.coffeeMapIdIndex + 1;
		coffee.setId(coffeeId);
		order.getCoffeeList().add(coffee);	//add the coffee in the order with the correct id
		databaseStub.getCoffeeMap().put(coffeeId, coffee);	//add the coffee in the map of coffees
		databaseStub.coffeeMapIdIndex++;
		return coffee;
	}
	
	public void deleteCoffeeOfOrder(int orderId, int coffeeId){
		Order order = databaseStub.getOrderMap().get(orderId);
		Iterator<Coffee> iterator = order.getCoffeeList().iterator();
		
		while(iterator.hasNext()){
			Coffee cof = iterator.next();
			if(cof.getId() == coffeeId){
				iterator.remove();
				break;
			}
		}
	}
	
	public Coffee updateCoffeeOfOrder(int orderId, Coffee coffee){
		Order order = databaseStub.getOrderMap().get(orderId);
		for(Coffee cof : order.getCoffeeList()){
			if(cof.getId() == coffee.getId()){ 
				cof.setType(coffee.getType());
				cof.setCreated(coffee.getCreated());
				cof.setUpdated(new Date());
			}
		}
		return coffee;
	}
}
