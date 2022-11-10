package com.logic.services;

import java.util.HashMap;

import javax.ejb.Remote;

@Remote
public interface ServiciosLogicaPrendaRemote {

	public boolean tst();

	public String delPrenda(HashMap<String, String> prenda);

	public String updPrenda(HashMap<String, String> prenda);

	public String addPrenda(HashMap<String, String> prenda);

	public HashMap<String, String> getPrendaById(String id);

	public String delPrendaById(String i);

	public String getIdPrenda(String id);

	public HashMap<String, String> getCatPrendaById(String id);

	public HashMap<String, String> getPrendaByIdFire(String idFire);

	public String getIdPrendaByIdFire(String idFire);

	public HashMap<String, String> getCatPrendaByIdStats(String id);
	

}
