package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface LocationClassDAO {
	LocationClass getLocation();
	void addLocation(LocationClass instance);
	void editLocation(int id, LocationClass instance);
	void deleteLocation(LocationClass instance);
}

class LocationClass {
	
	public String name;
	public int posX;
	public int posY;
	public ListMessageClass listMessage;
	public ListImageClass listImage;

	
	public LocationClass(String name, int posX, int posY) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.listMessage = new ListMessageClass();
		this.listImage = new ListImageClass();
	}
	
}

@Path("/index")
public class Location implements LocationClassDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/LocationClass")
	public LocationClass getLocation() {
		
		LocationClass instance = new LocationClass("Cafe de la Gare", 50, 100);
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/LocationClass/add")
	public void addLocation(LocationClass instance) {
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/LocationClass/edit")
	public void editLocation(@FormParam("id") int id, LocationClass instance) {
		
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/LocationClass/delete")
	public void deleteLocation(LocationClass instance) {
		System.out.println(instance.name);
	}

}
