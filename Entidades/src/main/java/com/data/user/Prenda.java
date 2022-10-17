package com.data.user;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prenda database table.
 * 
 */
@Entity
@Table(name="prenda")
@NamedQuery(name="Prenda.findAll", query="SELECT p FROM Prenda p")
public class Prenda implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPrenda;
	private String rutaImg;
	private int userId;

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


	@Column(name="ruta_img")
	public String getRutaImg() {
		return this.rutaImg;
	}

	public void setRutaImg(String rutaImg) {
		this.rutaImg = rutaImg;
	}


	@Column(name="user_id")
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}