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
public class GestorSolicitudesCart {

	 /**
	 * CONSTRUCTOR
	 */
	public GestorSolicitudesCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 *FUNCION PARA TRAER EL AGREGADO DE DONACIONES DE LA FUNDACION
	 */  
	
	public String addCart (String idUsuario) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(1)).queryParam("idUsuario", idUsuario);
		
		Response response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.post(null);
		
		if(response==null) {
			return "Carrito no encontrado";
		}
		
		return "Carrito agregado";
		
	}
	
	//FUNCIONES AUXILIARES 
	private static URI getBaseURI(int option) {
		
			switch (option) {
			case 1:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/cart/add").build();
			case 2:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getFunDon").build();
			case 3:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/upd").build();
			case 4:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/user/del").build();
			default:
				break;
			}
			return null;
		
	    }	
	

}
