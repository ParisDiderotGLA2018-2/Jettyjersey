package com.example.jetty_jersey.ws;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

interface ImageClassDAO {
	ImageClass getImage();
	void addImage(ImageClass instance);
	void editImage(int id, ImageClass instance);
	void deleteImage(ImageClass instance);
}

class ImageClass {
	
	public String name;
	
	public ImageClass(String name) {
		this.name = name;
	}
	
}
@Path("/index")
public class Image implements ImageClassDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ImageClass")
	public ImageClass getImage() {
		
		ImageClass instance = new ImageClass("https://www.rd.com/wp-content/uploads/2017/07/The-Eiffel-Towers-Electric-Bill-Is-Absurd_166143854_Brian-Kinney-1024x683.jpg");
		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ImageClass/add")
	public void addImage(ImageClass instance) {
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ImageClass/edit")
	public void editImage(@FormParam("id") int id, ImageClass instance) {
		
		System.out.println(instance.name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ImageClass/delete")
	public void deleteImage(ImageClass instance) {
		System.out.println(instance.name);
	}

}
