package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ListTagDAO {
	ListTagClass getListTag();
	void addListTag(ListTagClass instance);
	void editListTag(int id, ListTagClass instance);
	void deleteListTag(ListTagClass instance);
}

class ListTagClass {
	public ArrayList<TagClass> list;
	
	// constructors
	
	public ListTagClass() {
		this.list = new ArrayList<TagClass>();
	}
	
	public ListTagClass(ArrayList<TagClass> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouterUnTag(String name) {
		this.list.add(new TagClass(name));
	}
}

@Path("/index")
public class ListTag implements ListTagDAO {
	
	// webservices

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tag/list")
	public ListTagClass getListTag() {
		
		ListTagClass instance = new ListTagClass();
		instance.ajouterUnTag("Treasure Quest");
		instance.ajouterUnTag("Paris");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/add/list")
	public void addListTag(ListTagClass instance) {
		
		System.out.println("addListTag done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/edit/list")
	public void editListTag(@FormParam("id") int id, ListTagClass instance) {
		
		System.out.println("editListTag done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/delete/list")
	public void deleteListTag(ListTagClass instance) {
		
		System.out.println("deleteListTag done");
	}

}
