package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface MessageDAO {
	Message getMessage();
	void addMessage(Message instance);
	void editMessage(int id, Message instance);
	void deleteMessage(Message instance);
}

@Path("/index")
public class Message implements MessageDAO {
	
	public String text;
	
	public Message(String text) {
		this.text = text;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/message")
	public Message getMessage() {
		
		Message instance = new Message("J'adorerai venir !!");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/message/add")
	public void addMessage(Message instance) {
		System.out.println(instance.text);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/message/edit")
	public void editMessage(@FormParam("id") int id, Message instance) {
		
		System.out.println(instance.text);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/message/delete")
	public void deleteMessage(Message instance) {
		System.out.println(instance.text);
	}

}
