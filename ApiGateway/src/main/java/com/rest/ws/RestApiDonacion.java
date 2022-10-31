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
import com.controller.rst.CrtlDonacion;
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
@Path("/donacion")
public class RestApiDonacion {

	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDonacion(@QueryParam("id") String idDonacion, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlDonacion().getDonacion(idDonacion);

		
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public String addDonacion(@QueryParam("idFundacion") String idFundacion,
			@QueryParam("nombreDon") String nombreDon, 
			@QueryParam("telefonoDon") String telefonoDon, 
			@QueryParam("direccionDon") String direccionDon, 
			@QueryParam("fechaDon") String fechaDon, 
			@QueryParam("idUsuario") String idUsuario,
			@QueryParam("estado") String estado,
			@QueryParam("idFire") String idFire,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		return new CrtlDonacion().addDonacion(idFundacion,nombreDon,telefonoDon,direccionDon,fechaDon,idUsuario,estado,idFire);
		
		
	}
	


}
