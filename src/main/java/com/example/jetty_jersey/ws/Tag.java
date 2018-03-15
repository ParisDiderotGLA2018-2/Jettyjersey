package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface TagDAO {
	Tag getTag();
	void addTag(Tag instance);
	void editTag(int id, Tag instance);
	void deleteTag(Tag instance);
}

@Path("/index")
public class Tag implements TagDAO {
	
	public String name;
	
	public Tag(String name) {
		this.name = name;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tag")
	public Tag getTag() {
		
		Tag instance = new Tag("Party");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/add")
	public void addTag(Tag instance) {
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/edit")
	public void editTag(@FormParam("id") int id, Tag instance) {
		
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/tag/delete")
	public void deleteTag(Tag instance) {
		System.out.println(instance.name);
	}

}
