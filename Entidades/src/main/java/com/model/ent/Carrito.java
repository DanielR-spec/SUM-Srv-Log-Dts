package com.model.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carrito database table.
 * 
 */
@Entity
@NamedQuery(name="Carrito.findAll", query="SELECT c FROM Carrito c")
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCarrito;
	private String idCarrFire;
	private String idPrenda;
	private int idUsuario;

	public Carrito() {
	}


	@Id
	@Column(name="id_carrito")
	public int getIdCarrito() {
		return this.idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}


	@Column(name="id_carr_fire")
	public String getIdCarrFire() {
		return this.idCarrFire;
	}

	public void setIdCarrFire(String idCarrFire) {
		this.idCarrFire = idCarrFire;
	}


	@Column(name="id_prenda")
	public String getIdPrenda() {
		return this.idPrenda;
	}

	public void setIdPrenda(String idPrenda) {
		this.idPrenda = idPrenda;
	}


	@Column(name="id_usuario")
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}