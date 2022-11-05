package com.data.services;

import java.util.List;

import javax.ejb.Remote;

import com.model.ent.Donacion;

@Remote
public interface ServiciosDonacionRemote {

	public List<Donacion> findDonacionById(int id);

	public String addDonacion(Donacion dona);
	
	public int getId();

	public List<Donacion> findDonacionByFundacionId(int id);

	public String updDonacion(Donacion tstDona);

}
