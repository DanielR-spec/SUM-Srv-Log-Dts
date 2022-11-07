package com.conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.NamingException;

import com.logic.services.ServiciosLogicaDonacionRemote;
import com.logic.services.ServiciosLogicaPrendaRemote;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.model.ent.Donacion;
import com.model.ent.Prenda;
import com.model.ent.Usuario;
import com.data.services.ServiciosDonacionRemote;
import com.data.services.ServiciosPrendaRemote;
import com.data.services.ServiciosUsuarioRemote;

public class DonacionDt {
	private final static String outputFilePathCart = "C:\\Users\\danie\\Downloads\\imagenes\\uriKeysCart.txt";

	
	
	/**
	 * 
	 */
	public DonacionDt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ServiciosDonacionRemote lczDonacion() {
		
		// Buscar la fachada de datos
		LczDonacion localizadorServicios = new LczDonacion();

		ServiciosDonacionRemote fachadaDat = null;
		try {
			fachadaDat = localizadorServicios.getRemoteFachadaLogica();
			return fachadaDat;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fachadaDat;
		
	}

	public static void getDonacion(ServiciosDonacionRemote dt) {
		
		//Agregar Prenda
		
		System.out.println("Metodo traer donacion");
		List<Donacion> donaciones = new ArrayList<Donacion>();
		donaciones = dt.findDonacionByFundacionId(1);
		
		for (Donacion donacion : donaciones) {
			System.out.println(donacion.getIdDonaFire());
		}
		
		HashMap<String, List<Donacion>> mapDonacion = new HashMap<>();
		
		mapDonacion.put("rows", donaciones);

		
	}
	
	public static void getDonacionById(ServiciosDonacionRemote dt) {
		
		//Agregar Prenda
		
		System.out.println("Metodo traer donacion con id Back");
		List<Donacion> donaciones = new ArrayList<Donacion>();
		donaciones = dt.findDonacionById(0);
		
		for (Donacion donacion : donaciones) {
			System.out.println(donacion.getIdDonaFire());
		}
		
		HashMap<String, List<Donacion>> mapDonacion = new HashMap<>();
		
		mapDonacion.put("rows", donaciones);

		
	}
	
	public static void main(String[] args) throws NamingException {
		
	
		//Get EJB conexion
		ServiciosDonacionRemote donacionRemote =  lczDonacion();
		

		//Test create/add prenda
		//addDonacion(donacionRemote);
		
		//Test read/get prenda
		//getPrenda(prendaRemote);
		
		//Test delete prenda
		//deletPrenda(prendaRemote);
		
		//Test delete prenda
		//updatePrenda(prendaRemote);
		
		//Test get donacion by id Fundacion
		//getDonacion(donacionRemote);
		
		//Test get donacion by id Fundacion
		getDonacionById(donacionRemote);


	}

}
