/**
 * 
 */
package com.conexion.rst;

import java.net.URI;
import java.util.BitSet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.json.JSONObject;
import org.xnio.Bits;

import com.rest.ws.UsuarioDao;

/**
 * @author danie
 *
 */
public class GestorSolicitudesDona {

	 /**
	 * CONSTRUCTOR
	 */
	public GestorSolicitudesDona() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 *FUNCION PARA TRAER EL AGREGADO DE DONACIONES DE LA FUNDACION
	 */  
	
	public String getDonaciones (String idFundacion) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(1)).queryParam("idFundacion", idFundacion);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Donacion no encontrada";
		}
			
		return response;
		
	}
	
	//FUNCION PARA TRAER EL ID DEL USUARIO Y DE LA DONACION CON EL FIN 
	//DE TENER LA REFERENCIA PARA TRAER LAS IMAGENES
	public String getIdDonaUsr(String idDonaBack) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(5)).queryParam("idDonaBack", idDonaBack);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Infofrmacion no encontrada";
		}
			
		return response;	}	
	
	/**
	 *FUNCION PARA TRAER LAS PRENDAS DE UNA DONACION ESPESIFICA
	 */  
	
	public String getPrendasDonacion(String idUsuario, String idDonacion) {
	
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(2))
				.queryParam("idUsuario", idUsuario)
				.queryParam("idDonaFire", idDonacion);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "No hay prendas";
		}
			
		return response;
		
	}
	
	public String getStatsFun(String idFundacion) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(7))
				.queryParam("idFundacion", idFundacion);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "No hay stats";
		}
			
		return response;
	}
	
	public String getStatsUbiFun(String idFundacion) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(8))
				.queryParam("idFundacion", idFundacion);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "No hay stats ubi";
		}
			
		return response;	}
	
	public String updateDonacion(String id, String estado) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(3)).queryParam("idDonaFire", id).queryParam("estado", estado);
		
		Entity<?> empty = Entity.text("");
		Response response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.put(empty);
		
		if(response==null) {
			return "Error actualizando";
		}
			
		return response.readEntity(String.class);
		
	}
	
	public String addDonacion(String nombreDon, String telefonoDon, String direccionDon, String fechaDon,
			String idUsuario, String idFire, String latitud, String longitud, String sector) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(4))
				.queryParam("nombreDon", nombreDon)
				.queryParam("telefonoDon", telefonoDon)
				.queryParam("direccionDon", direccionDon)
				.queryParam("fechaDon", fechaDon)
				.queryParam("idUsuario", idUsuario)
				.queryParam("idFire", idFire)
				.queryParam("lat", latitud)
				.queryParam("long", longitud)
				.queryParam("sector", sector);
		
		Entity<?> empty = Entity.text("");
		Response response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.post(empty);
		
		if(response==null) {
			return "Error actualizando";
		}
			
		return response.readEntity(String.class);
	}
	
	public String getDonacionesUsr(String idUsuario) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(6)).queryParam("idUsuario", idUsuario);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Donacion no encontrada";
		}
			
		return response;
	}
	
	public String getDonacionesUsrStat(String idUsuario) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(9)).queryParam("idUsuario", idUsuario);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.get(String.class);
		
		if(response==null) {
			return "Donacion no encontrada";
		}
			
		return response;
	}
	
	public String getTotDonUsr(String idUsuario) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(10)).queryParam("idUsuario", idUsuario);
		
		String response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		
		if(response==null) {
			return "Fail to read donaciones";
		}
			
		return response;
	}
	
	public String getActiveDonFun(String idFundacion) {
		// TODO Auto-generated method stub
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI(11)).queryParam("idFundacion", idFundacion);
		
		String response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		
		if(response==null) {
			return "Fail to read donaciones";
		}
			
		return response;
	}

	
	//FUNCIONES AUXILIARES 
	private static URI getBaseURI(int option) {
		
			switch (option) {
			case 1:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getFun").build();
			case 2:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getPrendDonFun").build();
			case 3:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/upd").build();
			case 4:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/add").build();
			case 5:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getIdDonUsr").build();
			case 6:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getDonUsr").build();
			case 7:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getStatsFun").build();
			case 8:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getStatsUbiFun").build();
			case 9:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getDonUsrStat").build();
			case 10:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getTotDonUsr").build();
			case 11:
		        return UriBuilder.fromUri("http://localhost:9085/ApiGateway/rest/donacion/getActiveDonFun").build();
			default:
				break;
			}
			return null;
		
	    }






}
