/**
 * 
 */
package com.controller.rst;

import java.util.List;

import javax.naming.NamingException;

import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.conexion.rst.LocalizadorServicios;

/**
 * @author danie
 *
 */
public class ControladorSrv {

	/**
	 * 
	 */
	public ControladorSrv() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Usuario> traerUsuarios() {

		// TODO Auto-generated method stub
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		ServiciosLogicaUsuarioRemote serviciosUsuarioRemote = null;
		try {
			serviciosUsuarioRemote = localizadorServicios.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return serviciosUsuarioRemote.getUsers();
	}

	public String agregarUsuario() {
		// TODO Auto-generated method stub
		return "Holadfsfs";
	}

	public com.rest.ws.Usuario traerUsuariosInd() throws NamingException {
		// TODO Auto-generated method stub
		com.rest.ws.Usuario usuarioR = new com.rest.ws.Usuario();
		
		// TODO Auto-generated method stub
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		ServiciosLogicaUsuarioRemote fachadaLogica;
		try {
			fachadaLogica = localizadorServicios.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fachadaLogica = localizadorServicios.getRemoteFachadaLogica();

		// Invocar el servicio usando la referencia remota
		//System.out.println(fachadaLogica.addUser());
		List<Usuario> lista = fachadaLogica.getUsers();

		for (Usuario usuario : lista) {
			if (usuario.getIdUsuario() == 7) {
				usuarioR.setId(usuario.getIdUsuario());
				usuarioR.setName(usuario.getNombres());;
				usuarioR.setPassword(usuario.getPassword());;
			}
		}
	
		return usuarioR;
	}

}
