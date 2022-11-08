package com.conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

public class DonacionLg {
	private final static String outputFilePathCart = "C:\\Users\\danie\\Downloads\\imagenes\\uriKeysCart.txt";

	
	
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
		//donacion.put("idFundacion", "1");
		donacion.put("nombreDon","Daniel");
		donacion.put("telefonoDon", "123");
		donacion.put("direccionDon", "calle");
		donacion.put("fechaDon", "2022/02/03");
		donacion.put("idUsuario","2");
		//donacion.put("estado", "confirmada");
		donacion.put("idFire", "1_30_10_2022_19_15_59_1559");
		
		String res = dt.addDonacion(donacion);
		System.out.println(res);
		
	}
	
	public static void getDonacionById(ServiciosLogicaDonacionRemote dt) {
		
		//Agregar Prenda
		
		System.out.println("Metodo traer donacion por Id");

		HashMap<String, String> infDonacion = new HashMap<String, String>();

		
		infDonacion = dt.getDonacionById("0");
		
		for (Entry<String, String> set :
			infDonacion.entrySet()) {

           // Printing all elements of a Map
           System.out.println(set.getKey() + " = "
                              + set.getValue());
       }

		
		
	}
	
	public static void getDonacionByUsrId(ServiciosLogicaDonacionRemote dt) {
		
		//Agregar Prenda
		
		System.out.println("Metodo traer donacion por Id");

		HashMap<String, String> infDonacion = new HashMap<String, String>();

		
		infDonacion = dt.getDonacionByIdUsr("1");
		
		for (Entry<String, String> set :
			infDonacion.entrySet()) {

           // Printing all elements of a Map
           System.out.println(set.getKey() + " = "
                              + set.getValue());
       }	
		
	}
	
	public static void getDonacionesFundacion(ServiciosLogicaDonacionRemote dt) {
		
		//Agregar Prenda
		
		System.out.println("Metodo traer donacion");

		HashMap<String, List<List<String>>> donaciones = new HashMap<String, List<List<String>>>();

		
		donaciones = dt.getDonacionByFundacionId("1");
		
		for (Entry<String, List<List<String>>> set :
			donaciones.entrySet()) {

           // Printing all elements of a Map
           System.out.println(set.getKey() + " = "
                              + set.getValue());
       }

		
		
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

	public static HashMap<String, String> readFile(){
		
		File file = new File(outputFilePathCart);
		
		BufferedReader bf = null;
		
		HashMap<String, String> readFile = new HashMap<String, String>();
		int index = 0;
    	int indexFire = 0;
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
	
	public static void main(String[] args) throws NamingException {
		
	
		//Get EJB conexion
		ServiciosLogicaDonacionRemote donacionRemote =  lczDonacion();
//		HashMap<String, String> donacion = new HashMap<String, String>();
//		donacion = readFile();
//		
//		for (Map.Entry<String, String> set :
//			donacion.entrySet()) {
//
//           // Printing all elements of a Map
//           System.out.println(set.getKey() + " = "
//                              + set.getValue());
//       }
		
		//Test create/add prenda
		//getDonacionesFundacion(donacionRemote);
		
		//Test read/get prenda
		//getPrenda(prendaRemote);
		
		//Test delete prenda
		//deletPrenda(prendaRemote);
		
		//Test delete prenda
		//updatePrenda(prendaRemote);
		
		//Test add donacion
		//addDonacion(donacionRemote);
		
		//Test get donacion by id
		//getDonacionById(donacionRemote);
		
		//Test get donacion by user id
		//getDonacionByUsrId(donacionRemote);
		
	}

}
