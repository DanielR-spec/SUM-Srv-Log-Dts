package com.conexion.rst;

public class CartFB {

	private String idFire;
	private String idUsuario;
	private String imgUrl;

	
	public CartFB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idFire
	 * @param idUsuario
	 * @param imgUrl
	 */
	public CartFB(String idFire, String idUsuario, String imgUrl) {
		super();
		this.idFire = idFire;
		this.idUsuario = idUsuario;
		this.imgUrl = imgUrl;
	}

	/**
	 * @return the idFire
	 */
	public String getIdFire() {
		return idFire;
	}

	/**
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * @param idFire the idFire to set
	 */
	public void setIdFire(String idFire) {
		this.idFire = idFire;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	

	
	
}
