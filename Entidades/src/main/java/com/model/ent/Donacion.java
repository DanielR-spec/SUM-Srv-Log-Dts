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
	private String estado;
	private String fechaDon;
	private int fundacionId;
	private String idDonaFire;
	private String latitud;
	private String longitud;
	private String nombreDon;
	private String sector;
	private String telDon;
	private int usuarioId;

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


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Column(name="fecha_don")
	public String getFechaDon() {
		return this.fechaDon;
	}

	public void setFechaDon(String fechaDon) {
		this.fechaDon = fechaDon;
	}


	@Column(name="fundacion_id")
	public int getFundacionId() {
		return this.fundacionId;
	}

	public void setFundacionId(int fundacionId) {
		this.fundacionId = fundacionId;
	}


	@Column(name="id_dona_fire")
	public String getIdDonaFire() {
		return this.idDonaFire;
	}

	public void setIdDonaFire(String idDonaFire) {
		this.idDonaFire = idDonaFire;
	}


	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	@Column(name="nombre_don")
	public String getNombreDon() {
		return this.nombreDon;
	}

	public void setNombreDon(String nombreDon) {
		this.nombreDon = nombreDon;
	}


	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}


	@Column(name="tel_don")
	public String getTelDon() {
		return this.telDon;
	}

	public void setTelDon(String telDon) {
		this.telDon = telDon;
	}


	@Column(name="usuario_id")
	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

}