/**
 * 
 */
package com.controller.rst;

import java.util.BitSet;
import java.util.List;

import javax.naming.NamingException;

import com.conexion.rst.GestorSolicitudes;
import com.conexion.rst.GestorSolicitudesCart;
import com.rest.ws.UsuarioDao;

/**
 * @author danie
 *
 */
public class CrtlCart {

	/**
	 * 
	 */
	public CrtlCart() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *FUNCION PARA AGREGAR PRENDA 
	 */
	//...
	public String addCart(String idUsuario) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudesCart gestorSolicitudes = new GestorSolicitudesCart();
		
		return gestorSolicitudes.addCart(idUsuario);
	}
	
	public String getCartId(String idCart) {
		// TODO Auto-generated method stub
		return null;
	}

}
