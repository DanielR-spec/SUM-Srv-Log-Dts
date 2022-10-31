package com.logic.services;

import java.util.HashMap;

import javax.ejb.Remote;

@Remote
public interface ServiciosLogicaCarritoRemote {

	public HashMap<String, String> getCarritoById(String id);

	public String addCarrito(HashMap<String, String> carrito);

}
