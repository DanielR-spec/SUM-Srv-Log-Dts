package com.conexion;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.naming.NamingException;

import com.logic.services.ServiciosLogicaDonacionRemote;
import com.logic.services.ServiciosLogicaPrendaRemote;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.model.ent.Prenda;
import com.model.ent.Usuario;
import com.data.services.ServiciosDonacionRemote;
import com.data.services.ServiciosPrendaRemote;
import com.data.services.ServiciosUsuarioRemote;

public class DonacionLg {
	
	
	/**
	 * 
	 */
	public DonacionLg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ServiciosLogicaDonacionRemote lczDonacion() {
		
		// Buscar la fachada de datos
		LczDonacionLg localizadorServicios = new LczDonacionLg();

		ServiciosLogicaDonacionRemote fachadaLog = null;
		try {
			fachadaLog = localizadorServicios.getRemoteFachadaLogica();
			return fachadaLog;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fachadaLog;
		
	}

	public static void addDonacion(ServiciosLogicaDonacionRemote dt) {
		
		//Agregar Prenda
		
		System.out.println("Metodo agregar donacion");

		HashMap<String, String> donacion = new HashMap<String, String>();

		//donacion.put("idDonacion", "1");
		donacion.put("idFundacion", "1");
		donacion.put("nombreDon","dan");
		donacion.put("telefonoDon", "123");
		donacion.put("direccionDon", "calle");
		donacion.put("fechaDon", "2022/02/03");
		donacion.put("idUsuario","1");
		donacion.put("estado", "confirmada");
		donacion.put("idFire", "1_2_3");
		
		String res = dt.addDonacion(donacion);
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
		ServiciosLogicaDonacionRemote donacionRemote =  lczDonacion();
		
		//Test create/add prenda
		//addDonacion(donacionRemote);
		
		//Test read/get prenda
		//getPrenda(prendaRemote);
		
		//Test delete prenda
		//deletPrenda(prendaRemote);
		
		//Test delete prenda
		//updatePrenda(prendaRemote);
		
	


	}

}
