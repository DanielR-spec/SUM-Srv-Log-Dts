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

	/**
	 * 
	 */	/*
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(@Context HttpHeaders httpheaders) {
		//return new ControladorSrv().agregarUsuario();
		String token = httpheaders.getHeaderString("token");
		return token;
	}*/
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public com.rest.ws.Usuario getUsr(@QueryParam("user") String name,@QueryParam("psswr") String passw, @Context UriInfo uriInfo) throws NamingException{
		
		
	    //JSONObject jsonObj = new JSONObject(token);
		//ClientConfig config = new ClientConfig();
		//Client client = ClientBuilder.newClient(config);
		//WebTarget target = client.target(null);
		
		//String userName = request.getParameter("username");
		//String password = request.getParameter("pass");
		MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();

		String from = uriInfo.getQueryParameters().getFirst("user");
		
	    String query = uriInfo.getRequestUri().getQuery();

		String output = "QueryParams: " + queryParams 
	            + "<br> Keys: " + queryParams.keySet() 
	            + "<br> Values: " + queryParams.values()
	            + "<br> Query: " + query;
		System.out.print(output);
		
		return new ControladorSrv().traerUsuariosInd(name, passw);
		
	}

}
