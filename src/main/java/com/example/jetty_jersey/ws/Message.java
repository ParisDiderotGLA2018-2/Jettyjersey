package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface MessageClassDAO {
	MessageClass getMessage();
	void addMessage(MessageClass instance);
	void editMessage(int id, MessageClass instance);
	void deleteMessage(MessageClass instance);
}

class MessageClass {
	
	public String text;
	
	public MessageClass(String text) {
		this.text = text;
	}
}

@Path("/index")
public class Message implements MessageClassDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/MessageClass")
	public MessageClass getMessage() {
		
		MessageClass instance = new MessageClass("J'adorerai venir !!");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MessageClass/add")
	public void addMessage(MessageClass instance) {
		System.out.println(instance.text);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MessageClass/edit")
	public void editMessage(@FormParam("id") int id, MessageClass instance) {
		
		System.out.println(instance.text);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/MessageClass/delete")
	public void deleteMessage(MessageClass instance) {
		System.out.println(instance.text);
	}

}
