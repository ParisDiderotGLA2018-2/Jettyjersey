package com.example.jetty_jersey.ws;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.example.jetty_jersey.ws.User;

interface MapDAO {
	MapClass getMap();
	ListMapClass getMyMaps();
	ListMapClass getPubMaps();
	ListMapClass getFrdMaps();
	void retrieveMap(MapClass instance);
}

class MapClass {
	public Visibility visibilite;
	public String name;
	public UserClass user;
	
	public MapClass(Visibility visibilite, String name, UserClass user) {
		this.visibilite = visibilite;
		this.name = name;
		this.user = user;
	}
}

class ListMapClass {
	public ArrayList<MapClass> list;
	
	public ListMapClass() {
		this.list = new ArrayList<MapClass>();
	}
	
	public ListMapClass(ArrayList<MapClass> list) {
		this.list = list;
	}
	
	public void addMap(MapClass map) {
		this.list.add(map);
	}
}

@Path("/index")
public class Map implements MapDAO {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/XMaps")
	public MapClass getMap() {
		
		MapClass instance = new MapClass(Visibility.PUBLIC, "Cafes", new UserClass("Baptiste"));

		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myMaps")
	public ListMapClass getMyMaps() {
		
		UserClass me = new UserClass("Benjamin");
		MapClass map1 = new MapClass(Visibility.PUBLIC, "Cafes", me);
		MapClass map2 = new MapClass(Visibility.PRIVATE, "Vacances", me);
		
		ListMapClass instance = new ListMapClass();
		instance.addMap(map1);
		instance.addMap(map2);

		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pubMaps")
	public ListMapClass getPubMaps() {
		
		UserClass user1 = new UserClass("Baptiste");
		UserClass user2 = new UserClass("Jude");
		UserClass user3 = new UserClass("Mary");
		MapClass map1 = new MapClass(Visibility.PUBLIC, "Cafes", user1);
		MapClass map2 = new MapClass(Visibility.PUBLIC, "Places to go with friends", user2);
		MapClass map3 = new MapClass(Visibility.PUBLIC, "Parties", user3);
		
		ListMapClass instance = new ListMapClass();
		instance.addMap(map1);
		instance.addMap(map2);
		instance.addMap(map3);

		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/frdMaps")
	public ListMapClass getFrdMaps() {
		
		UserClass user1 = new UserClass("Baptiste");
		UserClass user2 = new UserClass("Jude");
		UserClass user3 = new UserClass("Mary");
		MapClass map1 = new MapClass(Visibility.FRIENDS, "Cafes", user1);
		MapClass map2 = new MapClass(Visibility.PUBLIC, "Places to go with friends", user2);
		MapClass map3 = new MapClass(Visibility.FRIENDS, "Parties", user3);
		
		ListMapClass instance = new ListMapClass();
		instance.addMap(map1);
		instance.addMap(map2);
		instance.addMap(map3);

		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/map")
	public void retrieveMap(MapClass instance) {
		System.out.println(instance.name);
	}

}
