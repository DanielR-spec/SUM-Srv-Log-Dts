/**
 * 
 */
package com.rest.ws;

import java.io.Console;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import jersey.repackaged.org.*;

import com.conexion.rst.GestorSolicitudes;
import com.controller.rst.ControladorSrv;
import com.fasterxml.jackson.databind.util.JSONPObject;

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
	
	//Funciona
	@GET
	@Path("/auth")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsr(
			@QueryParam("correo") String correo,
			@QueryParam("clave") String clave, 
			@Context UriInfo uriInfo) throws NamingException {
		    		
		return new ControladorSrv().validarUsr(correo, clave);
	}
	
	//Definición: Metodo ubicado a nivel de servicios actua como puente de acceso para
	//iniciar el proceso de creacion de cuenta 
	//Entrada: Atributos de creacion de cuenta de usuario
	//Salida: Str respuesta si se agrego o no
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public String addUsr(
			@QueryParam("nombres") String nombres,
			@QueryParam("apellidos") String apellidos,
			@QueryParam("correo") String correo,
			@QueryParam("clave") String clave,
			@QueryParam("cell") String cell,
			@QueryParam("doc") String doc,
			@QueryParam("direccion") String direccion,
			@QueryParam("ciudad") String ciudad,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		
		//Pasar el String a JSON
		String respServ = new ControladorSrv().addUsr(nombres, apellidos, correo, clave, cell, doc, direccion, "E", ciudad);
		
		return respServ; 
				
	}
	
	//Definición: Metodo ubicado a nivel de servicios actua como puente de acceso para
	//iniciar el proceso de actualización de cuenta 
	//Entrada: Atributos de actualización de cuenta de usuario
	//Salida: Str respuesta si se actualiza o no
	@PUT
	@Path("/upd")
	@Produces(MediaType.APPLICATION_JSON)
	public String updUsr(
			@QueryParam("id") String id,
			@QueryParam("nombres") String nombres,
			@QueryParam("apellidos") String apellidos,
			@QueryParam("correo") String correo,
			@QueryParam("clave") String clave,
			@QueryParam("cell") String cell,
			@QueryParam("doc") String doc,
			@QueryParam("direccion") String direccion,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		
		//Pasar el String a JSON
		String respServ = new ControladorSrv().updUsr(id, nombres, apellidos, correo, clave, cell, doc, direccion);
		
		return respServ; 
				
	}
	
	@GET
	@Path("/del")
	@Produces(MediaType.TEXT_PLAIN)
	public String delUsr(@QueryParam("id") String id, @Context UriInfo uriInfo) throws NamingException {
		
		
		String respServ = new ControladorSrv().delUsr(id);
		
		return respServ; 

	}

}

//MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
//
//String from = uriInfo.getQueryParameters().getFirst("user");
//    // In case you want to get the whole generated string
//    String query = uriInfo.getRequestUri().getQuery();
//
//    String output = "QueryParams: " + queryParams 
//            + "<br> Keys: " + queryParams.keySet() 
//            + "<br> Values: " + queryParams.values()
//            + "<br> Query: " + query;
