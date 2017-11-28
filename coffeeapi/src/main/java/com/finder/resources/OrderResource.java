package com.finder.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.finder.model.Coffee;
import com.finder.model.Order;
import com.finder.service.OrderService;

@Path("/orders")
public class OrderResource {
private OrderService orderService = new OrderService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrders(){
		return orderService.retrieveAllOrders();
	}
	
	@GET
	@Path("/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrder(@PathParam("orderId") int id){
		return orderService.retrieveOrderByID(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Order addOrder(Order order){
		return orderService.addOrder(order);
	}
	
	@PUT
	@Path("/{orderId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Order updateOrder(Order order, @PathParam("orderId") int id){
		order.setId(id);	//make sure that the orderId to be updated is the one with the id specified in the resource URL
		return orderService.updateOrderByID(order);
		
	}
	
	@DELETE
	@Path("/{orderId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteOrder(@PathParam("orderId") int id){
		orderService.deleteOrderByID(id);
		return "Deleted Order id: " + id;
	}
	
	@GET
	@Path("/{orderId}/coffees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coffee> getCoffeeListOfOrder(@PathParam("orderId") int id){
		return orderService.retrieveCoffeesOfOrder(id);
	}
	
	@GET
	@Path("/{orderId}/coffees/{coffeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Coffee getCoffeeOfOrder(@PathParam("orderId") int orderId, @PathParam("coffeeId") int coffeeId){
		return orderService.retrieveCoffeeOfOrder(orderId, coffeeId);
	}
	
	@POST
	@Path("/{orderId}/coffees")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Coffee addCoffeeForOrder(@PathParam("orderId") int id, Coffee coffee){
		return orderService.addCoffeeForOrder(id, coffee);
	}
	
	@DELETE
	@Path("/{orderId}/coffees/{coffeeId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCoffeeOfOrder(@PathParam("orderId") int orderId, @PathParam("coffeeId") int coffeeId){
		orderService.deleteCoffeeOfOrder(orderId, coffeeId);
		return "Deleted Coffee id: " + coffeeId +" of Order id: " + orderId;
	}
	
	@PUT
	@Path("/{orderId}/coffees/{coffeeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Coffee updateCoffeeOfOrder(@PathParam("orderId") int orderId, @PathParam("coffeeId") int coffeeId, Coffee coffee){
		coffee.setId(coffeeId);
		return orderService.updateCoffeeOfOrder(orderId, coffee);
	}
}
