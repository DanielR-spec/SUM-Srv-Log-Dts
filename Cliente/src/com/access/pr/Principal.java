/**
 * 
 */
package com.access.pr;

import java.util.List;

import javax.naming.NamingException;

import com.conexion.srv.LocalizadorServicios;
import com.conexion.srv.LocalizadorServiciosNg;
import com.data.services.ServiciosUsuarioRemote;
import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;

/**
 * @author danie
 *
 */
public class Principal {

	/**
	 * 
	 */
	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NamingException {
		// Crear el localizador de servicios
		@SuppressWarnings("unused")
		LocalizadorServiciosNg localizadorServicios = new LocalizadorServiciosNg();

		// Obtener la referencia remota usando el localizador de servicios
		//ServiciosUsuarioRemote fachadaLogica = null;
		ServiciosLogicaUsuarioRemote fachadaLogica;
		
		fachadaLogica = localizadorServicios.getRemoteFachadaLogica();

		// Invocar el servicio usando la referencia remota
		System.out.println(fachadaLogica.addUser());
		List<Usuario> lista = fachadaLogica.getUsers();

		for (Usuario usuario : lista) {
			System.out.println(usuario.getIdUsuario() + ", " + usuario.getNombres());
		}
		System.out.println("Size: " + lista.size());
	}

}
