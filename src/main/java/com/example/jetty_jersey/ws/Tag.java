package com.example.jetty_jersey.ws;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface TagDAO {
	ListTagClass getTagsOfMap();
	ListTagClass getTagsOfLocation();
	void retrieveTag(TagClass instance);
}

class TagClass {
	public String name;
	
	public TagClass(String name) {
		this.name = name;
	}
}

class ListTagClass {
	public ArrayList<TagClass> list;
	
	public ListTagClass() {
		this.list = new ArrayList<TagClass>();
	}
	
	public ListTagClass(ArrayList<TagClass> list) {
		this.list = list;
	}
	
	public void addTag(TagClass Tag) {
		this.list.add(Tag);
	}
}

@Path("/index")
public class Tag implements TagDAO {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myTags")
	public ListTagClass getTagsOfMap() {
		
		TagClass tag1 = new TagClass("Paris");
		TagClass tag2 = new TagClass("Cafe");
		
		ListTagClass instance = new ListTagClass();
		instance.addTag(tag1);
		instance.addTag(tag2);

		return instance;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/myTags")
	public ListTagClass getTagsOfLocation() {
		
		TagClass tag1 = new TagClass("Cafe");
		
		ListTagClass instance = new ListTagClass();
		instance.addTag(tag1);

		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Tag")
	public void retrieveTag(TagClass instance) {
		System.out.println(instance.name);
	}

}
