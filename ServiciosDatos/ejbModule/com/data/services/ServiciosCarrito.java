package com.data.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.model.ent.Carrito;


/**
 * Session Bean implementation class ServicionCarrito
 */
@Stateless
@LocalBean
public class ServiciosCarrito implements ServiciosCarritoRemote, ServiciosCarritoLocal {
	
	@PersistenceContext(unitName = "Entidades", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ServiciosCarrito() {
        // TODO Auto-generated constructor stub
    }
    
 	// BUSCAR CARRITO POR ID, RETORNA LA LISTA DE CARRITOS ENCONTRADOS
 	// READ Funciona
 	@Override
 	public List<Carrito> findCarrtioById(int id) {
 		// TODO Auto-generated method stub
 		String consulta = "SELECT e FROM Carrito e WHERE  e.idCarrito = :idCarrito";
 		TypedQuery<Carrito> query = entityManager.createQuery(consulta, Carrito.class);
 		query.setParameter("idCarrito", id);
 		query.setMaxResults(1);
 		List<Carrito> resultList = query.getResultList();

 		if (resultList.size() == 0) {
 			return null;
 		}
 		return resultList;

 	}

 	// AGREGAR PRENDA, AGREGA UN PRENDA NUEVO RETORNA LA LISTA DE PRENDAS
 	// ENCONTRADOS, LA LOGICA DEL id SE HACE EN LA LOGICA
 	// CREATE Funciona
 	@Override
 	public String addCarrito(Carrito carr) {
 		// TODO Auto-generated method stub
 		Carrito carrito = entityManager.find(Carrito.class, carr.getIdCarrito());
 		if (carrito == null) {
 			entityManager.persist(carr);
 			return "Carrito insertado";
 		} else
 			return "Carrito existe";

 	}
 	
 	// TRAER ID, RETORNA EL ULTIMO ID DE LA BD
 	// READ Funciona
 	@Override
 	public int getId() {
 		// TODO Auto-generated method stub
 		String consulta = "SELECT p FROM Carrito p";
 		TypedQuery<Carrito> query = entityManager.createQuery(consulta, Carrito.class);
 		List<Carrito> resultList = query.getResultList();

 		return resultList.size();
 	}

}
