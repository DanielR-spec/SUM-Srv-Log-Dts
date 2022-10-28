package com.model.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the donacion database table.
 * 
 */
@Entity
@NamedQuery(name="Donacion.findAll", query="SELECT d FROM Donacion d")
public class Donacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDonacion;
	private String direccionDon;
	private String fechaDon;
	private String nombreDon;
	private String telDon;
	private Usuario fundacion;
	private Usuario usuario;

	public Donacion() {
	}


	@Id
	@Column(name="id_donacion")
	public int getIdDonacion() {
		return this.idDonacion;
	}

	public void setIdDonacion(int idDonacion) {
		this.idDonacion = idDonacion;
	}


	@Column(name="direccion_don")
	public String getDireccionDon() {
		return this.direccionDon;
	}

	public void setDireccionDon(String direccionDon) {
		this.direccionDon = direccionDon;
	}


	@Column(name="fecha_don")
	public String getFechaDon() {
		return this.fechaDon;
	}

	public void setFechaDon(String fechaDon) {
		this.fechaDon = fechaDon;
	}


	@Column(name="nombre_don")
	public String getNombreDon() {
		return this.nombreDon;
	}

	public void setNombreDon(String nombreDon) {
		this.nombreDon = nombreDon;
	}


	@Column(name="tel_don")
	public String getTelDon() {
		return this.telDon;
	}

	public void setTelDon(String telDon) {
		this.telDon = telDon;
	}


	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="fundacion_id")
	public Usuario getFundacion() {
		return this.fundacion;
	}

	public void setFundacion(Usuario fundacionPar) {
		this.fundacion = fundacionPar;
	}
	
	//bi-directional one-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="usuario_id")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}