package com.logic.services;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import com.model.ent.Donacion;

@Remote
public interface ServiciosLogicaDonacionRemote {

	public HashMap<String, String> getDonacionById(String id);

	public String addDonacion(HashMap<String, String> donacion);

	public HashMap<String, List<List<String>>> getDonacionByFundacionId(String id);

	public String updDonacion(String id, String estado);


}
