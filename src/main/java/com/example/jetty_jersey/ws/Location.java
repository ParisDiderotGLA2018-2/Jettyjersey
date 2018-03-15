package com.example.jetty_jersey.ws;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface LocationDAO {
	Location getLocation();
	void addLocation(Location instance);
	void editLocation(int id, Location instance);
	void deleteLocation(Location instance);
}

@Path("/index")
public class Location implements LocationDAO {
	
	public String name;
	public int posX;
	public int posY;
	public ListMessage listMessage;
	public ListImage listImage;

	
	public Location(String name, int posX, int posY) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.listMessage = new ListMessage();
		this.listImage = new ListImage();
	}
	
	// webservices

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/location")
	public Location getLocation() {
		
		Location instance = new Location("Cafe de la Gare", 50, 100);
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/location/add")
	public void addLocation(Location instance) {
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/location/edit")
	public void editLocation(int id, Location instance) {
		
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/location/delete")
	public void deleteLocation(Location instance) {
		System.out.println(instance.name);
	}

}
