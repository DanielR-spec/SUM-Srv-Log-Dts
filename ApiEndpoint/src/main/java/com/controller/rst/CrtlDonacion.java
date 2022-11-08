/**
 * 
 */
package com.controller.rst;

import org.json.JSONObject;

import com.conexion.rst.GestorSolicitudes;
import com.conexion.rst.GestorSolicitudesDona;

/**
 * @author danie
 *
 */
public class CrtlDonacion {

	/**
	 * 
	 */
	public CrtlDonacion() {
		// TODO Auto-generated constructor stub
	}
	/**
	 *FUNCION PARA TRAER DONACIONES 
	 */
	// ...
		public String getDonacionByFundacionId(String idFundacion) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getDonacionByFundacionId() en CrtlDonacion===");
			
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getDonaciones(idFundacion);


		}
		
		public String getIdFireDonaUsr(String idDonaBack) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getIdFireDonaUsr() en CrtlDonacion===");

			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getIdDonaUsr(idDonaBack);
			}
		
		public String getPrendasDonacion(String idUsuario, String idDonacion) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getDonacionesFun() en CrtlDonacion===");
			

			// TODO Auto-generated method stub
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getPrendasDonacion(idUsuario, idDonacion);


		}
		
		public String updateDonacion(String id, String estado) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo updateDonacion() en CrtlDonacion===");

			// TODO Auto-generated method stub
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.updateDonacion(id, estado); 
		}
		
		public String addDona(String nombreDon, String telefonoDon, String direccionDon, String fechaDon,
				String idUsuario, String idFire) {
			// TODO Auto-generated method stub
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.addDonacion(nombreDon, telefonoDon, direccionDon, fechaDon,
					idUsuario, idFire); 
		}
		public String getDonacionByUserId(String idUsuario) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getDonacionByUserId() en CrtlDonacion===");
			
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getDonacionesUsr(idUsuario);
		}
		

}
