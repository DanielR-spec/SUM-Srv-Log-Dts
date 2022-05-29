/**
 * 
 */
package com.rest.ws;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	 */	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		//return new ControladorSrv().agregarUsuario();
		return "hello";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public com.rest.ws.Usuario getUsr() throws NamingException{
	
		return new ControladorSrv().traerUsuariosInd();
		
	}

}
