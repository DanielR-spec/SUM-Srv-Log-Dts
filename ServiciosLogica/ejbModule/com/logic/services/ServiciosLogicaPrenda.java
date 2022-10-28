package com.logic.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import com.conexion.srv.LocalizadorServicios;
import com.conexion.srv.LocalizadorServiciosPrenda;
import com.data.services.ServiciosPrendaRemote;
import com.data.services.ServiciosUsuarioRemote;
import com.model.ent.CategoriaPrenda;
import com.model.ent.Prenda;
import com.model.ent.TipoUsuario;
import com.model.ent.Usuario;

/**
 * Session Bean implementation class ServiciosLogicaPrenda
 */
@Stateless
@LocalBean
public class ServiciosLogicaPrenda implements ServiciosLogicaPrendaRemote, ServiciosLogicaPrendaLocal {

	/**
	 * Default constructor.
	 */
	public ServiciosLogicaPrenda() {
		// TODO Auto-generated constructor stub
	}

	// METODO PARA TRAER PRENDA POR ID, RETORNA LA INFORMACION DE LA PRENDA SI EXISTE
	// FUNCIONA
	@Override
	public HashMap<String, String> getPrendaById(String id) {

		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();

		HashMap<String, String> prendaRst = new HashMap<String, String>();

		List<Prenda> prendaDt = fachadaDat.findPrendaById(Integer.parseInt(id));

		if (prendaDt.size() > 0) {
			for (Prenda prenda : prendaDt) {

				prendaRst.put("idPrenda", String.valueOf(prenda.getIdPrenda()));
				prendaRst.put("idUsuario", String.valueOf(prenda.getIdUsuario()));
				prendaRst.put("imgUrl", prenda.getImageUrl());

			}
			return prendaRst;
		}

		return null;
	}

	// METODO PARA AGREGAR PRENDA, RETORNA MSN DE CONFIRMACION SI SE AGREGO O NO
	// FUNCIONA
	@Override
	public String addPrenda(HashMap<String, String> prenda) {

		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();

		Prenda tstPrenda = new Prenda();
		CategoriaPrenda catPrenda = new CategoriaPrenda();

		tstPrenda.setIdPrenda(getId());
		
		for (Entry<String, String> entry : prenda.entrySet()) {
			switch (entry.getKey()) {
			case "idUsuario": {
				if (entry.getValue() != "") {
					tstPrenda.setIdUsuario(Integer.parseInt(entry.getValue()));
					break;

				}
				break;

			}
			case "imgUri": {
				if (entry.getValue() != "") {
					tstPrenda.setImageUrl(entry.getValue());
					break;
				}
				break;

			}
			case "genero": {
				if (entry.getValue() != "") {
					catPrenda.setGenero(entry.getValue());
					break;

				}
				break;

			}
			case "tipo": {
				if (entry.getValue() != "") {
					catPrenda.setTipo(entry.getValue());
					break;
				}
				break;

			}


			default:
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
			}

		}


		try {
			String resultado = fachadaDat.addPrenda(tstPrenda);

			if (resultado.equals("Prenda insertada")) {
				catPrenda.setIdCategoriaPrenda(tstPrenda.getIdPrenda());
				fachadaDat.addPrendaCategoria(catPrenda);

				return "Prenda registrada existosamente";
			}

		} catch (Exception e) {
			// TODO: handle exception
			return "No se pudo agregar la prenda por el error:" + e;

		}
		return "Error agregando tipo de prenda";
	}

	// METODO PARA ACTUALIZAR PRENDA, RETORNA MSN DE CONFIRMACION SI SE ACTUALIZO O
	// NO
	// FUNCIONA
	@Override
	public String updPrenda(HashMap<String, String> prenda) {

		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();

		Prenda tstPrenda = new Prenda();

		tstPrenda = formatPrenda(prenda);

		// iterating through key/value mappings
		System.out.print("Entries: ");

		try {
			return fachadaDat.updatePrenda(tstPrenda);

		} catch (Exception e) {
			// TODO: handle exception
			return "No se pudo actualizar al usuario por el error:" + e.getMessage();

		}
	}

