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
	
	public static enum Visibilite {
		PUBLIC,
		FRIENDS,
		PRIVATE;
	}
	
	static class MapClass {
		public Visibilite visibilite;
		public String name;
		public User user;
		
		public MapClass(Visibilite visibilite, String name, User user) {
			this.visibilite = visibilite;
			this.name = name;
			this.user = user;
		}
	}
	
	MapClass getMap();
	List<MapClass> getMyMaps();
	List<MapClass> getPubMaps();
	List<MapClass> getFrdMaps();
	void retrieveMap(MapClass instance);
}

@Path("/index")
public class Map implements MapDAO {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map")
	public MapClass getMap() {
		
		MapClass instance = new MapClass(Visibilite.PUBLIC, "Cafes", new UserClass("Baptiste"));

		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myMaps")
	public List<MapClass> getMyMaps() {
		
		UserClass me = new UserClass("Benjamin");
		MapClass map1 = new MapClass(Visibilite.PUBLIC, "Cafés", me);
		MapClass map2 = new MapClass(Visibilite.PRIVATE, "Vacances", me);
		
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
		MapClass map1 = new MapClass(Visibilite.PUBLIC, "Cafés", user1):
		MapClass map2 = new MapClass(Visibilite.PUBLIC, "Places to go with friends", user2);
		MapClass map3 = new MapClass(Visibilite.PUBLIC, "Parties", user3);
		
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
		MapClass map1 = new MapClass(Visibilite.FRIENDS, "Cafés", user1):
		MapClass map2 = new MapClass(Visibilite.PUBLIC, "Places to go with friends", user2);
		MapClass map3 = new MapClass(Visibilite.FRIENDS, "Parties", user3);
		
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
