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
	@Path("/auth")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsr() throws NamingException{
		
		try {
			return new CrtlPrenda().authPrnd();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Error en ApiGateway";
		
	}
//	
//	@POST
//	@Path("/add")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String addUsr(
//			@QueryParam("tipo") String tipo,
//			@QueryParam("genero") String genero,
//			@QueryParam("ruta") String ruta,
//			@QueryParam("imagen") BitSet imagen,
//			@Context UriInfo uriInfo)
//			throws NamingException{
//		
//		return new CrtlPrenda().addPrenda(tipo, genero, ruta, imagen);
//		
//		
//	}
//	
//	@PUT
//	@Path("/upd")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String updUsr(
//			@QueryParam("id") String id,
//			@QueryParam("nombres") String nombres,
//			@QueryParam("apellidos") String apellidos,
//			@QueryParam("correo") String correo,
//			@QueryParam("clave") String clave,
//			@QueryParam("cell") String cell,
//			@QueryParam("doc") String doc,
//			@QueryParam("direccion") String direccion,
//			@Context UriInfo uriInfo)
//			throws NamingException{
//		
//		return new ControladorSrv().updUser(id, nombres, apellidos, correo, clave, cell, doc, direccion);
//		
//		
//	}
//	
//	@GET
//	@Path("/del")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String delUsr(
//			@QueryParam("id") String id, 
//			@Context UriInfo uriInfo) 
//			throws NamingException{
//		
//		return new ControladorSrv().delUser(id);
//		
//	}

}
