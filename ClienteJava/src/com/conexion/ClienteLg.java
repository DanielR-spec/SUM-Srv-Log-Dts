package com.conexion;

import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;

import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.data.services.ServiciosUsuarioRemote;

public class ClienteLg {
	
	public String addUsr(ServiciosLogicaUsuarioRemote dt) {
		
		System.out.println("Agregar Usuario usr: miguel, pss: ortiz");
		
		HashMap<String, String>usr= new HashMap<String, String>();
		
		usr.put("id", "10");
		usr.put("nombres", "miguel");
		usr.put("apellidos", "ortiz");
		usr.put("usuario", "migelor");
		usr.put("contrasena", "migelon123");
		
		String res = dt.addUser(usr);
				
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

		// Buscar la fachada de datos
		Lcz localizadorServicios = new Lcz();

		ServiciosLogicaUsuarioRemote fachadaLog = null;
		try {
			fachadaLog = localizadorServicios.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Inicia prueba de agregar usuario");
		System.out.println(new ClienteLg().addUsr(fachadaLog));

		// Invocar el servicio usando la referencia remota
		// Buscar usuario READ List Funciona

//		System.out.println("Prueba de integración");
//		
//		String res = fachadaLog.test();
//		
//		System.out.println(res);
		
		
		//Prueba de validacion de usuario
		// Buscar usuario READ Funciona
//		System.out.println("Prueba de validacion de usuario");
//		
//		HashMap<String, String>res2=fachadaLog.getUser("mar123", "mrl2020");
//		
//	    System.out.println(res2);

	}
}
