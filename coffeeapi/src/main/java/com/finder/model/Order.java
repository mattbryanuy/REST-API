package com.finder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	private int id;
	private List<Coffee> coffeeList = new ArrayList<Coffee>();
	private String status;
	private Date created;
	private Date updated;

	public Order(){
		
	}
	
	public Order(int id, String status, List<Coffee> coffeeList){
		this.id = id;
		this.status = status;
		this.coffeeList = coffeeList;
		this.created = new Date();
		this.updated = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public List<Coffee> getCoffeeList() {
		return coffeeList;
	}

	public void setCoffeeList(List<Coffee> coffeeList) {
		this.coffeeList = coffeeList;
	}
}
