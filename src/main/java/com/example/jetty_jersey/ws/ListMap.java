package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ListMapClassDAO {
	ListMapClass getMyMaps();
	ListMapClass getFriendsMaps();
	ListMapClass getPublicMaps();
	void addListMap(ListMapClass instance);
	void editListMap(int id, ListMapClass instance);
	void deleteListMap(ListMapClass instance);
}

class ListMapClass {
	
	public ArrayList<MapClass> list;
	
	// constructors
	
	public ListMapClass() {
		this.list = new ArrayList<MapClass>();
	}
	
	public ListMapClass(ArrayList<MapClass> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouteruneMapClass(MapClass instance) {
		this.list.add(instance);
	}
	
}

@Path("/index")
public class ListMap implements ListMapClassDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myMapClasss")
	public ListMapClass getMyMaps() {
		
		ListMapClass instance = new ListMapClass();
		UserClass user = new UserClass("Hamza", "MudaMuda");
		MapClass MapClass1 = new MapClass("Carte des vacances", user, Visibility.PRIVATE);
		MapClass1.ajouterUnLieu(new LocationClass("Lieu 1", 30, 100));
		MapClass1.ajouterUnLieu(new LocationClass("Lieu 2", 70, 190));
		instance.ajouteruneMapClass(MapClass1);
		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/frdMapClasss")
	public ListMapClass getFriendsMaps() {
		
		ListMapClass instance = new ListMapClass();
		UserClass user = new UserClass("Horace", "MudaMuda");
		MapClass MapClass1 = new MapClass("F�tes", user, Visibility.FRIENDS);
		MapClass1.ajouterUnLieu(new LocationClass("Concert", 300, 160));
		MapClass1.ajouterUnLieu(new LocationClass("Nightclub", 300, 200));
		UserClass user2 = new UserClass("Khawla", "MudaMuda");
		MapClass MapClass2 = new MapClass("Liste des cafes", user2, Visibility.PUBLIC);
		MapClass2.ajouterUnLieu(new LocationClass("Cafe de la Gare", 50, 100));
		MapClass2.ajouterUnLieu(new LocationClass("Cafe de la Paix", 70, 80));
		instance.ajouteruneMapClass(MapClass1);
		instance.ajouteruneMapClass(MapClass2);
		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pubMapClasss")
	public ListMapClass getPublicMaps() {
		
		ListMapClass instance = new ListMapClass();
		UserClass user = new UserClass("Valentin", "MudaMuda");
		MapClass MapClass1 = new MapClass("Chasse au tresor", user, Visibility.PUBLIC);
		MapClass1.ajouterUnLieu(new LocationClass("March�", 200, 100));
		MapClass1.ajouterUnLieu(new LocationClass("Bar", 70, 200));
		UserClass user2 = new UserClass("Benjamin", "MudaMuda");
		MapClass MapClass2 = new MapClass("Liste des cafes", user2, Visibility.PUBLIC);
		MapClass2.ajouterUnLieu(new LocationClass("Cafe de la Gare", 50, 100));
		MapClass2.ajouterUnLieu(new LocationClass("Cafe de la Paix", 70, 80));
		instance.ajouteruneMapClass(MapClass1);
		instance.ajouteruneMapClass(MapClass2);
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MapClass/add/list")
	public void addListMap(ListMapClass instance) {
		
		System.out.println("addListMapClass done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MapClass/edit/list")
	public void editListMap(@FormParam("id") int id, ListMapClass instance) {
		
		System.out.println("editListMapClass done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MapClass/delete/list")
	public void deleteListMap(ListMapClass instance) {
		
		System.out.println("deleteListMapClass done");
	}

}
