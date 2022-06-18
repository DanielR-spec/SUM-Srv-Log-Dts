/**
 * 
 */
package com.conexion.rst;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

/**
 * @author danie
 *
 */
public class GestorSolicitudes {

	/**
	 * 
	 */
	
	
	public String getUser (String usr, String pss) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI()).queryParam("user", usr).queryParam("psswr", pss);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		/*
		Client client2 = ClientBuilder.newClient(config);
		WebTarget target2 = client.target(getBaseURI()).queryParam("user", usr).queryParam("psswr", pss);
		
		String response2 = target2.request().accept(MediaType.APPLICATION_JSON).get(String.class);*/
			
		return response;
		
		//WebTarget target = null;
		
        //String response = target.path("hola").path("mundo").request().acceptLanguage(MediaType.TEXT_PLAIN).get(Response.class).toString();
        
        //System.out.println(response);

		
       // String plainAnswer =target.path("rest").path("hello").request().acceptLanguage(MediaType.TEXT_PLAIN).get(String.class);
       // String xmlAnswer =target.path("rest").path("hello").request().acceptLanguage(MediaType.TEXT_XML).get(String.class);
       // String htmlAnswer=target.path("rest").path("hello").request().acceptLanguage(MediaType.TEXT_HTML).get(String.class);

       // System.out.println(plainAnswer);
       // System.out.println(xmlAnswer);
       // System.out.println(htmlAnswer);
		
	}       

	 /**
	 * 
	 */
	public GestorSolicitudes() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static URI getBaseURI() {
	        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/user").build();
	    }

}
