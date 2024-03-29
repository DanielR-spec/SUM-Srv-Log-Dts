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
import java.net.URL;
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

import org.apache.commons.lang3.StringUtils;  

/**
 * @author danie
 *
 */
public class CrtlDonaFireBase {

	/**
	 * 
	 */
	public CrtlDonaFireBase() {
		// TODO Auto-generated constructor stub
	}

	// FUNCIONES DE FIREBASE
	public String getPrendasDonaFireBase(String idUsuario, String idDonaFire) throws IOException {
		System.out.println("===Invocando al metodo getPrendasDonaFireBase() en CrtlDonaFireBase===");

		// TODO Auto-generated method stub
		String STATUS_CODE = ":(";
		FireBase base = new FireBase();
		String keySaved = "Not Added";
		HashMap<String,  List<List<String>>> uriKeys = new HashMap<String,   List<List<String>>>();

		try {
			System.out.println("Iniciando proceso de conexion...");
			//Este parte del proceso escribe la informacion de los id en txt para ser 
			//leidos en la siguiente parte
			keySaved = base.getUriKeysPrendas(idUsuario, idDonaFire);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (keySaved.equals("Files Added")) {
			// Declarar hashmap y llamar la funcion
			//Esta parte lee la informacion leida en el txt ya fomateada
			uriKeys = uriFormatTemp();
			STATUS_CODE = ":)";
			System.out.println("Prenda existosamente guardada" + STATUS_CODE);

			return uriKeys.toString();

		}
		return uriKeys.toString();

		//return uriKeys.toString();

	}

	public HashMap<String,  List<String>> getTotalIdPrendasDonaFireBase(String idDonaFire, String idUsr) {
		// TODO Auto-generated method stub
		System.out.println("===Invocando al metodo getPrendasDonaFireBase() en CrtlDonaFireBase===");

		// TODO Auto-generated method stub
		String STATUS_CODE = ":(";
		FireBase base = new FireBase();
		String keySaved = "Not Added";
		HashMap<String,  List<String>> uriKeys = new HashMap<String,   List<String>>();

		System.out.println("Iniciando proceso de conexion...");
		//Este parte del proceso escribe la informacion de los id en txt para ser 
		//leidos en la siguiente parte
		keySaved = base.getIdPrendas(idDonaFire, idUsr);
		
		if (keySaved.equals("Files Added")) {
			// Declarar hashmap y llamar la funcion
			//Esta parte lee la informacion leida en el txt ya fomateada
			uriKeys = uriFormatIdPren();
			STATUS_CODE = ":)";
			System.out.println("Prenda existosamente guardada" + STATUS_CODE);

			return uriKeys;

		}
		return uriKeys;
	}
	
	public HashMap<Integer, PrendaRs> uriFormat() {

		System.out.println("===Invocando al metodo uriFormat() en CrtlPrenda===");

		// File path is passed as parameter
		File file = new File("C:\\Users\\danie\\Downloads\\imagenes\\uriKeysPrend.txt");

		HashMap<Integer, PrendaRs> uriKeys = new HashMap<Integer, PrendaRs>();

		uriKeys = saveMap(file);

		for (Map.Entry<Integer, PrendaRs> set : uriKeys.entrySet()) {

			// Printing all elements of a Map
			System.out.println("Key: " + set.getKey());
			System.out.println("Value: ");
			System.out.println("  Nombre: " + set.getValue().getNombre());
			System.out.println("  Uri: " + set.getValue().getUri());

		}

		// Note: Double backquote is to avoid compiler
		// interpret words
		// like \test as \t (ie. as a escape sequence)

		return uriKeys;

	}
	
	public HashMap<String,  List<List<String>>> uriFormatTemp() {

		System.out.println("===Invocando al metodo uriFormat() en CrtlPrenda===");

		// File path is passed as parameter
		File file = new File("C:\\Users\\danie\\Downloads\\imagenes\\uriKeysPrend.txt");

		HashMap<String,  List<List<String>>> uriKeys = new HashMap<String,   List<List<String>>>();

		uriKeys = saveMapTemp(file);

		return uriKeys;

	}

	public HashMap<String, List<String>> uriFormatIdPren() {

		System.out.println("===Invocando al metodo uriFormat() en CrtlPrenda===");

		// File path is passed as parameter
		File file = new File("C:\\Users\\danie\\Downloads\\imagenes\\uriKeysPrendId.txt");

		HashMap<String,  List<String>> uriKeys = new HashMap<String, List<String>>();

		uriKeys = saveMapIdPrend(file);

		return uriKeys;

	}
	
	public HashMap<Integer, PrendaRs> saveMap(File file) {

		HashMap<Integer, PrendaRs> uriKeys = new HashMap<Integer, PrendaRs>();

		// Declaring a string variable

		String str = "";
		String lineKey = "in";
		int cont = 0;
		int length = 0;

		// Creating an object of BufferedReader class
		BufferedReader br = null;

		try {
			System.out.println("Leyendo archivo...");
			br = new BufferedReader(new FileReader(file));

			// Condition holds true till
			// there is character in a string

			try {
				System.out.println("Cargando archivo...");
				int mapIndex = 0;
				while ((str = br.readLine()) != null) {// Print the string
					PrendaRs prendaRs = new PrendaRs();
					String idDonaFire = "";
					String uri = "";

					// Creating array of string length
					// using length() method
					char[] chNames = new char[str.length()];
					char[] chKeys = new char[str.length()];

					length = str.length();

					String flag = "chNm";

					// System.out.println(str);

					// Copying character by character into array
					// using for each loop

					for (int i = 0; i < length; i++) {
						lineKey = Character.toString(str.charAt(i));

						if (flag.equals("chNm")) {
							chNames[i] = str.charAt(i);

							if (lineKey.equals("@")) {
								idDonaFire = String.valueOf(chNames);
								prendaRs.setNombre(idDonaFire);
								flag = "chUri";

							}

						}

						else if (flag.equals("chUri") && !lineKey.equals("@")) {

							chKeys[cont] = str.charAt(i);

							if (i == (length - 1)) {
								uri = String.valueOf(chKeys);
								prendaRs.setUri(uri);
								cont = 0;

							}
							cont += 1;
						}

					}

					uriKeys.put(mapIndex, prendaRs);
					mapIndex += 1;

				}
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return uriKeys;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return uriKeys;

	}
	
	public HashMap<String,  List<List<String>>> saveMapTemp(File file) {

		HashMap<String,  List<List<String>>> uriKeys = new HashMap<String,   List<List<String>>>();

		// Declaring a string variable

		String str = "";
		String lineKey = "in";
		int cont = 0;
		int length = 0;
		
		List< List<String>> externalValues = new ArrayList<List<String>>();

		// Creating an object of BufferedReader class
		BufferedReader br = null;

		try {
			System.out.println("Leyendo archivo...");
			br = new BufferedReader(new FileReader(file));

			// Condition holds true till
			// there is character in a string

			try {
				System.out.println("Cargando archivo...");
				int mapIndex = 0;
				while ((str = br.readLine()) != null) {// Print the string
					List<String>links = new ArrayList<String>();
					PrendaRs prendaRs = new PrendaRs();
					String idPrendFire = "";
					String uri;

					// Creating array of string length
					// using length() method
					char[] chNames = new char[str.length()];
					char[] chKeys = new char[str.length()];

					length = str.length();

					String flag = "chNm";

					// System.out.println(str);

					// Copying character by character into array
					// using for each loop

					for (int i = 0; i < length; i++) {
						lineKey = Character.toString(str.charAt(i));

						if (flag.equals("chNm")) {
							chNames[i] = str.charAt(i);

							if (lineKey.equals("@")) {
								idPrendFire = String.valueOf(chNames).trim();
								idPrendFire = StringUtils.chop(idPrendFire); 
								idPrendFire = '"' + idPrendFire + '"';

								prendaRs.setNombre(idPrendFire);
								links.add(prendaRs.getNombre());
								flag = "chUri";

							}

						}

						else if (flag.equals("chUri") && !lineKey.equals("@")) {

							chKeys[cont] = str.charAt(i);

							if (i == (length - 1)) {
								uri = '"'+String.valueOf(chKeys).trim()+'"';
								prendaRs.setUri(uri);
								links.add(prendaRs.getUri());
								externalValues.add(links);
								cont = 0;

							}
							cont += 1;
						}

					}
					
					uriKeys.put('"' +"rows"+'"', externalValues);
					mapIndex += 1;

				}
				
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return uriKeys;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return uriKeys;

	}

	public HashMap<String,  List<String>> saveMapIdPrend(File file) {

		HashMap<String, List<String>> uriKeys = new HashMap<String, List<String>>();

		// Declaring a string variable

		String str = "";
		String lineKey = "in";
		int cont = 0;
		int length = 0;
		
		List<String> externalValues = new ArrayList<String>();

		// Creating an object of BufferedReader class
		BufferedReader br = null;

		try {
			System.out.println("Leyendo archivo...");
			br = new BufferedReader(new FileReader(file));

			// Condition holds true till
			// there is character in a string

			try {
				System.out.println("Cargando archivo...");
				while ((str = br.readLine()) != null) {// Print the string
					PrendaRs prendaRs = new PrendaRs();
					String idPrendFire = "";

					// Creating array of string length
					// using length() method
					char[] chNames = new char[str.length()];

					length = str.length();

					String flag = "chNm";

					// System.out.println(str);

					// Copying character by character into array
					// using for each loop

					for (int i = 0; i < length; i++) {
						lineKey = Character.toString(str.charAt(i));

						if (flag.equals("chNm")) {
							chNames[i] = str.charAt(i);

							if (lineKey.equals("@")) {
								idPrendFire = String.valueOf(chNames).trim();
								idPrendFire = StringUtils.chop(idPrendFire); 
								prendaRs.setNombre(idPrendFire);
								externalValues.add(prendaRs.getNombre());
								flag = "chUri";

							}

						}

					}
					
					uriKeys.put("id", externalValues);
				}
				
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return uriKeys;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return uriKeys;

	}
	
}
