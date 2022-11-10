package com.logic.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import com.conexion.srv.LocalizadorServicios;
import com.conexion.srv.LocalizadorServiciosDonacion;
import com.model.ent.Donacion;
import com.model.ent.TipoUsuario;
import com.model.ent.Usuario;
import com.data.services.ServiciosDonacionRemote;
import com.data.services.ServiciosUsuarioRemote;

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

 	 				donacionRst.put("idUsuario", String.valueOf(dona.getUsuarioId()));
 	 				donacionRst.put("idDonaFire", dona.getIdDonaFire());
				
 				//donacionRst.put("idDonacion", String.valueOf(dona.getIdDonacion()));

 				//donacionRst.put("direccion", dona.getDireccionDon());

 			}
 			return donacionRst;
 		}

 		return null;
 	}
 	
 	// METODO PARA TRAER DONACIONES POR ID DE LA FUNDACION, RETORNA LA INFORMACION DE LA DONACION SI
 	// EXISTE
 	// FUNCIONA
 	public HashMap<String,List<List<String>>> getDonacionByFundacionId(String id) {

 	 		// TODO Auto-generated method stub
 	 		ServiciosDonacionRemote fachadaDat = lczFachada();

 	 		List<Donacion> donaciones = fachadaDat.findDonacionByFundacionId(Integer.parseInt(id));
 	 		
 	 		List<List<String>> externalValues = new ArrayList<List<String>>();
 	 		List<List<String>> externaHeatherlValues = new ArrayList<List<String>>();

 	 		//List<String> internalValues = new ArrayList<String>();

 	 		
 	 		for (Donacion donacion : donaciones) {
 	 	 		List<String> internalValues = new ArrayList<String>();
 	 	 		List<String> internalHeatherValues = new ArrayList<String>();

 	 			
 	 			if (donacion.getFundacionId() == Integer.parseInt(id)) {
 	 				
 	 	 			internalValues.add('"' + donacion.getNombreDon() + '"');
 	 	 			internalValues.add('"' + donacion.getDireccionDon() + '"');
 	 	 			internalValues.add(donacion.getTelDon());
 	 	 			internalValues.add('"' + donacion.getEstado() + '"');
 	 	 			internalValues.add('"' +""+'"');
 	 	 			
 	 	 			String keyidUsr = "{" + '"' + "idUsr"  + '"' + ":";
 	 	 			String keyidDonaFire = '"' + "idDonaFire" + '"' + ":";
 	 	 			String keyidDonaBack = '"' + "idDonaBack" + '"' + ":";
 	 	 			String keylat = '"' + "lat" + '"' + ":";
 	 	 			String keylong = '"' + "long" + '"' + ":";
// 	 	 			
 	 	 			//String keyidUsr = "idUsr"+":";
 	 	 			//String keyidDonaFire = "idDonaFire"+":"; 
 	 	 			
 	 	 			String valueidUsr = '"' + String.valueOf(donacion.getUsuarioId()) + '"';
 	 	 			String valueidDonaFire = '"' +  String.valueOf(donacion.getIdDonaFire()) + '"';
 	 	 			String valueidDonaBack = '"' +  String.valueOf(donacion.getIdDonacion()) + '"';
 	 	 			String valueLat = '"' +  String.valueOf(donacion.getLatitud()) + '"';
 	 	 			String valueLong = '"' +  String.valueOf(donacion.getLongitud()) + '"';



 	 	 			
 	 	 			internalHeatherValues.add(keyidUsr+"["+valueidUsr+"]");
 	 	 			internalHeatherValues.add(keyidDonaFire+"["+valueidDonaFire+"]");
 	 	 			internalHeatherValues.add(keyidDonaBack+"["+valueidDonaBack+"]");
 	 	 			internalHeatherValues.add(keylat+"["+valueLat+"]");
 	 	 			internalHeatherValues.add(keylong+"["+valueLong+"]" + "}");

 	 	 			
 	 	 			externalValues.add(internalValues);
 	 	 			externaHeatherlValues.add(internalHeatherValues);
 	 	 								
				}
 	 			
 	 			
 	 		}
 	 			
 	 		
 	 		HashMap<String, List<List<String>>> mapDonacion = new HashMap<>();
 			
 			mapDonacion.put('"' +"rows"+'"' , externalValues);
 			mapDonacion.put('"' +"headers"+'"' , externaHeatherlValues);
 			
 	 		return mapDonacion;
 	 	}
 	
 	// METODO PARA TRAER DONACIONES POR ID DE LA FUNDACION, RETORNA LA INFORMACION DE LA DONACION SI
 	// EXISTE
 	// FUNCIONA
 	public HashMap<String,List<String>> getUbiDonacionByFundacionId(String id) {

 	 		// TODO Auto-generated method stub
 	 		ServiciosDonacionRemote fachadaDat = lczFachada();
 	 		int contTeu = 0;
 	 		int contCha = 0;
 	 		int contSub = 0;
 	 		int contBos = 0;
 	 		int contKen = 0;


 	 		List<Donacion> donaciones = fachadaDat.findDonacionByFundacionId(Integer.parseInt(id));

 	 		List<String> internalValues = new ArrayList<String>();
 	 		List<String> internalValuesCiu = new ArrayList<String>();


 	 		HashMap<String,List<String>> ubiDon = new HashMap<String,List<String>>();
 	 		
 	 		for (Donacion donacion : donaciones) {			
 	 			if (donacion.getSector().equals("Teusaquillo")) {
 	 				contTeu += 1;
 	 			}else if (donacion.getSector().equals("Chapinero")) {
 	 				contCha += 1;
				}else if (donacion.getSector().equals("Suba")) {
					contSub += 1;
				}else if (donacion.getSector().equals("Bosa")) {
					contBos += 1;
				}else if (donacion.getSector().equals("Kenedy")) {
					contKen += 1;
				}
 	 				
 	 	 								
			}
 	 			internalValuesCiu.add("{" + '"' +"Ciudad"+'"'+":"+'"' + "Bogota" + '"'+ "}");
	 	 		internalValues.add("{" +'"' +"Teusaquillo"+'"'+":"+'"' + contTeu + '"');
	 	 		internalValues.add('"' +"Chapinero"+'"'+":"+'"' + contCha + '"');
	 	 		internalValues.add('"' +"Suba"+'"'+":"+'"' + contSub + '"');
	 	 		internalValues.add('"' +"Bosa"+'"'+":"+'"' + contBos + '"');
	 	 		internalValues.add('"' +"Kenedy"+'"'+":"+'"' + contKen + '"'+ "}");
 	 			
	 		ubiDon.put('"' +"headers"+'"' , internalValuesCiu);

 			ubiDon.put('"' +"rows"+'"' , internalValues);
 			
 	 		return ubiDon;
 	 	}
 	 			
 	public HashMap<String, String> getDonacionByIdUsrSat(String id) {

 		ServiciosDonacionRemote fachadaDat = lczFachada();
	 	ServiciosUsuarioRemote fachadaDatUsr = lczFachadaUsr();

	 	
		HashMap<String, String> donacionRst = new HashMap<String, String>();

		List<Donacion> donacionDt = fachadaDat.findDonacionByUsrId(Integer.parseInt(id));


		if (donacionDt.size() > 0) {
			for (Donacion donacion : donacionDt) {
				
				if (donacion.getEstado().equals("En proceso")) {
					donacionRst.put('"' +"nombre"+'"', '"' +donacion.getNombreDon()+'"');
					donacionRst.put('"' +"direccion"+'"', '"' +donacion.getDireccionDon()+'"');
					donacionRst.put('"' +"fecha"+'"', '"' +donacion.getFechaDon()+'"');
					donacionRst.put('"' +"telefono"+'"', '"' +donacion.getTelDon()+'"');
					donacionRst.put('"' +"estado"+'"', '"' +donacion.getEstado()+'"');
					
//					donacionRst.put("nombre",donacion.getNombreDon());
//					donacionRst.put("direccion",donacion.getDireccionDon());
//					donacionRst.put("fecha",donacion.getFechaDon());
//					donacionRst.put("telefono",donacion.getTelDon());
//					donacionRst.put("estado",donacion.getEstado());
					
					List<Usuario> empresaDt = fachadaDatUsr.findUsuarioById(donacion.getFundacionId());
					
					for (Usuario empresa : empresaDt) {
						donacionRst.put('"' +"nombreEmp"+'"', '"' +empresa.getNombres()+'"');
						donacionRst.put('"' +"telefonoEmp"+'"', '"' +empresa.getCell()+'"');
						donacionRst.put('"' +"direccionEmp"+'"', '"' +empresa.getDireccion()+'"');
						donacionRst.put('"' +"correoEmp"+'"', '"' +empresa.getCorreo()+'"');
						
//						donacionRst.put("nombreEmp",empresa.getNombres());
//						donacionRst.put("telefonoEmp",empresa.getCell());
//						donacionRst.put("direccionEmp",empresa.getDireccion());
//						donacionRst.put("correoEmp",empresa.getCorreo());
					}
					
				}

				

			}
			return donacionRst;
		}

		return null;
	 		}
 	
 	@Override
 	public HashMap<String, String> getDonacionByIdUsr(String idUsuario) {
 		// TODO Auto-generated method stub
	 	ServiciosDonacionRemote fachadaDat = lczFachada();
	 	ServiciosUsuarioRemote fachadaDatUsr = lczFachadaUsr();

	 	
		HashMap<String, String> donacionRst = new HashMap<String, String>();

		List<Donacion> donacionDt = fachadaDat.findDonacionByUsrId(Integer.parseInt(idUsuario));


		if (donacionDt.size() > 0) {
			for (Donacion donacion : donacionDt) {

				donacionRst.put('"' +"nombre"+'"', '"' +donacion.getNombreDon()+'"');
				donacionRst.put('"' +"direccion"+'"', '"' +donacion.getDireccionDon()+'"');
				donacionRst.put('"' +"fecha"+'"', '"' +donacion.getFechaDon()+'"');
				donacionRst.put('"' +"telefono"+'"', '"' +donacion.getTelDon()+'"');
				donacionRst.put('"' +"estado"+'"', '"' +donacion.getEstado()+'"');
				
//				donacionRst.put("nombre",donacion.getNombreDon());
//				donacionRst.put("direccion",donacion.getDireccionDon());
//				donacionRst.put("fecha",donacion.getFechaDon());
//				donacionRst.put("telefono",donacion.getTelDon());
//				donacionRst.put("estado",donacion.getEstado());
				
				List<Usuario> empresaDt = fachadaDatUsr.findUsuarioById(donacion.getFundacionId());
				
				for (Usuario empresa : empresaDt) {
					donacionRst.put('"' +"nombreEmp"+'"', '"' +empresa.getNombres()+'"');
					donacionRst.put('"' +"telefonoEmp"+'"', '"' +empresa.getCell()+'"');
					donacionRst.put('"' +"direccionEmp"+'"', '"' +empresa.getDireccion()+'"');
					donacionRst.put('"' +"correoEmp"+'"', '"' +empresa.getCorreo()+'"');
					
//					donacionRst.put("nombreEmp",empresa.getNombres());
//					donacionRst.put("telefonoEmp",empresa.getCell());
//					donacionRst.put("direccionEmp",empresa.getDireccion());
//					donacionRst.put("correoEmp",empresa.getCorreo());
				}

			}
			return donacionRst;
		}

		return null;
 	}
 	
 	@Override
 	public HashMap<String, String> getCatTonFun(String idFun) {
 		// TODO Auto-generated method stub
	 	ServiciosDonacionRemote fachadaDat = lczFachada();
	 	ServiciosUsuarioRemote fachadaDatUsr = lczFachadaUsr();
	 	
	 	String totalDon = "";

	 	
		HashMap<String, String> donacionRst = new HashMap<String, String>();

		List<Donacion> donacionDt = fachadaDat.findDonacionByFundacionId(Integer.parseInt(idFun));


		if (donacionDt.size() > 0) {
			totalDon = String.valueOf(donacionDt.size());
			for (Donacion donacion : donacionDt) {

				donacionRst.put("total",totalDon);
				donacionRst.put("idFire",donacion.getIdDonaFire());
				donacionRst.put("idUser",String.valueOf(donacion.getUsuarioId()));

			}
			return donacionRst;
		}

		return null;
 	}
 	
	@Override
	public String getTotDonUsr(String idUsuario) {
		// TODO Auto-generated method stub
	 	ServiciosDonacionRemote fachadaDat = lczFachada();
	 	
	 	String totalDon = "";

		List<Donacion> donacionDt = fachadaDat.findDonacionByUsrId(Integer.parseInt(idUsuario));

		int cont = 0;
		if (donacionDt.size() > 0) {
			for (Donacion donacion : donacionDt) {
				if (donacion.getEstado().equals("Finalizado")) {
					cont += 1;
				}

			}
			
			totalDon = String.valueOf(cont);
		}

		return totalDon;
	}

 	// METODO PARA AGREGAR DONACION, RETORNA MSN DE CONFIRMACION SI SE AGREGO O NO
 	// FUNCIONA
 	@Override
 	public String addDonacion(HashMap<String, String> donacion) {

 		// TODO Auto-generated method stub
 		ServiciosDonacionRemote fachadaDat = lczFachada();

 		Donacion tstDona = new Donacion();

 		tstDona = formatDonacionAdd(donacion);
 		
 		System.out.println(tstDona.getSector());
 	
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
 	// METODO PARA ACTUALIZAR DONACION, RETORNA MSN DE CONFIRMACION SI SE AGREGO O NO
 	// FUNCIONA
 	@Override
 	public String updDonacion(String id, String estado) {

 		// TODO Auto-generated method stub
 		ServiciosDonacionRemote fachadaDat = lczFachada();

 		List<Donacion> tstDona = new ArrayList<Donacion>();
 		Donacion donaAct = new Donacion();
 		
 	
 		try {
 			tstDona = fachadaDat.findDonacionById(Integer.parseInt(id));
 			
 			for (Donacion donacion : tstDona) {
				donaAct.setDireccionDon(donacion.getDireccionDon());
				donaAct.setEstado(estado);
				donaAct.setFechaDon(donacion.getFechaDon());
				donaAct.setFundacionId(donacion.getFundacionId());
				donaAct.setIdDonacion(donacion.getIdDonacion());
				donaAct.setIdDonaFire(donacion.getIdDonaFire());
				donaAct.setNombreDon(donacion.getNombreDon());
				donaAct.setTelDon(donacion.getTelDon());
				donaAct.setUsuarioId(donacion.getUsuarioId());
				
			}
 			String resultado = fachadaDat.updDonacion(donaAct);

 			if (resultado.equals("Donacion actualizada")) {
 				
 				return "Donacion actualizada";
 			}

 		} catch (Exception e) {
 			// TODO: handle exception
 			return "No se pudo agregar la actualizar por el error:" + e;

 		}
 		return "Error actualizando donacion";
 	}


 	
	public Donacion formatDonacionAdd(HashMap<String, String> dona) {

		Donacion donacion = new Donacion();
		donacion.setIdDonacion(getId());
		donacion.setFundacionId(getIdFundacion());
		
		if (String.valueOf(donacion.getFundacionId())!=null) {
			donacion.setEstado("Activa");
		}

		for (Entry<String, String> entry : dona.entrySet()) {
			switch (entry.getKey()) {
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
			case "idFire": {
				if (entry.getValue() != "") {
					donacion.setIdDonaFire(entry.getValue());

					break;
				}
				break;

			}
			case "lat": {
				if (entry.getValue() != "") {
					donacion.setLatitud(entry.getValue());

					break;
				}
				break;

			}
			case "long": {
				if (entry.getValue() != "") {
					donacion.setLongitud(entry.getValue());

					break;
				}
				break;

			}
			case "sector": {
				if (entry.getValue() != "") {
					donacion.setSector(entry.getValue());

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
	
	@Override
	public String getActiveDonFun(String idFundacion) {
		// TODO Auto-generated method stub
 		ServiciosDonacionRemote fachadaDat = lczFachada();
 		int cont = 0;

 		List<Donacion> tstDona = new ArrayList<Donacion>();
 		
 	
 			tstDona = fachadaDat.findDonacionByFundacionId(Integer.parseInt(idFundacion));
 			
 			for (Donacion donacion : tstDona) {
				if (donacion.getEstado().equals("Activa")) {
					cont += 1;
				}
			}


 		return String.valueOf(cont);
	}
	
	// FUNCIONES AUXILIARES
	public int getId() {
		ServiciosDonacionRemote fachadaDat = lczFachada();
		int id = fachadaDat.getId();

		return id;

	}
	
	//Funcion para asignar la fundacion 
	//Falta la geolocalizacion
	public int getIdFundacion() {
		ServiciosUsuarioRemote fachadaDat = lczFachadaUsr();
		List<TipoUsuario>tipoUsuario = fachadaDat.findTipoUsuarioEmp();
		
		if (tipoUsuario.size()!=0) {
			for (TipoUsuario tipoUsr : tipoUsuario) {
				
				return tipoUsr.getIdTipoUsuario();
				
			}
			
		}


		return 0;

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
 	
 	public ServiciosUsuarioRemote lczFachadaUsr() {

		LocalizadorServicios Lcz = new LocalizadorServicios();
		ServiciosUsuarioRemote fachadaDato = null;

		try {
			fachadaDato = Lcz.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fachadaDato;

	}


}
