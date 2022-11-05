package com.model.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prenda database table.
 * 
 */
@Entity
@NamedQuery(name="Prenda.findAll", query="SELECT p FROM Prenda p")
public class Prenda implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPrenda;
	private String fechaAgregacion;
	private String idFire;
	private int idUsuario;
	private String imageUrl;

	public Prenda() {
	}


	@Id
	@Column(name="id_prenda")
	public int getIdPrenda() {
		return this.idPrenda;
	}

	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}


	@Column(name="fecha_agregacion")
	public String getFechaAgregacion() {
		return this.fechaAgregacion;
	}

	public void setFechaAgregacion(String fechaAgregacion) {
		this.fechaAgregacion = fechaAgregacion;
	}


	@Column(name="id_fire")
	public String getIdFire() {
		return this.idFire;
	}

	public void setIdFire(String idFire) {
		this.idFire = idFire;
	}


	@Column(name="id_usuario")
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	@Column(name="image_url")
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}