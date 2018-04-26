package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/index")
public class Location{
	public static class LocationClass {
		public String name;
		public int posX;
		public int posY;
		public ListMessage listMessage;
		public ListImage listImage;

		
		public LocationClass(String name, int posX, int posY) {
			this.name = name;
			this.posX = posX;
			this.posY = posY;
			this.listMessage = new ListMessage();
			this.listImage = new ListImage();
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Location")
	public LocationClass getLocation() {
		
		LocationClass instance = new LocationClass("Cafe de la Gare", 50, 100);
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Location/add")
	public void addLocation(LocationClass instance) {
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Location/edit")
	public void editLocation(@FormParam("id") int id, LocationClass instance) {
		
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Location/delete")
	public void deleteLocation(LocationClass instance) {
		System.out.println(instance.name);
	}

}
