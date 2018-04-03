package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ListLocationClassDAO {
	ListLocationClass getListLocation();
	void addListLocation(ListLocationClass instance);
	void editListLocation(int id, ListLocationClass instance);
	void deleteListLocation(ListLocationClass instance);
}

class ListLocationClass {
	
	public ArrayList<LocationClass> list;
	
	// constructors
	
	public ListLocationClass() {
		this.list = new ArrayList<LocationClass>();
	}
	
	public ListLocationClass(ArrayList<LocationClass> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouteruneLocationClass(LocationClass instance) {
		this.list.add(instance);
	}
	
}
@Path("/index")
public class ListLocation implements ListLocationClassDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/LocationClass/list")
	public ListLocationClass getListLocation() {
		
		ListLocationClass instance = new ListLocationClass();
		instance.ajouteruneLocationClass(new LocationClass("Cafe de la Gare", 50, 100));
		instance.ajouteruneLocationClass(new LocationClass("Cafe de la Paix", 70, 80));
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/LocationClass/add/list")
	public void addListLocation(ListLocationClass instance) {
		
		System.out.println("addListLocationClass done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/LocationClass/edit/list")
	public void editListLocation(@FormParam("id") int id, ListLocationClass instance) {
		
		System.out.println("editListLocationClass done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/LocationClass/delete/list")
	public void deleteListLocation(ListLocationClass instance) {
		
		System.out.println("deleteListLocationClass done");
	}

}
