package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ListMessageClassDAO {
	ListMessageClass getListMessage();
	void addListMessage(ListMessageClass instance);
	void editListMessage(int id, ListMessageClass instance);
	void deleteListMessage(ListMessageClass instance);
}

class ListMessageClass {
	
	public ArrayList<MessageClass> list;
	
	// constructors
	
	public ListMessageClass() {
		this.list = new ArrayList<MessageClass>();
	}
	
	public ListMessageClass(ArrayList<MessageClass> list) {
		this.list = list;
	}
	
	// methods
	
	public void ajouterUnMessageClass(String name) {
		this.list.add(new MessageClass(name));
	}
	
}

@Path("/index")
public class ListMessage implements ListMessageClassDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/MessageClass/list")
	public ListMessageClass getListMessage() {
		
		ListMessageClass instance = new ListMessageClass();
		instance.ajouterUnMessageClass("J'adorerai venir !!");
		instance.ajouterUnMessageClass("C'est payant ?");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MessageClass/add/list")
	public void addListMessage(ListMessageClass instance) {
		
		System.out.println("addListMessageClass done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MessageClass/edit/list")
	public void editListMessage(@FormParam("id") int id, ListMessageClass instance) {
		
		System.out.println("editListMessageClass done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MessageClass/delete/list")
	public void deleteListMessage(ListMessageClass instance) {
		
		System.out.println("deleteListMessageClass done");
	}

}
