package com.logic.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import com.conexion.srv.LocalizadorServiciosDonacion;
import com.model.ent.Donacion;
import com.data.services.ServiciosDonacionRemote;

/**
 * Session Bean implementation class ServiciosLogicaDonacion
 */
@Stateless
@LocalBean
public class ServiciosLogicaDonacion implements ServiciosLogicaDonacionRemote, ServiciosLogicaDonacionLocal {

    /**
     * Default constructor. 
     */
    public ServiciosLogicaDonacion() {
        // TODO Auto-generated constructor stub
    }
    
    // METODO PARA TRAER DONACION POR ID, RETORNA LA INFORMACION DE LA DONACION SI
 	// EXISTE
 	// FUNCIONA
 	@Override
 	public HashMap<String, String> getDonacionById(String id) {

 		// TODO Auto-generated method stub
 		ServiciosDonacionRemote fachadaDat = lczFachada();

 		HashMap<String, String> donacionRst = new HashMap<String, String>();

 		List<Donacion> donacion = fachadaDat.findDonacionById(Integer.parseInt(id));

 		if (donacion.size() > 0) {
 			for (Donacion dona : donacion) {

 				donacionRst.put("idDonacion", String.valueOf(dona.getIdDonacion()));
 				donacionRst.put("idUsuario", String.valueOf(dona.getUsuarioId()));
 				donacionRst.put("nomre", dona.getNombreDon());
 				donacionRst.put("direccion", dona.getDireccionDon());

 			}
 			return donacionRst;
 		}

 		return null;
 	}

 	// METODO PARA AGREGAR DONACION, RETORNA MSN DE CONFIRMACION SI SE AGREGO O NO
 	// FUNCIONA
 	@Override
 	public String addDonacion(HashMap<String, String> donacion) {

 		// TODO Auto-generated method stub
 		ServiciosDonacionRemote fachadaDat = lczFachada();

 		Donacion tstDona = new Donacion();

 		tstDona = formatDonacionAdd(donacion);
 	
 		try {
 			String resultado = fachadaDat.addDonacion(tstDona);

 			if (resultado.equals("Donacion insertada")) {
 				
 				return "Donacion insertada";
 			}

 		} catch (Exception e) {
 			// TODO: handle exception
 			return "No se pudo agregar la donacion por el error:" + e;

 		}
 		return "Error agregando donacion";
 	}

 	
	public Donacion formatDonacionAdd(HashMap<String, String> dona) {

		Donacion donacion = new Donacion();
		donacion.setIdDonacion(getId());

		for (Entry<String, String> entry : dona.entrySet()) {
			switch (entry.getKey()) {
			case "idFundacion": {
				if (entry.getValue() != "") {
					donacion.setFundacionId(Integer.parseInt(entry.getValue()));
					break;
				}
				break;

			}
			case "nombreDon": {

				if (entry.getValue() != "") {
					donacion.setNombreDon(entry.getValue());

					break;

				}
				break;

			}
			case "telefonoDon": {
				if (entry.getValue() != "") {
					donacion.setTelDon(entry.getValue());

					break;
				}
				break;

			}
			case "direccionDon": {
				if (entry.getValue() != "") {
					donacion.setDireccionDon(entry.getValue());

					break;
				}
				break;

			}
			case "fechaDon": {
				if (entry.getValue() != "") {
					donacion.setFechaDon(entry.getValue());

					break;
				}
				break;

			}
			case "idUsuario": {
				if (entry.getValue() != "") {
					donacion.setUsuarioId(Integer.parseInt(entry.getValue()));

					break;
				}
				break;

			}
			case "estado": {
				if (entry.getValue() != "") {
					donacion.setEstado(entry.getValue());

					break;
				}
				break;

			}
			case "idFire": {
				if (entry.getValue() != "") {
					donacion.setIdDonaFire(entry.getValue());

					break;
				}
				break;

			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
			}

		}

		return donacion;

	}
	
	// FUNCIONES AUXILIARES
	public int getId() {
		ServiciosDonacionRemote fachadaDat = lczFachada();
		int id = fachadaDat.getId();

		return id;

	}

 	public ServiciosDonacionRemote lczFachada() {

		LocalizadorServiciosDonacion Lcz = new LocalizadorServiciosDonacion();
		ServiciosDonacionRemote fachadaDato = null;

		try {
			fachadaDato = Lcz.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fachadaDato;

	}

}
