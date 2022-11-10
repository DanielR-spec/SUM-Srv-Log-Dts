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
				String idUsuario, String idFire, String latitud, String longitud, String sector) {
			// TODO Auto-generated method stub
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.addDonacion(nombreDon, telefonoDon, direccionDon, fechaDon,
					idUsuario, idFire, latitud, longitud, sector); 
		}
		public String getDonacionByUserId(String idUsuario) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getDonacionByUserId() en CrtlDonacion===");
			
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getDonacionesUsr(idUsuario);
		}
		public String getStatsFun(String idFundacion) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getStatsFun() en CrtlDonacion===");
			
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getStatsFun(idFundacion);
		}
		public String getStatsUbiFun(String idFundacion) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getStatsUbiFun() en CrtlDonacion===");
			
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getStatsUbiFun(idFundacion);
		}
		public String getDonacionByUserIdStat(String idUsuario) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getDonacionByUserIdStat() en CrtlDonacion===");
			
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getDonacionesUsrStat(idUsuario);
		}
		public String getTotDonUsr(String idUsuario) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getTotDonUsr() en CrtlDonacion===");
			
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getTotDonUsr(idUsuario);
		}
		public String getActiveDonFun(String idFundacion) {
			// TODO Auto-generated method stub
			System.out.println("===Invocando al metodo getActiveDonFun() en CrtlDonacion===");
			
			GestorSolicitudesDona gestorSolicitudes = new GestorSolicitudesDona();
			return gestorSolicitudes.getActiveDonFun(idFundacion);		}
		

}
