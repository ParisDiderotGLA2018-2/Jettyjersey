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
public class ListMessage {

	public ArrayList<Message> list;
	
	// constructors
	
	public ListMessage() {
		this.list = new ArrayList<Message>();
	}
	
	public ListMessage(ArrayList<Message> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouterUnMessage(String name) {
		this.list.add(new Message(name));
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Message/list")
	public ListMessage getListMessage() {
		
		ListMessage instance = new ListMessage();
		instance.ajouterUnMessage("J'adorerai venir !!");
		instance.ajouterUnMessage("C'est payant ?");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/add/list")
	public void addListMessage(ListMessage instance) {
		
		System.out.println("addListMessage done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/edit/list")
	public void editListMessage(@FormParam("id") int id, ListMessage instance) {
		
		System.out.println("editListMessage done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/delete/list")
	public void deleteListMessage(ListMessage instance) {
		
		System.out.println("deleteListMessage done");
	}

}
