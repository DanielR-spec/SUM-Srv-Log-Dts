/**
 * 
 */
package com.controller.rst;

import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.logic.services.ServiciosLogicaDonacionRemote;
import com.logic.services.ServiciosLogicaPrendaRemote;
//import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.conexion.rst.FireBase;
import com.conexion.rst.LocalizadorServicios;
import com.conexion.rst.LocalizadorServiciosDonacion;
import com.conexion.rst.LocalizadorServiciosPrenda;
import com.google.firebase.FirebaseApp;
import com.rest.ws.PrendaRs;
import com.rest.ws.Usuario;

/**
 * @author danie
 *
 */
public class CrtlDonacion {

	/**
	 * 
	 */
	public CrtlDonacion() {
		// TODO Auto-generated constructor stub
	}

	// ...
	public String getDonacion(String idDonacion) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getPrenda() en CrtlPrenda===");
		
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();

		return String.valueOf(fachadaLogica.getDonacionById(idDonacion));

	}

	// ...
	public String addDonacion(String idFundacion,
			String nombreDon,
			String telefonoDon,
			String direccionDon,
			String fechaDon,
			String idUsuario,
			String estado,
			String idFire) {
		// TODO Auto-generated method stub
		ServiciosLogicaDonacionRemote fachadaLog = lczFachada();

		HashMap<String, String> donacion = new HashMap<String, String>();

		//donacion.put("idDonacion", "1");
		donacion.put("idFundacion", idFundacion);
		donacion.put("nombreDon", nombreDon);
		donacion.put("telefonoDon", telefonoDon);
		donacion.put("direccionDon", direccionDon);
		donacion.put("fechaDon", fechaDon);
		donacion.put("idUsuario", idUsuario);
		donacion.put("estado", estado);
		donacion.put("idFire", idFire);

		return fachadaLog.addDonacion(donacion);

	}

	// ...
	public String updatePrenda(String id, String idUsuario, String imgUrl, String genero, String tipo) {
		// TODO Auto-generated method stub
//		ServiciosLogicaPrendaRemote fachadaLog = lczFachada();
//
//		HashMap<String, String> prenda = new HashMap<String, String>();
//
//		prenda.put("idPrenda", id);
//		prenda.put("idUsuario", idUsuario);
//		prenda.put("imgUrl", imgUrl);
//		prenda.put("genero", genero);
//		prenda.put("tipo", tipo);
//
//		return fachadaLog.updPrenda(prenda);
		
		return null;
	}

	// ...
	public String deletePrenda(String id) {
		// TODO Auto-generated method stub
		ServiciosLogicaDonacionRemote fachadaLog = lczFachada();

		//return fachadaLog.delPrendaById(id);
		return null;
	}
	
	
	
	// FUNCIONES AUXILIARES
	// Localizador de servicios logica de prenda
	public ServiciosLogicaDonacionRemote lczFachada() {
		// TODO Auto-generated method stub
		LocalizadorServiciosDonacion Lcz = new LocalizadorServiciosDonacion();
		ServiciosLogicaDonacionRemote fachadaLogica = null;

		try {
			fachadaLogica = Lcz.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fachadaLogica;

	}



}
