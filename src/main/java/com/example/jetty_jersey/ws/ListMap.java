package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.jetty_jersey.ws.Map.MapClass;
import com.example.jetty_jersey.ws.User.UserClass;
import com.example.jetty_jersey.ws.Location.LocationClass;



@Path("/index")
public class  ListMap {
	public static class ListMapClass {
		public ArrayList<MapClass> list;
		
		// constructors
		
		public ListMapClass() {
			this.list = new ArrayList<MapClass>();
		}
		
		public ListMapClass(ArrayList<MapClass> list) {
			this.list = list;
		}
		
		// methods
		
		public void ajouteruneMap(MapClass instance) {
			this.list.add(instance);
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myMaps")
	public ListMapClass getMyMaps() {
		
		ListMapClass instance = new ListMapClass();
		UserClass user = new UserClass();
		user.login = "Hamza";
		user.password = "Mudamuda";
		MapClass Map1 = new MapClass("Carte des vacances", user, Visibility.PRIVATE);
		Map1.ajouterUnLieu(new LocationClass("Lieu 1", 30, 100));
		Map1.ajouterUnLieu(new LocationClass("Lieu 2", 70, 190));
		instance.ajouteruneMap(Map1);
		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/frdMaps")
	public ListMapClass getFriendsMaps() {
		
		ListMapClass instance = new ListMapClass();
		UserClass user = new UserClass();
		user.login = "Hamza";
		user.password = "Mudamuda";
		MapClass Map1 = new MapClass("F�tes", user, Visibility.FRIENDS);
		Map1.ajouterUnLieu(new LocationClass("Concert", 300, 160));
		Map1.ajouterUnLieu(new LocationClass("Nightclub", 300, 200));
		UserClass user2 = new UserClass();
		user.login = "Khawla";
		user.password = "Mudamuda";
		MapClass Map2 = new MapClass("Liste des cafes", user2, Visibility.PUBLIC);
		Map2.ajouterUnLieu(new LocationClass("Cafe de la Gare", 50, 100));
		Map2.ajouterUnLieu(new LocationClass("Cafe de la Paix", 70, 80));
		instance.ajouteruneMap(Map1);
		instance.ajouteruneMap(Map2);
		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pubMaps")
	public ListMapClass getPublicMaps() {
		
		ListMapClass instance = new ListMapClass();
		UserClass user = new UserClass();
		user.login = "Valentin";
		user.password = "Mudamuda";
		MapClass Map1 = new MapClass("Chasse au tresor", user, Visibility.PUBLIC);
		Map1.ajouterUnLieu(new LocationClass("March�", 200, 100));
		Map1.ajouterUnLieu(new LocationClass("Bar", 70, 200));
		UserClass user2 = new UserClass();
		user.login = "Benjamin";
		user.password = "Mudamuda";
		MapClass Map2 = new MapClass("Liste des cafes", user2, Visibility.PUBLIC);
		Map2.ajouterUnLieu(new LocationClass("Cafe de la Gare", 50, 100));
		Map2.ajouterUnLieu(new LocationClass("Cafe de la Paix", 70, 80));
		instance.ajouteruneMap(Map1);
		instance.ajouteruneMap(Map2);
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/add/list")
	public void addListMap(ListMapClass instance) {
		
		System.out.println("addListMap done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/edit/list")
	public void editListMap(@FormParam("id") int id, ListMapClass instance) {
		
		System.out.println("editListMap done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/delete/list")
	public void deleteListMap(ListMapClass instance) {
		
		System.out.println("deleteListMap done");
	}

}
