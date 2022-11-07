/**
 * 
 */
package com.rest.ws;

import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.BitSet;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.naming.NamingException;
import javax.servlet.annotation.MultipartConfig;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument.Content;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.json.JSONObject;

import jersey.repackaged.org.*;

import com.conexion.rst.GestorSolicitudes;
import com.controller.rst.ControladorSrv;
import com.controller.rst.CrtlCart;
import com.controller.rst.CrtlDonacion;
import com.controller.rst.CrtlPrenda;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @author danie
 *
 */
@Path("/donacion")
public class RestApiDonacion {

	/**
	 * @param uriInfo 
	 * @throws NamingException 
	 * 
	 */	
	@GET
	@Path("/getFun")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDonacionByFundacionId(@QueryParam("idFundacion") String idFundacion, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlDonacion().getDonacionByFundacionId(idFundacion);

		
	}
	
	//Creo que no es necesario hacerlo en dos tiempos
	@GET
	@Path("/getIdDonUsr")
	@Produces(MediaType.APPLICATION_JSON)
	public String getIdFireDonaUsr(@QueryParam("idDonaBack") String idDonaBack, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlDonacion().getIdFireDonaUsr(idDonaBack);
		
	}
	
	@GET
	@Path("/getPrendDonFun")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPrendasDonacion(@QueryParam("idUsuario") String idUsuario, @QueryParam("idDonaFire") String idDonaFire, @Context UriInfo uriInfo) throws NamingException{
		
		
		return new CrtlDonacion().getPrendasDonacion(idUsuario, idDonaFire);

		
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
			@QueryParam("idDonaFire") String idFire,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		return new CrtlDonacion().addDona(nombreDon, telefonoDon, direccionDon, fechaDon, idUsuario, idFire);
		
		
	}
	
	@PUT
	@Path("/upd")
	@Produces(MediaType.APPLICATION_JSON)
	public String updDona(
			@QueryParam("idDonaFire") String id,
			@QueryParam("estado") String estado,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		
		//Pasar el String a JSON
		String respServ = new CrtlDonacion().updateDonacion(id,estado);
		
		return respServ; 
				
	}
	

}


