package com.example.jetty_jersey.ws;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ImageDAO {
	Image getImage();
	void addImage(Image instance);
	void editImage(int id, Image instance);
	void deleteImage(Image instance);
}

@Path("/index")
public class Image implements ImageDAO {
	
	public String name;
	
	public Image(String name) {
		this.name = name;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/image")
	public Image getImage() {
		
		Image instance = new Image("https://www.rd.com/wp-content/uploads/2017/07/The-Eiffel-Towers-Electric-Bill-Is-Absurd_166143854_Brian-Kinney-1024x683.jpg");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/image/add")
	public void addImage(Image instance) {
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/image/edit")
	public void editImage(int id, Image instance) {
		
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/image/delete")
	public void deleteImage(Image instance) {
		System.out.println(instance.name);
	}

}
