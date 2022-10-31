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
public class CrtlPrendaFireBase {

	/**
	 * 
	 */
	public CrtlPrendaFireBase() {
		// TODO Auto-generated constructor stub
	}

	// FUNCIONES DE FIREBASE
	public String getPrendaFireBase() throws IOException {
		System.out.println("===Invocando al metodo authPrnd() en CrtlPrenda===");

		// TODO Auto-generated method stub
		String STATUS_CODE = ":(";
		FireBase base = new FireBase();
		String keySaved = null;
		HashMap<Integer, PrendaRs> uriKeys = new HashMap<Integer, PrendaRs>();

		try {
			System.out.println("Iniciando proceso de conexion...");
			keySaved = base.getUriKeys();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (keySaved != null) {
			// Declarar hashmao y llamar la funcion
			uriKeys = uriFormat();
			// Logica
			System.out.println("Prenda existosamente guardada :)");

			return uriKeys.toString();

		}

		return uriKeys.toString();
	}

	public HashMap<Integer, PrendaRs> uriFormat() {

		System.out.println("===Invocando al metodo uriFormat() en CrtlPrenda===");

		// File path is passed as parameter
		File file = new File("C:\\Users\\danie\\Downloads\\imagenes\\uriKeys.txt");

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
					String nombre = "";
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
								nombre = String.valueOf(chNames);
								prendaRs.setNombre(nombre);
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
