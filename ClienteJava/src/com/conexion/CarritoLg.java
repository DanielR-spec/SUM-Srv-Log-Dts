package com.conexion;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.naming.NamingException;

import com.logic.services.ServiciosLogicaCarritoRemote;
import com.logic.services.ServiciosLogicaDonacionRemote;
import com.logic.services.ServiciosLogicaPrendaRemote;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.model.ent.Prenda;
import com.model.ent.Usuario;
import com.data.services.ServiciosDonacionRemote;
import com.data.services.ServiciosPrendaRemote;
import com.data.services.ServiciosUsuarioRemote;

public class CarritoLg {
	
	
	/**
	 * 
	 */
	public CarritoLg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ServiciosLogicaCarritoRemote lczCarrito() {
		
		// Buscar la fachada de datos
		LczCarrtioLg localizadorServicios = new LczCarrtioLg();

		ServiciosLogicaCarritoRemote fachadaLog = null;
		try {
			fachadaLog = localizadorServicios.getRemoteFachadaLogica();
			return fachadaLog;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fachadaLog;
		
	}

	public static void addCarrito(ServiciosLogicaCarritoRemote dt) {
		
		//Agregar Prenda
		
		System.out.println("Metodo agregar carrito");

		HashMap<String, String> carrito = new HashMap<String, String>();

		//donacion.put("idDonacion", "1");
		//carrito.put("idCarrito", "1");
		carrito.put("idUsuario","1");
		carrito.put("idPrenda", "1");
		carrito.put("idCarrFire", "1_1_1");

		
		String res = dt.addCarrito(carrito);
		System.out.println(res);
		
	}

	public static void main(String[] args) throws NamingException {
		
	
		//Get EJB conexion
		ServiciosLogicaCarritoRemote carritoRemote =  lczCarrito();
		
		//Test create/add prenda
		addCarrito(carritoRemote);
		
		//Test read/get prenda
		//getPrenda(prendaRemote);
		
		//Test delete prenda
		//deletPrenda(prendaRemote);
		
		//Test delete prenda
		//updatePrenda(prendaRemote);
		
	


	}

}
