package com.conexion;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;

import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.logic.services.ServiciosLogicaPrendaRemote;
import com.data.services.ServiciosUsuarioRemote;

public class ClienteLg {

	public String addUsr(ServiciosLogicaUsuarioRemote dt) {

		System.out.println("Agregar Usuario nombres: miguel, apellidos: ortiz");

		HashMap<String, String> usr = new HashMap<String, String>();

		usr.put("nombres", "miguel");
		usr.put("apellidos", "ortiz");
		usr.put("correo", "migelor");
		usr.put("clave", "migelon123");
		usr.put("cell", "10");
		usr.put("doc", "miguel");
		usr.put("direccion", "ortiz");
		usr.put("tipo", "P");

		String res = dt.addUser(usr);

		return res;

	}
	
	public String delUsr(ServiciosLogicaUsuarioRemote dt) {

		System.out.println("Eliminar Usuario nombres: miguel, apellidos: ortiz");

		HashMap<String, String> usr = new HashMap<String, String>();

		usr.put("id","1");
		usr.put("nombres", "miguel");
		usr.put("nombres", "miguel");
		usr.put("apellidos", "ortiz");
		usr.put("correo", "migelor");
		usr.put("clave", "migelon123");
		usr.put("cell", "10");
		usr.put("doc", "miguel");
		usr.put("direccion", "ortiz");

		//String res = dt.delUsr(usr);

		return "res";

	}

	public String updUsr(ServiciosLogicaUsuarioRemote dt) {

		System.out.println("Actualizar Usuario usr: carl123, pss: crl2020");

		HashMap<String, String> usr = new HashMap<String, String>();

		usr.put("id", "1");
		usr.put("nombres", "Carlos");
		usr.put("apellidos", "Gomez");
		usr.put("usuario", "carl123");
		usr.put("contrasena", "crl2020");

		String res = dt.updUser(usr);

		return res;

	}

	public boolean getPrenda(ServiciosLogicaPrendaRemote dt) {

		System.out.println("Traer Prenda");

		boolean res = dt.tst();

		return res;

	}
	
	
	/**
	 * 
	 */
	public ClienteLg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NamingException {
		
//		System.out.println("Inicia prueba de traer prenda");
//		FireBase base = new FireBase();
//		boolean key = false;
//		try {
//			key = base.getConexion();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(key) {
//			//boolean key2 = base.readFireBase();
//			if(true) {
//				System.out.println("yaaaaaaas");
//			}
//			else
//				System.out.println("nooo");
//		}else
//			System.out.println("noooooooo :(");

		// Buscar la fachada de datos
//		LczPrenda localizadorServicios = new LczPrenda();
//
//		ServiciosLogicaPrendaRemote fachadaLog = null;
//		try {
//			fachadaLog = localizadorServicios.getRemoteFachadaLogica();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		Lcz localizadorServicios = new Lcz();
		ServiciosLogicaUsuarioRemote fachadaLog = null;
		fachadaLog = localizadorServicios.getRemoteFachadaLogica();
		System.out.println("Inicia prueba de agregar usuario");
		System.out.println(new ClienteLg().addUsr(fachadaLog));
		
		// Eliminar usuario DELETE User Funciona
//		System.out.println("Inicia prueba de eliminar usuario");
//		System.out.println(new ClienteLg().delUsr(fachadaLog));

		
//		System.out.println("Inicia prueba de actualizar usuario");
//		System.out.println(new ClienteLg().updUsr(fachadaLog));

		// Invocar el servicio usando la referencia remota
		// Buscar usuario READ List Funciona

//		System.out.println("Prueba de integración");
//		
//		String res = fachadaLog.test();
//		
//		System.out.println(res);

		// Prueba de validacion de usuario
		// Buscar usuario READ Funciona
//		System.out.println("Prueba de validacion de usuario");
//		
//		HashMap<String, String>res2=fachadaLog.getUser("mar123", "mrl2020");
//		
//	    System.out.println(res2);

	}
}
