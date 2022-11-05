package com.logic.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import com.conexion.srv.LocalizadorServiciosCarrito;
import com.conexion.srv.LocalizadorServiciosDonacion;
import com.data.services.ServiciosCarritoRemote;
import com.data.services.ServiciosDonacionRemote;
import com.model.ent.Carrito;
import com.model.ent.Donacion;

/**
 * Session Bean implementation class ServiciosLogicaCarrito
 */
@Stateless
@LocalBean
public class ServiciosLogicaCarrito implements ServiciosLogicaCarritoRemote, ServiciosLogicaCarritoLocal {

    /**
     * Default constructor. 
     */
    public ServiciosLogicaCarrito() {
        // TODO Auto-generated constructor stub
    }
    
    // METODO PARA TRAER CARRITO POR ID, RETORNA LA INFORMACION DEL CARRITO SI
 	// EXISTE
 	// FUNCIONA
 	@Override
 	public HashMap<String, String> getCarritoById(String id) {

 		// TODO Auto-generated method stub
 		ServiciosCarritoRemote fachadaDat = lczFachada();

 		HashMap<String, String> carritoRst = new HashMap<String, String>();

 		List<Carrito> carrito = fachadaDat.findCarrtioById(Integer.parseInt(id));

 		if (carrito.size() > 0) {
 			for (Carrito carr : carrito) {

 				carritoRst.put("idCarrito", String.valueOf(carr.getIdCarrito()));
 				carritoRst.put("idUsuario", String.valueOf(carr.getIdUsuario()));
 				//carritoRst.put("idPrenda", carr.getIdPrenda());

 			}
 			return carritoRst;
 		}

 		return null;
 	}

 	// METODO PARA AGREGAR DONACION, RETORNA MSN DE CONFIRMACION SI SE AGREGO O NO
 	// FUNCIONA
 	@Override
 	public String addCarrito(HashMap<String, String> carrito) {
		System.out.println("Entro al metodo agregar carrito");

 		// TODO Auto-generated method stub
 		ServiciosCarritoRemote fachadaDat = lczFachada();

 		Carrito tstCarr = new Carrito();

 		tstCarr = formatCarritoAdd(carrito);
 	
 		try {
 			String resultado = fachadaDat.addCarrito(tstCarr);

 			if (resultado.equals("Carrito insertado")) {
 				
 				return "Carrito insertado";
 			}

 		} catch (Exception e) {
 			// TODO: handle exception
 			return "No se pudo agregar el carrito por el error:" + e;

 		}
 		return "Error agregando carrito";
 	}

 	
	public Carrito formatCarritoAdd(HashMap<String, String> dona) {

		Carrito carrito = new Carrito();
		carrito.setIdCarrito(getId());

		for (Entry<String, String> entry : dona.entrySet()) {
			switch (entry.getKey()) {
			case "idUsuario": {
				if (entry.getValue() != "") {
					carrito.setIdUsuario(Integer.parseInt(entry.getValue()));
					break;
				}
				break;

			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
			}

		}

		return carrito;

	}
	
	// FUNCIONES AUXILIARES
	public int getId() {
		ServiciosCarritoRemote fachadaDat = lczFachada();
		int id = fachadaDat.getId();

		return id;

	}

 	public ServiciosCarritoRemote lczFachada() {

		LocalizadorServiciosCarrito Lcz = new LocalizadorServiciosCarrito();
		ServiciosCarritoRemote fachadaDato = null;

		try {
			fachadaDato = Lcz.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fachadaDato;

	}

}
