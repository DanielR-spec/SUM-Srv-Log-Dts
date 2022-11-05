package com.model.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String apellidos;
	private String cell;
	private String clave;
	private String correo;
	private String direccion;
	private String doc;
	private String nombres;
	private TipoUsuario tipoUsuario;
	private UbicacionUsuario ubicacionUsuario;

	public Usuario() {
	}


	@Id
	@Column(name="id_usuario")
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCell() {
		return this.cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}


	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDoc() {
		return this.doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}


	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	//bi-directional one-to-one association to TipoUsuario
	@OneToOne(mappedBy="usuario")
	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


}