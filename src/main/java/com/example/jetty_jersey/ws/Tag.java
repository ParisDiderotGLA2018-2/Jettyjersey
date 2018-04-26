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
public class Tag {
	public static class TagClass {
		public String name;
		
		public TagClass(String name) {
			this.name = name;
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tag")
	public TagClass getTag() {
		
		TagClass instance = new TagClass("Party");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/add")
	public void addTag(TagClass instance) {
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/edit")
	public void editTag(@FormParam("id") int id, TagClass instance) {
		
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/delete")
	public void deleteTag(TagClass instance) {
		System.out.println(instance.name);
	}

}
