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

	// METODO PARA TRAER PRENDA POR ID, RETORNA LA INFORMACION DE LA PRENDA SI
	// EXISTE
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
				prendaRst.put("id_fire", prenda.getIdFire());

			}
			return prendaRst;
		}

		return null;
	}
	
	// METODO PARA TRAER PRENDA POR ID, RETORNA LA INFORMACION DE LA PRENDA SI
	// EXISTE
	// FUNCIONA
	@Override
	public HashMap<String, String> getPrendaByIdFire(String idFire) {

		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();

		HashMap<String, String> prendaRst = new HashMap<String, String>();

		List<Prenda> prendaDt = fachadaDat.getPrendaByIdFire(idFire);

		if (prendaDt.size() > 0) {
			for (Prenda prenda : prendaDt) {

				prendaRst.put("idPrenda", String.valueOf(prenda.getIdPrenda()));
				prendaRst.put("idUsuario", String.valueOf(prenda.getIdUsuario()));
				prendaRst.put("imgUrl", prenda.getImageUrl());
				prendaRst.put("id_fire", prenda.getIdFire());

			}
			return prendaRst;
		}

		return null;
	}
	
	// METODO PARA TRAER CATEGORIA PRENDA POR ID, RETORNA LA INFORMACION DE LA PRENDA SI
	// EXISTE
	// FUNCIONA
	@Override
	public HashMap<String, String> getCatPrendaById(String id) {

		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();

		HashMap<String, String> categoriaRst = new HashMap<String, String>();

		List<CategoriaPrenda> categoriaDt = fachadaDat.getCategoriaPrenda(Integer.parseInt(id));

		if (categoriaDt.size() > 0) {
			for (CategoriaPrenda prenda : categoriaDt) {

				categoriaRst.put('"' + "tipo" + '"', '"' + String.valueOf(prenda.getTipo()) + '"');
				categoriaRst.put('"' + "genero" + '"', '"' + String.valueOf(prenda.getGenero()) + '"');

			}
			return categoriaRst;
		}

		return null;
	}
	
	@Override
	public String getIdPrenda(String idFire) {
		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();
		
		HashMap<String, String> prendaRst = new HashMap<String, String>();

		List<Prenda> prendaDt = fachadaDat.getPrendaByIdFire(idFire);
		String id = "";

		//Nota el hash map no sirve para nada unicamente para iterar el metodo retorna el id
		if (prendaDt.size() > 0) {
			for (Prenda prenda : prendaDt) {

				prendaRst.put("idPrenda", String.valueOf(prenda.getIdPrenda()));
				prendaRst.put("idUsuario", String.valueOf(prenda.getIdUsuario()));
				prendaRst.put("imgUrl", prenda.getImageUrl());
				prendaRst.put("id_fire", prenda.getIdFire());
				id = String.valueOf(prenda.getIdPrenda());
				

			}
		}


		return id;
	}

	// METODO PARA AGREGAR PRENDA, RETORNA MSN DE CONFIRMACION SI SE AGREGO O NO
	// FUNCIONA
	@Override
	public String addPrenda(HashMap<String, String> prenda) {
		System.out.println("Entro al metodo agregar prenda");

		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();

		Prenda tstPrenda = new Prenda();
		CategoriaPrenda catPrenda = new CategoriaPrenda();

		tstPrenda = formatPrendaAdd(prenda);
	
		try {
			String resultado = fachadaDat.addPrenda(tstPrenda);

			if (resultado.equals("Prenda insertada")) {
				
				//En el metodo se formatea el id del la prenda que se pasa por parametro
				catPrenda = formatCategoria(prenda, tstPrenda.getIdPrenda());

				String resCat = fachadaDat.addPrendaCategoria(catPrenda);

				if(resCat.equals("Exito")) {
					return String.valueOf(tstPrenda.getIdPrenda());

				}
				else {
					return "Fallo el cargue de la categoria";
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			return "No se pudo agregar la prenda por el error:" + e;

		}
		return "Error agregando tipo de prenda";
	}

	// METODO PARA ACTUALIZAR PRENDA, RETORNA MSN DE CONFIRMACION SI SE ACTUALIZO O NO
	// FUNCIONA
	@Override
	public String updPrenda(HashMap<String, String> prenda) {

		// TODO Auto-generated method stub
		ServiciosPrendaRemote fachadaDat = lczFachada();

		Prenda tstPrenda = new Prenda();
		CategoriaPrenda catPrenda = new CategoriaPrenda();
		String res = "empty";

		tstPrenda = formatPrenda(prenda);
		catPrenda = formatCategoria(prenda, tstPrenda.getIdPrenda());

		try {
			res = fachadaDat.updateCatPrenda(catPrenda);
			
			if (res.equals("categoria actualizada")) {
				res = fachadaDat.updatePrenda(tstPrenda);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return "No se pudo actualizar la prenda por el error:" + e.getMessage();

		}
		return res;
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

	// METODO PARA ELIMINAR PRENDA POR ID, RETORNA MSN DE CONFIRMACION SI SE ELIMINO O NO
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
	
	public int getIdCat() {
		ServiciosPrendaRemote fachadaDat = lczFachada();
		int id = fachadaDat.getIdCat();

		return id;

	}

	public Prenda formatPrenda(HashMap<String, String> prnd) {

		Prenda prendaDm = new Prenda();

		prendaDm.setIdPrenda(getIdPrenda(prnd));

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
			case "genero": {

				break;

			}
			case "tipo": {

				break;

			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
			}

		}

		return prendaDm;

	}
	
	public Prenda formatPrendaAdd(HashMap<String, String> prnd) {

		Prenda prendaDm = new Prenda();
		prendaDm.setIdPrenda(getId());

		for (Entry<String, String> entry : prnd.entrySet()) {
			switch (entry.getKey()) {
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
			case "idFire": {
				if (entry.getValue() != "") {
					prendaDm.setIdFire(entry.getValue());
					break;
				}
				break;

			}
			case "fecha": {
				if (entry.getValue() != "") {
					prendaDm.setFechaAgregacion(entry.getValue());
					break;
				}
				break;

			}
			case "genero": {

				break;

			}
			case "tipo": {

				break;

			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
			}

		}

		return prendaDm;

	}	

	public CategoriaPrenda formatCategoria(HashMap<String, String> prnd, int id) {

		CategoriaPrenda categoriaPrenda = new CategoriaPrenda();
		categoriaPrenda.setIdCategoriaPrenda(id);

		for (Entry<String, String> entry : prnd.entrySet()) {
			switch (entry.getKey()) {
			case "idUsuario": {
				break;

			}
			case "imgUrl": {
				break;

			}
			case "idFire": {
				break;

			}
			case "fecha": {
				break;

			}
			case "genero": {
				if (entry.getValue() != "") {
					categoriaPrenda.setGenero(entry.getValue());
					break;
				}
				break;

			}
			case "tipo": {
				if (entry.getValue() != "") {
					categoriaPrenda.setTipo(entry.getValue());
					break;
				}
				break;

			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
			}

		}

		return categoriaPrenda;

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
