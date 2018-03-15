package com.example.jetty_jersey.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface UserDAO {
	User getUser();
	void addUser(User instance);
	void editUser(int id, User instance);
	void deleteUser(User instance);
}

@Path("/index")
public class User implements UserDAO {
	
	public String login;
	public String password;
	
	// constructors
	
	public User(String login) {
		this.login = login;
		this.password = "password";
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	// webservices
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public User getUser() {
		
		User instance = new User("Benjamin", "Mudamuda");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login/add")
	public void addUser(User instance) {
		System.out.println(instance.login);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login/edit")
	public void editUser(@FormParam("id") int id, User instance) {
		
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
	public void deleteUser(User instance) {
		System.out.println(instance.login);
	}

}
