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

import com.logic.services.ServiciosLogicaCarritoRemote;
import com.logic.services.ServiciosLogicaPrendaRemote;
//import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.conexion.rst.FireBase;
import com.conexion.rst.LocalizadorServicios;
import com.conexion.rst.LocalizadorServiciosCarrito;
import com.conexion.rst.LocalizadorServiciosPrenda;
import com.google.firebase.FirebaseApp;
import com.rest.ws.PrendaRs;
import com.rest.ws.Usuario;

/**
 * @author danie
 *
 */
public class CrtlCart {

	/**
	 * 
	 */
	public CrtlCart() {
		// TODO Auto-generated constructor stub
	}

	public String getCartId(String idCart) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String addCart(String idUsuario) {
		// TODO Auto-generated method stub
		ServiciosLogicaCarritoRemote fachadaLog = lczFachada();

		HashMap<String, String> cart = new HashMap<String, String>();

		
		cart.put("idUsuario", idUsuario);

		return fachadaLog.addCarrito(cart);
	}
	
	
	
	// FUNCIONES AUXILIARES
	// Localizador de servicios logica de prenda
	public ServiciosLogicaCarritoRemote lczFachada() {
		// TODO Auto-generated method stub
		LocalizadorServiciosCarrito Lcz = new LocalizadorServiciosCarrito();
		ServiciosLogicaCarritoRemote fachadaLogica = null;

		try {
			fachadaLogica = Lcz.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fachadaLogica;

	}






}
