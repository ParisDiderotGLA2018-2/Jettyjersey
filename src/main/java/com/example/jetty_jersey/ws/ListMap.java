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
public class  ListMap {
	public ArrayList<Map> list;
	
	// constructors
	
	public ListMap() {
		this.list = new ArrayList<Map>();
	}
	
	public ListMap(ArrayList<Map> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouteruneMap(Map instance) {
		this.list.add(instance);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myMaps")
	public ListMap getMyMaps() {
		
		ListMap instance = new ListMap();
		User user = new User("Hamza", "MudaMuda");
		Map Map1 = new Map("Carte des vacances", user, Visibility.PRIVATE);
		Map1.ajouterUnLieu(new Location("Lieu 1", 30, 100));
		Map1.ajouterUnLieu(new Location("Lieu 2", 70, 190));
		instance.ajouteruneMap(Map1);
		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/frdMaps")
	public ListMap getFriendsMaps() {
		
		ListMap instance = new ListMap();
		User user = new User("Horace", "MudaMuda");
		Map Map1 = new Map("F�tes", user, Visibility.FRIENDS);
		Map1.ajouterUnLieu(new Location("Concert", 300, 160));
		Map1.ajouterUnLieu(new Location("Nightclub", 300, 200));
		User user2 = new User("Khawla", "MudaMuda");
		Map Map2 = new Map("Liste des cafes", user2, Visibility.PUBLIC);
		Map2.ajouterUnLieu(new Location("Cafe de la Gare", 50, 100));
		Map2.ajouterUnLieu(new Location("Cafe de la Paix", 70, 80));
		instance.ajouteruneMap(Map1);
		instance.ajouteruneMap(Map2);
		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pubMaps")
	public ListMap getPublicMaps() {
		
		ListMap instance = new ListMap();
		User user = new User("Valentin", "MudaMuda");
		Map Map1 = new Map("Chasse au tresor", user, Visibility.PUBLIC);
		Map1.ajouterUnLieu(new Location("March�", 200, 100));
		Map1.ajouterUnLieu(new Location("Bar", 70, 200));
		User user2 = new User("Benjamin", "MudaMuda");
		Map Map2 = new Map("Liste des cafes", user2, Visibility.PUBLIC);
		Map2.ajouterUnLieu(new Location("Cafe de la Gare", 50, 100));
		Map2.ajouterUnLieu(new Location("Cafe de la Paix", 70, 80));
		instance.ajouteruneMap(Map1);
		instance.ajouteruneMap(Map2);
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/add/list")
	public void addListMap(ListMap instance) {
		
		System.out.println("addListMap done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/edit/list")
	public void editListMap(@FormParam("id") int id, ListMap instance) {
		
		System.out.println("editListMap done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Map/delete/list")
	public void deleteListMap(ListMap instance) {
		
		System.out.println("deleteListMap done");
	}

}
