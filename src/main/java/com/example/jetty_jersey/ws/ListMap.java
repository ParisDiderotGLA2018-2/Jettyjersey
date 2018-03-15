package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ListMapDAO {
	ListMap getMyMaps();
	ListMap getFriendMaps();
	ListMap getPublicMaps();
	void addListMap(ListMap instance);
	void editListMap(int id, ListMap instance);
	void deleteListMap(ListMap instance);
}

@Path("/index")
public class ListMap implements ListMapDAO {
	
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
	
	// webservices

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myMaps")
	public ListMap getMyMaps() {
		
		ListMap instance = new ListMap();
		User user = new User("Hamza", "MudaMuda");
		Map map1 = new Map("Carte des vacances", user, Visibility.PRIVATE);
		map1.ajouterUnLieu(new Location("Lieu 1", 30, 100));
		map1.ajouterUnLieu(new Location("Lieu 2", 70, 190));
		instance.ajouteruneMap(map1);
		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/frdMaps")
	public ListMap getFriendMaps() {
		
		ListMap instance = new ListMap();
		User user = new User("Horace", "MudaMuda");
		Map map1 = new Map("F�tes", user, Visibility.FRIENDS);
		map1.ajouterUnLieu(new Location("Concert", 300, 160));
		map1.ajouterUnLieu(new Location("Nightclub", 300, 200));
		User user2 = new User("Khawla", "MudaMuda");
		Map map2 = new Map("Liste des cafes", user2, Visibility.PUBLIC);
		map2.ajouterUnLieu(new Location("Cafe de la Gare", 50, 100));
		map2.ajouterUnLieu(new Location("Cafe de la Paix", 70, 80));
		instance.ajouteruneMap(map1);
		instance.ajouteruneMap(map2);
		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pubMaps")
	public ListMap getPublicMaps() {
		
		ListMap instance = new ListMap();
		User user = new User("Valentin", "MudaMuda");
		Map map1 = new Map("Chasse au tresor", user, Visibility.PUBLIC);
		map1.ajouterUnLieu(new Location("March�", 200, 100));
		map1.ajouterUnLieu(new Location("Bar", 70, 200));
		User user2 = new User("Benjamin", "MudaMuda");
		Map map2 = new Map("Liste des cafes", user2, Visibility.PUBLIC);
		map2.ajouterUnLieu(new Location("Cafe de la Gare", 50, 100));
		map2.ajouterUnLieu(new Location("Cafe de la Paix", 70, 80));
		instance.ajouteruneMap(map1);
		instance.ajouteruneMap(map2);
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/map/add/list")
	public void addListMap(ListMap instance) {
		
		System.out.println("addListMap done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/map/edit/list")
	public void editListMap(@FormParam("id") int id, ListMap instance) {
		
		System.out.println("editListMap done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/map/delete/list")
	public void deleteListMap(ListMap instance) {
		
		System.out.println("deleteListMap done");
	}

}
