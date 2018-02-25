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
	List<MapClass> getMyMaps();
	List<MapClass> getPubMaps();
	List<MapClass> getFrdMaps();
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

@Path("/index")
public class Map implements MapDAO {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map")
	public MapClass getMap() {
		
		MapClass instance = new MapClass(Visibility.PUBLIC, "Cafes", new UserClass("Baptiste"));

		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myMaps")
	public List<MapClass> getMyMaps() {
		
		UserClass me = new UserClass("Benjamin");
		MapClass map1 = new MapClass(Visibility.PUBLIC, "Caf�s", me);
		MapClass map2 = new MapClass(Visibility.PRIVATE, "Vacances", me);
		
		List<MapClass> instance = new ArrayList<MapClass>();
		instance.add(map1);
		instance.add(map2);

		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pubMaps")
	public List<MapClass> getPubMaps() {
		
		UserClass user1 = new UserClass("Baptiste");
		UserClass user2 = new UserClass("Jude");
		UserClass user3 = new UserClass("Mary");
		MapClass map1 = new MapClass(Visibility.PUBLIC, "Caf�s", user1);
		MapClass map2 = new MapClass(Visibility.PUBLIC, "Places to go with friends", user2);
		MapClass map3 = new MapClass(Visibility.PUBLIC, "Parties", user3);
		
		List<MapClass> instance = new ArrayList<MapClass>();
		instance.add(map1);
		instance.add(map2);
		instance.add(map3);

		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/frdMaps")
	public List<MapClass> getFrdMaps() {
		
		UserClass user1 = new UserClass("Baptiste");
		UserClass user2 = new UserClass("Jude");
		UserClass user3 = new UserClass("Mary");
		MapClass map1 = new MapClass(Visibility.FRIENDS, "Caf�s", user1);
		MapClass map2 = new MapClass(Visibility.PUBLIC, "Places to go with friends", user2);
		MapClass map3 = new MapClass(Visibility.FRIENDS, "Parties", user3);
		
		List<MapClass> instance = new ArrayList<MapClass>();
		instance.add(map1);
		instance.add(map2);
		instance.add(map3);

		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/map")
	public void retrieveMap(MapClass instance) {
		System.out.println(instance.name);
	}

}
