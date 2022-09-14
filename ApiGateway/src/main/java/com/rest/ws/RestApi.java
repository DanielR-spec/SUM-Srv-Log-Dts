/**
 * 
 */
package com.rest.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
@Path("/user")
public class RestApi {

	
	@GET
	@Path("{auth}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsr(
			@QueryParam("user") String usr,
			@QueryParam("psswr") String pass, 
			@Context UriInfo uriInfo) 
			throws NamingException{
		
		return new ControladorSrv().validateUser(usr, pass);
		
	}
	
	@GET
	@Path("{add}")
	@Produces(MediaType.TEXT_PLAIN)
	public String addUsr(
			@QueryParam("name") String name,
			@QueryParam("lName") String lName,
			@QueryParam("user") String usr,
			@QueryParam("psswr") String pass,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		return new ControladorSrv().addUser(name, lName, usr, pass);
		
		
	}

}
