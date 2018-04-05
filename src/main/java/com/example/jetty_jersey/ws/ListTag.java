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
public class ListTag {
	public ArrayList<Tag> list;
	
	// constructors
	
	public ListTag() {
		this.list = new ArrayList<Tag>();
	}
	
	public ListTag(ArrayList<Tag> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouterUnTag(String name) {
		this.list.add(new Tag(name));
	}
	// webservices

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tag/list")
	public ListTag getListTag() {
		
		ListTag instance = new ListTag();
		instance.ajouterUnTag("Treasure Quest");
		instance.ajouterUnTag("Paris");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/add/list")
	public void addListTag(ListTag instance) {
		
		System.out.println("addListTag done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/edit/list")
	public void editListTag(@FormParam("id") int id, ListTag instance) {
		
		System.out.println("editListTag done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/delete/list")
	public void deleteListTag(ListTag instance) {
		
		System.out.println("deleteListTag done");
	}

}
