/**
 * 
 */
package com.controller.rst;

import java.util.BitSet;
import java.util.List;

import javax.naming.NamingException;

import com.conexion.rst.GestorSolicitudes;
import com.conexion.rst.GestorSolicitudesPrenda;
import com.rest.ws.UsuarioDao;

/**
 * @author danie
 *
 */
public class CrtlPrenda {

	/**
	 * 
	 */
	public CrtlPrenda() {
		// TODO Auto-generated constructor stub
	}
	/**
	 *FUNCION PARA VALIDAR USUARIO 
	 */
	//Funciona
	public String getPrenda(String idPrenda) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudesPrenda gestorSolicitudes = new GestorSolicitudesPrenda();
		return gestorSolicitudes.getPrenda(idPrenda);
		
	}
	/**
	 *FUNCION PARA AGREGAR PRENDA 
	 */
	//...
	public String addPrnd(String idUsuario,
			String imgUrl,
			String idFire,
			String fecha,
			String genero,
			String tipo) throws NamingException {

		// TODO Auto-generated method stub
		GestorSolicitudesPrenda gestorSolicitudes = new GestorSolicitudesPrenda();
		return gestorSolicitudes.addPrenda(idUsuario, imgUrl, idFire, fecha, genero, tipo);
	}

	public String getPrendaId(String idFire) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		GestorSolicitudesPrenda gestorSolicitudes = new GestorSolicitudesPrenda();
		return gestorSolicitudes.getIdPrenda(idFire);
	}
	public String delPrenda(String id) {
		// TODO Auto-generated method stub
		GestorSolicitudesPrenda gestorSolicitudes = new GestorSolicitudesPrenda();
		return gestorSolicitudes.delPrendaById(id);
	}
	public String getCatById(String idPrend) {
		// TODO Auto-generated method stub
		GestorSolicitudesPrenda gestorSolicitudes = new GestorSolicitudesPrenda();
		return gestorSolicitudes.getCategoriaPrenda(idPrend);
	}
	
	

}
