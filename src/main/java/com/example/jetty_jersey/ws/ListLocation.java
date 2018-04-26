package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.example.jetty_jersey.ws.Location.LocationClass;

@Path("/index")
public class  ListLocation {
	public static class ListLocationClass {
		public ArrayList<LocationClass> list;
		
		// constructors
		
		public ListLocationClass() {
			this.list = new ArrayList<LocationClass>();
		}
		
		public ListLocationClass(ArrayList<LocationClass> list) {
			this.list = list;
		}
		
		// methods
		
		public void ajouteruneLocation(LocationClass instance) {
			this.list.add(instance);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Location/list")
	public ListLocationClass getListLocation() {
		
		ListLocationClass instance = new ListLocationClass();
		instance.ajouteruneLocation(new LocationClass("Cafe de la Gare", 50, 100));
		instance.ajouteruneLocation(new LocationClass("Cafe de la Paix", 70, 80));
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Location/add/list")
	public void addListLocation(ListLocationClass instance) {
		
		System.out.println("addListLocation done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Location/edit/list")
	public void editListLocation(@FormParam("id") int id, ListLocationClass instance) {
		
		System.out.println("editListLocation done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Location/delete/list")
	public void deleteListLocation(ListLocationClass instance) {
		
		System.out.println("deleteListLocation done");
	}

}
