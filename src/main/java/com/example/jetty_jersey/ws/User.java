package com.example.jetty_jersey.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface UserDAO {
	static class UserClass {
		public String login;
		public String password;
		
		public UserClass(String login) {
			this.login = login;
			this.password = "password";
		}
		
		public UserClass(String login, String password) {
			this.login = login;
			this.password = password;
		}
	}
	
	UserClass getUser();
	void retrieveUser(UserClass instance);
}

@Path("/index")
public class User implements UserDAO {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public UserClass getUser() {
		
		UserClass instance = new UserClass("Benjamin", "Mudamuda");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public void retrieveUser(UserClass instance) {
		System.out.println(instance.login);
	}

}
