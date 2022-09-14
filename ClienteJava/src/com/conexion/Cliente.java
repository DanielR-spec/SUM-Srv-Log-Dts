package com.conexion;

import java.util.List;

import javax.naming.NamingException;

import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.data.services.ServiciosUsuarioRemote;

public class Cliente {
	
	
	/**
	 * 
	 */
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String addUsr(ServiciosUsuarioRemote dt) {
		
		System.out.println("Agregar Usuario usr: ping, pss: pong");
		Usuario newUsuario = new Usuario();
		newUsuario.setIdUsuario(9);
		newUsuario.setNombres("Lelo");
		newUsuario.setApellidos("Lola");
		newUsuario.setUsername("king12");
		newUsuario.setPassword("kong12");
		String res = dt.addUsuario(newUsuario);
		
		System.out.println(res);
		
		return res;
		
	}

	public static void main(String[] args) throws NamingException {

		// Buscar la fachada de datos
		LczDt localizadorServicios = new LczDt();

		ServiciosUsuarioRemote fachadaData = null;
		try {
			fachadaData = localizadorServicios.getRemoteFachadaData();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Inicia prueba de agregar usuario");
		System.out.println(new Cliente().addUsr(fachadaData));

		// Invocar el servicio usando la referencia remota
		// Buscar usuario READ List Funciona

//		System.out.println("Buscar Usuario usr: mar123, pss: mrl2020");
//		List<Usuario> lista = fachadaData.findUsuario("mar123", "mrl2020");
//
//		if (lista == null) {
//			System.out.println("Usuario no existe");
//		} else {
//
//			for (Usuario user : lista) {
//				System.out.print(user.getNombres() + "\n");
//			}
//
//		}
//
//		System.out.println("End Function 1 "+ "\n");
//
//		// Agregar usuario CREATE User Funciona
//
//		System.out.println("Agregar Usuario usr: ping, pss: pong");
//		Usuario newUsuario = new Usuario();
//		newUsuario.setIdUsuario(7);
//		newUsuario.setNombres("Lelo");
//		newUsuario.setApellidos("Lola");
//		newUsuario.setUsername("king12");
//		newUsuario.setPassword("kong12");
//		String res = fachadaData.addUsuario(newUsuario);
//		
//		System.out.println(res);
//		
//	
//		System.out.println("End Function2"+ "\n");
		
		// Traer Todos los usuario READ List Funciona

//		System.out.println("Traer todos los usuarios");
//		List<Usuario> lista2 = fachadaData.getAllUsuarios();
//
//		if (lista2 == null) {
//			System.out.println("no hay usuarios");
//		} else {
//
//			for (Usuario user : lista2) {
//				System.out.print(user.getNombres() + "\n");
//			}
//
//		}
//
//		System.out.println("End Function 3 "+ "\n");
		
		// Eliminar usuario DELETE User Funciona
		/*
		System.out.println("Eliminar usuario usr: hola, pss: hola");
		Usuario newUsuario2 = new Usuario();
		newUsuario2.setIdUsuario(4);
		String res2 = fachadaData.delUsuario(newUsuario2);
		
		System.out.println(res2);
		
	
		System.out.println("End Function 4"+ "\n");*/
		
		// Actualizar usuario UPDATE User

//		System.out.println("Actualizar usuario usr: Raul, pss: Perez");
//		Usuario newUsuario3 = new Usuario();
//		newUsuario3.setIdUsuario(5);
//		newUsuario3.setNombres("Raul");
//		newUsuario3.setApellidos("Perez");
//		newUsuario3.setUsername("ReulTkm");
//		newUsuario3.setPassword("Rau123");
//		String res3 = fachadaData.updateUsuario(newUsuario3);
//		
//		System.out.println(res3);
//		
//	
//		System.out.println("End Function 5"+ "\n");
		
		//IMPORTANTE EN LA LOGICA HACER LA ACTUALIZACION DE ID!!!

		/*
		 * Lcz localizadorServicios = new Lcz();
		 * 
		 * ServiciosLogicaUsuarioRemote fachadaLogica = null; try { fachadaLogica =
		 * localizadorServicios.getRemoteFachadaLogica(); } catch (NamingException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * ServiciosUsuarioRemote fachadaDat = null;
		 * 
		 * try { fachadaDat = localizadorServicios.getRemoteFachadaLogicadat(); } catch
		 * (NamingException e) { // TODO Auto-generated catch block e.printStackTrace();
		 * }
		 */

		// Invocar el servicio usando la referencia remota
		// System.out.println(fachadaLogica.addUser());
		// Usuario usrL = fachadaLogica.getUser("carl123", "crl2020");
		// Usuario usrL= fachadaDat.findUserr("carl123", "crl2020");
		// List<Usuario>usuarios = fachadaDat.findUsuario("per123", "prl20220");
		// Usuario urs = fachadaLogica.getUser("per123", "prl2020");
		// System.out.print(urs.getNombres()+"\n");
		// usr.getNombres();
		/*
		 * for (Usuario user: usuarios) { System.out.print(user.getNombres()+"\n"); }
		 */

	}

}
