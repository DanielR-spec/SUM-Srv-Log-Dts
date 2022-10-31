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

import jersey.repackaged.org.*;

import com.conexion.rst.GestorSolicitudes;
import com.controller.rst.ControladorSrv;
import com.controller.rst.CrtlPrenda;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @author danie
 *
 */
@Path("/prenda")
public class RestApiPrenda {

	/**
	 * @param uriInfo 
	 * @throws NamingException 
	 * 
	 */	
	
	//Funciona
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsr(
			@QueryParam("idPrenda") String id,
			@Context UriInfo uriInfo) throws NamingException {
		    		
		return new CrtlPrenda().getPrenda(id);
	}
	
	//Definición: Metodo ubicado a nivel de servicios actua como puente de acceso para
	//iniciar el proceso de creacion de prenda
	//Entrada: Atributos de creacion de prenda de usuario
	//Salida: Str respuesta si se agrego o no
	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public String addPrend(
			@QueryParam("idFire") String idFire,
			@QueryParam("idUsuario") String idUsuario,
			@QueryParam("imgUrl") String imgUri,
			@QueryParam("genero") String genero,
			@QueryParam("tipo") String ruta,
			@Context UriInfo uriInfo)
			throws NamingException{
		
		return new CrtlPrenda().addPrnd(idFire, idUsuario, imgUri, genero, ruta);
		
		
	}
		
				
		
		//Pasar el String a JSON
		//String respServ = new CrtlPrenda().addPrnd(tipo, genero, ruta, imagen);
		
//		System.out.println("Tipo: " + tipo);
//	    System.out.println("Genero: " + genero);
//	    System.out.println("Ruta: " + ruta);
//	    
//	    System.out.println("Imagen...");
//		
//		 try {
//			BufferedImage img = ImageIO.read(imagen);
//			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
//			  
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        return Response.ok("Cool Tools!").build();
//		
				
	
	
	
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
