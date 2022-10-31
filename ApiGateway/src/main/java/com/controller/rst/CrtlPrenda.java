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

import com.logic.services.ServiciosLogicaPrendaRemote;
//import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.conexion.rst.FireBase;
import com.conexion.rst.LocalizadorServicios;
import com.conexion.rst.LocalizadorServiciosPrenda;
import com.google.firebase.FirebaseApp;
import com.rest.ws.PrendaRs;
import com.rest.ws.Usuario;

/**
 * @author danie
 *
 */
public class CrtlPrenda {

	/**
	 * 
	 */
	public CrtlPrenda() {
		// TODO Auto-generated constructor stub
	}

	// ...
	public String getPrenda(String id) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getPrenda() en CrtlPrenda===");
		
		ServiciosLogicaPrendaRemote fachadaLogica = lczFachada();

		return String.valueOf(fachadaLogica.getPrendaById(id));

	}

	// ...
	public String addPrenda(String idFire, String idUsuario, String imgUrl, String genero, String tipo) {
		// TODO Auto-generated method stub
		ServiciosLogicaPrendaRemote fachadaLog = lczFachada();

		HashMap<String, String> prenda = new HashMap<String, String>();

		prenda.put("idFire", idFire);
		prenda.put("idUsuario", idUsuario);
		prenda.put("imgUrl", imgUrl);
		prenda.put("genero", genero);
		prenda.put("tipo", tipo);

		return fachadaLog.addPrenda(prenda);

	}

	// ...
	public String updatePrenda(String id, String idUsuario, String imgUrl, String genero, String tipo) {
		// TODO Auto-generated method stub
		ServiciosLogicaPrendaRemote fachadaLog = lczFachada();

		HashMap<String, String> prenda = new HashMap<String, String>();

		prenda.put("idPrenda", id);
		prenda.put("idUsuario", idUsuario);
		prenda.put("imgUrl", imgUrl);
		prenda.put("genero", genero);
		prenda.put("tipo", tipo);

		return fachadaLog.updPrenda(prenda);
	}

	// ...
	public String deletePrenda(String id) {
		// TODO Auto-generated method stub
		ServiciosLogicaPrendaRemote fachadaLog = lczFachada();

		return fachadaLog.delPrendaById(id);
	}
	
	
	
	// FUNCIONES AUXILIARES
	// Localizador de servicios logica de prenda
	public ServiciosLogicaPrendaRemote lczFachada() {
		// TODO Auto-generated method stub
		LocalizadorServiciosPrenda Lcz = new LocalizadorServiciosPrenda();
		ServiciosLogicaPrendaRemote fachadaLogica = null;

		try {
			fachadaLogica = Lcz.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fachadaLogica;

	}



}
