package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ListImageDAO {
	ListImage getListImage();
	void addListImage(ListImage instance);
	void editListImage(int id, ListImage instance);
	void deleteListImage(ListImage instance);
}

@Path("/index")
public class ListImage implements ListImageDAO {
	
	public ArrayList<Image> list;
	
	// constructors
	
	public ListImage() {
		this.list = new ArrayList<Image>();
	}
	
	public ListImage(ArrayList<Image> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouterUneImage(String name) {
		this.list.add(new Image(name));
	}
	
	// webservices

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/image/list")
	public ListImage getListImage() {
		
		ListImage instance = new ListImage();
		instance.ajouterUneImage("https://www.rd.com/wp-content/uploads/2017/07/The-Eiffel-Towers-Electric-Bill-Is-Absurd_166143854_Brian-Kinney-1024x683.jpg");
		instance.ajouterUneImage("https://media-cdn.tripadvisor.com/media/photo-s/00/12/6d/03/the-view-from-the-top.jpg");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/image/add/list")
	public void addListImage(ListImage instance) {
		
		System.out.println("addListImage done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/image/edit/list")
	public void editListImage(@FormParam("id") int id, ListImage instance) {
		
		System.out.println("editListImage done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/image/delete/list")
	public void deleteListImage(ListImage instance) {
		
		System.out.println("deleteListImage done");
	}

}
