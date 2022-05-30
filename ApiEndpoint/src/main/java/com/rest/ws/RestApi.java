/**
 * 
 */
package com.rest.ws;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.controller.rst.ControladorSrv;

/**
 * @author danie
 *
 */
@Path("/user")
public class RestApi {

	/**
	 * @throws NamingException 
	 * 
	 */	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() throws NamingException {
		//return new ControladorSrv().traerUsuariosInd();
		return "hello";
	}
	/*
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response */
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsr() throws NamingException{
	
		return new ControladorSrv().traerUsuariosInd();
		
	}

}
