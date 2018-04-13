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
	public static class MessageClass {
		public String text;
		
		public MessageClass(String text) {
			this.text = text;
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Message")
	public MessageClass getMessage() {
		
		MessageClass instance = new MessageClass("J'adorerai venir !!");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/add")
	public void addMessage(MessageClass instance) {
		System.out.println(instance.text);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/edit")
	public void editMessage(@FormParam("id") int id, MessageClass instance) {
		
		System.out.println(instance.text);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Message/delete")
	public void deleteMessage(MessageClass instance) {
		System.out.println(instance.text);
	}

}
