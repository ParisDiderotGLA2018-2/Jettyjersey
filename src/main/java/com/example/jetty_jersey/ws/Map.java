package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.jetty_jersey.ws.User.UserClass;
import com.example.jetty_jersey.ws.Location.LocationClass;




@Path("/index")
public class Map {
	public static class MapClass {
		public String name;
		public UserClass creator;
		public Visibility visibilite;
		public ListLocation listLocation;
		public Date creationDate;

		// constructors

		public MapClass(String name, UserClass creator, Visibility visibilite) {
			this.name = name;
			this.creator = creator;
			this.visibilite = visibilite;
			this.listLocation = new ListLocation();
			Date date = new GregorianCalendar(2017, Calendar.FEBRUARY, 11).getTime();
			this.creationDate = date;
		}
		
		/**
		 * @bug : comprend pas Valentin
		 * @param instance
		 */
		public void ajouterUnLieu(LocationClass instance) {
			//TODO : this.listLocation.ajouteruneLocation(instance);
		}
		
		public MapClass devientChasseAuTresor(MapClass instance) {
			instance.name = "Chasse au tresor";
			instance.ajouterUnLieu(new LocationClass("Marche", 200, 100));
			instance.ajouterUnLieu(new LocationClass("Bar", 70, 200));
			return instance;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Map")
	public MapClass getMap() {
		UserClass us = new UserClass();
		us.login = "Hamza";
		us.password = "Mudamuda";
		MapClass instance = new MapClass("Liste des cafes", us, Visibility.PUBLIC);
		instance.ajouterUnLieu(new LocationClass("Cafe de la Gare", 50, 100));
		instance.ajouterUnLieu(new LocationClass("Cafe de la Paix", 70, 80));
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/add")
	public void addMap(MapClass instance) {
		System.out.println(instance.name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/edit")
	public void editMap(@FormParam("id") int id, MapClass instance) {

		System.out.println(instance.name);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/delete")
	public void deleteMap(MapClass instance) {
		System.out.println(instance.name);
	}

}
