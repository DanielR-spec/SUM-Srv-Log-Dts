package com.conexion.rst;

public class PrendaFB {

	private String nombre;
	private String uriKey;
	
	public PrendaFB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param uriKey
	 */
	public PrendaFB(String nombre, String uriKey) {
		super();
		this.nombre = nombre;
		this.uriKey = uriKey;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the uriKey
	 */
	public String getUriKey() {
		return uriKey;
	}
	
	
}
