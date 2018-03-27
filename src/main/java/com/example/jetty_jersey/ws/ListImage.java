package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ListImageClassDAO {
	ListImageClass getListImage();
	void addListImage(ListImageClass instance);
	void editListImage(int id, ListImageClass instance);
	void deleteListImage(ListImageClass instance);
}

class ListImageClass {
	
	public ArrayList<ImageClass> list;
	
	// constructors
	
	public ListImageClass() {
		this.list = new ArrayList<ImageClass>();
	}
	
	public ListImageClass(ArrayList<ImageClass> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouterUneImageClass(String name) {
		this.list.add(new ImageClass(name));
	}
	
}

@Path("/index")
public class ListImage implements ListImageClassDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ImageClass/list")
	public ListImageClass getListImage() {
		
		ListImageClass instance = new ListImageClass();
		instance.ajouterUneImageClass("https://www.rd.com/wp-content/uploads/2017/07/The-Eiffel-Towers-Electric-Bill-Is-Absurd_166143854_Brian-Kinney-1024x683.jpg");
		instance.ajouterUneImageClass("https://media-cdn.tripadvisor.com/media/photo-s/00/12/6d/03/the-view-from-the-top.jpg");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ImageClass/add/list")
	public void addListImage(ListImageClass instance) {
		
		System.out.println("addListImageClass done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ImageClass/edit/list")
	public void editListImage(@FormParam("id") int id, ListImageClass instance) {
		
		System.out.println("editListImageClass done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ImageClass/delete/list")
	public void deleteListImage(ListImageClass instance) {
		
		System.out.println("deleteListImageClass done");
	}

}
