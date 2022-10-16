/**
 * 
 */
package com.conexion.rst;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import com.rest.ws.UsuarioDao;

/**
 * @author danie
 *
 */
public class GestorSolicitudes {

	 /**
	 * CONSTRUCTOR
	 */
	public GestorSolicitudes() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 *FUNCION PARA VALIDAR USUARIO 
	 */
	//Funciona
	public String getUser (String usr, String pss) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(1)).queryParam("user", usr).queryParam("psswr", pss);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Usuario no existe";
		}
			
		return response;
		
	}      
	/**
	 *FUNCION PARA AGREGAR USUARIO 
	 */
	//...
	public String addUser (String name, String lName, String usr, String pss) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(
				getBaseURI(2)).
				queryParam("name", name).
				queryParam("lName", lName).
				queryParam("user", usr).
				queryParam("psswr", pss);
		
		Response response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.post(null);
				
			
		return response.readEntity(String.class);
	
	}   
	/**
	 *FUNCION PARA ACTUALIZAR USUARIO 
	 */
	//...
	public String updUser (String id, String name, String lName, String usr, String pss) {
		
		UsuarioDao user = new UsuarioDao(Integer.parseInt(id), usr, pss);
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(
				getBaseURI(3)).
				queryParam("id", id).
				queryParam("name", name).
				queryParam("lName", lName).
				queryParam("user", usr).
				queryParam("psswr", pss);
		Entity<?> empty = Entity.text("");
		Response response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.put(empty);
				
		
		return response.readEntity(String.class);
	
	}   
	/**
	 *FUNCION PARA ELIMINAR USUARIO 
	 */
	//Funciona
	public String delUser (String id) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(4)).queryParam("id", id);
		
		String response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		
		if(response==null) {
			return "Usuario no exisite";
		}
			
		return response;
		
	}  

	private static URI getBaseURI(int option) {
		
			switch (option) {
			case 1:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/user/auth").build();
			case 2:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/user/add").build();
			case 3:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/user/upd").build();
			case 4:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/user/del").build();
			default:
				break;
			}
			return null;
		
	    }
	
	
	private void txt() {
		/*
		Client client2 = ClientBuilder.newClient(config);
		WebTarget target2 = client.target(getBaseURI()).queryParam("user", usr).queryParam("psswr", pss);
		
		String response2 = target2.request().accept(MediaType.APPLICATION_JSON).get(String.class);*/
		
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

}
