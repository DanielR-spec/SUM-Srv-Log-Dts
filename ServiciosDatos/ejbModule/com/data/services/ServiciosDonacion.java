package com.data.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.model.ent.Donacion;
import com.model.ent.Prenda;

/**
 * Session Bean implementation class ServicionDonacion
 */
@Stateless
@LocalBean
public class ServiciosDonacion implements ServiciosDonacionRemote, ServiciosDonacionLocal {
	
	@PersistenceContext(unitName = "Entidades", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ServiciosDonacion() {
        // TODO Auto-generated constructor stub
    }
    
 	// BUSCAR PRENDA POR ID, RETORNA LA LISTA DE PRENDAS ENCONTRADOS
 	// READ Funciona
 	@Override
 	public List<Donacion> findDonacionById(int id) {
 		// TODO Auto-generated method stub
 		String consulta = "SELECT e FROM Donacion e WHERE  e.idDonacion = :idDonacion";
 		TypedQuery<Donacion> query = entityManager.createQuery(consulta, Donacion.class);
 		query.setParameter("idPrenda", id);
 		query.setMaxResults(1);
 		List<Donacion> resultList = query.getResultList();

 		if (resultList.size() == 0) {
 			return null;
 		}
 		return resultList;

 	}

 	// AGREGAR PRENDA, AGREGA UN PRENDA NUEVO RETORNA LA LISTA DE PRENDAS
 	// ENCONTRADOS, LA LOGICA DEL id SE HACE EN LA LOGICA
 	// CREATE Funciona
 	@Override
 	public String addDonacion(Donacion dona) {
 		// TODO Auto-generated method stub
 		Donacion donacion = entityManager.find(Donacion.class, dona.getIdDonacion());
 		if (donacion == null) {
 			entityManager.persist(dona);
 			return "Donacion insertada";
 		} else
 			return "Donacion existe";

 	}
 	
 	// TRAER ID, RETORNA EL ULTIMO ID DE LA BD
 	// READ Funciona
 	@Override
 	public int getId() {
 		// TODO Auto-generated method stub
 		String consulta = "SELECT p FROM Donacion p";
 		TypedQuery<Donacion> query = entityManager.createQuery(consulta, Donacion.class);
 		List<Donacion> resultList = query.getResultList();

 		return resultList.size();
 	}
 	

}
