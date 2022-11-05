/**
 * 
 */
package com.rest.ws;

import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.client.ClientConfig;

import com.controller.rst.ControladorSrv;
import com.controller.rst.CrtlCart;
import com.controller.rst.CrtlPrenda;

/*
import com.conexion.rst.LocalizadorServicios;
import com.controller.rst.ControladorSrv;
import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
*/
/**
 * @author danie
 *
 */
@Path("/cart")
public class RestApiCart {

	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPrend(@QueryParam("id") String id, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlPrenda().getPrenda(id);

	}
	
	//Funciona
	@GET
	@Path("/getId")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCartId(
			@QueryParam("idCart") String idCart,
			@Context UriInfo uriInfo) throws NamingException {
		    		
		return new CrtlCart().getCartId(idCart);
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public String addCart(@QueryParam("idUsuario") String idUsuario,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		return new CrtlCart().addCart(idUsuario);
		
		
	}
	
	
	@GET
	@Path("/del")
	@Produces(MediaType.TEXT_PLAIN)
	public String delPren(@QueryParam("id") String id,
			@Context UriInfo uriInfo) throws NamingException {
		
		
		String respServ = new CrtlPrenda().delPrenda(id);
		
		return respServ; 

	}

}
