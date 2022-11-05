/**
 * 
 */
package com.conexion.rst;

import java.net.URI;
import java.util.BitSet;

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
import org.xnio.Bits;

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
	public String getUser (String correo, String clave) {
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(1)).queryParam("correo", correo).queryParam("clave", clave);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Usuario no existe";
		}
			
		return response;
		
	}      
	
	public String getPrenda (String idPrenda) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURIPrenda(1)).queryParam("idPrenda", idPrenda);
		
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
	public String addUser (String nombres,
			String apellidos,
			String correo,
			String clave,
			String cell,
			String doc,
			String direccion,
			String tipo,
			String ciudad) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(
				getBaseURI(2)).
				queryParam("nombres", nombres).
				queryParam("apellidos", apellidos).
				queryParam("correo", correo).
				queryParam("clave", clave).
				queryParam("cell", cell).
				queryParam("doc", doc).
				queryParam("direccion", direccion).
				queryParam("tipo", tipo).
				queryParam("ciudad", ciudad);
		
		Response response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.post(null);
				
			
		return response.readEntity(String.class);
	
	}   
	/**
	 *FUNCION PARA ACTUALIZAR USUARIO 
	 */
	//...
	public String updUser (String id, 
			String nombres,
			String apellidos,
			String correo,
			String clave,
			String cell,
			String doc,
			String direccion) {
			
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(
				getBaseURI(3)).
				queryParam("id", id).
				queryParam("nombres", nombres).
				queryParam("apellidos", apellidos).
				queryParam("correo", correo).
				queryParam("clave", clave).
				queryParam("cell", cell).
				queryParam("doc", doc).
				queryParam("direccion", direccion);
		
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
	/**
	 *FUNCION PARA AGREGAR PRENDA 
	 */
	//...
	public String addPrenda (String idUsuario,
			String imgUrl,
			String idFire,
			String fecha,
			String genero,
			String tipo) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(
				getBaseURIPrenda(2)).
				queryParam("idUsuario", idUsuario).
				queryParam("imgUrl", imgUrl).
				queryParam("idFire", idFire).
				queryParam("fecha", idFire).
				queryParam("genero", genero).
				queryParam("tipo", tipo);
		
		Response response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.post(null);
				
			
		return response.readEntity(String.class);
		
	}
	
	public String getIdPrenda(String idFire) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURIPrenda(5)).queryParam("idFire", idFire);
		
		String response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Prenda no existe";
		}
			
		return response;
	}
	
	public String delPrendaById(String id) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURIPrenda(4)).queryParam("id", id);
		
		String response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Prenda no existe";
		}
			
		return response;
	}

	
	//FUNCIONES AUXILIARES 
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
	
	private static URI getBaseURIPrenda(int option) {
		
		switch (option) {
		case 1:
	        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/prenda/get").build();
		case 2:
	        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/prenda/add").build();
		case 3:
	        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/prenda/upd").build();
		case 4:
	        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/prenda/del").build();
		case 5:
	        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/prenda/getId").build();
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
