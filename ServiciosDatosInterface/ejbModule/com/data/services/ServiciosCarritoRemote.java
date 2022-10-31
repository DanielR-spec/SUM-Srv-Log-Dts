package com.data.services;

import java.util.List;

import javax.ejb.Remote;

import com.model.ent.Carrito;

@Remote
public interface ServiciosCarritoRemote {

	public List<Carrito> findCarrtioById(int id);

	public String addCarrito(Carrito carr);

	public int getId();

}
