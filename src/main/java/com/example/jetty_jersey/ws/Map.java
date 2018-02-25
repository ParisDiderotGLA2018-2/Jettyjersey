package com.example.jetty_jersey.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface MapDAO {
	static class MapClass {
		public Visibility visibility;
		public String name;
		public User user;
	}
	
	MapClass getMap();
	List<MapClass> getMyMaps();
	List<MapClass> getPubMaps();
	List<MapClass> getFrdMaps();
	void retrieveMap(MapClass instance);
}

@Path("/index")
public class Map implements MapDAO {
	
	public MapClass(Visibility visibility, String name, User user) {
		this.visibility = visibility;
		this.name = name;
		this.retrieveUser= user;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map")
	public MapClass getMap() {
		
		MapClass instance = new MapClass();
		instance.visibility = PUBLIC;
		instance.name = "Cafés";
		User person = new Map
		instance.user = person;

		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myMaps")
	public List<MapClass> getMyMaps() {
		
		UserClass me = new UserClass("Benjamin");
		MapClass map1 = new MapClass(PUBLIC, "Cafés", me):
		MapClass map2 = new MapClass(PRIVATE, "Vacances", me);
		
		List<MapClass> instance = new List<MapClass>();
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
		MapClass map1 = new MapClass(PUBLIC, "Cafés", user1):
		MapClass map2 = new MapClass(PUBLIC, "Places to go with friends", user2);
		MapClass map3 = new MapClass(PUBLIC, "Parties", user3);
		
		List<MapClass> instance = new List<MapClass>();
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
		MapClass map1 = new MapClass(FRIENDS, "Cafés", user1):
		MapClass map2 = new MapClass(PUBLIC, "Places to go with friends", user2);
		MapClass map3 = new MapClass(FRIENDS, "Parties", user3);
		
		List<MapClass> instance = new List<MapClass>();
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
