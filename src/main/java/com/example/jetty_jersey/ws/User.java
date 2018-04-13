package com.example.jetty_jersey.ws;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;

import persistance.Bdd;

import  javax.inject.Inject;

@Path("/index")
public class User{
	
	public static class UserClass {
		public String login;
		public String password;
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response getUser(@QueryParam("name") String name) {
			UserClass instance = new UserClass();
			instance.login = "Benjamin";
			instance.password = "Mudamuda";
	        return Response.ok(instance).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("test/insert/user")
	public Response testInsertUser(@QueryParam("name") String name) {
		String mdp = "Mudamuda";
	//	response = client.prepareIndex("twitter", "tweet")
	//	        .setSource(json, XContentType.JSON)
		//        .get();
		
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login/add")
	public UserClass addUser(UserClass instance) {
		String name = instance.login;
		String mdp = instance.password;
		UserClass inst = new UserClass();
		inst.login = name;
		inst.password = mdp;
		TransportClient client = Bdd.connectionToBD();
		Map<String, Object> json = new HashMap<String, Object>();
		IndexResponse response = null;
		try {
			response = client.prepareIndex("user","name")
			        .setSource(jsonBuilder()
			                    .startObject()
			                        .field("login", name)
			                        .field("password", mdp)
			                    .endObject()
			                  )
			        .get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inst;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login/edit")
	public void editUser(@FormParam("id") int id, UserClass instance) {
		
		

		System.out.println(instance.login);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login/delete")
	public void deleteUser(UserClass instance) {
		System.out.println(instance.login);
	}

}