	// METODO PARA ELIMINAR PRENDA, RETORNA MSN DE CONFIRMACION SI SE ELIMINO O NO
	// FUNCIONA
	@Override
	public String delPrenda(HashMap<String, String> prenda) {

		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();
		Prenda tstPrenda = new Prenda();

		// iterating through key/value mappings
		System.out.print("Entries: ");

		tstPrenda = formatPrenda(prenda);

		try {
			// COMENTARIO: SE ESTA ELIMINANDO EL HIJO Y EN CASCADA SE ELIMINA EL PADRES
			// POR LA REFERENCIA DEL LA LLAVE FORANEA
			// LA ENTIDAD USUARIO SE ELIMINA AUTOMATICAMENTE
			String res = fachadaDat.delCategoriaPrenda(tstPrenda.getIdPrenda());
			return res;

		} catch (Exception e) {
			// TODO: handle exception
			return "No se pudo eliminar al usuario por el error:" + e.getMessage();

		}
	}
	
	// METODO PARA ELIMINAR PRENDA, RETORNA MSN DE CONFIRMACION SI SE ELIMINO O NO
	// FUNCIONA
	@Override
	public String delPrendaById(String id) {

		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();
		Prenda prenda = new Prenda();
		prenda.setIdPrenda(Integer.parseInt(id));
		String res = "empty";

		try {
			// COMENTARIO: SE ESTA ELIMINANDO EL HIJO Y EN CASCADA SE ELIMINA EL PADRES
			// POR LA REFERENCIA DEL LA LLAVE FORANEA
			// LA ENTIDAD USUARIO SE ELIMINA AUTOMATICAMENTE
			res = fachadaDat.delCategoriaPrenda(Integer.parseInt(id));
			if (res.equals("Categoria eliminada")) {
				res = fachadaDat.delPrenda(prenda);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return "No se pudo eliminar al usuario por el error:" + e.getMessage();

		}
		
		return res;
	}

	// FUNCIONES AUXILIARES
	public int getId() {
		ServiciosPrendaRemote fachadaDat = lczFachada();
		int id = fachadaDat.getId();

		return id;

	}

	public Prenda formatPrenda(HashMap<String, String> prnd) {

		ServiciosPrendaRemote fachadaDat = lczFachada();

		Prenda prendaDm = new Prenda();
		List<Prenda> auxPrenda = new ArrayList<Prenda>();

		prendaDm.setIdPrenda(getIdPrenda(prnd));

		auxPrenda = fachadaDat.findPrendaById(prendaDm.getIdPrenda());

		for (Entry<String, String> entry : prnd.entrySet()) {
			switch (entry.getKey()) {
			case "idPrenda": {

				break;

			}
			case "idUsuario": {
				if (entry.getValue() != "") {
					prendaDm.setIdUsuario(Integer.parseInt(entry.getValue()));
					break;
				}
				break;

			}
			case "imgUrl": {

				if (entry.getValue() != "") {
					prendaDm.setImageUrl(entry.getValue());
					break;

				}
				break;

			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
			}

		}

		return prendaDm;

	}

	public int getIdPrenda(HashMap<String, String> prenda) {

		int id = 0;
		for (Entry<String, String> entry : prenda.entrySet()) {
			if (entry.getKey().equals("idPrenda")) {
				id = Integer.parseInt(entry.getValue());
			}

		}

		return id;

	}

	public ServiciosPrendaRemote lczFachada() {

		LocalizadorServiciosPrenda Lcz = new LocalizadorServiciosPrenda();
		ServiciosPrendaRemote fachadaDato = null;

		try {
			fachadaDato = Lcz.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fachadaDato;

	}

	@Override
	public boolean tst() {
		// TODO Auto-generated method stub
		return true;
	}

}
