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
public class GestorSolicitudesPrenda {

	 /**
	 * CONSTRUCTOR
	 */
	public GestorSolicitudesPrenda() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public String getCategoriaPrenda(String idPrend) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURIPrenda(6)).queryParam("idPrend", idPrend);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Categoria no existe";
		}
			
		return response;
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
		case 6:
	        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/prenda/getCat").build();
		default:
			break;
		}
		return null;
	
    }


	

}
