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
public class Message{

	public String text;
	
	public Message(String text) {
		this.text = text;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Message")
	public Message getMessage() {
		
		Message instance = new Message("J'adorerai venir !!");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/add")
	public void addMessage(Message instance) {
		System.out.println(instance.text);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/edit")
	public void editMessage(@FormParam("id") int id, Message instance) {
		
		System.out.println(instance.text);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/delete")
	public void deleteMessage(Message instance) {
		System.out.println(instance.text);
	}

}
