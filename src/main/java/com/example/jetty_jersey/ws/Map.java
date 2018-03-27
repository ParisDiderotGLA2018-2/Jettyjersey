package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface MapClassDAO {
	MapClass getMap();
	void addMap(MapClass instance);
	void editMap(int id, MapClass instance);
	void deleteMap(MapClass instance);
}

class MapClass {

	public String name;
	public UserClass creator;
	public Visibility visibilite;
	public ListLocationClass listLocationClass;
	public Date creationDate;

	// constructors

	public MapClass(String name, UserClass creator, Visibility visibilite) {
		this.name = name;
		this.creator = creator;
		this.visibilite = visibilite;
		this.listLocationClass = new ListLocationClass();
		Date date = new GregorianCalendar(2017, Calendar.FEBRUARY, 11).getTime();
		this.creationDate = date;
	}

	// methods

	public void ajouterUnLieu(LocationClass instance) {
		this.listLocationClass.ajouteruneLocationClass(instance);
	}

	public MapClass devientChasseAuTresor(MapClass instance) {

		instance.name = "Chasse au tresor";
		instance.ajouterUnLieu(new LocationClass("Marche", 200, 100));
		instance.ajouterUnLieu(new LocationClass("Bar", 70, 200));
		return instance;
	}

}

@Path("/index")
public class Map implements MapClassDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/MapClass")
	public MapClass getMap() {

		MapClass instance = new MapClass("Liste des cafes", new UserClass("Hamza", "MudaMuda"), Visibility.PUBLIC);
		instance.ajouterUnLieu(new LocationClass("Cafe de la Gare", 50, 100));
		instance.ajouterUnLieu(new LocationClass("Cafe de la Paix", 70, 80));
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MapClass/add")
	public void addMap(MapClass instance) {
		System.out.println(instance.name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MapClass/edit")
	public void editMap(@FormParam("id") int id, MapClass instance) {

		System.out.println(instance.name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MapClass/delete")
	public void deleteMap(MapClass instance) {
		System.out.println(instance.name);
	}

}
