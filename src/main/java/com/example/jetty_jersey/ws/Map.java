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
public class Map {

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
	/**
	 * @bug : comprend pas Valentin
	 * @param instance
	 */
	public void ajouterUnLieu(Location instance) {
		//TODO : this.listLocation.ajouteruneLocation(instance);
	}

	public Map devientChasseAuTresor(Map instance) {

		instance.name = "Chasse au tresor";
		instance.ajouterUnLieu(new Location("Marche", 200, 100));
		instance.ajouterUnLieu(new Location("Bar", 70, 200));
		return instance;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Map")
	public Map getMap() {

		Map instance = new Map("Liste des cafes", new User("Hamza", "MudaMuda"), Visibility.PUBLIC);
		instance.ajouterUnLieu(new Location("Cafe de la Gare", 50, 100));
		instance.ajouterUnLieu(new Location("Cafe de la Paix", 70, 80));
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/add")
	public void addMap(Map instance) {
		System.out.println(instance.name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/edit")
	public void editMap(@FormParam("id") int id, Map instance) {

		System.out.println(instance.name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/delete")
	public void deleteMap(Map instance) {
		System.out.println(instance.name);
	}

}
