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

	public com.rest.ws.Usuario traerUsuariosInd(String userName, String password) throws NamingException {
		// TODO Auto-generated method stub
		com.rest.ws.Usuario usuarioR = new com.rest.ws.Usuario();
		
		// TODO Auto-generated method stub
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		ServiciosLogicaUsuarioRemote fachadaLogica=null;
		
		fachadaLogica = localizadorServicios.getRemoteFachadaLogica();

		// Invocar el servicio usando la referencia remota
		//System.out.println(fachadaLogica.addUser());
		//List<Usuario> lista = fachadaLogica.getUsers();
		
		Usuario cliente = fachadaLogica.getUser(userName, password);
		
		if(cliente!=null) {
			usuarioR.setId(cliente.getIdUsuario());
			usuarioR.setName(cliente.getNombres());
			usuarioR.setSecondName(cliente.getApellidos());
			usuarioR.setUserName(cliente.getUsername());
			usuarioR.setPassword(cliente.getPassword());
			usuarioR.setIsValid(true);
			
		}
		
		if(usuarioR.getIsValid()) {
			return usuarioR;
		}

		/*
		for (Usuario usuario : lista) {
			if (usuario.getIdUsuario() == 7) {
				usuarioR.setId(usuario.getIdUsuario());
				usuarioR.setName(usuario.getNombres());;
				usuarioR.setPassword(usuario.getPassword());;
			}
		}*/
	
		return null;
	}

}
