/**
 * 
 */
package com.rest.ws;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.conexion.rst.GestorSolicitudes;
import com.controller.rst.ControladorSrv;

/**
 * @author danie
 *
 */
@Path("/user")
public class RestApi {

	/**
	 * @param uriInfo 
	 * @throws NamingException 
	 * 
	 */	
	
	@GET
	@Path("{auth}")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(@PathParam("auth") String auth, @QueryParam("user") String name,@QueryParam("psswr") String passw, @Context UriInfo uriInfo) throws NamingException {
		
		MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();

		String from = uriInfo.getQueryParameters().getFirst("user");
		    // In case you want to get the whole generated string
		    String query = uriInfo.getRequestUri().getQuery();

		    String output = "QueryParams: " + queryParams 
		            + "<br> Keys: " + queryParams.keySet() 
		            + "<br> Values: " + queryParams.values()
		            + "<br> Query: " + query;
		    
		String text = new GestorSolicitudes().getUser(name, passw);
		
		return "AccesToken";
		
		// return name;
	}


	/*
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response */
	
	/*
	@GET
	@Path("{auth}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsr() throws NamingException{
	
		return new ControladorSrv().traerUsuariosInd();
		
	}*/

}
