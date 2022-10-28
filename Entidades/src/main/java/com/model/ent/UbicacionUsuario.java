package com.model.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubicacion_usuario database table.
 * 
 */
@Entity
@Table(name="ubicacion_usuario")
@NamedQuery(name="UbicacionUsuario.findAll", query="SELECT u FROM UbicacionUsuario u")
public class UbicacionUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUbicacionUsuario;
	private String ciudad;
	private String pais;
	private Usuario usuario;

	public UbicacionUsuario() {
	}


	@Id
	@Column(name="id_ubicacion_usuario")
	public int getIdUbicacionUsuario() {
		return this.idUbicacionUsuario;
	}

	public void setIdUbicacionUsuario(int idUbicacionUsuario) {
		this.idUbicacionUsuario = idUbicacionUsuario;
	}


	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="id_ubicacion_usuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}