/**
 * 
 */
package com.controller.rst;

import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.logic.services.ServiciosLogicaCarritoRemote;
import com.logic.services.ServiciosLogicaDonacionRemote;
import com.logic.services.ServiciosLogicaPrendaRemote;
//import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.conexion.rst.FireBase;
import com.conexion.rst.LocalizadorServicios;
import com.conexion.rst.LocalizadorServiciosCarrito;
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
	private final static String outputFilePathCart = "C:\\Users\\danie\\Downloads\\imagenes\\uriKeysCart.txt";


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
	public String getDonacionByFundacionId(String idFundacion) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getPrenda() en CrtlPrenda===");
		
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();
		
		HashMap<String,List<List<String>>> res = fachadaLogica.getDonacionByFundacionId(idFundacion);
		
		String st = res.toString();
		
		String new_st = st.replace("=", ":");

		return new_st;

	}

	// ...
	public String addDonacion(
			String nombreDon,
			String telefonoDon,
			String direccionDon,
			String fechaDon,
			String idUsuario,
			String estado,
			String idFire) {
		// TODO Auto-generated method stub
		ServiciosLogicaDonacionRemote fachadaLog = lczFachada();
		ServiciosLogicaCarritoRemote fachadaLogCar = lczFachadaCart();

		HashMap<String, String> donacion = new HashMap<String, String>();
		
		String keySaved = ":)";


		//donacion.put("idDonacion", "1");
		//donacion.put("idFundacion", idFundacion);
		donacion.put("nombreDon", nombreDon);
		donacion.put("telefonoDon", telefonoDon);
		donacion.put("direccionDon", direccionDon);
		donacion.put("fechaDon", fechaDon);
		donacion.put("idUsuario", idUsuario);
		donacion.put("estado", estado);
		donacion.put("idFire", idFire);
		
		//String res = fachadaLog.addDonacion(donacion);
		String res = "Donacion insertada";
		
		if (res.equals("Donacion insertada")) {
			
			String STATUS_CODE = ":(";
			FireBase base = new FireBase();
			HashMap<String, String> cartRef = new HashMap<String, String>();

			try {
				System.out.println("Iniciando proceso de conexion...");
				keySaved = base.getUriKeysCart(idUsuario,idFire);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (keySaved.equals("Files Added")) {
				
				String flag;
				
				System.out.println("Prenda existosamente guardada :)");
				
				cartRef = readFile();
				flag = fachadaLogCar.addCarrito(cartRef);
				
				//fachadaLog.addDonacion(donacion);

				return flag;

			}
		}

		
		return keySaved;

	}

	// ...
	public String updateDonacion(String id, String estado) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo updateDonacion() en CrtlDonacion===");
		
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();

		return String.valueOf(fachadaLogica.updDonacion(id, estado));
	}

	// ...
	public String deleteDonacion(String id) {
		// TODO Auto-generated method stub
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
	// Localizador de servicios logica de prenda
	public ServiciosLogicaCarritoRemote lczFachadaCart() {
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
	
	public static HashMap<String, String> readFile(){
		
		File file = new File(outputFilePathCart);
		
		BufferedReader bf = null;
		
		HashMap<String, String> readFile = new HashMap<String, String>();

		 try {
			  
	            // create new BufferedWriter for the output file
	            bf = new BufferedReader(new FileReader(file));
	            String st;
	            int aux = 2000;
	            
	            while ((st = bf.readLine()) != null) {
	        		System.out.println("Entro al metodo");
	        		String auxStr = "";
		            String auxStrNam = "";
	        		for (int i = 0; i < st.length(); i++) {
	        			
	        			 
	                    // Print current character
	                    if(String.valueOf(st.charAt(i)).equals("@")) {
	                    	aux = i;
	                    	
	                    }
	                    
	                    if (aux < i) {
	                    	auxStr += String.valueOf(st.charAt(i));
	                    }
	                    if (aux > i) {
	                    	auxStrNam += String.valueOf(st.charAt(i));
	                    }
	                }
	        		
	        		readFile.put(auxStrNam, auxStr);
	        		
	            }
            
	            return readFile;
	            
	  
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally {
	  
	            try {
	  
	                // always close the writer
	                bf.close();
	            }
	            catch (Exception e) {
	            }
	        }
		 return readFile;
	}

	public String addDona(String nombreDon, String telefonoDon, String direccionDon, String fechaDon, String idUsuario,
			String idFire) {
		System.out.println("===Invocando al metodo addDona() en CrtlDonacion===");
		
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();
		
		HashMap<String, String> donacion = new HashMap<String, String>();

		//donacion.put("idDonacion", "1");
		//donacion.put("idFundacion", "1");
		donacion.put("nombreDon",nombreDon);
		donacion.put("telefonoDon", telefonoDon);
		donacion.put("direccionDon", direccionDon);
		donacion.put("fechaDon", fechaDon);
		donacion.put("idUsuario",idUsuario);
		donacion.put("idFire", idFire);

		return fachadaLogica.addDonacion(donacion);
	}

}
