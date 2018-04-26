package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.example.jetty_jersey.ws.Message.MessageClass;

@Path("/index")
public class ListMessage {
	public static class ListMessageClass{
		public ArrayList<MessageClass> list;
		
		// constructors
		
		public ListMessageClass() {
			this.list = new ArrayList<MessageClass>();
		}
		
		public ListMessageClass(ArrayList<MessageClass> list) {
			this.list = list;
		}
		
		// methods
		
		public void ajouterUnMessage(String name) {
			this.list.add(new MessageClass(name));
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Message/list")
	public ListMessageClass getListMessage() {
		
		ListMessageClass instance = new ListMessageClass();
		instance.ajouterUnMessage("J'adorerai venir !!");
		instance.ajouterUnMessage("C'est payant ?");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/add/list")
	public void addListMessage(ListMessageClass instance) {
		
		System.out.println("addListMessage done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/edit/list")
	public void editListMessage(@FormParam("id") int id, ListMessageClass instance) {
		
		System.out.println("editListMessage done");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/delete/list")
	public void deleteListMessage(ListMessageClass instance) {
		
		System.out.println("deleteListMessage done");
	}

}
