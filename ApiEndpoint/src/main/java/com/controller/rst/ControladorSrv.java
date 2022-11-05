/**
 * 
 */
package com.controller.rst;

import java.util.BitSet;
import java.util.List;

import javax.naming.NamingException;


import com.conexion.rst.GestorSolicitudes;
import com.rest.ws.UsuarioDao;

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

	/**
	 * FUNCION PARA VALIDAR USUARIO
	 */
	// Funciona
	public String validarUsr(String correo, String clave) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		return gestorSolicitudes.getUser(correo, clave);

	}

	/**
	 * FUNCION PARA AGREGAR USUARIO
	 */
	// ...
	public String addUsr(String nombres, String apellidos, String correo, String clave, String cell, String doc,
			String direccion, String tipo, String ciudad) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		return gestorSolicitudes.addUser(nombres, apellidos, correo, clave, cell, doc, direccion, tipo, ciudad);
	}

	/**
	 * FUNCION PARA ACRUALIZAR USUARIO
	 */
	// ...
	public String updUsr(String id, String nombres, String apellidos, String correo, String clave, String cell,
			String doc, String direccion) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		return gestorSolicitudes.updUser(id, nombres, apellidos, correo, clave, cell, doc, direccion);
	}

	/**
	 * FUNCION PARA ACRUALIZAR USUARIO
	 */
	// ...
	public String delUsr(String id) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		return gestorSolicitudes.delUser(id);
	}

}
