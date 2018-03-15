package com.example.jetty_jersey.ws;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface MapDAO {
	Map getMap();
	void addMap(Map instance);
	void editMap(int id, Map instance);
	void deleteMap(Map instance);
}

@Path("/index")
public class Map implements MapDAO {
	
	public String name;
	public User creator;
	public Visibility visibilite;
	public ListLocation listLocation;
	public Date creationDate;
	
	// constructors

	
	public Map(String name, User creator, Visibility visibilite) {
		this.name = name;
		this.creator = creator;
		this.visibilite = visibilite;
		this.listLocation = new ListLocation();
		Date date = new GregorianCalendar(2017, Calendar.FEBRUARY, 11).getTime();
		this.creationDate = date;
	}
	
	// methods
	
	public void ajouterUnLieu(Location instance) {
		this.listLocation.ajouteruneLocation(instance);
	}
	
	public Map createInstanceOfMap1() {	
		
		User user = new User("Benjamin", "MudaMuda");
		Map instance = new Map("Chasse au tresor", user, Visibility.PUBLIC);
		instance.ajouterUnLieu(new Location("Marché", 200, 100));
		instance.ajouterUnLieu(new Location("Bar", 70, 200));
		return instance;
	}
	
	public Map createInstanceOfMap2() {	
		
		User user = new User("Hamza", "MudaMuda");
		Map instance = new Map("Liste des cafes", user, Visibility.PUBLIC);
		instance.ajouterUnLieu(new Location("Cafe de la Gare", 50, 100));
		instance.ajouterUnLieu(new Location("Cafe de la Paix", 70, 80));
		return instance;
	}
	
	// webservices

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map")
	public Map getMap() {
		
		Map instance = createInstanceOfMap2();
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/map/add")
	public void addMap(Map instance) {
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/map/edit")
	public void editMap(int id, Map instance) {
		
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/map/delete")
	public void deleteMap(Map instance) {
		System.out.println(instance.name);
	}

}
