package com.data.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.model.ent.CategoriaPrenda;
import com.model.ent.Prenda;
import com.model.ent.TipoUsuario;
import com.model.ent.Usuario;

/**
 * Session Bean implementation class ServiciosPrenda
 */
@Stateless
@LocalBean
public class ServiciosPrenda implements ServiciosPrendaRemote, ServiciosPrendaLocal {
	
	@PersistenceContext(unitName = "Entidades", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ServiciosPrenda() {
        // TODO Auto-generated constructor stub
    }
    

 	// BUSCAR PRENDA POR ID, RETORNA LA LISTA DE PRENDAS ENCONTRADOS
 	// READ Funciona
 	@Override
 	public List<Prenda> findPrendaById(int id) {
 		// TODO Auto-generated method stub
 		String consulta = "SELECT e FROM Prenda e WHERE  e.idPrenda = :idPrenda";
 		TypedQuery<Prenda> query = entityManager.createQuery(consulta, Prenda.class);
 		query.setParameter("idPrenda", id);
 		query.setMaxResults(1);
 		List<Prenda> resultList = query.getResultList();

 		if (resultList.size() == 0) {
 			return null;
 		}
 		return resultList;

 	}

 	// AGREGAR PRENDA, AGREGA UN PRENDA NUEVO RETORNA LA LISTA DE PRENDAS
 	// ENCONTRADOS, LA LOGICA DEL id SE HACE EN LA LOGICA
 	// CREATE Funciona
 	@Override
 	public String addPrenda(Prenda prnd) {
 		// TODO Auto-generated method stub
 		Prenda prenda = entityManager.find(Prenda.class, prnd.getIdPrenda());
 		if (prenda == null) {
 			entityManager.persist(prnd);
 			return "Prenda insertada";
 		} else
 			return "Prenda existe";

 	}

 	// AGREGAR CATEGORIA DE PRENDA, AGREGA UN NUEVO CATEGORIA DE PRENDA
 	// NO RETORNA VOID SOLO PRESISTE
 	// CREATE Funciona
 	@Override
 	public String addPrendaCategoria(CategoriaPrenda categoria) {
 		// TODO Auto-generated method stub
 		CategoriaPrenda categoriaPrenda = entityManager.find(CategoriaPrenda.class, categoria.getIdCategoriaPrenda());
 		if (categoriaPrenda == null) {
 			entityManager.persist(categoria);
 			entityManager.flush();
 			return "Exito";
 		}
 		
 		return "Fallo";

 	}

 	// TRAER PRENDAS, RETORNA LA LISTA DE TODOS LOS PRENDAS ENCONTRADOS
 	// READ Funciona
 	@Override
 	public List<Prenda> getAllPrendas() {
 		// TODO Auto-generated method stub
 		String consulta = "SELECT p FROM Prenda p";
 		TypedQuery<Prenda> query = entityManager.createQuery(consulta, Prenda.class);
 		List<Prenda> resultList = query.getResultList();
 		if (resultList.size() == 0) {
 			return null;
 		}
 		return resultList;
 	}

 	// ELIMINAR PRENDA, ELIMINA EL PRENDA, PENSAR EN LA LOGICA DE ID
 	// DELETE Funciona
 	@Override
 	public String delPrenda(Prenda prnd) {
 		// TODO Auto-generated method stub

 		Prenda prenda = entityManager.find(Prenda.class, prnd.getIdPrenda());

 		if (prenda == null) {
 			return "No existe";
 		} else {
 			entityManager.remove(entityManager.contains(prenda) ? prenda : entityManager.merge(prenda));
 			return "Prenda eliminada correctamente";
 		}

 	}


 	// ELIMINAR CATEGORIA DE PRENDA, ELIMINA EL CATEGORIA DE PRENDA
 	// DELETE Funciona
 	@Override
 	public String delCategoriaPrenda(int id) {
 		// TODO Auto-generated method stub

 		CategoriaPrenda catPrend = entityManager.find(CategoriaPrenda.class, id);
 		if (catPrend.equals(null)) {
 			return "Categoria no existe";
 		} else {
 			entityManager.remove(catPrend);
 			return "Categoria eliminada";
 		}

 	}

 	// ACTUALIZAR PRENDAS, ACTUALIZA LA INFORMACION DE LOS PRENDAS
 	// UPDATE Funciona
 	@Override
 	public String updatePrenda(Prenda prnd) {
 		// TODO Auto-generated method stub
 		Prenda prenda = null;
 		prenda = entityManager.find(Prenda.class, prnd.getIdPrenda());
 		if (prenda == null) {
 			return "No existe prenda";
 		} else {
 			entityManager.merge(prnd);
 			entityManager.flush();
 			return "prenda actualizada";
 		}

 	}
 	
 	// ACTUALIZAR CATEGORIA PRENDAS, ACTUALIZA LA INFORMACION DE LOS PRENDAS
 	// UPDATE Funciona
 	@Override
 	public String updateCatPrenda(CategoriaPrenda catPrnd) {
 		// TODO Auto-generated method stub
 		CategoriaPrenda prenda = null;
 		prenda = entityManager.find(CategoriaPrenda.class, catPrnd.getIdCategoriaPrenda());
 		if (prenda == null) {
 			return "No existe categoria";
 		} else {
 			entityManager.merge(catPrnd);
 			entityManager.flush();
 			return "categoria actualizada";
 		}

 	}

 	// TRAER ID, RETORNA EL ULTIMO ID DE LA BD
 	// READ Funciona
 	@Override
 	public int getId() {
 		// TODO Auto-generated method stub
 		String consulta = "SELECT p FROM Prenda p";
 		TypedQuery<Prenda> query = entityManager.createQuery(consulta, Prenda.class);
 		List<Prenda> resultList = query.getResultList();

 		return resultList.size();
 	}
 	
 	// TRAER ID, RETORNA EL ULTIMO ID DE LA BD
 	// READ Funciona
 	@Override
 	public int getIdCat() {
 		// TODO Auto-generated method stub
 		String consulta = "SELECT p FROM CategoriaPrenda p";
 		TypedQuery<CategoriaPrenda> query = entityManager.createQuery(consulta, CategoriaPrenda.class);
 		List<CategoriaPrenda> resultList = query.getResultList();

 		return resultList.size();
 	}

}
