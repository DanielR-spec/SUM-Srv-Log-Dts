package com.model.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the categoria_prenda database table.
 * 
 */
@Entity
@Table(name="categoria_prenda")
@NamedQuery(name="CategoriaPrenda.findAll", query="SELECT c FROM CategoriaPrenda c")
public class CategoriaPrenda implements Serializable {
	private static final long serialVersionUID = 1L;
	private String genero;
	private int idCategoriaPrenda;
	private String tipo;

	public CategoriaPrenda() {
	}


	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Id
	@Column(name="id_categoria_prenda")
	public int getIdCategoriaPrenda() {
		return this.idCategoriaPrenda;
	}

	public void setIdCategoriaPrenda(int idCategoriaPrenda) {
		this.idCategoriaPrenda = idCategoriaPrenda;
	}


	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}