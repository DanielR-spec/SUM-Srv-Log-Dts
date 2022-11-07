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
import org.json.JSONObject;

import com.controller.rst.ControladorSrv;
import com.controller.rst.CrtlCartFireBase;
import com.controller.rst.CrtlDonaFireBase;
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
	@Produces(MediaType.TEXT_PLAIN	)
	public String getDonacion(@QueryParam("id") String idDonacion, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlDonacion().getDonacion(idDonacion);

		
	}
	
	@GET
	@Path("/getFun")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDonacionByFundacionId(@QueryParam("idFundacion") String idFundacion, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlDonacion().getDonacionByFundacionId(idFundacion);

		
	}
	
	//Es posible enviar toda la info con el metodo previo sin necesidad de acceder a este end Point 
	//TENER PRESENTE
	@GET
	@Path("/getIdDonUsr")
	@Produces(MediaType.APPLICATION_JSON)
	public String getIdFireDonaUsr(@QueryParam("idDonaBack") String idDonaBack, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlDonacion().getIdDonUsr(idDonaBack);
		
	}
	
	@GET
	@Path("/getPrendDonFun")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPrendasDonacion(@QueryParam("idUsuario") String idUsuario, @QueryParam("idDonaFire") String idDonaFire, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlDonacion().getPrendasByDonaId(idUsuario, idDonaFire);

		
	}
	
	//iniciar el proceso de actualización de cuenta 
	//Entrada: Atributos de actualización de cuenta de usuario
	//Salida: Str respuesta si se actualiza o no
	@PUT
	@Path("/upd")
	@Produces(MediaType.TEXT_PLAIN)
	public String updDona(
			@QueryParam("idDonaFire") String id,
			@QueryParam("estado") String estado,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		
		//Pasar el String a JSON
		String respServ = new CrtlDonacion().updateDonacion(id, estado);
		
		return respServ; 
				
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public String addPrend(
			@QueryParam("nombreDon") String nombreDon,
			@QueryParam("telefonoDon") String telefonoDon,
			@QueryParam("direccionDon") String direccionDon,
			@QueryParam("fechaDon") String fechaDon,
			@QueryParam("idUsuario") String idUsuario,
			@QueryParam("idFire") String idFire,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		return new CrtlDonacion().addDona(nombreDon, telefonoDon, direccionDon, fechaDon, idUsuario, idFire);
		
		
	}

}
