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
		System.out.println("===Invocando al metodo getDonacion() en CrtlDonacion===");
		
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();

		return String.valueOf(fachadaLogica.getDonacionById(idDonacion));

	}
	
	// ...
	public String getDonacionByFundacionId(String idFundacion) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getDonacionByFundacionId() en CrtlDonacion===");
		
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();
		
		HashMap<String,List<List<String>>> res = fachadaLogica.getDonacionByFundacionId(idFundacion);
		
		String st = res.toString();
		
		st.trim();
		
		String new_st = st.replace("=", ":");

		return new_st;

	}
	
	// ...
	public String getIdDonUsr(String idDonaBack) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getIdDonUsr() en CrtlDonacion===");
		
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();
		
		HashMap<String,String> res = fachadaLogica.getDonacionById(idDonaBack);

		return res.toString();
	}
	
	// ...
	public String getPrendasByDonaId(String idUsuario, String idDonaFire) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getPrenda() en CrtlPrenda===");
		
		String res = "";
		String formated = "";
		try {
			res = new CrtlDonaFireBase().getPrendasDonaFireBase(idUsuario, idDonaFire);
			formated = res.replaceFirst("=", ":");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return formated;

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
	
	// ...
	public String addDona(String nombreDon, String telefonoDon, String direccionDon, String fechaDon, String idUsuario,
			String idFire, String latitud, String longitud, String sector) {
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
		donacion.put("lat", latitud);
		donacion.put("long", longitud);
		donacion.put("sector", sector);

		return fachadaLogica.addDonacion(donacion);
	}
	
	// ...
	public String getDonacionUsr(String idUsuario) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getDonacionUsr() en CrtlDonacion===");
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();

		HashMap<String,String> res = fachadaLogica.getDonacionByIdUsr(idUsuario);
		
		String st = res.toString();
		
		st.trim();
		
		String new_st = st.replace("=", ":");

		return new_st;
	}
	
	public String getDonacionUsrStat(String idUsuario) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getDonacionUsrStat() en CrtlDonacion===");
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();

		HashMap<String,String> res = fachadaLogica.getDonacionByIdUsrSat(idUsuario);
		
		String st = res.toString();
		
		st.trim();
		
		String new_st = st.replace("=", ":");

		return new_st;
	}

	
	// ...
	public String getStats(String idFundacion) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getStats() en CrtlPrenda===");
		
		String res = "";
		String formated = "";
		String total = "";
		String idDonaFire = "";
		String idUsr = "";
		int totalCam = 0;
		int totalPan = 0;
		int totalZap = 0;
		int totalCha = 0;
		int totalAcc = 0;
		String infoTotal = "";
		String infoTotalCam = "";
		String infoTotalPan = "";
		String infoTotalZap = "";
		String infoTotalCha = "";
		String infoTotalAcc = "";

		
		//Trayendo el id usuario y el id donacion
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();
		ServiciosLogicaPrendaRemote fachadaLogicaPrend = lczFachadaPrend();
		
		HashMap<String,List<String>> finalStatInfo = new HashMap<String, List<String>>();
		List<String>infoCat = new ArrayList<String>();
		List<String>infoTot = new ArrayList<String>();



		HashMap<String,String> resId = fachadaLogica.getCatTonFun(idFundacion);
		
		for (Map.Entry<String, String> set : resId.entrySet()) {

			if (set.getKey().equals("total")) {
				total = set.getValue();
			}
			else if (set.getKey().equals("idFire")) {
				idDonaFire = set.getValue();
			}
			else if (set.getKey().equals("idUser")) {
				idUsr = set.getValue();
			}

		}
		infoTotal ="{"+'"' + "Total" + '"' +":"+ '"' + String.valueOf(total) + '"'+"}";

		infoTot.add(infoTotal);
		
		HashMap<String,List<String>> statsInf = new CrtlDonaFireBase().getTotalIdPrendasDonaFireBase(idDonaFire,idUsr);
		for (Map.Entry<String, List<String>> set : statsInf.entrySet()) {
			List<String> ids = set.getValue();
			
			for (String infoIds : ids) {
				String idBackPrend = fachadaLogicaPrend.getIdPrendaByIdFire(infoIds);
				HashMap<String, String> categoriaRst = fachadaLogicaPrend.getCatPrendaByIdStats(idBackPrend);

				for (Map.Entry<String, String> cont : categoriaRst.entrySet()) {
					if (cont.getValue().equals("Camisas")) {
						totalCam += 1;
						
					}else if (cont.getValue().equals("Pantalones")) {
						totalPan += 1;
						
					}else if (cont.getValue().equals("Zapatos")) {
						totalZap += 1;
						
					}else if (cont.getValue().equals("Accesorios")) {
						totalAcc += 1;
						
					}else if (cont.getValue().equals("Chaquetas")) {
						totalCha += 1;
						
					}
					
				}

			}
			infoTotalCam = "{" + '"' + "Camisas" + '"' +":"+ '"' + String.valueOf(totalCam) + '"';
			infoTotalPan = '"' + "Pantalones" + '"' +":"+ '"' + String.valueOf(totalPan) + '"';
			infoTotalZap = '"' + "Zapatos" + '"' +":"+ '"' + String.valueOf(totalZap) + '"';
			infoTotalCha = '"' + "Accesorios" + '"' +":"+ '"' + String.valueOf(totalAcc) + '"';
			infoTotalAcc = '"' + "Chaquetas" + '"' +":"+ '"' + String.valueOf(totalCha) + '"' + "}";
			
			infoCat.add(infoTotalCam);
			infoCat.add(infoTotalPan);
			infoCat.add(infoTotalZap);
			infoCat.add(infoTotalCha);
			infoCat.add(infoTotalAcc);
			
		}
		
		finalStatInfo.put('"' + "headers" + '"', infoTot);

		finalStatInfo.put('"' + "rows" + '"', infoCat);
		
		res = String.valueOf(finalStatInfo);
		
		formated = res.replace("=", ":");
		
		return formated;
	}
	
	public String getStatsUbiFun(String idFundacion) {
		// TODO Auto-generated method stub
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();
		String res = "";
		String formated = "";
		
		HashMap<String,List<String>> ubiDon = fachadaLogica.getUbiDonacionByFundacionId(idFundacion);
		
		res = String.valueOf(ubiDon);
		
		formated = res.replace("=", ":");
		
		return formated;
		
	}
	
	public String getTotDonUsr(String idUsuario) {
		// TODO Auto-generated method stub
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();
		String res = "";
		
		res = fachadaLogica.getTotDonUsr(idUsuario);
		
		
		return res;
	}
	
	public String getActiveDonFun(String idFundacion) {
		// TODO Auto-generated method stub
		ServiciosLogicaDonacionRemote fachadaLogica = lczFachada();
		String res = "";
		
		res = fachadaLogica.getActiveDonFun(idFundacion);
		
		
		return res;	}
	
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
	
	// Localizador de servicios logica de prenda
	public ServiciosLogicaPrendaRemote lczFachadaPrend() {
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




}
