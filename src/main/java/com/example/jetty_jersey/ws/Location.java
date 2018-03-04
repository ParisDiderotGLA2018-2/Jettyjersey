package com.example.jetty_jersey.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface LocationDAO {
	LocationClass getLocation();
	void retrieveLocation(LocationClass instance);
}

class LocationClass {
	public int coordX;
	public int coordY;
	public String name;
	
	public LocationClass(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.name = "Nouvel endroit";
	}
	
	public LocationClass(int coordX, int coordY, String name) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.name = name;
	}
}

@Path("/index")
public class Location implements LocationDAO {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/location")
	public LocationClass getLocation() {
		
		LocationClass instance = new LocationClass(50, 100, "Cafe de la Gare");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/location")
	public void retrieveLocation(LocationClass instance) {
		System.out.println(instance.name);
	}

}
