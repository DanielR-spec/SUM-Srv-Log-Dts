package com.conexion;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.naming.NamingException;

import com.logic.services.ServiciosLogicaPrendaRemote;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.model.ent.Prenda;
import com.model.ent.Usuario;
import com.data.services.ServiciosPrendaRemote;
import com.data.services.ServiciosUsuarioRemote;

public class PrendaCRUDLg {
	
	
	/**
	 * 
	 */
	public PrendaCRUDLg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ServiciosLogicaPrendaRemote lczPrnd() {
		
		// Buscar la fachada de datos
		LczPrendaLg localizadorServicios = new LczPrendaLg();

		ServiciosLogicaPrendaRemote fachadaLog = null;
		try {
			fachadaLog = localizadorServicios.getRemoteFachadaLogica();
			return fachadaLog;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fachadaLog;
		
	}

	public static void addPrenda(ServiciosLogicaPrendaRemote dt) {
		
		//Agregar Prenda
		
		System.out.println("Agregar Prenda id:1 , idUsr: 2, Url:https://www.google.com/search?q=triger+mysql&oq=triger+mysql&aqs=chrome..69i57j0i10i512l9.3347j1j7&sourceid=chrome&ie=UTF-8");

		HashMap<String, String> prenda = new HashMap<String, String>();

		prenda.put("idUsuario", "3");
		prenda.put("imgUri", "http://forUs.com");
		prenda.put("genero","F");
		prenda.put("tipo", "camiseta");
		
		String res = dt.addPrenda(prenda);
		System.out.println(res);
		
	}

	public static void getPrenda(ServiciosLogicaPrendaRemote dt) {
		
		//Traer Prenda
		
		String id = "1";
		HashMap<String, String> prenda = new HashMap<String, String>();

		prenda = dt.getPrendaById(id);
		
		Prenda prenda2 = new Prenda();
		
		for (Entry<String, String> entry : prenda.entrySet()) {
			switch (entry.getKey()) {
			case "idPrenda": {
				if (entry.getValue() != "") {
					prenda2.setIdPrenda(Integer.parseInt(entry.getValue()));
					break;

				}
				break;

			}
			case "idUsuario": {
				if (entry.getValue() != "") {
					prenda2.setIdUsuario(Integer.parseInt(entry.getValue()));
					break;
				}
				break;

			}
			case "imgUrl": {
				if (entry.getValue() != "") {
					prenda2.setImageUrl(entry.getValue());
					break;

				}
				break;

			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
			}

		}
		
		System.out.println("Respuesta get prenda id: 1");
		System.out.println("idPrenda: " + prenda2.getIdPrenda());
		System.out.println("idUsuario: " + prenda2.getIdUsuario());
		System.out.println("imgUri: " + prenda2.getImageUrl());

				
	}
	
	public static void deletPrenda(ServiciosLogicaPrendaRemote dt) {
		
 		//Eliminar prenda DELETE prenda Funciona
		
		System.out.println("Eliminar prenda idPrenda: 3");
 		Prenda prenda = new Prenda();
 		prenda.setIdPrenda(3);
		String res = dt.delPrendaById(String.valueOf(prenda.getIdPrenda()));
		
		System.out.println(res);
	
	
		System.out.println("End Function 3"+ "\n");
				
	}
	
	public static String updatePrenda(ServiciosLogicaPrendaRemote dt) {
		
		
		// Actualizar prenda UPDATE User

		System.out.println("Agregar Prenda id:1 , idUsr: 2, Url:https://www.google.com/search?q=triger+mysql&oq=triger+mysql&aqs=chrome..69i57j0i10i512l9.3347j1j7&sourceid=chrome&ie=UTF-8");

		HashMap<String, String> prenda = new HashMap<String, String>();

		prenda.put("idPrenda", "3");
		prenda.put("idUsuario", "3");
		prenda.put("imgUri", "http://forUs.com");
		prenda.put("genero","F");
		prenda.put("tipo", "camiseta");
		
		String res = dt.updPrenda(prenda);
		System.out.println("End Function 3"+ "\n");
		return res;
						
	}

	public static void main(String[] args) throws NamingException {
		
	
		//Get EJB conexion
		ServiciosLogicaPrendaRemote prendaRemote = lczPrnd();
		
		//Test create/add prenda
		//addPrenda(prendaRemote);
		
		//Test read/get prenda
		//getPrenda(prendaRemote);
		
		//Test delete prenda
		deletPrenda(prendaRemote);
		
		//Test delete prenda
		//updatePrenda(prendaRemote);
		
	


	}

}
