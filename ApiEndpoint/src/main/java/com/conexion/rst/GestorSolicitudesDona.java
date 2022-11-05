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
import org.json.JSONObject;
import org.xnio.Bits;

import com.rest.ws.UsuarioDao;

/**
 * @author danie
 *
 */
public class GestorSolicitudesDona {

	 /**
	 * CONSTRUCTOR
	 */
	public GestorSolicitudesDona() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 *FUNCION PARA TRAER EL AGREGADO DE DONACIONES DE LA FUNDACION
	 */  
	
	public String getDonaciones (String idFundacion) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(1)).queryParam("idFundacion", idFundacion);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Donacion no encontrada";
		}
			
		return response;
		
	}
	/**
	 *FUNCION PARA TRAER LAS PRENDAS DE UNA DONACION ESPESIFICA
	 */  
	
	public String getPrendasDonacion(String idUsuario, String idDonacion) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(2))
				.queryParam("idUsuario", idUsuario)
				.queryParam("idDonaFire", idDonacion);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "No hay prendas";
		}
			
		return response;
		
	}
	public String updateDonacion(String id, String estado) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(3)).queryParam("idDonaFire", id).queryParam("estado", estado);
		
		Entity<?> empty = Entity.text("");
		Response response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.put(empty);
		
		if(response==null) {
			return "Error actualizando";
		}
			
		return response.readEntity(String.class);
		
	}
	
	public String addDonacion(String nombreDon, String telefonoDon, String direccionDon, String fechaDon,
			String idUsuario, String idFire) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(4))
				.queryParam("nombreDon", nombreDon)
				.queryParam("telefonoDon", telefonoDon)
				.queryParam("direccionDon", direccionDon)
				.queryParam("fechaDon", fechaDon)
				.queryParam("idUsuario", idUsuario)
				.queryParam("idFire", idFire);
		
		Entity<?> empty = Entity.text("");
		Response response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.post(empty);
		
		if(response==null) {
			return "Error actualizando";
		}
			
		return response.readEntity(String.class);
	}

	
	//FUNCIONES AUXILIARES 
	private static URI getBaseURI(int option) {
		
			switch (option) {
			case 1:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getFun").build();
			case 2:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getPrendDonFun").build();
			case 3:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/upd").build();
			case 4:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/add").build();
			default:
				break;
			}
			return null;
		
	    }	
	


}
