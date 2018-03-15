package com.example.jetty_jersey.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface UserDAO {
	UserClass getUser();
	void addUser(UserClass instance);
	void editUser(int id, UserClass instance);
	void deleteUser(UserClass instance);
}

class UserClass {
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

@Path("/index")
public class User implements UserDAO {
	
	// constructors
	
	// webservices
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public UserClass getUser() {
		
		UserClass instance = new UserClass("Benjamin", "Mudamuda");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login/add")
	public void addUser(UserClass instance) {
		System.out.println(instance.login);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login/edit")
	public void editUser(@FormParam("id") int id, UserClass instance) {
		
		/**
		 * id : l'id du user a modifier (son nom)
		 * instance : le nouvel objet User complet
		 * 
		 * On cherchera dans la BDD le User ayant comme cle id
		 * puis on set chacun de ses attributs par ceux de instance
		 */
		
		System.out.println(instance.login);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login/delete")
	public void deleteUser(UserClass instance) {
		System.out.println(instance.login);
	}

}
