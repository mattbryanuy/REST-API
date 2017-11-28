package com.finder.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coffee {

	private int id;
	private String type;
	private Date created;
	private Date updated;
	
	public Coffee(){
		
	}

	public Coffee(int id, String type) {
		this.id = id;
		this.type = type;
		this.created = new Date();	//initialize with current Date
		this.updated = new Date();	//initialize with current Date
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
}
