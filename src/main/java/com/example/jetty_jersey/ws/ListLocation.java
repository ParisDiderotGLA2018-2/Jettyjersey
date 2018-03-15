package com.example.jetty_jersey.ws;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ListLocationDAO {
	ListLocation getListLocation();
	void addListLocation(ListLocation instance);
	void editListLocation(int id, ListLocation instance);
	void deleteListLocation(ListLocation instance);
}

@Path("/index")
public class ListLocation implements ListLocationDAO {
	
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
	
	// webservices

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/location/list")
	public ListLocation getListLocation() {
		
		ListLocation instance = new ListLocation();
		instance.ajouteruneLocation(new Location("Cafe de la Gare", 50, 100));
		instance.ajouteruneLocation(new Location("Cafe de la Paix", 70, 80));
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/location/add/list")
	public void addListLocation(ListLocation instance) {
		
		System.out.println("addListLocation done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/location/edit/list")
	public void editListLocation(int id, ListLocation instance) {
		
		System.out.println("editListLocation done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/location/delete/list")
	public void deleteListLocation(ListLocation instance) {
		
		System.out.println("deleteListLocation done");
	}

}
