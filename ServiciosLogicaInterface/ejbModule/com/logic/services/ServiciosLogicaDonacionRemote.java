package com.logic.services;

import java.util.HashMap;

import javax.ejb.Remote;

@Remote
public interface ServiciosLogicaDonacionRemote {

	public HashMap<String, String> getDonacionById(String id);

	public String addDonacion(HashMap<String, String> donacion);

}
