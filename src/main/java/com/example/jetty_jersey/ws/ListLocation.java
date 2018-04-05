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
public class  ListLocation {
	public ArrayList<Location> list;
	
	// constructors
	
	public ListLocation() {
		this.list = new ArrayList<Location>();
	}
	
	public ListLocation(ArrayList<Location> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouteruneLocation(Location instance) {
		this.list.add(instance);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Location/list")
	public ListLocation getListLocation() {
		
		ListLocation instance = new ListLocation();
		instance.ajouteruneLocation(new Location("Cafe de la Gare", 50, 100));
		instance.ajouteruneLocation(new Location("Cafe de la Paix", 70, 80));
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Location/add/list")
	public void addListLocation(ListLocation instance) {
		
		System.out.println("addListLocation done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Location/edit/list")
	public void editListLocation(@FormParam("id") int id, ListLocation instance) {
		
		System.out.println("editListLocation done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Location/delete/list")
	public void deleteListLocation(ListLocation instance) {
		
		System.out.println("deleteListLocation done");
	}

}
