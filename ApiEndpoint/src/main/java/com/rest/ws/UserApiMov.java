/**
 * 
 */
package com.rest.ws;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.controller.rst.ControladorSrv;

/**
 * @author danie
 *
 */
@Path("/userMov")
public class UserApiMov {
	
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
			@Context UriInfo uriInfo)
			throws NamingException{
		
		
		//Pasar el String a JSON
		String respServ = new ControladorSrv().addUsr(nombres, apellidos, correo, clave, cell, doc, direccion, "P");
		
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
