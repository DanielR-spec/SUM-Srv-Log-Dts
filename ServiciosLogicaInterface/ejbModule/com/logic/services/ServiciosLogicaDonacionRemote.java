package com.logic.services;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ServiciosLogicaDonacionRemote {

	public HashMap<String, String> getDonacionById(String id);

	public String addDonacion(HashMap<String, String> donacion);

	public HashMap<String, List<List<String>>> getDonacionByFundacionId(String id);

	public String updDonacion(String id, String estado);

	public HashMap<String, String> getDonacionByIdUsr(String idUsuario);

	public HashMap<String, String> getCatTonFun(String idFun);
	
	public HashMap<String,List<String>> getUbiDonacionByFundacionId(String id);

	public HashMap<String, String> getDonacionByIdUsrSat(String idUsuario);

	public String getTotDonUsr(String idUsuario);

	public String getActiveDonFun(String idFundacion);


}
