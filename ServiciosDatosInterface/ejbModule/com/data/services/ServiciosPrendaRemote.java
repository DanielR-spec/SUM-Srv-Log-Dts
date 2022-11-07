package com.data.services;

import java.util.List;

import javax.ejb.Remote;

import com.model.ent.CategoriaPrenda;
import com.model.ent.Prenda;
import com.model.ent.TipoUsuario;
import com.model.ent.Usuario;

@Remote
public interface ServiciosPrendaRemote {

	public String addPrenda(Prenda prnd);

	public List<Prenda> findPrendaById(int id);

	public String addPrendaCategoria(CategoriaPrenda categoria);

	public List<Prenda> getAllPrendas();

	public String delPrenda(Prenda prnd);

	public String delCategoriaPrenda(int id);

	public String updatePrenda(Prenda prnd);

	public int getId();

	public String updateCatPrenda(CategoriaPrenda catPrnd);

	public int getIdCat();

	public List<Prenda> getPrendaByIdFire(String idFire);

	public List<CategoriaPrenda> getCategoriaPrenda(int idPrenda);
	
	

}
