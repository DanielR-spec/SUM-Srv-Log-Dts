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
@Path("/prenda")
public class RestApiPrenda {

	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPrend(@QueryParam("id") String id, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlPrenda().getPrenda(id);

		
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public String addPrend(@QueryParam("idFire") String idFire, 
			@QueryParam("idUsuario") String idUsuario,
			@QueryParam("imgUrl") String imgUri,
			@QueryParam("genero") String genero,
			@QueryParam("tipo") String ruta,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		return new CrtlPrenda().addPrenda(idFire, idUsuario, imgUri, genero, ruta);
		
		
	}
	
	@PUT
	@Path("/upd")
	@Produces(MediaType.TEXT_PLAIN)
	public String updUsr(
			@QueryParam("idPrenda") String id,
			@QueryParam("idUsuario") String idUsuario,
			@QueryParam("imgUri") String imgUri,
			@QueryParam("genero") String genero,
			@QueryParam("tipo") String tipo,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		return new CrtlPrenda().updatePrenda(id, idUsuario, imgUri, genero, tipo);
		
		
	}
	
	@GET
	@Path("/del")
	@Produces(MediaType.TEXT_PLAIN)
	public String delUsr(
			@QueryParam("id") String id, 
			@Context UriInfo uriInfo) 
			throws NamingException{
		
		return new CrtlPrenda().deletePrenda(id);
		
	}

}
