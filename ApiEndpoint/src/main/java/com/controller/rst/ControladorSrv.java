/**
 * 
 */
package com.controller.rst;

import java.util.List;

import javax.naming.NamingException;


import com.conexion.rst.GestorSolicitudes;

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
	
	public String agregarUsuario() {
		// TODO Auto-generated method stub
		return "Holadfsfs";
	}

	public String traerUsuariosInd() throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		return gestorSolicitudes.getUser();
	}

}
