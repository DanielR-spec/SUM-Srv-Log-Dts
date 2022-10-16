/**
 * 
 */
package com.controller.rst;

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
	 *FUNCION PARA VALIDAR USUARIO 
	 */
	//Funciona
	public String validarUsr(String usuario, String clave) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		return gestorSolicitudes.getUser(usuario,clave);
		
	}
	/**
	 *FUNCION PARA AGREGAR USUARIO 
	 */
	//...
	public String addUsr(String name, String lName, String usr, String pss) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		return gestorSolicitudes.addUser(name, lName, usr, pss);
	}
	/**
	 *FUNCION PARA ACRUALIZAR USUARIO 
	 */
	//...
	public String updUsr(String id, String name, String lName, String usr, String pss) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		return gestorSolicitudes.updUser(id, name, lName, usr, pss);
	}
	/**
	 *FUNCION PARA ACRUALIZAR USUARIO 
	 */
	//...
	public String delUsr(String id) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		return gestorSolicitudes.delUser(id);
	}	
	
	

}
