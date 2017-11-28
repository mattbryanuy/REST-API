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
import com.finder.service.CoffeeService;


@Path("/coffees")
public class CoffeeResource {

	private CoffeeService coffeeService = new CoffeeService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coffee> getCoffees(){
		return coffeeService.retrieveAllCoffees();
	}
	
	@GET
	@Path("/{coffeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Coffee getCoffee(@PathParam("coffeeId") int id){
		return coffeeService.retrieveCoffeeByID(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Coffee addCoffee(Coffee coffee){
		return coffeeService.addCoffee(coffee);
	}
	
	@PUT
	@Path("/{coffeeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Coffee updateCoffee(Coffee coffee, @PathParam("coffeeId") int id){
		coffee.setId(id);	//make sure that the coffee to be updated is the one with the id specified in the resource URL
		return coffeeService.updateCoffeeByID(coffee);
		
	}
	
	@DELETE
	@Path("/{coffeeId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCoffee(@PathParam("coffeeId") int id){
		coffeeService.deleteCoffeeByID(id);
		return "Deleted Coffee id: " + id;
	}
}
